package n3.currency;

import java.util.function.Function;

public class CurrencyConverter {
    private static final float EURO_TO_DOLLAR = 1.1f;
    private static final float EURO_TO_POUND = 0.88f;
    private static final float DOLLAR_TO_POUND = 0.81f;

    public static float convertEuroToDollar(float amount) {
        return amount * EURO_TO_DOLLAR;
    }
    public static float convertDollarToEuro(float amount) {
        return amount / EURO_TO_DOLLAR;
    }
    public static float convertEuroToPound(float amount) {
        return amount * EURO_TO_POUND;
    }
    public static float convertPoundToDollar(float amount) {
        return amount / DOLLAR_TO_POUND;
    }
    public static float convertPoundToEuro(float amount) {
        return amount / EURO_TO_POUND;
    }
    public static float convertDollarToPound(float amount) {
        return amount * DOLLAR_TO_POUND;
    }


    public static float getCurrencyConversion(float amount, Currency original, Currency target) {
        if (original == target)
            return amount;

        switch (original) {
            case Euro -> {
                switch (target) {
                    case Dollar : return convertEuroToDollar(amount);
                    case Pound : return convertEuroToPound(amount);
                }
            }
            case Dollar -> {
                switch (target) {
                    case Euro : return convertDollarToEuro(amount);
                    case Pound : return convertDollarToPound(amount);
                }
            }
            case Pound -> {
                switch (target) {
                    case Euro : return convertPoundToEuro(amount);
                    case Dollar : return convertPoundToDollar(amount);
                }
            }
        }
        return -1;
    }

    public static String getSymbol(Currency c) {
        switch (c) {
            case Euro:
                return "€";
            case Pound:
                return "£";
            case Dollar:
                return "$";
            default:
                return "?";
        }
    }
}
