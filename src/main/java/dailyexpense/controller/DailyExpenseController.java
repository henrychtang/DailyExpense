package dailyexpense.controller;

import dailyexpense.dao.ExpenditureDao;
import dailyexpense.entity.Expenditure;
import dailyexpense.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DailyExpenseController {

    @Autowired
    ExpenditureDao expenditureDao;

//    @RequestMapping("/expense/add")
//    public String addExpense(@RequestParam String date, String category, String amount) {
//        String id = expenditureDao.addExpendure(date, category, amount);
//        return id;
//    }

    @RequestMapping("/expense/delete_json")
    public String deleteExpense(@RequestBody Expense expense) {
        String id = expenditureDao.deleteExpenditure(expense.getId());
        return id;
    }

    @RequestMapping("/expense/add_json")
    public String addExpense(@RequestBody Expense expense) {
        String id = expenditureDao.addExpendure(expense.getDate(), expense.getCategory(), expense.getAmount());
        return id;
    }

    @RequestMapping("/expense/list")
    public List<Expenditure> listExpense() {
        return expenditureDao.getExpenditureList();
    }

    @RequestMapping("/expense/delete/{id}")
    public String deletExpense(@PathVariable("id") String id) {

        return expenditureDao.deleteExpenditure(id);
    }

    @RequestMapping("/reportbydate")
    public boolean reportByDate(@RequestParam String date) {

        return true;
    }
}
