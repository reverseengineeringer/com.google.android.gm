import android.accounts.Account;
import android.content.ContentResolver;
import android.content.Context;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gm.provider.GmailProvider;

final class dsm
  extends dsy
  implements bwv
{
  boolean a = false;
  
  public dsm(drp paramdrp, SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery, dsz paramdsz)
  {
    super(paramdrp, paramSQLiteDatabase, paramSQLiteCursorDriver, paramString, paramSQLiteQuery, paramdsz);
  }
  
  public final void a()
  {
    Long localLong = null;
    Object localObject = (dsn)c;
    long l;
    String str;
    drk localdrk;
    drp localdrp;
    if (localObject != null)
    {
      l = k;
      str = c;
      localdrk = d;
      localdrp = b;
      if (localdrk != null) {
        break label63;
      }
      localObject = null;
      if (localdrk != null) {
        break label72;
      }
    }
    for (;;)
    {
      localdrp.a(l, str, (String)localObject, localLong, true);
      return;
      label63:
      localObject = b;
      break;
      label72:
      localLong = Long.valueOf(a);
    }
  }
  
  public final void b()
  {
    dsn localdsn = (dsn)c;
    long l;
    int i;
    if (localdsn != null)
    {
      l = k;
      i = GmailProvider.i(d.b);
      if ((i & 0x40) == 0) {
        break label106;
      }
    }
    for (String str = "emptySpam";; str = "emptyTrash")
    {
      b.n.a(str, 0L, l, 0L, null, null, null, null, 0L, 0, 0L);
      b.k.getContentResolver().notifyChange(dpy.a(b.l.name), null, true);
      i = true;
      localdsn.i();
      return;
      label106:
      if ((i & 0x20) == 0) {
        break;
      }
    }
    dri.d("CursorLogic", "We just tried to empty a folder that is not spam or trash. Folder type was %d", new Object[] { Integer.valueOf(i) });
  }
  
  final dsn c()
  {
    synchronized (d)
    {
      dsn localdsn = (dsn)c;
      if (localdsn.c()) {
        return localdsn;
      }
      return null;
    }
  }
  
  public final boolean onMove(int paramInt1, int paramInt2)
  {
    synchronized (d)
    {
      dsn localdsn = (dsn)c;
      if (h) {
        localdsn.a(paramInt2, this);
      }
      return super.onMove(paramInt1, paramInt2);
    }
  }
  
  public final Bundle respond(Bundle arg1)
  {
    ??? = ???.getString("command");
    Bundle localBundle1 = new Bundle();
    if (("setVisible".equals(???)) && (!???.getBoolean("visible")))
    {
      localBundle1.putString("commandResponse", "ok");
      return localBundle1;
    }
    if ("setUIPosition".equals(???))
    {
      int i = ???.getInt("position");
      dri.b(drp.b, "ConversationCursorLogic#respond Set position: %d", new Object[] { Integer.valueOf(i) });
      synchronized (d)
      {
        ((dsn)c).a(i, this);
        localBundle1.putString("commandResponse", "ok");
        return localBundle1;
      }
    }
    if ("activate".equals(???)) {
      synchronized (d)
      {
        ??? = (dsn)c;
        String str = c;
        if (!TextUtils.equals(b.Y, str))
        {
          ??? = "failed";
          dri.c(drp.b, "ignoring request to re-enable stale cursor: %s", new Object[] { str });
          localBundle2.putString("commandResponse", ???);
          return localBundle2;
        }
        a = true;
        ??? = "ok";
      }
    }
    if ("deactivate".equals(???)) {
      synchronized (d)
      {
        ??? = (dsn)c;
        if (((dsn)???).c())
        {
          a = false;
          localBundle2.putString("commandResponse", "ok");
          return localBundle2;
        }
        localBundle2.putString("commandResponse", "failed");
      }
    }
    if ("setVisible".equals(???))
    {
      ??? = c();
      if (??? != null) {
        ???.j();
      }
      localBundle3.putString("commandResponse", "ok");
      return localBundle3;
    }
    return super.respond(???);
  }
}

/* Location:
 * Qualified Name:     dsm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */