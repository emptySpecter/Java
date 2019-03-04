    import java.util.Arrays;

    public class Backpack {
    int volume;
    Item[] items;

    int maxValue;
    int[] maxSet;
    int[] currentSet;

    public Backpack(int volume, Item[] items){
        this.volume = volume;
        this.items = items;
        maxValue = 0;
        maxSet = new int[items.length];
        currentSet = new int[items.length];
    }

    static class Item{
        int id;
        String name;
        int weight;
        int value;

        public Item(int id, String name, int weight, int value) {
            this.id = id;
            this.name = name;
            this.weight = weight;
            this.value = value;
        }
    }

    void packing(int pos, int volume){
        currentSet[pos] = 1;
        int value = 0;

        for (int i = 0; i < currentSet.length; i++) {
            if (currentSet[i] != 0){
                value += items[i].value;
            }
        }

        int newVolume = volume-items[pos].weight;

        if (value > maxValue && newVolume >= 0){
            maxValue = value;
            for (int i = 0; i < currentSet.length; i++) {
                maxSet[i] = currentSet[i];
            }
        }

        if (pos+1 < items.length && newVolume >= 0){
            packing(pos+1,newVolume);
        }

        currentSet[pos] = 0;
        if (pos+1 < items.length){
            packing(pos+1,volume);

        }
      }
    public static void main(String[] args) {
        Item[] items = new Item[6];
        int packVolume = 15;//kg
        items[0] = new Item(0,"Book",1,600);
        items[1] = new Item(1,"Glass",2,5000);
        items[2] = new Item(2,"Aid kit",4,1500);
        items[3] = new Item(3,"Notebook ",2,40000);
        items[4] = new Item(4,"Kettle hat",1,500);
        items[5] = new Item(5,"Car ",10,75000);
        Backpack pack = new Backpack(15,items);
        pack.packing(0,packVolume);
        System.out.println("Max value - " + pack.maxValue);
        for (int i = 0; i < pack.maxSet.length; i++) {
            if (pack.maxSet[i] != 0){
                System.out.print(i + " ");
                }
            }
        }
    }

