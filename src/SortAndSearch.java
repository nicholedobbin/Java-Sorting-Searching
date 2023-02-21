/* ================================= L3T3: Compulsory Task 3: SortAndSearch.java ======================================

    This program implements the Linear and Binary Search algorithms on the given ArrayList to find a given element's
    index. It also implements the Insertion Sort method on the ArrayList and prints out the sorted list.

    (1) The appropriate search algorithm to use in this case is a Linear Search method. I chose to first implement
        this method because the given ArrayList is a one-dimensional, unsorted array. The Linear Search method:
        -   Takes the ArrayList and the target search element (i.e. known item) as parameters.
        -   Loops through the ArrayList, comparing each element to the known item.
        -   The process stops when the element matching the known item is found, or when the end of the
            list is reached.
        -   Has a time complexity of O(n).

    (2) The Insertion Sort method is a sorting algorithm that essentially transfers elements one at a time to the
        right position. The array is virtually divided into sorted and unsorted parts, and values from the unsorted
        part are found and moved to the correct position in the sorted part.
        The Insertion Sort method:
        -   Iterates from index 1 to index N (i.e. array.length) of the array.
        -   Compares the current element (i.e. the key) to its predecessor.
        -   If the current element is less than its predecessor, compares it to the elements before.
        -   Shifts the greater elements one position up to make space for the swapped element.
        -    Has a time complexity of O(n^2).

    (3) I chose to implement the Binary Search method as the method I've not used in this task, because this
        searching method is useful for sorted arrays, with a time complexity of O(log n). The Binary Search method
        finds a given element's index in the sorted array, by:
        -   finding the mid-point of the list.
        -   determining if the target element is on its left side (i.e. smaller than target element) or on its
            right side (i.e. bigger than the target element).
        -   repeatedly halving the portion of the list that could contain the target element, until the element
            is found.

        In a real world situation, you might use the Binary Search algorithm to find the word "Duplicate" and
        its corresponding meaning in a dictionary. A dictionary itself is essentially an order list of words (i.e
        in ordered in alphabetical order). To search for the key word "Duplicate" with the Binary Search method, we
        would open the dictionary at the middle page and compare the words on that page with the keyword. If
        "Duplicate" is alphabetically smaller than the words on the middle page, we could ignore all the pages on
        the right side of the middle page (i.e. after the middle page). If "Duplicate" is alphabetically larger, we
        could ignore all the pages on the left side of the middle page. We would then continue to search only the
        side where "Duplicate" might be, by repeatedly halving and comparing the words on the page with "Duplicate"
        until we have narrowed down our search side to one page (i.e. the page where "Duplicate" is found).

 ====================================================================================================================*/

import java.util.Arrays;

public class SortAndSearch
{
    // ----------------------------------------- Linear Search Method ----------------------------------------------
    public static String linearSearch(int item, int[] list)
    {
        // If index is still -1 at the end of this method, the item is not in this array.
        int index = -1;
        // Loop through each element in the array. if we find the item, exit the loop.
        for (int i = 0; i < list.length; i++)
        {
            if (list[i] == item)
            {
                index = i;
                break;
            }
        }
        // Return the index of where the item was found.
        return "Item [" + item + "] found at index: " + index;
    }

    // ------------------------------------ Insertion Sort Method --------------------------------------------------
    // Loops through array, comparing currentElement to its predecessor. If currentElement is less than
    // predecessor, compare it to elements before and shift greater elements one position up.
    public static void insertionSort(int[] array)
    {
        int arrayLength = array.length;

        for (int i = 1; i < arrayLength; i++)
        {

            int currentElement = array[i];
            int j = i - 1;

            while ((j >= 0) && (array[j] > currentElement))
            {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = currentElement;
        }
    }

    // ------------------------------------- Binary Search Method --------------------------------------------------
    public static String binarySearch(int item, int[] list)
    {
        // if index = -1 when the method is finished, we did not find the search term in the array.
        int index = -1;
        // set the starting and ending indexes of the array; these will change as we narrow our search.
        int low = 0;
        int high = list.length-1;
        int mid;

        // Continue to search for the search term until we find it or until our ''low'' and ''high'' markers cross.
        while (high >= low)
        {
            // calculate the midpoint of the current array.
            mid = (high + low)/2;
            // if value is in lower half, if at all
            if (item < list[mid])
            {
                high = mid - 1;
            }
            // if value is in upper half, if at all
            else if (item > list[mid])
            {
                low = mid + 1;
            }
            // found it! break out of the loop.
            else
            {
                index = mid;
                break;
            }
        }
        return "Item [" + item + "] found at index: " + index;
    }

    // ------------------------------------------ Main Method ------------------------------------------------------
    public static void main(String[] args)
    {
        // Initialise integer array with given integers and print to console.
        int[] givenArray = {27, -3, 4, 5, 35, 2, 1, -40, 7, 18, 9, -1, 16, 100};
        System.out.println("\n------- ORIGINAL UNSORTED ARRAY --------");
        System.out.println(Arrays.toString(givenArray));

        // Call linearSearch method to find and print index of element '9'.
        System.out.println("\n------- LINEAR SEARCH TO FIND GIVEN ELEMENT'S INDEX --------");
        System.out.println(linearSearch(9,givenArray));

        // Call insertionSort method to sort integers in ascending order and print sorted array.
        insertionSort(givenArray);
        System.out.println("\n------- SORTED ARRAY WITH INSERTION SORT --------");
        System.out.println(Arrays.toString(givenArray));

        // Call binarySearch method to find and print index of element '9' in sorted array.
        System.out.println("\n----------- (8) 'albums2': BINARY SEARCH TO FIND GIVEN ELEMENT'S INDEX -----------");
        System.out.println(binarySearch(9, givenArray));
    }
}

