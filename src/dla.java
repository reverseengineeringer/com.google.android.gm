import android.app.Activity;
import android.content.Intent;
import android.webkit.JavascriptInterface;

final class dla
{
  private final Activity a;
  private final String b;
  
  public dla(Activity paramActivity, String paramString)
  {
    a = paramActivity;
    b = paramString;
  }
  
  @JavascriptInterface
  public final void notifyClose()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("email", b);
    a.setResult(-1, localIntent);
    a.finish();
  }
}

/* Location:
 * Qualified Name:     dla
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */