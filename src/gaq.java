import android.os.Binder;
import android.os.Parcel;
import com.google.android.gms.search.ime.GetCorpusHandlesRegisteredForIMECall.Request;
import com.google.android.gms.search.ime.GetIMEUpdatesCall.Request;

public abstract class gaq
  extends Binder
  implements gap
{
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.search.ime.internal.IIMEUpdatesService");
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.search.ime.internal.IIMEUpdatesService");
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = GetCorpusHandlesRegisteredForIMECall.Request.CREATOR;
        localObject1 = gah.a(paramParcel1);
      }
      a((GetCorpusHandlesRegisteredForIMECall.Request)localObject1, gan.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.search.ime.internal.IIMEUpdatesService");
    localObject1 = localObject2;
    if (paramParcel1.readInt() != 0)
    {
      localObject1 = GetIMEUpdatesCall.Request.CREATOR;
      localObject1 = gaj.a(paramParcel1);
    }
    a((GetIMEUpdatesCall.Request)localObject1, gan.a(paramParcel1.readStrongBinder()));
    paramParcel2.writeNoException();
    return true;
  }
}

/* Location:
 * Qualified Name:     gaq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */