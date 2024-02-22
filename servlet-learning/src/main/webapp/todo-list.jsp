<%@ page import="java.util.*" %>
<html>
    <body>
        <form action="todo-list.jsp">
           Add new item:  <input type="text" name="theItem">
           <input type="submit" value="Submit">
        </form>
        <br>
        <%
            List<String> items = (List<String>)session.getAttribute("myToDoList");
            if(items == null)
            {
                items = new ArrayList<String>();
                session.setAttribute("myToDoList",items);
            }
            String theItem =  request.getParameter("theItem");

            boolean isItemNotEmpty = theItem != null && theItem.trim().length() > 0;
            boolean isItemNotDuplicate = theItem != null && !items.contains(theItem.trim());
            if(isItemNotEmpty && isItemNotDuplicate)
            {
                items.add(theItem);
            }
        %>
        <hr>
        <b>To Do List: </b>
        <br>
        <ol>
            <%
                for(String item: items)
                {
                    out.print("<li>"+ item +"</ul>");
                }
            %>
        </ol>
    </body>
</html>