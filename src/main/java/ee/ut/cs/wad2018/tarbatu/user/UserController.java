package ee.ut.cs.wad2018.tarbatu.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserRepository userRepository;
    UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public String showAuthUsers(Model model) {
        model.addAttribute("users", userRepository.findAuthUsers());

        return "users/all";
    }
}