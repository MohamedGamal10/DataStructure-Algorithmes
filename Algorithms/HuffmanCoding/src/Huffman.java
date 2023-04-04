import java.util.Comparator;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.PriorityQueue;

public class Huffman {

    //Store Final Codes in Hashtable
    public Hashtable codes = new Hashtable<>();

    //internal Processing Charachter
    char internal_char = (char)0;

    //Define PriorityQueue
        //Inputs Node and Frequecy == Periority
    private PriorityQueue<HeapNode> minHeap = new PriorityQueue<HeapNode>(Comparator.comparingInt(l -> l.freq));
    public Huffman(String Message){
        Hashtable freqHash = new Hashtable();
        int i;

        //Loop to get Frequency of each message character and insert into Hashtable
        for (i = 0; i < Message.length(); i++){
            if (freqHash.containsKey(Message.charAt(i))){
                freqHash.put(Message.charAt(i), (int)freqHash.get(Message.charAt(i)) + 1);
            }
            else {
                freqHash.put(Message.charAt(i), 1 );
            }
        }

        //Loop hashtable data into queue
        Enumeration Key = freqHash.keys();
        Enumeration Value = freqHash.elements();
        while (Key.hasMoreElements() & Value.hasMoreElements()) {
            HeapNode newNode = new HeapNode((char)Key.nextElement(), (int) Value.nextElement());
            minHeap.add(newNode);
        }

        //while loop runs until there is more than one node in the queue
        HeapNode top, left, right;
        int newFreq;
        while (minHeap.size() !=1){

            //removing the nodes having the highest priority (the lowest frequency) from the queue
            left = minHeap.poll();
            right = minHeap.poll();

            //sum up the frequency of the nodes (left and right) that we have deleted
            newFreq = left.freq + right.freq;

            //adding a new internal node (deleted nodes i.e. right and left) to the queue with a frequency that is equal to the sum of both nodes
            top = new HeapNode(internal_char, newFreq);
            top.left = left;
            top.right = right;

            minHeap.add(top);

        }

        // Genrate Codes
        generateCodes(minHeap.peek(), "");





    }

    //function to encode branches
    private void generateCodes (HeapNode node, String str){
        if (node == null){
            return;
        }
        if(node.data != internal_char){
            codes.put(node.data,str);
        }
        generateCodes(node.left, str + "0");
        generateCodes(node.right, str + "1");

    }
}
