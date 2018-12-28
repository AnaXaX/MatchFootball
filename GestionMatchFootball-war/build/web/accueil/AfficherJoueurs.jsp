<%@page import="entities.Joueur"%>
<%@page import="java.util.Collection"%>

<jsp:useBean id="listJoueurs" scope="request" class="java.util.Collection"></jsp:useBean>
<%@ include file="../header.jsp"%>


<section class="section" style="margin-top:2rem">
    <%                    
        String nomEquipe = (String) request.getAttribute("nomEquipe");
        String nomEntraineur = (String) request.getAttribute("nomEntraineur");
        Collection<Joueur> joueurs = listJoueurs;
    %>         

    <p class="title"><%=nomEquipe%></p>
    <p class="subtitle"><%=nomEntraineur%></p>

    <div class="columns is-multiline">
        <%  int i = 0;
            for (Joueur j : joueurs) {
        %> 
        <div class="column is-one-quarter-desktop is-one-third-tablet is-half-mobile ">
            <div class="card">
                <div class="card-image">
                    <figure class="image is-4by3">
                        <img src="https://api.adorable.io/avatars/285/<%=j.getId()%>.jpg" alt="Placeholder image">
                    </figure>
                </div>
                <div class="card-content">
                    <p class="title">
                        <%=j.getNom()%>&nbsp;<%=j.getPrenom()%>
                    </p>
                </div>`
            </div>
        </div>
        <%i++;
            }%>
    </div>
    <!-- <input style="margin-top: 1rem" class="button is-large is-success" value="Afficher les joueurs de l'équipe" type="submit"> -->
</section>
<%@ include file="../footer.jsp"%>
</body>
</html>