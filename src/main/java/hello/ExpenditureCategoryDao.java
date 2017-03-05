package hello;

import model.ExpenditureCategory;
import model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Component
public class ExpenditureCategoryDao {
    @Autowired
    SessionFactory sessionFactory;


    public String addCategory(String name){
        String userId;
        try{
            ExpenditureCategory expenditureCategory = new ExpenditureCategory(name);
            sessionFactory.getCurrentSession().save(expenditureCategory);
            userId=String.valueOf(expenditureCategory.getId());

        }catch (Exception ex){
            return "Error creating the expenditure expenditure: " + ex.toString();
        }
        return userId;
    }
    public List<ExpenditureCategory> listExpendliskCategory(){
        final List<ExpenditureCategory> list=sessionFactory.getCurrentSession()
                .createQuery("from User").list();
        return list;
    }
}
