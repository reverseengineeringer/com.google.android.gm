package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.DriveId;
import emj;
import enx;
import fbk;
import java.util.Arrays;

public final class ProgressEvent
  implements DriveEvent
{
  public static final Parcelable.Creator<ProgressEvent> CREATOR = new fbk();
  final int a;
  final DriveId b;
  final int c;
  final long d;
  final long e;
  final int f;
  
  public ProgressEvent(int paramInt1, DriveId paramDriveId, int paramInt2, long paramLong1, long paramLong2, int paramInt3)
  {
    a = paramInt1;
    b = paramDriveId;
    c = paramInt2;
    d = paramLong1;
    e = paramLong2;
    f = paramInt3;
  }
  
  public final int a()
  {
    return f;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramObject == null) || (paramObject.getClass() != getClass())) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == this);
      paramObject = (ProgressEvent)paramObject;
      if ((!enx.a(b, b)) || (c != c) || (d != d)) {
        break;
      }
      bool1 = bool2;
    } while (e == e);
    return false;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { b, Integer.valueOf(c), Long.valueOf(d), Long.valueOf(e) });
  }
  
  public final String toString()
  {
    return String.format("ProgressEvent[DriveId: %s, status: %d, bytes transferred: %d, total bytes: %d]", new Object[] { b, Integer.valueOf(c), Long.valueOf(d), Long.valueOf(e) });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, paramInt, false);
    emj.b(paramParcel, 3, c);
    emj.a(paramParcel, 4, d);
    emj.a(paramParcel, 5, e);
    emj.b(paramParcel, 6, f);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.events.ProgressEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */