<html>
    <body>
        <%!
            String makeItLower(String data)
            {
                return data.toLowerCase();
            }
        %>

        Lower Case of "Hello World":  <%= makeItLower("Hello World") %>
    </body>
</html>