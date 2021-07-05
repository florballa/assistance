package com.management.assistance.Service;

import com.management.assistance.Model.UserModel;
import com.management.assistance.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final static String USER_NOT_FOUND = "User with email %s not found!";
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, email)));

    }

    public String signUpUser(UserModel userModel){

        boolean userExists = userRepository.findByEmail(userModel.getEmail()).isPresent();

        if (userExists){
            throw new IllegalStateException("Email taken!");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(userModel.getPassword());

        userModel.setPassword(encodedPassword);

        userRepository.save(userModel);

        return "User Registered successfully!";

    }

}
