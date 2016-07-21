import android.database.Cursor;
import android.database.CursorWrapper;
import com.android.mail.providers.Attachment;
import java.util.HashMap;
import java.util.Map;

public final class bvp
  extends CursorWrapper
{
  public final Map<String, Attachment> a = new HashMap();
  
  bvp(Cursor paramCursor)
  {
    super(paramCursor);
  }
}

/* Location:
 * Qualified Name:     bvp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */