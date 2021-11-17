package com.sanyagupta.healthdream;

import android.content.Context;
import android.os.AsyncTask;

import java.util.Properties;

//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;

public class JavaMailAPI  {
//    private Context context;
//    private Session session;
//    private String email ,subject,Mimemessage;
//
//    public JavaMailAPI(Context context, String email, String subject, String Mimemessage) {
//        this.context = context;
//        this.email = email;
//        this.subject = subject;
//        this.Mimemessage = Mimemessage;
//    }
//
//    @Override
//    protected Void doInBackground(Void... voids) {
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.port", "465");
//        props.put("mail.smtp.socketFactory.port", "465");
//        props.put("mail.smtp.socketFactory.class",
//                "javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//
//        session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(Utils.EMAIL, Utils.PASSWORD);
//            }
//        });
//
//        try {
//            MimeMessage message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(Utils.EMAIL));
//            message.setRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(email)));
//            message.setSubject(subject);
//            message.setText(Mimemessage);
//            Transport.send(message);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
