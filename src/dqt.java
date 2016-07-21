import android.database.Cursor;
import android.database.CursorWrapper;
import java.util.HashMap;

final class dqt
  extends CursorWrapper
{
  final int a;
  final int b;
  
  dqt(dqs paramdqs, Cursor paramCursor)
  {
    super(paramCursor);
    a = paramCursor.getColumnIndex("_id");
    b = paramCursor.getColumnIndex("snippet");
  }
  
  public final String getString(int paramInt)
  {
    if (paramInt == b)
    {
      long l = getLong(a);
      String str = (String)c.s.get(Long.valueOf(l));
      if (str != null) {
        return str;
      }
    }
    return super.getString(paramInt);
  }
}

/* Location:
 * Qualified Name:     dqt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */