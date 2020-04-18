package FIFO;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    private static String[] memory;
    private static String value = "";
    private static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int framenum, pagenum;
        System.out.print("FIFO simulation\nNumber of frames: ");
        memory = new String[Integer.parseInt(s.nextLine())];
        System.out.print("Number of pages: ");
        pagenum = Integer.parseInt(s.nextLine());
        page(memory, pagenum);
    }
    
    public static void page(String[] memory, int pagenum){
        int index = 0;
  main: for(int i=0;i<pagenum;i++){
            System.out.print("\nEnter a String: ");
            value = s.nextLine();
            if(index>=memory.length)
                index=0;
            for(int j=0;j<memory.length-2;j++)
                //Checks if the value already exists in memory
                if(value.equals(memory[j])){
                    System.out.println("\n"+frameDisp());
                    continue main; //Skips if the value exists
                }
            memory[index]=value; //Replaces the value in the frame
            index++;
            System.out.println("\n"+frameDisp());
        }
    }
    
    public static String frameDisp(){ //Displays the page frames
        String out = "";
        for(int i=0;i<memory.length;i++)
            out+="\t"+memory[i]+"\n";
        return "Page frames:\n"+out+"\n";
    }
}
