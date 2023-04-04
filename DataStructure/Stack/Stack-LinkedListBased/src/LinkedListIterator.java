public class LinkedListIterator {
    LinkedListNode currentNode;
    LinkedListIterator(LinkedListNode node){
        this.currentNode = node;
    }

    public int data (){
        if (this.currentNode ==null) return 0;
        return this.currentNode.data;
    }

    public LinkedListIterator next(){
        if (this.currentNode != null){
            this.currentNode = this.currentNode.next;
        }
        return this;
    }

    public LinkedListNode current (){
        return this.currentNode;
    }
}
