import android.view.ViewGroup;
import android.webkit.WebView;
import com.android.setupwizardlib.SetupWizardLayout;

final class dll
  implements Runnable
{
  dll(dlk paramdlk, int paramInt, String paramString1, String paramString2) {}
  
  public final void run()
  {
    ((SetupWizardLayout)d.a.getView()).setHeaderText(dge.db);
    d.a.b(true);
    d.a.a(dge.cR);
    ((ViewGroup)d.a.g.getParent()).removeView(d.a.g);
    long l1;
    switch (a)
    {
    case 3: 
    default: 
      String str = dli.f;
      int i = a;
      cvm.d(str, 53 + "Gmailify WebView js:notifyPairingFailure #" + i, new Object[0]);
      d.a.e();
      return;
    case 1: 
      l1 = 0L;
    }
    try
    {
      long l2 = Long.parseLong(b);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;) {}
    }
    d.a.a(l1, c);
    return;
    d.a.a(c);
    return;
    d.a.E_();
    return;
    d.a.k();
  }
}

/* Location:
 * Qualified Name:     dll
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */