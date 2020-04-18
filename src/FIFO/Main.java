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
            if(index>2) //Frame size is 3
                index=0;
            try{
                for(int i=0;i<memory.size();i++)
                    //Checks if the value already exists in memory
                    if(value.equals(memory.get(i))){
                        System.out.println("\n"+frame());
                        continue main; //Skips if the value exists
                    }
                memory.set(index, value); //Replaces the value in the frame
                index++;
            }catch(IndexOutOfBoundsException e){
                //Error handling: Adds new value if no value exists in the frame
                memory.add(index, value);
                index++;
            }
            System.out.println("\n"+frame());
        }
    }
    public static String frame(){ //Displays the page frames
        String out = "";
        for(int i=0;i<memory.size();i++)
            out+="\t"+memory.get(i)+"\n";
        return "Page frames:\n"+out+"\n";
    }
}
