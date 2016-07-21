package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import mc;
import me;
import mk;
import ml;

public class ResultReceiver
  implements Parcelable
{
  public static final Parcelable.Creator<ResultReceiver> CREATOR = new mk();
  final boolean a = false;
  public final Handler b = null;
  mc c;
  
  public ResultReceiver(Parcel paramParcel)
  {
    paramParcel = paramParcel.readStrongBinder();
    if (paramParcel == null) {
      paramParcel = localIInterface;
    }
    for (;;)
    {
      c = paramParcel;
      return;
      localIInterface = paramParcel.queryLocalInterface("android.support.v4.os.IResultReceiver");
      if ((localIInterface != null) && ((localIInterface instanceof mc))) {
        paramParcel = (mc)localIInterface;
      } else {
        paramParcel = new me(paramParcel);
      }
    }
  }
  
  public void a(int paramInt, Bundle paramBundle) {}
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      if (c == null) {
        c = new ml(this);
      }
      paramParcel.writeStrongBinder(c.asBinder());
      return;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     android.support.v4.os.ResultReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */