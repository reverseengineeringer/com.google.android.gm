import android.os.Handler;
import android.webkit.JavascriptInterface;

public class giz
  implements giy
{
  private static final String f = giz.class.getSimpleName();
  final giy a;
  final gjm b;
  boolean c = false;
  public String d;
  public String e;
  private final Handler g;
  
  public giz(giy paramgiy, Handler paramHandler, gjm paramgjm)
  {
    a = paramgiy;
    g = paramHandler;
    b = paramgjm;
  }
  
  @JavascriptInterface
  public void onParamsLoaded(String paramString1, String paramString2)
  {
    new StringBuilder(String.valueOf(paramString1).length() + 42 + String.valueOf(paramString2).length()).append("Setting the params. survey=").append(paramString1).append(", surveySeries=").append(paramString2);
    d = paramString1;
    e = paramString2;
  }
  
  @JavascriptInterface
  public void onSurveyCanceled()
  {
    g.post(new gje(this));
  }
  
  @JavascriptInterface
  public void onSurveyComplete(boolean paramBoolean1, boolean paramBoolean2)
  {
    c = true;
    g.post(new gjc(this, paramBoolean1, paramBoolean2));
  }
  
  @JavascriptInterface
  public void onSurveyReady()
  {
    c = false;
    g.post(new gjb(this));
  }
  
  @JavascriptInterface
  public void onSurveyResponse(String paramString1, String paramString2)
  {
    if (!paramString1.contains("t=a")) {
      return;
    }
    g.post(new gjd(this, paramString1, paramString2));
  }
  
  @JavascriptInterface
  public void onWindowError()
  {
    c = false;
    g.post(new gja(this));
  }
}

/* Location:
 * Qualified Name:     giz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */