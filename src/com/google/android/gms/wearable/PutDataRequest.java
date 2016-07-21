package com.google.android.gms.wearable;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import emj;
import enz;
import ghw;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class PutDataRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<PutDataRequest> CREATOR = new ghw();
  private static final Random e = new SecureRandom();
  final int a;
  public final Uri b;
  final Bundle c;
  public byte[] d;
  
  public PutDataRequest(int paramInt, Uri paramUri, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    a = paramInt;
    b = paramUri;
    c = paramBundle;
    c.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
    d = paramArrayOfByte;
  }
  
  private PutDataRequest(Uri paramUri)
  {
    this(1, paramUri, new Bundle(), null);
  }
  
  public static PutDataRequest a(Uri paramUri)
  {
    return new PutDataRequest(paramUri);
  }
  
  public static PutDataRequest a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("An empty path was supplied.");
    }
    if (!paramString.startsWith("/")) {
      throw new IllegalArgumentException("A path must start with a single / .");
    }
    if (paramString.startsWith("//")) {
      throw new IllegalArgumentException("A path must start with a single / .");
    }
    return a(new Uri.Builder().scheme("wear").path(paramString).build());
  }
  
  public final PutDataRequest a(String paramString, Asset paramAsset)
  {
    enz.a(paramString);
    enz.a(paramAsset);
    c.putParcelable(paramString, paramAsset);
    return this;
  }
  
  public final Map<String, Asset> a()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = c.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, (Asset)c.getParcelable(str));
    }
    return Collections.unmodifiableMap(localHashMap);
  }
  
  public final Asset b(String paramString)
  {
    return (Asset)c.getParcelable(paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    boolean bool = Log.isLoggable("DataMap", 3);
    StringBuilder localStringBuilder = new StringBuilder("PutDataRequest[");
    Object localObject2 = new StringBuilder("dataSz=");
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
      localStringBuilder.append("\n    " + (String)localObject2 + ": " + c.getParcelable((String)localObject2));
    }
    localStringBuilder.append("\n  ]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, paramInt, false);
    emj.a(paramParcel, 4, c);
    emj.a(paramParcel, 5, d, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.PutDataRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */