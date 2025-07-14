package art.timestop.searchjob.controller;

import java.util.Date;
import java.util.List;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import art.timestop.searchjob.entity.JobPostActivity;
import art.timestop.searchjob.entity.RecruiterJobsDto;
import art.timestop.searchjob.entity.RecruiterProfile;
import art.timestop.searchjob.entity.Users;
import art.timestop.searchjob.services.JobPostActivityService;
import art.timestop.searchjob.services.UsersService;




@Controller
public class JobPostActivityController {
    
    private final UsersService usersService;
    private final JobPostActivityService jobPostActivityService;

    

    public JobPostActivityController(UsersService usersService, JobPostActivityService jobPostActivityService) {
        this.usersService = usersService;
        this.jobPostActivityService = jobPostActivityService;
    }

    @GetMapping("/dashboard/")
    public String searchHob(Model model) {
        
        Object currenttUserProfile = usersService.getCurrentUserProfile();
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(!(authentication instanceof  AnonymousAuthenticationToken)){
            String currentUserName = authentication.getName();
            System.out.println("here ---> " + currentUserName);
            model.addAttribute("username", currentUserName);
            if(authentication.getAuthorities().contains(new SimpleGrantedAuthority("Recruiter"))){
                List<RecruiterJobsDto> recruiterJobs = jobPostActivityService.getRecruiterJobs(((RecruiterProfile) currenttUserProfile).getUserAccoundId());
                model.addAttribute("jobPost", recruiterJobs);
            }
        }
        model.addAttribute("user", currenttUserProfile);

        return "dashboard";
    }

    @GetMapping("/dashboard/add")
    public String addJobs(Model model) {
        model.addAttribute("jobPostActivity", new JobPostActivity());
        model.addAttribute("user", usersService.getCurrentUserProfile());
        return "add-jobs";
    }
    
    @PostMapping("/dashboard/addNew")
    public String addNew(JobPostActivity jobPostActivity, Model model) {
        
        Users user = usersService.getCurrentUser();
        if(user !=null){
            jobPostActivity.setPostedById(user);
        }
        jobPostActivity.setPostedDate(new Date());
        model.addAttribute("jobPostActivity", jobPostActivity);
        JobPostActivity saved =  jobPostActivityService.addNew(jobPostActivity);
        return "redirect:/dashboard/";
    }
    

}
