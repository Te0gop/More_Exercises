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
# Breadth-first Search:
BFS is a vertex based technique for finding a shortest path in graph. It uses a Queue data structure which follows first in first out. In BFS, one vertex is selected at a time when it is visited and marked then its adjacent are visited and stored in the queue. It is slower than DFS.
```
        A
       / \
      B   C
     /   / \
    D   E   F
 
Output is: A, B, C, D, E, F
```

