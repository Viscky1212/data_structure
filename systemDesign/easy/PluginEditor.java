package systemDesign.easy;

import java.util.ArrayList;
import java.util.List;

// Common contract for all plugins
interface EditorPlugin {
    String execute(String text);
    String name();
}

// Converts text to uppercase
class UpperPlugin implements EditorPlugin {

    @Override
    public String execute(String text) {
        return text.toUpperCase();
    }

    @Override
    public String name() {
        return "upper";
    }
}

// Removes leading and trailing spaces
class TrimPlugin implements EditorPlugin {

    @Override
    public String execute(String text) {
        return text.trim();
    }

    @Override
    public String name() {
        return "trim";
    }
}

// Appends an exclamation mark
class ExclaimPlugin implements EditorPlugin {

    @Override
    public String execute(String text) {
        return text + "!";
    }

    @Override
    public String name() {
        return "exclaim";
    }
}

// Provided PluginEditor class
class PluginEditor {
    private final List<EditorPlugin> installed = new ArrayList<>();

    public PluginEditor() {
    }

    private EditorPlugin create(String name) {
        EditorPlugin[] available = {
                new UpperPlugin(),
                new TrimPlugin(),
                new ExclaimPlugin()
        };

        for (EditorPlugin plugin : available) {
            if (plugin.name().equals(name)) {
                return plugin;
            }
        }

        return null;
    }

    public boolean install(String name) {
        EditorPlugin plugin = create(name);

        if (plugin == null) {
            return false;
        }

        for (EditorPlugin p : installed) {
            if (p.name().equals(name)) {
                return false;
            }
        }

        installed.add(plugin);
        return true;
    }

    public String[] installed() {
        String[] out = new String[installed.size()];

        for (int i = 0; i < installed.size(); i++) {
            out[i] = installed.get(i).name();
        }

        return out;
    }

    public int pluginCount() {
        return installed.size();
    }

    public String run(String text) {
        String out = text;

        for (EditorPlugin p : installed) {
            out = p.execute(out);
        }

        return out;
    }


    public static void main(String[] args) {

        PluginEditor editor = new PluginEditor();

        // Install plugins in order
        System.out.println(editor.install("trim"));    // true
        System.out.println(editor.install("exclaim")); // true
        System.out.println(editor.install("upper"));   // true

        // Duplicate and unknown plugin
        System.out.println(editor.install("trim"));    // false
        System.out.println(editor.install("unknown")); // false

        // Installed plugin names
        System.out.println(
                String.join(", ", editor.installed())
        );
        // trim, exclaim, upper

        System.out.println(editor.pluginCount());
        // 3

        // Execute plugins in installation order
        System.out.println(editor.run(" hello "));
        // HELLO!
    }
}
