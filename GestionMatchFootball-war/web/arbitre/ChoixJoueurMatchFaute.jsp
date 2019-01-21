<%@page import="entities.MatchFoot"%>
<%@page import="entities.Joueur"%>
<%@page import="entities.Effectif"%>

<%@ include file="/arbitre/RedirectionArbitre.jsp" %>

<%@ include file="../header.jsp"%>


<section class="section" style="margin-top:2rem">
    <%        MatchFoot match = (MatchFoot) request.getAttribute("match");
        //System.out.println(joueurs);
%>         
    <h1 class="title">Choisir joueur :</h1>
    <form method="post" action="${pageContext.request.contextPath}/AccesArbitre">
        
             <div class="columns is-multiline">
            <%  int i = 0;
                for (Effectif e : match.getEffectif()) {
                    for(Joueur j : e.getListeJoueurs()){
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
                            <input class="is-checkradio" id="radio<%=i%>" type="radio" name="idJoueur" value="<%=j.getId()%>">
                            <label for="radio<%=i%>">Saisir une faute de ce Joueur</label>
                                              
                        </p>                                             
                    </div>     
                </div>
            </div>
            <%i++;
                }}%>
        </div>

        <input value="ChoixJoueurFauteMatch" name="action" type="hidden">
        <input value="<%=match.getId()%>" name="idMatch" type="hidden">
        <input style="margin-top: 1rem" class="button is-large is-success" value="saisir faute de ce match" type="submit">
    </form>
</section>
<%@ include file="../footer.jsp"%>
</body>
</html>