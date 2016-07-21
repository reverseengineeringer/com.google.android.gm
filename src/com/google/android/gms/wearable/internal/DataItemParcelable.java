package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import gdt;
import gdu;
import gex;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DataItemParcelable
  implements SafeParcelable, gdt
{
  public static final Parcelable.Creator<DataItemParcelable> CREATOR = new gex();
  final int a;
  final Uri b;
  final Map<String, gdu> c;
  byte[] d;
  
  public DataItemParcelable(int paramInt, Uri paramUri, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    a = paramInt;
    b = paramUri;
    paramUri = new HashMap();
    paramBundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramUri.put(str, (DataItemAssetParcelable)paramBundle.getParcelable(str));
    }
    c = paramUri;
    d = paramArrayOfByte;
  }
  
  public final boolean a()
  {
    return true;
  }
  
  public final Uri b()
  {
    return b;
  }
  
  public final byte[] c()
  {
    return d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    boolean bool = Log.isLoggable("DataItem", 3);
    StringBuilder localStringBuilder = new StringBuilder("DataItemParcelable[");
    localStringBuilder.append("@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    Object localObject2 = new StringBuilder(",dataSz=");
    if (d == null) {}
    for (Object localObject1 = "null";; localObject1 = Integer.valueOf(d.length))
    {
      localStringBuilder.append(localObject1);
      localStringBuilder.append(", numAssets=" + c.size());
      localStringBuilder.append(", uri=" + b);
      if (bool) {
        break;
      }
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    localStringBuilder.append("]\n  assets: ");
    localObject1 = c.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localStringBuilder.append("\n    " + (String)localObject2 + ": " + c.get(localObject2));
    }
    localStringBuilder.append("\n  ]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, paramInt, false);
    Bundle localBundle = new Bundle();
    localBundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
    Iterator localIterator = c.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localBundle.putParcelable((String)localEntry.getKey(), new DataItemAssetParcelable((gdu)localEntry.getValue()));
    }
    emj.a(paramParcel, 4, localBundle);
    emj.a(paramParcel, 5, d, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.DataItemParcelable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */