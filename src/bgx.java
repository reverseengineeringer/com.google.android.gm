import java.io.FilterOutputStream;
import java.io.OutputStream;

public final class bgx
  extends FilterOutputStream
{
  int a;
  
  public bgx(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }
  
  public final void flush()
  {
    if (a == 13)
    {
      super.write(10);
      a = 10;
    }
    super.flush();
  }
  
  public final void write(int paramInt)
  {
    if ((paramInt == 10) && (a != 13)) {
      super.write(13);
    }
    super.write(paramInt);
    a = paramInt;
  }
}

/* Location:
 * Qualified Name:     bgx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */