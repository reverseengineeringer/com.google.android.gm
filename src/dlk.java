import android.app.Activity;
import android.webkit.JavascriptInterface;

final class dlk
{
  final dli a;
  
  public dlk(dli paramdli)
  {
    a = paramdli;
  }
  
  @JavascriptInterface
  public final void notifyPairingFailure(int paramInt, String paramString1, String paramString2)
  {
    a.getActivity().runOnUiThread(new dll(this, paramInt, paramString2, paramString1));
  }
  
  @JavascriptInterface
  @Deprecated
  public final void notifyPairingSuccess()
  {
    a.c(null);
  }
  
  @JavascriptInterface
  public final void notifyPairingSuccess(String paramString, boolean paramBoolean)
  {
    a.c(paramString);
  }
}

/* Location:
 * Qualified Name:     dlk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */