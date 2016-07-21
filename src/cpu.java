import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;

public final class cpu
  extends ckn
{
  protected final int a()
  {
    return buj.bu;
  }
  
  final void a(int paramInt)
  {
    buo.a().a("report_spam_mute_dialog", "report_spam", b(paramInt), 0L);
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    return a(new SpannableString(getResources().getString(buj.bd))).a(buj.be).a(buj.bc, this).b(buj.bb, this).a();
  }
}

/* Location:
 * Qualified Name:     cpu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */