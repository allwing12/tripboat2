package tripboat.tripboat1.CommunityFile.WriterFile;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import tripboat.tripboat1.CommunityFile.Community;
import tripboat.tripboat1.CommunityFile.CommunityForm;
import tripboat.tripboat1.CommunityFile.CommunityService;
import tripboat.tripboat1.User.Domain.SiteUser;
import tripboat.tripboat1.User.Services.UserServices;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@Data
@RequiredArgsConstructor
@RequestMapping("/writer")
public class WriterController {

    @Autowired
    private final CommunityService communityService;
    private final UserServices userServices;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/content")
    public String WriterForm (CommunityForm communityForm){
        return "Writer";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/content")
    public String WriterDate (@Valid CommunityForm communityForm, BindingResult bindingResult, Principal principal) {

        SiteUser siteUser = this.userServices.getUser(principal.getName());
        if (bindingResult.hasErrors()) {
            return "Writer";
        }
        this.communityService.create(communityForm.getSubject(),communityForm.getContent(),communityForm.getRegion(),siteUser); {
            return "redirect:/community";
        }
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/modify/{id}")
    public String communityModify(CommunityForm communityForm, @PathVariable("id") Integer id, Principal principal) {
        Community community = this.communityService.getCommunity(id);
        if(!community.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        communityForm.setSubject(community.getSubject());
        communityForm.setContent(community.getContent());
        communityForm.setRegion(community.getRegion());
        return "Writer";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/modify/{id}")
    public String communityMoidify(@Valid CommunityForm communityForm, BindingResult bindingResult,
                                   Principal principal, @PathVariable("id") Integer id) {
        if (bindingResult.hasErrors()) {
            return "CommunityMain";
        }
        Community community = this.communityService.getCommunity(id);
        if (!community.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        this.communityService.modify(community, communityForm.getSubject(), communityForm.getContent(),communityForm.getRegion());
        return String.format("redirect:/community/detail/%s", id);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/delete/{id}")
    public String communitydelete(Principal principal, @PathVariable("id") Integer id) {
        Community community = this.communityService.getCommunity(id);
        if (!community.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한이 없습니다.");
        }
        this.communityService.delete(community);
        return "redirect:/community";
    }

}