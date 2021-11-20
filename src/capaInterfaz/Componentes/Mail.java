/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaInterfaz.Componentes;

import capaNegocio.clsUsuario;
import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.BodyPart;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import java.sql.ResultSet;

import java.util.Properties;

/**
 *
 * @author CMFerrer
 */
public class Mail {

    private final Properties props;

    public Mail() {
        props = new Properties();

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        props.put("from", "bioquimicanorteandino@gmail.com");
        props.put("username", "bioquimicanorteandino@gmail.com");
        props.put("password", "bioquimicadae");
    }

    public void enviar(String to, String subject, String content) throws MessagingException {
        Session sesion = Session.getInstance(props, new jakarta.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(props.getProperty("username"), props.getProperty("password"));
            }
        });

        Message mensaje = new MimeMessage(sesion);
        mensaje.setFrom(new InternetAddress(props.getProperty("from")));
        mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        mensaje.setSubject(subject);

        MimeMultipart multipart = new MimeMultipart("related");

        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(content, "text/html");
        multipart.addBodyPart(messageBodyPart);

        messageBodyPart = new MimeBodyPart();
        DataSource fds = new FileDataSource("src/Iconos/logo.png");

        messageBodyPart.setDataHandler(new DataHandler(fds));
        messageBodyPart.setHeader("Content-ID", "<image>");
        multipart.addBodyPart(messageBodyPart);

        mensaje.setContent(multipart);

        Transport.send(mensaje);

    }

    public void enviarNuevoCodigo(String usuario) throws MessagingException, Exception {
        clsUsuario miUsuario = new clsUsuario();
        
        String codRecuperacion = miUsuario.generarCodigoRecuperacion(16);
        ResultSet rsUsuario = miUsuario.actualizarCodigoRecuperacion(usuario, codRecuperacion);
        
        String to = null;
        String subject = null;
        String content = null;
        if (rsUsuario.next()){
            to = rsUsuario.getString("correo");
            subject = "Código de recuperación";
            content = "<div style=\"background-color: #090446; padding: 16px; margin-bottom: 10px;\"><h1 style=\"text-align: center; font-family: 'Verdana';\"><span style=\"color: #ffffff;\"><strong>Bioquimica del Norte Andino</strong></span></h1></div><div style=\"font-family: 'Verdana'; background-color: #0904450d; padding: 16px; padding-left: 36px;\"><p>Hola " + rsUsuario.getString("nombres") + " " + rsUsuario.getString("apellidos") + ":</p><p>&nbsp;</p><p>Este es tu nuevo <strong>c&oacute;digo de recuperaci&oacute;n</strong>:</p><p style=\"text-align: center;\"><strong>" + codRecuperacion + "</strong></p><p style=\"text-align: center;\">&nbsp;</p><p style=\"text-align: center;\">Atentamente</p><p style=\"text-align: center;\"><img src=\"cid:image\" alt=\"logo\" /></p></div></div>";
        }

        Session sesion = Session.getInstance(props, new jakarta.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(props.getProperty("username"), props.getProperty("password"));
            }
        });

        Message mensaje = new MimeMessage(sesion);
        mensaje.setFrom(new InternetAddress(props.getProperty("from")));
        mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        mensaje.setSubject(subject);

        MimeMultipart multipart = new MimeMultipart("related");

        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(content, "text/html");
        multipart.addBodyPart(messageBodyPart);

        messageBodyPart = new MimeBodyPart();
        DataSource fds = new FileDataSource("src/Iconos/logo.png");

        messageBodyPart.setDataHandler(new DataHandler(fds));
        messageBodyPart.setHeader("Content-ID", "<image>");
        multipart.addBodyPart(messageBodyPart);

        mensaje.setContent(multipart);

        Transport.send(mensaje);
    }

}
