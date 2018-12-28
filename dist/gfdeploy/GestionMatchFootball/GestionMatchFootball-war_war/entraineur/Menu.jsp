<%@page import="entities.Entraineur"%>
<%@page import="entities.Equipe"%>

<!-- Forcer la redirection vers le menu si le token n'existe pas , pour �viter les petits malins d'acc�der � cette vue par URL-->
<%
    RequestDispatcher rd = request.getRequestDispatcher("/Connexion.jsp");
    if (session.getAttribute("sessionEntraineur") == null) {
        rd.forward(request, response);
    }
%>
<%@ include file="../header.jsp"%>
<section class="section animated fadeIn">

    <div class="box">
        <article class="media">
            <div class="media-content">
                <div class="content">
                    <center>
                    <p class="title">
                        <% Entraineur e = (Entraineur) session.getAttribute("sessionEntraineur"); %>
                        <strong><%=(e.getNom()+' '+e.getPrenom())%></strong>
                    </p>
                    <p class="subtitle">
                        <% Equipe eq = (Equipe) session.getAttribute("equipe"); %>
                        <strong><% if (eq!=null) {out.print(eq.getNom());} else {out.print("Aucune �quipe");} %></strong>
                    </p>
                        
                    </center>
                </div>
            </div>
        </article>
    </div>
    <% if(eq!=null){ %>
    <a href="${pageContext.request.contextPath}/AccesEntraineur?action=afficherAffecterJoueur" >
        <div class="box">
            <article class="media">
                <div class="media-left">
                    <figure class="image is-64x64">
                        <img src="${pageContext.request.contextPath}/img/contract.png" alt="Image">
                    </figure>
                </div>
                <div class="media-content">
                    <div class="content">
                        <p>
                            <strong>Affecter un joueur � l'�quipe</strong><br>
                            Vous pouvez dans ce menu affecter un joueur � votre �quipe
                        </p>
                    </div>
                </div>
            </article>
        </div>
    </a>  

    <a href="${pageContext.request.contextPath}/AccesEntraineur?action=afficherTransfererJoueur">
        <div class="box">
            <article class="media">
                <div class="media-left">
                    <figure class="image is-64x64">
                        <img src="${pageContext.request.contextPath}/img/transfert.png" alt="Image">
                    </figure>
                </div>
                <div class="media-content">
                    <div class="content">
                        <p>
                            <strong>Transf�rer un joueur</strong><br>
                            Vous pouvez dans ce menu transf�rer un joueur � votre �quipe
                        </p>
                    </div>
                </div>
            </article>
        </div>
    </a>

    <a href="${pageContext.request.contextPath}/AccesEntraineur?action=afficherSupprimerContrat">
        <div class="box">
            <article class="media">
                <div class="media-left">
                    <figure class="image is-64x64">
                        <img src="${pageContext.request.contextPath}/img/destoyedContract.jpg" alt="Image">
                    </figure>
                </div>
                <div class="media-content">
                    <div class="content">
                        <p>
                            <strong>Supprimer un joueur</strong><br>
                            Vous pouvez dans ce menu supprimer un joueur
                        </p>
                    </div>
                </div>
            </article>
        </div>
    </a>

    <a href="${pageContext.request.contextPath}/AccesEntraineur?action=affecterJoueurEffectif">
        <div class="box">
            <article class="media">
                <div class="media-left">
                    <figure class="image is-64x64">
                        <img src="${pageContext.request.contextPath}/img/strategy.png" alt="Image">
                    </figure>
                </div>
                <div class="media-content">
                    <div class="content">
                        <p>
                            <strong>Affecter des joueurs � un match</strong><br>
                            Vous pouvez dans ce menu g�rer vos effectifs pour vos match
                        </p>
                    </div>
                </div>
            </article>
        </div>
    </a>
    <% } %>
    <form method="post" action="${pageContext.request.contextPath}/AccesEntraineur">                     
        <input value="deconnexion" name="action" type="hidden">
        <input style="margin-top: 1rem" class="button is-large is-danger" value="D�connexion" type="submit">
    </form> 

</section>
<%@ include file="../footer.jsp"%>
</body>
</html>