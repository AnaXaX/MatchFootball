<!-- Forcer la redirection vers le menu si le token n'existe pas , pour �viter les petits malins d'acc�der � cette vue par URL-->
<%
    RequestDispatcher rd = request.getRequestDispatcher("/Connexion.jsp");
    if (session.getAttribute("sessionFederation") == null) {
        rd.forward(request, response);
    }
%>
<%@ include file="../header.jsp"%>

<section class="section" style="margin-top:2rem">
    <form method="post" action="${pageContext.request.contextPath}/AccesFederation">
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
                <input name="prenom" class="input has-text-info is-fullwidth is-large has-text-centered" type="text" placeholder="Pr�nom du joueur">         
                <span class="icon is-small is-left">
                    <i class="far fa-user"></i>
                </span>
            </p>
        </div>

        <%--
        <div class="field">
          <div class="control has-icons-left">
            <div class="select is-large is-fullwidth has-text-centered">
              <select name="equipeID" class="has-text-centered is-centered" >
                    <option value="" disabled selected>Choisir l'�quipe</option>
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
        --%>
        <input value="creerJoueur" name="action" type="hidden">
        <input style="margin-top: 1rem" class="button is-large is-success" value="Cr�er le joueur" type="submit">
    </form>          
</section>
<%@ include file="../footer.jsp"%>
</body>
</html>