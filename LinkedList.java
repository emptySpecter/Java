import java.util.Iterator;

abstract class Link{
    public Link next;
    public abstract void display();
}

public class LinkedList<T extends Link> implements Iterable<T>{
    private Link first;

    public LinkedList(){
        first = null;

    }

    public Link getFirst() {
        return first;
    }

    public void setFirst(Link first) {
        this.first = first;
    }

    public LinkIterator<T> getIterator(){
        return new LinkIterator<T>(this);
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void display(){
        Link current = first;
        while(current != null){
            current.display();
            current = current.next;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return getIterator();
    }
}

class LinkIterator<T extends Link> implements Iterator<T>{
    private Link current;
    private Link previous;
    private LinkedList list;

    public LinkIterator(LinkedList list){
        this.list = list;
        this.reset();
    }

    public void reset(){
        current = list.getFirst();
        previous = null;
    }

    public boolean atEnd(){
        return (current.next == null);
    }

    public Object nextLink(){
        previous = current;
        current = current.next;
        return current;
    }

    public Link getCurrent(){
        return current;
    }

    public void insertAfter(T newLink){
        if (list.isEmpty()){
            list.setFirst(newLink);
            current = newLink;
        } else {
            newLink.next = current.next;
            current.next = newLink;
            nextLink();
        }
    }

    public void insertBefore(T newLink){
        if(previous == null){
            newLink.next = list.getFirst();
            list.setFirst(newLink);
            reset();
        }
        else{
            newLink.next = previous.next;
            previous.next = newLink;
            current = newLink;
        }
    }

    public T deleteCurrent(){
        T temp = (T)current;
        if (previous == null){
            list.setFirst(current.next);
            reset();
        } else {
            previous.next = current.next;
            if (atEnd()){
                reset();
            } else {
                current = current.next;
            }
        }
        return temp;
    }

    @Override
    public boolean hasNext() {
        return (current != null);
    }

    @Override
    public T next() {
        nextLink();
        return (T)previous;
    }
}

class Person extends Link{
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void display() {
        System.out.println("Name: " + this.name + ", age: " + this.age);
    }
}

 class LinkIteratorApp {

    public static void main(String[] args) {

        LinkedList<Person> list = new LinkedList<>();
        LinkIterator<Person> itr = new LinkIterator<>(list);

        itr.insertAfter(new Person("Artem", 20));
        itr.insertBefore(new Person("Sergey", 10));
        itr.insertAfter(new Person("Dutch with Great plan again", 1234));
        itr.insertAfter(new Person("John Martson", 1234));
        itr.insertAfter(new Person("Arthur Morgan", 34));
        itr.insertAfter(new Person("LEEEEEEEENNNNNNNNYYYYYYY", 12));
        itr.insertAfter(new Person("DIO BRANDO", 237));


        list.display();

        System.out.print("\n--------------------------------\n");

        for (Person p: list) {
            p.display();
        }

        itr.reset();
        itr.next();
        itr.next();
        System.out.println("\nitr current person:");
        itr.getCurrent().display();

        LinkIterator<Person> itr1 = new LinkIterator<>(list);
        itr1.reset();
        itr1.next();
        itr1.next();
        itr1.next();
        System.out.println("\nitr current person:");
        itr1.getCurrent().display();

        itr1.deleteCurrent();
        Person per = itr.deleteCurrent();
        System.out.println("\n \nadding Person with name Polnareff");
        itr1.insertBefore(new Person("Polnoreff",4234));
        System.out.println("------------------------------");
        list.display();
        System.out.println("\nWhere is DAMN \"Polnoreff\" ??????????????????????????????????????????????????????????????!");
    }

}
