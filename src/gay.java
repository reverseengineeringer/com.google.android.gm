import android.os.Binder;
import android.os.Parcel;
import com.google.android.gms.search.nativeapi.GetNativeApiInfoCall.Response;

public abstract class gay
  extends Binder
  implements gax
{
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.search.nativeapi.internal.INativeApiCallbacks");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.search.nativeapi.internal.INativeApiCallbacks");
    if (paramParcel1.readInt() != 0) {
      paramParcel2 = GetNativeApiInfoCall.Response.CREATOR;
    }
    for (paramParcel1 = gau.a(paramParcel1);; paramParcel1 = null)
    {
      a(paramParcel1);
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     gay
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */