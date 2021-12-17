# Big O Notation Complexity:
```
|---------------------------------------------------|
|Notation          |          Complexity            |
|---------------------------------------------------|
|O(1)              |          Constant              |
|O(log(n))         |          Logarithmic           |
|O(n)              |          Linear                |
|O(n*log(n))       |          n * log(n)            | 
|O(n²)             |          Quadratic             |
|O(n3)             |          Cubic                 |
|O(2n)             |          Exponential           |
|O(n!)             |          Factorial             |
|---------------------------------------------------|
```

# Big O Notation for Data Structures:
```
|--------------------------------------------------------------------------------------|
|Data Structure    |          Average cases            |          Worst cases          |
|--------------------------------------------------------------------------------------|
|                  |  Insert     Delete      Search    | Insert      Delete      Search|
|--------------------------------------------------------------------------------------|
|Array/stack/queue |  O(1)        O(1)        O(n)     |   O(1)        O(1)        O(n)|               
|Linked list       |  O(1)        O(1)        O(n)     |   O(1)        O(1)        O(n)|
|Doubly linked list|  O(1)        O(1)        O(n)     |   O(1)        O(1)        O(n)|
|Hash table        |  O(1)        O(1)        O(1)     |   O(n)        O(n)        O(n)|
|Binary search tree|  O(log(n))   O(log(n))   O(log(n))|   O(n)        O(n)        O(n)|
|--------------------------------------------------------------------------------------|
```

# Big O Notation for Sorting Algorithms:
```
|--------------------------------------------------------------------------------------|
|Algorithm         |       Best cases    |    Average cases    |    Worst cases        |
|--------------------------------------------------------------------------------------|
|Bubble sort       |         O(n)        |         O(n²)       |        O(n²)          |
|Insertion sort    |         O(n)        |         O(n²)       |        O(n²)          |
|Selection sort    |         O(n²)       |         O(n²)       |        O(n²)          |
|Quick sort        |         O(n*log(n)) |         O(n*log(n)) |        O(n²)          |
|Merge sort        |         O(n*log(n)) |         O(n*log(n)) |        O(n*log(n))    |
|Heap sort         |         O(n*log(n)) |         O(n*log(n)) |        O(n*log(n))    |
|--------------------------------------------------------------------------------------|
```
# Trees and Graphs Traversal Algorithms:
# Breadth-first search:
BFS is a vertex based technique for finding a shortest path in graph. It uses a Queue data structure which follows first in first out. In BFS, one vertex is selected at a time when it is visited and marked then its adjacent are visited and stored in the queue. It is slower than DFS.
```
        A
       / \
      B   C
     /   / \
    D   E   F
 
Output is: A, B, C, D, E, F
```

# Depth-first search:
DFS is a edge based technique. It uses Stack data structure, performs two stages, first visited vertices are pushed into stack and second if theres is no vertices then visited vertices are popped.
```
        A
       / \
      B   C
     /   / \
    D   E   F
 
Output is: A, B, D, C, E, F
```

# BFS vs DFS
```
BFS	                                                        DFS
1.	BFS stands for Breadth First Search.	                DFS stands for Depth First Search.

2.	BFS(Breadth First Search) uses Queue 

        data structure for finding the shortest path.	        DFS(Depth First Search) uses Stack data structure.
3.	BFS can be used to find single source shortest
        path in an unweighted graph, because in BFS, 
        we reach a vertex with minimum number of edges 
        from a source vertex.	
                                        
3.	BFS is more suitable for searching vertices which       In DFS, we might traverse through more edges to reach 
        are closer to the given source.	                        a destination vertex from a source. DFS is more suitable
                                                                when there are solutions away from source.
        
4.	BFS considers all neighbors first and therefore         DFS is more suitable for game or puzzle problems. We make a decision, 
        not suitable for decision making trees used in          then explore all paths through this decision. And if this decision
        games or puzzles.	                                leads to win situation, we stop.
                                                                 
5.	The Time complexity of BFS is O(V + E) when             The Time complexity of DFS is also O(V + E) when Adjacency List is used and 
        Adjacency List is used and O(V^2) when Adjacency        O(V^2) when Adjacency Matrix is used, where V stands for vertice
        Matrix is used, where V stands for vertices and E       s and E stands for edges.
        stands for edges.	       
        
6.	Here, siblings are visited before the children	        Here, children are visited before the siblings
```
