import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.accounts.api.AccountData;

public final class flw
{
  static final fma a = new flx();
  public static final flz b = new flz(a);
  
  public static boolean a(Context paramContext, Intent paramIntent)
  {
    return flz.a(paramContext, paramIntent);
  }
  
  public static AccountData b(Context paramContext, Intent paramIntent)
  {
    Parcel localParcel = null;
    enz.a(paramContext, "Context must not be null.");
    enz.a(paramIntent, "Intent must not be null.");
    if (!flz.a(paramContext, paramIntent)) {
      return null;
    }
    paramContext = AccountData.CREATOR;
    paramIntent = paramIntent.getByteArrayExtra("com.google.android.gms.accounts.ACCOUNT_DATA");
    if (paramIntent == null) {
      paramContext = localParcel;
    }
    for (;;)
    {
      return (AccountData)paramContext;
      enz.a(paramContext);
      localParcel = Parcel.obtain();
      localParcel.unmarshall(paramIntent, 0, paramIntent.length);
      localParcel.setDataPosition(0);
      paramContext = (SafeParcelable)paramContext.createFromParcel(localParcel);
      localParcel.recycle();
    }
  }
}

/* Location:
 * Qualified Name:     flw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */