<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.attendance.model.Student" %>
<%@ include file="navbar.jsp" %>

<!DOCTYPE html>
<html>
<head>


    <title>Student List</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">

</head>

<body>

<div class="container mt-5">

    <h2 class="text-center mb-4">
        Registered Students
    </h2>

    <table class="table table-bordered table-hover">

        <thead class="table-dark">

        <tr>
            <th>Photo</th>
            <th>Student ID</th>
            <th>Name</th>
            <th>Strand</th>
            <th>Section</th>
            <th>QR Code</th>
        </tr>

        </thead>

        <tbody>

        <%

            List<Student> students =
                    (List<Student>) request.getAttribute("students");

            if(students != null){

                for(Student student : students){

        %>

        <tr>

            <td>

                <img src="<%=student.getPhoto()%>"
                     width="80"
                     height="80">

            </td>

            <td><%=student.getStudentId()%></td>

            <td><%=student.getFullName()%></td>

            <td><%=student.getStrand()%></td>

            <td><%=student.getSection()%></td>

            <td>

                <img src="<%=student.getQrCode()%>"
                     width="100"
                     height="100">

            </td>

        </tr>

        <%

                }

            }

        %>

        </tbody>

    </table>

</div>

</body>
</html>