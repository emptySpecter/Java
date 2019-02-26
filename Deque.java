public class Deque {
    private int maxSize;
    private int[] deque;
    private int front;
    private int rear;
    private int items;

    public Deque(int s){
        maxSize = s;
        deque = new int[maxSize];
        front = 0;
        rear = -1;
        items = 0;
    }

    public void insertRight(int i){
        if(rear == maxSize-1) rear = -1;
        deque[++rear] = i;
        items++;
    }

    public void insertLeft(int i){
        if(front == 0) front = maxSize;
        deque[--front] = i;
        items++;
    }

    public int removeRight(){
        int temp = deque[rear--];
        if(rear == -1) rear = maxSize-1;
        items--;
        return temp;
    }

    public int removeLeft(){
        int temp = deque[front++];
        if(front == maxSize) front = 0;
        items--;
        return temp;
    }

    public int peekLeft(){
        return deque[front];
    }

    public int peekRight(){
        return deque[rear];
    }

    public boolean isEmpty(){
        return (items==0);
    }

    public boolean isFull(){
        return (items==maxSize);
    }

    public int size(){
        return items;
    }
}


 class Main{
    public static void main(String[] args){
        Deque q = new Deque(5);
        q.insertLeft(10);
        q.insertRight(20);
        q.insertLeft(30);
        q.insertLeft(40);
        q.insertRight(50);
        int size = q.size();
        for (int i = 0; i < size; i++) {
            System.out.println(q.removeLeft());
        }

//        q.insert(50);
//        q.insert(60);
//        q.insert(70);
//        q.insert(80);
//        while( !q.isEmpty() ){
//            int n = q.remove();
//            System.out.println(n);
//
//        }
    }
}
