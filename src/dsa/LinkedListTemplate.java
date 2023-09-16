package dsa;

public class LinkedListTemplate {

    public Node firstNode;
    public Node lastNode;

    public LinkedListTemplate() {
        firstNode = lastNode = null;
    }

    public void insertElement(int data) {
        Node newNode = new Node(data); 

        if(firstNode == null){
            firstNode = newNode;
            lastNode = newNode;
        } else { // list is not empty, so:
        	lastNode.next = newNode; // append the new node to the end of the list
            lastNode = newNode; // update the lastNode reference to the new node
        }
    }

    public Node deleteElement(int dataToDelete){

        Node tempNode = firstNode;
        Node prevNode = null;

        while (tempNode != null) {
            if (tempNode.data == dataToDelete) {
                if (prevNode == null) { // If it's the first node
                    firstNode = tempNode.next;
                    if (tempNode == lastNode) {
                        lastNode = null; // Adjust lastNode if necessary
                    }
                } else {
                    prevNode.next = tempNode.next;
                    if (tempNode == lastNode) {
                        lastNode = prevNode; // Adjust lastNode if necessary
                    }
                }
                return tempNode;
            }
            prevNode = tempNode;
            tempNode = tempNode.next;
        }
        
        return null; // Element not found      
    }

    public Boolean isEmpty(){
        return firstNode == null;
    }

}
