<%@page import="entities.MatchFoot"%>
<%@page import="entities.Joueur"%>

<%@ include file="/arbitre/RedirectionArbitre.jsp" %>

<%@ include file="../header.jsp"%>


<section class="section" style="margin-top:2rem">
    <%        MatchFoot match = (MatchFoot) request.getAttribute("match");
        Joueur joueur = (Joueur) request.getAttribute("joueur");
        //System.out.println(joueurs);
    %>         
    <form method="post" action="${pageContext.request.contextPath}/AccesArbitre">
        <div class="field">
            <div class="control has-icons-left">
                <div class="select is-large is-fullwidth has-text-centered">
                    <select name="cartonJaune" class="has-text-centered is-centered" >
                        <option value="" disabled selected>Choisir si Carton Jaune</option>              
                        <option  value="false">non</option>
                        <option  value="true">oui</option>

                    </select>   
                    <span class="icon is-small is-left">
                        <i class="fas fa-user-secret"></i>
                    </span>
                </div>
            </div>
        </div>

        <div class="field">
            <div class="control has-icons-left">
                <div class="select is-large is-fullwidth has-text-centered">
                    <select name="cartonRouge" class="has-text-centered is-centered" >
                        <option value="" disabled selected>Choisir si Carton Rouge</option>       
                        <option  value="false">non</option>
                        <option  value="true">oui</option>
                    </select>   
                    <span class="icon is-small is-left">
                        <i class="fas fa-user-secret"></i>
                    </span>
                </div>
            </div>
        </div>

        <input value="SetFauteJoueurMatch" name="action" type="hidden">
        <input value="<%=match.getId()%>" name="idMatch" type="hidden">
        <input value="<%=joueur.getId()%>" name="idJoueur" type="hidden">
        <input style="margin-top: 1rem" class="button is-large is-success" value="saisir faute de ce joueur" type="submit">
    </form>
</section>
<%@ include file="../footer.jsp"%>
</body>
</html>