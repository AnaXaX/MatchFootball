<%@page import="entities.Equipe"%>
<%@page import="java.util.List"%>
<jsp:useBean id="classement" scope="request" class="java.util.List"></jsp:useBean>
<%@ include file="../header.jsp"%>

<section class="section" style="margin-top:2rem">

    <%        
        List<Equipe> equipes = classement;
    %>         

    <h1 class="title">Classement des équipes</h1>

    <!-- Table checking -->
    <table class="table is-striped is-hoverable is-fullwidth">
    <tr>
      <th class="has-text-centered">Position</th>
      <th class="has-text-centered">Team</th>
      <th class="has-text-centered">Nbr matchs jouées</th>
      <th class="has-text-centered">Gagné</th>
      <th class="has-text-centered">Égalité</th>
      <th class="has-text-centered">Perdues</th>
      <th class="has-text-centered">Buts marqués</th>
      <th class="has-text-centered">Buts reçus</th>
      <th class="has-text-centered">Différence buts</th>
      <th class="has-text-centered">Points</th>
    </tr>

        <%            
            int i = 0, dernierPoints = equipes.get(0).getPoints()+1;
            for (Equipe e : equipes) {
                if(e.getPoints()<dernierPoints){
                    i++;
                    dernierPoints=e.getPoints();
                }
        %>         
        <tr >
            <td class="has-text-centered"><%=i%></td>
            <td class="has-text-centered"><%=e.getNom()%></td>
            <td class="has-text-centered"><%=e.matchsJoues()%></td>
            <td class="has-text-centered"><%=e.matchsGagnes()%></td>
            <td class="has-text-centered"><%=e.matchsEgalites()%></td>
            <td class="has-text-centered"><%=e.matchsPerdus()%></td>
            <td class="has-text-centered"><%=e.butsMarques()%></td>
            <td class="has-text-centered"><%=e.butsRecus()%></td>
            <td class="has-text-centered"><%=e.butsMarques()-e.butsRecus()%></td>
            <td class="has-text-centered"><%=e.getPoints()%></td>
        </tr>
        <%}%>
    </table>     
    </section>
<%@ include file="../footer.jsp"%>
</body>
</html>