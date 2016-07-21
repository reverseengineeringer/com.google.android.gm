import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.os.Binder;

public final class ays
  extends CursorWrapper
{
  private final int a;
  private final Context b;
  
  public ays(Context paramContext, Cursor paramCursor)
  {
    super(paramCursor);
    b = paramContext;
    a = paramCursor.getColumnIndex("section_body");
  }
  
  public final String getString(int paramInt)
  {
    if (paramInt != a) {
      return super.getString(paramInt);
    }
    long l1 = Binder.clearCallingIdentity();
    try
    {
      long l2 = super.getLong(a);
      String str2 = bds.d(b, l2);
      String str1 = str2;
      if (str2 == null) {
        str1 = bds.d(b, l2);
      }
      return str1;
    }
    finally
    {
      Binder.restoreCallingIdentity(l1);
    }
  }
  
  public final int getType(int paramInt)
  {
    if (paramInt != a) {
      return super.getType(paramInt);
    }
    return 3;
  }
}

/* Location:
 * Qualified Name:     ays
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */