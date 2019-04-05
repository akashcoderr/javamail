/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamail;

import java.util.Scanner;

/**
 *
 * @author The Robust Coder
 */
public class Javamail {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter Email Id To Send Message :");
        String sendToThisEmail=scan.next();
        scan.nextLine();
        System.out.println("Enter Your Message Subject:");
        String subject=scan.nextLine();
        System.out.println("Enter Your Message:");
        String message=scan.nextLine();
        JavaMailUtil.sendMail(sendToThisEmail,message,subject);
    }
    
}
