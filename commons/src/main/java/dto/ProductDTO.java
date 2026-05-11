package dto;

import java.io.Serializable;

public class ProductDTO implements Serializable {
    private Integer id;
    private String name;
    private Double price;

    public ProductDTO(Double price, String name, Integer id) {
        this.price = price;
        this.name = name;
        this.id = id;
    }

    public ProductDTO() {}

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
