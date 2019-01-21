package servlet;

import entities.Entraineur;
import entities.Equipe;
import java.io.IOException;
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

    private String jspClient = "/entraineur/Menu.jsp";

    protected void choixJoueursMatchTactique(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.setAttribute("listJoueurs", ((Equipe) request.getSession().getAttribute("equipe")).getEffectif());
            request.setAttribute("match", sessionEntraineur.rechercheMatchId(Long.parseLong(request.getParameter("idMatch"))));
            jspClient = "/entraineur/SetEffectifMatch.jsp";         
    }

    protected void choixMatchTactique(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                request.setAttribute("listMatchs", sessionEntraineur.listMatchsTactique((Equipe) request.getSession().getAttribute("equipe")));
            jspClient = "/entraineur/ChoixMatchsTactique.jsp";
    }
    protected void refreshEquipeEntraineur(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().setAttribute("equipe", (Equipe) sessionEntraineur.rechercheEquipeParEntraineur((Entraineur) request.getSession().getAttribute(ATT_SESSION_ENTRAINEUR)));
    }

    protected void afficherAffecterJoueur(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("listJoueurs", sessionEntraineur.rechercheJoueursSansEquipe());
        jspClient = "/entraineur/AffecterJoueur.jsp";
    }

    protected void afficherTransfertJoueur(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setAttribute("listEquipes", sessionEntraineur.listEquipesTransfert((Equipe) session.getAttribute("equipe")));
        request.setAttribute("listJoueurs", ((Equipe) session.getAttribute("equipe")).getEffectif());
        jspClient = "/entraineur/TransfererJoueurs.jsp";
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String act = request.getParameter("action");
        HttpSession session = request.getSession();

        /*Control Connexion*/
        if (act.equals("Connexion")) {
            
            String login = request.getParameter("login").trim();
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
            afficherAffecterJoueur(request, response);
        }

        if (act.equals("affecterJoueurs")) {
            if (request.getParameterValues("idJoueurs") != null && session.getAttribute("equipe") != null) {
                String[] joueursId = request.getParameterValues("idJoueurs");
                for (String j : joueursId) {
                    sessionEntraineur.affecterJoueur(Long.parseLong(j), (Equipe) session.getAttribute("equipe"));
                }
                jspClient = "/entraineur/Menu.jsp";
            } else {
                afficherAffecterJoueur(request, response);
            }

        }

        if (act.equals("afficherTransfererJoueur")) {
            afficherTransfertJoueur(request, response);
        }

        if (act.equals("transfererJoueurs")) {
            if (request.getParameter("equipeID") == null || request.getParameterValues("idJoueurs")==null || session.getAttribute("equipe") == null) {
                afficherTransfertJoueur(request, response);
            } else {
                String[] joueursId = request.getParameterValues("idJoueurs");
                for (String j : joueursId) {
                    sessionEntraineur.transfererJoueur(Long.parseLong(j), (Equipe) session.getAttribute("equipe"), Long.parseLong(request.getParameter("equipeID")));
                }
                jspClient = "/entraineur/Menu.jsp";
            }
        }

        if (act.equals("supprimerJoueurs")) {
            if (request.getParameterValues("idJoueurs") == null) {
                request.setAttribute("listJoueurs", ((Equipe) session.getAttribute("equipe")).getEffectif());
                jspClient = "/entraineur/SupprimerContrat.jsp";
            } else {
                String[] joueursId = request.getParameterValues("idJoueurs");
                for (String j : joueursId) {
                    sessionEntraineur.supprimerContratJoueur(Long.parseLong(j));
                }
                /*Actualiser l'effectif en bidirectionnel en recherchant l'équipe*/
                refreshEquipeEntraineur(request, response);
                jspClient = "/entraineur/Menu.jsp";
            }
        }

        if (act.equals("afficherSupprimerContrat")) {
            request.setAttribute("listJoueurs", ((Equipe) session.getAttribute("equipe")).getEffectif());
            jspClient = "/entraineur/SupprimerContrat.jsp";
 
        }
        
        if (act.equals("ChoixMatchsTactique")) {
            choixMatchTactique(request, response);
        }
        
        if (act.equals("setEffectifMatch")) {
            if(request.getParameter("idMatch")!=null){
                choixJoueursMatchTactique(request, response);
            }
            else{
                choixMatchTactique(request, response);
            }
        }
        
        
        if (act.equals("affecterJoueursTactique")) {
            if (request.getParameterValues("idJoueurs") == null) {
                choixJoueursMatchTactique(request, response);
            }
            else{          
               // String[] joueursId = request.getParameterValues("idJoueurs");
              //  for (String j : joueursId) {
                   
                sessionEntraineur.affecterMatch(request.getParameterValues("idJoueurs"),Long.parseLong(request.getParameter("idMatch")),((Equipe) session.getAttribute("equipe")));
              //  }
                jspClient = "/entraineur/Menu.jsp";
            }
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
