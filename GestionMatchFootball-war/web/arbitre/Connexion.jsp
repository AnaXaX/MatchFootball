<%@ include file="../header.jsp"%>
        <section class="section" style="margin-top:2rem">
            <form method="get" action="${pageContext.request.contextPath}/AccesArbitre">
            <div class="field">
                <p class="control has-icons-left">
                    <input name="loginArbitre" class="input is-rounded has-text-info is-fullwidth is-large has-text-centered" type="text" placeholder="Login Arbitre">         
                    <span class="icon is-small is-left">
                        <i class="fas fa-user"></i>
                    </span>
                </p>
            </div>
              <div class="field">
                <p class="control has-icons-left">
                    <input name="mdpArbitre" class="input is-rounded has-text-info is-fullwidth is-large has-text-centered" type="password" placeholder="Mot de Passe Arbitre">         
                    <span class="icon is-small is-left">
                        <i class="fas fa-key"></i>
                    </span>
                </p>
            </div>
                <input value="authentification" name="action" type="hidden">
                <input style="margin-top: 1rem" class="button is-large is-warning" value="Connexion" type="submit">
            </form>          
        </section>
<%@ include file="../footer.jsp"%>
