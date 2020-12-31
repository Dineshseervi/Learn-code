package main.java.search;

public class ExampleRecursiveSubStringSearch {

    public boolean searchSubStringInMainString(char[] mainArray, char[] searchTermArray) {
        int searchTermLength = searchTermArray.length ;
        boolean match = false;
        int point = 0;
        if (mainArray.length >= searchTermArray.length) {
            for (int i = 0; i < mainArray.length; i++) {
                if (mainArray[i] == searchTermArray[point]) {
                    match = true;
                    point++;
                } else {
                    point = 0;
                    match = false;
                }

                if (match && point == searchTermLength) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String mainString = "how are you dinesh today";
        String searchString = "dinesh ";
        ExampleRecursiveSubStringSearch exampleRecursiveSubStringSearch = new ExampleRecursiveSubStringSearch();
        boolean result = exampleRecursiveSubStringSearch.searchSubStringInMainString(mainString.toCharArray(), searchString.toCharArray());
        System.out.println("result: " + result);

    }
}
