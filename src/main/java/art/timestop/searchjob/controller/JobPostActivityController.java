package art.timestop.searchjob.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import art.timestop.searchjob.services.UsersService;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class JobPostActivityController {
    
    public final UsersService usersService;

    public JobPostActivityController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/dashboard/")
    public String searchHob(Model model) {
        
        Object currenttUserProfile = usersService.getCurrentUserProfile();
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(!(authentication instanceof  AnonymousAuthenticationToken)){
            String currentUserName = authentication.getName();
            System.out.println("here ---> " + currentUserName);
            model.addAttribute("username", currentUserName);
        }
        model.addAttribute("user", currenttUserProfile);

        return "dashboard";
    }

    @GetMapping("/dashboard/add")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    

}
