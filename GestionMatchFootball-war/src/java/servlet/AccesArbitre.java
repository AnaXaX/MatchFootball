package servlet;

import entities.Arbitre;
import java.io.IOException;
import javax.ejb.EJB;
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

    private Arbitre arbitre;

    private final String ATT_SESSION_ARBITRE = "sessionArbitre";


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
   
        
        String jspClient = null;
        HttpSession session = request.getSession();
        String act = request.getParameter("action");
        
           /*Control Connexion*/
        if (act.equals("authentification")) {      
            arbitre = null;
            String login = request.getParameter("loginArbitre");
            String mdp = request.getParameter("mdpArbitre");
            arbitre = sessionArbitre.authentification(login,mdp);
            
            if (arbitre!=null) {
                jspClient = "/arbitre/Menu.jsp";
                session.setAttribute(ATT_SESSION_ARBITRE, arbitre);//Attribuer le Token
            } else {
                jspClient = "/arbitre/Connexion.jsp";
                request.setAttribute("msgError", "Wrong password");
            }
        }

        /*Control Deconnexion*/
        if (act.equals("deconnexion")) {
            arbitre = null;
            session.setAttribute(ATT_SESSION_ARBITRE, arbitre); //Enlever le Token
            jspClient = "/Menu.jsp";
        }
        
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
