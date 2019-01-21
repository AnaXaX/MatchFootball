<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entities.Joueur"%>
<%@page import="entities.MatchFoot"%>
<%@page import="java.util.Collection"%>
<%@ include file="/entraineur/RedirectionEntraineur.jsp" %>

<jsp:useBean id="listJoueurs" scope="request" class="java.util.Collection"></jsp:useBean>
    <style>
    <jsp:include page="../css/bulma-checkradio.min.css"/> // rajout css for beautiful checkbox
</style>
<%@ include file="../header.jsp"%>

<section class="section" style="margin-top:2rem">
    <%        Collection<Joueur> joueurs = listJoueurs;
              MatchFoot match = (MatchFoot) request.getAttribute("match");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy à HH:mm");
    %>         
    <h1 class="title"><%=match.getEquipeInvitee().getNom()+" VS "+match.getEquipeReceveuse().getNom()%></h1>
    <h1 class="subtitle">Liste des joueurs à affecter pour le match du <%=dateFormat.format(match.getDate())%> arbitré par <%=match.getArbitre().getNom()+" "+match.getArbitre().getPrenom()%></h1>
    

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
                    <div class="card-content">
                        <p class="title">
                            <%=j.getNom()%>&nbsp;<%=j.getPrenom()%>
                        </p>
                        <p class="subtitle" style="margin-top: 1rem">
                            <input class="is-checkradio" id="checkbox<%=i%>" type="checkbox" name="idJoueurs" value="<%=j.getId()%>">
                            <label for="checkbox<%=i%>">Affecter ce Joueur</label>
                        </p>                                             
                    </div>     
                </div>
            </div>
            <%i++;
                }%>
        </div>
        <input value="<%=match.getId()%>" name="idMatch" type="hidden">
        <input value="affecterJoueursTactique" name="action" type="hidden">
        <input style="margin-top: 1rem" class="button is-large is-success" value="Affecter les joueurs" type="submit">
    </form>


    <!-- <input style="margin-top: 1rem" class="button is-large is-success" value="Afficher les joueurs de l'équipe" type="submit"> -->
</section>
<%@ include file="../footer.jsp"%>
</body>
</html>