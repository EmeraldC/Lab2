package FIFO;

import java.util.Scanner;

public class Main {
    private static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("FIFO simulation\nNumber of frames: ");
        String[] memory = new String[Integer.parseInt(s.nextLine())];
        System.out.print("Number of pages: ");
        page(memory, Integer.parseInt(s.nextLine()));
    }
    
    public static void page(String[] memory, int pagenum){
        int index = 0; String value;
  main: for(int i=0;i<pagenum;i++){
            System.out.print("\nEnter a String: ");
            value = s.nextLine();
            if(index>=memory.length)
                index=0;
            for(int j=0;j<memory.length;j++)
                //Checks if the value already exists in memory
                if(value.equals(memory[j])){
                    System.out.println("\n"+frameDisp(memory));
                    continue main; //Skips if the value exists
                }
            memory[index]=value; //Replaces the value in the frame
            index++;
            System.out.println("\n"+frameDisp(memory));
        }
    }
    
    public static String frameDisp(String[] memory){ //Displays the page frames
        String out = "";
        for(int i=0;i<memory.length;i++)
            out+="\t"+memory[i]+"\n";
        return "Page frames:\n"+out+"\n";
    }
}
