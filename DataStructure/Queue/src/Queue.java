public class Queue {
    private LinkdeList data_list;

    public Queue (){
        this.data_list = new LinkdeList(true);
    }

    public void enqueue (int _data){
        this.data_list.insertLast(_data);
    }

    public int dequeue (){
        int node_data = this.data_list.head.data;
        this.data_list.deleteHead();
        return node_data;
    }

    public Integer peek (){
        if(this.data_list.head == null) return null;
        return this.data_list.head.data;
    }

    boolean isEmpty (){
        if (this.data_list.length == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public int size (){
        return this.data_list.length;
    }

    public void print (){
        this.data_list.printList();
    }
}
