<html>
    <body>
        <h3>JSP built-in objects</h3>
        Request user agent: <%= request.getHeader("User-Agent") %>
        <br><br>
        Request Langauge: <%= request.getLocale() %>
    </body>
</html>