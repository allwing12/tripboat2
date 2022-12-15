package tripboat.tripboat1.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class TestController {
    @Autowired
    private TestServiceImple testServiceImple;

    @GetMapping("/api/overlap/usernameRegister")
    public String test () {
        return "test_form";
    }
}

