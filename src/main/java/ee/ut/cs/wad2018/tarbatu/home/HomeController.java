package ee.ut.cs.wad2018.tarbatu.home;

import ee.ut.cs.wad2018.tarbatu.liige.LiigeRepository;
import ee.ut.cs.wad2018.tarbatu.user.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    private final UserRepository userRepository;
    private final LiigeRepository liigeRepository;
    HomeController(UserRepository userRepository, LiigeRepository liigeRepository) {
        this.userRepository = userRepository;
        this.liigeRepository = liigeRepository;
    }

    @GetMapping(path = "/")
    public String getTestPage(Model model){
        model.addAttribute("liikmed", liigeRepository.findAll());
        model.addAttribute("hulk", liigeRepository.hulk());
        return "home/index";
    }

    @GetMapping(path = "/test-dynamic")
    public String getTest2Page(
            @RequestParam(
                    value="name-from-url",
                    required = false,
                    defaultValue = "World") String nameFromUrl, Model model){
        model.addAttribute("nameTemplate", nameFromUrl);
        return "home/index_dynamic";
    }

    @GetMapping("/liitu")
    public String getLiituPage(Model model){
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("user", new User());
        return "users/liitu";
    }

    @PostMapping("/liitu")
    public String liitumisAvaldus(@ModelAttribute Userform form){
        userRepository.save(new User(form.getUsername(), form.getCode()));

        return "redirect:/users";
    }
}