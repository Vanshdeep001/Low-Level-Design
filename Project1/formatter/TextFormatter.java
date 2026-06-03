package Project1.formatter;

// =============================================================================
// TextFormatter.java — Formatter Interface (Abstraction)
// =============================================================================
// SOLID Principles demonstrated:
//
// 1. Open/Closed Principle (OCP):
//    New formatting styles (Markdown, HTML, XML, etc.) can be added by creating
//    new classes that implement this interface — WITHOUT modifying any existing
//    formatter class. The system is open for extension, closed for modification.
//
// 2. Dependency Inversion Principle (DIP):
//    High-level modules (like DocumentEditor) depend on this ABSTRACTION,
//    not on concrete formatters. This interface is the "inversion point"
//    that decouples the editor from specific formatting implementations.
//
// 3. Liskov Substitution Principle (LSP):
//    Any class implementing this interface can be substituted wherever a
//    TextFormatter is expected, and the program will still behave correctly.
// =============================================================================

public interface TextFormatter {

    // Format the given raw text and return the formatted result.
    String format(String text);

    // Return the name/type of this formatter (e.g., "PLAIN", "UPPERCASE").
    String getFormatterName();
}
