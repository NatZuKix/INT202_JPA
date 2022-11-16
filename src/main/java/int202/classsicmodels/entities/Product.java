package int202.classsicmodels.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Entity
@Table(name = "products")
@Setter
@NamedQueries({
        @NamedQuery(name = "FIND_ALL", query = "select P from Product P"),
        @NamedQuery(name = "Product.count", query = "SELECT count(p) as count FROM Product p"),
})
public class Product {
    @Id
    private  String productCode;
    private  String productName;
    private  String productLine;
    private  String productScale;
    private  String productDescription;
    @Column(name = "quantityInstock")
    private  int quantityInStock;
    private BigDecimal buyPrice;
    private  BigDecimal MSRP;

}
