package systemDesign.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

// 1. Abstract Discount class
abstract class Discount {

    public abstract double apply(double price);

    public abstract String label();

    // Common description logic
    public final String describe(double price) {

        double newPrice = apply(price);

        return String.format(
                Locale.US,
                "%s: $%.2f -> $%.2f",
                label(),
                price,
                newPrice
        );
    }
}

// 2. Percentage Discount
class PercentageDiscount extends Discount {

    private final int percent;

    public PercentageDiscount(int percent) {
        this.percent = percent;
    }

    @Override
    public double apply(double price) {
        return price * (1 - percent / 100.0);
    }

    @Override
    public String label() {
        return percent + "% off";
    }
}

// 3. Flat Discount
class FlatDiscount extends Discount {

    private final double amount;

    public FlatDiscount(double amount) {
        this.amount = amount;
    }

    @Override
    public double apply(double price) {
        return Math.max(0.0, price - amount);
    }

    @Override
    public String label() {
        return String.format(Locale.US, "$%.2f off", amount);
    }
}

// 4. Buy One Get One Free Discount
class BuyOneGetOneFree extends Discount {

    @Override
    public double apply(double price) {
        return price / 2.0;
    }

    @Override
    public String label() {
        return "Buy 1 Get 1 Free";
    }
}

// 5. Provided PricingEngine class
class PricingEngine {

    private final List<Discount> discounts = new ArrayList<>();

    public PricingEngine() {
    }

    public int addPercentage(int percent) {
        discounts.add(new PercentageDiscount(percent));
        return discounts.size() - 1;
    }

    public int addFlat(double amount) {
        discounts.add(new FlatDiscount(amount));
        return discounts.size() - 1;
    }

    public int addBuyOneGetOne() {
        discounts.add(new BuyOneGetOneFree());
        return discounts.size() - 1;
    }

    public double priceAfter(int index, double price) {
        return discounts.get(index).apply(price);
    }

    public String label(int index) {
        return discounts.get(index).label();
    }

    public String describe(int index, double price) {
        return discounts.get(index).describe(price);
    }

    public int discountCount() {
        return discounts.size();
    }

    public static void main(String[] args) {

        PricingEngine engine = new PricingEngine();

        // Add discounts
        int percentageIndex = engine.addPercentage(20);
        int flatIndex = engine.addFlat(15);
        int bogoIndex = engine.addBuyOneGetOne();

        // Percentage discount
        System.out.println("Percentage Discount:");
        System.out.println(engine.label(percentageIndex));
        System.out.println(engine.priceAfter(percentageIndex, 100));
        System.out.println(engine.describe(percentageIndex, 100));

        System.out.println();

        // Flat discount
        System.out.println("Flat Discount:");
        System.out.println(engine.label(flatIndex));
        System.out.println(engine.priceAfter(flatIndex, 100));
        System.out.println(engine.describe(flatIndex, 100));

        System.out.println();

        // Buy One Get One Free
        System.out.println("Buy One Get One Free:");
        System.out.println(engine.label(bogoIndex));
        System.out.println(engine.priceAfter(bogoIndex, 79.98));
        System.out.println(engine.describe(bogoIndex, 79.98));

        System.out.println();

        // Total discount count
        System.out.println("Total Discounts: " + engine.discountCount());
    }
}
