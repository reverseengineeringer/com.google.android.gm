package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import emj;
import fct;

public class OnContentsResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnContentsResponse> CREATOR = new fct();
  final int a;
  public final Contents b;
  public final boolean c;
  
  public OnContentsResponse(int paramInt, Contents paramContents, boolean paramBoolean)
  {
    a = paramInt;
    b = paramContents;
    c = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, paramInt, false);
    emj.a(paramParcel, 3, c);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.internal.OnContentsResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */