package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import enz;
import fjc;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DriveSpace
  implements SafeParcelable
{
  public static final Parcelable.Creator<DriveSpace> CREATOR = new fjc();
  public static final DriveSpace a = new DriveSpace("DRIVE");
  public static final DriveSpace b = new DriveSpace("APP_DATA_FOLDER");
  public static final DriveSpace c = new DriveSpace("PHOTOS");
  public static final Set<DriveSpace> d = Collections.unmodifiableSet(new HashSet(Arrays.asList(new DriveSpace[] { a, b, c })));
  public static final String e = TextUtils.join(",", d.toArray());
  final int f;
  final String g;
  
  public DriveSpace(int paramInt, String paramString)
  {
    f = paramInt;
    g = ((String)enz.a(paramString));
  }
  
  private DriveSpace(String paramString)
  {
    this(1, paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (paramObject.getClass() != DriveSpace.class)) {
      return false;
    }
    return g.equals(g);
  }
  
  public int hashCode()
  {
    return 0x4A54C0DE ^ g.hashCode();
  }
  
  public String toString()
  {
    return g;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, f);
    emj.a(paramParcel, 2, g, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.DriveSpace
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */