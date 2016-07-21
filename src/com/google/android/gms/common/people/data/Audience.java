package com.google.android.gms.common.people.data;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import enx;
import eoc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Audience
  implements SafeParcelable
{
  public static final eoc CREATOR = new eoc();
  final int a;
  final List<AudienceMember> b;
  final int c;
  @Deprecated
  final boolean d;
  final boolean e;
  
  public Audience(int paramInt1, List<AudienceMember> paramList, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = paramList;
    if (paramInt1 == 1)
    {
      localObject = paramList;
      if (paramList == null) {
        localObject = Collections.emptyList();
      }
    }
    a = paramInt1;
    if (paramInt2 == 1)
    {
      paramList = a((List)localObject);
      b = paramList;
      c = paramInt2;
      if (paramInt1 != 1) {
        break label94;
      }
      d = paramBoolean1;
      if (paramBoolean1) {
        break label88;
      }
    }
    label88:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      e = paramBoolean1;
      return;
      paramList = Collections.unmodifiableList((List)localObject);
      break;
    }
    label94:
    e = paramBoolean2;
    if (!paramBoolean2) {}
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      d = paramBoolean1;
      return;
    }
  }
  
  private static List<AudienceMember> a(List<AudienceMember> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    label70:
    while (paramList.hasNext())
    {
      AudienceMember localAudienceMember = (AudienceMember)paramList.next();
      if ((b == 1) && (c == 1)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label70;
        }
        localArrayList.add(localAudienceMember);
        break;
      }
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Audience)) {}
    do
    {
      return false;
      paramObject = (Audience)paramObject;
    } while ((a != a) || (!enx.a(b, b)) || (c != c) || (e != e));
    return true;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(a), b, Integer.valueOf(c), Boolean.valueOf(e) });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, b, false);
    emj.b(paramParcel, 1000, a);
    emj.b(paramParcel, 2, c);
    emj.a(paramParcel, 3, d);
    emj.a(paramParcel, 4, e);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.people.data.Audience
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */