import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;

final class fpe
  extends fpg
{
  fpe(fpd paramfpd, eiz parameiz, Uri paramUri)
  {
    super(parameiz);
  }
  
  protected final void a(Context paramContext, fpa paramfpa)
  {
    Object localObject = new fph(this);
    Uri localUri = a;
    paramContext.grantUriPermission("com.google.android.gms", localUri, 1);
    localObject = new fpf(paramContext, localUri, (fox)localObject);
    try
    {
      paramfpa.a((fox)localObject, localUri, null, true);
      return;
    }
    catch (RemoteException paramfpa)
    {
      paramContext.revokeUriPermission(localUri, 1);
      throw paramfpa;
    }
    catch (RuntimeException paramfpa)
    {
      paramContext.revokeUriPermission(localUri, 1);
      throw paramfpa;
    }
  }
}

/* Location:
 * Qualified Name:     fpe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */