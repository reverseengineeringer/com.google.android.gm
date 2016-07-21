package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import fjw;
import fjx;

public class OneoffTask
  extends Task
{
  public static final Parcelable.Creator<OneoffTask> CREATOR = new fjw();
  private final long a;
  private final long b;
  
  @Deprecated
  public OneoffTask(Parcel paramParcel)
  {
    super(paramParcel);
    a = paramParcel.readLong();
    b = paramParcel.readLong();
  }
  
  public OneoffTask(fjx paramfjx)
  {
    super(paramfjx);
    a = a;
    b = b;
  }
  
  public final void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle.putLong("window_start", a);
    paramBundle.putLong("window_end", b);
  }
  
  public String toString()
  {
    return super.toString() + " windowStart=" + a + " windowEnd=" + b;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(a);
    paramParcel.writeLong(b);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.gcm.OneoffTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */