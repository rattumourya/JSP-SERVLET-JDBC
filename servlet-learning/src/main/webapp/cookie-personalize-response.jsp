<html>
    <head>
        <title>Confirmation</title>
    </head>
    <%
        String favLang = request.getParameter("favoriteLanguage");
        Cookie theCookie = new Cookie("myApp.favoriteLanguage",favLang);
        theCookie.setMaxAge(60*60*24*365);
        response.addCookie(theCookie); 
    %>
    <body>
        Thanks! We Set Your Favorite Language to : ${param.favoriteLanguage}
        <br><br>
        <a href="cookie-homepage.jsp">Return to homepage.</a>
    </body>
</html>