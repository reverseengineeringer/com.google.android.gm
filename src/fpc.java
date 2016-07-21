import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

final class fpc
  implements fpa
{
  private IBinder a;
  
  fpc(IBinder paramIBinder)
  {
    a = paramIBinder;
  }
  
  public final void a(fox paramfox, Uri paramUri, Bundle paramBundle, boolean paramBoolean)
  {
    IBinder localIBinder = null;
    int i = 1;
    Parcel localParcel = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel.writeInterfaceToken("com.google.android.gms.panorama.internal.IPanoramaService");
        if (paramfox != null) {
          localIBinder = paramfox.asBinder();
        }
        localParcel.writeStrongBinder(localIBinder);
        if (paramUri != null)
        {
          localParcel.writeInt(1);
          paramUri.writeToParcel(localParcel, 0);
          if (paramBundle != null)
          {
            localParcel.writeInt(1);
            paramBundle.writeToParcel(localParcel, 0);
            break label134;
            localParcel.writeInt(i);
            a.transact(1, localParcel, null, 1);
          }
        }
        else
        {
          localParcel.writeInt(0);
          continue;
        }
        localParcel.writeInt(0);
      }
      finally
      {
        localParcel.recycle();
      }
      label134:
      while (!paramBoolean)
      {
        i = 0;
        break;
      }
    }
  }
  
  public final IBinder asBinder()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     fpc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */