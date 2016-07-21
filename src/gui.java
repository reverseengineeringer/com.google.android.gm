import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class gui
  extends FilterInputStream
{
  private final guh a;
  
  public gui(InputStream paramInputStream, Logger paramLogger, Level paramLevel, int paramInt)
  {
    super(paramInputStream);
    a = new guh(paramLogger, paramLevel, paramInt);
  }
  
  public final void close()
  {
    a.close();
    super.close();
  }
  
  public final int read()
  {
    int i = super.read();
    a.write(i);
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt2 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt2 > 0) {
      a.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    return paramInt2;
  }
}

/* Location:
 * Qualified Name:     gui
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */