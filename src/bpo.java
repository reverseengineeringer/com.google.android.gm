import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.Attachment;
import com.android.emailcommon.provider.Mailbox;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class bpo
  extends bqs
{
  static final String[] d = { "fileReference" };
  Map<String, bpq> a = new HashMap();
  Map<String, bpq> b = new HashMap();
  Map<String, Long> c = new HashMap();
  private long e;
  private String k;
  private String l;
  
  public bpo(Context paramContext, Account paramAccount)
  {
    super(paramContext, paramAccount);
    paramContext = Mailbox.b(paramContext, g.D, 3);
    if (paramContext != null)
    {
      e = paramContext.c();
      k = d;
      l = j;
    }
  }
  
  static bpp a(Context paramContext, Attachment paramAttachment)
  {
    int i = 0;
    InputStream localInputStream = paramAttachment.a(paramContext);
    Object localObject = null;
    paramContext = (Context)localObject;
    if (localInputStream != null) {}
    try
    {
      int j = localInputStream.available();
      i = j;
    }
    catch (IOException paramContext)
    {
      for (;;)
      {
        cvm.e("Exchange", "IOException when getting length for attachment with id %d", new Object[] { Long.valueOf(D) });
      }
    }
    paramContext = (Context)localObject;
    if (i > 0) {
      paramContext = new bpp(D, localInputStream, i);
    }
    return paramContext;
  }
  
  static String a(String paramString, long paramLong)
  {
    return String.format("%s_%d_%d", new Object[] { paramString, Long.valueOf(paramLong), Long.valueOf(System.currentTimeMillis()) });
  }
  
  private final void a(bpi parambpi, bpq parambpq)
  {
    if (TextUtils.isEmpty(t))
    {
      parambpi.a(7);
      parambpi.b(12, u);
      parambpi.a(29);
      parambpi.a(150, c);
      parambpi.a(151, d);
      parambpi.a(1430, e);
      parambpi.a(153, f);
      parambpi.a(148, g);
      if (TextUtils.isEmpty(o)) {
        break label396;
      }
      parambpi.a(1098);
      parambpi.b(1094, "2");
      parambpi.b(1099, o);
      parambpi.b();
    }
    for (;;)
    {
      label140:
      if (((s != null) && (!s.isEmpty())) || ((q != null) && (!q.isEmpty())))
      {
        parambpi.a(1102);
        Iterator localIterator = q.iterator();
        Object localObject;
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject = (Attachment)localIterator.next();
            bpp localbpp = (bpp)r.get(Long.valueOf(D));
            parambpi.a(1116);
            parambpi.b(1118, d);
            parambpi.a(1119);
            parambpi.a(b, c);
            idc.a(b);
            parambpi.b();
            parambpi.b(1104, i);
            parambpi.b(1106, "1");
            if (!TextUtils.isEmpty(l))
            {
              parambpi.b(1107, l);
              parambpi.b(1109);
            }
            parambpi.b();
            c.put(d, Long.valueOf(D));
            continue;
            parambpi.a(8);
            parambpi.b(13, t);
            break;
            label396:
            if (TextUtils.isEmpty(p)) {
              break label140;
            }
            parambpi.a(1098);
            parambpi.b(1094, "1");
            parambpi.b(1099, p);
            parambpi.b();
            break label140;
          }
        }
        localIterator = s.iterator();
        while (localIterator.hasNext())
        {
          localObject = (String)localIterator.next();
          parambpi.a(1117);
          parambpi.b(1105, (String)localObject);
          parambpi.b();
        }
        parambpi.b();
      }
    }
    parambpi.b(146, Integer.toString(h));
    parambpi.b(149, Integer.toString(j));
    a(parambpi, k);
    parambpi.b();
    if ((n & 0x80) != 0) {
      parambpi.b(1431);
    }
    parambpi.b();
  }
  
  protected final int a(bns parambns)
  {
    Mailbox localMailbox = Mailbox.a(f, e);
    if (localMailbox == null) {
      return 100;
    }
    parambns = new bom(f, f.getContentResolver(), parambns.d(), localMailbox, g, a, b, c);
    try
    {
      parambns.d();
      return 0;
    }
    catch (bno parambns)
    {
      cvm.e("Exchange", "EasDraftsSync had CommandStatusException with request: %s", new Object[] { f() });
      throw parambns;
    }
    catch (boz parambns)
    {
      for (;;) {}
    }
  }
  
  protected final bpi f()
  {
    if (((a == null) || (a.isEmpty())) && ((b == null) || (b.isEmpty()))) {
      throw new IllegalStateException("Should not upsync Drafts folder changes when there are none.");
    }
    bpi localbpi = new bpi();
    localbpi.a(5);
    localbpi.a(28);
    localbpi.a(15);
    localbpi.b(11, l);
    localbpi.b(18, k);
    localbpi.b(19, "1");
    localbpi.a(22);
    Iterator localIterator = a.values().iterator();
    while (localIterator.hasNext()) {
      a(localbpi, (bpq)localIterator.next());
    }
    localIterator = b.values().iterator();
    while (localIterator.hasNext()) {
      a(localbpi, (bpq)localIterator.next());
    }
    localbpi.b();
    localbpi.b();
    localbpi.b();
    localbpi.b();
    localbpi.a();
    return localbpi;
  }
  
  public final int o_()
  {
    if ((!bnq.d(g.l)) || (TextUtils.isEmpty(k)) || (TextUtils.isEmpty(l)) || (l.equals("0"))) {
      return 0;
    }
    for (;;)
    {
      try
      {
        localObject1 = f.getContentResolver().query(beb.a, beb.i, "accountKey=? AND mailboxKey IN (SELECT _id FROM Mailbox WHERE type = 3) AND flagLoaded IN (2,1,5, 6) AND timeStamp>draftUpsyncTimestamp", new String[] { String.valueOf(g.D) }, null);
        if (localObject1 == null) {
          continue;
        }
        try
        {
          if (!((Cursor)localObject1).moveToNext()) {
            continue;
          }
          localObject3 = new bpq(f, (Cursor)localObject1);
          if (!TextUtils.isEmpty(t)) {
            continue;
          }
          a.put(u, localObject3);
          continue;
        }
        finally
        {
          localObject3 = localObject1;
          localObject1 = localObject4;
        }
      }
      finally
      {
        Object localObject1;
        Object localObject3 = null;
        continue;
      }
      if (localObject3 != null) {
        ((Cursor)localObject3).close();
      }
      throw ((Throwable)localObject1);
      b.put(t, localObject3);
    }
    if (localObject1 != null) {
      ((Cursor)localObject1).close();
    }
    if ((!a.isEmpty()) || (!b.isEmpty())) {
      return p_();
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     bpo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */