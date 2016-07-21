import android.app.FragmentManager;
import android.app.FragmentTransaction;

final class dke
  implements Runnable
{
  dke(dkd paramdkd, dkv paramdkv, boolean paramBoolean) {}
  
  public final void run()
  {
    FragmentManager localFragmentManager = c.getFragmentManager();
    FragmentTransaction localFragmentTransaction = localFragmentManager.beginTransaction();
    localFragmentTransaction.replace(dfy.cd, a, "GmailifyContentFragment");
    localFragmentTransaction.addToBackStack(a.getClass().getSimpleName());
    if (b) {
      c.a(a.getClass().getSimpleName());
    }
    try
    {
      localFragmentTransaction.commit();
      localFragmentManager.executePendingTransactions();
      return;
    }
    catch (IllegalStateException localIllegalStateException) {}
  }
}

/* Location:
 * Qualified Name:     dke
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */