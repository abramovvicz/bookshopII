package excercises;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionTests {

    private static List<String> namesList = new ArrayList<>();
    private static Set<String> nameSet = new TreeSet<>();
    private static Map<Integer, String> colorsMap = new HashMap<>();

    public static void main(String[] args) {
        //ex1
        List<String> namesList = createNewNameList();
        //ex2
        showNameList(namesList);
        //ex3
        showNameListSize();
        //ex4
        addNamePaulina("Paulina");
        //ex5
        showThirdElemenet(3);
        //ex6
        reverseElementNameList("Marek");
        //ex7
        whichElementIsJakob("Jakub");
        //ex8
        isSywliaInList("Sylwia");
        //ex9
        isMartaInList("Marta");
        //ex10
        showFirstTwoElements(namesList);
        //ex11
        swapElements(namesList);
        //ex12
        showLastTwoElements(namesList);
        //ex13
        appendAllElementsToString();
        //ex14
        showElementsWithS("s");
        //ex15
        swowThreeAndThourElement(1, 3);
        //ex16
        showReversList(namesList);
        //ex17
        showElementsOnMAndA("M", "A");
        //ex18
        showNamesAndNamesLength();
        //ex19
        createNewListWithTwoNames();
        //ex20
        checkIfNamesAreInList();
        //ex21
        showNamesInMapFormat();
        //ex22
        removeFirstElemenet();
        //ex23
        removeJacobName();
        //ex24
        sortASC();
        //ex25
        sortDESC();
        //ex26
        checkIfListIsEmpty();
        //ex27
        clearList();
        //ex28
        againCheckIfListIsEmpty();
        //ex29
        createSet();
        //ex30
        addNameToSet();
        //ex31
        creatHashMap(1, "Niebieski");
        creatHashMap(2, "Zielony");
        creatHashMap(23, "Czerwony");
        //ex32
        showAllColors();
        //ex33
        showIndexOfColors();
        //ex34
        addNewColor(4, "Brązowy");
        //ex35
        showColorOnIndex(2);
        //ex36
        showIdBlueColor();
        //ex37
        showAllColors2();
        //ex38
        showAllIndexColors();
        //ex39
        removeSecondIndex(2);
        //ex40     //Usuń kolor czerwony z mapy.
        removeRedColor();
    }

    //ex1
    private static List<String> createNewNameList() {
        namesList.add("Marek");
        namesList.add("Aleksandra");
        namesList.add("Marta");
        namesList.add("Jakub");
        namesList.add("Bartosz");
        return namesList;
    }

    //ex2
    private static void showNameList(List<String> namesList) {
        namesList.forEach(System.out::println);
    }

    //ex3
    private static void showNameListSize() {
        System.out.println(namesList.size());

    }

    //ex4
    private static void addNamePaulina(String name) {
        namesList.add(name);
    }

    //ex5
    private static void showThirdElemenet(int i) {
        System.out.println(namesList.get(i));
    }

    //ex6
    private static void reverseElementNameList(String name) {
        StringBuilder stringBuilder = new StringBuilder(namesList.get(namesList.indexOf(name)));
        System.out.println(stringBuilder.reverse());
    }

    //ex7
    private static void whichElementIsJakob(String listElement) {
        System.out.println("Jakub posiada index: " + namesList.indexOf(listElement));
    }

    //ex8
    private static void isSywliaInList(String listElement) {
        System.out.println(namesList.contains(listElement));
    }

    //ex9
    private static void isMartaInList(String listElement) {
        System.out.println(namesList.contains(listElement));
    }

    //ex10
    private static void showFirstTwoElements(List<String> namesList) {
        System.out.println(namesList.get(0) + "" + namesList.get(1));
    }

    //ex11
    private static void swapElements(List<String> namesList) {
        namesList.set(namesList.indexOf("Marek"), "Sebastian");
    }

    //ex12
    private static void showLastTwoElements(List<String> namesList) {
        System.out.println("przedostastni " + namesList.get(namesList.size() - 2) + " ostastni " + namesList.get(namesList.size() - 1));
        System.out.println("inaczej" + namesList.subList(1, 3));
    }

    //ex13
    private static void appendAllElementsToString() {
        String result = "";
        for (String element : namesList) {
            String.join(result, element);
        }
        System.out.println("połączone stringi " + result);
    }

    //ex14
    private static void showElementsWithS(String s) {
        String elements = namesList.stream().filter(x -> x.contains(s)).collect(Collectors.joining());
        System.out.println("połaćzone stringi " + elements);
    }

    //ex15
    private static void swowThreeAndThourElement(int i, int j) {
//     namesList.stream().forEach(x->System.out.print(x.charAt(1) +" "+ x.charAt(2)));
        namesList.forEach(x -> System.out.println(x.substring(i, j) + " "));
    }


    //ex16
    private static void showReversList(List<String> namesList) {
        System.out.println("Cwiczenie 16");
        Collections.reverse(namesList);
        System.out.println(namesList);
    }

    //ex17
    private static void showElementsOnMAndA(String s, String c) {
        namesList.stream().filter(x -> x.toUpperCase().startsWith(s) || x.toUpperCase().endsWith(c)).forEach(System.out::print);

    }

    //ex18
    private static void showNamesAndNamesLength() {
        namesList.stream().forEach(x -> System.out.println(x + " ilośc znaków " + x.length()));
    }

    //ex19
    private static void createNewListWithTwoNames() {
        List<String> newList = Arrays.asList("Anna", "Maciej");
        Collections.copy(namesList, newList);
        namesList.forEach(System.out::println);
    }

    //ex20
    private static void checkIfNamesAreInList() {
        List<String> tempList = Arrays.asList("Marta", "Aleksandra", "Jakub");
        System.out.println("yo2 " + namesList.containsAll(tempList));
//        System.out.println("yo " + namesList.stream().anyMatch(x -> x.equals("Marta") && x.equals("Aleksandra") && x.equals("Jakub")));

    }

    //ex21
    private static void showNamesInMapFormat() {
        for (int i = 0; i < namesList.size(); i++) {
            System.out.println(i + ":" + namesList.get(i));
        }
//        namesList.stream().forEach(x-> System.out.println(namesList.indexOf(x)+ ":"+ x));
    }

    //ex22
    private static void removeFirstElemenet() {
        namesList.remove(1);
        System.out.println(namesList);
    }

    //ex23
    private static void removeJacobName() {
        System.out.println(namesList.remove("Jakub"));
        namesList.forEach(System.out::println);
    }

    //ex24
    private static void sortASC() {
        Collections.sort(namesList);
        System.out.println("sortowanie rosnco" + namesList);

    }

    //ex25
    private static void sortDESC() {
        Collections.sort(namesList);
        Collections.reverse(namesList);
        System.out.println("sortowanie malejco" + namesList);

    }

    //ex26
    private static void checkIfListIsEmpty() {
        System.out.println(namesList.isEmpty());
    }

    //ex27
    private static void clearList() {
        namesList.clear();
        System.out.println("wyczyszczona lista  " + namesList);
    }

    //ex28
    private static void againCheckIfListIsEmpty() {
        System.out.println(namesList.isEmpty());
    }

    //ex29
    private static void createSet() {
        nameSet.addAll(Arrays.asList("Marek", "Aleksandra", "Marta", "Jakub", "Bartosz"));
        nameSet.forEach(System.out::print);
        System.out.println();
    }

    //ex30
    private static void addNameToSet() {
        nameSet.add("Marek");
        System.out.println("nowy set");
        nameSet.forEach(System.out::println);
    }

    //ex31
    private static void creatHashMap(int i, String s) {
        colorsMap.put(i, s);
        colorsMap.put(i, s);
        colorsMap.put(i, s);
    }

    //ex32
    private static void showAllColors() {
        // System.out.println(colorsMap.values());
        colorsMap.forEach((x, y) -> System.out.println(y));
    }

    //ex33
    private static void showIndexOfColors() {
        // System.out.println(colorsMap.keySet());
        colorsMap.forEach((x, y) -> System.out.println(x));

    }

    //ex34
    private static void addNewColor(int i, String s) {
        colorsMap.put(i, s);
        System.out.println(colorsMap);
    }

    //ex35
    private static void showColorOnIndex(int i) {
        System.out.println(colorsMap.get(i));
    }

    //ex36
    private static void showIdBlueColor() {
        colorsMap.entrySet().stream().filter(a -> a.getValue().equals("Niebieski")).
                forEach(x -> System.out.println(x.getKey()));
    }

    //ex37
    private static void showAllColors2() {
        colorsMap.values().stream().forEach(System.out::print);
    }

    //ex38
    private static void showAllIndexColors() {
        colorsMap.keySet().stream().forEach(System.out::println);
    }

    //ex39
    private static void removeSecondIndex(int i) {
        colorsMap.remove(i);
        System.out.println(colorsMap);
    }

    //ex40
    private static void removeRedColor() {
        colorsMap.entrySet().removeIf(x -> x.getValue().equals("Czerwony"));

        for (Map.Entry<Integer, String> entry : colorsMap.entrySet()) { // wywala błąd bo próbuje usunąc element po ktorym sie iteruje
            if (entry.getValue().equals("Czerwony")) {
                colorsMap.remove(entry.getKey());
            }
        }
    }
}

