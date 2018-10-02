package ee.ut.cs.wad2018.tarbatu.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private final UserRepository userRepository;
    UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "users/all";
    }

    @GetMapping("/liitu")
    public String showAllUser(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "users/all";
    }

    /*
    @RequestMapping(value = "liitu/add", method = RequestMethod.POST)
    @ResponseBody
    public void set(@RequestParam("username") String username){
        User user = new User();
        user.setUsername(username);
        userRepository.save(user);
    }*/
}