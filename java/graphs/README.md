# Graph

In this folder we have the Graph project with the [IGraphService](src/main/java/br/com/gomide/graph/service/IGraphService.java) interface.

The `IGraphService` interface contains the methods related to Graphs operations. 

## Exercise

We have a test class to check the [GraphService](src/main/java/br/com/gomide/graph/service/GraphService.java) implementation.

You should open the [GraphServiceTest](src/test/java/br/com/gomide/graph/service/GraphServiceTest.java) and [ShortestPathTest](src/test/java/br/com/gomide/graph/service/ShortestPathTest.java) to know how `GraphService` will work.

Also, implement the [Graph](src/main/java/br/com/gomide/graph/model/Graph.java), [NonDirectedGraph](src/main/java/br/com/gomide/graph/model/NonDirectedGraph.java) and [DirectedGraph](src/main/java/br/com/gomide/graph/model/DirectedGraph.java) using any approach (matrix, object oriented or another one...).

Complete the `GraphService` implementation to make all tests green.