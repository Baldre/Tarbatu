package ee.ut.cs.wad2018.tarbatu.liige;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LiigeController {

    @Autowired
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
