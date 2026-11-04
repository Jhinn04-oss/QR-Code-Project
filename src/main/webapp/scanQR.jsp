<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="navbar.jsp" %>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>QR Scanner</title>

    <meta name="viewport"
          content="width=device-width, initial-scale=1">

    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">

    <link rel="stylesheet"
          href="css/scanner.css">

    <script src="https://unpkg.com/html5-qrcode"></script>

</head>

<body>

<div class="scanner-wrapper">

    <h1 class="scanner-title">

        QR Scanner

    </h1>

    <p class="scanner-subtitle">

        Position the QR code inside the frame to scan

    </p>

    <div class="scanner-card">

        <div id="reader"></div>

    </div>

    <div class="status-card">

        <span id="result">

            Waiting for QR code...

        </span>

    </div>

</div>

<script src="js/scanner.js"></script>

</body>
</html>