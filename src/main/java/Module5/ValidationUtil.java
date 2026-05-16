/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Module5;

public class ValidationUtil {
    public static boolean isValidEmail(
            String email
    ) {

        return email.contains("@")
                &&
                email.contains(".");
    }

    public static boolean isValidPhone(
            String phone
    ) {

        return phone.length() >= 11;
    }

    public static boolean isValidPassword(
            String password
    ) {

        return password.length() >= 6;
    }

}
