import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.atomic.AtomicReference;

public abstract class ejq<R extends ejk, A extends eit>
  extends ejm<R>
  implements ejr<R>, eks<A>
{
  private AtomicReference<ekr> a = new AtomicReference();
  final eiu<A> g;
  
  public ejq(eiu<A> parameiu, eiz parameiz)
  {
    super(((eiz)enz.a(parameiz, "GoogleApiClient must not be null")).a());
    g = ((eiu)enz.a(parameiu));
  }
  
  private final void a(RemoteException paramRemoteException)
  {
    c(new Status(8, paramRemoteException.getLocalizedMessage(), null));
  }
  
  public abstract void a(A paramA);
  
  public final void a(ekr paramekr)
  {
    a.set(paramekr);
  }
  
  public final void b(A paramA)
  {
    try
    {
      a(paramA);
      return;
    }
    catch (DeadObjectException paramA)
    {
      a(paramA);
      throw paramA;
    }
    catch (RemoteException paramA)
    {
      a(paramA);
    }
  }
  
  protected final void c()
  {
    ekr localekr = (ekr)a.getAndSet(null);
    if (localekr != null) {
      localekr.a(this);
    }
  }
  
  public final void c(Status paramStatus)
  {
    if (!paramStatus.b()) {}
    for (boolean bool = true;; bool = false)
    {
      enz.b(bool, "Failed result must not be success");
      a(a(paramStatus));
      return;
    }
  }
  
  public final eiu<A> d()
  {
    return g;
  }
}

/* Location:
 * Qualified Name:     ejq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */