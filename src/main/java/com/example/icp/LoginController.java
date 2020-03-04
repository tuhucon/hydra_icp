package com.example.icp;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class LoginController {
    final HydraService hydraService;

    String userId = "bimbip";

    @GetMapping("/login")
    @ResponseBody
    public String login(@RequestParam("login_challenge") String loginChallenge) throws IOException {
        //call to hydra to start login
        //neu skip = true thi call accept login sang hydra
        //neu skip = false thi hien thi user login page

        HydraGetLoginResponse response = hydraService.getLogin(loginChallenge);
        if (response.getSkip() == false) {
            return "<form method=POST action=/login?login_challenge=" + loginChallenge + ">" + loginChallenge + "<br/><button type=submit>submit</button></form>";
        }

        return acceptLogin(loginChallenge, userId);
    }

    @PostMapping("/login")
    @ResponseBody
    public String login1(@RequestParam("login_challenge") String loginChallenge) throws IOException {
        return acceptLogin(loginChallenge, userId);
    }

    private String acceptLogin(String loginChallenge, String userId) throws IOException {
        HydraAcceptLoginResponse response = hydraService.acceptLogin(loginChallenge, userId);
        return "redirect:" + response.getRedirectTo();
    }
}
