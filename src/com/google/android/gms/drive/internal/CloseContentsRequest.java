package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import emj;
import feb;

public class CloseContentsRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<CloseContentsRequest> CREATOR = new feb();
  final int a;
  final Contents b;
  final Boolean c;
  final int d;
  
  public CloseContentsRequest(int paramInt1, Contents paramContents, Boolean paramBoolean, int paramInt2)
  {
    a = paramInt1;
    b = paramContents;
    c = paramBoolean;
    d = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    int j = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, paramInt, false);
    Boolean localBoolean = c;
    if (localBoolean != null)
    {
      emj.a(paramParcel, 3, 4);
      if (!localBoolean.booleanValue()) {
        break label79;
      }
    }
    label79:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      emj.b(paramParcel, 4, d);
      emj.b(paramParcel, j);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.internal.CloseContentsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */