<!-- Forcer la redirection vers le menu si le token n'existe pas , pour éviter les petits malins d'accéder à cette vue par URL-->

<%
    RequestDispatcher rd = request.getRequestDispatcher("/Connexion.jsp");
    if (session.getAttribute("sessionFederation") == null) {
        rd.forward(request, response);
    }
%>
<%@ include file="../header.jsp"%>
<section class="section animated fadeIn">

    <a href="${pageContext.request.contextPath}/AccesFederation?action=afficherEntraineur" >
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
                            <strong>Créer des équipes</strong><br>
                            Vous pouvez dans ce menu créer de nouvelles équipes
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

    <a href="${pageContext.request.contextPath}/federation/CreerJoueur.jsp">
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
                            <strong>Créer des Joueurs</strong><br>
                            Vous pouvez dans ce menu créer de nouveaux joueurs
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

    <form method="post" action="${pageContext.request.contextPath}/AccesFederation">                     
        <input value="deconnexion" name="action" type="hidden">
        <input style="margin-top: 1rem" class="button is-large is-danger" value="Déconnexion" type="submit">
    </form> 

</section>
<%@ include file="../footer.jsp"%>
</body>
</html>