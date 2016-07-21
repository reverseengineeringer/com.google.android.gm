import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.dataservice.CheckFactoryResetPolicyComplianceRequest;

public final class eek
  implements Parcelable.Creator<CheckFactoryResetPolicyComplianceRequest>
{
  public static CheckFactoryResetPolicyComplianceRequest a(Parcel paramParcel)
  {
    int j = emh.a(paramParcel);
    int i = 0;
    String str = null;
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
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new CheckFactoryResetPolicyComplianceRequest(i, str);
  }
}

/* Location:
 * Qualified Name:     eek
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */