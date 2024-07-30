public class TaskManagementSystem {

    // Class representing a task
    static class Task {
        private int taskId;
        private String taskName;
        private String status;

        public Task(int taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
        }

        public int getTaskId() {
            return taskId;
        }

        public String getTaskName() {
            return taskName;
        }

        public String getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return "TaskID: " + taskId + ", TaskName: " + taskName + ", Status: " + status;
        }
    }

    // Node class for singly linked list
    static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    // Singly Linked List class to manage tasks
    static class TaskLinkedList {
        private Node head;
        private int size;

        public TaskLinkedList() {
            head = null;
            size = 0;
        }

        // Add a task to the end of the list
        public void addTask(Task task) {
            Node newNode = new Node(task);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            size++;
        }

        // Search for a task by ID
        public Task searchTask(int taskId) {
            Node current = head;
            while (current != null) {
                if (current.task.getTaskId() == taskId) {
                    return current.task;
                }
                current = current.next;
            }
            return null; // Task not found
        }

        // Traverse and print all tasks
        public void traverseTasks() {
            Node current = head;
            if (current == null) {
                System.out.println("No tasks to display.");
                return;
            }
            while (current != null) {
                System.out.println(current.task);
                current = current.next;
            }
        }

        // Delete a task by ID
        public boolean deleteTask(int taskId) {
            if (head == null) {
                return false; // Empty list
            }

            // Special case: delete the head node
            if (head.task.getTaskId() == taskId) {
                head = head.next;
                size--;
                return true;
            }

            // Search for the task to delete
            Node current = head;
            while (current.next != null && current.next.task.getTaskId() != taskId) {
                current = current.next;
            }

            if (current.next == null) {
                return false; // Task not found
            }

            // Bypass the node to delete
            current.next = current.next.next;
            size--;
            return true;
        }
    }

    public static void main(String[] args) {
        // Create TaskLinkedList
        TaskLinkedList taskList = new TaskLinkedList();

        // Add tasks
        taskList.addTask(new Task(1, "Task 1", "Pending"));
        taskList.addTask(new Task(2, "Task 2", "In Progress"));
        taskList.addTask(new Task(3, "Task 3", "Completed"));

        // Traverse tasks
        System.out.println("All Tasks:");
        taskList.traverseTasks();

        // Search for a task
        System.out.println("\nSearching for TaskID 2:");
        Task task = taskList.searchTask(2);
        if (task != null) {
            System.out.println("Found: " + task);
        } else {
            System.out.println("Task not found.");
        }

        // Delete a task
        System.out.println("\nDeleting TaskID 2:");
        if (taskList.deleteTask(2)) {
            System.out.println("Task deleted.");
        } else {
            System.out.println("Task not found.");
        }

        // Traverse tasks after deletion
        System.out.println("\nAll Tasks after deletion:");
        taskList.traverseTasks();
    }
}

/*
 
 Q1 Explain the different types of linked lists (Singly Linked List, Doubly Linked List).

 Linked lists are a fundamental data structure used for managing collections of elements. 
 They consist of nodes where each node contains a value and a reference (or link) to the next node in the sequence.

 Types of Linked Lists:
 1.Singly Linked List:
     Each node points to the next node.
     Supports traversal in only one direction (forward).

 2.Doubly Linked List:
     Each node has two pointers: one pointing to the next node and one to the previous node.
     Supports traversal in both directions (forward and backward).


*/