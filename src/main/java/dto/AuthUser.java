package dto;

/**
 * Created by Nikolay on 28.03.2016.
 */
public class AuthUser {
    private Integer id;
    private String name;
    private String role;
    public static final String ROLE_ADMIN = "ROLE_ADMIN";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "AuthUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
