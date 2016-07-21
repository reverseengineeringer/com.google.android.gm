import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.net.Uri;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;

final class coa
  implements cjo
{
  coa(cnz paramcnz) {}
  
  public final Account a()
  {
    return a.m;
  }
  
  public final Account a(Uri paramUri)
  {
    if ((a.m != null) && (a.m.g.equals(paramUri))) {
      return a.m;
    }
    return null;
  }
  
  public final void a(DataSetObserver paramDataSetObserver) {}
  
  public final void a(cgn paramcgn) {}
  
  public final void a(Account paramAccount)
  {
    cvm.f(cnz.l, "FolderSelectionActivity.switchToDefaultInboxOrChangeAccount() called when NOT expected.", new Object[0]);
  }
  
  public final void a(boolean paramBoolean, Account paramAccount, Folder paramFolder)
  {
    a.o.notifyChanged();
  }
  
  public final boolean ai()
  {
    return false;
  }
  
  public final int an()
  {
    return 0;
  }
  
  public final void b(DataSetObserver paramDataSetObserver) {}
  
  public final void c(DataSetObserver paramDataSetObserver) {}
  
  public final void d(DataSetObserver paramDataSetObserver) {}
  
  public final void e(DataSetObserver paramDataSetObserver)
  {
    a.o.registerObserver(paramDataSetObserver);
  }
  
  public final void f(DataSetObserver paramDataSetObserver)
  {
    a.o.unregisterObserver(paramDataSetObserver);
  }
  
  public final Account[] k()
  {
    return new Account[] { a.m };
  }
}

/* Location:
 * Qualified Name:     coa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */