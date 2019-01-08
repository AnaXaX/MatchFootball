<%@ include file="header.jsp"%>
<section class="section animated fadeIn">
    <a href="${pageContext.request.contextPath}/accueil/choixIntervalle.jsp">
        <div class="box">
            <article class="media">       
                <div class="media-left">
                    <figure class="image is-64x64">
                        <img src="${pageContext.request.contextPath}/img/matchFoot.png" alt="Image">
                    </figure>
                </div>
                <div class="media-content">
                    <div class="content">
                        <p>
                            <strong>Afficher les matchs</strong>
                            <br>
                            Afficher les matchs qui auront lieu à une date donnée ou pour un intervalle de dates
                        </p>
                    </div>

                </div>
            </article>
        </div>
    </a>
    <a href="${pageContext.request.contextPath}/AccesCommun?action=afficherEquipe">
        <div class="box">
            <article class="media">   
                <div class="media-left">
                    <figure class="image is-64x64">
                        <img src="${pageContext.request.contextPath}/img/players.png" alt="Image">
                    </figure>
                </div>
                <div class="media-content">
                    <div class="content">
                        <p>
                            <strong>Afficher les joueurs</strong><br>
                            Afficher les joueurs d'une équipe
                        </p>
                    </div>                    
                </div>
            </article>
        </div>
    </a>
    <a href="${pageContext.request.contextPath}/AccesCommun?action=afficherClassement">
        <div class="box">
            <article class="media">   
                <div class="media-left">
                    <figure class="image is-64x64">
                        <img src="${pageContext.request.contextPath}/img/podium.png" alt="Image">
                    </figure>
                </div>
                <div class="media-content">
                    <div class="content">
                        <p>
                            <strong>Afficher le classement</strong><br>
                            Afficher le classement des équipes selon les points
                        </p>
                    </div>                    
                </div>
            </article>
        </div>
    </a>
</section>
<%@ include file="footer.jsp"%>
</body>
</html>