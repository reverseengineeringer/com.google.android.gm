package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import enz;
import fed;

public class CreateContentsRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<CreateContentsRequest> CREATOR = new fed();
  final int a;
  final int b;
  
  public CreateContentsRequest(int paramInt)
  {
    this(1, paramInt);
  }
  
  public CreateContentsRequest(int paramInt1, int paramInt2)
  {
    a = paramInt1;
    if ((paramInt2 == 536870912) || (paramInt2 == 805306368)) {}
    for (boolean bool = true;; bool = false)
    {
      enz.b(bool, "Cannot create a new read-only contents!");
      b = paramInt2;
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.b(paramParcel, 2, b);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.internal.CreateContentsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */