import android.accounts.Account;
import android.os.IInterface;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.signin.internal.CheckServerAuthResult;
import com.google.android.gms.signin.internal.RecordConsentRequest;

public abstract interface gcn
  extends IInterface
{
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, Account paramAccount, gck paramgck);
  
  public abstract void a(AuthAccountRequest paramAuthAccountRequest, gck paramgck);
  
  public abstract void a(ResolveAccountRequest paramResolveAccountRequest, ent parament);
  
  public abstract void a(CheckServerAuthResult paramCheckServerAuthResult);
  
  public abstract void a(RecordConsentRequest paramRecordConsentRequest, gck paramgck);
  
  public abstract void a(eme parameme, int paramInt, boolean paramBoolean);
  
  public abstract void a(gck paramgck);
  
  public abstract void a(boolean paramBoolean);
}

/* Location:
 * Qualified Name:     gcn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */