package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by henry on 26/2/2017.
 */
@Controller
public class UserController {
    @Autowired
    UserDAO userDAO;

    @GetMapping("/adduser")
    @ResponseBody
    public String addUser(@RequestParam String email, String name) {
        return userDAO.addUser(name, email);
    }

    @GetMapping("/getuserlist")
    @ResponseBody
    public List getUserList() {
        return userDAO.listUsers();
    }
}
