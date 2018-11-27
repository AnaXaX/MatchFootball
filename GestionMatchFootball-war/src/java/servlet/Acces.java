/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entities.Equipe;
import entities.Joueur;
import java.io.IOException;
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
@WebServlet(name = "Acces", urlPatterns = {"/Acces"})
public class Acces extends HttpServlet {

    @EJB
    private SessionCommuneLocal sessionCommune;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String jspClient = null;
        String act = request.getParameter("action");
       
            
         /*Federation Menu Possibilités*/
        /*Création Entraineur*/
  
        /* why dis doesn't work here and work's in AccesCommun
          if (act.equals("afficherEquipe")) {
                jspClient = "/accueil/ChoixEquipe.jsp";
                List<Equipe> listEquipes = sessionCommune.listEquipes();
                for(Equipe e :  listEquipes){
                    System.out.println(e.getId());
                }

                request.setAttribute("listEquipes", listEquipes);
                
          }

         if (act.equals("afficherJoueurs")) {
      
             if(request.getParameter("equipeID").trim().isEmpty() || request.getParameter("equipeID").isEmpty()){
                jspClient = "/accueil/ChoixEquipe.jsp";
                request.setAttribute("msgError", "Une erreur est produite lors du choix de l'équipe");
             }else{
                List<Joueur> listJoueurs = sessionCommune.rechercheEquipe(Long.parseLong(request.getParameter("equipeID"))).getEffectif();
                request.setAttribute("listJoueurs", listJoueurs);
                jspClient = "/accueil/AfficherJoueurs.jsp";
             }
              
          }*/
        
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
