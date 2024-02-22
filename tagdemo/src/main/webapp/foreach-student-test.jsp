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
                    <td>${tempStudent.firstName}</td>
                    <td>${tempStudent.lastName}</td>
                    <td>${tempStudent.goldCustomer}</td>
                </tr>
            </c:forEach>
        </table>
        <hr>

        <h2>How cookie used in jstl</h2>
        <c:forEach items="${cookie}" var="currentCookie">
            Cookie name as map entry key: ${currentCookie.key} <br />
            Cookie object as map entry value: ${currentCookie.value} <br />
            Name property of Cookie object: ${currentCookie.value.name} <br />
            Value property of Cookie object: ${currentCookie.value.value} <br />
        </c:forEach>
        
    </body>
</html>