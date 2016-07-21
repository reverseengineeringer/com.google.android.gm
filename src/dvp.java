import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils.SimpleStringSplitter;
import android.util.SparseArray;
import com.android.mail.providers.ConversationInfo;
import com.android.mail.providers.Folder;
import com.android.mail.providers.FolderList;
import com.android.mail.providers.ParticipantInfo;
import com.google.android.gm.provider.GmailProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class dvp
  extends dvr
{
  private static final cwi<duq> E = new cwi(new dvq());
  private final Map<String, dqz> A = new HashMap();
  private String B;
  private final nx<Folder> C = new nx();
  private final HashMap<String, String[]> D = new HashMap();
  private final String c;
  private final String d;
  private final int e;
  private final int f;
  private final int g;
  private final int h;
  private final int i;
  private final int j;
  private final int k;
  private final int l;
  private final int m;
  private final int n;
  private final int o;
  private final int p;
  private final int q;
  private final int r;
  private final int s;
  private final int t;
  private final int u;
  private final int v;
  private final int w;
  private final String x;
  private final Map<String, dqz> y = new HashMap();
  private boolean z = false;
  
  public dvp(Cursor paramCursor, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    super(paramCursor, paramArrayOfString);
    c = paramString1;
    d = paramString2;
    e = paramCursor.getColumnIndexOrThrow("_id");
    f = paramCursor.getColumnIndexOrThrow("subject");
    g = paramCursor.getColumnIndexOrThrow("snippet");
    h = paramCursor.getColumnIndexOrThrow("fromAddress");
    i = paramCursor.getColumnIndex("fromProtoBuf");
    j = paramCursor.getColumnIndex("fromCompact");
    k = paramCursor.getColumnIndex("date");
    l = paramCursor.getColumnIndexOrThrow("personalLevel");
    m = paramCursor.getColumnIndexOrThrow("numMessages");
    n = paramCursor.getColumnIndexOrThrow("hasAttachments");
    o = paramCursor.getColumnIndex("conversationLabels");
    p = paramCursor.getColumnIndex("synced");
    q = paramCursor.getColumnIndex("sortMessageId");
    r = paramCursor.getColumnIndex("promoteCalendar");
    s = paramCursor.getColumnIndex("unsubscribeSenderName");
    t = paramCursor.getColumnIndex("unsubscribeSenderIdentifier");
    u = paramCursor.getColumnIndex("isSenderUnsubscribed");
    v = paramCursor.getColumnIndex("fromCompactV2");
    w = paramCursor.getColumnIndexOrThrow("hasCalendarInvite");
    x = GmailProvider.a().toString();
  }
  
  private final void b()
  {
    if (!z)
    {
      Map localMap = A;
      cxa.g("loadLabels");
      drd.a(c, super.getString(o), localMap, y);
      cxa.a();
      B = a(g);
      z = true;
    }
  }
  
  private final ConversationInfo c()
  {
    ??? = null;
    Object localObject1 = super.getBlob(v);
    int i3 = super.getInt(m);
    ConversationInfo localConversationInfo1 = new ConversationInfo(i3);
    duq localduq = (duq)E.a();
    boolean bool2;
    boolean bool1;
    for (;;)
    {
      try
      {
        localduq.a();
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          cxa.g("parseCSI-ssv2");
          dpo.a((byte[])localObject1, localduq, true);
          cxa.a();
          localObject1 = B;
          bool2 = A.containsKey("^u");
          i1 = c;
          a.clear();
          b = i3;
          c = i1;
          d = ((String)localObject1);
          e = ((String)localObject1);
          localObject1 = a.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label777;
          }
          ??? = (dur)((Iterator)localObject1).next();
          if (d != 0) {
            continue;
          }
          if (!bool2) {
            c = false;
          }
          if (c) {
            break label771;
          }
          bool1 = true;
          label198:
          localConversationInfo1.a(new ParticipantInfo(a, b, e, bool1, f));
          continue;
        }
        localObject3 = super.getBlob(j);
      }
      finally
      {
        E.a(localduq);
      }
      if ((localObject3 != null) && (localObject3.length > 0))
      {
        cxa.g("parseCSI-ss");
        dpo.a((byte[])localObject3, localduq, false);
      }
      else
      {
        localObject6 = super.getBlob(i);
        cxa.g("parseCSI-proto");
        localObject3 = ???;
        if (localObject6 != null)
        {
          localObject3 = ???;
          if (localObject6.length > 0) {
            localObject3 = dpo.a((byte[])localObject6);
          }
        }
        if (localObject3 == null) {
          break;
        }
        dpo.a((gzn)localObject3, localduq);
      }
    }
    Object localObject6 = a(h);
    Object localObject3 = (List)dpo.b.a();
    try
    {
      ((List)localObject3).clear();
      synchronized (dpo.a)
      {
        dpo.a.setString((String)localObject6);
        if (dpo.a.hasNext()) {
          ((List)localObject3).add(dpo.a.next());
        }
      }
    }
    finally
    {
      dpo.b.a(localObject3);
    }
    int i1 = 0;
    for (;;)
    {
      int i2;
      String str;
      if (i1 < ((List)localObject3).size())
      {
        i2 = i1 + 1;
        str = (String)((List)localObject3).get(i1);
        if (("".equals(str)) || ("e".equals(str))) {
          break label788;
        }
        if ("n".equals(str))
        {
          i1 = i2 + 1;
          continue;
        }
        if ("d".equals(str))
        {
          if (i2 < ((List)localObject3).size())
          {
            c = Integer.parseInt((String)((List)localObject3).get(i2));
            i1 = i2 + 1;
          }
        }
        else
        {
          if (!"l".equals(str)) {
            break label644;
          }
          if (i2 < ((List)localObject3).size())
          {
            str = Html.fromHtml((String)((List)localObject3).get(i2)).toString();
            if (str.length() != 0) {
              break label638;
            }
            bool1 = true;
            label607:
            localduq.a(str, str, false, false, bool1, -1, 0);
          }
        }
      }
      label638:
      label644:
      do
      {
        dpo.b.a(localObject3);
        localduq.b();
        break;
        bool1 = false;
        break label607;
        if (("s".equals(str)) || ("f".equals(str))) {
          break label788;
        }
      } while (i2 + 2 > ((List)localObject3).size());
      if (Integer.parseInt(str) != 0)
      {
        bool1 = true;
        label690:
        i1 = i2 + 1;
        str = (String)((List)localObject3).get(i2);
        localObject6 = (String)((List)localObject3).get(i1);
        i2 = Integer.parseInt(str);
        if (((String)localObject6).length() != 0) {
          break label765;
        }
      }
      label765:
      for (bool2 = true;; bool2 = false)
      {
        localduq.a((String)localObject6, null, false, bool1, bool2, i2, 0);
        i1 += 1;
        break;
        bool1 = false;
        break label690;
      }
      label771:
      bool1 = false;
      break label198;
      label777:
      E.a(localduq);
      return localConversationInfo2;
      label788:
      i1 = i2;
    }
  }
  
  private final long d()
  {
    return super.getLong(e);
  }
  
  protected final void a()
  {
    super.a();
    A.clear();
    z = false;
  }
  
  public final byte[] getBlob(int paramInt)
  {
    dri.e("Gmail", "UIConversationCursor.getBlob(%d): Unexpected column", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public final Bundle getExtras()
  {
    Bundle localBundle1 = super.getExtras();
    Bundle localBundle2 = new Bundle(localBundle1);
    int i1 = localBundle1.getInt("status");
    localBundle2.putInt("cursor_status", ((Integer)a.get(i1)).intValue());
    localBundle2.putInt("cursor_total_count", -1);
    return localBundle2;
  }
  
  public final int getInt(int paramInt)
  {
    int i3 = 1;
    int i2 = 0;
    b();
    int i1 = i2;
    switch (paramInt)
    {
    case 15: 
    case 19: 
    case 22: 
    case 23: 
    case 24: 
    case 26: 
    case 29: 
    case 30: 
    default: 
      dri.e("Gmail", "UIConversationCursor.getInt(%d): Unexpected column", new Object[] { Integer.valueOf(paramInt) });
      i1 = super.getInt(paramInt);
    case 21: 
    case 33: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 18: 
    case 20: 
    case 16: 
    case 17: 
    case 25: 
    case 27: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              return i1;
                              return super.getInt(n);
                              return super.getInt(m);
                              i1 = i2;
                            } while (!A.containsKey("^r"));
                            return 1;
                            if (A.containsKey("^^out"))
                            {
                              if (A.containsKey("^^failed")) {
                                return -1;
                              }
                              if (A.containsKey("^^sending")) {
                                return 2;
                              }
                              return 1;
                            }
                            i1 = i2;
                          } while (!A.containsKey("^f"));
                          return 3;
                          i1 = i2;
                        } while (!A.containsKey("^io_im"));
                        return 1;
                        i1 = i2;
                      } while (A.containsKey("^u"));
                      return 1;
                      i1 = i2;
                    } while (A.containsKey("^us"));
                    return 1;
                    i1 = i2;
                  } while (!A.containsKey("^t"));
                  return 1;
                  i1 = i2;
                } while (!A.containsKey("^s"));
                return 1;
                i1 = i2;
              } while (!A.containsKey("^g"));
              return 1;
              i1 = i2;
            } while (super.getInt(w) == 0);
            return 16;
            paramInt = dpy.a(super.getInt(l));
            i1 = i2;
            switch (paramInt)
            {
            case 0: 
            default: 
              throw new IllegalArgumentException(40 + "PersonalLevel doesn't exist: " + paramInt);
            case 2: 
              return 2;
            }
            return 1;
            i1 = i2;
          } while (super.getInt(p) != 0);
          return 1;
          i1 = i2;
        } while (A.containsKey("^sq_ig_i_promo"));
        i1 = i2;
      } while (A.containsKey("^sq_ig_i_group"));
      long l1 = getLong(0);
      paramInt = super.getInt(r);
      dyb.a(l1, paramInt);
      return paramInt;
    case 28: 
      if (super.getLong(u) != 0L) {}
      for (paramInt = i3; paramInt != 0; paramInt = 0) {
        return 3;
      }
      return GmailProvider.a(A);
    case 31: 
      return 1;
    }
    return GmailProvider.b(A);
  }
  
  public final long getLong(int paramInt)
  {
    b();
    switch (paramInt)
    {
    default: 
      dri.e("Gmail", "UIConversationCursor.getLong(%d): Unexpected column", new Object[] { Integer.valueOf(paramInt) });
      return super.getLong(paramInt);
    case 0: 
      return d();
    case 6: 
      return super.getLong(k);
    }
    return super.getLong(q);
  }
  
  public final String getString(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 3) && (paramInt != 2)) {
      b();
    }
    switch (paramInt)
    {
    default: 
      dri.e("Gmail", "UIConversationCursor.getString(%d): Unexpected column", new Object[] { Integer.valueOf(paramInt) });
      return super.getString(paramInt);
    case 1: 
      return GmailProvider.b(c, d());
    case 3: 
      return a(f);
    case 4: 
      return B;
    case 2: 
      return GmailProvider.c(c, d()).toString();
    case 23: 
      return null;
    case 22: 
      return d;
    case 24: 
      return x;
    case 29: 
      return super.getString(s);
    }
    return super.getString(t);
  }
  
  public final Bundle respond(Bundle paramBundle)
  {
    Bundle localBundle = new Bundle(1);
    if (paramBundle.containsKey("setVisibility"))
    {
      boolean bool = paramBundle.getBoolean("setVisibility");
      if (bool)
      {
        localObject = new Bundle(2);
        ((Bundle)localObject).putString("command", "setVisible");
        ((Bundle)localObject).putBoolean("visible", bool);
        if (!"ok".equals(super.respond((Bundle)localObject).getString("commandResponse"))) {
          break label266;
        }
        localObject = "ok";
        localBundle.putString("setVisibility", (String)localObject);
      }
    }
    if (paramBundle.containsKey("uiPositionChange"))
    {
      int i1 = paramBundle.getInt("uiPositionChange");
      localObject = new Bundle(2);
      ((Bundle)localObject).putString("command", "setUIPosition");
      ((Bundle)localObject).putInt("position", i1);
      if (!"ok".equals(super.respond((Bundle)localObject).getString("commandResponse"))) {
        break label274;
      }
    }
    label266:
    label274:
    for (Object localObject = "ok";; localObject = "failed")
    {
      localBundle.putString("uiPositionChange", (String)localObject);
      if (paramBundle.containsKey("conversationInfo"))
      {
        b();
        localBundle.putParcelable("conversationInfo", c());
      }
      if (paramBundle.containsKey("rawFolders"))
      {
        b();
        cxa.g("getRawFolders");
        paramBundle = GmailProvider.a(c, A, C, D);
        cxa.a();
        localBundle.putParcelable("rawFolders", FolderList.a(paramBundle));
      }
      return localBundle;
      localObject = "failed";
      break;
    }
  }
}

/* Location:
 * Qualified Name:     dvp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */