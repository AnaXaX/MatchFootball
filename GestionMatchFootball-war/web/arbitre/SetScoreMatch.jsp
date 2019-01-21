<%@page import="entities.MatchFoot"%>

<%@ include file="/arbitre/RedirectionArbitre.jsp" %>

<%@ include file="../header.jsp"%>


<section class="section" style="margin-top:2rem">
    <%        MatchFoot match = (MatchFoot) request.getAttribute("match");
        //System.out.println(joueurs);
%>         
    <h1 class="title">Modifier score du match :</h1>
    <form method="post" action="${pageContext.request.contextPath}/AccesArbitre">
        
        <div class="field">
            <p class="control has-icons-left">
                <input name="scoreEquipeReceveuse" class="input has-text-info is-fullwidth is-large has-text-centered" type="text" placeholder="Score Equipe Receveuse : <%=match.getEquipeReceveuse().getNom()%>" value="<%if(match.getScoreEquipeReceveuse()!=-1){out.print(match.getScoreEquipeReceveuse());}%>">         
                <span class="icon is-small is-left">
                    <i class="far fa-calendar-alt"></i>
                </span>
            </p>
        </div>
                       
        <div class="field">
            <p class="control has-icons-left">
                <input name="scoreEquipeInvitee" class="input has-text-info is-fullwidth is-large has-text-centered" type="text" placeholder="Score Equipe Inviteee : <%=match.getEquipeInvitee().getNom()%>" value="<%if(match.getScoreEquipeInvitee()!=-1){out.print(match.getScoreEquipeInvitee());}%>">         
                <span class="icon is-small is-left">
                    <i class="far fa-calendar-alt"></i>
                </span>
            </p>
        </div>

        <input value="setScoreMatch" name="action" type="hidden">
        <input value="<%=match.getId()%>" name="idMatch" type="hidden">
        <input style="margin-top: 1rem" class="button is-large is-success" value="Changer le score de ce match" type="submit">
    </form>
</section>
<%@ include file="../footer.jsp"%>
</body>
</html>