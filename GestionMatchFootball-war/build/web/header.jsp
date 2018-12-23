<%@page import="entities.Arbitre"%>
<%@page import="entities.Entraineur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="has-navbar-fixed-top">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/all.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bulma.min.css">
   <%--   only imported in JSPs in need <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bulma-checkradio.min.css"> --%>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/animated.css">
        <link rel="stylesheet"  type="text/css" href="${pageContext.request.contextPath}/css/style.css">
        <link rel="icon" href="favicon.ico" type="image/ico">
        <title>Menu Gestion de Matchs de FootBall</title>
    </head>
    <body class="has-text-centered">
        <nav class="navbar is-info is-fullwidth is-fixed-top">
            <div class="container">
                <div class="navbar-brand">
                    <a class="navbar-item " href="Menu.jsp" style="font-weight:bold" >
                        Gestion de matchs de football
                    </a>
                    <span class="navbar-burger burger" data-target="navMenu">
                        <span></span>
                        <span></span>
                        <span></span>
                    </span>
                </div>
                <div id="navMenu" class="navbar-menu">
                    <div class="navbar-end">
                        <a href="${pageContext.request.contextPath}/Menu.jsp" class="navbar-item">Accueil</a>
                <%
                    String statutConnexionFederation = (String) session.getAttribute("sessionFederation");
                    if(statutConnexionFederation==null)
                        out.println("<a href='"+request.getContextPath()+"/federation/Connexion.jsp' class='navbar-item'>Fédération</a>");
                    else
                        out.println("<a href='"+request.getContextPath()+"/federation/Menu.jsp' class='navbar-item'>Fédération</a>");
                %>     
                <%
                    Entraineur statutConnexionEntraineur = (Entraineur) session.getAttribute("sessionEntraineur");
                    if(statutConnexionEntraineur==null)
                        out.println("<a href='"+request.getContextPath()+"/entraineur/Connexion.jsp' class='navbar-item'>Entraineur</a>");
                    else
                        out.println("<a href='"+request.getContextPath()+"/entraineur/Menu.jsp' class='navbar-item'>Entraineur</a>");
                %>   
                <%
                    Arbitre statutConnexionArbitre = (Arbitre) session.getAttribute("sessionArbitre");
                    if(statutConnexionEntraineur==null)
                        out.println("<a href='"+request.getContextPath()+"/arbitre/Connexion.jsp' class='navbar-item'>Arbitre</a>");
                    else
                        out.println("<a href='"+request.getContextPath()+"/arbitre/Menu.jsp' class='navbar-item'>Arbitre</a>");
                %>  
                       <!--
                        <a href="EntraineurConnexion.jsp" class="navbar-item">Entraineur</a>
                        <a href="ArbitreConnexion.jsp" class="navbar-item">Arbitre</a>
                       -->
                       </div>
                </div>
            </div>
        </nav>