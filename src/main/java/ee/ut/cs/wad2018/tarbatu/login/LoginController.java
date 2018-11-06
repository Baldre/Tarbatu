package ee.ut.cs.wad2018.tarbatu.login;

import ee.ut.cs.wad2018.tarbatu.user.NotificationService;
import ee.ut.cs.wad2018.tarbatu.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @Autowired
    private NotificationService notificationService;

    // Login formi lehele jõudmine.
    //*sama siin, login on oauthi puhul mingi default gateway vist?*
    @RequestMapping(value = "/userlogin", method = RequestMethod.GET)
    public String getLoginForm() {
        return "login/login";
    }

    // Andmete kontroll sisselogimisel.
    @RequestMapping(value = "/userlogin", method = RequestMethod.POST)
    public String login(@ModelAttribute(name = "loginForm") LoginForm loginForm, Model model) {
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        //Kui on õiged andmed
        if ("admin".equals(username) && "admin".equals(password)) {
            User saadetav = new User();
            saadetav.setUsername(saadetav.getUsername()); // Saadab e-maili, et sisse-logimine on õnnestunud.
            // Vaja, et e-mail oleks sama, mis username.

            try {
                notificationService.sendNotification(saadetav);
            }
            catch (MailException e) {
                // Püüab errori. Ei tee midagi lol
            }

            return "home/index";
        }

        //Kui on valed andmed.
        model.addAttribute("invalidCredentials", true);
        return "login/login";
    }
}
