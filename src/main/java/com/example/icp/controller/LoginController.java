package com.example.icp.controller;

import com.example.icp.HydraService;
import com.example.icp.model.hydra.login.HydraAcceptLoginResponse;
import com.example.icp.model.hydra.login.HydraGetLoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class LoginController {
    final HydraService hydraService;

    @GetMapping("/login")
    @ResponseBody
    public String login(@RequestParam("login_challenge") String loginChallenge, HttpServletResponse servletResponse) throws IOException {
        //call to hydra to start login
        //neu skip = true thi call accept login sang hydra
        //neu skip = false thi hien thi user login page

        HydraGetLoginResponse response = hydraService.getLogin(loginChallenge);
        if (response.getSkip() == false) {
            return "<form method=POST action=/login?login_challenge=" + loginChallenge + ">" + loginChallenge + "<br/><button type=submit>submit</button></form>";
        }

        return acceptLogin(loginChallenge, response.getUserId(), servletResponse);
    }

    @PostMapping("/login")
    @ResponseBody
    public String login1(@RequestParam("login_challenge") String loginChallenge, HttpServletResponse servletResponse) throws IOException {
        String userId = "bimbip";

        return acceptLogin(loginChallenge, userId, servletResponse);
    }

    private String acceptLogin(String loginChallenge, String userId, HttpServletResponse servletResponse) throws IOException {
        HydraAcceptLoginResponse response = hydraService.acceptLogin(loginChallenge, userId);
        servletResponse.setHeader("Location", response.getRedirectTo());
        servletResponse.setStatus(302);
        return null;
    }
}
