
class Link{
    public String name;
    public int age;

    public Link next;
    public Link prev;

    public Link(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void display(){
        System.out.println("Name: "+this.name+", age: "+this.age);
    }
}

class LinkedList {
    public Link first;
    public Link last;

    public LinkedList(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void insertLeft(String name, int age){
        Link newLink = new Link(name, age);
        if (this.isEmpty()){
            first = newLink;
            last = newLink;
        }else {
            newLink.next = first;
            first.prev = newLink;
            first = newLink;
        }
    }

    public void insertRight(String name,int age){
        Link newLink = new Link(name, age);
        if (this.isEmpty()){
            first = newLink;
            last = newLink;
        }else {
            newLink.prev = last;
            last.next = newLink;
            last = newLink;
        }
    }

    public String deleteLeft(){
        Link temp = first;
        if (first.next == null) {
            last = null;
            first = null;
        }else {
            first = first.next;
            first.prev = null;
        }
        return temp.name;
    }

    public String deleteRight(){
        Link temp = first;
        if (last.prev == null) {
            last = null;
            first = null;
        }else {
            last = last.prev;
            last.next = null;
        }
        return temp.name;
    }

    public void display(){
        Link current = first;
        while(current != null){
            current.display();
            current = current.next;
        }
    }

    public void displayReverse(){
        Link current = last;
        while(current != null){
            current.display();
            current = current.prev;
        }
    }
}

public class DubleLinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertLeft("Dutch",76);
        linkedList.insertLeft("Devil",666);
        linkedList.insertRight("GOD",999);
        linkedList.insertRight("DAMN", 12334);
        linkedList.insertLeft("PLAAAN",321);

        linkedList.display();
        System.out.println("\n \n  FAITH,GOD DAMN FAITH ARTHUR \n \n");
        linkedList.displayReverse();

        linkedList.deleteLeft();
        linkedList.deleteLeft();
        linkedList.deleteRight();

        System.out.println();

        linkedList.display();
        System.out.println("\n \n WE NEED MUNHEY \n \n");
        linkedList.displayReverse();
    }
}

