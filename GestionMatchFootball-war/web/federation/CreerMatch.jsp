<%@page import="entities.Equipe"%>
<%@page import="entities.Arbitre"%>
<%@page import="java.util.List"%>
<%@ include file="/federation/RedirectionFederation.jsp" %>
<jsp:useBean id="listEquipes" scope="request" class="java.util.List"></jsp:useBean>
<jsp:useBean id="listArbitres" scope="request" class="java.util.List"></jsp:useBean>
<style>
<jsp:include page="../css/flatpickr.min.css"/> 
</style>
<%@ include file="../header.jsp"%>

<section class="section" style="margin-top:2rem">
    <form method="post" action="${pageContext.request.contextPath}/AccesFederation">

        <div class="field">
            <div class="control has-icons-left">
                <div class="select is-large is-fullwidth has-text-centered">
                    <select name="arbitreID" class="has-text-centered is-centered" >
                        <option value="" disabled selected>Choisir l'arbitre</option>
                        <%                            List<Arbitre> arbitres = listArbitres;
                            for (Arbitre a : arbitres) {
                        %>
                        <option  value="<%=a.getId()%>"><%=a.getNom()%>&nbsp;<%=a.getPrenom()%></option>
                        <%}%>
                    </select>   
                    <span class="icon is-small is-left">
                        <i class="fas fa-user-secret"></i>
                    </span>
                </div>
            </div>
        </div>

        <div class="field">
            <div class="control has-icons-left">
                <div class="select is-large is-fullwidth has-text-centered">
                    <select name="equipeReceveuse" class="has-text-centered is-centered" >
                        <option value="" disabled selected>Choisir l'équipe Receveuse</option>
                        <%
                            List<Equipe> equipes = listEquipes;
                            for (Equipe e : equipes) {
                        %>
                        <option  value="<%=e.getId()%>"><%=e.getNom()%></option>
                        <%}%>
                    </select>   
                    <span class="icon is-small is-left">
                        <i class="fas fa-futbol"></i>
                    </span>
                </div>
            </div>
        </div>

        <div class="field">
            <div class="control has-icons-left">
                <div class="select is-large is-fullwidth has-text-centered">
                    <select name="equipeInvitee" class="has-text-centered is-centered" >
                        <option value="" disabled selected>Choisir l'équipe Invitée</option>
                        <%
                            for (Equipe e : equipes) {
                        %>
                        <option  value="<%=e.getId()%>"><%=e.getNom()%></option>
                        <%}%>
                    </select>   
                    <span class="icon is-small is-left">
                        <i class="far fa-futbol"></i>
                    </span>
                </div>
            </div>
        </div>                   
                    
        <div class="field">
            <p class="control has-icons-left">
                <input name="dateMatch" class="input has-text-info is-fullwidth is-large has-text-centered flatpickr flatpickr-input" type="text" placeholder="Choisir la date du match" data-id="datetime" readonly="readonly">         
                <span class="icon is-small is-left">
                    <i class="far fa-calendar-alt"></i>
                </span>
            </p>
        </div>

        


        <input value="creerMatch" name="action" type="hidden">
        <input style="margin-top: 1rem" class="button is-large is-success" value="Créer le match" type="submit">
    </form>          
</section>
<%@ include file="../footer.jsp"%>
<script src="${pageContext.request.contextPath}/js/flatpickr.min.js"></script>
<script src="${pageContext.request.contextPath}/js/flatpickr.fr.js"></script>
<script>
$( '.flatpickr' ).flatpickr({
    locale: "fr",
    enableTime: true,
    dateFormat: "Y-m-d H:i:s",
    minDate: "today", /*On peut pas créer un match qui va se passer hier */
    minTime: "08:00", /*Ici le javascript permet de limiter la création d'un match a des heures normales*/
    maxTime: "23:00",
    altInput: true,
    altFormat: "j F, Y à H:i"
    //time_24hr: true
});
</script>
<script>
/*Script qui change les options de Select, si une option est séléctionnée */
$(document).ready(function(){
    $('select').on('change', function(event) {
    var prevValue = $(this).data('previous');
    $('select').not(this).find('option[value="'+prevValue+'"]').show();    
    var value = $(this).val();
    $(this).data('previous',value); 
    $('select').not(this).find('option[value="'+value+'"]').hide();
    });
});
</script>
</body>
</html>