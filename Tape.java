import java.util.HashMap;

/**
 * A class that holds a 100 element tape with label references that can be used to quickly find data
 * as well as a series of methods to manipulate the labels and gather data from the labels.
 */
public class Tape {
    /**
     * The tape that the program will use to store data.
     */
    public int[] tape = new int[100];

    /**
     * A HashMap that stores the labels and their positions in the tape.
     */
    private HashMap<String, Integer> labels = new HashMap<String, Integer>();

    /**
     * The pointer that the program will use to access the tape.<br></br>
     * { position, value }
     */
    private static int[] pointer = new int[]{ 0, 0 }; // position, value

    /**
     * Initializes the tape with zeros.
     */
    public void initializeTape() {
        for(int i = 0; i < tape.length; i++) {
            tape[i] = 0;
        }
    }

    public Tape(){
        initializeTape();
    }

    /**
     * Adds a label to the tape.
     * @param label The label to add.
     * @param position The position in the tape where the label will reference.
     */
    public void addLabel(String label, int position){ labels.put(label, position); }

    /**
     * Gets the value of an existing label.
     * @param label of a tape index
     * @return The value of the label as an int.
     */
    public int getLabel(String label){ return tape[labels.get(label)]; }

    /**
     * Sets the value of an existing label.
     * @param label of a tape index
     * @param value The value to set the label to.
     */
    public void setLabel(String label, int value){ tape[labels.get(label)] = value; }

    /**
     * @param label of a tape index
     * @return The index of the label
     */
    public int getLabelIndex(String label){ return labels.get(label); }

    /**
     * @param index of the tape
     * @return The label of the index, returns null if the label does not exist
     */
    public String getLabelFromIndex(int index) {
        for(String label : labels.keySet()) {
            if(labels.get(label) == index) {
                return label;
            }
        }
        return null;
    }

    /**
     * @return The current pointer position.
     */
    public int getPointer(){ return pointer[0]; }
    
    /**
     * Sets the pointer to a new position and updates the value of the pointer.
     * @param destination The position to move the pointer to.
     */
    public void setPointer(int destination){
        pointer[0] = destination;
        pointer[1] = tape[destination];
    }

    /**
     * @return The value of the pointer.
     */
    public int getPointerValue(){ return pointer[1]; }

    public HashMap<String, Integer> getLabels() {
        return labels;
    }
}
