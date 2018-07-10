public class LinkedList {
    private Node start;
    private int size;

    public LinkedList(){
        this.start = null;
        this.size = 0;
    }

    public int getSize(){
        return size;
    }

    public Node getStart(){ return this.start; }

    public void addNode(Node node){

        if(this.size == 0){
            this.start = node;
        }else{
            Node currentNode = start;

            while(currentNode.getLink() != null){
                currentNode = currentNode.getLink();
            }

            currentNode.setLink(node);
        }
        this.size++;
    }

    public Node searchFor(String string) {
        Node currentNode = start;

        while (currentNode.getLink() != null) {
            if(currentNode.getData() == string)
                return currentNode;
            currentNode = currentNode.getLink();
        }
        return null;
    }

    public void deleteNode(int pos) {
        Node currentNode = start;
        Node previousNode = null;

        if(pos == 0) // delete first element
            start = start.getLink();

        else if(pos == this.size - 1) {  //delete last element
            while (currentNode != null) {
                if(currentNode.getLink() == null)
                    previousNode.setLink(null);

                previousNode = currentNode;
                currentNode = currentNode.getLink();
            }
        }

        else {  // delete any other element
            for (int i = 0; i < pos; i++) {
                previousNode = currentNode;
                currentNode = currentNode.getLink();
            }
            previousNode.setLink(currentNode.getLink());
        }

        size--;
    }

    public String[] returnAllValues() {
        String[] valuesArray = new String[this.size];

        Node currentNode = start;
        for(int i = 0; i < size; i++){
            valuesArray[i] = currentNode.getData();
            currentNode = currentNode.getLink();
        }

        return valuesArray;
    }
}