import android.database.Cursor;

public final class bif
{
  public final String a;
  public final String b;
  public final int c;
  public final String d;
  public final long e;
  public final Long f;
  public final long g;
  public final String h;
  public final int i;
  public final String j;
  
  public bif(Cursor paramCursor, Long paramLong)
  {
    a = paramCursor.getString(0);
    b = paramCursor.getString(1);
    c = paramCursor.getInt(2);
    d = paramCursor.getString(3);
    e = paramCursor.getLong(4);
    f = paramLong;
    g = paramCursor.getLong(5);
    h = paramCursor.getString(6);
    i = paramCursor.getInt(7);
    j = paramCursor.getString(8);
  }
}

/* Location:
 * Qualified Name:     bif
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */