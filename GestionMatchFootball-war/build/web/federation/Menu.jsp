<%@ include file="/federation/RedirectionFederation.jsp" %>
<%@ include file="../header.jsp"%>
<section class="section animated fadeIn">

   <%-- <a href="${pageContext.request.contextPath}/AccesFederation?action=afficherEntraineur"> --%>
    <a href="${pageContext.request.contextPath}/federation/GestionEquipe.jsp" >
        <div class="box">
            <article class="media">
                <div class="media-left">
                    <figure class="image is-64x64">
                        <img src="${pageContext.request.contextPath}/img/equipe.png" alt="Équipe">
                    </figure>
                </div>
                <div class="media-content">
                    <div class="content">
                        <p>
                            <strong>Gestion des équipes</strong><br>
                            Vous pouvez dans ce menu créer de nouvelles équipes ou encore de modifier modifier. <%--ou encore supprimer--%>
                        </p>
                    </div>
                </div>
            </article>
        </div>
    </a>  

    <a href="${pageContext.request.contextPath}/federation/CreerArbitre.jsp">
        <div class="box">
            <article class="media">
                <div class="media-left">
                    <figure class="image is-64x64">
                        <img src="${pageContext.request.contextPath}/img/referee.png" alt="Arbitre">
                    </figure>
                </div>
                <div class="media-content">
                    <div class="content">
                        <p>
                            <strong>Créer des arbitres</strong><br>
                            Vous pouvez dans ce menu créer de nouveaux arbitres
                        </p>
                    </div>
                </div>
            </article>
        </div>
    </a>

    <a href="${pageContext.request.contextPath}/federation/CreerEntraineur.jsp">
        <div class="box">
            <article class="media">
                <div class="media-left">
                    <figure class="image is-64x64">
                        <img src="${pageContext.request.contextPath}/img/coach.png" alt="Entraineur">
                    </figure>
                </div>
                <div class="media-content">
                    <div class="content">
                        <p>
                            <strong>Créer des Entraineurs</strong><br>
                            Vous pouvez dans ce menu créer de nouveaux entraineurs
                        </p>
                    </div>
                </div>
            </article>
        </div>
    </a>

    <a href="${pageContext.request.contextPath}/federation/GestionJoueur.jsp">
        <div class="box">
            <article class="media">
                <div class="media-left">
                    <figure class="image is-64x64">
                        <img src="${pageContext.request.contextPath}/img/player.png" alt="Joueur">
                    </figure>
                </div>
                <div class="media-content">
                    <div class="content">
                        <p>
                            <strong>Gestion des Joueurs</strong><br>
                            Vous pouvez dans ce menu créer de nouveux joueurs, modifier ou encore sanctionner.
                        </p>
                    </div>
                </div>
            </article>
        </div>
    </a>

    <a href="${pageContext.request.contextPath}/AccesFederation?action=afficherCreerMatch">
        <div class="box">
            <article class="media">
                <div class="media-left">
                    <figure class="image is-64x64">
                        <img src="${pageContext.request.contextPath}/img/match.png" alt="Match">
                    </figure>
                </div>
                <div class="media-content">
                    <div class="content">
                        <p>
                            <strong>Créer des Matchs</strong><br>
                            Vous pouvez dans ce menu créer des Matchs
                        </p>
                    </div>
                </div>
            </article>
        </div>
    </a>
                    
    <a href="${pageContext.request.contextPath}/AccesFederation?action=matchAModifier">
        <div class="box">
            <article class="media">
                <div class="media-left">
                    <figure class="image is-64x64">
                        <img src="${pageContext.request.contextPath}/img/match.png" alt="Match">
                    </figure>
                </div>
                <div class="media-content">
                    <div class="content">
                        <p>
                            <strong>Modifier la date d'un match</strong><br>
                            Vous pouvez dans ce menu modifier la date d'un match
                        </p>
                    </div>
                </div>
            </article>
        </div>
    </a>

    <form method="post" action="${pageContext.request.contextPath}/AccesFederation">                     
        <input value="deconnexion" name="action" type="hidden">
        <input style="margin-top: 1rem" class="button is-large is-danger" value="Déconnexion" type="submit">
    </form> 

</section>
<%@ include file="../footer.jsp"%>
</body>
</html>