package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import fjz;
import fka;

public class PeriodicTask
  extends Task
{
  public static final Parcelable.Creator<PeriodicTask> CREATOR = new fjz();
  public long a = -1L;
  public long b = -1L;
  
  @Deprecated
  public PeriodicTask(Parcel paramParcel)
  {
    super(paramParcel);
    a = paramParcel.readLong();
    b = paramParcel.readLong();
  }
  
  public PeriodicTask(fka paramfka)
  {
    super(paramfka);
    a = a;
    b = b;
  }
  
  public final void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle.putLong("period", a);
    paramBundle.putLong("period_flex", b);
  }
  
  public String toString()
  {
    return super.toString() + " period=" + a + " flex=" + b;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(a);
    paramParcel.writeLong(b);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.gcm.PeriodicTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */