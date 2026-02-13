package com.soham.airbnb.serviceimpl;

import com.soham.airbnb.dto.request.LoginRequest;
import com.soham.airbnb.dto.request.SignUpRequest;
import com.soham.airbnb.entity.Role;
import com.soham.airbnb.entity.User;
import com.soham.airbnb.repository.RoleRepository;
import com.soham.airbnb.repository.UserRepository;
import com.soham.airbnb.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {



    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


     public void register(SignUpRequest request){
         if(userRepository.existsByEmail(request.getEmail())){
             throw new RuntimeException("Email already exists");
         }
     Role userRole = roleRepository.findByName("ROLE_USER")
             .orElseThrow(() -> new RuntimeException("Role Not found "));

     User user =new User();
     user.setName(request.getName);
     user.setEmail(request.getEmail());
     user.setPassword(passwordEncoder.encode(request.getPassword())) ;
     user.setRoles(Set.of(userRole));
     userRepository.save(user);




     }

     public String login(LoginRequest request ){
         return "JWT TOKEN PLACEHOLDER";
     }
}
