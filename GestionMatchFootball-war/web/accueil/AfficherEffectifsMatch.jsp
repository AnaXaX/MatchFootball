<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collection"%>
<%@page import="entities.ReceveuseInvitee"%>
<%@page import="entities.MatchFoot"%>
<%@page import="entities.Equipe"%>
<%@page import="entities.Effectif"%>
<%@page import="entities.Joueur"%>
<%@page import="java.util.List"%>
<%@page import="java.lang.String"%>
<jsp:useBean id="effectifsMatch" scope="request" class="java.util.List"></jsp:useBean>
<jsp:useBean id="nomEquipeReceveuse" scope="request" class="java.lang.String"></jsp:useBean>
<jsp:useBean id="nomEquipeInvitee" scope="request" class="java.lang.String"></jsp:useBean>
<%@ include file="../header.jsp"%>

<section class="section" style="margin-top:2rem">

    <%        
        List<Effectif> effectifs = effectifsMatch;
        String ner = nomEquipeReceveuse;
        String nei = nomEquipeInvitee;
        List<Joueur> ei = new ArrayList<Joueur>();
        List<Joueur> er = new ArrayList<Joueur>();
        for (Effectif e : effectifs ){
            if (e.getReceveuseInvitee()==ReceveuseInvitee.I){
                ei=e.getListeJoueurs();
            } else if (e.getReceveuseInvitee()==ReceveuseInvitee.R){
                er=e.getListeJoueurs();
            }
        }
    %>         

    <div class="columns">
	<div class="column is-half">
            <h1 class="title"><%=nei%></h1>
  	    <!-- Table checking -->
            <table class="table is-striped is-hoverable is-fullwidth">
                <tr>
                    <th class="has-text-centered">Joueurs</th>
                </tr>

        <%            
            for (Joueur j : ei) {
            
        %>         
                <tr >
                    <td class="has-text-centered"><%=j.getNom()+' '+j.getPrenom()%></td>
                </tr>
        <%}%>
    </table>  
    </div>
    <div class="column is-half">
  	    <h1 class="title"><%=ner%></h1>

    <!-- Table checking -->
    <table class="table is-striped is-hoverable is-fullwidth">
    <tr>
      <th class="has-text-centered">Joueurs</th>
    </tr>

        <%            
            for (Joueur j : er) {
            
        %>         
        <tr >
            <td class="has-text-centered"><%=j.getNom()+' '+j.getPrenom()%></td>
            
        </tr>
        <%}%>
    </table> 
    </div>
    </div>
    
    

   


    


</section>
<%@ include file="../footer.jsp"%>
</body>
</html>