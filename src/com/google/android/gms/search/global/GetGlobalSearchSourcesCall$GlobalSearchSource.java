package com.google.android.gms.search.global;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import fzp;

public class GetGlobalSearchSourcesCall$GlobalSearchSource
  implements SafeParcelable
{
  public static final fzp CREATOR = new fzp();
  public String a;
  public int b;
  public int c;
  public int d;
  public String e;
  public String f;
  public String g;
  public GetGlobalSearchSourcesCall.CorpusInfo[] h;
  public boolean i;
  final int j;
  
  public GetGlobalSearchSourcesCall$GlobalSearchSource()
  {
    j = 1;
  }
  
  public GetGlobalSearchSourcesCall$GlobalSearchSource(int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3, String paramString4, GetGlobalSearchSourcesCall.CorpusInfo[] paramArrayOfCorpusInfo, boolean paramBoolean)
  {
    j = paramInt1;
    a = paramString1;
    b = paramInt2;
    c = paramInt3;
    d = paramInt4;
    e = paramString2;
    f = paramString3;
    g = paramString4;
    h = paramArrayOfCorpusInfo;
    i = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int k = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1000, j);
    emj.a(paramParcel, 1, a, false);
    emj.b(paramParcel, 2, b);
    emj.b(paramParcel, 3, c);
    emj.b(paramParcel, 4, d);
    emj.a(paramParcel, 5, e, false);
    emj.a(paramParcel, 6, f, false);
    emj.a(paramParcel, 7, g, false);
    emj.a(paramParcel, 8, h, paramInt);
    emj.a(paramParcel, 9, i);
    emj.b(paramParcel, k);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.search.global.GetGlobalSearchSourcesCall.GlobalSearchSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */