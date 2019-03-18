package enums;


public enum FileTypes {
    BOOKS("src/main/resources/books.csv"), AUTHORS("src/main/resources/authors.csv"), CATEGORIES("src/main/resources/categories.csv");
    private String fileTypes;

    FileTypes(String fileTypes) {
        this.fileTypes = fileTypes;
    }

    public String getFileAddress() {
        return fileTypes;
    }
}
