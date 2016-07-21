package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import emj;
import enz;
import ffm;

public class CustomProperty
  implements SafeParcelable
{
  public static final Parcelable.Creator<CustomProperty> CREATOR = new ffm();
  final int a;
  public final CustomPropertyKey b;
  public final String c;
  
  public CustomProperty(int paramInt, CustomPropertyKey paramCustomPropertyKey, String paramString)
  {
    a = paramInt;
    enz.a(paramCustomPropertyKey, "key");
    b = paramCustomPropertyKey;
    c = paramString;
  }
  
  public CustomProperty(CustomPropertyKey paramCustomPropertyKey, String paramString)
  {
    this(1, paramCustomPropertyKey, paramString);
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
    emj.a(paramParcel, 3, c, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.metadata.internal.CustomProperty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */