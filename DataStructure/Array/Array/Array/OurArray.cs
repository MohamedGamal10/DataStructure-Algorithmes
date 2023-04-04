using System;
using System.Runtime.InteropServices;
using System.Runtime.CompilerServices;
    public class OurArray
    {
        public void  Resize <T> (ref T[] Source, int newSize)
        {

            //Processes
            //Validation
            if (newSize <= 0) return;
            if (Source == null) return;
            if (Source.Length == newSize) return;

            T[] newArray = new T[newSize];

            //Copy Array bytes to new array it's impose that faster than you copy element by element with for loop
            Buffer.BlockCopy(Source,0, newArray,0,Buffer.ByteLength(Source));

            //Address of old array point to address of new array
            Source = newArray;
        }


        public T GetAt<T>(T[] source, int index, int SizeOF) 
        {
            if(index < 0) return default(T);
            ref byte zeroAdrr = ref MemoryMarshal.GetArrayDataReference((Array)source);
            ref byte indexRef = ref Unsafe.Add(ref zeroAdrr, index * SizeOF);
            ref T item = ref Unsafe.As<Byte, T>(ref indexRef);
            return item;
        
        }
    }
