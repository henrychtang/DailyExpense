package dailyexpense.model;

import java.util.Date;

/**
 * Created by Henry on 3/6/2017.
 */
public class Expense {
    int id;
    Date date;
    String category;
    String amount;

    public Expense() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public String getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", category='" + category + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
