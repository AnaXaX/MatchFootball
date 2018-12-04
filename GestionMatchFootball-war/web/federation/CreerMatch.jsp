
<!-- Forcer la redirection vers le menu si le token n'existe pas , pour éviter les petits malins d'accéder à cette interface-->
<%
    RequestDispatcher rd = request.getRequestDispatcher("../Menu.jsp");
    if (session.getAttribute("sessionFederation") == null) {
        rd.forward(request, response);
    }
%>
<%@ include file="../header.jsp"%>

<section class="section" style="margin-top:2rem">
    <form method="get" action="${pageContext.request.contextPath}/AccesFederation">
        <div class="field">
            <p class="control has-icons-left">
                <input name="date" class="input has-text-info is-fullwidth is-large has-text-centered" type="date" placeholder="Date et Heure">         
                <span class="icon is-small is-left">
                    <i class="far fa-user"></i>
                </span>
            </p>
        </div>
        <div class="field">
            <p class="control has-icons-left">
                <input name="equiperecevant" class="input has-text-info is-fullwidth is-large has-text-centered" type="text" placeholder="Nom Equipe Recevant">
                <span class="icon is-small is-left">
                    <i class="fas fa-user"></i>
                </span>
            </p>
        </div>
        <div class="field">
            <p class="control has-icons-left">
                <input name="equipevisiteuse" class="input has-text-info is-fullwidth is-large has-text-centered" type="text" placeholder="Nom Equipe Visiteuse">
                <span class="icon is-small is-left">
                    <i class="fas fa-clock"></i>
                </span>
            </p>
        </div>
        <div class="field">
            <p class="control has-icons-left">
                <input name="prenom" class="input has-text-info is-fullwidth is-large has-text-centered" type="text" placeholder="Arbitre">         
                <span class="icon is-small is-left">
                    <i class="far fa-user"></i>
                </span>
            </p>
        </div>
        <input value="creerMatch" name="action" type="hidden">
        <input style="margin-top: 1rem" class="button is-large is-success" value="Créer le match" type="submit">
    </form>          
</section>
<%@ include file="../footer.jsp"%>
