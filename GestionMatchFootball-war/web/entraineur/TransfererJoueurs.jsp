<%@page import="entities.Equipe"%>
<%@page import="entities.Joueur"%>
<%@page import="java.util.Collection"%>
<%@ include file="/entraineur/RedirectionEntraineur.jsp" %>

<jsp:useBean id="listJoueurs" scope="request" class="java.util.Collection"></jsp:useBean>
<jsp:useBean id="listEquipes" scope="request" class="java.util.Collection"></jsp:useBean> 
<style>
    <jsp:include page="../css/bulma-checkradio.min.css"/> // rajout
</style>
<%@ include file="../header.jsp"%>

<section class="section" style="margin-top:2rem">

    <%        
        Collection<Joueur> joueurs = listJoueurs;
        Collection<Equipe> equipes = listEquipes;
        // System.out.println(joueurs);

    %>         

    <h1 class="title">Liste des joueurs</h1>

    <!-- Table checking -->
    <table class="table is-striped is-hoverable is-fullwidth">
        <tr>
            <th>Nom</th>
            <th>Prenom</th>
        </tr>
        <%            for (Joueur j : joueurs) {
        %>         
        <tr>
            <td><%=j.getNom()%></td>
            <td><%=j.getPrenom()%></td>
        </tr>
        <%}%>
    </table>     

    <form method="post" action="${pageContext.request.contextPath}/AccesEntraineur">
        <div class="field">
            <div class="control has-icons-left">
                <div class="select is-large is-fullwidth has-text-centered">
                    <select name="equipeID" class="has-text-centered is-centered" >
                        <option value="" disabled selected>Choisir l'équipe à transférer</option>
                        <%

                            for (Equipe e : equipes) {
                        %>
                        <option  value="<%=e.getId()%>"><%=e.getNom()%></option>
                        <%}%>
                    </select>   
                    <span class="icon is-small is-left">
                        <i class="fas fa-user-secret"></i>
                    </span>
                </div>
            </div>
        </div>
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
                                <%=j.getNom()%>&nbsp;<%=j.getPrenom()%>
                            </p>
                            <p class="subtitle" style="margin-top: 1rem">
                                <input class="is-checkradio" id="checkbox<%=i%>" type="checkbox" name="idJoueurs" value="<%=j.getId()%>">
                                <label for="checkbox<%=i%>">Transférer ce Joueur</label>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
            <%i++;
                }%>
        </div>
        <input value="transfererJoueurs" name="action" type="hidden">
        <input style="margin-top: 1rem" class="button is-large is-success" value="Transférer les joueurs" type="submit">
    </form>


    <!-- <input style="margin-top: 1rem" class="button is-large is-success" value="Afficher les joueurs de l'équipe" type="submit"> -->
</section>
<%@ include file="../footer.jsp"%>
</body>
</html>