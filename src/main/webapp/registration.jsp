<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="navbar.jsp" %>

<!DOCTYPE html>
<html>
<head>

    <title>Register Student</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">

</head>
<%
    String success = request.getParameter("success");
    String error = request.getParameter("error");
%>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow">

        <div class="card-header bg-primary text-white">

            <h3>Student Registration</h3>

        </div>

        <div class="card-body">

            <% if(success != null){ %>

            <div class="alert alert-success">
                Student Registered Successfully!
            </div>

            <% } %>

            <% if(error != null){ %>

            <div class="alert alert-danger">
                Registration Failed!
            </div>

            <% } %>

            <form action="RegisterStudentServlet" method="post" enctype="multipart/form-data">

                <div class="mb-3">

                    <label>Student ID</label>

                    <input type="text"
                           name="studentID"
                           class="form-control"
                           required>

                </div>

                <div class="mb-3">

                    <label>Full Name</label>

                    <input type="text"
                           name="fullName"
                           class="form-control"
                           required>

                </div>

                <div class="mb-3">

                    <label>Strand</label>

                    <input type="text"
                           name="strand"
                           class="form-control"
                           required>

                </div>

                <div class="mb-3">

                    <label>Section</label>

                    <input type="text"
                           name="section"
                           class="form-control"
                           required>

                </div>

                <div class="mb-3">

                    <label>Photo</label>

                    <input type="file"
                           name="photo"
                           class="form-control"
                           accept="image/*"
                           required>

                </div>

                <button class="btn btn-success">

                    Register Student

                </button>

            </form>

        </div>

    </div>

</div>

</body>

</html>