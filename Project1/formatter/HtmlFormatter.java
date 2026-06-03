package Project1.formatter;

// =============================================================================
// HtmlFormatter.java — Concrete Formatter (HTML wrapping)
// =============================================================================
// Wraps the text in basic HTML paragraph tags.
// Yet another formatter added without modifying any existing code — OCP in action.
// =============================================================================

public class HtmlFormatter implements TextFormatter {

    @Override
    public String format(String text) {
        // Split by newlines and wrap each line in <p> tags
        StringBuilder html = new StringBuilder();
        String[] lines = text.split("\n");
        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                html.append("<p>").append(line.trim()).append("</p>\n");
            }
        }
        return html.toString().trim();
    }

    @Override
    public String getFormatterName() {
        return "HTML";
    }
}
