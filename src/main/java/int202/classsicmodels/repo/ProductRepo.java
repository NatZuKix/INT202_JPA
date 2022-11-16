package int202.classsicmodels.repo;

import int202.classsicmodels.entities.Office;
import int202.classsicmodels.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

import static int202.classsicmodels.repo.EntityManagerBuilder.getEntityManager;

public class ProductRepo {
    private  static int PAGE_SIZE=10;
    public static int getPageSize(){
        return  PAGE_SIZE;
    }
    public List<Product>findAll(int page,int pagesize) {
        int StatPosition = (page - 1) * pagesize;
        EntityManager classicmodel = EntityManagerBuilder.getEntityManager();
        Query query = classicmodel.createNamedQuery("FIND_ALL");
        query.setFirstResult(StatPosition);
        query.setMaxResults(pagesize);
        List<Product> x =query.getResultList();
        classicmodel.close();
        return  x;
    }
    public static Product find(String p){
        EntityManager classicmodel = EntityManagerBuilder.getEntityManager();
        return  classicmodel.find(Product.class,p);
    }
    public static int CountALL(){
        EntityManager classicmodel = EntityManagerBuilder.getEntityManager();
        Query query = classicmodel.createNamedQuery("Product.count");
        int cont = ((Number)query.getSingleResult()).intValue();
        classicmodel.close();
        return  cont;
    }

}
