public class FactoryMethodPatternExample {

    // Document interface
    public interface Document {
        void create();
    }

    // Concrete Document classes
    public static class WordDocument implements Document {
        @Override
        public void create() {
            System.out.println("Creating a Word Document");
        }
    }

    public static class PdfDocument implements Document {
        @Override
        public void create() {
            System.out.println("Creating a PDF Document");
        }
    }

    public static class ExcelDocument implements Document {
        @Override
        public void create() {
            System.out.println("Creating an Excel Document");
        }
    }

    // DocumentFactory abstract class
    public abstract static class DocumentFactory {
        public abstract Document createDocument();
    }

    // Concrete Factory classes
    public static class WordDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new WordDocument();
        }
    }

    public static class PdfDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new PdfDocument();
        }
    }

    public static class ExcelDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new ExcelDocument();
        }
    }

    // Main method to test the Factory Method Pattern
    public static void main(String[] args) {
        // Create a Word Document
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.create();

        // Create a PDF Document
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.create();

        // Create an Excel Document
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.create();
    }
}
