<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/add-student-style.css">
    <title>Add Student</title>
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>Foobar University</h2>
        </div>
    </div>
    <div id="container">
        <h3>Add Student</h3>
        <form action="StudentControllerServlet" method="GET">
            <input type="hidden" name="command" value="ADD">
            <table>
                <tbody>
                    <tr>
                        <td><label>First Name: </label></td>
                        <td><input type="text" name="firstName" /></td>
                    </tr>
                    <tr>
                        <td><label>Last Name: </label></td>
                        <td><input type="text" name="lastName" /></td>
                    </tr>
                    <tr>
                        <td><label>Email: </label></td>
                        <td><input type="text" name="email" /></td>
                    </tr>
                    <tr>
                        <td><label></label></td>
                        <td><input type="submit" value="Save" class="save" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </div>

</body>
</html>