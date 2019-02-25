import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stack {
    private int maxSize;
    private char[] stackArr;
    private int top;

    public Stack(int size){
        this.maxSize = size;
        this.stackArr = new char[size];
        this.top = -1;
    }

    public void push(char i){
        stackArr[++top] = i;
    }

    public char pop(){
        return stackArr[top--];
    }

    public boolean isEmpty(){
        return (top == -1);
    }
}

 class Main{
     public static void main(String[] args) throws IOException {
        Stack st = new Stack(1000);
        String input = getString();
         System.out.println("input string - " + input);
         for (int i = 0; i < input.length(); i++) {
             char ch = input.charAt(i);
             st.push(ch);
         }
         String output = "";
         while (!st.isEmpty()){
             output = output + st.pop();
         }
         System.out.println("reverse string - " + output);
     }

     public static String getString() throws IOException {
         InputStreamReader isr = new InputStreamReader(System.in);
         BufferedReader br = new BufferedReader(isr);

         return br.readLine();
     }
}
