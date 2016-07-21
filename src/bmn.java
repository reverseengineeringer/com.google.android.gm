import android.content.Context;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import java.util.HashMap;

public abstract class bmn
  extends bmo
{
  public Context a;
  public Cursor b;
  public int c;
  public SparseIntArray d;
  public final HashMap<Object, Integer> e = new HashMap();
  
  public bmn(Context paramContext, fq paramfq, Cursor paramCursor)
  {
    super(paramfq);
    if (paramCursor != null)
    {
      i = 1;
      b = paramCursor;
      a = paramContext;
      if (i == 0) {
        break label64;
      }
    }
    label64:
    for (int i = b.getColumnIndex("uri");; i = -1)
    {
      c = i;
      return;
      i = 0;
      break;
    }
  }
  
  private final boolean c(int paramInt)
  {
    if ((b != null) && (!b.isClosed())) {
      return b.moveToPosition(paramInt);
    }
    return false;
  }
  
  private final void f()
  {
    if ((b == null) || (b.isClosed()))
    {
      d = null;
      return;
    }
    SparseIntArray localSparseIntArray = new SparseIntArray(b.getCount());
    b.moveToPosition(-1);
    while (b.moveToNext()) {
      localSparseIntArray.append(b.getString(c).hashCode(), b.getPosition());
    }
    d = localSparseIntArray;
  }
  
  public final int a()
  {
    if (b != null) {
      return b.getCount();
    }
    return 0;
  }
  
  public Cursor a(Cursor paramCursor)
  {
    int i;
    if (Log.isLoggable("BaseCursorPagerAdapter", 2))
    {
      if (b != null) {
        break label62;
      }
      i = -1;
      if (paramCursor != null) {
        break label75;
      }
    }
    label62:
    label75:
    for (int j = -1;; j = paramCursor.getCount())
    {
      new StringBuilder(43).append("swapCursor old=").append(i).append("; new=").append(j);
      if (paramCursor != b) {
        break label85;
      }
      return null;
      i = b.getCount();
      break;
    }
    label85:
    Cursor localCursor = b;
    b = paramCursor;
    if (paramCursor != null) {}
    for (c = paramCursor.getColumnIndex("uri");; c = -1)
    {
      f();
      e();
      return localCursor;
    }
  }
  
  public abstract Fragment a(Cursor paramCursor, int paramInt);
  
  public final Object a(View paramView, int paramInt)
  {
    if (b == null) {
      throw new IllegalStateException("this should only be called when the cursor is valid");
    }
    if (c(paramInt)) {}
    for (Integer localInteger = Integer.valueOf(b.getString(c).hashCode());; localInteger = null)
    {
      paramView = super.a(paramView, paramInt);
      if (paramView != null) {
        e.put(paramView, localInteger);
      }
      return paramView;
    }
  }
  
  protected final String a(int paramInt1, int paramInt2)
  {
    if (c(paramInt2))
    {
      paramInt2 = b.getString(c).hashCode();
      return 37 + "android:pager:" + paramInt1 + ":" + paramInt2;
    }
    return super.a(paramInt1, paramInt2);
  }
  
  public final void a(View paramView, int paramInt, Object paramObject)
  {
    e.remove(paramObject);
    super.a(paramView, paramInt, paramObject);
  }
  
  public final int b(Object paramObject)
  {
    paramObject = (Integer)e.get(paramObject);
    if ((paramObject == null) || (d == null)) {
      return -2;
    }
    return d.get(((Integer)paramObject).intValue(), -2);
  }
  
  public final Fragment b(int paramInt)
  {
    if ((b != null) && (c(paramInt))) {
      return a(b, paramInt);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     bmn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */