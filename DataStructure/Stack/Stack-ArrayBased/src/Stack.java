public class Stack {
    private int[] data_list;
    private int top_index;
    private int initial_size;
    private int current_size;

    Stack(boolean unique){
        this.initial_size = 5;
        this.data_list = new int [this.initial_size];
        this.top_index = -1;
        this.current_size = this.initial_size;
    }

    public void resizeOrnot(){
        if (this.top_index < this.current_size -1) return;
        System.out.println("Will be resized");
        int [] newArray = new int [this.current_size + this.initial_size];
        System.arraycopy(this.data_list, 0,newArray,this.data_list.length + this.current_size, this.data_list.length + this.current_size);
        this.current_size += this.initial_size;
        this.data_list = newArray;
    }

    public void push (int _data){
        this.resizeOrnot();
        this.data_list[++this.top_index] = _data;

    }

    public int pop (){
        if (this.top_index == -1) return 0;
        int head_data = this.data_list[this.top_index];
        this.data_list[this.top_index --] = 0;
        return head_data;


    }

    public int peek (){
        if (this.top_index == -1) return 0;
        return this.data_list[this.top_index];

    }

    public boolean isEmpty(){
        if (this.top_index == -1 ){
            return true ;
        }
        else {
            return false;
        }

    }

    public void print(){
        for (int i = this.top_index; i >=0; i--){
            System.out.print(this.data_list[i] + " -> ");
        }
        System.out.println("");
    }

    public int size (){
        return this.top_index + 1 ;

    }
}
