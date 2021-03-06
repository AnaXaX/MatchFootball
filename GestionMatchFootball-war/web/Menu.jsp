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
                            Afficher les matchs qui auront lieu � une date donn�e ou pour un intervalle de dates
                        </p>
                    </div>

                </div>
            </article>
        </div>
    </a>
    <a href="${pageContext.request.contextPath}/AccesCommun?action=afficherEquipeMatch">
        <div class="box">
            <article class="media">       
                <div class="media-left">
                    <figure class="image is-64x64">
                        <img src="${pageContext.request.contextPath}/img/field.png" alt="Image">
                    </figure>
                </div>
                <div class="media-content">
                    <div class="content">
                        <p>
                            <strong>Afficher les matchs</strong>
                            <br>
                            Afficher les matchs d'une �quipe
                        </p>
                    </div>

                </div>
            </article>
        </div>
    </a>
    
    <a href="${pageContext.request.contextPath}/AccesCommun?action=afficherEffectifMatch">
        <div class="box">
            <article class="media">       
                <div class="media-left">
                    <figure class="image is-64x64">
                        <img src="${pageContext.request.contextPath}/img/match.png" alt="Image">
                    </figure>
                </div>
                <div class="media-content">
                    <div class="content">
                        <p>
                            <strong>Afficher l'effectif d'un match</strong>
                            <br>
                            Afficher l'effectif d'un match
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
                            Afficher les joueurs d'une �quipe
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
                            Afficher le classement des �quipes selon les points
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