package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import eoj;

public class FieldMappingDictionary$FieldMapPair
  implements SafeParcelable
{
  public static final eoj CREATOR = new eoj();
  final int a;
  final String b;
  final FastJsonResponse.Field<?, ?> c;
  
  public FieldMappingDictionary$FieldMapPair(int paramInt, String paramString, FastJsonResponse.Field<?, ?> paramField)
  {
    a = paramInt;
    b = paramString;
    c = paramField;
  }
  
  FieldMappingDictionary$FieldMapPair(String paramString, FastJsonResponse.Field<?, ?> paramField)
  {
    a = 1;
    b = paramString;
    c = paramField;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.a(paramParcel, 3, c, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.server.response.FieldMappingDictionary.FieldMapPair
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */