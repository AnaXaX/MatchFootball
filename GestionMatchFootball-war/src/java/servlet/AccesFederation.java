package servlet;

import entities.Entraineur;
import entities.Equipe;
import entities.MatchFoot;
import java.io.IOException;
import java.sql.Timestamp;
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
    

    public final String ATT_SESSION_FEDERATION = "sessionFederation";

    public final String ERREUR_CHAMP = "Un des champs n'est pas rempli";

    private String jspClient;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        //String jspClient = null;
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
            if (request.getParameter("nom").trim().isEmpty() || request.getParameter("prenom").trim().isEmpty() || request.getParameter("login").trim().isEmpty() || request.getParameter("mdp").trim().isEmpty()) {
                request.setAttribute("msgError", ERREUR_CHAMP);
                jspClient = "/federation/CreerEntraineur.jsp";
            } else {
                sessionFederation.creerEntraineur(request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("login"), request.getParameter("mdp"));
                jspClient = "/federation/Menu.jsp";
            }
        }

        /*Création Arbitre*/
        if (act.equals("creerArbitre")) {
            if (request.getParameter("nom").trim().isEmpty() || request.getParameter("prenom").trim().isEmpty() || request.getParameter("login").trim().isEmpty() || request.getParameter("mdp").trim().isEmpty()) {
                request.setAttribute("msgError", ERREUR_CHAMP);
                jspClient = "/federation/CreerArbitre.jsp";
            } else {
                sessionFederation.creerArbitre(request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("login"), request.getParameter("mdp"));
                jspClient = "/federation/Menu.jsp";
            }
        }

        /*Création Joueur*/
        if (act.equals("creerJoueur")) {
            if (request.getParameter("nom").trim().isEmpty() || request.getParameter("prenom").trim().isEmpty()) {
                jspClient = "/federation/CreerJoueur.jsp";
                request.setAttribute("listEquipes", sessionFederation.listEquipes());
                request.setAttribute("msgError", ERREUR_CHAMP);
            } else {
                sessionFederation.creerJoueur(request.getParameter("nom"), request.getParameter("prenom"));
                jspClient = "/federation/Menu.jsp";
            }
            jspClient = "/federation/Menu.jsp";
        }

        /*Création Équipe*/
 /*Choix entraineur pour l'équipe, donc affichage des entraineurs*/
        if (act.equals("afficherEntraineur")) {
            request.setAttribute("listEntraineurs", sessionFederation.listEntraineur());
            jspClient = "/federation/CreerEquipe.jsp";

        }

        if (act.equals("creerEquipe")) {
            if (request.getParameter("nom").trim().isEmpty() || request.getParameter("entraineurID") == null || request.getParameter("entraineurID").isEmpty()) {
                request.setAttribute("listEntraineurs", sessionFederation.listEntraineur());
                request.setAttribute("msgError", ERREUR_CHAMP);
                jspClient = "/federation/CreerEquipe.jsp";
            } else {
                sessionFederation.creerEquipe(request.getParameter("nom"), sessionFederation.rechercheEntraineur(Long.parseLong(request.getParameter("entraineurID"))));
                // Forcer la reconnexion pour l'entraineur déjà connecté une fois on l'a affecté pour actualiser sa page menu
                //if (session.getAttribute(AccesEntraineur.ATT_SESSION_ENTRAINEUR).equals(e)) 
                session.setAttribute(AccesEntraineur.ATT_SESSION_ENTRAINEUR, null);
                jspClient = "/federation/Menu.jsp";
            }
        }
        /*Création Match*/
 /*Choix arbitre et équipes*/
        if (act.equals("afficherCreerMatch")) {
            afficherCreerMatch(request, response);
        }
        
        if(act.equals("modifierMatch")){
            MatchFoot m = sessionFederation.rechercheMatchId(Long.parseLong(request.getParameter("idMatch")));
            request.setAttribute("matchAModifier", sessionFederation.rechercheMatchId(Long.parseLong(request.getParameter("idMatch"))));
            jspClient = "/federation/ModifierMatch.jsp";
        }
        
        if(act.equals("matchAModifier")){
            request.setAttribute("listMatchs", sessionFederation.listMatchs());
            jspClient = "/federation/ChoixMatchs.jsp";
        }
        if(act.equals("doModifierMatch")){
            String date = request.getParameter("dateMatch");
            String match = request.getParameter("match");
            if (date == null || date.trim().isEmpty() || match == null || match.trim().isEmpty()  ) {
                request.setAttribute("msgError", ERREUR_CHAMP);
                request.setAttribute("listMatchs", sessionFederation.listMatchs());
                jspClient = "/federation/ChoixMatchs.jsp";
            } else {
                sessionFederation.modifierMatch(Timestamp.valueOf(date), sessionFederation.rechercheMatchId(Long.parseLong(match)));
                jspClient = "/federation/Menu.jsp";
            }

            
            request.setAttribute("listMatchs", sessionFederation.listMatchs());
            jspClient = "/federation/ChoixMatchs.jsp";
        }
        
        

        if (act.equals("creerMatch")) {
            String arbitre = request.getParameter("arbitreID");
            String equipeR = request.getParameter("equipeReceveuse");
            String equipeI = request.getParameter("equipeInvitee");
            String date = request.getParameter("dateMatch");

            if (arbitre == null || equipeR == null || equipeI == null || date == null || arbitre.isEmpty() || equipeR.isEmpty() || equipeI.isEmpty() || date.trim().isEmpty()) {
                request.setAttribute("msgError", ERREUR_CHAMP);
                afficherCreerMatch(request, response);
            } else {
                sessionFederation.creerMatch(Timestamp.valueOf(date), Long.parseLong(equipeR), Long.parseLong(equipeI), Long.parseLong(arbitre));
                jspClient = "/federation/Menu.jsp";
            }
        }

        if (act.equals("modifierEquipe")) {
            if (request.getParameter("nom") != null || request.getParameter("entraineurID") != null || request.getParameter("idEquipe") != null) {
                sessionFederation.modifierEquipe(Long.parseLong(request.getParameter("idEquipe")), request.getParameter("nom"), Long.parseLong(request.getParameter("entraineurID")));
                jspClient = "/federation/Menu.jsp";
            } else {
                request.setAttribute("equipe", sessionFederation.rechercheEquipe(Long.parseLong(request.getParameter("idEquipe"))));
                request.setAttribute("listEntraineurs", sessionFederation.listEntraineur());
                jspClient = "/federation/ModifierEquipe.jsp";
            }
        }
        if (act.equals("afficherEquipeModifier")) {
            if (request.getParameter("idEquipe") == null) {
                request.setAttribute("listEquipes", sessionFederation.listEquipes());
                jspClient = "/federation/ChoixEquipeModifier.jsp";
            } else {
                request.setAttribute("equipe", sessionFederation.rechercheEquipe(Long.parseLong(request.getParameter("idEquipe"))));
                request.setAttribute("listEntraineurs", sessionFederation.listEntraineur());
                jspClient = "/federation/ModifierEquipe.jsp";
            }
        }

        if (act.equals("afficherEquipesModif")) {
            request.setAttribute("listEquipes", sessionFederation.listEquipes());
            jspClient = "/federation/ChoixEquipeModifier.jsp";
        }

        /*
        if (act.equals("supprimerEquipes")) {
            if (request.getParameterValues("idEquipes") != null) {
                String[] equipesId = request.getParameterValues("idEquipes");
                for (String j : equipesId) {
                    sessionFederation.supprimerEquipe(Long.parseLong(j));
                }
                jspClient = "/federation/Menu.jsp";
            }else{
                request.setAttribute("listEquipes", sessionFederation.listEquipes());
                jspClient = "/federation/ChoixEquipeSupprimer.jsp";
            }

        }
        if (act.equals("afficherEquipesSupp")) {
            request.setAttribute("listEquipes", sessionFederation.listEquipes());
            jspClient = "/federation/ChoixEquipeSupprimer.jsp";
        }
        */

        RequestDispatcher rd = getServletContext().getRequestDispatcher(jspClient);
        rd.forward(request, response);

    }

    protected void afficherCreerMatch(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("listEquipes", sessionFederation.listEquipes());
        request.setAttribute("listArbitres", sessionFederation.listArbitres());
        jspClient = "/federation/CreerMatch.jsp";
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
