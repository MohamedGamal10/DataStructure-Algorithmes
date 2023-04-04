public class Stack {
    private LinkdeList data_list;

    Stack(boolean unique){
        this.data_list = new LinkdeList(unique);
    }

    public void push (int _data){
        this.data_list.insertFirst(_data);
    }

    public int pop (){
        int head_data = this.data_list.head.data;
        this.data_list.deleteHead();
        return head_data;
    }

    public int peek (){
        return this.data_list.head.data;
    }

    public boolean isEmpty(){
        return this.data_list.length <= 0;
    }

    public void print(){
        this.data_list.printList();
    }

    public int size (){
        return this.data_list.length;
    }
}
