public class Queue <Tdata>{
    private LinkdeList data_list;

    public Queue (){
        this.data_list = new LinkdeList(true);
    }

    public void enqueue (Tdata _data){
        this.data_list.insertLast(_data);
    }

    public Tdata dequeue (){
        Tdata node_data = (Tdata) this.data_list.head.data;
        this.data_list.deleteHead();
        return node_data;
    }

    public Tdata peek (){
        if(this.data_list.head == null) return null;
        return (Tdata) this.data_list.head.data;
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
