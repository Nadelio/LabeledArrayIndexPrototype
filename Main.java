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
    }
}