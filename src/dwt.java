import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public final class dwt
  extends cro
  implements cru, dwn, dwp<List<crq>>
{
  private static final String e = cvl.a;
  private cjw f;
  private dwj<List<crq>> g;
  private boolean h;
  private DataSetObserver i = new dwu(this);
  
  public dwt(Context paramContext, cjw paramcjw, Bundle paramBundle)
  {
    super(paramContext);
    f = paramcjw;
    paramcjw = paramContext.getContentResolver();
    paramContext = new dwr(paramContext, this, paramBundle, "gmail", "Android Gmail");
    paramBundle = e;
    a.c = paramBundle;
    paramBundle = ghz.a(paramcjw, "gmail_asfe_suggestion_api_url_override", null);
    if (!TextUtils.isEmpty(paramBundle)) {
      a.d = paramBundle;
    }
    int j = ghz.a(paramcjw, "gmail_asfe_suggestion_connection_timeout_ms_override", -1);
    a.e = j;
    j = ghz.a(paramcjw, "gmail_asfe_suggestion_read_timeout_ms_override", -1);
    a.f = j;
    a.g = this;
    g = a;
  }
  
  private static boolean e()
  {
    return buo.a().a("asfe_timing_analytics", 1);
  }
  
  private static boolean f()
  {
    return buo.a().a("asfe_event_analytics", 1);
  }
  
  public final void a()
  {
    f.b(i);
    if (b != null) {
      b.g.remove(this);
    }
    super.a();
  }
  
  public final void a(long paramLong)
  {
    if (e()) {
      buo.a().a("search", paramLong, "asfe_req_duration", null);
    }
  }
  
  public final void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    dwj localdwj = g;
    if (!TextUtils.isEmpty(i)) {
      paramBundle.putString("asfeQueryController-current-account", i);
    }
  }
  
  public final void a(crr paramcrr, chc paramchc)
  {
    super.a(paramcrr, paramchc);
    f.a(i);
    b.a(this);
    d();
  }
  
  public final void a(IOException paramIOException)
  {
    if (f())
    {
      if ((paramIOException instanceof gqp))
      {
        Object localObject = a;
        paramIOException = buo.a();
        int j = code;
        localObject = String.valueOf(message);
        paramIOException.a("search", "asfe_request_json_exception_v2", String.valueOf(localObject).length() + 14 + j + " - " + (String)localObject, 0L);
      }
    }
    else {
      return;
    }
    buo.a().a("search", "asfe_request_io_exception_v2", dyu.a(paramIOException), 0L);
  }
  
  public final void a(CharSequence paramCharSequence, dwq<List<crq>> paramdwq)
  {
    boolean bool2 = h;
    boolean bool1;
    if ((paramdwq != null) && (a))
    {
      bool1 = true;
      h = (bool1 & bool2);
      if (!TextUtils.equals(b.a(), paramCharSequence)) {
        break label94;
      }
      if (!h) {
        break label89;
      }
    }
    label89:
    for (paramdwq = (List)b;; paramdwq = null)
    {
      d = paramdwq;
      notifyDataSetChanged();
      dri.a(e, "Suggestion results for '%s' displayed", new Object[] { paramCharSequence });
      return;
      bool1 = false;
      break;
    }
    label94:
    dri.a(e, "Suggestion results for '%s' ignored", new Object[] { paramCharSequence });
  }
  
  public final void a(String paramString)
  {
    if (paramString != null)
    {
      if (h) {
        g.a(paramString);
      }
    }
    else {
      return;
    }
    super.a(paramString);
  }
  
  public final void a(boolean paramBoolean)
  {
    but localbut;
    if (f())
    {
      localbut = buo.a();
      if (!paramBoolean) {
        break label32;
      }
    }
    label32:
    for (String str = "timed_out";; str = "ok")
    {
      localbut.a("search", "asfe_connection_timeout", str, 0L);
      return;
    }
  }
  
  protected final Cursor b(String paramString)
  {
    if (h) {
      return c.b(paramString);
    }
    return super.b(paramString);
  }
  
  public final String b()
  {
    if (h) {
      return "asfe_adapter";
    }
    return super.b();
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 != 0))
    {
      AsyncTask.execute(g.n);
      g.a(b.a());
    }
  }
  
  public final void b(long paramLong)
  {
    if (e()) {
      buo.a().a("search", paramLong, "asfe_user_query_duration", null);
    }
  }
  
  public final android.accounts.Account c()
  {
    com.android.mail.providers.Account localAccount = f.a();
    if (localAccount != null) {
      return localAccount.c();
    }
    return null;
  }
  
  final void d()
  {
    h = dyp.a(c());
    if (h) {
      g.a();
    }
  }
}

/* Location:
 * Qualified Name:     dwt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */