<html>
    <head>
        <title>Traning Portal</title>
    </head>
    <h3>Traning Portal</h3>
    <%
        String favLang = "Java";
        Cookie[] theCookies = request.getCookies();
        if(theCookies != null)
        {
            for(Cookie tempCookie: theCookies)
            {
                if("myApp.favoriteLanguage".equals(tempCookie.getName()))
                {
                    favLang = tempCookie.getValue();
                    break;
                }
            }
        }

    %>
    <body>
        <h4>New Books For <%= favLang %> </h4>
        <ul>
            <li>Blah Blah Blah</li>
            <li>Blah Blah Blah</li>
            <li>Blah Blah Blah</li>
        </ul>

        <h4>Latest New For <%= favLang %> </h4>
        <ul>
            <li>Blah Blah Blah</li>
            <li>Blah Blah Blah</li>
            <li>Blah Blah Blah</li>
        </ul>

        <h4>Hot Jobs For <%= favLang %> </h4>
        <ul>
            <li>Blah Blah Blah</li>
            <li>Blah Blah Blah</li>
            <li>Blah Blah Blah</li>
        </ul>

        <hr>
        <a href="cookie-personalize-form.html">Personalize this page</a>

    </body>
</html>