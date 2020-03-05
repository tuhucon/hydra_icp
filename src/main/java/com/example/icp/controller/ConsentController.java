package com.example.icp.controller;

import com.example.icp.HydraService;
import com.example.icp.model.hydra.consent.HydraAcceptConsentResponse;
import com.example.icp.model.hydra.consent.HydraGetConsentResponse;
import com.example.icp.model.hydra.login.HydraAcceptLoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ConsentController {
    final HydraService hydraService;

    String userId = "bimbip";

    @GetMapping("/consent")
    @ResponseBody
    public String consent(@RequestParam("consent_challenge") String consentChallenge, HttpServletResponse servletResponse) throws IOException {
        //call to hydra to start consent
        //hien thi man hinh consent cho user

        HydraGetConsentResponse response = hydraService.getConsent(consentChallenge);
        if (response.getSkip() == false) {
            return "<form method=POST action=/consent?consent_challenge=" + consentChallenge + ">"
                    + consentChallenge + "<br/>client name = " + response.getClient().getClientName() + "<button type=submit>submit</button></form>";
        }

        return acceptConsent(consentChallenge, servletResponse);
    }

    @PostMapping("/consent")
    @ResponseBody
    public String consent1(@RequestParam("consent_challenge") String consentChallenge, HttpServletResponse servletResponse) throws IOException {
        return acceptConsent( consentChallenge, servletResponse);
    }

    private String acceptConsent(String consentChallenge, HttpServletResponse servletResponse) throws IOException {
        List<String> grantScopes = new ArrayList<>();
        grantScopes.add("*");
        grantScopes.add("offline"); //add this custome scope to hydra return refresh token
        HydraAcceptConsentResponse response = hydraService.acceptConsent(consentChallenge, grantScopes);
        servletResponse.setHeader("Location", response.getRedirectTo());
        servletResponse.setStatus(302);
        return null;
    }
}
