<%@page import="entities.Entraineur"%>
<%@page import="java.util.List"%>
<!-- Forcer la redirection vers le menu si le token n'existe pas , pour éviter les petits malins d'accéder à cette interface-->
<%
    RequestDispatcher rd = request.getRequestDispatcher("../Menu.jsp");
    if (session.getAttribute("sessionFederation") == null) {
        rd.forward(request, response);
    }
%>
<jsp:useBean id="listEntraineurs" scope="request" class="java.util.List"></jsp:useBean>
<%@ include file="../header.jsp"%>

<section class="section" style="margin-top:2rem">
    <form method="get" action="${pageContext.request.contextPath}/AccesFederation">
        <div class="field">
            <p class="control has-icons-left">
                <input name="nom" class="input has-text-info is-fullwidth is-large has-text-centered" type="text" placeholder="Nom de l'équipe">
                <span class="icon is-small is-left">
                    <i class="fas fa-user"></i>
                </span>
            </p>
        </div>

        <div class="field">
          <div class="control has-icons-left">
            <div class="select is-large is-fullwidth has-text-centered">
              <select name="entraineurID" class="has-text-centered is-centered" >
                    <option value="" disabled selected>Choisir l'entraineur</option>
                <%
                    List<Entraineur> entraineurs = listEntraineurs;
                    for(Entraineur e : entraineurs){
                %>
                <option  value="<%=e.getId()%>"><%=e.getNom()%>&nbsp;<%=e.getPrenom()%></option>
                <%}%>
              </select>   
                <span class="icon is-small is-left">
                    <i class="fas fa-user-secret"></i>
                </span>
            </div>
          </div>
        </div>
        <input value="creerEquipe" name="action" type="hidden">
        <input style="margin-top: 1rem" class="button is-large is-success" value="Créer l'équipe" type="submit">
    </form>          
</section>
<%@ include file="../footer.jsp"%>
