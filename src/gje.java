import android.webkit.CookieManager;

final class gje
  implements Runnable
{
  gje(giz paramgiz) {}
  
  public final void run()
  {
    giz localgiz = a;
    Object localObject = CookieManager.getInstance();
    String str = String.valueOf(b.c);
    if (str.length() != 0) {
      "Looking for cookie on URL=".concat(str);
    }
    for (;;)
    {
      localObject = ((CookieManager)localObject).getCookie(b.c);
      b.a((String)localObject);
      a.a.onSurveyCanceled();
      return;
      new String("Looking for cookie on URL=");
    }
  }
}

/* Location:
 * Qualified Name:     gje
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */