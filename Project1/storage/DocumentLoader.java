package Project1.storage;

import Project1.document.Document;

// =============================================================================
// DocumentLoader.java — Load-only Interface
// =============================================================================
// SOLID Principle demonstrated: Interface Segregation Principle (ISP)
//
// Segregated from DocumentSaver. A class that only needs to LOAD documents
// depends only on this interface and is never forced to implement save().
// =============================================================================

public interface DocumentLoader {
    Document load(String title);
}
