import android.database.Cursor;
import android.database.CursorWrapper;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public final class azl
  extends CursorWrapper
{
  private static final String a = cvl.a;
  private int b = -1;
  private List<azm> c;
  
  public azl(Cursor paramCursor)
  {
    super(paramCursor);
    c = new ArrayList(paramCursor.getCount());
  }
  
  public final void a()
  {
    Cursor localCursor = getWrappedCursor();
    nx localnx = new nx();
    cvm.b(a, "ExchangeStateChangeCursorWrapper.consolidateStateChanges", new Object[0]);
    Object localObject;
    int j;
    while (localCursor.moveToNext())
    {
      long l = localCursor.getLong(1);
      localObject = localCursor.getString(2);
      i = localCursor.getInt(3);
      j = localCursor.getInt(4);
      int k = localCursor.getInt(5);
      int m = localCursor.getInt(6);
      azm localazm = (azm)localnx.a(l, null);
      if (localazm != null)
      {
        if (j != -1) {
          d = j;
        }
        if (m != -1) {
          f = m;
        }
      }
      else
      {
        localazm = new azm();
        b = ((String)localObject);
        a = l;
        c = i;
        d = j;
        e = k;
        f = m;
        localnx.b(l, localazm);
      }
    }
    int i = 0;
    if (i < localnx.a())
    {
      localObject = (azm)localnx.c(i);
      if ((c != d) || (e != f)) {}
      for (j = 1;; j = 0)
      {
        if ((!TextUtils.isEmpty(b)) && (j != 0)) {
          c.add(localObject);
        }
        i += 1;
        break;
      }
    }
    localCursor.moveToFirst();
    cvm.b(a, "Consolidate complete, mIndex=%d, change size=%d", new Object[] { Integer.valueOf(b), Integer.valueOf(c.size()) });
  }
  
  public final int getCount()
  {
    return c.size();
  }
  
  public final int getInt(int paramInt)
  {
    if ((b >= 0) && (b < getCount())) {}
    switch (paramInt)
    {
    default: 
      return 0;
    case 3: 
      return c.get(b)).c;
    case 4: 
      return c.get(b)).d;
    case 5: 
      return c.get(b)).e;
    }
    return c.get(b)).f;
  }
  
  public final long getLong(int paramInt)
  {
    if ((b >= 0) && (b < getCount())) {}
    switch (paramInt)
    {
    case 2: 
    default: 
      return 0L;
    case 1: 
      return c.get(b)).a;
    case 3: 
      return c.get(b)).c;
    case 4: 
      return c.get(b)).d;
    case 5: 
      return c.get(b)).e;
    }
    return c.get(b)).f;
  }
  
  public final String getString(int paramInt)
  {
    if ((b >= 0) && (b < getCount()) && (paramInt == 2)) {
      return c.get(b)).b;
    }
    return null;
  }
  
  public final boolean move(int paramInt)
  {
    return moveToPosition(b + paramInt);
  }
  
  public final boolean moveToFirst()
  {
    boolean bool = false;
    if (c.size() > 0)
    {
      b = 0;
      bool = true;
    }
    return bool;
  }
  
  public final boolean moveToLast()
  {
    if (c.size() > 0)
    {
      b = (c.size() - 1);
      return true;
    }
    return false;
  }
  
  public final boolean moveToNext()
  {
    if (b + 1 < getCount())
    {
      b += 1;
      return true;
    }
    return false;
  }
  
  public final boolean moveToPosition(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getCount()))
    {
      b = paramInt;
      return true;
    }
    return false;
  }
  
  public final boolean moveToPrevious()
  {
    if (b > 1)
    {
      b -= 1;
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     azl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */