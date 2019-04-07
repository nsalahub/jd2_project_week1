package com.gmail.salahub.nikolay.service.util;

public class SeparatorSelector {

    public static String getSeparatorOfNumbers(String string) {
        String separator = null;
        if (string.contains(",")) {
            separator = ",";
        }
        if (string.contains(":")) {
            separator = ":";
        }
        if (string.contains("|")) {
            separator = "|";
        }
        return separator;
    }
}
