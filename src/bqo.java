import android.content.Context;
import android.text.TextUtils;
import com.android.emailcommon.provider.Account;
import java.io.IOException;
import org.apache.http.HttpEntity;

public abstract class bqo
  extends bqc
{
  public final int a;
  public final Long b;
  public final Long c;
  public final String d;
  public final String e;
  public final String k;
  public final String l;
  
  public bqo(Context paramContext, Account paramAccount, Integer paramInteger, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramContext, paramAccount);
    int i;
    if (paramInteger == null)
    {
      i = -1;
      a = i;
      if (paramLong1 != -1L) {
        break label93;
      }
      paramContext = null;
      label33:
      b = paramContext;
      if (paramLong2 != -1L) {
        break label102;
      }
    }
    label93:
    label102:
    for (paramContext = (Context)localObject;; paramContext = Long.valueOf(paramLong2))
    {
      c = paramContext;
      d = paramString1;
      e = paramString2;
      k = paramString3;
      l = paramString4;
      return;
      i = c(paramInteger.intValue());
      break;
      paramContext = Long.valueOf(paramLong1);
      break label33;
    }
  }
  
  protected final int a(bns parambns)
  {
    int i = b;
    if (i == 200) {
      if (!parambns.e())
      {
        parambns = parambns.d();
        if (parambns != null) {
          new bou(parambns).d();
        }
        j();
      }
    }
    while (parambns.b()) {
      return 0;
    }
    cvm.e("Exchange", "Meeting response request failed, code: %d", new Object[] { Integer.valueOf(i) });
    throw new IOException();
  }
  
  protected final String b()
  {
    return "MeetingResponse";
  }
  
  protected abstract int c(int paramInt);
  
  protected final HttpEntity c()
  {
    if ((a == -1) || (TextUtils.isEmpty(e)) || (TextUtils.isEmpty(k)))
    {
      cvm.e("Exchange", "Invalid meeting response. userResponse: %s, mailboxServerId: %s, meetingRequestServerId: %s.", new Object[] { Integer.valueOf(a), e, k });
      return null;
    }
    bpi localbpi = new bpi();
    localbpi.a(519);
    localbpi.a(521);
    localbpi.b(524, String.valueOf(a));
    localbpi.b(518, e);
    localbpi.b(520, k);
    localbpi.a(526, l);
    localbpi.b();
    localbpi.b();
    localbpi.a();
    return a(localbpi);
  }
  
  protected void j() {}
}

/* Location:
 * Qualified Name:     bqo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */