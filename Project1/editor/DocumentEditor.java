package Project1.editor;

import Project1.document.Document;
import Project1.formatter.TextFormatter;
import Project1.storage.DocumentSaver;

// =============================================================================
// DocumentEditor.java — High-Level Editor (Orchestrator)
// =============================================================================
// SOLID Principles demonstrated:
//
// 1. Single Responsibility Principle (SRP):
//    The editor's ONLY responsibility is orchestrating edit operations on a
//    document. It does NOT know how to format text (delegates to TextFormatter)
//    and does NOT know how to persist data (delegates to DocumentSaver).
//
// 2. Dependency Inversion Principle (DIP):
//    This high-level module depends on ABSTRACTIONS (TextFormatter, DocumentSaver),
//    not on concrete classes (PlainTextFormatter, InMemoryStorage).
//    The concrete implementations are injected through the constructor.
//
// 3. Open/Closed Principle (OCP):
//    To change formatting or storage behaviour, simply inject a different
//    implementation — no modification of this class is needed.
// =============================================================================

public class DocumentEditor {
    private Document document;
    private final TextFormatter formatter;   // depends on abstraction, not concrete class
    private final DocumentSaver saver;       // depends on abstraction, not concrete class

    // Dependencies are INJECTED through the constructor (Constructor Injection)
    // This is the practical mechanism for achieving DIP.
    public DocumentEditor(Document document, TextFormatter formatter, DocumentSaver saver) {
        this.document = document;
        this.formatter = formatter;
        this.saver = saver;
    }

    // --- Edit Operations (the editor's single responsibility) ---

    public void write(String text) {
        document.appendContent(text);
        System.out.println("  [Editor] Wrote " + text.length() + " characters to \"" + document.getTitle() + "\"");
    }

    public void insertAt(int position, String text) {
        document.insertContent(position, text);
        System.out.println("  [Editor] Inserted " + text.length() + " characters at position " + position);
    }

    public void deleteRange(int start, int end) {
        document.deleteContent(start, end);
        System.out.println("  [Editor] Deleted characters [" + start + ", " + end + ")");
    }

    // --- Delegates formatting to the injected TextFormatter ---

    public String getFormattedContent() {
        return formatter.format(document.getContent());
    }

    // --- Delegates saving to the injected DocumentSaver ---

    public void save() {
        saver.save(document);
    }

    // --- Accessors ---

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public String getFormatterName() {
        return formatter.getFormatterName();
    }
}
