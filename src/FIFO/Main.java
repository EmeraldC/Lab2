package FIFO;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    private static LinkedList<String> memory = new LinkedList();
    private static String value = "";
    private static int index = 0;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        main: while(true){
            System.out.print("FIFO simulation\n"
                    + "Enter a string: ");
            value = s.nextLine();
            if(index>2)
                index=0;
            try{
                for(int i=0;i<memory.size();i++)
                    if(value.equals(memory.get(i))){
                        System.out.println("\n"+frame());
                        continue main;
                    }
                memory.set(index, value);
                index++;
            }catch(IndexOutOfBoundsException e){
                memory.add(index, value);
                index++;
            }
            System.out.println("\n"+frame());
        }
    }
    public static String frame(){
        String out = "";
        for(int i=0;i<memory.size();i++)
            out+="\t"+memory.get(i)+"\n";
        return "Page frames:\n"+out+"\n";
    }
}
