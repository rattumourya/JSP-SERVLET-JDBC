<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.* " %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Tracker App</title>
</head>
    <%
        List<Student> theStudents = (List<Student>) request.getAttribute("STUDENT_LIST");
    %>
<body>
    
    <div class="wrapper">
        <div class="header">
            <h2>Foobar University</h2>
        </div>
    </div>

    <div class="container">
        <div class="content">
            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                </tr>
                <% for(Student tempStudent: theStudents) { %>
                    <tr>
                        <td><%= tempStudent.getFirstName() %></td>
                        <td><%= tempStudent.getLastName() %></td>
                        <td><%= tempStudent.getEmail() %></td>
                    </tr>
                <% } %>
            </table>
        </div>
    </div>

</body>
</html>