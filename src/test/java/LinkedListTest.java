import org.junit.Before;
import org.junit.Test;

import java.sql.Array;

import static org.junit.Assert.assertEquals;

public class LinkedListTest {
    @Test
    public void newEmptyNodeDataEqualsEmptyString(){
        Node myNode = new Node();

        assertEquals("", myNode.getData());
    }

    @Test
    public void newPopulatedNodeDataEqualsDataPassedIn(){
        Node myNode = new Node("string", new Node());

        assertEquals("string", myNode.getData());
    }

    @Test
    public void setDataInNodeResultsInNewDataValue(){
        Node myNode = new Node("string", new Node());

        myNode.setData("new string");

        assertEquals("new string", myNode.getData());
    }

    @Test
    public void setLinkInNodeResultsInNewLink(){
        Node myNode = new Node("words", new Node());
        Node linkNode = new Node("more words", new Node());

        myNode.setLink(linkNode);

        assertEquals(linkNode, myNode.getLink());
    }

    @Test
    public void newEmptyLinkedListContainsZeroNodes(){
        LinkedList myList = new LinkedList();

        assertEquals(0, myList.getSize());
    }

    @Test
    public void newPopulatedLinkedListResultsICorrectSize(){
        LinkedList myList = new LinkedList();
        Node firstNode = new Node("string", null);
        Node secondNode = new Node("another string", null);

        myList.addNode(firstNode);
        myList.addNode(secondNode);

        assertEquals(2, myList.getSize());
    }

    @Test
    public void newLinkedListCanHaveNodesAddedToEnd(){
        LinkedList myList = new LinkedList();
        Node firstNode = new Node("string", null);
        Node secondNode = new Node("another string", null);

        myList.addNode(firstNode);
        myList.addNode(secondNode);

        assertEquals(secondNode, firstNode.getLink());
    }

    @Test
    public void searchingForStringReturnsTheNodeContainingThatString(){
        LinkedList myList = new LinkedList();
        Node firstNode = new Node("First string", null);
        Node secondNode = new Node("Second string", null);
        Node thirdNode = new Node("Third string", null);

        myList.addNode(firstNode);
        myList.addNode(secondNode);
        myList.addNode(thirdNode);

        Node resultNode = myList.searchFor("Second string");

        assertEquals("Second string", resultNode.getData());
    }

    @Test
    public void deletingTheOnlyNodeInTheArrayResultsInEmptyList(){
        LinkedList myList = new LinkedList();
        Node firstNode = new Node("First string", null);

        myList.addNode(firstNode);

        myList.deleteNode(0);

        assertEquals(0, myList.getSize());
        assertEquals(null, myList.getStart());
    }

    @Test
    public void deletingLastNodeInListResultsInPreviousElementBecomingLast(){
        LinkedList myList = new LinkedList();
        Node firstNode = new Node("First string", null);
        Node secondNode = new Node("Second string", null);
        Node thirdNode = new Node("Third string", null);

        myList.addNode(firstNode);
        myList.addNode(secondNode);
        myList.addNode(thirdNode);

        myList.deleteNode(2);

        assertEquals(2, myList.getSize());
        assertEquals(null, secondNode.getLink());
    }

    @Test
    public void deletingMiddleNodeInListResultsInThatNodeBeingRemoved(){
        LinkedList myList = new LinkedList();
        Node firstNode = new Node("First string", null);
        Node secondNode = new Node("Second string", null);
        Node thirdNode = new Node("Third string", null);

        myList.addNode(firstNode);
        myList.addNode(secondNode);
        myList.addNode(thirdNode);

        myList.deleteNode(1);

        assertEquals(2, myList.getSize());
        assertEquals(thirdNode, firstNode.getLink());
    }

    @Test
    public void returnAllValuesReturnsAnArrayOfEachStringInTheList(){
        LinkedList myList = new LinkedList();
        Node firstNode = new Node("First string", null);
        Node secondNode = new Node("Second string", null);
        Node thirdNode = new Node("Third string", null);

        myList.addNode(firstNode);
        myList.addNode(secondNode);
        myList.addNode(thirdNode);

        String[] expectedArray = {"First string", "Second string", "Third string"};

        assertEquals(expectedArray, myList.returnAllValues());
    }

}
