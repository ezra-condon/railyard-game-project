public class Node {
    /*
    This class serves to hold values for the game.

    Attributes: 
    - int destination: holds the destination value of car
        -references positions in RailyardGame.destinations[]

    - Node frontLinkNode: refers to node connected at the object's head in a list

    - Node backLinkNode: refers to node connected at the object's tail in list

    Methods:
    - int getDestination: returns int destination value as int

    - String getDestinationString: returns int destination as String
        - by referencing RailyardGame.destinations with destination as index

    - Node getFrontLinkNode: returns Node frontLinkNode

    - Node getBackLinkNode: returns Node backLinkNode

    - Boolean setFrontLinkNode: sets frontLinkNode to provided node.
        - returns true if successful
        - no failure state exists yet 

    - Boolean setBackLinkNode: sets backLinkNode to provided node
        - return true if successful
        - no failure state exists yet

    */



    //references array of strings RailyardGame.destinations.
    private final int destination; 
    private Node frontLinkNode;
    private Node backLinkNode;

    //possible implementation later that could be fun but is unimportant:
    //private String good; a string for what car contains.

    ////// Constructor ////// 
    public Node(int destination){ 
        this.destination = destination;
        this.frontLinkNode = null;
        this.backLinkNode = null;
    }

    ////// Destination Operations ////// 
    public int getDestination(){ //returns destination integer
        return destination;
    }

    public String getDestinationString(){ //returns the destination string
        return RailyardGame.destinations[this.destination];
    }


    ////// Link Operations ////// 
    public Node getFrontLinkNode() { //returns the front link node
        return this.frontLinkNode;
    }

    public Node getBackLinkNode() { //returns back link node
        return this.backLinkNode;
    }

    public Boolean setFrontLinkNode(Node front) { //sets frontLinkNode to provided node.
        this.frontLinkNode = front;
        return true;
    }

    public Boolean setBackLinkNode(Node back) { //sets backLinkNode to provided node.
        this.backLinkNode = back;
        return true;
    }

    
    /* ////// ////// Goods Operations ////// ////// possible implement later. not necessary
     * public String getGoods(){
     *  return this.goods;
     * }
     * 
    */

}
