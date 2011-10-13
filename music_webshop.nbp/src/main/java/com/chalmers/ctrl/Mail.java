/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.ctrl;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.util.ByteArrayDataSource;
import javax.naming.InitialContext;

/**
 *
 * @author Daniel Nicklasson
 */
public class Mail {
    
    private String message;
    
    public Mail(String message){
        this.message = message;
    }
   
    public void sendMail() throws Exception {
        InitialContext ctx = new InitialContext();
        Session session =
            (Session) ctx.lookup("mail/mailserver");
        // Or by injection.
        //@Resource(name = "mail/<name>")
        //private Session session;

        // Create email and headers.
        Message msg = new MimeMessage(session);
        msg.setSubject("Confirmation");
        msg.setRecipient(RecipientType.TO,
                         new InternetAddress(
                         "dixtre@gmail.com",
                         "Daniel"));
        msg.setRecipient(RecipientType.CC,
                         new InternetAddress(
                         "michelle@email.com",
                         "Michelle"));
        msg.setFrom(new InternetAddress(
                    "jack@email.com",
                    "Jack"));

        // Body text.
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText(message);

//        // Multipart message.
//        Multipart multipart = new MimeMultipart();
//        multipart.addBodyPart(messageBodyPart);
//
//        // Attachment file from string.
//        messageBodyPart = new MimeBodyPart();
//        messageBodyPart.setFileName("README1.txt");
//        messageBodyPart.setContent(new String(
//                                   "file 1 content"),
//                                   "text/plain");
//        multipart.addBodyPart(messageBodyPart);
//
//        // Attachment file from file.
//        messageBodyPart = new MimeBodyPart();
//        messageBodyPart.setFileName("README2.txt");
//        DataSource src = new FileDataSource("file.txt");
//        messageBodyPart.setDataHandler(new DataHandler(src));
//        multipart.addBodyPart(messageBodyPart);
//
//        // Attachment file from byte array.
//        messageBodyPart = new MimeBodyPart();
//        messageBodyPart.setFileName("README3.txt");
//        src = new ByteArrayDataSource(
//            "file 3 content".getBytes(),
//            "text/plain");
//        messageBodyPart.setDataHandler(new DataHandler(src));
//        multipart.addBodyPart(messageBodyPart);
//
//        // Add multipart message to email.
//        msg.setContent(multipart);

        // Send email.
        Transport.send(msg);
    }

}
