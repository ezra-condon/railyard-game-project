public class nLinkedList {
    /*
    nLinkedList
    This base class serves to be extended to nStack and nQueue.

    Constructor:
    - Parameters:
       - int max: optional, sets maximum number of nodes the list can hold
    - headNode: initially set to null
    - size: initially set to -1 (empty)
    - maxSize: set to either -1 (nonexistent) or max parameter

    Attributes: 
    - Node headNode: holds the first node in list

    - int size: number of nodes in list - 1

    - int maxSize: max number of nodes in list - 1 (-1 if none is set)

    Methods:

    - int getSize: returns number of nodes in list - 1 (int size)

    - int getMaxSize: returns max number of nodes in list -1 (int maxSize; returns -1 if none exists)

    - Boolean isEmpty: checks if no nodes exist in list.

    - Boolean isFull: checks to see if size is at or exceeds maxSize. returns false if maxSize == -1.
    */

    protected Node headNode;
    protected int size;
    protected int maxSize;
    
    ////// Constructors //////
    /// If Max Size is not given:
    public nLinkedList(){
        this.headNode = null;
        this.size = -1;
        this.maxSize = -1;
    }

    /// If Max Size is not given
    public nLinkedList(int max){
        this.headNode = null;
        this.size = -1;
        this.maxSize = max;
    }

    ////// Get Operations ////// 
    public int getSize(){ //returns size 
        return this.size;
    }
    public int getMaxSize(){ // returns max size
        return (this.maxSize);
    }

    ////// Check Operations ////// 
    public Boolean isEmpty(){
        if(this.size==-1){
            return true;
        }
        return false;
    }
    public Boolean isFull(){
        if((this.size >= maxSize) && (this.size != -1)){
            return true;
        } 
        return false;
    }

}