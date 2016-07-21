import android.content.Context;
import android.text.TextUtils;

public final class dlp
  implements Runnable
{
  private static final String a = cvl.a;
  private final Context b;
  private final String c;
  private final String d;
  
  public dlp(Context paramContext, String paramString1, String paramString2)
  {
    b = paramContext.getApplicationContext();
    c = paramString1;
    d = paramString2;
  }
  
  public final void run()
  {
    Object localObject = drp.b(b, c);
    if (localObject == null)
    {
      cvm.f(a, new NullPointerException("MailEngine is null"), "Gmailify", new Object[0]);
      return;
    }
    localObject = o;
    if (TextUtils.isEmpty(d))
    {
      ((drj)localObject).k();
      return;
    }
    ((drj)localObject).g(d);
  }
}

/* Location:
 * Qualified Name:     dlp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */