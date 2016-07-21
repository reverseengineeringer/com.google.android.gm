import android.webkit.CookieManager;

final class gjc
  implements Runnable
{
  gjc(giz paramgiz, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void run()
  {
    giz localgiz = c;
    Object localObject = CookieManager.getInstance();
    String str = String.valueOf(b.c);
    if (str.length() != 0) {
      "Looking for cookie on URL=".concat(str);
    }
    for (;;)
    {
      localObject = ((CookieManager)localObject).getCookie(b.c);
      b.a((String)localObject);
      c.a.onSurveyComplete(a, b);
      return;
      new String("Looking for cookie on URL=");
    }
  }
}

/* Location:
 * Qualified Name:     gjc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */