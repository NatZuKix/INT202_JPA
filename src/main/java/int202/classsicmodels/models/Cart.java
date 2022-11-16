package int202.classsicmodels.models;

import java.util.*;

public class Cart {
    private Map<String ,Lineitem> cart=new HashMap<>();
    public  void  addItem(Lineitem x){
        String key=x.getProduct().getProductCode();
        Lineitem old=cart.get(key);
        if(old!=null){
            old.setAmount(old.getAmount()+x.getAmount());
        }else{
            cart.put(key,x);
        }
    }
    public void clear(){
        cart.clear();
    }
    public  double getTotalPrice(){
        double total=0;
        for (Lineitem x:cart.values()) {
            total=total+x.getTotalPrice();
        }
        return total;
    }
    public List<Lineitem> getItem(){
        Collection<Lineitem> lineitems =cart.values();
        return  new ArrayList(lineitems);
    }
}
