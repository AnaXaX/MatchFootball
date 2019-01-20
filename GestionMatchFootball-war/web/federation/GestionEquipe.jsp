<%@ include file="/federation/RedirectionFederation.jsp" %>

<%@ include file="../header.jsp"%>
<section class="section" style="margin-top:3rem">
    <div class="columns is-variable" style="margin-top:30vh">
        <div class="column is-half">   
            <a href="${pageContext.request.contextPath}/AccesFederation?action=afficherEntraineur" class="has-text-success is-large is-fullwidth">
                <span class="icon is-large">
                    <i class="fas fa-6x fa-folder-plus"></i>
                </span>
                <div style="margin: 1rem 0 1rem" class="title has-text-success">Cr�er une �quipe</div>
            </a> 
        </div> 

        <div class="column is-half">           
            <a class="is-large is-fullwidth" href="${pageContext.request.contextPath}/AccesFederation?action=afficherEquipesModif" >
                <span class="icon is-large">
                    <i class="fas fa-6x fa-folder-open"></i>
                </span>
                <div style="margin: 1rem 0 1rem" class="title has-text-link">Modifier une �quipe</div>
            </a>
        </div>        
<%--
        <div class="column is-one-third">        
            <a class=" is-large is-fullwidth has-text-danger" href="${pageContext.request.contextPath}/AccesFederation?action=afficherEquipesSupp" >
                <span class="icon is-large ">
                    <i class="fas fa-6x fa-folder-minus"></i>
                </span>
                <div style="margin: 1rem 0 1rem" class="title has-text-danger">Supprimer une ou des �quipes</div>
            </a>  
        </div>        
    </div>
--%>
</section>
<%@ include file="../footer.jsp"%>
</body>
</html>