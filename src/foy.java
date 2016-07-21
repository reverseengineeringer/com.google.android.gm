import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class foy
  extends Binder
  implements fox
{
  public foy()
  {
    attachInterface(this, "com.google.android.gms.panorama.internal.IPanoramaCallbacks");
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.panorama.internal.IPanoramaCallbacks");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.panorama.internal.IPanoramaCallbacks");
    paramInt1 = paramParcel1.readInt();
    Bundle localBundle;
    if (paramParcel1.readInt() != 0)
    {
      localBundle = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      paramInt2 = paramParcel1.readInt();
      if (paramParcel1.readInt() == 0) {
        break label126;
      }
    }
    label126:
    for (paramParcel1 = (Intent)Intent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      a(paramInt1, localBundle, paramInt2, paramParcel1);
      paramParcel2.writeNoException();
      return true;
      localBundle = null;
      break;
    }
  }
}

/* Location:
 * Qualified Name:     foy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */