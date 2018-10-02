package ee.ut.cs.wad2018.tarbatu.liige;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LiigeController {


    private final LiigeRepository liigeRepository;
    LiigeController(LiigeRepository liigeRepository) {
        this.liigeRepository = liigeRepository;
    }

    @GetMapping("/liikmed")
    public String showAllUsers(Model model) {
        model.addAttribute("liikmed", liigeRepository.findAll());
        return "liikmed/all";
    }

    @GetMapping("/")
    public String FrontPage(Model model){
        model.addAttribute("liikmed", liigeRepository.findAll());
        model.addAttribute("hulk", liigeRepository.hulk());
        return "home/index";
    }

}
