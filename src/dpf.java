import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import com.google.android.gm.provider.uiprovider.GmailAttachment;
import java.util.HashMap;
import java.util.Map;

public final class dpf
{
  public static final String a = cvl.a;
  private static final String[] k = { "messages_messageId", "messages_partId", "downloadId", "mimeType", "saveToSd", "filename", "status", "desiredRendition", "originExtras" };
  final String b;
  public final long c;
  final Map<Long, GmailAttachment> d;
  public final Loader<Cursor> e;
  public final dpm f;
  final drp g;
  final dpa h;
  public dph i;
  public boolean j;
  
  public dpf(Context paramContext, String paramString, long paramLong, drp paramdrp)
  {
    dri.b(a, "ASL constructor for conversation %d", new Object[] { Long.valueOf(paramLong) });
    b = paramString;
    c = paramLong;
    d = new HashMap();
    e = new CursorLoader(paramContext, dpy.a(b, c), k, null, null, null);
    e.registerListener(e.getId(), new dpg(this));
    f = new dpm(this, paramContext);
    f.registerListener(e.getId(), new dpj(this));
    g = paramdrp;
    h = w;
    i = null;
    j = false;
  }
}

/* Location:
 * Qualified Name:     dpf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */