package com.company;

public class Main {

    public static void main(String[] args) {
        int base = 4;
        int power = 6;
        System.out.println("Base = " + base + ", power = " + power);
        System.out.println("My method - " + power(base,power) + "\nJava Math method - " + Math.round(Math.pow(base,power)));
    }

    public static long power(long i,int p){
        if (p == 1){
            return i;
        }
        long tmp = 1;
        tmp = (p%2 != 0) ? i : 1;
        long result = power(i, p / 2);
        return result * result * tmp;


    }
}
