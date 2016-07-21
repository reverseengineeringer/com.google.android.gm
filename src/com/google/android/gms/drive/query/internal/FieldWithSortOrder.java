package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import fgg;
import java.util.Locale;

public class FieldWithSortOrder
  implements SafeParcelable
{
  public static final fgg CREATOR = new fgg();
  final String a;
  final boolean b;
  final int c;
  
  public FieldWithSortOrder(int paramInt, String paramString, boolean paramBoolean)
  {
    c = paramInt;
    a = paramString;
    b = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    Locale localLocale = Locale.US;
    String str2 = a;
    if (b) {}
    for (String str1 = "ASC";; str1 = "DESC") {
      return String.format(localLocale, "FieldWithSortOrder[%s %s]", new Object[] { str2, str1 });
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1000, c);
    emj.a(paramParcel, 1, a, false);
    emj.a(paramParcel, 2, b);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.query.internal.FieldWithSortOrder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */