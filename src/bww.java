import android.database.Cursor;
import android.database.CursorWrapper;

public final class bww
{
  public static void a(Cursor paramCursor)
  {
    for (;;)
    {
      if (paramCursor == null) {}
      do
      {
        return;
        if ((paramCursor instanceof bwv))
        {
          ((bwv)paramCursor).a();
          return;
        }
      } while (!(paramCursor instanceof CursorWrapper));
      paramCursor = ((CursorWrapper)paramCursor).getWrappedCursor();
    }
  }
  
  public static void b(Cursor paramCursor)
  {
    for (;;)
    {
      if (paramCursor == null) {}
      do
      {
        return;
        if ((paramCursor instanceof bwv))
        {
          ((bwv)paramCursor).b();
          return;
        }
      } while (!(paramCursor instanceof CursorWrapper));
      paramCursor = ((CursorWrapper)paramCursor).getWrappedCursor();
    }
  }
}

/* Location:
 * Qualified Name:     bww
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */