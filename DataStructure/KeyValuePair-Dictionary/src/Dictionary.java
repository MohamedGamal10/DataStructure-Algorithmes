public class Dictionary<Tkey,Tvalue>
{
    KeyValuePair[] entries;
    int initialSize;
    int entriesCount;
    public Dictionary ()
    {
        this.initialSize = 3;
        this.entries = new KeyValuePair[this.initialSize];
        this.entriesCount= 0;
    }
    public void ResizeOrNot()
    {
        if(this.entriesCount < this.entries.length -1) return;

        int newSize = this.entries.length + this.initialSize;
        System.out.println("[resize] from " + this.entries.length + " to " + newSize);
        KeyValuePair[] newArray = new KeyValuePair[newSize];
        System.arraycopy(this.entries,0, newArray,0,this.entries.length);
        this.entries = newArray;
    }
    public int Size()
    {
        return this.entriesCount;
    }
    public void Set (Tkey key, Tvalue value)
    {
        for (int i = 0; i < this.entries.length; i++)
        {
            if(this.entries[i] !=null && this.entries[i].get_key() == key)
            {
                this.entries[i].set_value(value);
                return;
            }
        }
        this.ResizeOrNot();
        KeyValuePair<Tkey,Tvalue> newPair = new KeyValuePair<>(key,value);
        this.entries[this.entriesCount] = newPair;
        this.entriesCount ++;
    }
    public Tvalue Get(Tkey key)
    {
        for (int i = 0; i < this.entries.length; i++)
        {
            if(this.entries[i] !=null && this.entries[i].get_key() == key)
            {
                return (Tvalue) this.entries[i].get_value();
            }
        }
        return null;
    }
    public boolean Remove (Tkey key)
    {
        for (int i = 0; i < this.entries.length; i++)
        {
            if(this.entries[i] !=null && this.entries[i].get_key() == key)
            {
                this.entries[i] = this.entries[this.entriesCount-1];
                this.entries[this.entriesCount-1]=null;
                this.entriesCount --;
                return true;
            }
        }
        return false;
    }
    public void Print()
    {
        System.out.println("----------------------------");
        System.out.println("[size] " + this.Size());
        for (int i = 0; i < this.entries.length; i++)
        {
            if(this.entries[i] ==null)
            {
                System.out.println("["+i+"]");
                continue;
            }
            else
            {
                System.out.println("[" +i+ "]" + this.entries[i].get_key() + " : " + this.entries[i].get_value());
            }
        }
        System.out.println("----------------------------");
    }

}
