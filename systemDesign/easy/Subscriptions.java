package systemDesign.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

// 1. Abstract Parent Class
abstract class Plan {

    private final String customer;
    private final String tier;

    // Constructor
    public Plan(String customer, String tier) {
        this.customer = customer;
        this.tier = tier;
    }

    // Abstract method: implemented by child classes
    public abstract double monthlyCost();

    // Common invoice logic
    public final String invoiceLine() {

        return String.format(
                Locale.US,
                "%s (%s): $%.2f",
                customer,
                tier,
                monthlyCost()
        );
    }
}

// 2. Free Plan
class FreePlan extends Plan {

    public FreePlan(String customer) {
        super(customer, "Free");
    }

    @Override
    public double monthlyCost() {
        return 0.0;
    }
}

// 3. Pro Plan
class ProPlan extends Plan {

    private static final double PRICE_PER_SEAT = 12.0;

    private final int seats;

    public ProPlan(String customer, int seats) {
        super(customer, "Pro");
        this.seats = seats;
    }

    @Override
    public double monthlyCost() {

        return seats * PRICE_PER_SEAT;
    }
}

// 4. Enterprise Plan
class EnterprisePlan extends Plan {

    private static final double PRICE_PER_SEAT = 20.0;

    private final int seats;
    private final double discountPercent;

    public EnterprisePlan(
            String customer,
            int seats,
            double discountPercent) {

        super(customer, "Enterprise");

        this.seats = seats;
        this.discountPercent = discountPercent;
    }

    @Override
    public double monthlyCost() {

        double basePrice = seats * PRICE_PER_SEAT;

        double discount = basePrice * discountPercent / 100.0;

        return basePrice - discount;
    }
}

// 5. Provided Subscriptions Class
class Subscriptions {

    private final List<Plan> plans = new ArrayList<>();

    public Subscriptions() {
    }

    public int addFree(String customer) {

        plans.add(new FreePlan(customer));

        return plans.size() - 1;
    }

    public int addPro(String customer, int seats) {

        plans.add(new ProPlan(customer, seats));

        return plans.size() - 1;
    }

    public int addEnterprise(
            String customer,
            int seats,
            double discountPercent) {

        plans.add(
                new EnterprisePlan(
                        customer,
                        seats,
                        discountPercent
                )
        );

        return plans.size() - 1;
    }

    public double monthlyCost(int index) {

        return plans.get(index).monthlyCost();
    }

    public String invoiceLine(int index) {

        return plans.get(index).invoiceLine();
    }

    public double totalMonthly() {

        double sum = 0.0;

        for (Plan plan : plans) {
            sum += plan.monthlyCost();
        }

        return sum;
    }

    public int planCount() {

        return plans.size();
    }


    public static void main(String[] args) {

        Subscriptions subscriptions = new Subscriptions();

        // Add Free Plan
        int freeIndex = subscriptions.addFree("Acme");

        // Add Pro Plan: 10 seats
        int proIndex = subscriptions.addPro("Globex", 10);

        // Add Enterprise Plan: 50 seats, 10% discount
        int enterpriseIndex =
                subscriptions.addEnterprise("Microsoft", 50, 10);

        // Display plan count
        System.out.println("Total Plans: "
                + subscriptions.planCount());

        // Display individual monthly costs
        System.out.println("\nMonthly Costs:");

        System.out.println("Free: $"
                + subscriptions.monthlyCost(freeIndex));

        System.out.println("Pro: $"
                + subscriptions.monthlyCost(proIndex));

        System.out.println("Enterprise: $"
                + subscriptions.monthlyCost(enterpriseIndex));

        // Display invoice lines
        System.out.println("\nInvoice Details:");

        System.out.println(subscriptions.invoiceLine(freeIndex));

        System.out.println(subscriptions.invoiceLine(proIndex));

        System.out.println(subscriptions.invoiceLine(enterpriseIndex));

        // Display total monthly billing
        System.out.println("\nTotal Monthly Revenue: $"
                + subscriptions.totalMonthly());
    }
}

