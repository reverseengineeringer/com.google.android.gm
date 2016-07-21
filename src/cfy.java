import android.database.DataSetObserver;
import com.android.mail.providers.Account;

public abstract class cfy
  extends DataSetObserver
{
  private cjo a;
  private int b;
  
  public abstract void a();
  
  public abstract void a(Account[] paramArrayOfAccount);
  
  public final Account[] a(cjo paramcjo)
  {
    if (paramcjo == null) {
      throw new NullPointerException("AllAccountObserver initialized with null controller!");
    }
    a = paramcjo;
    a.c(this);
    paramcjo = a.k();
    b = paramcjo.length;
    return paramcjo;
  }
  
  public final Account[] b()
  {
    if (a == null) {
      return null;
    }
    return a.k();
  }
  
  public final void c()
  {
    if (a == null) {
      return;
    }
    a.d(this);
  }
  
  public final void onChanged()
  {
    if (a == null) {}
    Account[] arrayOfAccount;
    do
    {
      return;
      arrayOfAccount = a.k();
      a(arrayOfAccount);
    } while (b == arrayOfAccount.length);
    b = arrayOfAccount.length;
    a();
  }
}

/* Location:
 * Qualified Name:     cfy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */