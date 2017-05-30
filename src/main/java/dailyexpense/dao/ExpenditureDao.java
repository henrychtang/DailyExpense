package dailyexpense.dao;

import dailyexpense.entity.Expenditure;
import dailyexpense.entity.ExpenditureCategory;
import dailyexpense.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Component
public class ExpenditureDao {
    @Autowired
    SessionFactory sessionFactory;


    public String addCategory(String name) {
        String userId;
        try {
            ExpenditureCategory expenditureCategory = new ExpenditureCategory(name);
            sessionFactory.getCurrentSession().save(expenditureCategory);
            userId = String.valueOf(expenditureCategory.getId());

        } catch (Exception ex) {
            return "Error creating the expenditure expenditure: " + ex.toString();
        }
        return userId;
    }


    public String addExpendure(String date, String category, String amount) {
        String id;
        try {
            Expenditure expenditure = new Expenditure(date, category, amount);
            sessionFactory.getCurrentSession().save(expenditure);
            id = String.valueOf(expenditure.getId());

        } catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return id;
    }


    public List<Expenditure> getExpenditureList() {
        final List<Expenditure> list = sessionFactory.getCurrentSession()
                .createQuery("from Expenditure").list();
        System.out.println(list);
        return list;
    }

    public List<ExpenditureCategory> listExpendlistCategory() {
        final List<ExpenditureCategory> list = sessionFactory.getCurrentSession()
                .createQuery("from User").list();
        return list;
    }

    public String deleteExpenditure(String id) {
        String userId;
        try {
            System.out.println("want to detlete: " +id);
            Expenditure expenditure = new Expenditure();
            expenditure.setId(Integer.parseInt(id));
            sessionFactory.getCurrentSession().delete(expenditure);
            userId = String.valueOf(expenditure.getId());

        } catch (Exception ex) {
            return "Error deleteing the expenditure expenditure: " + ex.toString();
        }
        return userId;
    }
}
