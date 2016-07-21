import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.search.ime.GetCorpusHandlesRegisteredForIMECall.Response;
import com.google.android.gms.search.ime.GetIMEUpdatesCall.Response;

public abstract class gan
  extends Binder
  implements gam
{
  public static gam a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.search.ime.internal.IIMEUpdatesCallbacks");
    if ((localIInterface != null) && ((localIInterface instanceof gam))) {
      return (gam)localIInterface;
    }
    return new gao(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.search.ime.internal.IIMEUpdatesCallbacks");
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.search.ime.internal.IIMEUpdatesCallbacks");
      paramParcel2 = (Parcel)localObject1;
      if (paramParcel1.readInt() != 0)
      {
        paramParcel2 = GetCorpusHandlesRegisteredForIMECall.Response.CREATOR;
        paramParcel2 = gai.a(paramParcel1);
      }
      a(paramParcel2);
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.search.ime.internal.IIMEUpdatesCallbacks");
    paramParcel2 = (Parcel)localObject2;
    if (paramParcel1.readInt() != 0)
    {
      paramParcel2 = GetIMEUpdatesCall.Response.CREATOR;
      paramParcel2 = gak.a(paramParcel1);
    }
    a(paramParcel2);
    return true;
  }
}

/* Location:
 * Qualified Name:     gan
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */