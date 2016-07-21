import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Status;

final class fxh
  implements frh
{
  private final Status a;
  private final ParcelFileDescriptor b;
  private final boolean c;
  private final int d;
  private final int e;
  
  public fxh(Status paramStatus, ParcelFileDescriptor paramParcelFileDescriptor, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    a = paramStatus;
    b = paramParcelFileDescriptor;
    c = paramBoolean;
    d = paramInt1;
    e = paramInt2;
  }
  
  public final Status a()
  {
    return a;
  }
  
  public final void b()
  {
    if (b != null) {
      eow.a(b);
    }
  }
  
  public final ParcelFileDescriptor c()
  {
    return b;
  }
  
  public final int d()
  {
    return d;
  }
  
  public final int e()
  {
    return e;
  }
}

/* Location:
 * Qualified Name:     fxh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */