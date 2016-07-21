package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import fgx;
import java.util.List;

public class ParcelableEvent
  implements SafeParcelable
{
  public static final Parcelable.Creator<ParcelableEvent> CREATOR = new fgx();
  final int a;
  final String b;
  final String c;
  final List<String> d;
  final boolean e;
  final boolean f;
  final boolean g;
  final String h;
  final String i;
  final TextInsertedDetails j;
  final TextDeletedDetails k;
  final ValuesAddedDetails l;
  final ValuesRemovedDetails m;
  final ValuesSetDetails n;
  final ValueChangedDetails o;
  final ReferenceShiftedDetails p;
  final ObjectChangedDetails q;
  final FieldChangedDetails r;
  
  public ParcelableEvent(int paramInt, String paramString1, String paramString2, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3, String paramString4, TextInsertedDetails paramTextInsertedDetails, TextDeletedDetails paramTextDeletedDetails, ValuesAddedDetails paramValuesAddedDetails, ValuesRemovedDetails paramValuesRemovedDetails, ValuesSetDetails paramValuesSetDetails, ValueChangedDetails paramValueChangedDetails, ReferenceShiftedDetails paramReferenceShiftedDetails, ObjectChangedDetails paramObjectChangedDetails, FieldChangedDetails paramFieldChangedDetails)
  {
    a = paramInt;
    b = paramString1;
    c = paramString2;
    d = paramList;
    e = paramBoolean1;
    f = paramBoolean2;
    g = paramBoolean3;
    h = paramString3;
    i = paramString4;
    j = paramTextInsertedDetails;
    k = paramTextDeletedDetails;
    l = paramValuesAddedDetails;
    m = paramValuesRemovedDetails;
    n = paramValuesSetDetails;
    o = paramValueChangedDetails;
    p = paramReferenceShiftedDetails;
    q = paramObjectChangedDetails;
    r = paramFieldChangedDetails;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.a(paramParcel, 3, c, false);
    emj.a(paramParcel, 4, d, false);
    emj.a(paramParcel, 5, e);
    emj.a(paramParcel, 6, h, false);
    emj.a(paramParcel, 7, i, false);
    emj.a(paramParcel, 8, j, paramInt, false);
    emj.a(paramParcel, 9, k, paramInt, false);
    emj.a(paramParcel, 10, l, paramInt, false);
    emj.a(paramParcel, 11, m, paramInt, false);
    emj.a(paramParcel, 12, n, paramInt, false);
    emj.a(paramParcel, 13, o, paramInt, false);
    emj.a(paramParcel, 14, p, paramInt, false);
    emj.a(paramParcel, 15, q, paramInt, false);
    emj.a(paramParcel, 17, g);
    emj.a(paramParcel, 16, f);
    emj.a(paramParcel, 18, r, paramInt, false);
    emj.b(paramParcel, i1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.ParcelableEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */