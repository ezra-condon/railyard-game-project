# Railyard Game
Produced for CSCI 230-1 Spring '25; Dr. Wang
*by Cecil Favero, Nyree Hamrick, Ezra Condon*

Players operate a classification yard, receiving Cars from the Stack to sort into [x] Trains. Once the Train has [y] cars, it is shipped off and the player is awarded points based on how many share a destination. 

Classes / Data Structures: 

Linked List / “Trains”: Linked trains to be cleared once full / once the stack is empty.   
    Parameters:  
      - head (Node)  
      - tail (Node)  
    Operations:  
      -  

Stack: Collection of cars to be sorted by player   
    Parameters:  
      -  
    Operations:  
      - Pop: Pops the active car into the slot for the player to sort.  
      - Peek: player peeks at the following car’s destination  

Node / “Cars”: Nodes placed into trains by the player  
    Parameters:  
      - Key (int):   
      - Destination (string; alternatively, an int that references an array of possible  destinations)  
      - frontLink (Node)  
      - backLink (Node)  
    Operations:  
      -  
