import android.content.ContentValues;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class dqf
  extends ContentObserver
{
  private final Set<Object> a = new HashSet();
  private ContentValues b;
  public Cursor r;
  public String s;
  
  protected dqf(Handler paramHandler, String paramString, Cursor paramCursor)
  {
    super(paramHandler);
    r = paramCursor;
    s = paramString;
    if (r != null) {
      r.registerContentObserver(this);
    }
  }
  
  protected void a()
  {
    b = null;
  }
  
  public final boolean d()
  {
    if (r == null) {
      throw new IllegalStateException("cannot read from an insertion cursor");
    }
    boolean bool = r.moveToPosition(0);
    if (bool) {
      a();
    }
    return bool;
  }
  
  public final boolean deliverSelfNotifications()
  {
    return false;
  }
  
  public final void e()
  {
    if (r != null)
    {
      r.unregisterContentObserver(this);
      r.deactivate();
    }
    if ((r != null) && (!r.isClosed())) {
      r.close();
    }
  }
  
  public void onChange(boolean paramBoolean)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
  }
}

/* Location:
 * Qualified Name:     dqf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */