package Project1.document;

// =============================================================================
// Document.java — Core Document Model
// =============================================================================
// SOLID Principle demonstrated: Single Responsibility Principle (SRP)
//
// This class has ONE and only one responsibility: holding the data of a document
// (its title and content). It does NOT handle saving, formatting, displaying,
// or any other concern. Each of those responsibilities lives in its own class.
// =============================================================================

public class Document {
    private String title;
    private StringBuilder content;

    public Document(String title) {
        this.title = title;
        this.content = new StringBuilder();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content.toString();
    }

    // Append text to the end of the document
    public void appendContent(String text) {
        content.append(text);
    }

    // Replace the entire content
    public void setContent(String newContent) {
        this.content = new StringBuilder(newContent);
    }

    // Delete a range of characters from the content
    public void deleteContent(int start, int end) {
        if (start < 0 || end > content.length() || start > end) {
            throw new IllegalArgumentException("Invalid range: [" + start + ", " + end + ")");
        }
        content.delete(start, end);
    }

    // Insert text at a specific position
    public void insertContent(int position, String text) {
        if (position < 0 || position > content.length()) {
            throw new IllegalArgumentException("Invalid position: " + position);
        }
        content.insert(position, text);
    }

    public int getLength() {
        return content.length();
    }

    @Override
    public String toString() {
        return "Document{title='" + title + "', length=" + content.length() + " chars}";
    }
}
