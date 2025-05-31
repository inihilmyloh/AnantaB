
package com.pengaturan.otp;

import java.util.Properties;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class getEmail {
    public static void emailResend(String emailTo) {
        
         if (!OtpSave.canResend()) {
        System.out.println("Harap tunggu sebelum mengirim ulang OTP.");
        return;
        }
         
        try {
            
            ELoader eLoader = new ELoader();
            String emailFrom = eLoader.getProperty("email.from");
            //String emailTo = eLoader.getProperty("email.to");
            String appPassword = eLoader.getProperty("email.password");
            
            Properties props = new Properties();
            props.put("mail.smtp.auth", eLoader.getProperty("smtp.auth"));
            props.put("mail.smtp.starttls.enable", eLoader.getProperty("smtp.starttls.enable"));
            props.put("mail.smtp.port", eLoader.getProperty("smtp.port"));
            props.put("mail.smtp.host", eLoader.getProperty("smtp.host"));
            
            Session session = Session.getInstance(props, new Authenticator() {
            
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(emailFrom, appPassword);
              }
            });
            
            int otp = otpGenerate.randomOTP();
            OtpSave.storeOtp(otp);

            Message message =  new MimeMessage(session);
            message.setFrom(new InternetAddress(emailFrom));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
         
            message.setSubject("Jangan bagikan kode OTP ini!");
            message.setText(
            "Halo pengguna,\n\n" +
            "Kami mendengar bahwa Anda sedang mengalami kesulitan mengakses akun Anda.\n" +
            "Untuk membantu proses pemulihan akun, kami telah mengirimkan kode OTP Anda.\n\n" +
            "Kode OTP Anda adalah: " + otp + "\n\n" +
            "JANGAN bagikan kode ini kepada siapapun, termasuk pihak yang mengatasnamakan layanan kami.\n\n" +
            "Terima kasih.\n\n" +
            "Hormat kami,\nTim Keamanan Aplikasi"
        );
            
            Transport.send(message);
            System.out.println("Email berhasil dikirim nih!");
            
            System.out.println("Mengirim email ke: " + emailTo);

        } catch(MessagingException e){
            e.printStackTrace();
        }
    }
    //global variable untuk menyimpan data email sementara
    public class sessionData {
        public static String emailData;
        public static String userData;
    }
}