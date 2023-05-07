import com.google.common.primitives.UnsignedInteger;
import com.google.common.primitives.UnsignedLong;

import java.nio.charset.StandardCharsets;
import java.math.BigInteger;
public class Hash {

    public UnsignedInteger Hash32(String str)
    {
        //Note the "L" suffix at the end of the value. This tells Java that the value should be treated as a long rather than an int.
        UnsignedInteger OffsetBasis = UnsignedInteger.valueOf(2166136261L);
        UnsignedInteger FNVPrime = UnsignedInteger.valueOf(16777619);

        byte[] data = str.getBytes(StandardCharsets.US_ASCII);

        UnsignedInteger hash = OffsetBasis;

        for (int i = 0; i < data.length; i++)
        {
            hash = UnsignedInteger.valueOf(hash.bigIntegerValue().xor(BigInteger.valueOf(data[i] & 0xff)));
            hash = hash.times(FNVPrime);
        }
        System.out.println(str + " , " + hash + " , " + Integer.toHexString(hash.intValue()));
        return hash;
    }

    public UnsignedLong Hash64(String str)
    {
        //Note the "L" suffix at the end of the value. This tells Java that the value should be treated as a long rather than an int.
        UnsignedLong OffsetBasis = UnsignedLong.valueOf("14695981039346656037");
        UnsignedLong FNVPrime = UnsignedLong.valueOf("1099511628211");

        byte[] data = str.getBytes(StandardCharsets.US_ASCII);

        UnsignedLong hash = OffsetBasis;

        for (int i = 0; i < data.length; i++)
        {
            hash = UnsignedLong.valueOf(hash.bigIntegerValue().xor(BigInteger.valueOf(data[i] & 0xff)));
            hash = hash.times(FNVPrime);
        }
        System.out.println(str + " , " + hash + " , " + Long.toHexString(hash.longValue()));
        return hash;
    }
}
