import android.database.Cursor;
import android.database.CursorWrapper;
import android.util.SparseArray;

public class ccy<T>
  extends CursorWrapper
{
  private final SparseArray<T> a;
  private final ccx<T> b;
  
  public ccy(Cursor paramCursor, ccx<T> paramccx)
  {
    super(paramCursor);
    if (paramCursor != null) {}
    for (a = new SparseArray(paramCursor.getCount());; a = null)
    {
      b = paramccx;
      return;
    }
  }
  
  public void close()
  {
    super.close();
    a.clear();
  }
  
  public final T f()
  {
    Cursor localCursor = getWrappedCursor();
    if (localCursor == null) {
      localObject1 = null;
    }
    int i;
    Object localObject2;
    do
    {
      return (T)localObject1;
      i = localCursor.getPosition();
      localObject2 = a.get(i);
      localObject1 = localObject2;
    } while (localObject2 != null);
    Object localObject1 = b.a(localCursor);
    a.put(i, localObject1);
    return (T)localObject1;
  }
}

/* Location:
 * Qualified Name:     ccy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */