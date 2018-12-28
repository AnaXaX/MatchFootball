<!-- Forcer la redirection vers le menu si le token n'existe pas , pour �viter les petits malins d'acc�der � cette vue par URL-->

<%     
    RequestDispatcher rd = request.getRequestDispatcher("/Connexion.jsp");   
    if(session.getAttribute("sessionArbitre")==null)
    rd.forward(request, response);
%>
<%-- jsp:useBean id="sessionFederation" scope="session" class=""></jsp:useBean--%>
<%@ include file="../header.jsp"%>
        <section class="section animated fadeIn">
            
            <a href="${pageContext.request.contextPath}/AccesFederation?action=afficherEntraineur" >
                <div class="box">
                    <article class="media">
                        <div class="media-left">
                            <figure class="image is-64x64">
                                <img src="https://bulma.io/images/placeholders/128x128.png" alt="Image">
                            </figure>
                        </div>
                        <div class="media-content">
                            <div class="content">
                                <p>
                                    <strong>Saisir r�sultat</strong><br>
                                    Vous pouvez dans ce menu saisir le r�sultat d'un match arbitr�
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
                                <img src="${pageContext.request.contextPath}/img/Referee.png" alt="Image">
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
                                <img src="https://bulma.io/images/placeholders/128x128.png" alt="Image">
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
                
            <%--
             <a href="${pageContext.request.contextPath}/AccesFederation?action=affecterJoueurEquipe">
                <div class="box">
                    <article class="media">
                        <div class="media-left">
                            <figure class="image is-64x64">
                                <img src="${pageContext.request.contextPath}/img/playerPlus.png" alt="Image">
                            </figure>
                        </div>
                        <div class="media-content">
                            <div class="content">
                                <p>
                                   <strong>Cr�er des Joueurs</strong><br>
                                    Vous pouvez dans ce menu cr�er de nouveaux joueurs
                                </p>
                            </div>
                        </div>
                    </article>
                </div>
            </a>
            --%>
                 <a href="${pageContext.request.contextPath}/federation/CreerJoueur.jsp">
                <div class="box">
                    <article class="media">
                        <div class="media-left">
                            <figure class="image is-64x64">
                                <img src="${pageContext.request.contextPath}/img/playerPlus.png" alt="Image">
                            </figure>
                        </div>
                        <div class="media-content">
                            <div class="content">
                                <p>
                                   <strong>Cr�er des Joueurs</strong><br>
                                    Vous pouvez dans ce menu cr�er de nouveaux joueurs
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