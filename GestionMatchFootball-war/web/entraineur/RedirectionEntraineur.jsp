<!-- Forcer la redirection vers le menu si le token n'existe pas , pour �viter les petits malins d'acc�der � cette interface par URL-->
<%
    RequestDispatcher rd = request.getRequestDispatcher("/Connexion.jsp");
    if (session.getAttribute("sessionEntraineur") == null) {
        rd.forward(request, response);
    }
%>