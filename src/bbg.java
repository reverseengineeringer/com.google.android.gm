import android.database.Cursor;

public final class bbg
{
  public static final String[] a = { "_id", "flagLoaded", "syncServerId" };
  public final long b;
  public final int c;
  public final String d;
  
  public bbg(Cursor paramCursor)
  {
    b = paramCursor.getLong(0);
    c = paramCursor.getInt(1);
    d = paramCursor.getString(2);
  }
}

/* Location:
 * Qualified Name:     bbg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */