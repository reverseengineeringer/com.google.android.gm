import android.graphics.Bitmap;
import com.android.mail.providers.Account;

public final class dww
{
  public static Bitmap a(Account paramAccount, cff paramcff1, cff paramcff2, int paramInt, float paramFloat, boolean paramBoolean)
  {
    boolean bool = dyp.a(paramAccount);
    cop localcop;
    if (bool)
    {
      localcop = new cop(paramInt, paramInt, 1.0F, paramFloat);
      if (!bool) {
        break label64;
      }
    }
    label64:
    for (paramcff2 = "&";; paramcff2 = b)
    {
      paramcff1 = paramcff1.a(localcop, paramcff2, c);
      paramAccount = paramcff1;
      if (paramBoolean) {
        paramAccount = cts.a(paramcff1);
      }
      return paramAccount;
      paramcff1 = paramcff2;
      break;
    }
  }
}

/* Location:
 * Qualified Name:     dww
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */