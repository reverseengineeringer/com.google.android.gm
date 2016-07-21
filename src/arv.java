import android.os.AsyncTask;
import android.os.Bundle;
import com.android.emailcommon.EmailProviderConfiguration;
import com.android.emailcommon.provider.Account;

final class arv
  implements Runnable
{
  arv(art paramart, Account paramAccount) {}
  
  public final void run()
  {
    if ((a == null) || (!b.a.isResumed())) {}
    Object localObject;
    do
    {
      return;
      localObject = (asb)b.a.getActivity();
      ((asb)localObject).a(a);
      ((asb)localObject).h();
      AsyncTask.execute(new arw(this));
      localObject = (EmailProviderConfiguration)b.a.getArguments().getParcelable("provider");
    } while ((localObject == null) || (a != 3));
    AsyncTask.execute(new arx(this, (EmailProviderConfiguration)localObject));
  }
}

/* Location:
 * Qualified Name:     arv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */