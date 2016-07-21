package com.google.android.gms.search.global;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.appdatasearch.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import fzo;

public class GetGlobalSearchSourcesCall$CorpusInfo
  implements SafeParcelable
{
  public static final fzo CREATOR = new fzo();
  public String a;
  public Feature[] b;
  public boolean c;
  public Bundle d;
  final int e;
  
  public GetGlobalSearchSourcesCall$CorpusInfo()
  {
    e = 1;
  }
  
  public GetGlobalSearchSourcesCall$CorpusInfo(int paramInt, String paramString, Feature[] paramArrayOfFeature, boolean paramBoolean, Bundle paramBundle)
  {
    e = paramInt;
    a = paramString;
    b = paramArrayOfFeature;
    c = paramBoolean;
    d = paramBundle;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1000, e);
    emj.a(paramParcel, 1, a, false);
    emj.a(paramParcel, 2, b, paramInt);
    emj.a(paramParcel, 3, c);
    emj.a(paramParcel, 4, d);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.search.global.GetGlobalSearchSourcesCall.CorpusInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */