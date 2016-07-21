import android.os.IInterface;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.signin.GoogleSignInAccount;
import com.google.android.gms.signin.internal.AuthAccountResult;

public abstract interface gck
  extends IInterface
{
  public abstract void a(ConnectionResult paramConnectionResult, AuthAccountResult paramAuthAccountResult);
  
  public abstract void a(Status paramStatus);
  
  public abstract void a(Status paramStatus, GoogleSignInAccount paramGoogleSignInAccount);
  
  public abstract void b(Status paramStatus);
}

/* Location:
 * Qualified Name:     gck
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */