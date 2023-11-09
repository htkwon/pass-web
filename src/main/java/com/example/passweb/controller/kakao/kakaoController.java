package com.example.passweb.controller.kakao;

import com.example.passweb.kakao.KakaoService;
import com.example.passweb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/kakao")
@RequiredArgsConstructor
public class kakaoController {

    private final KakaoService kakaoService;
    private final UserRepository userRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "login/login";
    }

    @GetMapping("/oauth")
    public String get(@RequestParam String code, Model model) throws IOException {
        String access_token = kakaoService.getToken(code);
        Map<String, Object> userInfo = kakaoService.getUserInfo(access_token);
        kakaoService.saveUuid(userInfo);

        model.addAttribute("code", code);
        model.addAttribute("access_token", access_token);
        model.addAttribute("userInfo", userInfo);

        return "login/kakaoResponse";
    }


}
