package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import egn;
import emj;
import java.util.List;

public class ScopeDetail
  implements SafeParcelable
{
  public static final egn CREATOR = new egn();
  final int a;
  String b;
  String c;
  String d;
  String e;
  String f;
  List<String> g;
  public FACLData h;
  
  public ScopeDetail(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, List<String> paramList, FACLData paramFACLData)
  {
    a = paramInt;
    b = paramString1;
    c = paramString2;
    d = paramString3;
    e = paramString4;
    f = paramString5;
    g = paramList;
    h = paramFACLData;
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
    emj.a(paramParcel, 3, c, false);
    emj.a(paramParcel, 4, d, false);
    emj.a(paramParcel, 5, e, false);
    emj.a(paramParcel, 6, f, false);
    emj.a(paramParcel, 7, g, false);
    emj.a(paramParcel, 8, h, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.shared.ScopeDetail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */