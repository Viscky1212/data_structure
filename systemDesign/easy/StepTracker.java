package systemDesign.easy;

class StepTracker {

    private final int goal;
    private int totalSteps;

    // Constructor
    public StepTracker(int goal) {
        this.goal = goal;
        this.totalSteps = 0;
    }

    // Add steps and return updated total
    public int addSteps(int count) {

        if (count < 1) {
            return totalSteps;
        }

        totalSteps += count;

        return totalSteps;
    }

    // Return total steps recorded
    public int steps() {
        return totalSteps;
    }

    // Return daily goal
    public int goal() {
        return goal;
    }

    // Return remaining steps
    public int remaining() {
        return Math.max(0, goal - totalSteps);
    }

    // Check whether goal is reached
    public boolean goalReached() {
        return totalSteps >= goal;
    }

    // Return percentage completed, capped at 100
    public int percentComplete() {

        return (int) Math.min(
                100,
                (long) totalSteps * 100 / goal
        );
    }

    // Return progress summary
    public String summary() {

        if (goalReached()) {
            return steps() + " of " + goal()
                    + " steps, goal reached";
        }

        return steps() + " of " + goal()
                + " steps, " + remaining() + " to go";
    }

    public static void main(String[] args) {
        StepTracker tracker = new StepTracker(10000);

        // Add steps
        System.out.println("Added Steps: " + tracker.addSteps(3000)); // 3000
        System.out.println("Added Steps: " + tracker.addSteps(5000)); // 8000
        System.out.println("Added Steps: " + tracker.addSteps(2500)); // 10500

        // Check progress
        System.out.println("Total Steps: " + tracker.steps()); // 10500
        System.out.println("Daily Goal: " + tracker.goal()); // 10000
        System.out.println("Remaining Steps: " + tracker.remaining()); // 0
        System.out.println("Goal Reached: " + tracker.goalReached()); // true
        System.out.println("Percent Complete: " + tracker.percentComplete() + "%"); // 100%
        System.out.println("Summary: " + tracker.summary()); // Summary message
    }
}
