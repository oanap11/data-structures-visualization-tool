package dsa;

public class SinglyLinkedList {

    public Node first;
    public Node last;

    public SinglyLinkedList() {
        first = last = null;
    }

    //insereaza un element in lista
    public void insertElement(int data) {
        Node elementNou = new Node(data); //se initializeaza un nod

        //daca nu exista elemente in lista (first este null),
        //nodul initializat este primul elem introdus in lista
        if(first == null){
        	elementNou.next = null;
            first = elementNou;
            last = elementNou;
        }
        //daca exista elemente in lista, elementul curent este adaugat dupa ultimul nod
        //si devine ultimul nod
        else {
        	elementNou.next = null;
            last.next = elementNou;
            last = elementNou;
        }
    }

    //sterge un element din lista
    public Node deleteElement(int data){
        Node tmp  = first;
        Node prev = first;

        while(tmp != null){
            if(tmp.data == data){
                if(tmp == first){
                    if(tmp == last){
                        first = last = null;
                    }
                    else{
                        first = tmp.next;
                    }
                 }
                else if(tmp == last) {
                    prev.next = tmp.next;
                    last = prev;
                }
                else {
                    prev.next = tmp.next;
                }
                return tmp;
            }

            prev = tmp;
            tmp = tmp.next;
        }
        return null;
    }

    public Boolean isEmpty(){
        return first == null;
    }

}
