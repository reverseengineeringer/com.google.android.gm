import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.FilterHolder;

public final class fbb
{
  public String[] a;
  private String b;
  private Filter c;
  private DriveId d;
  
  public final IntentSender a(eiz parameiz)
  {
    enz.a(parameiz.e(), "Client must be connected");
    if (a == null) {
      a = new String[0];
    }
    if ((a.length > 0) && (c != null)) {
      throw new IllegalStateException("Cannot use a selection filter and set mimetypes simultaneously");
    }
    if (c == null) {}
    for (FilterHolder localFilterHolder = null;; localFilterHolder = new FilterHolder(c)) {
      try
      {
        parameiz = ((fcc)((fev)parameiz.a(fae.a)).k()).a(new OpenFileIntentSenderRequest(b, a, d, localFilterHolder));
        return parameiz;
      }
      catch (RemoteException parameiz)
      {
        throw new RuntimeException("Unable to connect Drive Play Service", parameiz);
      }
    }
  }
}

/* Location:
 * Qualified Name:     fbb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */