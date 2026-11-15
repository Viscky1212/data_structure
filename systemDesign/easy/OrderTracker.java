package systemDesign.easy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 1. Order status enum
enum OrderStatus {
    PLACED,
    PACKED,
    SHIPPED,
    DELIVERED,
    CANCELLED;

    private List<OrderStatus> transitions;

    // Initialize allowed transitions after all enum constants exist
    static {
        PLACED.transitions = createTransitions(PACKED, CANCELLED);
        PACKED.transitions = createTransitions(SHIPPED, CANCELLED);
        SHIPPED.transitions = createTransitions(DELIVERED);
        DELIVERED.transitions = Collections.emptyList();
        CANCELLED.transitions = Collections.emptyList();
    }

    private static List<OrderStatus> createTransitions(
            OrderStatus... statuses) {

        List<OrderStatus> result = new ArrayList<>();
        Collections.addAll(result, statuses);

        return Collections.unmodifiableList(result);
    }

    public List<OrderStatus> allowedNext() {
        return transitions;
    }

    public boolean canAdvanceTo(OrderStatus target) {
        return target != null && transitions.contains(target);
    }

    public boolean isTerminal() {
        return transitions.isEmpty();
    }

    public static OrderStatus fromName(String name) {
        if (name == null) {
            return null;
        }

        try {
            return OrderStatus.valueOf(name.trim().toUpperCase());
        } catch (IllegalArgumentException exception) {
            return null;
        }
    }
}

// 2. Order tracker
class OrderTracker {

    private OrderStatus currentStatus;
    private int steps;

    public OrderTracker() {
        currentStatus = OrderStatus.PLACED;
        steps = 0;
    }

    public boolean advance(String nextStatus) {

        OrderStatus target = OrderStatus.fromName(nextStatus);

        if (target == null || !currentStatus.canAdvanceTo(target)) {
            return false;
        }

        currentStatus = target;
        steps++;

        return true;
    }

    public OrderStatus getCurrentStatus() {
        return currentStatus;
    }

    public int getSteps() {
        return steps;
    }

    public List<OrderStatus> allowedNext() {
        return currentStatus.allowedNext();
    }

    public boolean isTerminal() {
        return currentStatus.isTerminal();
    }
    public static void main(String[] args) {

        OrderTracker tracker = new OrderTracker();

        System.out.println("Initial Status: " +
                tracker.getCurrentStatus());

        System.out.println("Allowed Next: " +
                tracker.allowedNext());

        // PLACED -> PACKED
        System.out.println("\nAdvance to PACKED: " +
                tracker.advance("PACKED"));

        // PACKED -> SHIPPED
        System.out.println("Advance to SHIPPED: " +
                tracker.advance("SHIPPED"));

        // SHIPPED -> DELIVERED
        System.out.println("Advance to DELIVERED: " +
                tracker.advance("DELIVERED"));

        // DELIVERED is terminal; this transition must fail
        System.out.println("Advance to CANCELLED: " +
                tracker.advance("CANCELLED"));

        System.out.println("\nFinal Status: " +
                tracker.getCurrentStatus());

        System.out.println("Total Successful Steps: " +
                tracker.getSteps());

        System.out.println("Is Terminal: " +
                tracker.isTerminal());
    }
}