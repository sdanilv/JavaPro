import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;


public class RoomData {
    static EntityManager em;
    static EntityManagerFactory emf;


    RoomData() {
        emf = Persistence.createEntityManagerFactory("JPA");
        em = emf.createEntityManager();
    }

    public void addApartmentWithRandomParam(int count) {
        try {
            em.getTransaction().begin();
            for (int i = 0; i < count; i++) {
                em.persist(ApartmentBuilder.createApartmentWithRandomParam());
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void addApartmentToDB(Apartment apartment) {
        try {
            em.getTransaction().begin();
            em.persist(apartment);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }


    public void searchApartmentForPrice(int price) {
        Query query = em.createQuery("select a from Apartment a where price=:price", Apartment.class);
        query.setParameter("price", price);
        List<Apartment> apartments = (List<Apartment>) query.getResultList();
        for (Apartment apartment : apartments) {
            System.out.println(apartment);
        }

    }

    public void searchApartmentForArea(int area) {
        Query query = em.createQuery("select a from Apartment a where area=:area", Apartment.class);
        query.setParameter("area", area);
        List<Apartment> apartments = (List<Apartment>) query.getResultList();
        for (Apartment apartment : apartments) {
            System.out.println(apartment);
        }

    }

    public void searchApartmentForCountRoom(int countRoom) {
        Query query = em.createQuery("select a from Apartment a where countRoom=:countRoom", Apartment.class);
        query.setParameter("countRoom", countRoom);
        List<Apartment> apartments = (List<Apartment>) query.getResultList();
        for (Apartment apartment : apartments) {
            System.out.println(apartment);
        }
    }

    public void searchApartmentForDistrict(String district) {
        Query query = em.createQuery("select a from Apartment a where district=:district", Apartment.class);
        query.setParameter("district", district);
        List<Apartment> apartments = (List<Apartment>) query.getResultList();
        for (Apartment apartment : apartments) {
            System.out.println(apartment);
        }
    }

    public void searchApartmentForAddress(String adress) {
        Query query = em.createQuery("select a from Apartment a where adress=:adress", Apartment.class);
        query.setParameter("adress", adress);
        List<Apartment> apartments = (List<Apartment>) query.getResultList();
        for (Apartment apartment : apartments) {
            System.out.println(apartment);
        }

    }

//    public void searchApartmentForParam(String param, int count) {
//        Query query = em.createQuery("select a from Apartment a where :param=:count", Apartment.class);
//        query.setParameter("param", "a."+param);
//        query.setParameter("count", count);
//        List<Apartment> apartments = (List<Apartment>) query.getResultList();
//        for (Apartment apartment : apartments) {
//            System.out.println(apartment);
//        }
//    }

    public void close() {
        em.close();
        emf.close();
    }
}
