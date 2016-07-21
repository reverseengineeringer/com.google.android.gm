import android.database.CursorWindow;
import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import java.util.Arrays;

public class elq
{
  public final DataHolder a;
  public int b;
  public int c;
  
  public elq(DataHolder paramDataHolder, int paramInt)
  {
    a = ((DataHolder)enz.a(paramDataHolder));
    if ((paramInt >= 0) && (paramInt < a.h)) {}
    for (boolean bool = true;; bool = false)
    {
      enz.a(bool);
      b = paramInt;
      c = a.a(b);
      return;
    }
  }
  
  public final long a(String paramString)
  {
    DataHolder localDataHolder = a;
    int i = b;
    int j = c;
    localDataHolder.a(paramString, i);
    return d[j].getLong(i, c.getInt(paramString));
  }
  
  public final boolean a()
  {
    return !a.b();
  }
  
  public final int b(String paramString)
  {
    DataHolder localDataHolder = a;
    int i = b;
    int j = c;
    localDataHolder.a(paramString, i);
    return d[j].getInt(i, c.getInt(paramString));
  }
  
  public final String c(String paramString)
  {
    return a.a(paramString, b, c);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof elq))
    {
      paramObject = (elq)paramObject;
      bool1 = bool2;
      if (enx.a(Integer.valueOf(b), Integer.valueOf(b)))
      {
        bool1 = bool2;
        if (enx.a(Integer.valueOf(c), Integer.valueOf(c)))
        {
          bool1 = bool2;
          if (a == a) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(b), Integer.valueOf(c), a });
  }
}

/* Location:
 * Qualified Name:     elq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */