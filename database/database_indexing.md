### database indexing

#### few things we have to undrstand first , before we see how indexing works

- how table data(rows) are actually stored ?
  - table is just a logical representation
  - dbms creates data pages
  - each data page can store multiple table rows in it
  - a data page consists of 
    - header ( 96 bytes )
      - pageNo , free space , checksum , etc
    - data records ( 8060 bytes )
      - actual data is stored in here
    - Offset ( 36 bytes )
      - contains an array 
      - each index of an array holds a pointer to corresponding data in the Data records.
  - these data pages ultimately get stored in the data block in physical memory like disk.
- what is data block ?
  - data block is minimum amount of data which can be read/write by an I/O operation
  - it is managed by underlying storage system like disk. Data block size can range from 4kb to 32 kb ( common size is 8KB )
  - so based on the data block size, it can hold 1 or many Data page.
  - dbms controls data pages ( like what Row goes in which page or sequence of pages etc. ) but has no control on Data Blocks ( data blocks can be scattered over the disk )
  - dbms maintains the mapping of DataPage and Data Block.
- what type of indexing present ?
  - indexing
    - clustered indexing (done for primary key , if not it creates internally ) 
      - order of rows inside the data pages, match with the order of index

    - non-clustered indexing ( done for composite key)
      - 

  - what is indexing ?
    - it is used to increased the performance of the database query. So that data can be fetched faster.
    - without indexing, DBMS has to iterate each and every table row to find the requested data.
    - i.e O(N), if there are millions of rows, qeury can take some time to fetch the data.
  - which data structure provides better time complexity then O(N) ?
    - B+ Tree, it provides O(log N) time complexity for insertion, searching & deletion.
  - How B (Balanced) Tree works ?
    - It maintains sorted data
    - All leaf are at the same level
    - M order B tree means, each node can have at most M childrens.
    - And M-1 Keys per node.

- understanding the data structure used for indexing and how it works ?
  - 