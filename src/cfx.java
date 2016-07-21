import android.database.DataSetObserver;
import com.android.mail.providers.Account;

public abstract class cfx
  extends DataSetObserver
{
  private static final String b = cvl.a;
  private cjo a;
  
  public final Account a(cjo paramcjo)
  {
    if (paramcjo == null) {
      cvm.f(b, "AccountObserver initialized with null controller!", new Object[0]);
    }
    a = paramcjo;
    a.a(this);
    return a.a();
  }
  
  public final void a()
  {
    if (a == null) {
      return;
    }
    a.b(this);
  }
  
  public abstract void a(Account paramAccount);
  
  public final void onChanged()
  {
    if (a == null) {
      return;
    }
    a(a.a());
  }
}

/* Location:
 * Qualified Name:     cfx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */