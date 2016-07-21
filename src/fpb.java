import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class fpb
  extends Binder
  implements fpa
{
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.panorama.internal.IPanoramaService");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.panorama.internal.IPanoramaService");
    paramParcel2 = paramParcel1.readStrongBinder();
    Object localObject;
    label84:
    Bundle localBundle;
    if (paramParcel2 == null)
    {
      paramParcel2 = null;
      if (paramParcel1.readInt() == 0) {
        break label172;
      }
      localObject = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
      if (paramParcel1.readInt() == 0) {
        break label178;
      }
      localBundle = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      label105:
      if (paramParcel1.readInt() == 0) {
        break label184;
      }
    }
    label172:
    label178:
    label184:
    for (boolean bool = true;; bool = false)
    {
      a(paramParcel2, (Uri)localObject, localBundle, bool);
      return true;
      localObject = paramParcel2.queryLocalInterface("com.google.android.gms.panorama.internal.IPanoramaCallbacks");
      if ((localObject != null) && ((localObject instanceof fox)))
      {
        paramParcel2 = (fox)localObject;
        break;
      }
      paramParcel2 = new foz(paramParcel2);
      break;
      localObject = null;
      break label84;
      localBundle = null;
      break label105;
    }
  }
}

/* Location:
 * Qualified Name:     fpb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */