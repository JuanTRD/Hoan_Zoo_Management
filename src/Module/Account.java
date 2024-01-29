package Module;
import Module.Role;
import Module.Staff;
public class Account {
    private String username;
    private String password;
    private Role role;
    private Staff staff;
    public Account() {
    }

    public Account(String username, String password, Role role, Staff staff) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.staff = staff;

    }



    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return username +
                "," + password +
                "," + role +
                "," + staff;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
