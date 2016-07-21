package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import enx;
import fbh;
import java.util.Arrays;
import java.util.Locale;

public final class ChangesAvailableEvent
  implements SafeParcelable, DriveEvent
{
  public static final Parcelable.Creator<ChangesAvailableEvent> CREATOR = new fbh();
  final int a;
  final String b;
  final ChangesAvailableOptions c;
  
  public ChangesAvailableEvent(int paramInt, String paramString, ChangesAvailableOptions paramChangesAvailableOptions)
  {
    a = paramInt;
    b = paramString;
    c = paramChangesAvailableOptions;
  }
  
  public final int a()
  {
    return 4;
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
      paramObject = (ChangesAvailableEvent)paramObject;
      if (!enx.a(c, c)) {
        break;
      }
      bool1 = bool2;
    } while (enx.a(b, b));
    return false;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { c, b });
  }
  
  public final String toString()
  {
    return String.format(Locale.US, "ChangesAvailableEvent [changesAvailableOptions=%s]", new Object[] { c });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.a(paramParcel, 3, c, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.events.ChangesAvailableEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */