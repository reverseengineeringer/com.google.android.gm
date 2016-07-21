import android.os.Binder;
import android.os.Parcel;

public abstract class fib
  extends Binder
  implements fia
{
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    boolean bool2 = false;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.drive.realtime.internal.IDocumentSaveStateEventCallback");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IDocumentSaveStateEventCallback");
    if (paramParcel1.readInt() != 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (paramParcel1.readInt() != 0) {
        bool2 = true;
      }
      a(bool1, bool2);
      paramParcel2.writeNoException();
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     fib
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */