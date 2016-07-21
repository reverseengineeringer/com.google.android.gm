import android.database.Cursor;
import android.database.CursorWrapper;
import android.os.Bundle;

public final class ect
  extends CursorWrapper
{
  public ect(Cursor paramCursor, Bundle paramBundle)
  {
    super(paramCursor);
  }
  
  public final Bundle getExtras()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     ect
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */