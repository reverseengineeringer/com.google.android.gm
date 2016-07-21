import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.internal.OnContentsResponse;

final class fes
  extends fdx
{
  private final ejr<fak> a;
  
  public fes(ejr<fak> paramejr)
  {
    a = paramejr;
  }
  
  public final void a(Status paramStatus)
  {
    a.a(new fen(paramStatus, null));
  }
  
  public final void a(OnContentsResponse paramOnContentsResponse)
  {
    a.a(new fen(Status.a, new few(b)));
  }
}

/* Location:
 * Qualified Name:     fes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */