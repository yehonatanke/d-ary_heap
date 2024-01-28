<div align="center">
  <img src="https://img.shields.io/badge/language-Java-red.svg">
  <img src="https://custom-icon-badges.demolab.com/github/license/denvercoder1/custom-icon-badges?logo=law">
</div>

# d-ary heap

## Overview
The d-ary heap implements a D-ary max heap data structure in Java. It supports essential operations such as insertion, extraction of the maximum element, increasing a key, and building a max heap. The implementation utilizes an ArrayList as the underlying data structure and assumes 0-based indexing. Detailed comments, time, and space complexity analyses are provided for each method.

## Table of Contents
1. [General Information](#general-information)
2. [Wikipedia Reference](#wikipedia-reference)
3. [D-ary Heap Properties](#d-ary-heap-properties)
4. [Installation](#installation)
5. [Program Structure](#program-structure)
   - [Constructors](#constructors)
   - [Public Methods](#public-methods)
   - [Private Methods](#private-methods)
   - [Utility Methods](#utility-methods)
6. [DaryHeapTest Class](#daryheaptest-class)
   - [Overview](#overview)
   - [Main Method](#main-method)
   - [Utility Methods](#utility-methods-1)
   - [Example Usage](#example-usage)
7. [License](#license)

### General Information
This program serves as an implementation for the course "Data Structures and Introduction to Algorithms" at The Open University. This practical implementation allows to interact with and explore the functionality of the D-ary Heap, a key data structure in the study of algorithms and data structures.

### Wikipedia Reference

#### For a more detailed overview, you can visit: 
   - [Binary heap](https://en.wikipedia.org/wiki/Binary_heap)
   - [d-ary heap](https://en.wikipedia.org/wiki/D-ary_heap)

### D-ary Heap Properties

A D-ary heap is a specialized data structure with the following properties:

- **Structure:** The heap is a tree structure where each node has D children.
- **Heap Property:** In a max D-ary heap, for every node \( i \), the key of \( i \) is greater than or equal to the keys of its children.
- **Representation:** The heap can be efficiently represented using an array.

## Installation

To use the DaryHeap library in your Java project, follow these simple steps:

1. Clone Repository:
   ```bash
   git clone [https://github.com/yehonatanke/d-ary_heap.git]
2. Include in Your Project:
  - Include the DaryHeap.java file in your project.
  - Ensure the file is in the correct package if your project uses packages.
3. Usage:
  - Create an instance of the DaryHeap class.
  - Use the provided methods like maxHeapInsert and delete for manipulating the heap.
4. Build and Run:
  - Build your project to compile the DaryHeap class.
  - Run your project to utilize the D-ary heap functionality.


## Program Structure
### Constructors
- `DaryHeap(int d)`: Initializes an empty D-ary max heap with the specified degree.
- `DaryHeap(List<Integer> elements, int d)`: Initializes a D-ary max heap with the given elements and degree.

### Public Methods
- `void insert(Integer element)`: Inserts an element into the heap and maintains the max heap property.
- `void buildMaxHeap()`: Builds the max heap from the given elements.
- `Integer extractMax()`: Removes and returns the maximum element from the heap.
- `void heapInsert(Integer key)`: Inserts a key into the heap while maintaining the max heap property.
- `void maxHeapInsert(Integer key)`: Inserts a new element with the specified key into the D-ary heap and maintains the heap properties.
- `void heapIncreaseKey(int index, Integer newKey)`: Increases the key at the specified index and maintains the max heap property.
- `boolean isEmpty()`: Checks if the heap is empty.
- `void printHeapByDepth()`: Prints the heap elements by depth level.
- `boolean isMaxHeap()`: Checks if the heap is a valid max heap.

### Private Methods
- `int parent(int i)`: Returns the index of the parent of the element at index 'i'.
- `int child(int i, int k)`: Returns the value of the k-th child of the element at index 'i'.
- `void swap(int i, int j)`: Swaps the elements at indices 'i' and 'j'.
- `void maxHeapify(int index)`: Maintains the max heap property starting from the given index.
- `int findMaxChild(int index)`: Finds the maximum child's index of the element at the given index.

### Utility Methods
- `static void printLine(String message)`: Prints a message followed by a newline.
- `static void print(String message)`: Prints a message without a newline.

## **DaryHeapTest Class**

### Overview
The `DaryHeapTest` class serves as a demonstration and interaction point for the D-ary Heap implementation (`DaryHeap` class). The main method allows users to perform various actions on the D-ary Heap, such as insertion, extraction of the maximum element, building a max heap, increasing a key, deleting a key, and printing the heap by depth. The program continuously prompts the user for actions until manually exited.

### Main Method
- `main(String[] args)`: Interacts with the D-ary Heap based on user input. It prompts the user to enter the degree of the D-ary heap, then allows them to choose actions to perform on the heap. The actions include inserting elements, extracting the maximum element, building a max-heap, increasing a key, deleting a key, and printing the heap by depth.

### Utility Methods
- `buildNewHeap(Scanner scanner, int d)`: Builds a new D-ary heap using user input. It prompts the user to enter the number of elements and the elements themselves, then constructs and returns a new D-ary heap using the provided degree 'd'.
- `printLine(String message)`: Prints a line to the standard output.
- `print(String message)`: Prints a message to the standard output without a newline.

### Example Usage
```java
// Running the main program to interact with the D-ary Heap
main(args);

// Building a new D-ary heap using user input
```
### General Methodology
The `DaryHeapTest` class follows a user-driven approach, allowing interaction with the D-ary Heap implementation (`DaryHeap` class) through a command-line interface. The general methodology includes the following steps:

1. **Degree Initialization:**
   - The user is prompted to enter the degree (d) for the D-ary heap. The degree represents the number of children each node can have.

2. **D-ary Heap Initialization:**
   - A D-ary heap (`DaryHeap` object) is created based on the provided degree. The heap is initially empty.

3. **User Interaction Loop:**
   - The program enters a loop that continuously prompts the user for actions until manually exited.

4. **Action Selection:**
   - The user is presented with a menu of actions to choose from, including:
     - Inserting an element into the heap.
     - Extracting the maximum element from the heap.
     - Building a max-heap from a list of elements.
     - Increasing the key of an element at a specified index.
     - Deleting a key from the heap.
     - Printing the heap elements by depth.
     - Exiting the program.

5. **Action Execution:**
   - Based on the user's selection, the program executes the corresponding action by calling the appropriate methods from the `DaryHeap` class.

6. **Exception Handling:**
   - Exception handling is implemented to manage potential errors, such as attempting to extract from an empty heap.

7. **Continuous Interaction:**
   - The program allows users to perform multiple actions in sequence or exit the program at any point.

8. **Utility Methods:**
   - Additional utility methods (`buildNewHeap`, `printLine`, `print`) support specific functionalities, such as building a new heap from user input and printing messages to the console.

9. **Example Usage:**
   - Example code snippets demonstrate how to run the main program and build a new D-ary heap using user input.



## License

This program is released under the [MIT License](https://github.com/yehonatanke/d-ary_heap/blob/main/LICENSE).

## Author

yehonataKe
