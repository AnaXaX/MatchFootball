/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entities.Equipe;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessions.SessionCommuneLocal;

/**
 *
 * @author Grind-Machine
 */
@WebServlet(name = "AccesCommun", urlPatterns = {"/AccesCommun"})
public class AccesCommun extends HttpServlet {

    @EJB
    private SessionCommuneLocal sessionCommune;

    public final String ERREUR_CHAMP = "Un des champs n'est pas rempli";

    private String jspClient = "/Menu.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String act = request.getParameter("action");

        /*Federation Menu Possibilités*/
 /*Création Entraineur*/
        System.out.println(act);

        if (act.equals("afficherEquipe")) {
            jspClient = "/accueil/ChoixEquipe.jsp";
            Collection<Equipe> listEquipes = sessionCommune.listEquipes();
            request.setAttribute("listEquipes", listEquipes);
        }

        if (act.equals("afficherEquipeMatch")) {
            jspClient = "/accueil/choixEquipeMatch.jsp";
            Collection<Equipe> listEquipes = sessionCommune.listEquipes();
            request.setAttribute("listEquipes", listEquipes);
        }
        if (act.equals("afficherEffectifMatch")) {
            jspClient = "/accueil/ChoixMatchs.jsp";
            List listMatchs = sessionCommune.listMatchs();
            request.setAttribute("listMatchs", listMatchs);
        }
        if (act.equals("afficherMatchsEquipe")) {
            if (request.getParameter("equipeID").trim().isEmpty() || request.getParameter("equipeID").isEmpty()) {
                jspClient = "/accueil/choixEquipeMatch.jsp";
                request.setAttribute("msgError", "Une erreur est produite lors du choix de l'équipe");
            } else {
                Long l = Long.parseLong(request.getParameter("equipeID"));
                Equipe e = sessionCommune.rechercheEquipe(l);
                request.setAttribute("matchsEquipe", e.getHistoriqueMatchs());

                jspClient = "/accueil/AfficherMatchsEquipe.jsp";

            }
        }
        
        if (act.equals("getEffectifMatch")) {
            if (request.getParameter("idMatch").equals(null) || request.getParameter("idMatch").equals("")) {
                jspClient = "/AccesCommun?action=afficherEffectifMatch";
                request.setAttribute("msgError", "Une erreur est produite lors du choix de l'équipe");
            } else {
                Long l = Long.parseLong(request.getParameter("equipeID"));
                Equipe e = sessionCommune.rechercheEquipe(l);
                request.setAttribute("matchsEquipe", e.getHistoriqueMatchs());

                jspClient = "/accueil/AfficherMatchsEquipe.jsp";

            }
        }

        /*System.out.println(e.getNom());
                request.setAttribute("nomEquipe", e.getNom());
         */
        if (act.equals("afficherJoueurs")) {
            if (request.getParameter("equipeID").trim().isEmpty() || request.getParameter("equipeID").isEmpty()) {
                jspClient = "/accueil/ChoixEquipe.jsp";
                request.setAttribute("msgError", "Une erreur est produite lors du choix de l'équipe");
            } else {
                Long l = Long.parseLong(request.getParameter("equipeID"));
                Equipe e = sessionCommune.rechercheEquipe(l);
                if (e.getEntraineur() != null) {
                    request.setAttribute("nomEntraineur", e.getEntraineur().getNom() + " " + e.getEntraineur().getPrenom());
                }
                request.setAttribute("nomEquipe", e.getNom());
                request.setAttribute("listJoueurs", e.getEffectif());

                jspClient = "/accueil/AfficherJoueurs.jsp";

            }

        }

        if (act.equals("afficherClassement")) {
            request.setAttribute("classement", sessionCommune.classement());
            jspClient = "/accueil/Classement.jsp";

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
