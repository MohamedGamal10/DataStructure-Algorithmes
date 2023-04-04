public class item {
    public String name;
    public float value;
    public float weight;
    public float ratio;

    public item (float value, float weight, String name){
        this.value = value;
        this.weight = weight;
        this.name = name;
        this.ratio = value / weight;
    }



}
