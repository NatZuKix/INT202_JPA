package int202.classsicmodels.models;

import int202.classsicmodels.entities.Product;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Lineitem {
    private Product product;
    private double Price;
    private int amount;

    public  Lineitem(Product p,int amount){
        this.product=p;
        this.Price=p.getMSRP().doubleValue();
        this.amount=amount;
    }
    public  Lineitem(Product p){
        this(p,1);
    }
    public   double getTotalPrice(){
        return Price*amount;
    }
}
