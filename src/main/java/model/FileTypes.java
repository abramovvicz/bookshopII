package model;

public enum FileTypes {
    BOOKS("books.csv"), AUTHORS("authors.csv"), CATEGORIES("categoris.csv");
    private String fileTypes;

    FileTypes(String fileTypes) {
        this.fileTypes = fileTypes;
    }

    public String getFileAdress() {
        return fileTypes;
    }
}
