import android.database.DataSetObserver;
import com.android.mail.providers.Folder;

public abstract class cgm
  extends DataSetObserver
{
  private static final String b = cvl.a;
  private cnh a;
  
  public final Folder a(cnh paramcnh)
  {
    if (paramcnh == null) {
      cvm.f(b, "FolderObserver initialized with null controller!", new Object[0]);
    }
    a = paramcnh;
    a.k(this);
    return a.p();
  }
  
  public final void a()
  {
    if (a == null) {
      return;
    }
    a.l(this);
  }
  
  public abstract void a(Folder paramFolder);
  
  public final void onChanged()
  {
    if (a == null) {
      return;
    }
    a(a.p());
  }
}

/* Location:
 * Qualified Name:     cgm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */