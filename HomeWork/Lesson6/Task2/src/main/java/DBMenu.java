import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DBMenu {

    private EntityManagerFactory emf;
    private EntityManager em;

    public DBMenu() {
        emf = Persistence.createEntityManagerFactory("JPA");
        em = emf.createEntityManager();
    }

    public void addDish(String name, int price, int weight, boolean sale) {
        em.getTransaction().begin();
        try {
            Dish d = new Dish(name, price, weight);
            d.setSale(sale);
            em.persist(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void addDish(String name, int price, int weight) {
        em.getTransaction().begin();
        try {
            Dish d = new Dish(name, price, weight);
            em.persist(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void addDish(Dish dish) {
        em.getTransaction().begin();
        try {
            em.persist(dish);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void lookFromToPrice(int from, int to) {
        Query query = em.createQuery("select a from Dish a where price>:min and price<:max");
        query.setParameter("min", from);
        query.setParameter("max", to);
        see(query);
    }

    public void lookWithSale() {
        Query query = em.createQuery("select a from Dish a where sale = true ");
        see(query);
    }

    public void seeRandomKilo(){
        Random random = new Random();
        Query query = em.createQuery("select a from Dish a");
        List list = query.getResultList();
        int mass =0;
        while (mass<900){
            Dish dish = (Dish) list.get(random.nextInt(list.size()));
            System.out.println(dish);
            mass+=dish.getWeight();
        }
    }

    public void see(Query query){
        ArrayList<Dish> list = (ArrayList<Dish>) query.getResultList();
        for (Dish dish : list) {
            System.out.println(dish);
        }
    }

    public  void generateList() {
        addDish("fried chicken", 12, 100,true);
        addDish("fried cow", 20, 100);
        addDish("fried rabbit", 15, 100);
        addDish("fried crocodile", 80, 100,true);
        addDish("rice", 5, 200);
        addDish("buckwheat", 4, 200);
        addDish("potato", 5, 200,true);
    }

    public void close() {
        em.close();
        emf.close();
    }
}
