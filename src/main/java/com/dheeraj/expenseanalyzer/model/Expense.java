package main.java.com.dheeraj.expenseanalyzer.model;

import java.time.LocalDate;

public class Expense {
    private String id;
    private String title;
    private String category;
    private double amount;
    private LocalDate date;

    public Expense(String id, String title, String category, double amount, LocalDate date) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.date = date;
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

    @Override
    public String toString() {
        return title + " | " + category + " | " + amount + " | " + date;
    }

}
