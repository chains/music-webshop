/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.ctrl;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
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

        Message msg = new MimeMessage(session);
        msg.setSubject("Confirmation email");
        msg.setRecipient(RecipientType.TO,
                         new InternetAddress(
                         "dixtre@gmail.com",
                         "Customer"));
        
        msg.setFrom(new InternetAddress(
                    "mailer.music.webshop@gmail.com",
                    "MailerRobot at MusicWebshop"));

        // Body text.
        BodyPart messageBodyPart = new MimeBodyPart();
        
        messageBodyPart.setText("Here is your order confirmation " + message);

         Multipart multipart = new MimeMultipart();  
         multipart.addBodyPart(messageBodyPart); 
   
         // Add multipart message to email.  
         msg.setContent(multipart); 
        
        // Send email.
        Transport.send(msg);
        
    }

}
