package Project1.formatter;

// =============================================================================
// PlainTextFormatter.java — Concrete Formatter (no transformation)
// =============================================================================
// Returns the text as-is. This is the default/identity formatter.
// Demonstrates LSP: can be used wherever TextFormatter is expected.
// =============================================================================

public class PlainTextFormatter implements TextFormatter {

    @Override
    public String format(String text) {
        return text; // no transformation
    }

    @Override
    public String getFormatterName() {
        return "PLAIN";
    }
}
