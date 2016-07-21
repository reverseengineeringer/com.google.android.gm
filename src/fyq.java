import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.administration.GetStorageStatsCall.PackageStats;
import com.google.android.gms.search.administration.GetStorageStatsCall.Response;

public final class fyq
  implements Parcelable.Creator<GetStorageStatsCall.Response>
{
  public static GetStorageStatsCall.Response a(Parcel paramParcel)
  {
    GetStorageStatsCall.PackageStats[] arrayOfPackageStats = null;
    long l1 = 0L;
    int j = emh.a(paramParcel);
    int i = 0;
    long l2 = 0L;
    long l3 = 0L;
    Status localStatus = null;
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
        arrayOfPackageStats = (GetStorageStatsCall.PackageStats[])emh.b(paramParcel, k, GetStorageStatsCall.PackageStats.CREATOR);
        break;
      case 3: 
        l3 = emh.g(paramParcel, k);
        break;
      case 4: 
        l2 = emh.g(paramParcel, k);
        break;
      case 5: 
        l1 = emh.g(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new GetStorageStatsCall.Response(i, localStatus, arrayOfPackageStats, l3, l2, l1);
  }
}

/* Location:
 * Qualified Name:     fyq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */