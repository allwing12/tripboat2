package tripboat.tripboat1.Mypage;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tripboat.tripboat1.User.Domain.SiteUser;
import tripboat.tripboat1.User.Repository.UserRepository;
import tripboat.tripboat1.User.Services.UserServices;
import tripboat.tripboat1.Util.DataNotFoundException;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Data
@Controller
@RequiredArgsConstructor
public class MypageController {
    private final UserServices userServices;
//    private final PasswordEncoder passwordEncoder;

//    public MypageController(UserServices userServices, PasswordEncoder passwordEncoder, UserRepository userRepository) {
//        this.userServices = userServices;
//        this.passwordEncoder = passwordEncoder;
//    }

//    @PreAuthorize("isAuthenticated()")
    @GetMapping("/mypage")
    public String mypage() {
        return "Mypage";
    }

//    @PostMapping("/mypage")
//    public String post(Model model, Authentication authentication, Principal principal) {
//
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//        model.addAttribute("author", userDetails.getUsername());
//        model.addAttribute("name",authentication.getName());
//        model.addAttribute("user",userServices.getUser(principal.getName()));
//        return "Mypage";
    //    }
//@GetMapping("/mypage/delete/{id}")
//public String deleteUser (Model model) {
//    return "DeleteUser";
//}
    @RequestMapping("/mypage")
    private String post(Model model,  Principal principal)throws IOException {
//        SiteUser name =  userServices.getUser(principal.getName());
//        model.addAttribute("name",name);
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        auth.getPrincipal();
        model.addAttribute("name", userServices.getUser(principal.getName()));
        return "Mypage";
    }
}
