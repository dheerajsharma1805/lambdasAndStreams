package main.java.com.dheeraj.expenseanalyzer.service;

import main.java.com.dheeraj.expenseanalyzer.model.Expense;

import java.util.*;
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

    public List<Double> getAmountsWithGST(double gstPercent) {
        return expenses.stream().map(expense -> expense.getAmount() + expense.getAmount() * gstPercent).toList();
    }

    public List<String> showExpenseTitlesAbove(double amount) {
        return expenses.stream().filter(expense -> expense.getAmount() > amount).map(expense -> expense.getTitle()).toList();
    }

    public Set<String> getAllUniqueTags() {
        return expenses.stream().map(
                e -> e.getTags()
        ).filter(Objects::nonNull).flatMap(
                list -> list.stream()
        ).map(t -> t.toLowerCase()).collect(
                Collectors.toSet()
        );
    }

    public Map<String, Long> getTagUsageCount() {
        return expenses.stream().map(e -> e.getTags()).filter(Objects:: nonNull).flatMap(List::stream)
                .map(t -> t.toLowerCase()).collect(Collectors.groupingBy(tag -> tag, Collectors.counting()));
    }

    public double getTotalSpendUsingReduce() {
        return expenses.stream().map(expense -> expense.getAmount()).reduce(0.0, (e1, e2) -> e1 + e2);
    }

    public double getTotalSpendUsingSum() {
        return expenses.stream().mapToDouble(value -> value.getAmount()).sum();
    }
}
