/* ===================================== L3T3: Compulsory Task 1: ArrayLists.java =====================================

    This program contains an Album Class with an Album constructor method and relevant data fields, getter and setter
    methods, and a 'toString()' method to create two ArrayLists of Album objects ('albums1' and 'albums2' with the
    following print format: (albumName, albumArtist, numberOfSongs). The program demonstrates a variety of sorting
    and searching algorithms, using the following methods:

    ----- albums1 ArrayList -----
    (1) A method to populate the 'albums1' ArrayList.
    (2) A Selection Sort method that sorts the ArrayList by number of songs (in ascending order) by:
        -   dividing the ArrayList into sorted and unsorted parts
        -   finding the minimum element of the unsorted part of the array and putting it at the beginning of the
            sorted part by swapping the elements.
        This sorting method is useful for small arrays/lists, with a time complexity of O(n^2).
    (3) A method to swap the albums in 'albums1' at positions 1 and 2.

    ----- albums2 ArrayList -----
    (4) A method to populate the 'albums2' ArrayList.
    (5) An addAll() method to add all the albums from 'albums1' to 'albums2' (called in Main class).
    (6) A method to add 2 given elements to 'albums2' ArrayList.
    (7) A Quick Sort method that sorts the ArrayList's objects into alphabetical order based on album names, by:
        -   using a pivot element and partitioning the ArrayList into two sub-arrays
        -    sorting the elements less than the pivot to the left sub-array and the elements greater than the
            pivot to the right sub-array.
        -   combining the two sorted sub-arrays to produce the final, sorted ArrayList.
        This sorting method is useful for large arrays/data-sets, with a time complexity of O(n log(n)).
    (8) A Binary Search method to find a given album's index in the sorted ArrayList, by:
        -   finding the mid-point of the list.
        -   determining if the target element is on its left side (i.e. smaller than target element) or on its
            right side (i.e. bigger than the target element).
        -   repeatedly halving the portion of the list that could contain the target element, until the element
            is found.
        This searching method is useful for sorted arrays, with a time complexity of O(log n).

 ====================================================================================================================*/

import java.util.ArrayList;
import java.util.Collections;

public class ArrayLists
{

    // ============================================= Album Class ===================================================
    public static class Album
    {
        // ----------------------------------------- Data fields ---------------------------------------------------
        String albumName;
        String albumArtist;
        int numberOfSongs;

        // ------------------------------------- Constructor Method ------------------------------------------------
        public Album(String albumName, String albumArtist, int numberOfSongs)
        {
            this.albumName = albumName;
            this.albumArtist = albumArtist;
            this.numberOfSongs = numberOfSongs;
        }

        // ----------------------------------- Getter & Setter Methods ---------------------------------------------
        // Getters
        public String getAlbumName() {return albumName;}
        public String getAlbumArtist() {return albumArtist;}
        public int getNumberOfSongs() {return numberOfSongs;}

        // Setters (unused, but I kept them here as per task instructions)
        public void setAlbumArtist(String newArtist) {this.albumArtist = newArtist;}
        public void setAlbumName(String newAlbumName) {this.albumName = newAlbumName;}
        public void setNumberOfSongs(int newNumberOfSongs) {this.numberOfSongs = newNumberOfSongs;}

        // -------------------------------------- toString Method --------------------------------------------------
        // Overrides the toString() method in java Object class.
        public String toString()
        {
            return "(" + albumName + ", "+ albumArtist + ", " + numberOfSongs + ")\n";
        }

        // ======================================== Albums1 Methods ================================================

        // -------------------------- (1) Populate 'albums1' ArrayList ---------------------------------------------
        private static void populateAlbums1ArrayList(ArrayList<Album> albumsArray)
        {
            // Create five album instances.
            Album firstAlbum = new Album
                    ("Aha Shake Heartbreak", "Kings of Leon", 13);
            Album secondAlbum = new Album
                    ("Three Second Memory", "Goldfish", 16);
            Album thirdAlbum = new Album
                    ("Permanent Waves","Rush",6);
            Album fourthAlbum = new Album
                    ("WattsWave IV: Dreams", "Akira The Don",20);
            Album fifthAlbum = new Album
                    ("Talking", "Elderbrook", 7);

            // Add all instances to 'albums1' ArrayList.
            Collections.addAll(albumsArray, firstAlbum, secondAlbum, thirdAlbum, fourthAlbum, fifthAlbum);
        }

        // ------------------------------- (2) Selection Sort Method -----------------------------------------------
        public static void selectionSortByNumberOfSongs(ArrayList<Album> albumsArray)
        {
            int arraySize = albumsArray.size();

            // Move boundary (minimumIndex) of unsorted sub-array as loop increments.
            for (int i = 0; i < arraySize-1; i++)
            {
                int minimumIndex = i;

                // Find the minimum element in the unsorted sub-array.
                for (int j = i + 1; j < arraySize; j++)
                {
                    // If the numberOfSongs at index j is less than the numberOfSongs at minimumIndex, change
                    // the minimumIndex to index j.
                    if (albumsArray.get(j).getNumberOfSongs() < albumsArray.get(minimumIndex).getNumberOfSongs())
                    {
                        minimumIndex = j;
                    }
                }

                // Store the fields at minimumIndex in temporary Album object.
                Album tempAlbum = albumsArray.get(minimumIndex);

                // Set the fields at minimumIndex to the fields at index i.
                albumsArray.set(minimumIndex, albumsArray.get(i));

                // Set the fields at index i to the stored temporary object values.
                albumsArray.set(albumsArray.indexOf(albumsArray.get(i)), tempAlbum);
            }
        }

        // ------------------------------- (3) Swap Elements Method ------------------------------------------------
        private static void swapElementsInAlbum(ArrayList<Album> albumsArray)
        {
            // Create temporary Album object to store object at index 1 of albumsArray.
            Album tempAlbum = new Album(
                    albumsArray.get(1).getAlbumName(),
                    albumsArray.get(1).getAlbumArtist(),
                    albumsArray.get(1).getNumberOfSongs());

            // Set the fields at index 1 of albumsArray to the fields at index 2.
            albumsArray.set(1, albumsArray.get(2));

            // Set the fields at index 2 to the tempAlbum's fields.
            albumsArray.set(2, tempAlbum);
        }

        // ======================================== Albums2 Methods ================================================

        // -------------------------- (4) Populate 'albums2' ArrayList ---------------------------------------------
        private static void populateAlbums2ArrayList(ArrayList<Album> albumsArray)
        {
            // Create five album instances.
            Album firstAlbum = new Album
                    ("Silk and Soul", "Nina Simone",12);
            Album secondAlbum = new Album
                    ("Pendulum", "Creedence Clearwater Revival", 13);
            Album thirdAlbum = new Album
                    ("Blue Is The Colour", "The Beautiful South",11);
            Album fourthAlbum = new Album
                    ("Live Killers", "Queen", 22);
            Album fifthAlbum = new Album
                    ("Piano Man", "Billy Joel", 33);

            // Add all instances to 'albums2' ArrayList.
            Collections.addAll(albumsArray, firstAlbum, secondAlbum, thirdAlbum, fourthAlbum, fifthAlbum);
        }

        // -------------------------- (6) Add Given Elements Method ------------------------------------------------
        private static void addElementsToAlbums2(ArrayList<Album> albumsArray)
        {
            // Create two album instances with given fields.
            Album firstAddedAlbum = new Album
                    ("Dark Side of the Moon", "Pink Floyd", 9);
            Album secondAddedAlbum = new Album
                    ("Oops!... I Did It Again", "Britney Spears", 16);

            // Add both instances to 'albums2' ArrayList.
            Collections.addAll(albumsArray, firstAddedAlbum, secondAddedAlbum);
        }

        // --------------------------------- (7) Quick Sort Method -------------------------------------------------
        // quickSortAlphabetically method calls partition method and recursively calls quickSortAlphabetically
        // to sort the two sub-arrays.
        public static void quickSortAlphabetically(ArrayList<Album> albumsArray, int low, int high)
        {
            if (low < high)
            {
                int middle = partition(albumsArray, low, high);
                quickSortAlphabetically(albumsArray, low, middle-1);
                quickSortAlphabetically(albumsArray, middle+1, high);
            }
        }

        // Partition method supports Quick Sort method by selecting the pivot point and moving elements accordingly.
        public static int partition(ArrayList<Album> albumsArray, int low, int high)
        {
            // Create pivot point.
            Album pivot = albumsArray.get(low);

            // Loop through the array, sorting elements into correct position based on pivot point.
            do
            {
                // While albumName at high is greater than pivot's albumName, decrement 'high'
                // (i.e. decrement until an albumName smaller than pivot's is found).
                while (low < high && albumsArray.get(high).albumName.compareTo(pivot.albumName) >= 0) {
                    high--;
                }

                if (low < high)
                {
                    // When the smaller albumName is found, swap their positions.
                    albumsArray.set(low, albumsArray.get(high));

                    // While albumName at low is less than pivot's albumName, increment 'low'
                    // (i.e. increment until an albumName greater than pivot's is found).
                    while (low < high && albumsArray.get(low).albumName.compareTo(pivot.albumName) <= 0)
                    {
                        low++;
                    }

                    if (low < high)
                    {
                        // When the greater albumName is found, swap their positions.
                        albumsArray.set(high, albumsArray.get(low));
                    }
                }
            }

            while (low < high);
            // Move the pivot back into the array and return its index.
            albumsArray.set(low, pivot);
            return low;
        }

        // --------------------------------- (8) Binary Search Method ----------------------------------------------
        public static String binarySearch(String item, ArrayList<Album> albumsArray)
        {
            // If index = -1 when the method is finished,the item is not found in the ArrayList.
            int index = -1;
            // Set starting and ending indexes and declare middle index.
            int low = 0;
            int high = albumsArray.size()-1;
            int middle;

            // Search for item until it is found or until 'low' and 'high' markers cross.
            while (high >= low)
            {
                // Calculate midpoint of current array.
                middle = (high + low)/2;

                // If item is less than middle's albumName, change high to index at middle-1 (i.e. item is in
                // lower half, if at all).
                if (item.compareTo(albumsArray.get(middle).albumName) < 0)
                {
                    high = middle - 1;
                }
                // If item is greater than middle's albumName, change low to index at middle+1
                // (i.e. item is in upper half, if at all).
                else if (item.compareTo(albumsArray.get(middle).albumName) > 0)
                {
                    low = middle + 1;
                }
                // Else, item is found, break out of loop.
                else
                {
                    index = middle;
                    break;
                }
            }
            // Print index of item.
            return "Item [" + item + "] found at index: " + index;
        }
    }

    // =========================================== Main Method =====================================================
    public static void main(String[] args)
    {
        // Create 'albums1' ArrayList to store album objects.
        // Call method to populate ArrayList with 5 album instances, and print out arrayList.
        System.out.println("\n==================== ALBUMS1 ====================");
        System.out.println("\n----- (1) POPULATE ARRAYLIST WITH 5 ALBUMS -----\n");
        ArrayList<Album> albums1 = new ArrayList<Album>();
        Album.populateAlbums1ArrayList(albums1);
        System.out.println(albums1);

        // Call Selection Sort method to sort and print out sorted ArrayList.
        System.out.println("\n----- (2) SORT ARRAYLIST BY NUMBER OF SONGS (ASCENDING ORDER) -----\n");
        Album.selectionSortByNumberOfSongs(albums1);
        System.out.println(albums1);

        // Call method to swap album objects at index 0 and 1, and print out updated ArrayList.
        System.out.println("\n----- (3) SWAP ALBUMS AT POSITIONS 1 AND 2 -----\n");
        Album.swapElementsInAlbum(albums1);
        System.out.println(albums1);

        // Create 'albums2' ArrayList to store album objects.
        // Call method to populate ArrayList with 5 album instances, and print out arrayList.
        System.out.println("\n==================== ALBUMS2 ====================");
        System.out.println("\n----- (4) POPULATE NEW ARRAYLIST WITH 5 ALBUMS -----\n");
        ArrayList<Album> albums2 = new ArrayList<Album>(5);
        Album.populateAlbums2ArrayList(albums2);
        System.out.println(albums2);

        // Call addAll() method to add all 'albums1' elements to 'albums2', and print out updated 'albums2'.
        System.out.println("\n----- (5) ADD ALL ALBUMS FROM 'albums1' TO 'albums2' -----\n");
        albums2.addAll(albums1);
        System.out.println(albums2);

        // Call method to add given elements and print out updated ArrayList.
        System.out.println("\n----- (6) ADD 2 ELEMENTS TO 'albums2' -----\n");
        Album.addElementsToAlbums2(albums2);
        System.out.println(albums2);

        // Call Quick Sort method to sort ArrayList alphabetically by Album Name and print out updated ArrayList.
        System.out.println("\n----- (7) SORT ARRAYLIST ALPHABETICALLY BY ALBUM NAME -----\n");
        Album.quickSortAlphabetically(albums2, 0, albums2.size()-1);
        System.out.println(albums2);

        // Call Binary Search method to find the index of a given Album Name.
        System.out.println("\n----- (8) BINARY SEARCH TO FIND GIVEN ALBUM'S INDEX -----\n");
        System.out.println(Album.binarySearch("Dark Side of the Moon", albums2));
    }
}
