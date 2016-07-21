import android.os.Bundle;
import com.android.mail.providers.Message;
import java.lang.ref.SoftReference;

final class ccs
  implements Runnable
{
  String a;
  private final SoftReference<cbk> b;
  private final cha c;
  private final ccf d;
  private final CharSequence e;
  private final boolean f;
  private final Bundle g;
  
  public final void run()
  {
    cbk localcbk = (cbk)b.get();
    if (localcbk != null)
    {
      Message localMessage = localcbk.a(t, H, x, new cbh(a));
      localcbk.a(localcbk, O, c, K, localMessage, H, e, d, f, x, N, g);
      return;
    }
    buo.a().a("webview_compose", "save", "no_activity", 0L);
    cvm.e(cvl.a, "Race condition: ComposeActivity is gone", new Object[0]);
  }
}

/* Location:
 * Qualified Name:     ccs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */