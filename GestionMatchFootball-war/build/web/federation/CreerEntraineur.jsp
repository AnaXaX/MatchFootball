<%@ include file="/federation/RedirectionFederation.jsp" %>
<%@ include file="../header.jsp"%>
<section class="section" style="margin-top:2rem">
    <form method="post" action="${pageContext.request.contextPath}/AccesFederation">
        <div class="field">
            <p class="control has-icons-left">
                <input name="nom" class="input has-text-info is-fullwidth is-large has-text-centered" type="text" placeholder="Nom de l'entraineur">
                <span class="icon is-small is-left">
                    <i class="fas fa-user"></i>
                </span>
            </p>
        </div>
        
        <div class="field">
            <p class="control has-icons-left">
                <input name="prenom" class="input has-text-info is-fullwidth is-large has-text-centered" type="text" placeholder="Prénom de l'entraineur">         
                <span class="icon is-small is-left">
                    <i class="far fa-user"></i>
                </span>
            </p>
        </div>
        <div class="field">
            <p class="control has-icons-left">
                <input name="login" class="input has-text-info is-fullwidth is-large has-text-centered" type="text" placeholder="Login de l'entraineur">         
                <span class="icon is-small is-left">
                    <i class="fas fa-sign-in-alt"></i>
                </span>
            </p>
        </div>
        <div class="field">
            <p class="control has-icons-left">
                <input name="mdp" class="input has-text-info is-fullwidth is-large has-text-centered" type="password" placeholder="Mot de Passe l'entraineur">         
                <span class="icon is-small is-left">
                    <i class="fas fa-lock"></i>
                </span>
            </p>
        </div>
        <input value="creerEntraineur" name="action" type="hidden">
        <input style="margin-top: 1rem" class="button is-large is-success" value="Créer l'entraineur" type="submit">
    </form>     
</section>
<%@ include file="../footer.jsp"%>
</body>
</html>