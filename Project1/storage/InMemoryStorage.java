package Project1.storage;

import Project1.document.Document;
import java.util.HashMap;
import java.util.Map;

// =============================================================================
// InMemoryStorage.java — Concrete Storage (implements both saver & loader)
// =============================================================================
// SOLID Principles demonstrated:
//
// 1. ISP: This class CHOOSES to implement both DocumentSaver and DocumentLoader
//    because it can handle both. But other classes could implement only one.
//    For example, a "ReadOnlyArchive" would implement only DocumentLoader.
//
// 2. LSP: This can be substituted wherever DocumentSaver or DocumentLoader
//    is expected, and the program remains correct.
//
// 3. OCP: To add a new storage backend (FileStorage, DatabaseStorage),
//    just create a new class implementing these interfaces — no changes needed
//    in the editor or any existing storage class.
// =============================================================================

public class InMemoryStorage implements DocumentSaver, DocumentLoader {
    private final Map<String, String> store = new HashMap<>();

    @Override
    public void save(Document document) {
        store.put(document.getTitle(), document.getContent());
        System.out.println("  [InMemoryStorage] Saved document: \"" + document.getTitle() + "\"");
    }

    @Override
    public Document load(String title) {
        String content = store.get(title);
        if (content == null) {
            System.out.println("  [InMemoryStorage] Document not found: \"" + title + "\"");
            return null;
        }
        Document doc = new Document(title);
        doc.setContent(content);
        System.out.println("  [InMemoryStorage] Loaded document: \"" + title + "\"");
        return doc;
    }

    // Utility method to check if a document exists
    public boolean exists(String title) {
        return store.containsKey(title);
    }
}
