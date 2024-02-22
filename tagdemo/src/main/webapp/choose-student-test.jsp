<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.* , src.main.java.Student"  %>

<%
    List<Student> data = new ArrayList<>();
    data.add(new Student("John","Doe",false));
    data.add(new Student("Ratan","Mourya",true));
    data.add(new Student("Somya","Omer",true));
    data.add(new Student("Mary","Pulbic",false));

    pageContext.setAttribute("myStudents",data);
%>


<html>
    <body>
        <table border="1">
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Gold Customer</th>
            </tr>
            <c:forEach var="tempStudent" items="${myStudents}">
                <tr>
                    <td>${tempStud  ent.firstName}</td>
                    <td>${tempStudent.lastName}</td>
                    <td>
                        <c:choose>
                            <c:when test="${tempStudent.goldCustomer}">
                                Special Discount
                            </c:when>
                            <c:otherwise>
                                No soup for you!
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </table>
        
    </body>
</html>