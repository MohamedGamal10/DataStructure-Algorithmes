public class Main {
    public static void main(String[] args) {
        HashTable<String, String> table = new HashTable();
        table.Print();
        table.Set("Sinar", "sinar@gmail.com");
        table.Set("Elvis", "elvis@gmail.com");
        table.Set("Tane", "tane@gmail.com");
        table.Print();
        System.out.println(" [get] " + table.Get("Sinar"));
        //System.out.println(" [get] " + table.Get("Tane"));
        table.Set("Gerti", "gerti@gmail.com");
        table.Set("Arist", "arist@gmail.com");
        table.Print();
        System.out.println(" [get] " + table.Get("Sinar"));
    }
}