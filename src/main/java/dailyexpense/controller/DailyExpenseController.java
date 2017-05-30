package dailyexpense.controller;

import dailyexpense.dao.ExpenditureDao;
import dailyexpense.entity.Expenditure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DailyExpenseController {

    @Autowired
    ExpenditureDao expenditureDao;

    @RequestMapping("/expense/add")
    public String addExpense(@RequestParam String date, String category, String amount) {
        String id = expenditureDao.addExpendure(date, category, amount);
        return id;
    }

    @RequestMapping("/expense/list")
    public List<Expenditure> listExpense() {

        System.out.print(expenditureDao.getExpenditureList().toString());

        return  expenditureDao.getExpenditureList();
    }
    @RequestMapping("/expense/delete/{id}")
    public String deletExpense(@PathVariable("id") String id) {

        return  expenditureDao.deleteExpenditure(id);
    }

    @RequestMapping("/reportbydate")
    public boolean reportByDate(@RequestParam String date) {

        return true;
    }
}
