<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entities.MatchFoot"%>
<%@page import="java.util.Collection"%>

<jsp:useBean id="listMatchs" scope="request" class="java.util.Collection"></jsp:useBean>

<%@ include file="../header.jsp"%>

<section class="section" style="margin-top:2rem">
    <%        
        Collection<MatchFoot> matchs = listMatchs;
    %>         
    <h1 class="title">Liste des matchs à venir</h1>

        <div class="columns is-multiline">
            <%  
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy à HH:mm");
                for (MatchFoot m : matchs) {
            %> 
            <div class="column is-one-quarter-desktop is-one-third-tablet">
                <div class="card">
                    <div class="card-content">
                        <p class="title" style="margin-top: 1rem"><%=m.getEquipeInvitee().getNom()%></p>
                        <p class="subtitle" style="margin-top: 1rem">VS</p>
                        <p class="title" style="margin-top: 1rem"><%=m.getEquipeReceveuse().getNom()%></p>
                        <p class="subtitle" style="margin-top: 1rem">Arbitré par : <%=m.getArbitre().getNom() + " " + m.getArbitre().getPrenom()%></p>
                        <p class="subtitle" style="margin-top: 1rem"><%=dateFormat.format(m.getDate())%></p>
                        <p class="subtitle" style="margin-top: 1rem"><% if(m.isPlayed()){out.print(m.getScoreEquipeInvitee()+" : "+m.getScoreEquipeReceveuse());
                        } %></p>

                        </p>
                    </div>
                </div>
            </div>
            <%}%>

        </div>
 
</section>
<%@ include file="../footer.jsp"%>
</body>
</html>