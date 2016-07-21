import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class guj
  extends FilterOutputStream
{
  final guh a;
  
  public guj(OutputStream paramOutputStream, Logger paramLogger, Level paramLevel, int paramInt)
  {
    super(paramOutputStream);
    a = new guh(paramLogger, paramLevel, paramInt);
  }
  
  public final void close()
  {
    a.close();
    super.close();
  }
  
  public final void write(int paramInt)
  {
    out.write(paramInt);
    a.write(paramInt);
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    out.write(paramArrayOfByte, paramInt1, paramInt2);
    a.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}

/* Location:
 * Qualified Name:     guj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */