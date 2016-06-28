package dao;

import dto.AuthUser;
import dto.Role;
import dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Nikolay on 15.02.2016.
 */
public class UserDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String SELECT_ALL = "SELECT * FROM users INNER JOIN roles ON users.user_role = roles.id";
    private static final String SELECT_AUTH_USER = "SELECT users.id, users.name, roles.authority FROM users INNER JOIN roles ON users.role_id = roles.id WHERE users.login=?";
    private static final String SELECT_BY_ID = "SELECT * FROM users WHERE id=?";
    private static final String INSERT = "INSERT INTO users (login, password, mail, name, phone) VALUES (?, ?, ?, ?, ?)";

    public List<User> getUsers() {
        List<User> users = jdbcTemplate.query(SELECT_ALL, new UserRowMapper());
        return users;
    }

    public AuthUser getAuthUser(String login) {
        AuthUser authUser = jdbcTemplate.queryForObject(SELECT_AUTH_USER, new AuthUserRowMaper(), login);
        return authUser;
    }

    public User getUserById(Integer id) {
        User user = jdbcTemplate.queryForObject(SELECT_BY_ID, new UserRowMapper(), id);
        return user;
    }

    public void addUser(User user) {
        jdbcTemplate.update(INSERT, user.getLogin(), user.getPassword(), user.getMail(), user.getName(), user.getPhone());
    }


    public static class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setEnabled(resultSet.getBoolean("enabled"));
            user.setMail(resultSet.getString("mail"));
            user.setName(resultSet.getString("name"));
            user.setPhone(resultSet.getInt("phone"));
            Role role = new Role();
            role.setId(resultSet.getInt("id"));
            role.setAuthority(resultSet.getString("authority"));
            user.setRole(role);
            return user;
        }
    }

    public static class RoleRowMapper implements RowMapper<Role> {

        @Override
        public Role mapRow(ResultSet resultSet, int i) throws SQLException {
            Role role = new Role();
            role.setId(resultSet.getInt("id"));
            role.setAuthority(resultSet.getString("authority"));
            return role;
        }
    }

    public static class AuthUserRowMaper implements RowMapper<AuthUser> {
        @Override
        public AuthUser mapRow(ResultSet resultSet, int i) throws SQLException {
            AuthUser authUser = new AuthUser();
            authUser.setId(resultSet.getInt("id"));
            authUser.setName(resultSet.getString("name"));
            authUser.setRole(resultSet.getString("authority"));
            return authUser;
        }
    }
}
