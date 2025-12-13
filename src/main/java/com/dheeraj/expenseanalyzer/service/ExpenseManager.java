package main.java.com.dheeraj.expenseanalyzer.service;

import main.java.com.dheeraj.expenseanalyzer.model.Expense;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExpenseManager {
    private final List<Expense> expenses = new ArrayList<>();

    public void addExpense(Expense expense) {
        if (expense == null || expense.getAmount() <= 0) {
            throw new IllegalArgumentException("Invalid Expense");
        }
        expenses.add(expense);
    }

    public List<Expense> getExpenses() {
        return new ArrayList<>(expenses);
    }

    public List<String> getExpenseTitles() {
        List<String> titles = expenses.stream().map(expense -> expense.getTitle()).toList();
        return titles;
    }

    public Map<String, List<Expense>> groupByCategory() {
        return expenses.stream().collect(Collectors.groupingBy(expense -> expense.getCategory()));
    }

    public Map<String, Double> totalAmountPerCategory() {
        return expenses.stream().collect(Collectors.groupingBy(Expense:: getCategory, Collectors.summingDouble(Expense::getAmount)));
    }
}
