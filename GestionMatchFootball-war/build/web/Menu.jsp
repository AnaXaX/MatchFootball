<%@ include file="header.jsp"%>
        <section class="section animated fadeIn">
            <a href="${pageContext.request.contextPath}/AccesCommun">
                <div class="box">
                    <article class="media">         
                        <div class="media-content">
                            <div class="content">
                                <p>
                                    <strong>Afficher les matchs</strong>
                                    <br>
                            Afficher les matchs qui auront lieu à une date donée ou pour un intervalle de dates
                                </p>
                            </div>
      
                        </div>
                    </article>
                </div>
            </a>
     <a href="${pageContext.request.contextPath}/AccesCommun?action=afficherEquipe">
                <div class="box">
                    <article class="media">                
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
    </section>
<%@ include file="footer.jsp"%>
</body>
</html>