import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.dataservice.CheckFactoryResetPolicyComplianceResponse;

public final class eel
  implements Parcelable.Creator<CheckFactoryResetPolicyComplianceResponse>
{
  public static CheckFactoryResetPolicyComplianceResponse a(Parcel paramParcel)
  {
    boolean bool = false;
    int j = emh.a(paramParcel);
    int i = 0;
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
        bool = emh.c(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new CheckFactoryResetPolicyComplianceResponse(i, bool);
  }
}

/* Location:
 * Qualified Name:     eel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */