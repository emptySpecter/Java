import java.util.LinkedList;

public class LinkedHashTableImpl implements HashTable {

    public static final Integer INVALID_COST = null;

    private class Entry {

        private Item key;
        private int value;

        public Entry(Item key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            return ((Entry) obj).key.equals(this.key);
        }
    }

    class EntryLinkedList extends LinkedList<Entry> {
    }

    private EntryLinkedList[] data;
    private int size;


    public LinkedHashTableImpl(int maxSize) {
        this.data = new EntryLinkedList[maxSize];
    }

    private int hashFunc(int key) {
        return key % data.length;
    }

    @Override
    public boolean put(Item item, Integer cost) {
        int index = hashFunc(item.hashCode());
        if (data[index] == null) data[index] = new EntryLinkedList();
        int idx = data[index].indexOf(new Entry(item, 0));
        if (idx == -1) {
            data[index].add(new Entry(item, cost));
            size++;
        } else {
            data[index].get(idx).value = cost;
        }
        return true;
    }

    @Override
    public Integer get(Item item) {
        int index = hashFunc(item.hashCode());
        if (data[index] == null) return INVALID_COST;
        int idx = data[index].indexOf(new Entry(item, 0));
        if (idx == -1) return INVALID_COST;
        return data[index].get(idx).value;
    }


    @Override
    public boolean remove(Item item) {
        int index = hashFunc(item.hashCode());
        if (data[index] == null) return false;
        int idx = data[index].indexOf(new Entry(item, 0));
        if (idx == -1) return false;
        data[index].remove(idx);
        size--;
        return true;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println("-----------");
        for (int index = 0; index < data.length; index++) {
            System.out.println(String.format("HashTable[%d] = %s", index, data[index]));
        }
        System.out.println("-----------");
    }

}