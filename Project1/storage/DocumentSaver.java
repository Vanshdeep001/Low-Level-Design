package Project1.storage;

import Project1.document.Document;

// =============================================================================
// DocumentSaver.java — Save-only Interface
// =============================================================================
// SOLID Principle demonstrated: Interface Segregation Principle (ISP)
//
// Instead of one fat "DocumentStorage" interface with save(), load(), delete(),
// export(), etc., we segregate into small, focused interfaces.
//
// A class that only needs to SAVE documents depends only on this interface —
// it is never forced to implement load() or delete() methods it doesn't need.
// =============================================================================

public interface DocumentSaver {
    void save(Document document);
}
