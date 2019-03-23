package enums;


public enum FileTypes {
    BOOKS("src/main/resources/books.csv"),
    AUTHORS("src/main/resources/authors.csv"),
    CATEGORIES("src/main/resources/categories.csv"),
    NEW_AUTHORS("src/main/resources/newAuthors.csv"),
    NEW_BOOKS("src/main/resources/newBooks.csv"),
    NEW_CATEGORIES("src/main/resources/newCategories.csv");

    private String fileTypes;

    FileTypes(String fileTypes) {
        this.fileTypes = fileTypes;
    }

    public String getFileAddress() {
        return fileTypes;
    }
}
