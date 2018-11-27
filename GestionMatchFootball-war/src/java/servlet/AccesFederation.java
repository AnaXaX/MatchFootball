package servlet;

import entities.Entraineur;
import entities.Equipe;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessions.SessionFederationLocal;

/**
 *
 * @author Anas
 */
@WebServlet(name = "AccesFederation", urlPatterns = {"/AccesFederation"})
public class AccesFederation extends HttpServlet {

    @EJB
    private SessionFederationLocal sessionFederation;

    public static final String ATT_SESSION_FEDERATION = "sessionFederation";
    
    public static final String ERREUR_CHAMP = "Un des champs n'est pas rempli";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String jspClient = null;
        HttpSession session = request.getSession();
        String act = request.getParameter("action");
 
        /*Control Connexion*/
        if (act.equals("authentification")) {
            String mdpFederation = request.getParameter("mdpFederation");
            if (sessionFederation.authentification(mdpFederation)) {
                jspClient = "/federation/Menu.jsp";
                session.setAttribute(ATT_SESSION_FEDERATION, mdpFederation);//Attribuer le Token
            } else {
                jspClient = "/federation/Connexion.jsp";
                request.setAttribute("msgError", "Wrong password");
            }
        }

        /*Control Deconnexion*/
        if (act.equals("deconnexion")) {
            session.setAttribute(ATT_SESSION_FEDERATION, null); //Enlever le Token
            jspClient = "/Menu.jsp";
        }
        
    /*Federation Menu Possibilités*/
        /*Création Entraineur*/
        if (act.equals("creerEntraineur")) {
            if(request.getParameter("nom").trim().isEmpty() || request.getParameter("prenom").trim().isEmpty() || request.getParameter("login").trim().isEmpty() || request.getParameter("mdp").trim().isEmpty()){
                jspClient = "/federation/CreerEntraineur.jsp";
                request.setAttribute("msgError", ERREUR_CHAMP);
            }else{
                sessionFederation.creerEntraineur(request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("login"), request.getParameter("mdp"));
                jspClient = "/federation/Menu.jsp";
            }
        }
        
           /*Création Arbitre*/        
        if (act.equals("creerArbitre")) {
            if(request.getParameter("nom").trim().isEmpty() || request.getParameter("prenom").trim().isEmpty() || request.getParameter("login").trim().isEmpty() || request.getParameter("mdp").trim().isEmpty()){
                jspClient = "/federation/CreerArbitre.jsp";
                request.setAttribute("msgError", ERREUR_CHAMP);
            }else{
                sessionFederation.creerArbitre(request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("login"), request.getParameter("mdp"));
                jspClient = "/federation/Menu.jsp";
            }
        }
        
        /*Création Joueur*/
            /*Choix équipe pour le joueur, donc affichage des équipes*/
             if (act.equals("afficherEquipe")) {
                jspClient = "/federation/CreerJoueur.jsp";
                List<Equipe> listEquipes = sessionFederation.listEquipes();
                request.setAttribute("listEquipes", listEquipes);
          }
          /*une fois le choix récupérer de la liste des équipes on crée le joueur*/
          if (act.equals("creerJoueur")) {
            if(request.getParameter("nom").trim().isEmpty() || request.getParameter("equipeID").trim().isEmpty()){
                jspClient = "/federation/CreerJoueur.jsp";
                List<Equipe> listEquipes = sessionFederation.listEquipes();
                request.setAttribute("listEquipes", listEquipes);
                request.setAttribute("msgError", ERREUR_CHAMP);
            }else{          
                sessionFederation.creerJoueur(request.getParameter("nom"), request.getParameter("prenom"), sessionFederation.rechercheEquipe(Long.parseLong(request.getParameter("equipeID"))));
                jspClient = "/federation/Menu.jsp";
            }
            jspClient = "/federation/Menu.jsp";
        }        

        
        /*Création Équipe*/
            /*Choix entraineur pour l'équipe, donc affichage des entraineurs*/
          if (act.equals("afficherEntraineur")) {
                jspClient = "/federation/CreerEquipe.jsp";
                List<Entraineur> listEntraineurs = sessionFederation.listEntraineur();
                request.setAttribute("listEntraineurs", listEntraineurs);
          }
          
          if (act.equals("creerEquipe")) {
            if(request.getParameter("nom").trim().isEmpty() || request.getParameter("entraineurID").isEmpty()){
                jspClient = "/federation/CreerEquipe.jsp";
                List<Entraineur> listEntraineurs = sessionFederation.listEntraineur();
                request.setAttribute("listEntraineurs", listEntraineurs);
                request.setAttribute("msgError", ERREUR_CHAMP);
            }else{
                sessionFederation.creerEquipe(request.getParameter("nom"), sessionFederation.rechercheEntraineur(Long.parseLong(request.getParameter("entraineurID"))));
                jspClient = "/federation/Menu.jsp";
            }
            jspClient = "/federation/Menu.jsp";
        }        

        
        if (act == null || act.equals("vide")) {
            jspClient = "/Menu.jsp";
        }
        
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher(jspClient);
        rd.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
