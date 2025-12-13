package main.java.com.dheeraj.expenseanalyzer.model;

import java.time.LocalDate;
import java.util.List;

public class Expense {
    private String id;
    private String title;
    private String category;
    private double amount;
    private LocalDate date;
    private List<String> tags;

    public Expense(String id, String title, String category, double amount, LocalDate date, List<String> tags) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getCategory() {
        return this.category;
    }

    public double getAmount() {
        return this.amount;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public List<String> getTags() {
        return this.tags;
    }

    @Override
    public String toString() {
        return title + " | " + category + " | " + amount + " | " + date;
    }

}
