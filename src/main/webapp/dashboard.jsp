<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         isELIgnored="false" %>
<%@ include file="navbar.jsp" %>

<!DOCTYPE html>
<html>
<head>

    <title>Dashboard</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow">

        <div class="card-header bg-primary text-white">

            <h2 class="text-center">
                QR Attendance Monitoring System
            </h2>

        </div>

        <div class="card-body">

            <div class="row">

                <div class="col-md-4">

                    <div class="card text-center border-primary">

                        <div class="card-body">

                            <h3>Total Students</h3>

                            <h1>${totalStudents}</h1>

                        </div>

                    </div>

                </div>

                <div class="col-md-4">

                    <div class="card text-center border-success">

                        <div class="card-body">

                            <h3>Present Today</h3>

                            <h1>${presentToday}</h1>

                        </div>

                    </div>

                </div>

                <div class="col-md-4">

                    <div class="card text-center border-danger">

                        <div class="card-body">

                            <h3>Absent Today</h3>

                            <h1>${absentToday}</h1>

                        </div>

                    </div>

                </div>

            </div>

            <hr>

            <div class="d-grid gap-3 mt-4">

                <a href="registration.jsp" class="btn btn-primary">
                    Register Student
                </a>

                <a href="students" class="btn btn-success">
                    Student List
                </a>

                <a href="attendanceHistory" class="btn btn-warning">
                    Attendance History
                </a>

            </div>

        </div>

    </div>

</div>

</body>
</html>