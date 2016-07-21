import android.os.Binder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.feedback.ErrorReport;

public abstract class fos
  extends Binder
  implements for
{
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i = 0;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.feedback.internal.IFeedbackService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.feedback.internal.IFeedbackService");
      if (paramParcel1.readInt() != 0) {
        localObject1 = (ErrorReport)ErrorReport.CREATOR.createFromParcel(paramParcel1);
      }
      bool = a((ErrorReport)localObject1);
      paramParcel2.writeNoException();
      if (bool) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.feedback.internal.IFeedbackService");
      a(paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.feedback.internal.IFeedbackService");
    localObject1 = localObject2;
    if (paramParcel1.readInt() != 0) {
      localObject1 = (ErrorReport)ErrorReport.CREATOR.createFromParcel(paramParcel1);
    }
    boolean bool = b((ErrorReport)localObject1);
    paramParcel2.writeNoException();
    paramInt1 = i;
    if (bool) {
      paramInt1 = 1;
    }
    paramParcel2.writeInt(paramInt1);
    return true;
  }
}

/* Location:
 * Qualified Name:     fos
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */