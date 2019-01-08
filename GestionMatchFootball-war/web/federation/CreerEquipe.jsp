<%@page import="entities.Entraineur"%>
<%@page import="java.util.List"%>
<%@ include file="/federation/RedirectionFederation.jsp"%>

<jsp:useBean id="listEntraineurs" scope="request" class="java.util.List"></jsp:useBean>
<%@ include file="../header.jsp"%>

<section class="section" style="margin-top:2rem">
    <form method="post" action="${pageContext.request.contextPath}/AccesFederation">
        <div class="field">
            <p class="control has-icons-left">
                <input name="nom" class="input has-text-info is-fullwidth is-large has-text-centered" type="text" placeholder="Nom de l'équipe">
                <span class="icon is-small is-left">
                    <i class="fas fa-flag-checkered"></i>
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
</body>
</html>