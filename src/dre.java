import android.content.Context;
import android.database.Cursor;
import java.util.Map;

final class dre
{
  final Context a;
  final String b;
  final int c;
  final int d;
  final int e;
  final int f;
  final int g;
  final int h;
  final int i;
  final int j;
  final int k;
  final int l;
  final Map<String, CharSequence> m;
  
  dre(Context paramContext, String paramString, Cursor paramCursor)
  {
    a = paramContext;
    b = paramString;
    c = paramCursor.getColumnIndexOrThrow("_id");
    d = paramCursor.getColumnIndexOrThrow("canonicalName");
    e = paramCursor.getColumnIndexOrThrow("name");
    f = paramCursor.getColumnIndexOrThrow("numConversations");
    g = paramCursor.getColumnIndexOrThrow("numUnreadConversations");
    h = paramCursor.getColumnIndexOrThrow("color");
    i = paramCursor.getColumnIndexOrThrow("hidden");
    j = paramCursor.getColumnIndexOrThrow("labelCountDisplayBehavior");
    k = paramCursor.getColumnIndexOrThrow("labelSyncPolicy");
    l = paramCursor.getColumnIndexOrThrow("lastTouched");
    m = dqz.a(paramContext);
  }
}

/* Location:
 * Qualified Name:     dre
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */