<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.* " %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Tracker App</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    
    <div id="wrapper">
        <div id="header">
            <h2>Foobar University</h2>
        </div>
    </div>

    <div id="container">
        <div id="content">
            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                </tr>
                <c:forEach var="tempStudent" items="${STUDENT_LIST}">
                    <tr>
                        <td>${tempStudent.getFirstName()}</td>
                        <td>${tempStudent.getLastName()}</td>
                        <td>${tempStudent.getEmail()}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</body>
</html>