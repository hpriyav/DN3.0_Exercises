public class TaskManagementSystem {

        static class Task {
        private String taskId;
        private String taskName;
        private String status;

        public Task(String taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
        }

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        public String getTaskName() {
            return taskName;
        }

        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "Task ID: " + taskId + ", Name: " + taskName + ", Status: " + status;
        }
    }

    
    static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }
    static class TaskLinkedList {
        private Node head;

        public TaskLinkedList() {
            this.head = null;
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

        
        public Task searchTaskById(String taskId) {
            Node current = head;
            while (current != null) {
                if (current.task.getTaskId().equals(taskId)) {
                    return current.task;
                }
                current = current.next;
            }
            return null; // Not found
        }

        
        public void traverseTasks() {
            Node current = head;
            while (current != null) {
                System.out.println(current.task);
                current = current.next;
            }
        }

     
        public boolean deleteTaskById(String taskId) {
            if (head == null) {
                return false; // List is empty
            }
            if (head.task.getTaskId().equals(taskId)) {
                head = head.next; // Remove the head node
                return true;
            }
            Node current = head;
            while (current.next != null && !current.next.task.getTaskId().equals(taskId)) {
                current = current.next;
            }
            if (current.next != null) {
                current.next = current.next.next; // Remove the node
                return true;
            }
            return false; 
        }
    }

    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        
        taskList.addTask(new Task("T001", "Complete Assignment", "Pending"));
        taskList.addTask(new Task("T002", "Review Code", "In Progress"));
        taskList.addTask(new Task("T003", "Prepare Presentation", "Completed"));

        
        System.out.println("All Tasks:");
        taskList.traverseTasks();

       
        System.out.println("\nSearch Result:");
        Task searchResult = taskList.searchTaskById("T002");
        if (searchResult != null) {
            System.out.println("Found: " + searchResult);
        } else {
            System.out.println("Task not found.");
        }

        
        System.out.println("\nDeleting Task T002:");
        boolean deleted = taskList.deleteTaskById("T002");
        if (deleted) {
            System.out.println("Task T002 deleted.");
        } else {
            System.out.println("Task T002 not found.");
        }

        
        System.out.println("\nAll Tasks After Deletion:");
        taskList.traverseTasks();
    }
}