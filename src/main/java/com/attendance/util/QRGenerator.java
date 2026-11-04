package com.attendance.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRGenerator {

    public static void generateQRCode(String text, String path) {

        try {

            BitMatrix matrix = new MultiFormatWriter().encode(
                    text,
                    BarcodeFormat.QR_CODE,
                    300,
                    300
            );

            Path filePath = FileSystems.getDefault().getPath(path);

            MatrixToImageWriter.writeToPath(matrix, "PNG", filePath);

            System.out.println("QR Code Generated!");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}