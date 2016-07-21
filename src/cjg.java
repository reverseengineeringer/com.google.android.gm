import android.net.Uri;
import com.android.mail.providers.Account;

final class cjg
  extends cfy
{
  cjg(cjf paramcjf) {}
  
  protected final void a() {}
  
  public final void a(Account[] paramArrayOfAccount)
  {
    Account localAccount1 = a.f;
    int j = paramArrayOfAccount.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Account localAccount2 = paramArrayOfAccount[i];
        if (g.equals(g))
        {
          a.f = localAccount2;
          a.g.b = a.f;
          a.a(localAccount2, localAccount1);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     cjg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */