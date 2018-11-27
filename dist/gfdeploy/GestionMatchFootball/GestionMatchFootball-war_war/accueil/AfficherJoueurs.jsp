<%@page import="entities.Joueur"%>
<%@page import="java.util.Collection"%>

<jsp:useBean id="listJoueurs" scope="request" class="java.util.Collection"></jsp:useBean>
<%@ include file="../header.jsp"%>

<%            String nomEquipe = (String) request.getAttribute("nomEquipe");
%>
<section class="section" style="margin-top:2rem">
  
    
                    <%
                        Collection<Joueur> joueurs = listJoueurs;
                        System.out.println(joueurs);
                       
                    %>         

              



    <h1 class="title">Liste des joueurs</h1>
    <table class="table is-striped is-hoverable is-fullwidth">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Prenom</th>
        </tr>
        <%
            for (Joueur j : joueurs) {
        %>         
        <tr>
            <td><%=j.getId()%></td>
            <td><%=j.getNom()%></td>
            <td><%=j.getPrenom()%></td>
        </tr>
        <%}%>
    </table>     

    <div class="columns is-multiline">
        <%  int i =0;
            for (Joueur j : joueurs) {
                
        %> 
        <div class="column is-one-quarter-desktop ">
            <div class="card">
<div class="card-image">
    <figure class="image is-4by3">
      <img src="https://randomuser.me/api/portraits/men/<%=i%>.jpg" alt="Placeholder image">
    </figure>
  </div>
                `<div class="card">
                    <div class="card-content">
                        <p class="title">
                            <%=j.getId()%>&nbsp;<%=j.getNom()%>&nbsp;<%=j.getPrenom()%>
                        </p>
                        <p class="subtitle"></p>
                    </div>
                </div>`
            </div>

        </div>
        <%i++;}%>

    </div>


    <!-- <input style="margin-top: 1rem" class="button is-large is-success" value="Afficher les joueurs de l'�quipe" type="submit"> -->
</section>
<%@ include file="../footer.jsp"%>
