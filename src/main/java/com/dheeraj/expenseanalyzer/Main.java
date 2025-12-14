package com.dheeraj.expenseanalyzer;

import com.dheeraj.expenseanalyzer.model.Expense;
import com.dheeraj.expenseanalyzer.service.ExpenseManager;
import com.dheeraj.expenseanalyzer.util.FilterExpense;
import com.dheeraj.expenseanalyzer.util.SortExpense;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        ExpenseManager manager = new ExpenseManager();

        // ---------- Sample Data ----------
        manager.addExpense(new Expense(
                "1", "Milk Packet", "Food", 60,
                LocalDate.now(), List.of("Food", "Dairy")
        ));

        manager.addExpense(new Expense(
                "2", "Pizza", "Food", 400,
                LocalDate.now(), List.of("Food", "Junk")
        ));

        manager.addExpense(new Expense(
                "3", "Uber Ride", "Travel", 250,
                LocalDate.now(), List.of("Travel", "Cab")
        ));

        manager.addExpense(new Expense(
                "4", "Netflix", "Subscription", 199,
                LocalDate.now(), List.of("Subscription", "Entertainment")
        ));

        // ---------- Get All Expenses ----------
        System.out.println("\n===== ALL EXPENSES =====");
        manager.getExpenses().forEach(System.out::println);

        // ---------- Filter: Above Amount ----------
        System.out.println("\n===== ABOVE 100 (filter + map) =====");
        FilterExpense filter = new FilterExpense();
        filter.getExpenseAbove(manager.getExpenses(), 100)
                .forEach(System.out::println);

        // ---------- Group By Category ----------
        System.out.println("\n===== GROUP BY CATEGORY =====");
        manager.groupByCategory().forEach((k, v) ->
                System.out.println(k + " -> " + v.size())
        );

        // ---------- Total Spend Per Category ----------
        System.out.println("\n===== TOTAL PER CATEGORY =====");
        manager.totalAmountPerCategory().forEach((k, v) ->
                System.out.println(k + " -> " + v)
        );

        // ---------- Sort By Amount ----------
        System.out.println("\n===== SORTED BY AMOUNT =====");
        SortExpense sort = new SortExpense();
        sort.sortedByAmount(manager.getExpenses(), "desc")
                .forEach(System.out::println);

        // ---------- Total Spend (Reduce vs Sum) ----------
        System.out.println("\n===== TOTAL SPEND =====");
        System.out.println("Total (reduce): " + manager.getTotalSpendUsingReduce());
        System.out.println("Total (sum):    " + manager.getTotalSpendUsingSum());
    }
}
