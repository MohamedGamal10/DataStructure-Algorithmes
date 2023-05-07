import com.google.common.primitives.UnsignedInteger;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class HashTable<Tkey,Tvalue>
{
    KeyValuePair[] entries;
    int initialSize;
    int entriesCount;
    public HashTable ()
    {
        this.initialSize = 3;
        this.entries = new KeyValuePair[this.initialSize];
        this.entriesCount= 0;
    }

    public int GetHash(Tkey key)
    {
        //Note the "L" suffix at the end of the value. This tells Java that the value should be treated as a long rather than an int.
        UnsignedInteger OffsetBasis = UnsignedInteger.valueOf(2166136261L);
        UnsignedInteger FNVPrime = UnsignedInteger.valueOf(16777619);

        byte[] data = key.toString().getBytes(StandardCharsets.US_ASCII);

        UnsignedInteger hash = OffsetBasis;

        for (int i = 0; i < data.length; i++)
        {
            hash = UnsignedInteger.valueOf(hash.bigIntegerValue().xor(BigInteger.valueOf(data[i] & 0xff)));
            hash = hash.times(FNVPrime);
        }
        System.out.println(" [hash] " + key.toString() + " " + hash + " " + Integer.toHexString(hash.intValue()) + " " + hash.longValue() % UnsignedInteger.valueOf(this.entries.length).longValue());
        return (int)(hash.longValue() % UnsignedInteger.valueOf(this.entries.length).longValue());

    }

    public int CollisionHandling(Tkey key, int hash, boolean Set)
    {
        int newHash;
        for (int i = 0; i < this.entries.length; i++)
        {
            newHash = ( hash + i ) % this.entries.length;
            System.out.println(" [coll] " + key.toString()+ " " + hash + ", new hash: " + newHash);
            if(Set && ( this.entries[newHash] == null || this.entries[newHash].get_key() == key ))
            {
                return newHash;
            }
            else if (!Set && this.entries[newHash].get_key() == key)
            {
                return newHash;
            }
        }
        return -1;
    }

    public void AddToEntries(Tkey key, Tvalue value)
    {
        int hash = this.GetHash(key);
        if(this.entries[hash] != null && this.entries[hash].get_key() != key)
        {
            hash = this.CollisionHandling(key,hash, true);
        }

        if(hash ==  -1)
        {
            throw new RuntimeException("Invalid Hashtable !!!!!!!!!!!!!");
        }

        if (this.entries[hash] == null)
        {
            KeyValuePair newPair = new KeyValuePair(key,value);
            this.entries[hash] = newPair;
            this.entriesCount ++;
        }
        else if (this.entries[hash].get_key() == key )
        {
            this.entries[hash].set_value(value);
        }
        else
        {
            throw new RuntimeException("Invalid HashTable !!!!!!!!!!!!");
        }

    }

    public void ResizeOrNot()
    {
        if(this.entriesCount < this.entries.length) return;

        int newSize = this.entries.length * 2;
        System.out.println("[resize] from " + this.entries.length + " to " + newSize);
        KeyValuePair[] entriesCopy = new KeyValuePair[this.entries.length];
        System.arraycopy(this.entries,0, entriesCopy,0,this.entries.length);
        this.entries = new KeyValuePair[newSize];
        this.entriesCount = 0;
        for (int i = 0; i < entriesCopy.length; i++)
        {
            if (entriesCopy[i] == null) continue;
            this.AddToEntries((Tkey) entriesCopy[i].get_key(), (Tvalue) entriesCopy[i].get_value());
        }
    }

    public void Set (Tkey key, Tvalue value)
    {
        this.ResizeOrNot();
        this.AddToEntries(key,value);
    }
    public int Size()
    {
        return this.entriesCount;
    }

    public Tvalue Get(Tkey key)
    {
        int hash = this.GetHash(key);
        if(this.entries[hash] != null && this.entries[hash].get_key() != key)
        {
            hash = this.CollisionHandling(key,hash, false);
        }

        if(hash ==  -1 || this.entries[hash] == null)
        {
            return (Tvalue) "0";
        }

        if(this.entries[hash].get_key() == key)
        {
            return (Tvalue) this.entries[hash].get_value();
        }
        else
        {
            throw new RuntimeException("Invalied Hashtable !!!!!!!!!!");
        }

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
