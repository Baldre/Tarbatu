package ee.ut.cs.wad2018.tarbatu.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class NotificationService {

    private JavaMailSender javaMailSender;

    @Autowired
    public NotificationService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendNotification(User user) throws MailException {
        // Saadab e-maili.
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getUsername()); // Vaja saata kasutaja e-mailile. User'is pole e-maile.
        mail.setFrom("rahvatantsu.planeerija@gmail.com");
        mail.setSubject("Sisse logimise teavitus");
        mail.setText("Sisse logimine sooritati edukalt");

        javaMailSender.send(mail);
    }




}
