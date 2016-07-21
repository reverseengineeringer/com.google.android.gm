import android.content.Context;
import android.text.TextUtils;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.RecipientAvailability;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.http.HttpEntity;

public final class bql
  extends bqc
{
  public List<RecipientAvailability> a;
  private final List<String> b;
  private final long c;
  private final long d;
  
  public bql(Context paramContext, Account paramAccount, List<String> paramList, long paramLong1, long paramLong2)
  {
    super(paramContext, paramAccount);
    b = paramList;
    c = paramLong1;
    d = paramLong2;
  }
  
  protected final int a(bns parambns)
  {
    parambns = parambns.d();
    try
    {
      bpf localbpf = new bpf(parambns);
      if (localbpf.d())
      {
        a = a;
        return 0;
      }
      return -99;
    }
    finally
    {
      parambns.close();
    }
  }
  
  protected final String b()
  {
    return "ResolveRecipients";
  }
  
  protected final HttpEntity c()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    bpi localbpi = new bpi();
    localbpi.a(645);
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!TextUtils.isEmpty(str)) {
        localbpi.b(656, str);
      }
    }
    localbpi.a(655).a(662).b(663, localSimpleDateFormat.format(new Date(c))).b(664, localSimpleDateFormat.format(new Date(d))).b().b().b().a();
    return a(localbpi);
  }
}

/* Location:
 * Qualified Name:     bql
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */