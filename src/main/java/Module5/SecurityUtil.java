/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Module5;
import java.util.Base64;

public class SecurityUtil {
        public static String hashPassword(
            String password
    ) {

        return Base64.getEncoder()
                .encodeToString(
                        password.getBytes()
                );
    }

    public static String encrypt(
            String data
    ) {

        return Base64.getEncoder()
                .encodeToString(
                        data.getBytes()
                );
    }

    public static String decrypt(
            String encrypted
    ) {

        byte[] decoded =
                Base64.getDecoder()
                .decode(encrypted);

        return new String(decoded);
    }

    public static String maskAccountNumber(
            String accountNumber
    ) {

        return "******" +
                accountNumber.substring(6);
    }

}
