<!-- Forcer la redirection vers le menu si le token n'existe pas , pour éviter les petits malins d'accéder à cette vue par URL-->
<%
    RequestDispatcher rd = request.getRequestDispatcher("/Connexion.jsp");
    if (session.getAttribute("sessionFederation") == null) {
        rd.forward(request, response);
    }
%>
<%@ include file="../header.jsp"%>
<section class="section" style="margin-top:3rem">
    <div class="columns is-variable" style="margin-top:30vh">
        <div class="column is-one-third">   
            <a href="${pageContext.request.contextPath}/federation/CreerEntraineur.jsp" class="has-text-success is-large is-fullwidth">
                <span class="icon is-large">
                    <i class="fas fa-6x fa-user-plus"></i>
                </span>
                <div style="margin: 1rem 0 1rem" class="title has-text-success">Créer un entraineur</div>
            </a> 
        </div> 

        <div class="column is-one-third">           
            <a class="is-large is-fullwidth" href="${pageContext.request.contextPath}/AccesFederation?action=afficherListEntraineursModifier" >
                <span class="icon is-large">
                    <i class="fas fa-6x fa-user-edit"></i>
                </span>
            </a>
            <div style="margin: 1rem 0 1rem" class="title has-text-link">Modifier un entraineur</div>

        </div>        

        <div class="column is-one-third">        
            <a class=" is-large is-fullwidth has-text-danger" href="${pageContext.request.contextPath}/AccesFederation?action=afficherListEntraineursSupprimer" >
                <span class="icon is-large ">
                    <i class="fas fa-6x fa-user-times"></i>
                </span>
                <div style="margin: 1rem 0 1rem" class="title has-text-danger">Supprimer un ou des entraineurs</div>
            </a>  
        </div>        
    </div>
</section>
<%@ include file="../footer.jsp"%>
</body>
</html>