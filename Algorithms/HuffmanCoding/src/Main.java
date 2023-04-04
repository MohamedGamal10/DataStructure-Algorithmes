public class Main {
    public static void main(String[] args) {
        String msg = "internet";
        Huffman huff = new Huffman(msg);
        huff.codes.forEach(
                (k, v) -> System.out.println(k +" "+ v));
    }
}