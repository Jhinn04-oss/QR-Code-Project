<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="navbar.jsp" %>

<!DOCTYPE html>
<html>

<head>

    <title>QR Code Scanner</title>

    <script src="https://unpkg.com/html5-qrcode"></script>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow">

        <div class="card-header bg-primary text-white">

            <h2 class="text-center">

                QR Code Scanner

            </h2>

        </div>

        <div class="card-body">

            <div id="reader" style="width:500px;margin:auto;"></div>

            <div class="text-center mt-3">

                <h4 id="result">

                    Waiting for QR Code...

                </h4>

            </div>

        </div>

    </div>

</div>

<script>

    function onScanSuccess(decodedText) {

        fetch("scanQR", {

            method: "POST",

            headers: {
                "Content-Type":
                    "application/x-www-form-urlencoded"
            },

            body: "qrData=" + encodeURIComponent(decodedText)

        })

            .then(response => response.text())

            .then(data => {

                document.getElementById("result").innerHTML = data;

            });

    }

    const html5QrCode = new Html5Qrcode("reader");

    html5QrCode.start(

        { facingMode: "environment" },

        {
            fps:10,
            qrbox:250
        },

        onScanSuccess

    );

</script>

</body>
</html>