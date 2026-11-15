package systemDesign.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 1. Abstract parent class
abstract class ExportFormat {

    // Template Method
    public final String render(List<String> events) {

        // Common validation
        if (events == null || events.isEmpty()) {
            return "INVALID";
        }

        // Format-specific implementation
        return format(events);
    }

    // Child classes must implement this method
    protected abstract String format(List<String> events);
}

// 2. CSV Format
class CsvFormat extends ExportFormat {

    @Override
    protected String format(List<String> events) {

        return String.join(",", events);
    }
}

// 3. Summary Format
class SummaryFormat extends ExportFormat {

    @Override
    protected String format(List<String> events) {

        return events.size() + " events: "
                + String.join(" | ", events);
    }
}

// 4. JSON Format
class JsonFormat extends ExportFormat {

    @Override
    protected String format(List<String> events) {

        StringBuilder result = new StringBuilder();

        result.append("[");

        for (int i = 0; i < events.size(); i++) {

            if (i > 0) {
                result.append(",");
            }

            result.append("\"")
                    .append(events.get(i))
                    .append("\"");
        }

        result.append("]");

        return result.toString();
    }
}

// 5. Provided EventExporter class
class EventExporter {

    private final List<String> events = new ArrayList<>();

    private final Map<String, ExportFormat> formats =
            new HashMap<>();

    public EventExporter() {

        formats.put("csv", new CsvFormat());
        formats.put("summary", new SummaryFormat());
        formats.put("json", new JsonFormat());
    }

    public boolean addEvent(String name) {

        if (name == null || name.isEmpty()) {
            return false;
        }

        events.add(name);

        return true;
    }

    public String exportAs(String format) {

        ExportFormat exporter = formats.get(format);

        if (exporter == null) {
            return "UNSUPPORTED";
        }

        return exporter.render(events);
    }

    public int eventCount() {
        return events.size();
    }

    public static void main(String[] args) {

        EventExporter exporter = new EventExporter();

        // Add events
        System.out.println("Add signup: "
                + exporter.addEvent("signup"));

        System.out.println("Add login: "
                + exporter.addEvent("login"));

        System.out.println("Add purchase: "
                + exporter.addEvent("purchase"));

        // Total events
        System.out.println("\nEvent Count: "
                + exporter.eventCount());

        // CSV export
        System.out.println("\nCSV Output:");
        System.out.println(exporter.exportAs("csv"));

        // Summary export
        System.out.println("\nSummary Output:");
        System.out.println(exporter.exportAs("summary"));

        // JSON export
        System.out.println("\nJSON Output:");
        System.out.println(exporter.exportAs("json"));

        // Unsupported format
        System.out.println("\nUnsupported Output:");
        System.out.println(exporter.exportAs("xml"));

        // Empty exporter test
        EventExporter emptyExporter = new EventExporter();

        System.out.println("\nEmpty JSON Output:");
        System.out.println(emptyExporter.exportAs("json"));
    }
}
