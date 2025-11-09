public class nStack extends nLinkedList {
    /*
    nStack
    This class serves to define a stack of nodes and relevant operations
    Child Class of nLinkedList

    Constructor:
    - Parameters:
       - int max: optional, sets maximum number of nodes the stack can hold
    - headNode: initially set to null
    - size: initially set to -1 (empty)
    - maxSize: set to either -1 (nonexistent) or max parameter

    Attributes: * denotes inherited

    *- Node headNode: holds the first node in stack

    *- int size: number of nodes in stack - 1

    *- int maxSize: max number of nodes in stack - 1 (-1 if none is set)

    Methods: * denotes inherited

    - Node pop: returns headNode of stack, and removes head node.
                - if following nodes exist, sets their head node to null.
                - sets new head node
                - if the stack is empty, returns null. else, decrements size.

    - Boolean push(Node newHead): Pushes a new node to top of stack.
                - If the operation is successful (space exists), increments size & returns true
                - If operation is unsuccessful (full), returns false
    
    - Node peek: returns headNode of stack, does not remove head node.
                - if the stack is empty, returns null. else, increments size.

    *- int getSize: returns number of nodes in stack - 1 (int size)

    *- int getMaxSize: returns max number of nodes in stack -1 (int maxSize; returns -1 if none exists)

    *- Boolean isEmpty: checks if no nodes exist in stack.

    *- Boolean isFull: checks to see if size is at or exceeds maxSize. returns false if maxSize == -1.

     */


    ////// Constructors //////
    /// If Max Size is not given:
    public nStack(){
        this.headNode = null;
        this.size = -1;
        this.maxSize = -1;
    }

    /// If Max Size is not given
    public nStack(int max){
        this.headNode = null;
        this.size = -1;
        this.maxSize = max;
    }

    ////// Stack Operations //////
    
    public Node pop(){ //if not empty,
        if(this.isEmpty()==false){
            //save first node as return node
            Node returnNode = this.headNode;
            //decrement size
            this.size--; 

            if(this.isEmpty() == false){ //if still not empty,
                //returnNode's back link (second node from head) 
                // has its front link set to null
                returnNode.getBackLinkNode().setFrontLinkNode(null);
                //new head node assigned to next node
                this.headNode = returnNode.getBackLinkNode();
            }

            return returnNode; //return returnNode
        }
        return null; // return null if no nodes exist (empty)
    }

    public Boolean push(Node newHead){ // if not full,
        if(this.isFull()==false){ 
            //front link of head node is set to new head
            //back link of new head is set to old head
            this.headNode.setFrontLinkNode(newHead);
            newHead.setBackLinkNode(this.headNode);
            this.headNode = newHead;
            this.size++; //size incremented
            return true; //return true if successful (space exists)
        }
        return false; //return false if failed (full)
    }

    public Node peek(){ // returns head node
        return this.headNode;
    }
}