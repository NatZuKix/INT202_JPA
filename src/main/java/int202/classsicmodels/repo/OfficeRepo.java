package int202.classsicmodels.repo;

import int202.classsicmodels.entities.Office;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

import static int202.classsicmodels.repo.EntityManagerBuilder.getEntityManager;

@AllArgsConstructor
@NoArgsConstructor
public class OfficeRepo {
    private EntityManager entityManager;

    private EntityManager EntityManagergetEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = getEntityManager();
        }
        return entityManager;
    }

    public List<Office> findAll() {
        return getEntityManager().createQuery("select o from Office o").getResultList();
    }

    public Office find(String officeCode) {
        return getEntityManager().find(Office.class, officeCode);
    }

    public List<Office> findByCityOrCountry(String cityOrCoutry) {
        cityOrCoutry = cityOrCoutry.toLowerCase() + '%';
        Query qr = getEntityManager().createNamedQuery("FINDBYCITYORCOUNTRY");
        qr.setParameter("city", cityOrCoutry);
        qr.setParameter("country", cityOrCoutry);
        return qr.getResultList();
    }

    public boolean insert(Office office) {
        try {
            EntityManager entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(office);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean delete(Office office) {
        if (office != null) {
            EntityManager entityManager = getEntityManager();
            if (entityManager.contains(office)) {
                entityManager.getTransaction().begin();
                entityManager.remove(office);
                entityManager.getTransaction().commit();
                return true;
            } else {
                return delete(office.getOfficeCode());
            }
        }
        return false;
    }

    public boolean delete(String officeCode) {
        EntityManager entityManager = getEntityManager();
        Office office = find(officeCode);
        if (office != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(office);
            entityManager.getTransaction().commit();
            return true;
        }
        return false;
    }

    //useforupdate
    public EntityTransaction getTransaction() {
        return getEntityManager().getTransaction();
    }
}

