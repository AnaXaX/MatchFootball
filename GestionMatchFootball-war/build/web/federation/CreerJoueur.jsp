<%@page import="entities.Equipe"%>
<%@page import="java.util.List"%>
<!-- Forcer la redirection vers le menu si le token n'existe pas , pour éviter les petits malins d'accéder à cette interface-->
<%
    RequestDispatcher rd = request.getRequestDispatcher("../Menu.jsp");
    if (session.getAttribute("sessionFederation") == null) {
        rd.forward(request, response);
    }
%>
<jsp:useBean id="listEquipes" scope="request" class="java.util.List"></jsp:useBean>
<%@ include file="../header.jsp"%>

<section class="section" style="margin-top:2rem">
    <form method="get" action="${pageContext.request.contextPath}/AccesFederation">
        <div class="field">
            <p class="control has-icons-left">
                <input name="nom" class="input has-text-info is-fullwidth is-large has-text-centered" type="text" placeholder="Nom du joueur">
                <span class="icon is-small is-left">
                    <i class="fas fa-user"></i>
                </span>
            </p>
        </div>
        <div class="field">
            <p class="control has-icons-left">
                <input name="prenom" class="input has-text-info is-fullwidth is-large has-text-centered" type="text" placeholder="Prénom du joueur">         
                <span class="icon is-small is-left">
                    <i class="far fa-user"></i>
                </span>
            </p>
        </div>

        <div class="field">
          <div class="control has-icons-left">
            <div class="select is-large is-fullwidth has-text-centered">
              <select name="equipeID" class="has-text-centered is-centered" >
                    <option value="" disabled selected>Choisir l'équipe</option>
                <%
                    List<Equipe> equipes = listEquipes;
                    for(Equipe e : equipes){
                %>
                <option value="<%=e.getId()%>"><%=e.getNom()%></option>
                <%}%>
              </select>
                <span class="icon is-small is-left">
                 <i class="fas fa-user"></i>
             </span>
            </div>
          </div>
        </div>
        <input value="creerJoueur" name="action" type="hidden">
        <input style="margin-top: 1rem" class="button is-large is-success" value="Créer le joueur" type="submit">
    </form>          
</section>
<%@ include file="../footer.jsp"%>
