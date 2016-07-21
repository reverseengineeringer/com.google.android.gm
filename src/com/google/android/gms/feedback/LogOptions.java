package com.google.android.gms.feedback;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import fjq;

public class LogOptions
  implements SafeParcelable
{
  public static final Parcelable.Creator<LogOptions> CREATOR = new fjq();
  public final int a;
  public String b;
  public boolean c;
  
  public LogOptions(int paramInt, String paramString, boolean paramBoolean)
  {
    a = paramInt;
    b = paramString;
    c = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.a(paramParcel, 3, c);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.feedback.LogOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */