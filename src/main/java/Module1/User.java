/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Module1;


public class User {
    private String fullName;
    private String email;
    private String phone;
    private String dob;
    private String nationalId;
    private String password;
    private UserRole role;

    private int failedAttempts;
    private boolean locked;

    public User(
            String fullName,
            String email,
            String phone,
            String dob,
            String nationalId,
            String password,
            UserRole role
    ) {

        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
        this.nationalId = nationalId;
        this.password = password;
        this.role = role;

        failedAttempts = 0;
        locked = false;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    public boolean isLocked() {
        return locked;
    }

    public void incrementAttempts() {

        failedAttempts++;

        if(failedAttempts >= 5) {
            locked = true;
        }
    }

    public void resetAttempts() {
        failedAttempts = 0;
    }

    public void resetPassword(String newPassword) {
        password = newPassword;
    }

}
