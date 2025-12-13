package main.java.com.dheeraj.expenseanalyzer.util;

import main.java.com.dheeraj.expenseanalyzer.model.Expense;

import java.util.List;

public class FilterExpense {
    public List<Expense> getExpenseAbove (List<Expense> expenses , double amount) {
        return expenses.stream().filter((a) -> a.getAmount() > amount).toList();
    }
}
