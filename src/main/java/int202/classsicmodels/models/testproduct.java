package int202.classsicmodels.models;

import int202.classsicmodels.entities.Product;
import int202.classsicmodels.repo.ProductRepo;

import java.util.List;

public class testproduct {
    public static void main(String[] args) {
        ProductRepo n1 =new ProductRepo();
        Product x=n1.find("S10_1949");
        Lineitem x1=new Lineitem(x);
        Cart mycart=new Cart();
        mycart.addItem(x1);
        mycart.addItem(x1);
        System.out.println(mycart.getItem().size());
    }
}
