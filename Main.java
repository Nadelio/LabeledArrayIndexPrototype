import java.util.Scanner;

public class Main{
    public static void main(String [] args){
        Tape tape = new Tape();
        tape.addLabel("Label1", 1); // Label1:[1] = 0
        tape.addLabel("Label2", 2); // Label2:[2] = 0
        tape.addLabel("Label3", 3); // Label3:[3] = 0

        tape.tape[1]++; // Label1:[1] = 1
        int label = tape.getLabel("Label1"); // 1
        System.out.println(label); // 1
        tape.setLabel("Label2", 5); // Label2:[2] = 5
        label = tape.getLabel("Label2"); // 5
        System.out.println(label); // 5

        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        String[] tokens = in.split(" ");
        int i = 0;
        while(!tokens[i].equals("^E")){
            switch(tokens[i]){
                case "#":
                    tape.addLabel(tokens[i+1], tape.getPointer());
                    i++;
                    break;
                case "@":
                    tape.setPointer(tape.getLabel(tokens[i+1]));
                    i++;
                    break;
                case "+":
                    tape.tape[tape.getPointer()]++;
                    break;
                case "-":
                    tape.tape[tape.getPointer()]--;
                    break;
                case ">":
                    tape.setPointer(tape.getPointer() + 1);
                    break;
                case "<":
                    tape.setPointer(tape.getPointer() - 1);
                    break;
                case "=":
                    System.out.print("[ ");
                    for(int cell : tape.tape){ System.out.print(cell + " "); }
                    System.out.println("]");
                    System.out.println("Pointer: { Position: " + tape.getPointer() + ", Value: " + tape.getPointerValue() + " }");
                    for(String key : tape.getLabels().keySet()){ System.out.println(key + " : " + tape.getLabel(key)); }
                    break;
                case "^E":
                    break;
            }
            i++;
        }
        sc.close();
    }
}