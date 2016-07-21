import android.content.ContentQueryMap;
import android.database.Cursor;

final class dqe
  extends ContentQueryMap
{
  public dqe(Cursor paramCursor, String paramString)
  {
    super(paramCursor, paramString, true, null);
    super.setKeepUpdated(false);
  }
  
  public final void setKeepUpdated(boolean paramBoolean) {}
}

/* Location:
 * Qualified Name:     dqe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */