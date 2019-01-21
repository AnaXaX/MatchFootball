<style>
<jsp:include page="../css/flatpickr.min.css"/> 
</style>
<%@ include file="../header.jsp"%>

<section class="section" style="margin-top:2rem">
    <form method="post" action="${pageContext.request.contextPath}/AccesCommun">         
                    
        <div class="field">
            <p class="control has-icons-left">
                <input name="dateMatch" class="input has-text-info is-fullwidth is-large has-text-centered flatpickr flatpickr-input" type="text" placeholder="Choisir un jour ou un intervalle pour les dates des matchs" data-id="datetime" readonly="readonly">         
                <span class="icon is-small is-left">
                    <i class="far fa-calendar-alt"></i>
                </span>
            </p>
        </div>

        <input value="chercherMatchs" name="action" type="hidden">
        <input style="margin-top: 1rem" class="button is-large is-success" value="Chercher les matchs" type="submit">
    </form>          
</section>
<%@ include file="../footer.jsp"%>
<script src="${pageContext.request.contextPath}/js/flatpickr.min.js"></script>
<script src="${pageContext.request.contextPath}/js/flatpickr.fr.js"></script>
<script>
$( '.flatpickr' ).flatpickr({
    locale: "fr",
    enableTime: false,
    dateFormat: "Y-m-d H:i:ss",
    mode: "range",/*Pour avoir un intervalle en flatpickr*/
    altInput: true,
    altFormat: "j F, Y"   
    
});
</script>
</body>
</html>