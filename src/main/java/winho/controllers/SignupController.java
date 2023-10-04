package winho.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import winho.models.dtos.UserDto;
import winho.models.request.SignupReq;
import winho.services.AuthService;

@RestController
public class SignupController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> create(@RequestBody SignupReq signupReq) {
        UserDto create = authService.create(signupReq);
        if (create == null) return new ResponseEntity<>("User is not created, try again later", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(create, HttpStatus.CREATED);
    }
}
