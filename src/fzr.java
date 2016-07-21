import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.global.GetGlobalSearchSourcesCall.GlobalSearchSource;
import com.google.android.gms.search.global.GetGlobalSearchSourcesCall.Response;

public final class fzr
  implements Parcelable.Creator<GetGlobalSearchSourcesCall.Response>
{
  public static GetGlobalSearchSourcesCall.Response a(Parcel paramParcel)
  {
    int j = emh.a(paramParcel);
    Status localStatus = null;
    int i = 0;
    GetGlobalSearchSourcesCall.GlobalSearchSource[] arrayOfGlobalSearchSource = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = paramParcel.readInt();
      switch (0xFFFF & k)
      {
      default: 
        emh.b(paramParcel, k);
        break;
      case 1000: 
        i = emh.e(paramParcel, k);
        break;
      case 1: 
        localStatus = (Status)emh.a(paramParcel, k, Status.CREATOR);
        break;
      case 2: 
        arrayOfGlobalSearchSource = (GetGlobalSearchSourcesCall.GlobalSearchSource[])emh.b(paramParcel, k, GetGlobalSearchSourcesCall.GlobalSearchSource.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new GetGlobalSearchSourcesCall.Response(i, localStatus, arrayOfGlobalSearchSource);
  }
}

/* Location:
 * Qualified Name:     fzr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */