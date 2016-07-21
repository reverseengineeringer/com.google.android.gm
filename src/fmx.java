import java.util.Arrays;

public final class fmx
  extends fml<fmx>
{
  public byte[] a = fmt.h;
  public byte[][] b = fmt.g;
  public boolean c = false;
  
  public fmx()
  {
    f = null;
    g = -1;
  }
  
  protected final int a()
  {
    int n = 0;
    int j = super.a();
    int i = j;
    if (!Arrays.equals(a, fmt.h)) {
      i = j + fmj.b(1, a);
    }
    j = i;
    if (b != null)
    {
      j = i;
      if (b.length > 0)
      {
        int k = 0;
        int m = 0;
        j = n;
        while (j < b.length)
        {
          byte[] arrayOfByte = b[j];
          int i1 = k;
          n = m;
          if (arrayOfByte != null)
          {
            n = m + 1;
            i1 = k + fmj.a(arrayOfByte);
          }
          j += 1;
          k = i1;
          m = n;
        }
        j = i + k + m * 1;
      }
    }
    i = j;
    if (c) {
      i = j + (fmj.b(3) + 1);
    }
    return i;
  }
  
  public final void a(fmj paramfmj)
  {
    if (!Arrays.equals(a, fmt.h)) {
      paramfmj.a(1, a);
    }
    if ((b != null) && (b.length > 0))
    {
      int i = 0;
      while (i < b.length)
      {
        byte[] arrayOfByte = b[i];
        if (arrayOfByte != null) {
          paramfmj.a(2, arrayOfByte);
        }
        i += 1;
      }
    }
    if (c) {
      paramfmj.a(3, c);
    }
    super.a(paramfmj);
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (!(paramObject instanceof fmx));
          paramObject = (fmx)paramObject;
          bool1 = bool2;
        } while (!Arrays.equals(a, a));
        bool1 = bool2;
      } while (!fmp.a(b, b));
      bool1 = bool2;
    } while (c != c);
    return a((fml)paramObject);
  }
  
  public final int hashCode()
  {
    int j = Arrays.hashCode(a);
    int k = fmp.a(b);
    if (c) {}
    for (int i = 1231;; i = 1237) {
      return (i + ((j + 527) * 31 + k) * 31) * 31 + b();
    }
  }
}

/* Location:
 * Qualified Name:     fmx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */