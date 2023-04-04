public class LinkdeList {
    LinkedListNode head;
    LinkedListNode tail;
    int length;
    boolean unique;

    LinkdeList (boolean unique){
        this.head = null;
        this.tail = null;
        this.length = 0;
        this.unique = unique;
    }

    public LinkedListIterator begin (){
        return new LinkedListIterator(this.head);
    }

    public void printList(){
        String print_data = "";
        for (var itr = this.begin();itr.current() != null; itr.next()){
            print_data += itr.data() + " -> ";
        }
        System.out.println(print_data);
    }

    public boolean isExist(int _data){
        if(!(this.find(_data) == null)){
            return true;
        }
        else{
            return false;
        }
    }
    public LinkedListNode find(int _data){
        for (var itr = this.begin();itr.current() != null; itr.next()){
            if(itr.data() ==_data){
                return itr.current();
            }
        }
        return null;
    }

    public LinkedListNode findparant(LinkedListNode node){
        for (LinkedListIterator itr = this.begin(); itr.current() != null; itr.next()){
            if(itr.current().next == node){
                return itr.current();
            }
        }
        return null;
    }

    public boolean canInsert(int _data){
        if(this.unique && this.isExist(_data)){
            System.out.println(_data + " already exist");
            return false;
        }else{
            return true;
        }

    }
    public void insertLast (int _data){
        if(!this.canInsert(_data)) return;

        LinkedListNode newNode = new LinkedListNode(_data);
        if(this.head == null){
            this.head = newNode;
            this.tail = newNode;
        }
        else{
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.length++;
    }

    public void insertAfter (int node_data, int _data){
        if(!this.canInsert(_data)) return;

        LinkedListNode node = this.find(node_data);
        LinkedListNode newNode = new LinkedListNode(_data);
        newNode.next = node.next;
        node.next = newNode;
        if (this.tail ==node){
            this.tail = newNode;
        }
        this.length++;
    }

    public void insertBefore (int node_data, int _data){
        if(!this.canInsert(_data)) return;

        LinkedListNode node = this.find(node_data);
        LinkedListNode newNode = new LinkedListNode(_data);
        newNode.next = node;
        LinkedListNode parent = this.findparant(node);

        if(parent == null){
            this.head = newNode;
        }
        else{
            parent.next = newNode;
        }
        this.length++;
    }

    public void deleteNode (int node_data){
        LinkedListNode node = this.find(node_data);
        if(this.head == this.tail){
            this.head = null;
            this.tail = null;
        }
        else if (this.head == node){
            this.head = node.next;
        }
        else{
            LinkedListNode parent = this.findparant(node);
            if(this.tail == node){
                this.tail = parent;
            }
            else{
                parent.next = node.next;
            }
        }
        node = null;
        this.length--;
    }

    public void insertFirst(int _data){
        if(!this.canInsert(_data)) return;
        LinkedListNode newNode = new LinkedListNode(_data);
        if(this.head == null){
            this.head = newNode;
            this.tail = newNode;
        }
        else{
            newNode.next = this.head;
            this.head = newNode;
        }
        this.length++;
    }

    public void deleteHead(){
        if(this.head == null) return;
        this.head = this.head.next;
        this.length --;
    }
}
