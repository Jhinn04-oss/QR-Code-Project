<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.attendance.model.Attendance" %>
<%@ include file="navbar.jsp" %>

<%
    List<Attendance> attendanceList =
            (List<Attendance>) request.getAttribute("attendanceList");
%>

<!DOCTYPE html>
<html>

<head>

    <title>Attendance History</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow">

        <div class="card-header bg-primary text-white">

            <h2 class="text-center">
                Attendance History
            </h2>

        </div>

        <div class="card-body">

            <div class="mb-3">

                <a href="dashboard" class="btn btn-success">
                    Dashboard
                </a>

                <a href="students" class="btn btn-primary">
                    Student List
                </a>

                <button onclick="window.print()" class="btn btn-secondary">
                    Print
                </button>

            </div>

            <table class="table table-bordered table-hover">

                <thead class="table-dark">

                <tr>

                    <th>Student ID</th>
                    <th>Full Name</th>
                    <th>Strand</th>
                    <th>Section</th>
                    <th>Date</th>
                    <th>Time</th>
                    <th>Status</th>

                </tr>

                </thead>

                <tbody>

                <%
                    if(attendanceList != null){

                        for(Attendance attendance : attendanceList){
                %>

                <tr>

                    <td><%= attendance.getStudentId() %></td>

                    <td><%= attendance.getFullName() %></td>

                    <td><%= attendance.getStrand() %></td>

                    <td><%= attendance.getSection() %></td>

                    <td><%= attendance.getAttendanceDate() %></td>

                    <td><%= attendance.getAttendanceTime() %></td>

                    <td>

                        <span class="badge bg-success">

                            <%= attendance.getStatus() %>

                        </span>

                    </td>

                </tr>

                <%
                        }
                    }
                %>

                </tbody>

            </table>

        </div>

    </div>

</div>

</body>

</html>