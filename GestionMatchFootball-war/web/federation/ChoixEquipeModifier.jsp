<%@page import="java.util.Random"%>
<%@page import="entities.Equipe"%>
<%@page import="java.util.List"%>
<%@ include file="/federation/RedirectionFederation.jsp"%>

<jsp:useBean id="listEquipes" scope="request" class="java.util.List"></jsp:useBean>
<style>
    <jsp:include page="../css/bulma-checkradio.min.css"/> // rajout
</style>
<%@ include file="../header.jsp"%>

<section class="section" style="margin-top:2rem">
    <%        
        List<Equipe> equipes = listEquipes;
    %>            

    <h1 class="title">Liste des equipes</h1>

    <form method="post" action="${pageContext.request.contextPath}/AccesFederation">

        <div class="columns is-multiline">
            <%  int i = 0;
                Random random = new Random();
                for (Equipe e : equipes) {
                int nextInt = random.nextInt(0xffffff + 1); // Generates a random number between 0x10 and 0x20
                String s = String.format("%06x", nextInt);/*Hexa for background color*/
            %> 
            <div class="column is-one-quarter-desktop is-one-third-tablet">
                <div class="card">
                    <div class="card-image">
                        <figure class="image is-4by3">
                            <img src="https://ui-avatars.com/api/?background=<%=s%>&size=256&length=3&name=<%=e.getNom()%>" alt="<%=e.getNom()%>">
                        </figure>
                    </div>
                    <div class="card">
                        <div class="card-content">
                            <p class="title" style="margin-top: 1rem"><%=e.getNom()%></p>
                            <p class="subtitle" style="margin-top: 1rem">
                                <input class="is-checkradio" id="radio<%=i%>" type="radio" name="idEquipe" value="<%=e.getId()%>">
                                <label for="radio<%=i%>">Modifier cette Equipe</label>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
            <%i++;
                }%>
        </div>
        <input value="afficherEquipeModifier" name="action" type="hidden">
        <input style="margin-top: 1rem" class="button is-large is-warning" value="Modifier cette équipe" type="submit">
    </form>


    <!-- <input style="margin-top: 1rem" class="button is-large is-success" value="Afficher les joueurs de l'équipe" type="submit"> -->
</section>
<%@ include file="../footer.jsp"%>
</body>
</html>