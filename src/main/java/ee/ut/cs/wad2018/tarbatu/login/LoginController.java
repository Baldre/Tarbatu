package ee.ut.cs.wad2018.tarbatu.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class LoginController {

    // Login form
    @GetMapping(path = "/login")
    public String login() {
        return "login/login";
    }
}
