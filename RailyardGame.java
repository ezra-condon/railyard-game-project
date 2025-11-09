public class RailyardGame {
    //This class serves to act as the game object, initiated by the main method.

    //array of destination strings to be referenced by each node.
    public static String[] destinations = {"Nanning","Kowloon","Xiamen","Changsha","Nanchang"};
    
    //stack storing all cars to be sorted by player
    public nLinkedList stack = new nLinkedList();

    //Spot where nodes popped from stack to be stored
    public static Node sortNode = null; 

    //Tracks for sorted cars by player
    public nLinkedList track1 = new nLinkedList();
    public nLinkedList track2 = new nLinkedList();
    public nLinkedList track3 = new nLinkedList();

    

}
