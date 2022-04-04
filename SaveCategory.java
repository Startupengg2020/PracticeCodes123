import entity.Catalog;
import entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveCategory {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Category category = new Category();
        category.setCategory_Name("Subject Name");
        category.setStatus("Active Now");

        Catalog catalog = new Catalog();
        catalog.setCatalog_Name("DBMS");

        category.getCatalogList().add(catalog);
        catalog.setCategory(category);

        Catalog c1 = new Catalog();
        c1.setCatalog_Name("Data Strcture");
        c1.setCategory(category);

        category.getCatalogList().add(c1);

        Catalog c2 = new Catalog();
        c2.setCatalog_Name("Compiler Design");
        c2.setCategory(category);

        category.getCatalogList().add(c2);

        session.persist(category);
        transaction.commit();
        System.out.println("****successfully  saved*****");
        factory.close();
        session.close();
    }
}
