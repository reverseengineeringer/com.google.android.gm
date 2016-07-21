import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.Mailbox;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import org.apache.http.HttpEntity;

public class bqs
  extends bqc
{
  private boolean a = false;
  private long b;
  private String c;
  private String d;
  private List<beg> e;
  private Map<String, Integer> k;
  
  public bqs(Context paramContext, Account paramAccount)
  {
    super(paramContext, paramAccount);
  }
  
  private static String a(Calendar paramCalendar)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramCalendar.get(1));
    localStringBuilder.append('-');
    localStringBuilder.append(String.format(Locale.US, "%02d", new Object[] { Integer.valueOf(paramCalendar.get(2) + 1) }));
    localStringBuilder.append('-');
    localStringBuilder.append(String.format(Locale.US, "%02d", new Object[] { Integer.valueOf(paramCalendar.get(5)) }));
    localStringBuilder.append('T');
    localStringBuilder.append(String.format(Locale.US, "%02d", new Object[] { Integer.valueOf(paramCalendar.get(11)) }));
    localStringBuilder.append(':');
    localStringBuilder.append(String.format(Locale.US, "%02d", new Object[] { Integer.valueOf(paramCalendar.get(12)) }));
    localStringBuilder.append(':');
    localStringBuilder.append(String.format(Locale.US, "%02d", new Object[] { Integer.valueOf(paramCalendar.get(13)) }));
    localStringBuilder.append(".000Z");
    return localStringBuilder.toString();
  }
  
  protected static void a(bpi parambpi, int paramInt)
  {
    if (paramInt != 0)
    {
      parambpi.a(186).b(187, "2");
      parambpi.b(189, "FollowUp");
      long l = System.currentTimeMillis();
      Object localObject = GregorianCalendar.getInstance(TimeZone.getTimeZone("GMT"));
      ((Calendar)localObject).setTimeInMillis(l);
      String str = a((Calendar)localObject);
      parambpi.b(606, str).b(607, str);
      ((Calendar)localObject).setTimeInMillis(l + 604800000L);
      localObject = a((Calendar)localObject);
      parambpi.b(588, (String)localObject).b(589, (String)localObject);
      parambpi.b();
      return;
    }
    parambpi.b(186);
  }
  
  protected int a(bns parambns)
  {
    Mailbox localMailbox = Mailbox.a(f, b);
    if (localMailbox == null) {
      return 100;
    }
    parambns = new bom(f, f.getContentResolver(), parambns.d(), localMailbox, g);
    try
    {
      parambns.d();
      k = i;
      return 0;
    }
    catch (bno parambns)
    {
      throw parambns;
    }
    catch (boz parambns)
    {
      for (;;) {}
    }
  }
  
  protected final String b()
  {
    return "Sync";
  }
  
  protected final HttpEntity c()
  {
    return a(f());
  }
  
  bpi f()
  {
    bpi localbpi = new bpi();
    localbpi.a(5);
    localbpi.a(28);
    Object localObject1 = c;
    Object localObject2 = d;
    List localList = e;
    localbpi.a(15);
    if (h.e < 12.1D) {
      localbpi.b(16, bnq.a(1));
    }
    localbpi.b(11, (String)localObject2);
    localbpi.b(18, (String)localObject1);
    if (h.e >= 12.0D) {
      localbpi.b(19, "0");
    }
    localbpi.a(22);
    localObject1 = localList.iterator();
    int i = 0;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (beg)((Iterator)localObject1).next();
      localbpi.a(8);
      localbpi.b(13, e);
      localbpi.a(29);
      int j = ((beg)localObject2).a();
      if (j != -1)
      {
        localbpi.b(149, Integer.toString(j));
        i = 1;
      }
      j = ((beg)localObject2).b();
      if (j == -1) {
        break label267;
      }
      a(localbpi, j);
      i = 1;
    }
    label267:
    for (;;)
    {
      localbpi.b().b();
      break;
      localbpi.b().b();
      if (i == 0) {
        throw new bqd(this, "Not a valid upsync request");
      }
      localbpi.b().b().a();
      return localbpi;
    }
  }
  
  public int o_()
  {
    Object localObject1 = f;
    long l = g.D;
    if (h.e < 12.0D) {}
    Object localObject5;
    int j;
    for (boolean bool = true;; bool = false)
    {
      localObject5 = beg.a((Context)localObject1, l, bool);
      if (localObject5 != null) {
        break;
      }
      j = 0;
      return j;
    }
    if (localObject5 == null) {
      localObject1 = null;
    }
    Object localObject6;
    Object localObject7;
    while (localObject1 == null)
    {
      return 0;
      localObject3 = new nx();
      localObject6 = ((List)localObject5).iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = (beg)((Iterator)localObject6).next();
        localObject4 = (List)((nx)localObject3).a(h, null);
        localObject1 = localObject4;
        if (localObject4 == null)
        {
          localObject1 = new ArrayList();
          ((nx)localObject3).b(h, localObject1);
        }
        ((List)localObject1).add(localObject7);
      }
      if (((nx)localObject3).a() == 0) {
        localObject1 = null;
      } else {
        localObject1 = localObject3;
      }
    }
    int i = ((List)localObject5).size();
    Object localObject3 = (long[][])Array.newInstance(Long.TYPE, new int[] { 2, i });
    Object localObject4 = new int[2];
    int m = 0;
    i = 0;
    label232:
    int n;
    if (m < ((nx)localObject1).a())
    {
      b = ((nx)localObject1).b(m);
      e = ((List)((nx)localObject1).c(m));
      n = 1;
      if (i < 0) {
        break label835;
      }
      localObject5 = f.getContentResolver().query(ContentUris.withAppendedId(Mailbox.a, b), bea.a, null, null, null);
      if (localObject5 == null) {
        break label835;
      }
      j = i;
    }
    for (;;)
    {
      try
      {
        if (!((Cursor)localObject5).moveToFirst()) {
          break label830;
        }
        c = ((Cursor)localObject5).getString(0);
        d = ((Cursor)localObject5).getString(1);
        if ((TextUtils.isEmpty(d)) || (d.equals("0")))
        {
          cvm.b("Exchange", "Tried to sync mailbox %d with invalid mailbox sync key", new Object[] { Long.valueOf(b) });
          n = 1;
          j = i;
          i = n;
          ((Cursor)localObject5).close();
          n = i;
          i = j;
          if (n == 0) {
            break label777;
          }
          localObject5 = e.iterator();
          if (!((Iterator)localObject5).hasNext()) {
            break label777;
          }
          localObject6 = (beg)((Iterator)localObject5).next();
          localObject3[1][localObject4[1]] = d;
          localObject4[1] += 1;
          continue;
        }
        n = p_();
        j = n;
        if (n < 0) {
          break label830;
        }
        if (n != 0) {
          break label680;
        }
        localObject6 = k.entrySet().iterator();
        if (!((Iterator)localObject6).hasNext()) {
          break label672;
        }
        Object localObject8 = (Map.Entry)((Iterator)localObject6).next();
        localObject7 = (String)((Map.Entry)localObject8).getKey();
        if (bnp.e(((Integer)((Map.Entry)localObject8).getValue()).intValue()))
        {
          i = 1;
          localObject8 = e.iterator();
          if (!((Iterator)localObject8).hasNext()) {
            break label664;
          }
          beg localbeg = (beg)((Iterator)localObject8).next();
          if (!e.equals(localObject7)) {
            continue;
          }
          l = d;
          if (l == -1L) {
            continue;
          }
          localObject3[i][localObject4[i]] = l;
          localObject4[i] += 1;
          continue;
        }
        i = 0;
      }
      finally
      {
        ((Cursor)localObject5).close();
      }
      continue;
      label664:
      l = -1L;
      continue;
      label672:
      i = 0;
      j = n;
      continue;
      label680:
      if (n == 100)
      {
        localObject6 = e.iterator();
        while (((Iterator)localObject6).hasNext())
        {
          localObject7 = (beg)((Iterator)localObject6).next();
          localObject3[0][localObject4[0]] = d;
          localObject4[0] += 1;
        }
      }
      cvm.f("Exchange", "Unrecognized result code: %d", new Object[] { Integer.valueOf(n) });
      i = 0;
      j = n;
      continue;
      label777:
      m += 1;
      break label232;
      ContentResolver localContentResolver = f.getContentResolver();
      beg.a(localContentResolver, localObject3[0], localObject4[0]);
      beg.b(localContentResolver, localObject3[1], localObject4[1]);
      j = i;
      if (i < 0) {
        break;
      }
      return localObject4[0];
      label830:
      i = 1;
      continue;
      label835:
      continue;
      i = 0;
      j = n;
    }
  }
  
  protected final long p()
  {
    if (a) {
      return 120000L;
    }
    return super.p();
  }
}

/* Location:
 * Qualified Name:     bqs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */