package com.management.assistance.Service;

import com.management.assistance.Model.RegistrationRequest;
import com.management.assistance.Model.UserModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.management.assistance.Model.UserRole.TECHNICIANS;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;

    public String register(RegistrationRequest request) {

        return userService.signUpUser(
                new UserModel(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        TECHNICIANS
                )
        );
    }
}
