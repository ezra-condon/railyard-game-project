public class nQueue extends nLinkedList {
    /*
    nQueue
    This class serves to define a queue of nodes and relevant operations
    Child Class of nLinkedList

    Constructor:
    - Parameters:
       - int max: optional, sets maximum number of nodes the queue can hold
    - headNode: initially set to null
    - size: initially set to -1 (empty)
    - maxSize: set to either -1 (nonexistent) or max parameter

    Attributes: * denotes inherited

    - Node tailNode: holds the last node in the queue.

    *- Node headNode: holds the first node in queue.

    *- int size: number of nodes in queue - 1.

    *- int maxSize: max number of nodes in queue - 1 (-1 if none is set).

    Methods: * denotes inherited

    - Node getHead: returns Node headNode.

    - Node getTail: returns Node tailNode.

    - Boolean addHead(Node newHead): adds provided node to head of queue.
                - If other nodes exist, 
                    - links old head node's frontLinkNode to provided node
                    - links provided node's backLinkNode to old head node.
                    - reassign headNode to provided node
                - if successful (space exists), increments size & returns true
                - if unsuccessful (full), returns false

    - Boolean addTail(Node newTail): adds provided node to tail of queue.
                - If other nodes exist, 
                    - links old tail node's backLinkNode to provided node
                    - links provided node's frontLinkNode to old tail node.
                    - reassign headNode to provided node
                - if successful (space exists), increments size & returns true
                - if unsuccessful (full), returns false

    - Boolean removeHead(): removes node at the head of queue.
                - If other nodes exist, 
                    - sets new head node's frontLinkNode to null
                    - reassign headNode to new head node
                - if successful (nodes exist), decrements size & returns true
                - if unsuccessful (empty), returns false
    
    - Boolean removeTail(): removes node at the tail of queue.
                - If other nodes exist, 
                    - sets new tail node's backLinkNode to null
                    - reassign tailNode to new tail node
                - if successful (nodes exist), decrements size & returns true
                - if unsuccessful (empty), returns false

    *- int getSize: returns number of nodes in queue - 1 (int size)

    *- int getMaxSize: returns max number of nodes in queue -1 (int maxSize; returns -1 if none exists)

    *- Boolean isEmpty: checks if no nodes exist in queue.

    *- Boolean isFull: checks to see if size is at or exceeds maxSize. returns false if maxSize == -1.

     */

    private Node tailNode;

    ////// Constructors //////

    /// forgot if children inherit attribution code from parent 
    /// so i added it to be safe
    /// -ezra

    /// If Max Size is not given:
    public nQueue(){
        this.headNode = null;
        this.tailNode = null; 
        this.size = -1;
        this.maxSize = -1;
    }

    /// If Max Size is not given
    public nQueue(int max){
        this.headNode = null;
        this.tailNode = null;
        this.size = -1;
        this.maxSize = max;
    }

    ////// Get Operations //////
    public Node getHead(){ // returns head node
        return this.headNode;
    }
    public Node getTail(){ //returns tail node
        return this.tailNode;
    }

    ////// Add Operations ////// 
    public Boolean addHead(Node newHead){
        if(this.isFull()==false){
            if(this.size>-1){ // if other nodes exist, link them to added node
                this.headNode.setFrontLinkNode(newHead);
            } else { // if no other nodes exist, make newHead tail as well
                this.tailNode = newHead;
            }

            this.headNode = newHead; //add newHead as head node

            this.size++; //increment size
            return true; //return true if operation is a success
        }
        return false; //return false if operation is failure (full)
    }

    public Boolean addTail(Node newTail){
        if(this.isFull()==false){
            if(this.isEmpty()==false){ // if other nodes exist, link them to added node
                this.tailNode.setBackLinkNode(newTail);
            } else { // if no other nodes exist, make newTail the head node as well
                this.headNode = newTail;
            }

            this.tailNode = newTail; //add newTail as tailNode

            this.size++; //increment size
            return true; //return true if operation is a success (added)
        }
        return false; // return false if operation is failure (full)
    }

    ////// Remove Operations ////// 
    public Boolean removeHead(){
        if(this.isEmpty()==false){

            
            if(this.size>0){ //if another node exists behind head,
                //clear their link
                this.headNode.getBackLinkNode().setFrontLinkNode(null);
                //make new head
                this.headNode = this.headNode.getBackLinkNode();
            }

            this.size--; //decrement size

            //return true if operation is successful
            return true;

        } else {
            //return false if operation is unsuccessful (empty)
            return false;
        }
    }

    public Boolean removeTail(){
        if(this.isEmpty()==false){
            
            if(this.size>0){ //if another node exists in front of tail
                //clear their link
                this.tailNode.getFrontLinkNode().setBackLinkNode(null);
                //make new tail
                this.tailNode = this.tailNode.getFrontLinkNode();
            }

            this.size--; //decrement size

            //return true if operation is successful
            return true;

        } else {
            //return false if operation is unsuccessful (empty)
            return false;
        }
    }
}
