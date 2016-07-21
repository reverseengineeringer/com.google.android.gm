import android.app.FragmentManager;
import android.content.Loader;
import android.os.Bundle;
import com.android.email.activity.setup.AccountSecurity;
import com.android.emailcommon.provider.Account;

final class asm
  implements Runnable
{
  asm(asl paramasl, Account paramAccount, Loader paramLoader) {}
  
  public final void run()
  {
    Object localObject1 = c.a;
    if (!d) {}
    Object localObject2;
    do
    {
      boolean bool1;
      boolean bool3;
      do
      {
        do
        {
          return;
          if ((a == null) || ((a.o != 0L) && (a.v == null)))
          {
            ((AccountSecurity)localObject1).finish();
            cvm.b("Email/AccountSecurity", "could not load account or policy in AccountSecurity", new Object[0]);
            return;
          }
        } while (b);
        b = true;
        localObject2 = (ask)b;
        localObject3 = a;
        bool1 = a;
        boolean bool2 = b;
        bool3 = c;
        a = ((Account)localObject3);
        if ((!bool2) && (!bool3)) {
          break;
        }
        localObject2 = ((AccountSecurity)localObject1).getFragmentManager();
      } while (((FragmentManager)localObject2).findFragmentByTag("password_expiration") != null);
      localObject1 = a.c;
      localObject3 = new asn();
      localBundle = new Bundle();
      localBundle.putString("account_name", (String)localObject1);
      localBundle.putBoolean("expired", bool3);
      ((asn)localObject3).setArguments(localBundle);
      ((asn)localObject3).show((FragmentManager)localObject2, "password_expiration");
      return;
      if (a.o == 0L) {
        break label305;
      }
      if (!bool1) {
        break;
      }
      localObject2 = ((AccountSecurity)localObject1).getFragmentManager();
    } while (((FragmentManager)localObject2).findFragmentByTag("security_needed") != null);
    localObject1 = a.c;
    Object localObject3 = new aso();
    Bundle localBundle = new Bundle();
    localBundle.putString("account_name", (String)localObject1);
    ((aso)localObject3).setArguments(localBundle);
    ((aso)localObject3).show((FragmentManager)localObject2, "security_needed");
    return;
    ((AccountSecurity)localObject1).a(a);
    return;
    label305:
    ((AccountSecurity)localObject1).finish();
  }
}

/* Location:
 * Qualified Name:     asm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */