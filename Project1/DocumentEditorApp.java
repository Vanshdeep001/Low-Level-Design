package Project1;

import Project1.document.Document;
import Project1.editor.DocumentEditor;
import Project1.formatter.PlainTextFormatter;
import Project1.formatter.UpperCaseFormatter;
import Project1.formatter.HtmlFormatter;
import Project1.storage.InMemoryStorage;

// =============================================================================
// DocumentEditorApp.java — Main Demonstration
// =============================================================================
// This class ties everything together and demonstrates how all 5 SOLID
// principles work in concert within the Document Editor.
//
// Summary of SOLID principles used across the project:
//
// ┌────────────────────────────────────────────────────────────────────┐
// │  Principle                │  Where it's demonstrated              │
// ├───────────────────────────┼────────────────────────────────────────┤
// │  SRP (Single Resp.)      │  Document holds data only.            │
// │                           │  DocumentEditor orchestrates edits.   │
// │                           │  Formatters only format.              │
// │                           │  Storage only persists.               │
// ├───────────────────────────┼────────────────────────────────────────┤
// │  OCP (Open/Closed)       │  New formatters & storage backends    │
// │                           │  can be added without modifying       │
// │                           │  existing classes.                    │
// ├───────────────────────────┼────────────────────────────────────────┤
// │  LSP (Liskov Sub.)       │  Any TextFormatter or DocumentSaver   │
// │                           │  implementation works correctly       │
// │                           │  when substituted.                    │
// ├───────────────────────────┼────────────────────────────────────────┤
// │  ISP (Interface Seg.)    │  DocumentSaver and DocumentLoader     │
// │                           │  are separate interfaces.             │
// │                           │  Editor only depends on Saver.        │
// ├───────────────────────────┼────────────────────────────────────────┤
// │  DIP (Dependency Inv.)   │  DocumentEditor depends on            │
// │                           │  TextFormatter & DocumentSaver        │
// │                           │  abstractions, not concretes.         │
// └────────────────────────────────────────────────────────────────────┘
// =============================================================================

public class DocumentEditorApp {
    public static void main(String[] args) {

        // Shared storage backend
        InMemoryStorage storage = new InMemoryStorage();

        // =====================================================================
        // Scenario 1: Plain Text Editing
        // =====================================================================
        System.out.println("=== Scenario 1: Plain Text Editor ===");
        Document doc1 = new Document("Meeting Notes");
        DocumentEditor editor1 = new DocumentEditor(doc1, new PlainTextFormatter(), storage);

        editor1.write("Attendees: Alice, Bob, Charlie\n");
        editor1.write("Topic: Q3 Planning\n");
        editor1.write("Action Items: Review budget, finalize roadmap.\n");
        editor1.save();

        System.out.println("  Formatted output [" + editor1.getFormatterName() + "]:");
        System.out.println("  ---");
        System.out.println("  " + editor1.getFormattedContent().replace("\n", "\n  "));
        System.out.println();

        // =====================================================================
        // Scenario 2: Uppercase Formatter (swapped at construction — OCP + DIP)
        // =====================================================================
        System.out.println("=== Scenario 2: Uppercase Editor ===");
        Document doc2 = new Document("Announcement");
        DocumentEditor editor2 = new DocumentEditor(doc2, new UpperCaseFormatter(), storage);

        editor2.write("Important: Server maintenance this weekend.\n");
        editor2.write("All services will be temporarily unavailable.");
        editor2.save();

        System.out.println("  Formatted output [" + editor2.getFormatterName() + "]:");
        System.out.println("  ---");
        System.out.println("  " + editor2.getFormattedContent().replace("\n", "\n  "));
        System.out.println();

        // =====================================================================
        // Scenario 3: HTML Formatter (yet another swap — same editor code!)
        // =====================================================================
        System.out.println("=== Scenario 3: HTML Editor ===");
        Document doc3 = new Document("Blog Post");
        DocumentEditor editor3 = new DocumentEditor(doc3, new HtmlFormatter(), storage);

        editor3.write("Welcome to my blog.\n");
        editor3.write("Today we discuss SOLID principles.\n");
        editor3.write("They make our code maintainable and extensible.");
        editor3.save();

        System.out.println("  Formatted output [" + editor3.getFormatterName() + "]:");
        System.out.println("  ---");
        System.out.println("  " + editor3.getFormattedContent().replace("\n", "\n  "));
        System.out.println();

        // =====================================================================
        // Scenario 4: Edit operations — insert and delete
        // =====================================================================
        System.out.println("=== Scenario 4: Advanced Editing (Insert & Delete) ===");
        Document doc4 = new Document("Draft");
        DocumentEditor editor4 = new DocumentEditor(doc4, new PlainTextFormatter(), storage);

        editor4.write("Hello World!");
        System.out.println("  Before edit: \"" + editor4.getFormattedContent() + "\"");

        // Insert " Beautiful" between "Hello" and " World"
        editor4.insertAt(5, " Beautiful");
        System.out.println("  After insert: \"" + editor4.getFormattedContent() + "\"");

        // Delete "Beautiful " (positions 6-16) to revert
        editor4.deleteRange(5, 15);
        System.out.println("  After delete: \"" + editor4.getFormattedContent() + "\"");

        editor4.save();
        System.out.println();

        // =====================================================================
        // Scenario 5: Loading a previously saved document (ISP — uses Loader)
        // =====================================================================
        System.out.println("=== Scenario 5: Loading a Saved Document ===");
        Document loaded = storage.load("Meeting Notes");
        if (loaded != null) {
            System.out.println("  Content of loaded document:");
            System.out.println("  ---");
            System.out.println("  " + loaded.getContent().replace("\n", "\n  "));
        }
    }
}
