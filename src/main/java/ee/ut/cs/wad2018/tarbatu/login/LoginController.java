package ee.ut.cs.wad2018.tarbatu.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    // Login formi lehele jõudmine.
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginForm() {
        return "login/login";
    }

    // Andmete kontroll sisselogimisel.
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute(name = "loginForm") LoginForm loginForm, Model model) {
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        //Kui on õiged andmed
        if ("admin".equals(username) && "admin".equals(password)) {
            return "home/index";
        }

        //Kui on valed andmed.
        model.addAttribute("Valed andmed", true);
        return "login/login";
    }
}
