package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import emj;
import fgb;
import fgi;
import fgj;
import fgm;
import java.util.Collection;
import java.util.Iterator;

public class InFilter<T>
  extends AbstractFilter
{
  public static final fgm CREATOR = new fgm();
  final MetadataBundle a;
  final int b;
  private final fgb<T> c;
  
  public InFilter(int paramInt, MetadataBundle paramMetadataBundle)
  {
    b = paramInt;
    a = paramMetadataBundle;
    c = ((fgb)fgi.a(paramMetadataBundle));
  }
  
  public final <F> F a(fgj<F> paramfgj)
  {
    return (F)paramfgj.a(c, ((Collection)a.a(c)).iterator().next());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1000, b);
    emj.a(paramParcel, 1, a, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.query.internal.InFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */