package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import enz;
import ffj;
import ffk;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class AppVisibleCustomProperties
  implements SafeParcelable, Iterable<CustomProperty>
{
  public static final Parcelable.Creator<AppVisibleCustomProperties> CREATOR = new ffk();
  public static final AppVisibleCustomProperties a = new ffj().a();
  final int b;
  public final List<CustomProperty> c;
  
  public AppVisibleCustomProperties(int paramInt, Collection<CustomProperty> paramCollection)
  {
    b = paramInt;
    enz.a(paramCollection);
    c = new ArrayList(paramCollection);
  }
  
  public AppVisibleCustomProperties(Collection<CustomProperty> paramCollection)
  {
    this(1, paramCollection);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final Iterator<CustomProperty> iterator()
  {
    return c.iterator();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, b);
    emj.b(paramParcel, 2, c, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */