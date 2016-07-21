import android.content.Context;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.Mailbox;

final class bbb
  implements bdd
{
  bbb(Account paramAccount, Mailbox paramMailbox, long paramLong, Context paramContext) {}
  
  public final void a(int paramInt) {}
  
  public final void a(bdg parambdg)
  {
    try
    {
      beb localbeb = new beb();
      aqt.a(localbeb, parambdg, a.D, b.D);
      W = U;
      U = c;
      ag = b.d;
      baa.a(localbeb, d);
      return;
    }
    catch (bdi parambdg)
    {
      cvm.e(bba.a, parambdg, "Error while copying downloaded message.", new Object[0]);
      return;
    }
    catch (Exception parambdg)
    {
      cvm.e(bba.a, parambdg, "Error while storing downloaded message.", new Object[0]);
    }
  }
}

/* Location:
 * Qualified Name:     bbb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */