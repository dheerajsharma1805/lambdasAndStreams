package main.java.com.dheeraj.expenseanalyzer.util;

import main.java.com.dheeraj.expenseanalyzer.model.Expense;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortExpense {

    public List<Expense> sortedByAmount(List<Expense> expenses, String sortType) {
        String sortTypeIgnoreCase = sortType.toLowerCase();
        return expenses.stream().sorted(
                (e1, e2) -> sortTypeIgnoreCase.equals("desc")  ?
                        Double.compare(e2.getAmount(), e1.getAmount()) : Double.compare(e1.getAmount(), e2.getAmount())
        ).toList();
    }

    public List<Expense> getExpensesSortedByDateThenAmount(List<Expense> expenses) {
        return expenses.stream().sorted(
                Comparator.comparing(Expense::getDate).thenComparing(Expense::getAmount)
        ).toList();
    }
}
