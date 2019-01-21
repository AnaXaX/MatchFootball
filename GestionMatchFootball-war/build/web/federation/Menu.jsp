<%@ include file="/federation/RedirectionFederation.jsp" %>
<%@ include file="../header.jsp"%>
<section class="section animated fadeIn">

   <%-- <a href="${pageContext.request.contextPath}/AccesFederation?action=afficherEntraineur"> --%>
    <a href="${pageContext.request.contextPath}/federation/GestionEquipe.jsp" >
        <div class="box">
            <article class="media">
                <div class="media-left">
                    <figure class="image is-64x64">
                        <img src="${pageContext.request.contextPath}/img/equipe.png" alt="�quipe">
                    </figure>
                </div>
                <div class="media-content">
                    <div class="content">
                        <p>
                            <strong>Gestion des �quipes</strong><br>
                            Vous pouvez dans ce menu cr�er de nouvelles �quipes ou encore de modifier modifier. <%--ou encore supprimer--%>
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
                            <strong>Cr�er des arbitres</strong><br>
                            Vous pouvez dans ce menu cr�er de nouveaux arbitres
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
                            <strong>Cr�er des Entraineurs</strong><br>
                            Vous pouvez dans ce menu cr�er de nouveaux entraineurs
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
                            Vous pouvez dans ce menu cr�er de nouveux joueurs, modifier ou encore sanctionner.
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
                            <strong>Cr�er des Matchs</strong><br>
                            Vous pouvez dans ce menu cr�er des Matchs
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
        <input style="margin-top: 1rem" class="button is-large is-danger" value="D�connexion" type="submit">
    </form> 

</section>
<%@ include file="../footer.jsp"%>
</body>
</html>