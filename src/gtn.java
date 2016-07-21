import java.io.OutputStream;

final class gtn
  extends OutputStream
{
  long a;
  
  public final void write(int paramInt)
  {
    a += 1L;
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a += paramInt2;
  }
}

/* Location:
 * Qualified Name:     gtn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */