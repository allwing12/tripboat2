package tripboat.tripboat1.CommunityFile;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tripboat.tripboat1.CommentFile.CommentForm;
import tripboat.tripboat1.User.Services.UserServices;

import java.security.Principal;


@Controller
@Data
@RequiredArgsConstructor
@RequestMapping("/community")
public class CommunityController {
    @Autowired
    private final CommunityService communityService;
    private final UserServices userServices;

    @RequestMapping("")
    private String list(Model model, @RequestParam(value="page", defaultValue="0") int page, @RequestParam(value = "kw", defaultValue = "") String kw, Principal principal) {
        Page<Community> paging = this.communityService.getList(page, kw);
        model.addAttribute("kw", kw);
        model.addAttribute("paging", paging);
        model.addAttribute("name",userServices.getUser(principal.getName()));
        return "CommunityMain";
    }
    @RequestMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, CommentForm commentForm) {
        Community community = this.communityService.getCommunity(id);
        model.addAttribute("community", community);
        return "CommunityContent";
    }
    @RequestMapping("login_errors")
    private String login_err () {
        return "login_errors";
    }
}
