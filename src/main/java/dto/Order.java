package dto;

/**
 * Created by Nikolay on 15.05.2016.
 */
public class Order {
   private Integer id;
    private User user;
    private Product product;
    private String suplement;
    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getSuplement() {
        return suplement;
    }

    public void setSuplement(String suplement) {
        this.suplement = suplement;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", product=" + product +
                ", suplement='" + suplement + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
