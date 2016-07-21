import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.Mailbox;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import org.apache.http.HttpEntity;

public final class bpw
  extends bqc
{
  private static final String a = cvl.a;
  private final long b;
  
  public bpw(Context paramContext, Account paramAccount, long paramLong)
  {
    super(paramContext, paramAccount);
    b = paramLong;
  }
  
  private static long a(ContentValues paramContentValues, String paramString, long paramLong)
  {
    paramContentValues = paramContentValues.getAsLong(paramString);
    if (paramContentValues == null) {
      return paramLong;
    }
    return paramContentValues.longValue();
  }
  
  private static bdn a(InputStream paramInputStream)
  {
    try
    {
      Object localObject = new bcl(paramInputStream);
      paramInputStream = new ArrayList();
      bco.a((bdn)localObject, paramInputStream, new ArrayList());
      int i = 0;
      while (i < paramInputStream.size())
      {
        localObject = (bdn)paramInputStream.get(i);
        if (localObject != null)
        {
          boolean bool = ((bdn)localObject).e().contains("text/calendar");
          if (bool) {
            return (bdn)localObject;
          }
        }
        i += 1;
      }
      return null;
    }
    catch (bdi paramInputStream)
    {
      cvm.e(a, paramInputStream, "Error parsing MIME file.", new Object[0]);
      return null;
    }
    catch (IOException paramInputStream)
    {
      cvm.e(a, paramInputStream, "Error reading MIME stream.", new Object[0]);
    }
    return null;
  }
  
  public static void a(InputStream paramInputStream, beb parambeb)
  {
    ContentValues localContentValues = new ContentValues();
    paramInputStream = new BufferedInputStream(paramInputStream);
    new bth().a(paramInputStream, localContentValues);
    long l1 = a(localContentValues, "originalStart", 0L);
    long l2 = a(localContentValues, "originalEnd", 0L);
    long l3 = a(localContentValues, "dtstart", l1);
    long l4 = a(localContentValues, "dtend", l2);
    if (("COUNTER".equalsIgnoreCase(localContentValues.getAsString("method"))) && (l3 <= l4))
    {
      if (ad == null) {
        ad = localContentValues.getAsString("uid");
      }
      aq = l3;
      ar = l4;
      al = localContentValues.getAsString("title");
      am = localContentValues.getAsString("comment");
      ao = l1;
      ap = l2;
      an = localContentValues.getAsString("recurrenceRule");
    }
  }
  
  private final void c(int paramInt)
  {
    beb localbeb = beb.a(f, b);
    if (localbeb != null)
    {
      localbeb.d(paramInt);
      localbeb.h(f);
    }
  }
  
  protected final int a(bns parambns)
  {
    parambns = new bot(parambns.d(), f);
    parambns.d();
    parambns = a;
    beb localbeb;
    if (parambns != null)
    {
      parambns = a(new ByteArrayInputStream(parambns.getBytes(Charset.defaultCharset())));
      if (parambns != null) {
        localbeb = beb.a(f, b);
      }
    }
    try
    {
      a(parambns.a().g_(), localbeb);
      localbeb.h(f);
      return 0;
    }
    catch (bdi parambns)
    {
      cvm.e(a, parambns, "Event ICS file cannot be parsed.", new Object[0]);
    }
    return -101;
  }
  
  protected final String b()
  {
    return "ItemOperations";
  }
  
  protected final HttpEntity c()
  {
    beb localbeb = beb.a(f, b);
    if (localbeb != null)
    {
      Mailbox localMailbox = Mailbox.a(f, U);
      if (localMailbox != null)
      {
        bpi localbpi = new bpi();
        localbpi.a(1285);
        localbpi.a(1286);
        localbpi.b(1287, "Mailbox");
        if (!TextUtils.isEmpty(x))
        {
          localbpi.b(18, d);
          localbpi.b(13, x);
          localbpi.a(1288);
          localbpi.b(34, "2");
          if (h.e < 12.0D) {
            break label213;
          }
          localbpi.a(1093);
          localbpi.b(1094, "4");
          localbpi.b(1095, "200000");
          localbpi.b();
        }
        for (;;)
        {
          localbpi.b();
          localbpi.b();
          localbpi.b();
          localbpi.a();
          return a(localbpi);
          if (TextUtils.isEmpty(ag)) {
            break;
          }
          localbpi.b(984, ag);
          break;
          label213:
          localbpi.b(25, "7");
        }
      }
      cvm.b("Exchange", "Mailbox with id \"%d\" not found", new Object[] { Long.valueOf(U) });
    }
    for (;;)
    {
      return null;
      cvm.b("Exchange", "Message with id \"%d\" not found", new Object[] { Long.valueOf(b) });
    }
  }
  
  public final int p_()
  {
    c(16);
    int j = super.p_();
    if (j == 0) {}
    for (int i = 32;; i = 64)
    {
      c(i);
      return j;
    }
  }
}

/* Location:
 * Qualified Name:     bpw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */