<!-- Forcer la redirection vers le menu si le token n'existe pas , pour �viter les petits malins d'acc�der � cette vue par URL-->
<%
    RequestDispatcher rd = request.getRequestDispatcher("/Connexion.jsp");
    if (session.getAttribute("sessionFederation") == null) {
        rd.forward(request, response);
    }
%>