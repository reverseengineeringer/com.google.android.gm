package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ebp;
import emj;

public class GlobalSearchApplication
  implements SafeParcelable
{
  public static final ebp CREATOR = new ebp();
  final int a;
  public final GlobalSearchApplicationInfo b;
  final GlobalSearchAppCorpusFeatures[] c;
  public final boolean d;
  
  public GlobalSearchApplication(int paramInt, GlobalSearchApplicationInfo paramGlobalSearchApplicationInfo, GlobalSearchAppCorpusFeatures[] paramArrayOfGlobalSearchAppCorpusFeatures, boolean paramBoolean)
  {
    a = paramInt;
    b = paramGlobalSearchApplicationInfo;
    c = paramArrayOfGlobalSearchAppCorpusFeatures;
    d = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1, b, paramInt, false);
    emj.b(paramParcel, 1000, a);
    emj.a(paramParcel, 2, c, paramInt);
    emj.a(paramParcel, 3, d);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.GlobalSearchApplication
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */