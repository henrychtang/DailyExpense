package dailyexpense.dao;

import dailyexpense.entity.Expenditure;
import dailyexpense.entity.ExpenditureCategory;
import dailyexpense.entity.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.tool.schema.extract.internal.TableInformationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ExceptionDepthComparator;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    public String deleteExpenditure(int id){
        try {
            Expenditure expenditure = new Expenditure();
            expenditure.setId(id);
            sessionFactory.getCurrentSession().delete(expenditure);
            return true+"";
        }catch (Exception ex){
            return "Error deleting the expenditure: " + ex.toString();

        }
    }

    public String addExpendure(Date date, String category, String amount) {
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
        return list;
    }

    public String deleteExpenditure(String id) {
        String userId;
        try {
            Expenditure expenditure = new Expenditure();
            expenditure.setId(Integer.parseInt(id));
            sessionFactory.getCurrentSession().delete(expenditure);
            userId = String.valueOf(expenditure.getId());
        } catch (Exception ex) {
            return "Error deleteing the expenditure expenditure: " + ex.toString();
        }
        return userId;
    }

    public List<String> getDistinctDateList() {

        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Expenditure.class)
                .setProjection(Projections.distinct(Projections.property("date")));
        List <Timestamp> dateList=crit.list();
        //List<String> dateStringList = dateList.stream()
        // .map( it -> new SimpleDateFormat("yyyy-MM-dd").format(it)).collect(Collectors.toList());
        return convertToDistintSet(dateList);

    }

    public List<String> convertToDistintSet(List<Timestamp> dateList) {
        List<String> listWithoutDuplicates = dateList.stream()
                .map( it -> new SimpleDateFormat("yyyy-MM").format(it))
                .distinct()
                .collect(Collectors.toList());

        return listWithoutDuplicates;
    }

    public List<Expenditure> getExpenditureList(String date) {
        final List<Expenditure> list = sessionFactory.getCurrentSession()
                .createQuery("from Expenditure").list();

        List<Expenditure> result = list.stream()                // convert list to stream
                .filter(expenditure -> date.equals(new SimpleDateFormat("yyyy-MM").format(expenditure.getDate())))
                .collect(Collectors.toList());
        return result;
    }
}
