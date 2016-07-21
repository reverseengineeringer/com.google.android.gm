import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.internal.OnMetadataResponse;

final class fbq
  extends fdx
{
  private final ejr<fau> a;
  
  public fbq(ejr<fau> paramejr)
  {
    a = paramejr;
  }
  
  public final void a(Status paramStatus)
  {
    a.a(new fbr(paramStatus, null));
  }
  
  public final void a(OnMetadataResponse paramOnMetadataResponse)
  {
    a.a(new fbr(Status.a, new feh(b)));
  }
}

/* Location:
 * Qualified Name:     fbq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */