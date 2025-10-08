package Controllers;

import Models.UsuarioModel;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

public class EnvioCorreoController {

    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final String SMTP_PORT = "587";
    private static final String USER = "gestioninventartios@gmail.com";
    private static final String PASS = "mgca zcca zdde hvfg"; 

    public static void enviarCorreo(String to, String subject, String body) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", SMTP_HOST);
        props.put("mail.smtp.port", SMTP_PORT);

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USER, PASS);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USER));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
            System.out.println("Correo enviado correctamente a " + to);

        } catch (MessagingException e) {
            e.printStackTrace();
            System.err.println("Error al enviar el correo: " + e.getMessage());
        }
    }

    public void enviarAlertaStock(String producto, int stockRestante) {
    UsuarioModel usuario = Models.SesionUsuario.getUsuarioActual();

        if (usuario == null) {
        System.err.println("No hay un usuario en sesión. No se puede enviar el correo.");
        return;
        }

    String correoUsuario = usuario.getCorreo();

        if (correoUsuario == null || correoUsuario.isEmpty()) {
        System.err.println("El usuario actual no tiene correo registrado.");
        return;
        }

    String subject = "Alerta de Stock Bajo";
    String body = "Hola " + usuario.getNombre() + ",\n\n"
            + "El producto '" + producto + "' tiene un stock bajo: " + stockRestante + " unidades.\n\n"
            + "Por favor revisa el inventario.\n\n"
            + "Saludos,\nSistema de Gestión de Inventarios.";

    enviarCorreo(correoUsuario, subject, body);
    }
    
    public void enviarRecuperacionContrasena(UsuarioModel usuario, String nuevaContrasenaTemporal) {
        String asunto = "Recuperación de Contraseña - Sistema de Inventarios";
        String cuerpo = "Hola " + usuario.getNombre() + " " + usuario.getApellido() + ",\n\n"
                      + "Has solicitado restablecer tu contraseña.\n\n"
                      + "Tu nueva contraseña temporal es: " + nuevaContrasenaTemporal + "\n\n"
                      + "Por seguridad, cambia tu contraseña una vez inicies sesión nuevamente.\n\n"
                      + "Saludos,\nSistema de Gestión de Inventarios.";
        enviarCorreo(usuario.getCorreo(), asunto, cuerpo);
    }
}
