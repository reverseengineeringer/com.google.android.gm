import java.io.OutputStream;

public final class bgw
  extends OutputStream
{
  public long a;
  private final OutputStream b;
  
  public bgw(OutputStream paramOutputStream)
  {
    b = paramOutputStream;
  }
  
  public final void write(int paramInt)
  {
    b.write(paramInt);
    a += 1L;
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    b.write(paramArrayOfByte, paramInt1, paramInt2);
    a += paramInt2;
  }
}

/* Location:
 * Qualified Name:     bgw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */