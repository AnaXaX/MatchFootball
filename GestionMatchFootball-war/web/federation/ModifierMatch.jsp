<%@page import="entities.Equipe"%>
<%@page import="entities.Arbitre"%>
<%@page import="entities.MatchFoot"%>
<%@page import="java.util.List"%>
<%@ include file="/federation/RedirectionFederation.jsp" %>
<jsp:useBean id="matchAModifier" scope="request" class="entities.MatchFoot"></jsp:useBean>
<style>
<jsp:include page="../css/flatpickr.min.css"/> 
</style>
<%@ include file="../header.jsp"%>
<% MatchFoot match = matchAModifier; %>
<section class="section" style="margin-top:2rem">
    <form method="post" action="${pageContext.request.contextPath}/AccesFederation">

        <div class="field">
            <div class="control">
                <div class="select is-large is-fullwidth has-text-centered">
                    <input value="<%="Arbitre : "+matchAModifier.getArbitre().getNom()+" "+matchAModifier.getArbitre().getPrenom()%>" class="input has-text-info is-fullwidth is-large has-text-centered" type="text" readonly="readonly">
                </div>
            </div>
        </div>

        <div class="field">
            <div class="control">
                <div class="select is-large is-fullwidth has-text-centered">
                    <input value="<%="Equipe receveuse : "+matchAModifier.getEquipeReceveuse().getNom()%>" class="input has-text-info is-fullwidth is-large has-text-centered" type="text" readonly="readonly">
                </div>
            </div>
        </div>

        <div class="field">
            <div class="control">
                <div class="select is-large is-fullwidth has-text-centered">
                    <input value="<%="Equipe receveuse : "+matchAModifier.getEquipeInvitee().getNom()%>" class="input has-text-info is-fullwidth is-large has-text-centered" type="text" readonly="readonly">
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

        <input value="doModifierMatch" name="action" type="hidden">
        <input value="<%=match.getId()%>" name="match" type="hidden">
        <input style="margin-top: 1rem" class="button is-large is-success" value="Modifier le match" type="submit">
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
    maxTime: "22:00",
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