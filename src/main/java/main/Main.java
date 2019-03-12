package main;

import dao.DataFromFiles;
import view.MenuNavigation;


public class Main {
    public static void main(String[] args) {
        MenuNavigation menu = new MenuNavigation();
        menu.menuNavigation();
        DataFromFiles.getInstance();
    }

}
