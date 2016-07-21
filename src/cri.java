import android.content.Context;
import android.database.Cursor;
import com.android.mail.providers.Folder;

public final class cri
  extends col
{
  public cri(Context paramContext, Cursor paramCursor, int paramInt, Folder paramFolder)
  {
    super(paramContext, paramCursor, paramInt, paramFolder);
  }
  
  protected final boolean a(Folder paramFolder)
  {
    if (paramFolder.a()) {
      return false;
    }
    return super.a(paramFolder);
  }
}

/* Location:
 * Qualified Name:     cri
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */