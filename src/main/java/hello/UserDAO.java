package hello;

import model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by henry on 26/2/2017.
 */
@Transactional
@Component
public class UserDAO {
    @Autowired
    SessionFactory sessionFactory;

    public String addUser(String name, String email){
        String userId;
        try{
            User user = new User(email, name);
            sessionFactory.getCurrentSession().save(user);
            userId=String.valueOf(user.getId());

        }catch (Exception ex){
            return "Error creating the user: " + ex.toString();
        }
        return userId;
    }
    public List<User> listUsers(){
        final List<User> list=sessionFactory.getCurrentSession()
                .createQuery("from User").list();
        return list;
    }
}
