package com.aarya.javapractice;

import java.text.NumberFormat;
import java.util.*;

public class CurrencyFormatter {
    public static void currencyFormatter(double money) {
        NumberFormat us = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
        NumberFormat india = NumberFormat.getCurrencyInstance(new Locale("hi", "IN"));
        NumberFormat china = NumberFormat.getCurrencyInstance(new Locale("zh", "CN"));
        NumberFormat france = NumberFormat.getCurrencyInstance(new Locale("fr", "FR"));
        System.out.println("US: " + formattedString(us, money));
        System.out.println("India: " + formattedString(india, money));
        System.out.println("China: " + formattedString(china, money));
        System.out.println("France: " + formattedString(france, money));
    }

    public static String formattedString(NumberFormat formatter, double money) {
        return formatter.format(money);
    }

    public static void main(String arg[]) {
        currencyFormatter(12324.134);
    }
}
