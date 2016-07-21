import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.BitSet;

public final class icz
  implements icr, ics
{
  private static final BitSet c = new BitSet(256);
  private final Charset a;
  private final boolean b;
  
  static
  {
    int i = 33;
    while (i <= 60)
    {
      c.set(i);
      i += 1;
    }
    i = 62;
    while (i <= 126)
    {
      c.set(i);
      i += 1;
    }
    c.set(9);
    c.set(32);
  }
  
  public icz()
  {
    this(ict.f);
  }
  
  private icz(Charset paramCharset)
  {
    a = paramCharset;
    b = false;
  }
  
  private static final int a(int paramInt, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    paramByteArrayOutputStream.write(61);
    int i = Character.toUpperCase(Character.forDigit(paramInt >> 4 & 0xF, 16));
    paramInt = Character.toUpperCase(Character.forDigit(paramInt & 0xF, 16));
    paramByteArrayOutputStream.write(i);
    paramByteArrayOutputStream.write(paramInt);
    return 3;
  }
  
  private static int a(int paramInt, boolean paramBoolean, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    if (paramBoolean) {
      return a(paramInt, paramByteArrayOutputStream);
    }
    paramByteArrayOutputStream.write(paramInt);
    return 1;
  }
  
  private static int a(int paramInt, byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte[paramInt];
    paramInt = i;
    if (i < 0) {
      paramInt = i + 256;
    }
    return paramInt;
  }
  
  private static boolean a(int paramInt)
  {
    return (paramInt == 32) || (paramInt == 9);
  }
  
  private static byte[] c(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int j;
    for (int i = 0;; i = j + 1) {
      if (i < paramArrayOfByte.length)
      {
        int k = paramArrayOfByte[i];
        if (k == 61)
        {
          j = i + 1;
          if (paramArrayOfByte[j] != 13) {
            try
            {
              i = ida.a(paramArrayOfByte[j]);
              j += 1;
              localByteArrayOutputStream.write((char)((i << 4) + ida.a(paramArrayOfByte[j])));
            }
            catch (ArrayIndexOutOfBoundsException paramArrayOfByte)
            {
              throw new icu("Invalid quoted-printable encoding", paramArrayOfByte);
            }
          }
        }
        else
        {
          j = i;
          if (k != 13)
          {
            j = i;
            if (k != 10)
            {
              localByteArrayOutputStream.write(k);
              j = i;
            }
          }
        }
      }
      else
      {
        return localByteArrayOutputStream.toByteArray();
      }
    }
  }
  
  public final byte[] a(byte[] paramArrayOfByte)
  {
    return c(paramArrayOfByte);
  }
  
  public final byte[] b(byte[] paramArrayOfByte)
  {
    int i = 0;
    Object localObject2 = c;
    boolean bool = b;
    if (paramArrayOfByte == null) {
      return null;
    }
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = c;
    }
    localObject2 = new ByteArrayOutputStream();
    int j;
    int k;
    if (bool)
    {
      j = 0;
      i = 1;
      if (j < paramArrayOfByte.length - 3)
      {
        k = a(j, paramArrayOfByte);
        if (i < 73)
        {
          if (!((BitSet)localObject1).get(k)) {}
          for (bool = true;; bool = false)
          {
            i += a(k, bool, (ByteArrayOutputStream)localObject2);
            j += 1;
            break;
          }
        }
        if ((!((BitSet)localObject1).get(k)) || (a(k))) {}
        for (bool = true;; bool = false)
        {
          a(k, bool, (ByteArrayOutputStream)localObject2);
          ((ByteArrayOutputStream)localObject2).write(61);
          ((ByteArrayOutputStream)localObject2).write(13);
          ((ByteArrayOutputStream)localObject2).write(10);
          i = 1;
          break;
        }
      }
      j = a(paramArrayOfByte.length - 3, paramArrayOfByte);
      if ((!((BitSet)localObject1).get(j)) || ((a(j)) && (i > 68)))
      {
        bool = true;
        if (a(j, bool, (ByteArrayOutputStream)localObject2) + i > 71)
        {
          ((ByteArrayOutputStream)localObject2).write(61);
          ((ByteArrayOutputStream)localObject2).write(13);
          ((ByteArrayOutputStream)localObject2).write(10);
        }
        i = paramArrayOfByte.length - 2;
        label248:
        if (i >= paramArrayOfByte.length) {
          break label377;
        }
        j = a(i, paramArrayOfByte);
        if ((((BitSet)localObject1).get(j)) && ((i <= paramArrayOfByte.length - 2) || (!a(j)))) {
          break label309;
        }
      }
      label309:
      for (bool = true;; bool = false)
      {
        a(j, bool, (ByteArrayOutputStream)localObject2);
        i += 1;
        break label248;
        bool = false;
        break;
      }
    }
    else
    {
      int m = paramArrayOfByte.length;
      if (i < m)
      {
        k = paramArrayOfByte[i];
        j = k;
        if (k < 0) {
          j = k + 256;
        }
        if (((BitSet)localObject1).get(j)) {
          ((ByteArrayOutputStream)localObject2).write(j);
        }
        for (;;)
        {
          i += 1;
          break;
          a(j, (ByteArrayOutputStream)localObject2);
        }
      }
    }
    label377:
    return ((ByteArrayOutputStream)localObject2).toByteArray();
  }
}

/* Location:
 * Qualified Name:     icz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */