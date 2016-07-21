import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.net.Uri;
import android.text.TextUtils;
import com.android.emailcommon.provider.Attachment;

public final class azg
  extends CursorWrapper
{
  private final int a;
  private final int b;
  private final Context c;
  private final String[] d;
  
  public azg(Context paramContext, Cursor paramCursor)
  {
    super(paramCursor);
    a = paramCursor.getColumnIndex("contentUri");
    b = paramCursor.getColumnIndex("uri");
    c = paramContext;
    d = new String[paramCursor.getCount()];
    if (a == -1) {
      return;
    }
    while (paramCursor.moveToNext())
    {
      int i = paramCursor.getPosition();
      long l = Long.parseLong(Uri.parse(getString(b)).getLastPathSegment());
      Attachment localAttachment = Attachment.a(c, l);
      if (localAttachment == null)
      {
        d[i] = "";
      }
      else if (!TextUtils.isEmpty(n))
      {
        d[i] = n;
      }
      else
      {
        if ((w == 1) && (v == 3) && (TextUtils.equals(j, "application/vnd.android.package-archive"))) {
          paramContext = localAttachment.d();
        }
        for (;;)
        {
          d[i] = paramContext;
          break;
          String str = localAttachment.d();
          if (!TextUtils.isEmpty(str)) {}
          for (paramContext = Uri.parse(str).getAuthority();; paramContext = null)
          {
            if (!TextUtils.equals(paramContext, Attachment.e)) {
              break label235;
            }
            paramContext = str;
            break;
          }
          label235:
          paramContext = bgt.a(u, l).toString();
        }
      }
    }
    paramCursor.moveToPosition(-1);
  }
  
  public final String getString(int paramInt)
  {
    if (paramInt == a) {
      return d[getPosition()];
    }
    return super.getString(paramInt);
  }
}

/* Location:
 * Qualified Name:     azg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */