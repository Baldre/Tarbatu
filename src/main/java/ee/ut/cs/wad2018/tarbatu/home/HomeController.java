package ee.ut.cs.wad2018.tarbatu.home;

import ee.ut.cs.wad2018.tarbatu.liige.Liige;
import ee.ut.cs.wad2018.tarbatu.liige.LiigeRepository;
import ee.ut.cs.wad2018.tarbatu.user.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

}