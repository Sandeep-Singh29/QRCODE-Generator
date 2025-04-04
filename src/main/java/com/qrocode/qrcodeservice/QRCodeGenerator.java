package com.qrocode.qrcodeservice;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.qrocode.entity.Student;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * Author: Sandeep Singh
 * Date: 04/04/25
 */

public class QRCodeGenerator {

    public static void generateQrCode(Student student) {

        String qrCodePath = "/Users/envotionsmacbookpro/Documents/Notes/qr-code/QRCodeImage/";
        String qrCodeName = qrCodePath + student.getFirstName() + student.getId() + "-QRCODE.png";

        var qrCodeWriter = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = qrCodeWriter.encode("ID: " + student.getId() + "\n" +
                            "FirstName : " + student.getFirstName() + "\n" +
                            "LastName : " + student.getLastName() + "\n" +
                            "Email : " + student.getEmail() + "\n" +
                            "Phone : " + student.getPhone() + "\n",
                    BarcodeFormat.QR_CODE, 400, 400);
            Path path = FileSystems.getDefault().getPath(qrCodeName);
            MatrixToImageWriter.writeToPath(bitMatrix,"PNG",path);
        } catch (WriterException | IOException e) {
            throw new RuntimeException(e);
        }

    }

}
