import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

public abstract class elr<T>
  extends elh<T>
{
  private boolean b = false;
  private ArrayList<Integer> c;
  
  public elr(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  private final void a()
  {
    for (;;)
    {
      int i;
      String str2;
      try
      {
        if (b) {
          break label190;
        }
        int j = a.h;
        c = new ArrayList();
        if (j <= 0) {
          break label185;
        }
        c.add(Integer.valueOf(0));
        String str3 = e();
        i = a.a(0);
        String str1 = a.a(str3, 0, i);
        i = 1;
        if (i >= j) {
          break label185;
        }
        int k = a.a(i);
        str2 = a.a(str3, i, k);
        if (str2 == null) {
          throw new NullPointerException("Missing value for markerColumn: " + str3 + ", at row: " + i + ", for window: " + k);
        }
      }
      finally {}
      if (!str2.equals(localObject1))
      {
        c.add(Integer.valueOf(i));
        Object localObject2 = str2;
        break label193;
        label185:
        b = true;
        label190:
        return;
      }
      label193:
      i += 1;
    }
  }
  
  private final int b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= c.size())) {
      throw new IllegalArgumentException("Position " + paramInt + " is out of bounds for this buffer");
    }
    return ((Integer)c.get(paramInt)).intValue();
  }
  
  public final T a(int paramInt)
  {
    a();
    int k = b(paramInt);
    int j;
    if ((paramInt < 0) || (paramInt == c.size()))
    {
      j = 0;
      return (T)a(k, j);
    }
    if (paramInt == c.size() - 1) {}
    for (int i = a.h - ((Integer)c.get(paramInt)).intValue();; i = ((Integer)c.get(paramInt + 1)).intValue() - ((Integer)c.get(paramInt)).intValue())
    {
      j = i;
      if (i != 1) {
        break;
      }
      paramInt = b(paramInt);
      a.a(paramInt);
      j = i;
      break;
    }
  }
  
  public abstract T a(int paramInt1, int paramInt2);
  
  public final int c()
  {
    a();
    return c.size();
  }
  
  public abstract String e();
}

/* Location:
 * Qualified Name:     elr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */