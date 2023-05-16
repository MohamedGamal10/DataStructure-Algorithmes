public class LinkedListIterator <Tdata> {
    LinkedListNode currentNode;
    LinkedListIterator(LinkedListNode node){
        this.currentNode = node;
    }

    public Tdata data (){
        if (this.currentNode ==null) return (Tdata) "0";
        return (Tdata) this.currentNode.data;
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
