import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import com.google.android.gm.provider.GmailProvider;

final class dsp
  extends cua
{
  private final Context a;
  private final Intent b;
  
  public dsp(Context paramContext, Account paramAccount, int paramInt)
  {
    super(drp.L(), paramInt);
    a = paramContext;
    b = new Intent("com.android.mail.ACTION_NOTIFY_DATASET_CHANGED");
    b.putExtra("accountUri", GmailProvider.b(name));
    b.setType("application/gmail-ls");
  }
  
  protected final void b()
  {
    a.sendBroadcast(b, "com.google.android.gm.permission.BROADCAST_INTERNAL");
  }
}

/* Location:
 * Qualified Name:     dsp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */