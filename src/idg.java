import java.io.Serializable;
import java.io.Writer;

public final class idg
  extends Writer
  implements Serializable
{
  private final StringBuilder a;
  
  public idg()
  {
    a = new StringBuilder();
  }
  
  public idg(byte paramByte)
  {
    a = new StringBuilder(4);
  }
  
  public final Writer append(char paramChar)
  {
    a.append(paramChar);
    return this;
  }
  
  public final Writer append(CharSequence paramCharSequence)
  {
    a.append(paramCharSequence);
    return this;
  }
  
  public final Writer append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    a.append(paramCharSequence, paramInt1, paramInt2);
    return this;
  }
  
  public final void close() {}
  
  public final void flush() {}
  
  public final String toString()
  {
    return a.toString();
  }
  
  public final void write(String paramString)
  {
    if (paramString != null) {
      a.append(paramString);
    }
  }
  
  public final void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (paramArrayOfChar != null) {
      a.append(paramArrayOfChar, paramInt1, paramInt2);
    }
  }
}

/* Location:
 * Qualified Name:     idg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */