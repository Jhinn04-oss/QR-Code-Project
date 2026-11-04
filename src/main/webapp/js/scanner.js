function onScanSuccess(decodedText) {

    document.getElementById("result").innerHTML =
        "QR Code Detected...";

    html5QrCodeScanner.clear();

    setTimeout(function(){

        window.location.href =
            decodedText;

    },1000);

}

function onScanFailure(error){

}

const html5QrCodeScanner =
    new Html5QrcodeScanner(

        "reader",

        {

            fps:10,

            qrbox:250

        },

        false

    );

html5QrCodeScanner.render(
    onScanSuccess,
    onScanFailure
);