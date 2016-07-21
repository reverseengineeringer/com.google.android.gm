import android.os.AsyncTask;
import android.webkit.JavascriptInterface;
import com.google.android.gm.welcome.ChangeAddressActivity;

public final class eah
{
  public eah(ChangeAddressActivity paramChangeAddressActivity) {}
  
  @JavascriptInterface
  public final void notifyAddressChangeCancelled()
  {
    a.a();
    dri.b(ChangeAddressActivity.a, "Account Central reported address change cancelled", new Object[0]);
  }
  
  @JavascriptInterface
  public final void notifyAddressChangedSuccess(String paramString)
  {
    a.g = paramString;
    dri.b(ChangeAddressActivity.a, "Successful address change reported by Account Central: %s -> %s", new Object[] { dri.a(a.b), dri.a(a.g) });
    AsyncTask.execute(new eai(a.getApplicationContext(), a.b));
  }
}

/* Location:
 * Qualified Name:     eah
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */