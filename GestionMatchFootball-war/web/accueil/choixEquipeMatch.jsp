<%@page import="entities.Equipe"%>
<%@page import="java.util.Collection"%>

<jsp:useBean id="listEquipes" scope="request" class="java.util.Collection"></jsp:useBean>
<%@ include file="../header.jsp"%>

<section class="section" style="margin-top:2rem">
    <form method="post" action="${pageContext.request.contextPath}/AccesCommun">
        <div class="field">
          <div class="control has-icons-left">
            <div class="select is-large is-fullwidth has-text-centered">
              <select name="equipeID" class="has-text-centered is-centered" >
                    <option value="" disabled selected>Choisir l'équipe</option>
                <%
                    Collection<Equipe> equipes = listEquipes;
                    for(Equipe e : equipes){
                %>
               
                <option value="<%=e.getId()%>"><%=e.getNom()%></option>
                <%}%>
              </select>
                <span class="icon is-small is-left">
                    <i class="fas fa-tshirt"></i>            
                </span>
            </div>
          </div>
        </div>
        <input value="afficherMatchsEquipe" name="action" type="hidden">
        <input style="margin-top: 1rem" class="button is-large is-success" value="Afficher les matchs de l'équipe" type="submit">
    </form>          
</section>
<%@ include file="../footer.jsp"%>
</body>
</html>