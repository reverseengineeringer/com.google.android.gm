package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import emj;
import fbg;
import java.util.Locale;

public final class ChangeEvent
  implements SafeParcelable, ResourceEvent
{
  public static final Parcelable.Creator<ChangeEvent> CREATOR = new fbg();
  final int a;
  final DriveId b;
  final int c;
  
  public ChangeEvent(int paramInt1, DriveId paramDriveId, int paramInt2)
  {
    a = paramInt1;
    b = paramDriveId;
    c = paramInt2;
  }
  
  public final int a()
  {
    return 1;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    return String.format(Locale.US, "ChangeEvent [id=%s,changeFlags=%x]", new Object[] { b, Integer.valueOf(c) });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, paramInt, false);
    emj.b(paramParcel, 3, c);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.events.ChangeEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */