package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ebs;
import emj;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GlobalSearchQuerySpecification
  implements SafeParcelable
{
  public static final ebs CREATOR = new ebs();
  final int a;
  final CorpusId[] b;
  public final int c;
  final CorpusScoringInfo[] d;
  public final int e;
  public final int f;
  public final int g;
  public final String h;
  public final boolean i;
  public final byte[] j;
  private final transient Map<String, Set<String>> k;
  private final transient Map<CorpusId, CorpusScoringInfo> l;
  
  public GlobalSearchQuerySpecification(int paramInt1, CorpusId[] paramArrayOfCorpusId, int paramInt2, CorpusScoringInfo[] paramArrayOfCorpusScoringInfo, int paramInt3, int paramInt4, int paramInt5, String paramString, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    a = paramInt1;
    b = paramArrayOfCorpusId;
    c = paramInt2;
    e = paramInt3;
    f = paramInt4;
    g = paramInt5;
    h = paramString;
    i = paramBoolean;
    j = paramArrayOfByte;
    d = paramArrayOfCorpusScoringInfo;
    if ((paramArrayOfCorpusId == null) || (paramArrayOfCorpusId.length == 0))
    {
      k = null;
      if ((paramArrayOfCorpusScoringInfo != null) && (paramArrayOfCorpusScoringInfo.length != 0)) {
        break label197;
      }
      l = null;
    }
    for (;;)
    {
      return;
      k = new HashMap();
      paramInt1 = 0;
      while (paramInt1 < paramArrayOfCorpusId.length)
      {
        paramArrayOfByte = (Set)k.get(b);
        paramString = paramArrayOfByte;
        if (paramArrayOfByte == null)
        {
          paramString = new HashSet();
          k.put(b, paramString);
        }
        if (c != null) {
          paramString.add(c);
        }
        paramInt1 += 1;
      }
      break;
      label197:
      l = new HashMap(paramArrayOfCorpusScoringInfo.length);
      paramInt1 = 0;
      while (paramInt1 < paramArrayOfCorpusScoringInfo.length)
      {
        l.put(b, paramArrayOfCorpusScoringInfo[paramInt1]);
        paramInt1 += 1;
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject2;
    Object localObject1;
    if (k != null)
    {
      localStringBuilder.append("mFilter\n");
      localObject2 = k.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        Iterator localIterator = ((Set)k.get(str)).iterator();
        for (localObject1 = ""; localIterator.hasNext(); localObject1 = (String)localObject1 + (String)localIterator.next() + ",") {}
        localStringBuilder.append("key:").append(str).append(", values:").append((String)localObject1).append("\n");
      }
    }
    if (l != null)
    {
      localStringBuilder.append("mCorpusScoringInfoMap\n");
      localObject1 = l.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CorpusId)((Iterator)localObject1).next();
        localStringBuilder.append(((CorpusId)localObject2).toString() + "\n");
      }
    }
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int m = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1, b, paramInt);
    emj.b(paramParcel, 1000, a);
    emj.b(paramParcel, 2, c);
    emj.a(paramParcel, 3, d, paramInt);
    emj.b(paramParcel, 4, e);
    emj.b(paramParcel, 5, f);
    emj.b(paramParcel, 6, g);
    emj.a(paramParcel, 7, h, false);
    emj.a(paramParcel, 8, i);
    emj.a(paramParcel, 9, j, false);
    emj.b(paramParcel, m);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.GlobalSearchQuerySpecification
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */