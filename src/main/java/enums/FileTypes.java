package enums;


public enum FileTypes {
    BOOKS("books.csv"), AUTHORS("authors.csv"), CATEGORIES("categories.csv");
    private String fileTypes;

    FileTypes(String fileTypes) {
        this.fileTypes = fileTypes;
    }

    public String getFileAdress() {
        return fileTypes;
    }
}
