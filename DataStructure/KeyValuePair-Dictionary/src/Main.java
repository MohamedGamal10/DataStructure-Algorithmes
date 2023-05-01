public class Main {
    public static void main(String[] args) {
        Dictionary<String,String> dic = new Dictionary<>();
        dic.Print();

        dic.Set("Mohamed","mohamed@gmail.com");
        dic.Set("ahmed","ahmed@gmail.com");
        dic.Print();

        dic.Set("gamal","gamal@gmail.com");
        dic.Set("greti","greti@gmail.com");
        dic.Set("Artist","Artist@gmail.com");

        //dic.Set("rArtist","rArtist@gmail.com");
        //dic.Set("tArtist","tArtist@gmail.com");
        //dic.Set("yArtist","yArtist@gmail.com");

        dic.Print();

        System.out.println(dic.Get("Mohamed"));
        System.out.println(dic.Get("ahmed"));
        System.out.println(dic.Get("gamalf"));

        dic.Remove("Mohamed");
        dic.Remove("ahmed");
        dic.Remove("gamal");
        dic.Remove("greti");
        dic.Remove("Artist");
        dic.Print();
        dic.Set("Sinar","Sinar@gmail.com");
        dic.Print();

    }
}