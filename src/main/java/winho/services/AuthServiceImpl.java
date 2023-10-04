package winho.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import winho.entities.User;
import winho.models.dtos.UserDto;
import winho.models.request.SignupReq;
import winho.repositories.UserRepository;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto create(SignupReq signupReq) {

        User user = new User();
        user.setEmail(signupReq.getEmail());
        user.setName(signupReq.getName());
        user.setPhone(signupReq.getPhone());
        user.setPassword(new BCryptPasswordEncoder().encode(signupReq.getPassword()));

        User create = userRepository.save(user);
        UserDto userDto = new UserDto();
        userDto.setId(create.getId());
        userDto.setEmail(create.getEmail());
        userDto.setName(create.getName());
        userDto.setPhone(create.getPhone());
        return userDto;
    }
}
