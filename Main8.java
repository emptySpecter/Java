import java.util.HashMap;
import java.util.Map;

public class Main8 {

    public static void main(String[] args) {

        HashTable hashTable = new LinkedHashTableImpl(5);
        hashTable.put(new Item(1, "Orange"), 150);
        hashTable.put(new Item(77, "Banana"), 100);
        hashTable.put(new Item(62, "Lemon"), 250);
        hashTable.put(new Item(21, "Potato"), 67);
        hashTable.put(new Item(55, "Milk"), 120);

        hashTable.put(new Item(21, "Potato"), 500);
        System.out.println("Cost of Potato is= " + hashTable.get(new Item(21, "Potato")));

        System.out.println("Size is " + hashTable.getSize());
        hashTable.display();

        System.out.println("Cost of Banana is " + hashTable.get(new Item(77, "Banana")));
        hashTable.remove(new Item(77, "Banana"));
        System.out.println("Cost of Banana is " + hashTable.get(new Item(77, "Banana")));

        System.out.println("Size is " + hashTable.getSize());
        hashTable.display();
    }
}