package practice2023;

import java.util.*;

public class DocumentSort {

    public static void main(String[] args) {
        List<Document> documents = new LinkedList<>();
        Document document1 = new Document("Passport", 1050);
        Document document2 = new Document("Driver's License", 100);
        Document document3 = new Document("Birth Certificate", 250);
        documents = Arrays.asList(document1, document2, document3);
        Collections.sort(documents, (doc1, doc2) -> doc1.getName().compareTo(doc2.getName()));
        System.out.println("Sorted by name ascending.");
        documents.stream().forEach(doc -> System.out.println("Name: " + doc.getName() + "\nSize: " + doc.getSize()));

        System.out.println("Sorted by name descending.");
        documents = sortDocuments(documents);
        documents.stream().forEach(doc -> System.out.println("Name: " + doc.getName() + "\nSize: " + doc.getSize()));
        System.out.println("Largest Document: " + getLargestDocument(documents).toString());
    }

    public static List<Document> sortDocuments(List<Document> documents) {
        Collections.sort(documents, new SortByName());
        return documents;
    }

    public static Optional<Document> getLargestDocument(List<Document> documents) {
        Collections.sort(documents, new SortBySize());
        return documents.stream().findFirst();
    }
}

class Document{
    String name;
    int size;

    public Document(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Document{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}

class SortBySize implements Comparator<Document> {
    @Override
    public int compare(Document o1, Document o2) {
        return o2.getSize() - o1.getSize();
    }
}

class SortByName implements Comparator<Document> {
    @Override
    public int compare(Document o1, Document o2) {
        return o2.getName().compareTo(o1.getName());
    }
}