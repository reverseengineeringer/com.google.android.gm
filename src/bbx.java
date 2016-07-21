import android.content.Context;
import android.content.Intent;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.Attachment;
import java.util.Set;

public abstract interface bbx
{
  public abstract void a();
  
  public abstract void a(long paramLong, Set<String> paramSet);
  
  public abstract void a(long paramLong, boolean paramBoolean);
  
  public abstract void a(Context paramContext, Intent paramIntent);
  
  public abstract void a(Context paramContext, Account paramAccount);
  
  public abstract void a(Account paramAccount);
  
  public abstract void a(Attachment paramAttachment);
  
  public abstract void b(long paramLong, boolean paramBoolean);
  
  public abstract void b(Account paramAccount);
  
  public abstract void c();
  
  public abstract void c(long paramLong);
  
  public abstract void c(Account paramAccount);
  
  public abstract void d();
  
  public abstract void d(long paramLong);
  
  public abstract void d(Account paramAccount);
  
  public abstract void e();
}

/* Location:
 * Qualified Name:     bbx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */