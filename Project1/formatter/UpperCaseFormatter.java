package Project1.formatter;

// =============================================================================
// UpperCaseFormatter.java — Concrete Formatter (UPPERCASE)
// =============================================================================
// Converts all text to upper case.
// Added WITHOUT touching PlainTextFormatter or TextFormatter — this is OCP.
// Substitutable for any TextFormatter reference — this is LSP.
// =============================================================================

public class UpperCaseFormatter implements TextFormatter {

    @Override
    public String format(String text) {
        return text.toUpperCase();
    }

    @Override
    public String getFormatterName() {
        return "UPPERCASE";
    }
}
