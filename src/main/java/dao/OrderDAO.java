package dao;

import dto.Order;
import dto.Product;
import dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Nikolay on 15.05.2016.
 */
public class OrderDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final String SELECT_ALL_ORDERS = "SELECT * FROM orders o INNER JOIN products p ON o.product_id = p.id INNER JOIN users u ON o.customer_id = u.id";
    private static final String SELECT_ORDERS_BY_AUTHOR = "SELECT * FROM orders o INNER JOIN products p ON o.product_id = p.id INNER JOIN users u ON o.customer_id = u.id WHERE u.login = ?";

            public List<Order> getOrders (){
                List<Order> orders = jdbcTemplate.query(SELECT_ALL_ORDERS, new OrderRowMapper());
                return orders;
            }

    public List<Order> getOrdersByAuthor (String customer){
        List<Order> orderList = jdbcTemplate.query(SELECT_ORDERS_BY_AUTHOR, new OrderRowMapper(), customer);
        return orderList;
    }





    public static class OrderRowMapper implements RowMapper<Order>{

        @Autowired
        public Order mapRow (ResultSet resultSet, int i) throws SQLException{
            Order order = new Order();
            order.setId(resultSet.getInt("id"));
            order.setState(resultSet.getString("state"));
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setLogin(resultSet.getString("login"));
            user.setMail(resultSet.getString("mail"));
            user.setName(resultSet.getString("name"));
            user.setPhone(resultSet.getInt("phone"));
            order.setUser(user);
            Product product = new Product();
            product.setId(resultSet.getInt("id"));
            product.setTitle(resultSet.getString("title"));
            product.setDescription(resultSet.getString("description"));
            product.setPrice(resultSet.getInt("price"));
            order.setProduct(product);
            return order;
        }

    }
}
