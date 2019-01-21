package servlet;

import entities.Arbitre;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessions.SessionArbitreLocal;

/**
 *
 * @author 6170232
 */
@WebServlet(name = "AccesArbitre", urlPatterns = {"/AccesArbitre"})
public class AccesArbitre extends HttpServlet {

    @EJB
    private SessionArbitreLocal sessionArbitre;

    private final String ATT_SESSION_ARBITRE = "sessionArbitre";

    private String jspClient = "/arbitre/Menu.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        String act = request.getParameter("action");

        /*Control Connexion*/
        if (act.equals("Connexion")) {
            String login = request.getParameter("login").trim();
            String mdp = request.getParameter("password");
            Arbitre arbitre = sessionArbitre.authentification(login, mdp);

            if (arbitre != null) {

                jspClient = "/arbitre/Menu.jsp";
                session.setAttribute(ATT_SESSION_ARBITRE, arbitre);//Attribuer le Token
            } else {
                System.out.println("I am here 3");

                jspClient = "/arbitre/Connexion.jsp";
                request.setAttribute("msgError", "Wrong password");
            }
        }

        /*Control Deconnexion*/
        if (act.equals("deconnexion")) {
            session.setAttribute(ATT_SESSION_ARBITRE, null); //Enlever le Token
            jspClient = "/arbitre/Connexion.jsp";
        }
        /*Fin Deconnexion*/

        if (act.equals("setScoreMatch")) {
            if (request.getParameter("scoreEquipeReceveuse") != null && request.getParameter("scoreEquipeInvitee") != null) {
                sessionArbitre.setScoreMatch(Long.parseLong(request.getParameter("idMatch")), Integer.parseInt(request.getParameter("scoreEquipeReceveuse")), Integer.parseInt(request.getParameter("scoreEquipeInvitee")));
                jspClient = "/arbitre/Menu.jsp";

            }
        }

        if (act.equals("ModifierScoreMatch")) {
            if (request.getParameter("idMatch") != null) {
                request.setAttribute("match", sessionArbitre.rechercheMatch(Long.parseLong(request.getParameter("idMatch"))));
                jspClient = "/arbitre/SetScoreMatch.jsp";
            } else {
                request.setAttribute("listMatchs", sessionArbitre.listMatchsResultat((Arbitre) session.getAttribute(ATT_SESSION_ARBITRE)));
                jspClient = "/arbitre/ChoixMatchResultat.jsp";
            }
        }

        if (act.equals("afficherMatchResultat")) {
            request.setAttribute("listMatchs", sessionArbitre.listMatchsResultat((Arbitre) session.getAttribute(ATT_SESSION_ARBITRE)));
            jspClient = "/arbitre/ChoixMatchResultat.jsp";
        }

        if (act.equals("SetFauteJoueurMatch")) {
            if(request.getParameter("cartonJaune") != null && request.getParameter("cartonRouge") != null){
                sessionArbitre.setFauteJoueurMatch(Long.parseLong(request.getParameter("idJoueur")),Long.parseLong(request.getParameter("idMatch")),Boolean.parseBoolean(request.getParameter("cartonJaune")),Boolean.parseBoolean(request.getParameter("cartonRouge")));
            }
        }
        if (act.equals("ChoixJoueurFauteMatch")) {
            request.setAttribute("match", sessionArbitre.rechercheMatch(Long.parseLong(request.getParameter("idMatch"))));
            request.setAttribute("joueur", sessionArbitre.rechercheJoueur(Long.parseLong(request.getParameter("idJoueur"))));
            jspClient = "/arbitre/SetFauteJoueurMatch.jsp";
        }

        if (act.equals("ModifierFauteMatch")) {
            if (request.getParameter("idMatch") != null) {
                request.setAttribute("match", sessionArbitre.rechercheMatch(Long.parseLong(request.getParameter("idMatch"))));
                jspClient = "/arbitre/ChoixJoueurMatchFaute.jsp";
            } else {
                request.setAttribute("listMatchs", sessionArbitre.listMatchsResultat((Arbitre) session.getAttribute(ATT_SESSION_ARBITRE)));
                jspClient = "/arbitre/ChoixMatchFaute.jsp";
            }
        }

        if (act.equals("afficherMatchFautes")) {
            request.setAttribute("listMatchs", sessionArbitre.listMatchsResultat((Arbitre) session.getAttribute(ATT_SESSION_ARBITRE)));
            jspClient = "/arbitre/ChoixMatchFaute.jsp";
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
