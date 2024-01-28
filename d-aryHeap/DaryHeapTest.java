import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.NoSuchElementException;

import static java.lang.Math.floor;


/**
 * DaryHeap Class
 * <p>
 * This class implements a D-ary max heap data structure.
 * It supports operations such as insertion, extraction of the maximum element, increasing a key, and building a max heap.
 * The class follows standard heap operations and is implemented using an ArrayList as the underlying data structure.
 * The implementation assumes 0-based indexing and provides detailed comments, time, and space complexity analysis for each method.
 *
 * @param <T> The type of elements stored in the heap, must extend Comparable for comparison.
 * <p>
 * Constructors:
 * - DaryHeap(int d): Initializes an empty D-ary max heap with the specified degree.
 * - DaryHeap(List<Integer> elements, int d): Initializes a D-ary max heap with the given elements and degree.
 * <p>
 * Public Methods:
 * - void insert(Integer element): Inserts an element into the heap and maintains the max heap property.
 * - void buildMaxHeap(): Builds the max heap from the given elements.
 * - Integer extractMax(): Removes and returns the maximum element from the heap.
 * - void heapInsert(Integer key): Inserts a key into the heap while maintaining the max heap property.
 * - void maxHeapInsert(Integer key): Inserts a new element with the specified key into the D-ary heap and maintains the heap properties.
 * - void heapIncreaseKey(int index, Integer newKey): Increases the key at the specified index and maintains the max heap property.
 * - boolean isEmpty(): Checks if the heap is empty.
 * - void printHeapByDepth(): Prints the heap elements by depth level.
 * - boolean isMaxHeap(): Checks if the heap is a valid max heap.
 * <p>
 * Private Methods:
 * - int parent(int i): Returns the index of the parent of the element at index 'i'.
 * - int child(int i, int k): Returns the value of the k-th child of the element at index 'i'.
 * - void swap(int i, int j): Swaps the elements at indices 'i' and 'j'.
 * - void maxHeapify(int index): Maintains the max heap property starting from the given index.
 * - int findMaxChild(int index): Finds the maximum child's index of the element at the given index.
 * <p>
 * Utility Methods:
 * - static void printLine(String message): Prints a message followed by a newline.
 * - static void print(String message): Prints a message without a newline.
 */
class DaryHeap<T extends Comparable<T>> {

    /**
     * Degree of the D-ary heap. It determines the maximum number of children each element can have.
     */
    private final int d; // Degree of the heap

    /**
     * List representing the D-ary heap's underlying data structure.
     */
    private final List<Integer> heap;

    /**
     * Initializes a D-ary heap with the specified degree.
     * <p>
     * This constructor creates a D-ary heap using an ArrayList as the underlying data structure.
     * The degree determines the maximum number of children each element can have.
     *
     * @param d The degree of the D-ary heap must be at least 2.
     *
     * @throws IllegalArgumentException if the degree is less than 2.
     * <p>
     * Time Complexity: O(1)
     * - The time complexity of this constructor is constant as it involves basic assignments.
     * <p>
     * Space Complexity: O(1)
     * - The space complexity is constant since it only creates an ArrayList and stores an integer.
     * <p>
     * Algorithm:
     * - Check if the given degree is at least 2; otherwise, throw an IllegalArgumentException.
     * - Initialize an empty ArrayList to represent the D-ary heap.
     * - Assign the specified degree to the 'd' instance variable.
     * <p>
     * Example Usage:
     * <pre>
     * {@code
     *   // Creating a D-ary heap with degree 3
     *   DaryHeap heap = new DaryHeap(3);
     * }
     * </pre>
     * <p>
     * Notes:
     * - Ensure that the degree provided is at least 2 to create a valid D-ary heap.
     */
    public DaryHeap(int d) {

        if (d < 2) {
            throw new IllegalArgumentException("Degree (d) must be at least 2");
        }

        this.heap = new ArrayList<>();
        this.d = d;
    }

    /**
     * Initializes a D-ary heap with the specified degree and populates it with the given elements.
     * <p>
     * This constructor creates a D-ary heap using an ArrayList as the underlying data structure.
     * It takes a list of elements and inserts them into the heap, ensuring that the heap properties are maintained.
     *
     * @param elements List of elements to be inserted into the heap.
     * @param d The degree of the D-ary heap must be at least 2.
     *
     * @throws IllegalArgumentException if the list of elements is null or if the degree is less than 2.
     * <p>
     * Time Complexity: O(n * log_d(n))
     * - The time complexity depends on the number of elements (n) and the degree (d).
     * - Inserting each element has a time complexity of log_d(n), and building the max heap has a time complexity of O(n).
     * <p>
     * Space Complexity: O(n)
     * - The space complexity is linear, as it depends on the number of elements in the input list.
     * <p>
     * Algorithm:
     * - Initialize the D-ary heap using the constructor with degree 'd'.
     * - Check if the list of elements is null; if so, throw an IllegalArgumentException.
     * - Insert each element from the input list into the heap using the insert method.
     * - Build the max heap to ensure the heap properties are maintained.
     * <p>
     * Example Usage:
     * <pre>
     * {@code
     *   // Creating a D-ary heap with degree 3 and inserting elements
     *   List<Integer> elements = Arrays.asList(5, 3, 8, 2, 7);
     *   DaryHeap heap = new DaryHeap(elements, 3);
     * }
     * </pre>
     * <p>
     * Notes:
     * - Ensure that the list of elements is not null, and the degree provided is at least 2.
     */
    public DaryHeap(List<Integer> elements, int d) {

        this(d);

        if (elements == null) {
            throw new IllegalArgumentException("List of elements cannot be null");
        }

        for (Integer element : elements) {
            insert(element);
        }
        buildMaxHeap();
    }

    /**
     * Inserts a new element into the D-ary heap and maintains the heap properties.
     * <p>
     * This method adds a new element to the end of the heap and then performs a max-heapify operation
     * to ensure that the heap properties are maintained.
     *
     * @param element The element to be inserted into the heap.
     * <p>
     * Time Complexity: O(log_d(n))
     * - The time complexity depends on the degree (d) and the height of the tree, which is log_d(n).
     * - The method involves adding the element to the end of the heap and performing max-heapify.
     * <p>
     * Space Complexity: O(1)
     * - The space complexity is constant as it only involves adding one element to the heap.
     * <p>
     * Algorithm:
     * - Add the new element to the end of the heap.
     * - Perform max-heapify starting from the index of the newly added element to maintain heap properties.
     * <p>
     * Example Usage:
     * <pre>
     * {@code
     *   // Inserting an element into the D-ary heap
     *   heap.insert(10);
     * }
     * </pre>
     * <p>
     * Notes:
     * - The method assumes that the heap properties are already satisfied before the insertion.
     */
    public void insert(Integer element) {

        // Add the new element to the end of the heap
        heap.add(element);

        // Maintain the max-heap property by applying maxHeapify on the newly added element's index
        maxHeapify(heap.size() - 1);
    }

    /**
     * Inserts a new element with the specified key into the D-ary heap and maintains the heap properties.
     * <p>
     * This method inserts a new element with the specified key into the D-ary heap. It adds a placeholder
     * for the new element at the end of the heap and then uses the 'heapIncreaseKey' method to set the key
     * and maintain the heap properties.
     *
     * @param key The key of the new element to be inserted.
     * <p>
     * Time Complexity: O(log_d(n))
     * - The time complexity depends on the arity (d) and the height of the tree, which is log_d(n).
     * - The method involves adding a placeholder and then calling 'heapIncreaseKey'.
     * <p>
     * Space Complexity: O(1)
     * - The space complexity is constant as it involves only basic variable assignments.
     * <p>
     * Algorithm:
     * - Add the key placeholder for the new element at the end of the heap.
     * - Use 'heapIncreaseKey' to set the key of the new element and maintain the heap properties.
     * <p>
     * Example Usage:
     * <pre>
     * {@code
     *   // Inserting a new element with key 42 into the D-ary heap
     *   heap.maxHeapInsert(42);
     * }
     * </pre>
     * <p>
     * Notes:
     * - This method assumes that the heap properties are satisfied before the insertion.
     * - The 'heapIncreaseKey' method is responsible for maintaining the heap properties.
     */
    public void maxHeapInsert(Integer key) {
        // Add a placeholder for the new element
        heap.add(key);
        heapIncreaseKey(heap.size() - 1, key);
    }

    /**
     * Builds a max heap from the elements in the D-ary heap.
     * <p>
     * This method iterates through the elements of the heap and applies the maxHeapify operation
     * to each non-leaf node, starting from the last non-leaf node and moving towards the root.
     * <p>
     * Time Complexity: O(n)
     * - The time complexity is linear, as the method iterates through each non-leaf node once,
     * and maxHeapify has a time complexity of O(log_d(n)).
     * <p>
     * Space Complexity: O(1)
     * - The space complexity is constant as it involves only basic variable assignments.
     * <p>
     * Algorithm:
     * - Start from the last non-leaf node (floor((heap.size() - 1) / d)) and move towards the root.
     * - Apply maxHeapify to each non-leaf node to maintain the max heap properties.
     * <p>
     * Example Usage:
     * <pre>
     * {@code
     *   // Building a max heap from the existing elements in the D-ary heap
     *   heap.buildMaxHeap();
     * }
     * </pre>
     * <p>
     * Notes:
     * - This method should be called after inserting elements to ensure the heap properties are satisfied.
     */
    public void buildMaxHeap() {

        // Start from the last non-leaf node and perform maxHeapify operation for each node in reverse order
        for (int i = (int) floor((double) (heap.size() - 1) / d); i >= 0; i--) {
            maxHeapify(i);
        }
    }

    /**
     * Returns the index of the parent node for a given index in the D-ary heap.
     * <p>
     * This method calculates and returns the index of the parent node for a given index 'i'
     * in the D-ary heap, based on the specified degree 'd'.
     *
     * @param i The index for which the parent index is to be calculated.
     *
     * @return The index of the parent node.
     * <p>
     * Time Complexity: O(1)
     * - The time complexity is constant as it only involves basic arithmetic operations.
     * <p>
     * Space Complexity: O(1)
     * - The space complexity is constant as it involves only basic variable assignments.
     * <p>
     * Algorithm:
     * - If the given index is less than 0, return -1 (indicating no parent).
     * - Calculate and return the index of the parent node based on the specified degree 'd'.
     * <p>
     * Example Usage:
     * <pre>
     * {@code
     *   // Getting the parent index for a given index
     *   int parentIndex = parent(5);
     * }
     * </pre>
     * <p>
     * Notes:
     * - The method returns -1 if the given index is less than 0.
     */
    private int parent(int i) {

        return (i < 0) ? -1 : (int) floor((double) (i - 1) / d);
    }

    /**
     * Returns the index of the k-th child for a given index in the D-ary heap.
     * <p>
     * This method calculates and returns the index of the k-th child for a given index 'i'
     * in the D-ary heap, based on the specified degree 'd'.
     *
     * @param i The index for which the child index is to be calculated.
     * @param k The position of the child (1-based) within the set of children.
     *
     * @return The index of the k-th child node.
     *
     * @throws NoSuchElementException if the calculated child index is out of bounds for the heap size.
     * <p>
     * Time Complexity: O(1)
     * - The time complexity is constant as it only involves basic arithmetic operations.
     * <p>
     * Space Complexity: O(1)
     * - The space complexity is constant as it involves only basic variable assignments.
     * <p>
     * Algorithm:
     * - Calculate the index of the k-th child using the specified degree 'd'.
     * - Check if the calculated child index is within bounds of the heap size.
     * - If valid, return the value at the calculated child index.
     * - If out of bounds, throw a NoSuchElementException with a descriptive message.
     * <p>
     * Example Usage:
     * <pre>
     * {@code
     *   // Getting the index of the 2nd child for a given index
     *   int childIndex = child(3, 2);
     * }
     * </pre>
     * <p>
     * Notes:
     * - The method uses 0-based indexing for the position of the child.
     * - The formula for the k-th child of node at index i is: d * i + k.
     * - Throws an exception if the calculated child index is out of bounds.
     */
    private int child(int i, int k) {

        int childIndex = this.d * i + k;

        if (childIndex >= heap.size()) {
            throw new NoSuchElementException("[Overflow]: Index " + childIndex +
                                                     " out of bounds for length " + heap.size() + ".");
        }
        return heap.get(this.d * i + k);
    }

    /**
     * Extracts and returns the maximum element from the D-ary heap.
     * <p>
     * This method removes and returns the maximum element (root) from the D-ary heap,
     * then reorganizes the heap to maintain the max heap properties.
     *
     * @return The maximum element in the heap.
     *
     * @throws NoSuchElementException if the heap is empty (heap underflow).
     * <p>
     * Time Complexity: O(log_d(n))
     * - The time complexity depends on the degree (d) and the height of the tree, which is log_d(n).
     * - The method involves removing the root, placing the last element at the root, and performing maxHeapify.
     * <p>
     * Space Complexity: O(1)
     * - The space complexity is constant as it involves only basic variable assignments.
     * <p>
     * Algorithm:
     * - Check if the heap is empty; if so, throw a NoSuchElementException.
     * - Remove the maximum element (root) from the heap.
     * - If the heap is not empty, place the last element at the root and perform maxHeapify to maintain heap properties.
     * - Return the extracted maximum element.
     * <p>
     * Example Usage:
     * <pre>
     * {@code
     *   // Extracting the maximum element from the D-ary heap
     *   Integer maxElement = heap.extractMax();
     * }
     * </pre>
     * <p>
     * Notes:
     * - The method assumes that the heap properties are satisfied before the extraction.
     */
    public Integer extractMax() throws NoSuchElementException {

        // Check if the heap is empty
        if (isEmpty()) {
            throw new NoSuchElementException("[Heap Underflow] Cannot extract maximum element.");
        }

        // Retrieve the maximum element from the root of the max-heap
        Integer max = heap.get(0);

        // Remove the last element from the heap
        Integer lastElement = heap.remove(heap.size() - 1);

        // If the heap is not empty, replace the root with the last element and maintain max-heap property
        if (!isEmpty()) {
            heap.set(0, lastElement);
            maxHeapify(0);
        }

        // Return the extracted maximum element
        return max;
    }


    /**
     * Increases the key of a specified element in the D-ary heap and maintains the max heap properties.
     * <p>
     * This method increases the key of the element at the specified index in the D-ary heap to the new key,
     * then adjusts the heap to maintain the max heap properties.
     *
     * @param index The index of the element whose key needs to be increased.
     * @param newKey The new key to set for the specified element.
     *
     * @throws NullPointerException if the heap is null.
     * @throws IndexOutOfBoundsException if the specified index is out of bounds for the heap size.
     * @throws IllegalArgumentException if the new key is smaller than the current key.
     * <p>
     * Time Complexity: O(log_d(n))
     * - The time complexity depends on the degree (d) and the height of the tree, which is log_d(n).
     * - The method involves updating the key, then repeatedly swapping with the parent until max heap properties are satisfied.
     * <p>
     * Space Complexity: O(1)
     * - The space complexity is constant as it involves only basic variable assignments.
     * <p>
     * Algorithm:
     * - Check if the heap is null, and throw a NullPointerException if true.
     * - Check if the specified index is out of bounds, and throw an IndexOutOfBoundsException if true.
     * - Check if the new key is smaller than the current key, and throw an IllegalArgumentException if true.
     * - Update the key at the specified index.
     * - Repeat the swap with the parent while the heap properties are violated.
     * <p>
     * Example Usage:
     * <pre>
     * {@code
     *   // Increasing the key of an element in the D-ary heap
     *   heap.heapIncreaseKey(2, 15);
     * }
     * </pre>
     * <p>
     * Notes:
     * - The method assumes that the heap properties are satisfied before the key increase.
     */
    public void heapIncreaseKey(int index, Integer newKey) {

        // Check for null heap
        if (heap == null) {
            throw new NullPointerException("Heap is null.");
        }

        // Check if the index is within bounds
        if (index < 0 || index >= heap.size()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for heap of" +
                                                        " size " + heap.size());
        }

        // Check if the new key is greater than or equal to the current key
        if (newKey.compareTo(heap.get(index)) < 0) {
            throw new IllegalArgumentException("New key is smaller than the current key");
        }

        // Update the key at the specified index
        heap.set(index, newKey);

        // Move the element up the heap until the max-heap property is restored
        while (index > 0 && heap.get(parent(index)) < heap.get(index)) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    /**
     * Swaps two elements in the D-ary heap.
     * <p>
     * This method swaps the elements at the specified indices 'i' and 'j' in the D-ary heap.
     *
     * @param i Index of the first element to be swapped.
     * @param j Index of the second element to be swapped.
     * <p>
     * Time Complexity: O(1)
     * - The time complexity is constant as it involves only basic variable assignments and swaps.
     * <p>
     * Space Complexity: O(1)
     * - The space complexity is constant as it involves only basic variable assignments.
     * <p>
     * Algorithm:
     * - Store the value of element at index 'i' in a temporary variable.
     * - Set the element at index 'i' to the value of element at index 'j'.
     * - Set the element at index 'j' to the value stored in the temporary variable.
     * <p>
     * Example Usage:
     * <pre>
     * {@code
     *   // Swapping elements at indices 2 and 5 in the D-ary heap
     *   swap(2, 5);
     * }
     * </pre>
     * <p>
     * Notes:
     * - This method is used for swapping elements during heap operations.
     */
    private void swap(int i, int j) {

        Integer temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /**
     * Checks if the D-ary heap is empty.
     * <p>
     * This method returns true if the D-ary heap is empty, i.e., it contains no elements.
     *
     * @return true if the heap is empty, false otherwise.
     * <p>
     * Time Complexity: O(1)
     * - The time complexity is constant as it involves checking the size of the heap.
     * <p>
     * Space Complexity: O(1)
     * - The space complexity is constant as it involves only basic operations.
     * <p>
     * Example Usage:
     * <pre>
     * {@code
     *   // Checking if the D-ary heap is empty
     *   boolean isEmpty = heap.isEmpty();
     * }
     * </pre>
     * <p>
     * Notes:
     * - Use this method to determine if the heap contains any elements.
     */
    public boolean isEmpty() {

        return heap.isEmpty();
    }

    /**
     * Prints the D-ary heap elements organized by depth.
     * <p>
     * This method prints the elements of the D-ary heap, organized by depth and separated by levels.
     * <p>
     * Time Complexity: O(n)
     * - The time complexity is linear as the method iterates through each element in the heap.
     * <p>
     * Space Complexity: O(1)
     * - The space complexity is constant as it involves only basic variable assignments.
     * <p>
     * Example Usage:
     * <pre>
     * {@code
     *   // Printing the D-ary heap elements by depth
     *   heap.printHeapByDepth();
     * }
     * </pre>
     * <p>
     * Notes:
     * - The output shows elements organized by depth with levels separated by tabs.
     */
    public void printHeapByDepth() {

        int depth = 0;
        int levelSize = 1;

        print("d-ary Heap (d = " + this.d + "): ");
        for (int i = 0; i < heap.size(); i++) {

            if (i == levelSize) {
                print("\t"); // Move to the next level
                depth++;
                levelSize += Math.pow(d, depth);
            }

            print(heap.get(i) + " ");
        }

        printLine(""); // Print a newline at the end
    }

    /**
     * Checks if the D-ary heap satisfies the max heap properties.
     * <p>
     * This method iterates through the elements of the D-ary heap and checks if the max heap properties are satisfied.
     *
     * @return true if the heap is a max heap, false otherwise.
     * <p>
     * Time Complexity: O(n)
     * - The time complexity is linear as the method iterates through each element in the heap.
     * <p>
     * Space Complexity: O(1)
     * - The space complexity is constant as it involves only basic variable assignments.
     * <p>
     * Example Usage:
     * <pre>
     * {@code
     *   // Checking if the D-ary heap is a max heap
     *   boolean isMaxHeap = heap.isMaxHeap();
     * }
     * </pre>
     * <p>
     * Notes:
     * - This method assumes that the heap is represented with 0-based indexing.
     * - Returns true if the heap satisfies the max heap properties.
     */
    public boolean isMaxHeap() {

        for (int i = 0; i < heap.size(); i++) {
            int leftChild = d * i + 1;
            if (leftChild < heap.size() && heap.get(i).compareTo(heap.get(leftChild)) < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Maintains the max heap properties by recursively fixing violations starting from the specified index.
     * <p>
     * This method compares the element at the given index with its children and swaps it with the maximum child
     * if necessary, then recursively calls itself on the swapped child to ensure max heap properties are maintained.
     *
     * @param index The index of the element to start max heapify from.
     * <p>
     * General Idea:
     * - A D-ary heap is a variation of the binary heap where each node has up to 'd' children.
     * - The heap is implemented using an ArrayList as the underlying data structure.
     * - The D-ary heap supports operations like insertion, extraction of the maximum element,
     * increasing a key, and building a max heap from a list of elements.
     * - The class includes methods for maintaining the max heap properties, such as maxHeapify and heapIncreaseKey.
     * - It also provides utility methods like printHeapByDepth to visualize the heap's structure.
     * - The implementation assumes 0-based indexing and follows standard heap operations.
     * <p>
     * Time Complexity: O(log_d(n))
     * - The time complexity depends on the degree (d) and the height of the tree, which is log_d(n).
     * - The method involves finding the maximum child and potentially swapping elements recursively.
     * <p>
     * Space Complexity: O(log_d(n))
     * - The space complexity is proportional to the height of the tree due to the recursive nature.
     * <p>
     * Algorithm:
     * - Find the maximum child index of the element at the specified index.
     * - If a valid maximum child is found, and it is greater than the element at the current index,
     * swap the elements and recursively call maxHeapify on the swapped child.
     * <p>
     * Example Usage:
     * <pre>
     * {@code
     *   // Maintaining max heap properties starting from index 2
     *   maxHeapify(2);
     * }
     * </pre>
     * <p>
     * Notes:
     * - This method assumes that the heap is represented with 0-based indexing.
     * - Called during insertion and extraction to maintain max heap properties.
     */
    private void maxHeapify(int index) {

        // Find the index of the maximum child of the element at the given index
        int maxChild = findMaxChild(index);

        // Check if a valid child exists and if it is greater than the current element
        if (maxChild != -1 && heap.get(index) < heap.get(maxChild)) {

            // Swap the current element with its maximum child
            swap(index, maxChild);

            // Recursively call maxHeapify on the swapped child index
            maxHeapify(maxChild);
        }
    }

    /**
     * Finds the index of the maximum child for a given element in the D-ary heap.
     * <p>
     * This method calculates the range of child indices based on the specified degree 'd',
     * then iterates through the children to find and return the index of the maximum child.
     *
     * @param index The index of the element for which the maximum child index is to be found.
     *
     * @return The index of the maximum child, or -1 if no valid child is found.
     * <p>
     * Time Complexity: O(d)
     * - The time complexity is linear with respect to the degree 'd' as the method iterates through the children.
     * <p>
     * Space Complexity: O(1)
     * - The space complexity is constant as it involves only basic variable assignments.
     * <p>
     * Algorithm:
     * - Calculate the range of child indices based on the specified degree 'd'.
     * - Iterate through the children within the calculated range and find the index of the maximum child.
     * - Return the index of the maximum child or -1 if no valid child is found.
     * <p>
     * Example Usage:
     * <pre>
     * {@code
     *   // Finding the index of the maximum child for the element at index 3
     *   int maxChildIndex = findMaxChild(3);
     * }
     * </pre>
     * <p>
     * Notes:
     * - This method assumes that the heap is represented with 0-based indexing.
     * - Used by maxHeapify to find the maximum child during the heapify operation.
     */
    private int findMaxChild(int index) {

        int startChild = d * index + 1;
        int endChild = Math.min(startChild + d - 1, heap.size() - 1);
        int maxChildIndex = -1;
        int maxChildValue = Integer.MIN_VALUE;

        for (int i = startChild; i <= endChild; i++) {
            if (heap.get(i) > maxChildValue) {
                maxChildValue = heap.get(i);
                maxChildIndex = i;
            }
        }

        return maxChildIndex;
    }

    /**
     * Utility Methods for Printing in the D-ary Heap Class
     * <p>
     * Time Complexity: O(1)
     * <p>
     * Example Usage:
     * <pre>
     * {@code
     *   // Using the print and println methods within the D-ary Heap class
     *   print("Hello ");
     *   printLine("World!");
     * }
     * </pre>
     */
    private static void printLine(String message) {

        System.out.println(message);
    }

    /**
     * Utility Methods for Printing in the D-ary Heap Class
     * <p>
     * Time Complexity: O(1)
     * <p>
     * Example Usage:
     * <pre>
     * {@code
     *   // Using the print and println methods within the D-ary Heap class
     *   print("Hello ");
     *   printLine("World!");
     * }
     * </pre>
     */
    private static void print(String message) {

        System.out.print(message);
    }


    /**
     * Deletes the element at the specified index in the D-ary heap and maintains the heap properties.
     * <p>
     * This method deletes the element at the specified index 'i' in the D-ary heap. It swaps the element
     * to be deleted with the last element, removes the last element (which is now the element to be deleted),
     * and then performs max-heapify to ensure the heap properties are maintained.
     * <p>
     *
     * @param i The index of the element to be deleted.
     *
     * @throws IndexOutOfBoundsException if the specified index is out of bounds for the heap size.
     * <p>
     * Time Complexity: O(log_d(n))
     * - The time complexity depends on the arity (d) and the height of the tree, which is log_d(n).
     * - The method involves swapping, removing, and performing max-heapify.
     * <p>
     * Space Complexity: O(1)
     * - The space complexity is constant as it involves only basic variable assignments.
     * <p>
     * Algorithm:
     * - Check if the specified index is out of bounds; if so, throw an IndexOutOfBoundsException.
     * - Swap the element to be deleted with the last element.
     * - Remove the last element (which is now the element to be deleted).
     * - Perform max-heapify starting from the index of the swapped element to maintain heap properties.
     * <p>
     * Example Usage:
     * <pre>
     * {@code
     *   // Deleting the element at index 2 from the D-ary heap
     *   heap.delete(2);
     * }
     * </pre>
     * <p>
     * Notes:
     * - This method assumes that the heap properties are satisfied before the deletion.
     */
    public void delete(int i) {

        if (i < 0 || i >= heap.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        // Swap the element to be deleted with the last element
        int lastIndex = heap.size() - 1;
        swap(i, lastIndex);

        // Remove the last element (which is now the element to be deleted)
        heap.remove(lastIndex);

        // Heapify after removal
        maxHeapify(i);

        printLine("\nThe updated heap after removing the node at index '" + i + "' is: ");
        printHeapByDepth();
        printLine("");
    }

}


public class DaryHeapTest {

    /**
     * Main method to interact with and demonstrate the D-ary Heap implementation.
     * <p>
     * This method creates a D-ary Heap based on user input.
     * <p>
     * Example Usage:
     * <pre>
     * {@code
     *   // Running the main program to interact with the D-ary Heap
     *   main(args);
     * }
     * </pre>
     * <p>
     * Notes:
     * - The program continuously prompts the user for actions until manually exited.
     * - Ensure to provide valid inputs according to the specified actions.
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Ask for the requested d value
        System.out.print("Enter the degree of the d-ary heap (must be at least 2): ");
        int d = scanner.nextInt();

        // Create a D-ary Heap
        DaryHeap<Integer> daryHeap = new DaryHeap<>(d);

        while (true) {
            // Ask the user for the action
            printLine("\nChoose an action:");
            printLine("1. Insert element");
            printLine("2. Extract maximum element");
            printLine("3. Build Max-Heap");
            printLine("4. Increase Key");
            printLine("5. Delete Key");
            printLine("6. Print Heap by Depth");
            printLine("7. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    print("Enter the element to insert: ");
                    int element = scanner.nextInt();
                    daryHeap.maxHeapInsert(element);
                    break;
                case 2:
                    try {
                        printLine("Extracted max element: " + daryHeap.extractMax());
                    } catch (Exception e) {
                        printLine(e.getMessage());
                    }
                    break;
                case 3:
                    daryHeap = buildNewHeap(scanner, d);
                    break;
                case 4:
                    System.out.print("Enter the index of the element to increase key: ");
                    int index = scanner.nextInt();
                    System.out.print("Enter the new key value: ");
                    int newKey = scanner.nextInt();
                    daryHeap.heapIncreaseKey(index, newKey);
                    break;
                case 5:
                    print("Enter the key you want to delete: ");
                    int delKey = scanner.nextInt();
                    daryHeap.delete(delKey);
                    break;
                case 6:
                    daryHeap.printHeapByDepth();
                    break;
                case 7:
                    printLine("Exiting program. Bye!");
                    System.exit(0);
                default:
                    printLine("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Builds a new D-ary heap using user input.
     * <p>
     * This method prompts the user to enter the number of elements and the elements themselves,
     * then constructs and returns a new D-ary heap using the provided degree 'd'.
     *
     * @param scanner Scanner object to read user input.
     * @param d The degree of the D-ary heap (must be at least 2).
     *
     * @return A new D-ary heap constructed from user input.
     *
     * @throws IllegalArgumentException if the number of elements is negative or the list of elements is empty.
     * <p>
     * Time Complexity: O(numElements)
     * - The time complexity is linear as it depends on the number of elements entered by the user.
     * <p>
     * Space Complexity: O(numElements)
     * - The space complexity is linear as it depends on the number of elements entered by the user.
     * <p>
     * Example Usage:
     * <pre>
     * {@code
     *   // Building a new D-ary heap using user input
     *   DaryHeap<Integer> newHeap = buildNewHeap(scanner, 3);
     * }
     * </pre>
     * <p>
     * Notes:
     * - The method assumes a valid degree 'd' is provided.
     * - The user is prompted to enter the number of elements and each element individually.
     */
    private static DaryHeap<Integer> buildNewHeap(Scanner scanner, int d) {
        // Ask for new values to build a new heap
        print("Enter the number of elements for the new heap: ");
        int numElements = scanner.nextInt();

        if (numElements < 0) {
            throw new IllegalArgumentException("Number of elements must be non-negative");
        }

        List<Integer> elements = new ArrayList<>();
        for (int i = 0; i < numElements; i++) {
            print("Enter element " + (i + 1) + ": ");
            elements.add(scanner.nextInt());
        }

        if (elements.isEmpty()) {
            throw new IllegalArgumentException("List of elements cannot be empty");
        }

        return new DaryHeap<>(elements, d);
    }

    /**
     * Prints a line to the standard output.
     * <p>
     * This method prints the specified message followed by a newline to the standard output.
     *
     * @param message The message to be printed.
     */
    private static void printLine(String message) {

        System.out.println(message);
    }

    /**
     * Prints a message to the standard output without a newline.
     *
     * @param message The message to be printed.
     */
    private static void print(String message) {

        System.out.print(message);
    }

}

