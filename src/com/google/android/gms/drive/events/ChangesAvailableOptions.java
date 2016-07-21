package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveSpace;
import emj;
import enx;
import fbi;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public final class ChangesAvailableOptions
  implements SafeParcelable
{
  public static final Parcelable.Creator<ChangesAvailableOptions> CREATOR = new fbi();
  final int a;
  final int b;
  final boolean c;
  final List<DriveSpace> d;
  private final Set<DriveSpace> e;
  
  public ChangesAvailableOptions(int paramInt1, int paramInt2, boolean paramBoolean, List<DriveSpace> paramList) {}
  
  private ChangesAvailableOptions(int paramInt1, int paramInt2, boolean paramBoolean, List<DriveSpace> paramList, Set<DriveSpace> paramSet)
  {
    a = paramInt1;
    b = paramInt2;
    c = paramBoolean;
    d = paramList;
    e = paramSet;
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
      paramObject = (ChangesAvailableOptions)paramObject;
      if ((!enx.a(e, e)) || (b != b)) {
        break;
      }
      bool1 = bool2;
    } while (c == c);
    return false;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { e, Integer.valueOf(b), Boolean.valueOf(c) });
  }
  
  public final String toString()
  {
    return String.format(Locale.US, "ChangesAvailableOptions[ChangesSizeLimit=%d, Repeats=%s, Spaces=%s]", new Object[] { Integer.valueOf(b), Boolean.valueOf(c), d });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.b(paramParcel, 2, b);
    emj.a(paramParcel, 3, c);
    emj.b(paramParcel, 4, d, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.events.ChangesAvailableOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */