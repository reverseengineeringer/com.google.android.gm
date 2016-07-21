import android.database.Cursor;

public final class baz
{
  public static final String[] a = { "_id", "flagRead", "flagFavorite", "flagLoaded", "syncServerId", "flags", "timeStamp" };
  public final long b;
  public final boolean c;
  public final boolean d;
  public final int e;
  public final String f;
  public final int g;
  public final long h;
  
  public baz(Cursor paramCursor)
  {
    b = paramCursor.getLong(0);
    if (paramCursor.getInt(1) != 0)
    {
      bool1 = true;
      c = bool1;
      if (paramCursor.getInt(2) == 0) {
        break label102;
      }
    }
    label102:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      d = bool1;
      e = paramCursor.getInt(3);
      f = paramCursor.getString(4);
      g = paramCursor.getInt(5);
      h = paramCursor.getLong(6);
      return;
      bool1 = false;
      break;
    }
  }
}

/* Location:
 * Qualified Name:     baz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */