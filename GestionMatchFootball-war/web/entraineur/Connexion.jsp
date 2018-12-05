<%@ include file="../header.jsp"%>
<section class="section" style="margin-top:2rem">
    <form method="post" action="${pageContext.request.contextPath}/AccesEntraineur">
        <div class="field">
            <p class="control has-icons-left">
                <input name="login" class="input has-text-info is-fullwidth is-large has-text-centered" type="text" placeholder="Login de l'entraineur">
                <span class="icon is-small is-left">
                    <i class="fas fa-user"></i>
                </span>
            </p>
        </div>
        <div class="field">
            <p class="control has-icons-left">
                <input name="password" class="input has-text-info is-fullwidth is-large has-text-centered" type="password" placeholder="Mot de Passe de l'entraineur">         
                <span class="icon is-small is-left"> 
                    <i class="fas fa-lock"></i>
                </span>
            </p>
        </div>
        <input value="Connexion" name="action" type="hidden">
        <input style="margin-top: 1rem" class="button is-large is-success" value="Connexion" type="submit">
    </form>     
</section>
<%@ include file="../footer.jsp"%>