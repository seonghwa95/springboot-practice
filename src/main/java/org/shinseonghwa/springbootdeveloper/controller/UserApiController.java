package org.shinseonghwa.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import org.shinseonghwa.springbootdeveloper.dto.AddUserRequest;
import org.shinseonghwa.springbootdeveloper.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserApiController {

    private final UserService userService;

    @PostMapping("/user")
    public String singup(AddUserRequest request) {
        userService.save(request);

        return "redirect:/login";
    }
}
