import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;

public final class cpv
  extends ckn
{
  private String[] a;
  
  public static cpv a(String[] paramArrayOfString)
  {
    cpv localcpv = new cpv();
    Bundle localBundle = new Bundle(1);
    localBundle.putStringArray("sender-names", paramArrayOfString);
    localcpv.setArguments(localBundle);
    return localcpv;
  }
  
  protected final int a()
  {
    return buj.bv;
  }
  
  final void a(int paramInt)
  {
    buo.a().a("report_spam_unsubscribe_dialog", "report_spam", b(paramInt), 0L);
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    Activity localActivity = getActivity();
    a = getArguments().getStringArray("sender-names");
    if (a.length == 1) {
      paramBundle = a[0];
    }
    for (;;)
    {
      return a(Html.fromHtml(String.format(localActivity.getResources().getQuantityString(buh.n, a.length), new Object[] { paramBundle, Integer.valueOf(a.length) }))).a(buj.bh).a(buj.bg, this).b(buj.bf, this).a();
      paramBundle = String.valueOf(TextUtils.join("<br>&bull; ", a));
      if (paramBundle.length() != 0) {
        paramBundle = "<br><br>&bull; ".concat(paramBundle);
      } else {
        paramBundle = new String("<br><br>&bull; ");
      }
    }
  }
}

/* Location:
 * Qualified Name:     cpv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */