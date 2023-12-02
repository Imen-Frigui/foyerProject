package tn.esprit.springproject.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.springproject.configuration.UserAuthenticationProvider;
import tn.esprit.springproject.dtos.CredentialsDto;
import tn.esprit.springproject.dtos.SignUpDto;
import tn.esprit.springproject.dtos.UserDto;
import tn.esprit.springproject.services.UserServiceImp;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final UserServiceImp userServiceImpl;
    private final UserAuthenticationProvider userAuthenticationProvider;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody @Valid CredentialsDto credentialsDto) {
        UserDto userDto = userServiceImpl.login(credentialsDto);
        System.out.println(userDto.toString());
        userDto.setToken(userAuthenticationProvider.createToken(userDto));
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody @Valid SignUpDto user) {
        UserDto createdUser = userServiceImpl.register(user);
        createdUser.setToken(userAuthenticationProvider.createToken(createdUser));
        return ResponseEntity.created(URI.create("/users/" + createdUser.getIdUser())).body(createdUser);
    }

}
