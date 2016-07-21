import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.feedback.ErrorReport;

final class fot
  implements for
{
  private IBinder a;
  
  fot(IBinder paramIBinder)
  {
    a = paramIBinder;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.feedback.internal.IFeedbackService");
      localParcel1.writeInt(paramInt1);
      localParcel1.writeInt(paramInt2);
      a.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final boolean a(ErrorReport paramErrorReport)
  {
    boolean bool = true;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.feedback.internal.IFeedbackService");
        if (paramErrorReport != null)
        {
          localParcel1.writeInt(1);
          paramErrorReport.writeToParcel(localParcel1, 0);
          a.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            return bool;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        bool = false;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final IBinder asBinder()
  {
    return a;
  }
  
  public final boolean b(ErrorReport paramErrorReport)
  {
    boolean bool = true;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.feedback.internal.IFeedbackService");
        if (paramErrorReport != null)
        {
          localParcel1.writeInt(1);
          paramErrorReport.writeToParcel(localParcel1, 0);
          a.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            return bool;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        bool = false;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
}

/* Location:
 * Qualified Name:     fot
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */