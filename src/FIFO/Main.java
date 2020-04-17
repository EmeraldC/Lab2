package FIFO;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    private static LinkedList<String> memory = new LinkedList();
    private static String value = "";
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(true){
            System.out.print("FIFO simulation:\n"
                    + "1 - Add new data"
                    + "\n2 - Remove data"
                    + "\n3 - Check memory"
                    + "\n4 - Exit"
                    + "\n\n>");
            value = s.nextLine();
            switch (value) {
                case "1":
                    System.out.print("Enter value: ");
                    value = s.nextLine();
                    memory.addLast(value);
                    System.out.println("\n"+stack());
                    break;
                case "2":
                    if(memory.isEmpty())
                        System.out.println("\nNo data to retrieve.\n");
                    else
                        System.out.println("\nRetrieved: \""+memory.removeFirst()+"\"\n\n"+stack());
                    break;
                case "3":
                    System.out.println(stack());
                    break;
                case "4":
                    System.exit(0);
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }
    public static String stack(){
        String out = "";
        for(int i=memory.size()-1;i>=0;i--)
            out+="\t"+memory.get(i)+"\n";
        return "Memory:\n"+out+"\n";
    }
}
