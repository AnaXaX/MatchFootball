<%@page import="entities.Arbitre"%>

<%@ include file="/arbitre/RedirectionArbitre.jsp" %>

<%@ include file="../header.jsp"%>
        <section class="section animated fadeIn">
            
    <div class="box">
        <article class="media">
            <div class="media-content">
                <div class="content">
                    <center>
                        <p class="title">
                            <% Arbitre a = (Arbitre) session.getAttribute("sessionArbitre"); %>
                            <strong><%=(a.getNom()+' '+a.getPrenom())%></strong>
                        </p>
                        <p class="subtitle">
                            Nombre de matchs affectés : <strong><%=a.getHistoriqueMatchs().size()%></strong>
                        </p>                   
                    </center>
                </div>
            </div>
        </article>
    </div>
                      
            <a href="${pageContext.request.contextPath}/AccesArbitre?action=afficherMatchResultat" >
                <div class="box">
                    <article class="media">
                        <div class="media-left">
                            <figure class="image is-64x64">
                                <img src="${pageContext.request.contextPath}/img/scoreboard.png" alt="Image">
                            </figure>
                        </div>
                        <div class="media-content">
                            <div class="content">
                                <p>
                                    <strong>Saisir résultat</strong><br>
                                    Vous pouvez dans ce menu saisir le résultat d'un match arbitré
                                </p>
                            </div>
                        </div>
                    </article>
                </div>
            </a>           
                 <a href="${pageContext.request.contextPath}/AccesArbitre?action=afficherMatchFautes" >
                <div class="box">
                    <article class="media">
                        <div class="media-left">
                            <figure class="image is-64x64">
                                <img src="${pageContext.request.contextPath}/img/yellow-card.png" alt="Image">
                            </figure>
                        </div>
                        <div class="media-content">
                            <div class="content">
                                <p>
                                    <strong>Saisir fautes</strong><br>
                                    Vous pouvez dans ce menu saisir les fautes relatifs à un match arbitré
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