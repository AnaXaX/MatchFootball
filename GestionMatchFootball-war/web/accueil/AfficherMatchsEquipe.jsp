<%@page import="entities.MatchFoot"%>
<%@page import="entities.Equipe"%>
<%@page import="java.util.List"%>
<jsp:useBean id="matchsEquipe" scope="request" class="java.util.List"></jsp:useBean>
<%@ include file="../header.jsp"%>

<section class="section" style="margin-top:2rem">

    <%        
        List<MatchFoot> matchs = matchsEquipe;
    %>         

    <h1 class="title">Matchs de l'équipe</h1>

    <!-- Table checking -->
    <table class="table is-striped is-hoverable is-fullwidth">
    <tr>
      <th class="has-text-centered">Arbitre</th>
      <th class="has-text-centered">Equipe Invitée</th>
      <th class="has-text-centered">Equipe receveuse</th>
      <th class="has-text-centered">Buts equipe invitee</th>
      <th class="has-text-centered">Buts equipe receveuse</th>
    </tr>

        <%            
            for (MatchFoot m : matchs) {
            String sei;
            String ser;
            if(m.getScoreEquipeInvitee()<0){
                sei="-";
            } else {
                sei=""+m.getScoreEquipeInvitee();
            }
            if(m.getScoreEquipeReceveuse()<0){
                ser="-";
            } else {
                ser=""+m.getScoreEquipeReceveuse();
            }
        %>         
        <tr >
            <td class="has-text-centered"><%=m.getArbitre().getNom()+' '+m.getArbitre().getNom()%></td>
            <td class="has-text-centered"><%=m.getEquipeInvitee().getNom()%></td>
            <td class="has-text-centered"><%=m.getEquipeReceveuse().getNom()%></td>
            <td class="has-text-centered"><%=sei%></td>
            <td class="has-text-centered"><%=ser%></td>
            
        </tr>
        <%}%>
    </table>     
    </section>
<%@ include file="../footer.jsp"%>
</body>
</html>