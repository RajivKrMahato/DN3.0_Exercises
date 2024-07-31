public class TaskManagementSystem {
    private Node head; 

    private class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

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
    }

    public Task searchTask(String taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public void deleteTask(String taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        if (head.task.getTaskId().equals(taskId)) {
            head = head.next; 
            return;
        }

        Node current = head;
        while (current.next != null && !current.next.task.getTaskId().equals(taskId)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        } else {
            System.out.println("Task with ID " + taskId + " not found.");
        }
    }

    public static void main(String[] args) {
        TaskManagementSystem tms = new TaskManagementSystem();

        tms.addTask(new Task("T101", "Prepare Presentation", "Pending"));
        tms.addTask(new Task("T102", "Review Code", "In Progress"));
        tms.addTask(new Task("T103", "Submit Report", "Completed"));

        System.out.println("List of all tasks:");
        tms.traverseTasks();

        System.out.println("\nSearching for task with ID T102:");
        Task foundTask = tms.searchTask("T102");
        System.out.println(foundTask);

        System.out.println("\nRemoving task with ID T102:");
        tms.deleteTask("T102");

        System.out.println("\nTasks list after removal:");
        tms.traverseTasks();
    }
}

