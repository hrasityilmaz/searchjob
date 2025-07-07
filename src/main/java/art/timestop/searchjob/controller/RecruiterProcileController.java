package art.timestop.searchjob.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.core.model.Model;


@Controller
@RequestMapping("/recruiter-profile")
public class RecruiterProcileController {

    @GetMapping("/")
    public String recruiterProfile(Model model) {
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            
        }

        return "";
    }
    

}
