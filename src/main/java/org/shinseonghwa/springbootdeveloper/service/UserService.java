package org.shinseonghwa.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import org.shinseonghwa.springbootdeveloper.domain.User;
import org.shinseonghwa.springbootdeveloper.dto.AddUserRequest;
import org.shinseonghwa.springbootdeveloper.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto) {
        return userRepository.save(User.builder()
                .email(dto.getEmail())
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))  // 패스워드 암호화
                .build()).getId();
    }
}
