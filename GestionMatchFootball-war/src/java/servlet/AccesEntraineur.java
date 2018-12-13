/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entities.Entraineur;
import entities.Equipe;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessions.SessionEntraineurLocal;

/**
 *
 * @author 6170232
 */
@WebServlet(name = "AccesEntraineur", urlPatterns = {"/AccesEntraineur"})
public class AccesEntraineur extends HttpServlet {

    @EJB
    private SessionEntraineurLocal sessionEntraineur;

    public static final String ATT_SESSION_ENTRAINEUR = "sessionEntraineur";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String jspClient = null;
        String act = request.getParameter("action");
        HttpSession session = request.getSession();

        /*Control Connexion*/
        if (act.equals("Connexion")) {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            Entraineur e = sessionEntraineur.authentification(login, password);
            if (e != null) {
                Equipe eq = sessionEntraineur.rechercheEquipeParEntraineur(e);
                session.setAttribute("equipe", eq);
                jspClient = "/entraineur/Menu.jsp";
                session.setAttribute(ATT_SESSION_ENTRAINEUR, e);//Attribuer le Token

            } else {
                jspClient = "/entraineur/Connexion.jsp";
                request.setAttribute("msgError", "Wrong password");
            }
        }

        if (act.equals("deconnexion")) {
            session.setAttribute(ATT_SESSION_ENTRAINEUR, null);//Enlever le Token
            jspClient = "/entraineur/Connexion.jsp";
        }
        /*End connexion & deconnexion*/
        if (act.equals("afficherAffecterJoueur")) {
            request.setAttribute("listJoueurs", sessionEntraineur.rechercheJoueursSansEquipe());
            jspClient = "/entraineur/AffecterJoueur.jsp";

        }

        if (act.equals("affecterJoueurs")) {
            String[] joueursId = request.getParameterValues("idJoueurs");
            for (String j : joueursId) 
                sessionEntraineur.affecterJoueur(Long.parseLong(j), (Equipe) session.getAttribute("equipe"));          
            jspClient = "/entraineur/Menu.jsp";
        }

        if (act.equals("afficherTransfererJoueur")) {
            request.setAttribute("listEquipes", sessionEntraineur.listEquipesTransfert((Equipe) session.getAttribute("equipe")));
            request.setAttribute("listJoueurs", ((Equipe) session.getAttribute("equipe")).getEffectif());
            System.out.println(sessionEntraineur.listEquipesTransfert((Equipe) session.getAttribute("equipe")));        
            jspClient = "/entraineur/TransfererJoueurs.jsp";
        }

        if (act.equals("transfererJoueurs")) {
            String[] joueursId = request.getParameterValues("idJoueurs");
            for (String j : joueursId) 
                sessionEntraineur.transfererJoueur(Long.parseLong(j), (Equipe) session.getAttribute("equipe"), Long.parseLong(request.getParameter("equipeID")));  
        jspClient = "/entraineur/Menu.jsp";

            
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(jspClient);
        rd.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
