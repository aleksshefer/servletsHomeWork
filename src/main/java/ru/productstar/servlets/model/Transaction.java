package ru.productstar.servlets.model;

public record Transaction(String name, int sum) {

    @Override
    public String toString() {
        return "Transaction{" +
                "name='" + name + '\'' +
                ", sum=" + sum +
                '}';
    }
}
