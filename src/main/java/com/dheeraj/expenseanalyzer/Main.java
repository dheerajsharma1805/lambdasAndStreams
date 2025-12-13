package main.java.com.dheeraj.expenseanalyzer;

import main.java.com.dheeraj.expenseanalyzer.model.Expense;
import main.java.com.dheeraj.expenseanalyzer.service.ExpenseManager;
import main.java.com.dheeraj.expenseanalyzer.util.FilterExpense;
import main.java.com.dheeraj.expenseanalyzer.util.SortExpense;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ExpenseManager manager = new ExpenseManager();

        manager.addExpense(new Expense("1", "Milk", "Food", 60, LocalDate.now()));
        manager.addExpense(new Expense("2", "Pizza", "Food", 400, LocalDate.now()));
        manager.addExpense(new Expense("3", "Uber", "Travel", 250, LocalDate.now()));

        List<Expense> expensesList = new ArrayList<>(manager.getExpenses());
        System.out.println("---- Above 100 ----");
        FilterExpense filter = new FilterExpense();
        filter.getExpenseAbove(expensesList, 100).forEach(System.out::println);

        System.out.println("---- Grouped ----");
        manager.groupByCategory().forEach((k,v) ->
                System.out.println(k + " -> " + v.size())
        );

        System.out.println("---- Sorted by Amount ----");
        SortExpense sort = new SortExpense();
        sort.sortedByAmount(expensesList, " ").forEach(System.out::println);

    }
}
