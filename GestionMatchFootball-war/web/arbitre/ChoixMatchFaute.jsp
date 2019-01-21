<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entities.MatchFoot"%>
<%@page import="java.util.Collection"%>
<%@ include file="/arbitre/RedirectionArbitre.jsp" %>

<jsp:useBean id="listMatchs" scope="request" class="java.util.Collection"></jsp:useBean>
    <style>
    <jsp:include page="../css/bulma-checkradio.min.css"/> // rajout css for beautiful checkbox
</style>
<%@ include file="../header.jsp"%>

<section class="section" style="margin-top:2rem">
    <%        Collection<MatchFoot> matchs = listMatchs;
              //System.out.println(joueurs);
    %>         
    <h1 class="title">Liste des matchs qui ont commencé</h1>
    <form method="post" action="${pageContext.request.contextPath}/AccesArbitre">
        
        <div class="columns is-multiline">
            <%  int i = 0;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy à HH:mm");
                for (MatchFoot m : matchs) {
            %> 
            <div class="column is-one-quarter-desktop is-one-third-tablet">
                    <div class="card">
                        <div class="card-content">
                            <p class="title" style="margin-top: 1rem"><%=m.getEquipeInvitee().getNom()%></p>
                            <p class="subtitle" style="margin-top: 1rem">VS</p>
                            <p class="title" style="margin-top: 1rem"><%=m.getEquipeReceveuse().getNom()%></p>
                            <p class="subtitle" style="margin-top: 1rem">Arbitré par : <%=m.getArbitre().getNom()+" "+m.getArbitre().getPrenom()%></p>
                            <p class="subtitle" style="margin-top: 1rem"><%=dateFormat.format(m.getDate())%></p>

                                
                                <input class="is-checkradio" id="radio<%=i%>" type="radio" name="idMatch" value="<%=m.getId()%>">
                                <label for="radio<%=i%>">Saisir un match</label>
                            </p>
                        </div>
                </div>
            </div>
            <%i++;
                }%>
        </div>
        <input value="ModifierFauteMatch" name="action" type="hidden">
        <input style="margin-top: 1rem" class="button is-large is-success" value="Changer le score de ce match" type="submit">
    </form>
</section>
    <%@ include file="../footer.jsp"%>
</body>
</html>