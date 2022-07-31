package Week1;
// You are provided with kth linked list. Write an algorithm to find median of merged linked 
// list in sorter order.
// input: list 1= [2,4,7,5,10]
// list2 = [3,2,7,9]
// list3 = [12,5,6,9]
// output: 5
// Explanation:
// after merging above kth linked list i.e three list in sorted order linked list become, 
// [2,2,3,4,5,5,6,7,7,9,9,10]



import Week1.SingelyLinkedList.Node;

public class Week1 {

    SingelyLinkedList[] arr; // This array saves all the linked lists input by the user.

    Week1(SingelyLinkedList[] arr) {
        // constructor
        this.arr = arr;
    }

    SingelyLinkedList mergeAll() {
        // This function itterates through all the linked lists and merges them into one linked list.
        SingelyLinkedList finalOutputList = arr[0]; // Initialize the final output list with the first linked list.
        SingelyLinkedList mergedList; // This linked list is used to save the two merged linked list.
        for (int i = 1; i < arr.length; i++) {
            // itteration through all the linked lists.
            mergedList = mergeTwo(finalOutputList, arr[i]); // Merge the current linked list with the final output list.
            finalOutputList = mergedList; // Update the final output list with the merged linked list.
        }
        return finalOutputList; // Return the final output list.
    }

    SingelyLinkedList mergeTwo(SingelyLinkedList a, SingelyLinkedList b) {
        // This function merges two linked lists.
        SingelyLinkedList result = new SingelyLinkedList(); // Initialize the result linked list.
        Node first_itterator = a.head; // Initialize the first itterator with the first linked list.
        Node second_itterator = b.head; // Initialize the second itterator with the second linked list.
        while (first_itterator != null) {
            // itterate through the first linked list.
            result.addNode(first_itterator.data); // Append the current data to the result linked list.
            first_itterator = first_itterator.next; // Update the first itterator.
        }
        while (second_itterator != null) {
            // itterate through the second linked list.
            result.addNode(second_itterator.data); // Append the current data to the result linked list.
            second_itterator = second_itterator.next; // Update the second itterator.
        }
        return sortLinkedList(result); // Return the sorted result linked list.
    }

    SingelyLinkedList sortLinkedList(SingelyLinkedList list) {
        // Node current will point to head
        Node current = list.head, index = null; // Initialize the current and index pointers.
        int temp; // Initialize the temp variable.

        if (list.head == null) {
            return null; // If the linked list is empty, return null.
        } else {
            while (current != null) {
                // Node index will point to node next to current
                index = current.next;

                while (index != null) {
                    // If current node's data is greater than index's node data, swaping the data between them
                    if (current.data > index.data) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
        return list; // Return the saved linked list.
    }

    void output() {

        int median = (mergeAll().getSize() + 1) / 2;
        // Get the output of the linked list.
        System.out.println("output: " + mergeAll().getDataAtAnyPos(median)); // Print the median.
    }

    public static void main(String[] args) {
        // created 3 linked lists
        SingelyLinkedList[] arr = new SingelyLinkedList[3];
        SingelyLinkedList list1 = new SingelyLinkedList();
        SingelyLinkedList list2 = new SingelyLinkedList();
        SingelyLinkedList list3 = new SingelyLinkedList();

        // added nodes to the linked lists
        list1.addNode(2);
        list1.addNode(4);
        list1.addNode(7);
        list1.addNode(5);
        list1.addNode(10);

        list2.addNode(3);
        list2.addNode(2);
        list2.addNode(7);
        list2.addNode(9);
        
        list3.addNode(12);
        list3.addNode(5);
        list3.addNode(6);
        list3.addNode(9);
        // passing the linked lists as arrays
        arr[0] = list1;
        arr[1] = list2;
        arr[2] = list3;
        Week1 w = new Week1(arr);
        // displaying the output
        w.output();
    }
}