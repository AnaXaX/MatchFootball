<%@page import="entities.Joueur"%>
<%@page import="java.util.Collection"%>

<jsp:useBean id="listJoueurs" scope="request" class="java.util.Collection"></jsp:useBean>
<%@ include file="../header.jsp"%>



<%            String nomEquipe = (String) request.getAttribute("nomEquipe");
%>
<section class="section" style="margin-top:2rem">


    <%
        Collection<Joueur> joueurs = listJoueurs;
        System.out.println(joueurs);

    %>         





    <h1 class="title">Liste des joueurs</h1>
    <%--
    <table class="table is-striped is-hoverable is-fullwidth">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Prenom</th>
        </tr>
        <%
            for (Joueur j : joueurs) {
        %>         
        <tr>
            <td><%=j.getId()%></td>
            <td><%=j.getNom()%></td>
            <td><%=j.getPrenom()%></td>
        </tr>
        <%}%>
    </table>     
    --%>
<form method="post" action="${pageContext.request.contextPath}/AccesEntraineur">
    <div class="columns is-multiline">
        <%  int i = 0;
            for (Joueur j : joueurs) {
        %> 
        <div class="column is-one-quarter-desktop is-one-third-tablet">
            <div class="card">
                <div class="card-image">
                    <figure class="image is-4by3">
                        <img src="https://api.adorable.io/avatars/285/<%=j.getId()%>.jpg" alt="Placeholder image">
                    </figure>
                </div>
                <div class="card">
                    <div class="card-content">
                        <p class="title">
                            <%=j.getId()%>&nbsp;<%=j.getNom()%>&nbsp;<%=j.getPrenom()%>
                        </p>
                        <p class="subtitle"></p>
                    </div>
                </div>
                <footer class="card- has-text-centered">
                    <div class="field">
                        <input class="is-checkradio" id="checkbox<%=i%>" type="checkbox" name="idJoueurs" value="<%=j.getId()%>">
                        <label for="checkbox<%=i%>">Affecter ce Joueur</label>
                    </div>
                </footer>     
            </div>
        </div>
        <%i++;
            }%>
      

    </div>
              <input value="affecterJoueurs" name="action" type="hidden">
        <input style="margin-top: 1rem" class="button is-large is-success" value="Affecter les joueurs" type="submit">
    </form>


    <!-- <input style="margin-top: 1rem" class="button is-large is-success" value="Afficher les joueurs de l'équipe" type="submit"> -->
</section>
<%@ include file="../footer.jsp"%>
