import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.dataservice.GplusInfoRequest;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;

public final class eez
  implements Parcelable.Creator<GplusInfoRequest>
{
  public static GplusInfoRequest a(Parcel paramParcel)
  {
    int j = emh.a(paramParcel);
    CaptchaSolution localCaptchaSolution = null;
    String str = null;
    int i = 0;
    Account localAccount = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = paramParcel.readInt();
      switch (0xFFFF & k)
      {
      default: 
        emh.b(paramParcel, k);
        break;
      case 1: 
        i = emh.e(paramParcel, k);
        break;
      case 2: 
        str = emh.m(paramParcel, k);
        break;
      case 3: 
        localCaptchaSolution = (CaptchaSolution)emh.a(paramParcel, k, CaptchaSolution.CREATOR);
        break;
      case 4: 
        localAccount = (Account)emh.a(paramParcel, k, Account.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new GplusInfoRequest(i, str, localCaptchaSolution, localAccount);
  }
}

/* Location:
 * Qualified Name:     eez
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */