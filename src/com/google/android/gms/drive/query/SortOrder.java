package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import emj;
import fgt;
import java.util.List;
import java.util.Locale;

public class SortOrder
  implements SafeParcelable
{
  public static final Parcelable.Creator<SortOrder> CREATOR = new fgt();
  final List<FieldWithSortOrder> a;
  final boolean b;
  final int c;
  
  public SortOrder(int paramInt, List<FieldWithSortOrder> paramList, boolean paramBoolean)
  {
    c = paramInt;
    a = paramList;
    b = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return String.format(Locale.US, "SortOrder[%s, %s]", new Object[] { TextUtils.join(",", a), Boolean.valueOf(b) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1000, c);
    emj.b(paramParcel, 1, a, false);
    emj.a(paramParcel, 2, b);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.query.SortOrder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */