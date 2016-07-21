import java.io.IOException;
import java.nio.ByteBuffer;

public class fmq
{
  public volatile int g = -1;
  
  public static final byte[] a(fmq paramfmq)
  {
    byte[] arrayOfByte = new byte[paramfmq.d()];
    int i = arrayOfByte.length;
    try
    {
      fmj localfmj = fmj.a(arrayOfByte, 0, i);
      paramfmq.a(localfmj);
      if (a.remaining() != 0) {
        throw new IllegalStateException("Did not write as much data as expected.");
      }
    }
    catch (IOException paramfmq)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", paramfmq);
    }
    return arrayOfByte;
  }
  
  public int a()
  {
    return 0;
  }
  
  public void a(fmj paramfmj) {}
  
  public fmq c()
  {
    return (fmq)super.clone();
  }
  
  public final int d()
  {
    int i = a();
    g = i;
    return i;
  }
  
  public String toString()
  {
    return fmr.a(this);
  }
}

/* Location:
 * Qualified Name:     fmq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */