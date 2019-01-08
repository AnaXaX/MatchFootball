<%@page import="entities.Equipe"%>
<%@page import="entities.Entraineur"%>
<%@page import="java.util.List"%>
<%@ include file="/federation/RedirectionFederation.jsp" %>

<jsp:useBean id="listEntraineurs" scope="request" class="java.util.List"></jsp:useBean>

<%@ include file="../header.jsp"%>
<section class="section" style="margin-top:2rem">
    <%        
        Equipe equipe = (Equipe) request.getAttribute("equipe");
        List<Entraineur> entraineurs = listEntraineurs;
    %>
    <h1 class="title">Equipe : <%=equipe.getNom()%>, <% if (equipe.getEntraineur() != null) {%>Entraineur Actuel : <%=equipe.getEntraineur().getNom() + " " + equipe.getEntraineur().getPrenom()%><%}%></h1>
    <form method="post" action="${pageContext.request.contextPath}/AccesFederation">

        <div class="field">
            <p class="control has-icons-left">
                <input name="nom" class="input has-text-info is-fullwidth is-large has-text-centered" type="text" value="<%=equipe.getNom()%>" placeholder="Nom de l'équipe">
                <span class="icon is-small is-left">
                    <i class="fas fa-flag-checkered"></i>
                </span>
            </p>
        </div>

        <div class="field">
            <div class="control has-icons-left">
                <div class="select is-large is-fullwidth has-text-centered">
                    <select name="entraineurID" class="has-text-centered is-centered" >
                        <%
                            for (Entraineur e : entraineurs) {
                                if (equipe.getEntraineur() != null && e.getId() == equipe.getEntraineur().getId()) {%>                                                                                                                                   
                        <option selected value="<%=e.getId()%>"><%=e.getNom()%>&nbsp;<%=e.getPrenom()%></option>
                        <%} else {%>
                        <option  value="<%=e.getId()%>"><%=e.getNom()%>&nbsp;<%=e.getPrenom()%></option>
                        <%}
                        }%>
                    </select>   
                    <span class="icon is-small is-left">
                        <i class="fas fa-user-secret"></i>
                    </span>
                </div>
            </div>
        </div>
        <input value="modifierEquipe" name="action" type="hidden">
        <input value="<%=equipe.getId()%>" name="idEquipe" type="hidden">
        <input style="margin-top: 1rem" class="button is-large is-warning" value="Modifier l'équipe" type="submit">
    </form>-
</section>
<%@ include file="../footer.jsp"%>
</body>
</html>