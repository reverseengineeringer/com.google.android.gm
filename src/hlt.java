import java.io.IOException;
import java.nio.ByteBuffer;

public abstract class hlt
{
  public volatile int E = -1;
  
  public static <T extends hlt> T a(int paramInt)
  {
    try
    {
      int i;
      Object localObject = new hlk((byte[])localObject, 0, i);
      paramInt.a((hlk)localObject);
      ((hlk)localObject).a(0);
      return paramInt;
    }
    catch (hls paramInt)
    {
      throw paramInt;
    }
    catch (IOException paramInt)
    {
      throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
    }
  }
  
  public static final byte[] a(hlt paramhlt)
  {
    byte[] arrayOfByte = new byte[paramhlt.d()];
    int i = arrayOfByte.length;
    try
    {
      hll localhll = hll.a(arrayOfByte, 0, i);
      paramhlt.a(localhll);
      if (a.remaining() != 0) {
        throw new IllegalStateException("Did not write as much data as expected.");
      }
    }
    catch (IOException paramhlt)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", paramhlt);
    }
    return arrayOfByte;
  }
  
  public int a()
  {
    return 0;
  }
  
  public abstract hlt a(hlk paramhlk);
  
  public void a(hll paramhll) {}
  
  public hlt c()
  {
    return (hlt)super.clone();
  }
  
  public final int d()
  {
    int i = a();
    E = i;
    return i;
  }
  
  public String toString()
  {
    return hlu.a(this);
  }
}

/* Location:
 * Qualified Name:     hlt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */