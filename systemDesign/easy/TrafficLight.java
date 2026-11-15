package systemDesign.easy;

public
class TrafficLight {
    private Color current;

    public TrafficLight(String startColor) {
        Color parsed = Color.RED;

        for (Color color : Color.values()) {
            if (color.name().equalsIgnoreCase(startColor)) {
                parsed = color;
                break;
            }
        }

        this.current = parsed;
    }

    public String getColor() {
        return current.name();
    }

    public int getDuration() {
        return current.duration();
    }

    public String next() {
        current = current.next();
        return current.name();
    }

    public String describe() {
        return current.name() + " (" + current.duration() + "s)";
    }
}

enum Color {
    RED(30),
    GREEN(25),
    YELLOW(5);

    private final int seconds;

    Color(int seconds) {
        this.seconds = seconds;
    }

    public int duration() {
        return seconds;
    }

    public Color next() {
        switch (this) {
            case RED:
                return GREEN;

            case GREEN:
                return YELLOW;

            case YELLOW:
                return RED;

            default:
                throw new IllegalStateException("Unknown color: " + this);
        }
    }
    public static void main(String[] args) {

        TrafficLight light = new TrafficLight("red");

        // Initial state
        System.out.println(light.getColor());
        System.out.println(light.getDuration());
        System.out.println(light.describe());

        // Red -> Green
        System.out.println(light.next());
        System.out.println(light.describe());

        // Green -> Yellow
        System.out.println(light.next());
        System.out.println(light.describe());

        // Yellow -> Red
        System.out.println(light.next());
        System.out.println(light.describe());

        // Test case-insensitive input
        TrafficLight light2 = new TrafficLight("gReEn");
        System.out.println(light2.describe());

        // Test invalid input (defaults to RED)
        TrafficLight light3 = new TrafficLight("BLUE");
        System.out.println(light3.describe());
    }
}

