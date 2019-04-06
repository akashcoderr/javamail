/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamail;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Rajiv Pathak
 */
public class JavaMailUtil {
    public static void sendMail(String recepient,String messageToSend,String subject)throws Exception{
        System.out.println("Preparing To Send Email..");
        Properties properties=new Properties();
        
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        String myAccountEmail="mygmail@gmail.com";
        String password="********
        
        Session session=Session.getInstance(properties,new Authenticator() {
            
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        
        Message message=prepaerMessage(session,myAccountEmail,recepient,messageToSend,subject);
        Transport.send(message);
        System.out.println("message send successfully!!");
    }

    private static Message prepaerMessage(Session session, String myAccountEmail, String recepient,String messageToSend,String subject){
        try{
        Message message=new MimeMessage(session);
        message.setFrom(new InternetAddress(myAccountEmail));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
        message.setSubject(subject);
        message.setText(messageToSend);
        
        /*
            for html 
            message.setContent(htmlcode,"text/html");
        */
        return message;
        }catch(Exception ex){
            Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
        
    }
}
