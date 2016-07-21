package com.google.android.gm.drive.aclfix;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import dit;

public class FixPermissionDialogState
  implements Parcelable
{
  public static final Parcelable.Creator<FixPermissionDialogState> CREATOR = new dit();
  public final boolean a;
  public final int b;
  public final int c;
  public final int d;
  
  public FixPermissionDialogState(Parcel paramParcel)
  {
    if (paramParcel.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      b = paramParcel.readInt();
      c = paramParcel.readInt();
      d = paramParcel.readInt();
      return;
    }
  }
  
  public FixPermissionDialogState(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    a = paramBoolean;
    b = paramInt1;
    c = paramInt2;
    d = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (a) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(b);
      paramParcel.writeInt(c);
      paramParcel.writeInt(d);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.drive.aclfix.FixPermissionDialogState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */