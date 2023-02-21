/* ===================================== L3T3: Compulsory Task 2: BubbleSort.java =====================================

    This program implements the Bubble Sort algorithm on the given ArrayList and prints out the sorted list.

    The Bubble Sort method works by 'bubbling up' larger values to the top of a list by:
        -   Repeatedly comparing one element with its following element (i.e. the first element with the next element).
        -   If the first element is greater than the second, switch their places in the list until all elements
            in the list have been compared.
    This sorting method is suitable for smaller arrays/data sets, with a time complexity of O(n^2).

 ====================================================================================================================*/

import java.util.ArrayList;
import java.util.List;
import static java.util.Arrays.*;

public class BubbleSort
{
    // ----------------------------------------- Bubble Sort Method ------------------------------------------------
    static void bubbleSort(ArrayList<String> inputArray)
    {
        // Create temp string array to store ArrayList contents (makes conditions in loops shorter/easier to read).
        String[] tempStringArray = new  String[inputArray.size()];

        for (int i = 0; i < tempStringArray.length; i++)
        {
            tempStringArray[i] = inputArray.get(i);
        }

        // Create flag for do-while loop.
        Boolean flag;

        do
        {
            flag = false;

            // Compare elements in 'tempStringArray' lexicographically at 'j' and 'j+1'.
            // If 'j' compared to 'j+1' is greater than 0, swap them and mark the flag as true.
            for (int j = 0; j < tempStringArray.length-1; j++)
            {
                if (tempStringArray[j].compareTo(tempStringArray[j+1]) > 0)
                {
                    String tempString = tempStringArray[j];
                    tempStringArray[j] = tempStringArray[j+1];
                    tempStringArray[j+1] = tempString;
                    flag = true;
                }
            }
        }
        while (flag.equals(true));

        // Clear the ArrayList and add the sorted 'tempStringArray' elements to the ArrayList.
        inputArray.clear();
        inputArray.addAll(List.of(tempStringArray));
    }

    // -------------------------------------------- Main Method ----------------------------------------------------
    public static void main(String[] args)
    {
        // Initialise ArrayList with given strings and print to console.
        ArrayList<String> givenArrayList = new ArrayList<>
                (asList("blue", "six", "hello", "game", "unorthodox", "referee", "ask", "zebra", "run", "flex"));
        System.out.println("\nOriginal Given Array: \n" + givenArrayList);

        // Call bubbleSort method and print sorted ArrayList.
        bubbleSort(givenArrayList);
        System.out.println("\nBubble Sorted Array: \n" + givenArrayList);
    }
}

