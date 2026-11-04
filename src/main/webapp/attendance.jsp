<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.attendance.model.Student" %>

<%
    Student student = (Student) request.getAttribute("student");
    String message = (String) request.getAttribute("message");
%>
<%@ include file="navbar.jsp" %>

<!DOCTYPE html>
<html>
<head>

    <title>Attendance Result</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow">

        <div class="card-header bg-success text-white text-center">

            <h3>QR Attendance Monitoring System</h3>

        </div>

        <div class="card-body text-center">

            <h4 class="text-success mb-4">

                <%= message %>

            </h4>

            <% if(student != null){ %>

            <img src="<%= student.getPhoto() %>"
                 width="180"
                 height="180"
                 class="rounded-circle border mb-3">

            <table class="table table-bordered">

                <tr>
                    <th width="35%">Student ID</th>
                    <td><%= student.getStudentId() %></td>
                </tr>

                <tr>
                    <th>Full Name</th>
                    <td><%= student.getFullName() %></td>
                </tr>

                <tr>
                    <th>Strand</th>
                    <td><%= student.getStrand() %></td>
                </tr>

                <tr>
                    <th>Section</th>
                    <td><%= student.getSection() %></td>
                </tr>

            </table>

            <% } %>

            <a href="students" class="btn btn-primary">
                Back to Student List
            </a>

        </div>

    </div>

</div>

</body>
</html>