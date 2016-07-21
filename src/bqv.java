import android.content.Context;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.Mailbox;
import java.io.InputStream;

public abstract class bqv
{
  protected static void a(bpi parambpi, String paramString, double paramDouble, int paramInt)
  {
    parambpi.b(30);
    parambpi.b(19);
    parambpi.b(21, String.valueOf(paramInt));
    parambpi.a(23);
    if (paramString != null) {
      parambpi.b(24, paramString);
    }
    if (paramDouble >= 12.0D)
    {
      parambpi.a(1093);
      parambpi.b(1094, "1");
      parambpi.b(1095, "200000");
      parambpi.b();
    }
    for (;;)
    {
      parambpi.b();
      return;
      parambpi.b(25, "7");
    }
  }
  
  public abstract int a();
  
  public abstract bnx a(Context paramContext, Account paramAccount, Mailbox paramMailbox, InputStream paramInputStream);
  
  public abstract void a(Context paramContext, bpi parambpi, double paramDouble, Account paramAccount, Mailbox paramMailbox, boolean paramBoolean, int paramInt);
  
  public void a(Context paramContext, Account paramAccount) {}
}

/* Location:
 * Qualified Name:     bqv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */