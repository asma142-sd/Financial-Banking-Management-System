/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Module1;
import java.util.ArrayList;

import Module5.SecurityUtil;
import Module5.ValidationUtil;

public class AuthenticationService {
    private ArrayList<User> users =
            new ArrayList<>();

    public void registerUser(
            String name,
            String email,
            String phone,
            String dob,
            String nationalId,
            String password,
            UserRole role
    ) {

        if(!ValidationUtil.isValidEmail(email)) {
            System.out.println("Invalid Email");
            return;
        }

        String encrypted =
                SecurityUtil.hashPassword(password);

        User user = new User(
                name,
                email,
                phone,
                dob,
                nationalId,
                encrypted,
                role
        );

        users.add(user);

        System.out.println("User Registered");
    }

    public User login(
            String email,
            String password
    ) {

        for(User user : users) {

            if(user.getEmail().equals(email)) {

                if(user.isLocked()) {
                    System.out.println("Account Locked");
                    return null;
                }

                String encrypted =
                        SecurityUtil.hashPassword(password);

                if(user.getPassword().equals(encrypted)) {

                    user.resetAttempts();

                    System.out.println("Login Successful");

                    return user;
                }
                else {

                    user.incrementAttempts();

                    System.out.println(
                            "Wrong Password"
                    );
                }
            }
        }

        return null;
    }

}
