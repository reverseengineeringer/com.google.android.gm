import android.content.ContentValues;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.AccountDirtyFlags;

final class dvx
  implements dvw
{
  private final String a;
  
  public dvx(String paramString)
  {
    a = paramString;
  }
  
  public final void a(ContentValues paramContentValues)
  {
    paramContentValues.put("signature", a);
  }
  
  public final boolean a(Account paramAccount)
  {
    return hbc.a(a, n);
  }
  
  public final boolean a(AccountDirtyFlags paramAccountDirtyFlags)
  {
    return b;
  }
}

/* Location:
 * Qualified Name:     dvx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */