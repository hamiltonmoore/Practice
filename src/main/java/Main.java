public class Main {

    private int[] theArray = new int[50];
    private int arraySize = 10;

    public int getValueAtIndex(int index) {

        if (index < arraySize) return theArray[index];

        return 0;
    }

    public boolean doesArrayContainValue(int search) {
        boolean valueInArray = false;

        for (int i = 0; i < arraySize; i++){

            if (theArray[i]==search){
                valueInArray = true;
            }
        }
        return valueInArray;
    }

    public void deleteIndex(int index) {

        if (index < arraySize){

            for (int i = index; i < (arraySize - 1); i++ ){
                theArray[i] = theArray[i + 1];
            }
            arraySize--;
        }
    }

    public void insertValue(int value) {

        if (arraySize < 50){

            theArray[arraySize] = value;

            arraySize++;
        }

    }

    //linear search
    public String searchForValue(int value){
        boolean containsValue = false;

        String indexesWithValue = "";

        for (int i = 0; i < arraySize; i++){
            if (theArray[i] == value){
                containsValue = true;

                System.out.print(i + " ");

                indexesWithValue =+ i + " ";
            }
            if (!containsValue){
                indexesWithValue = "none";
                System.out.println(indexesWithValue);
            }

        }
        System.out.println();
        System.out.println("value was found in following indexes: " + indexesWithValue);
        return indexesWithValue;
    }

//    public void bubbleSort(int[] theArray) {
//
//        for (int i= arraySize; i > 1; i--){
//
//           for (int j = 0; j < i; j++){
//
//               if (theArray[j] > theArray[j+1]){
//                   //swap values
//                   swapValues(j,j+1);
//               }
//           }
//
//        }
//    }

    static void bubbleSortExample(int[] arr) {
        int n = arr.length;
        int temp = 0;
        //loop through the array. . according to its length
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    //swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
    }

    static void myOwnBubbleSort(int[] a){
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
        for (int i = 0; i < a.length -1; i++) {
            if (a[i] > a[i + 1]) {
                swap(a, i, i + 1);
                isSorted = false;
            }
        }
        }
    }

    static void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    //only works on sorted array
    static boolean recursiveBinarySearch(int[] array, int x, int left, int right) {
        if (left > right){
            return false;
        }
        int mid = (array[right] + array[left]) / 2;
        if (array[mid] == x){
            return true;
        }
        else if (x < array[mid]){
            recursiveBinarySearch(array, x, left, mid);
        }
        else {
            recursiveBinarySearch(array, x, mid, right);
        }
        return true;
    }



    public void generateRandomArray() {

        for (int i = 0; i < arraySize; i++){

            theArray[i] = (int) (Math.random()*10)+10;
        }
    }

    public void printArray() {

        System.out.println("----------");
        for (int i = 0; i < arraySize; i++) {

            System.out.print("| " + i + " | ");
            System.out.println(theArray[i] + " | ");

            System.out.println("----------");
        }
    }


    public static void main(String[] args) {

        int arr[] ={3,60,35,2,45,320,5};
        int[] a = {2,3,4,5,6,7,8,9,1};
        Practice practice = new Practice();
        //practice.sort(a);

        Main main = new Main();
        main.generateRandomArray();
        main.printArray();

        int value = main.getValueAtIndex(3);
        System.out.println("get value at index: " + value);

        boolean value2 = main.doesArrayContainValue(3);
        System.out.println("does value contain a defined value? : "+ value2);

        //delete index
        //main.deleteIndex(5);
        //main.printArray();
        //insert value (add index)
        //main.insertValue(55);
        //main.printArray();

        main.searchForValue(12);
        main.printArray();

        System.out.println("print the array before the bubble sort: ");
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        //bubble sort algorithm
        //main.bubbleSortExample(arr);
        main.myOwnBubbleSort(arr);

        System.out.println("print the array after the bubble sort: ");
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }
}
