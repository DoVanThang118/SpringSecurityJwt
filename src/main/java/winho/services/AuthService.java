package winho.services;

import winho.models.dtos.UserDto;
import winho.models.request.SignupReq;

public interface AuthService {
    UserDto create(SignupReq signupReq);
}
