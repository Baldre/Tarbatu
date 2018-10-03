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
    public String showAllUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "users/all";
    }


    /*
    @RequestMapping(value = "/liitu", method = RequestMethod.POST)
    @ResponseBody
    public void set(@ModelAttribute("username") String username){
        User user = new User();
        user.setUsername(username);
        userRepository.save(user);
    }*/
}