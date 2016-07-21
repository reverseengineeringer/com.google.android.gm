import android.content.ContentValues;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.AccountDirtyFlags;

final class dvy
  implements dvw
{
  private final int a;
  
  public dvy(int paramInt)
  {
    a = paramInt;
  }
  
  public final void a(ContentValues paramContentValues)
  {
    paramContentValues.put("syncLookback", Integer.valueOf(a));
  }
  
  public final boolean a(Account paramAccount)
  {
    return f == a;
  }
  
  public final boolean a(AccountDirtyFlags paramAccountDirtyFlags)
  {
    return c;
  }
}

/* Location:
 * Qualified Name:     dvy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */