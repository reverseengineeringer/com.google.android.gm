package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import emj;
import fvq;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DefaultPersonImpl
  extends FastJsonResponse
  implements SafeParcelable
{
  public static final fvq CREATOR = new fvq();
  private static final HashMap<String, FastJsonResponse.Field<?, ?>> J;
  List<DefaultPersonImpl.PlacesLived> A;
  String B;
  List<DefaultPersonImpl.Relations> C;
  List<DefaultPersonImpl.RelationshipInterests> D;
  List<DefaultPersonImpl.RelationshipStatuses> E;
  List<DefaultPersonImpl.Skills> F;
  DefaultPersonImpl.SortKeys G;
  List<DefaultPersonImpl.Taglines> H;
  List<DefaultPersonImpl.Urls> I;
  final Set<Integer> a;
  final int b;
  List<DefaultPersonImpl.Abouts> c;
  List<DefaultPersonImpl.Addresses> d;
  String e;
  List<DefaultPersonImpl.Birthdays> f;
  List<DefaultPersonImpl.BraggingRights> g;
  List<DefaultPersonImpl.CoverPhotos> h;
  List<DefaultPersonImpl.CustomFields> i;
  List<DefaultPersonImpl.Emails> j;
  String k;
  List<DefaultPersonImpl.Events> l;
  List<DefaultPersonImpl.Genders> m;
  String n;
  List<DefaultPersonImpl.Images> o;
  List<DefaultPersonImpl.InstantMessaging> p;
  String q;
  DefaultPersonImpl.LegacyFields r;
  List<DefaultPersonImpl> s;
  List<DefaultPersonImpl.Memberships> t;
  DefaultPersonImpl.Metadata u;
  List<DefaultPersonImpl.Names> v;
  List<DefaultPersonImpl.Nicknames> w;
  List<DefaultPersonImpl.Occupations> x;
  List<DefaultPersonImpl.Organizations> y;
  List<DefaultPersonImpl.PhoneNumbers> z;
  
  static
  {
    HashMap localHashMap = new HashMap();
    J = localHashMap;
    localHashMap.put("abouts", FastJsonResponse.Field.b("abouts", 2, DefaultPersonImpl.Abouts.class));
    J.put("addresses", FastJsonResponse.Field.b("addresses", 3, DefaultPersonImpl.Addresses.class));
    J.put("ageRange", FastJsonResponse.Field.d("ageRange", 4));
    J.put("birthdays", FastJsonResponse.Field.b("birthdays", 5, DefaultPersonImpl.Birthdays.class));
    J.put("braggingRights", FastJsonResponse.Field.b("braggingRights", 6, DefaultPersonImpl.BraggingRights.class));
    J.put("coverPhotos", FastJsonResponse.Field.b("coverPhotos", 7, DefaultPersonImpl.CoverPhotos.class));
    J.put("customFields", FastJsonResponse.Field.b("customFields", 8, DefaultPersonImpl.CustomFields.class));
    J.put("emails", FastJsonResponse.Field.b("emails", 9, DefaultPersonImpl.Emails.class));
    J.put("etag", FastJsonResponse.Field.d("etag", 10));
    J.put("events", FastJsonResponse.Field.b("events", 11, DefaultPersonImpl.Events.class));
    J.put("genders", FastJsonResponse.Field.b("genders", 12, DefaultPersonImpl.Genders.class));
    J.put("id", FastJsonResponse.Field.d("id", 13));
    J.put("images", FastJsonResponse.Field.b("images", 14, DefaultPersonImpl.Images.class));
    J.put("instantMessaging", FastJsonResponse.Field.b("instantMessaging", 15, DefaultPersonImpl.InstantMessaging.class));
    J.put("language", FastJsonResponse.Field.d("language", 17));
    J.put("legacyFields", FastJsonResponse.Field.a("legacyFields", 18, DefaultPersonImpl.LegacyFields.class));
    J.put("linkedPeople", FastJsonResponse.Field.b("linkedPeople", 19, DefaultPersonImpl.class));
    J.put("memberships", FastJsonResponse.Field.b("memberships", 20, DefaultPersonImpl.Memberships.class));
    J.put("metadata", FastJsonResponse.Field.a("metadata", 21, DefaultPersonImpl.Metadata.class));
    J.put("names", FastJsonResponse.Field.b("names", 22, DefaultPersonImpl.Names.class));
    J.put("nicknames", FastJsonResponse.Field.b("nicknames", 23, DefaultPersonImpl.Nicknames.class));
    J.put("occupations", FastJsonResponse.Field.b("occupations", 24, DefaultPersonImpl.Occupations.class));
    J.put("organizations", FastJsonResponse.Field.b("organizations", 25, DefaultPersonImpl.Organizations.class));
    J.put("phoneNumbers", FastJsonResponse.Field.b("phoneNumbers", 26, DefaultPersonImpl.PhoneNumbers.class));
    J.put("placesLived", FastJsonResponse.Field.b("placesLived", 27, DefaultPersonImpl.PlacesLived.class));
    J.put("profileUrl", FastJsonResponse.Field.d("profileUrl", 28));
    J.put("relations", FastJsonResponse.Field.b("relations", 29, DefaultPersonImpl.Relations.class));
    J.put("relationshipInterests", FastJsonResponse.Field.b("relationshipInterests", 30, DefaultPersonImpl.RelationshipInterests.class));
    J.put("relationshipStatuses", FastJsonResponse.Field.b("relationshipStatuses", 31, DefaultPersonImpl.RelationshipStatuses.class));
    J.put("skills", FastJsonResponse.Field.b("skills", 32, DefaultPersonImpl.Skills.class));
    J.put("sortKeys", FastJsonResponse.Field.a("sortKeys", 33, DefaultPersonImpl.SortKeys.class));
    J.put("taglines", FastJsonResponse.Field.b("taglines", 34, DefaultPersonImpl.Taglines.class));
    J.put("urls", FastJsonResponse.Field.b("urls", 35, DefaultPersonImpl.Urls.class));
  }
  
  public DefaultPersonImpl()
  {
    b = 1;
    a = new HashSet();
  }
  
  public DefaultPersonImpl(Set<Integer> paramSet, int paramInt, List<DefaultPersonImpl.Abouts> paramList, List<DefaultPersonImpl.Addresses> paramList1, String paramString1, List<DefaultPersonImpl.Birthdays> paramList2, List<DefaultPersonImpl.BraggingRights> paramList3, List<DefaultPersonImpl.CoverPhotos> paramList4, List<DefaultPersonImpl.CustomFields> paramList5, List<DefaultPersonImpl.Emails> paramList6, String paramString2, List<DefaultPersonImpl.Events> paramList7, List<DefaultPersonImpl.Genders> paramList8, String paramString3, List<DefaultPersonImpl.Images> paramList9, List<DefaultPersonImpl.InstantMessaging> paramList10, String paramString4, DefaultPersonImpl.LegacyFields paramLegacyFields, List<DefaultPersonImpl> paramList11, List<DefaultPersonImpl.Memberships> paramList12, DefaultPersonImpl.Metadata paramMetadata, List<DefaultPersonImpl.Names> paramList13, List<DefaultPersonImpl.Nicknames> paramList14, List<DefaultPersonImpl.Occupations> paramList15, List<DefaultPersonImpl.Organizations> paramList16, List<DefaultPersonImpl.PhoneNumbers> paramList17, List<DefaultPersonImpl.PlacesLived> paramList18, String paramString5, List<DefaultPersonImpl.Relations> paramList19, List<DefaultPersonImpl.RelationshipInterests> paramList20, List<DefaultPersonImpl.RelationshipStatuses> paramList21, List<DefaultPersonImpl.Skills> paramList22, DefaultPersonImpl.SortKeys paramSortKeys, List<DefaultPersonImpl.Taglines> paramList23, List<DefaultPersonImpl.Urls> paramList24)
  {
    a = paramSet;
    b = paramInt;
    c = paramList;
    d = paramList1;
    e = paramString1;
    f = paramList2;
    g = paramList3;
    h = paramList4;
    i = paramList5;
    j = paramList6;
    k = paramString2;
    l = paramList7;
    m = paramList8;
    n = paramString3;
    o = paramList9;
    p = paramList10;
    q = paramString4;
    r = paramLegacyFields;
    s = paramList11;
    t = paramList12;
    u = paramMetadata;
    v = paramList13;
    w = paramList14;
    x = paramList15;
    y = paramList16;
    z = paramList17;
    A = paramList18;
    B = paramString5;
    C = paramList19;
    D = paramList20;
    E = paramList21;
    F = paramList22;
    G = paramSortKeys;
    H = paramList23;
    I = paramList24;
  }
  
  protected final boolean a(FastJsonResponse.Field paramField)
  {
    return a.contains(Integer.valueOf(g));
  }
  
  protected final Object b()
  {
    return null;
  }
  
  protected final Object b(FastJsonResponse.Field paramField)
  {
    switch (g)
    {
    case 16: 
    default: 
      throw new IllegalStateException("Unknown safe parcelable id=" + g);
    case 2: 
      return c;
    case 3: 
      return d;
    case 4: 
      return e;
    case 5: 
      return f;
    case 6: 
      return g;
    case 7: 
      return h;
    case 8: 
      return i;
    case 9: 
      return j;
    case 10: 
      return k;
    case 11: 
      return l;
    case 12: 
      return m;
    case 13: 
      return n;
    case 14: 
      return o;
    case 15: 
      return p;
    case 17: 
      return q;
    case 18: 
      return r;
    case 19: 
      return s;
    case 20: 
      return t;
    case 21: 
      return u;
    case 22: 
      return v;
    case 23: 
      return w;
    case 24: 
      return x;
    case 25: 
      return y;
    case 26: 
      return z;
    case 27: 
      return A;
    case 28: 
      return B;
    case 29: 
      return C;
    case 30: 
      return D;
    case 31: 
      return E;
    case 32: 
      return F;
    case 33: 
      return G;
    case 34: 
      return H;
    }
    return I;
  }
  
  protected final boolean c()
  {
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof DefaultPersonImpl)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (DefaultPersonImpl)paramObject;
    Iterator localIterator = J.values().iterator();
    while (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (a(localField))
      {
        if (((DefaultPersonImpl)paramObject).a(localField))
        {
          if (!b(localField).equals(((DefaultPersonImpl)paramObject).b(localField))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((DefaultPersonImpl)paramObject).a(localField)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    Iterator localIterator = J.values().iterator();
    int i1 = 0;
    if (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (!a(localField)) {
        break label68;
      }
      int i2 = g;
      i1 = b(localField).hashCode() + (i1 + i2);
    }
    label68:
    for (;;)
    {
      break;
      return i1;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = emj.a(paramParcel, 20293);
    Set localSet = a;
    if (localSet.contains(Integer.valueOf(1))) {
      emj.b(paramParcel, 1, b);
    }
    if (localSet.contains(Integer.valueOf(2))) {
      emj.b(paramParcel, 2, c, true);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      emj.b(paramParcel, 3, d, true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      emj.a(paramParcel, 4, e, true);
    }
    if (localSet.contains(Integer.valueOf(5))) {
      emj.b(paramParcel, 5, f, true);
    }
    if (localSet.contains(Integer.valueOf(6))) {
      emj.b(paramParcel, 6, g, true);
    }
    if (localSet.contains(Integer.valueOf(7))) {
      emj.b(paramParcel, 7, h, true);
    }
    if (localSet.contains(Integer.valueOf(8))) {
      emj.b(paramParcel, 8, i, true);
    }
    if (localSet.contains(Integer.valueOf(9))) {
      emj.b(paramParcel, 9, j, true);
    }
    if (localSet.contains(Integer.valueOf(10))) {
      emj.a(paramParcel, 10, k, true);
    }
    if (localSet.contains(Integer.valueOf(11))) {
      emj.b(paramParcel, 11, l, true);
    }
    if (localSet.contains(Integer.valueOf(12))) {
      emj.b(paramParcel, 12, m, true);
    }
    if (localSet.contains(Integer.valueOf(13))) {
      emj.a(paramParcel, 13, n, true);
    }
    if (localSet.contains(Integer.valueOf(14))) {
      emj.b(paramParcel, 14, o, true);
    }
    if (localSet.contains(Integer.valueOf(15))) {
      emj.b(paramParcel, 15, p, true);
    }
    if (localSet.contains(Integer.valueOf(17))) {
      emj.a(paramParcel, 17, q, true);
    }
    if (localSet.contains(Integer.valueOf(19))) {
      emj.b(paramParcel, 19, s, true);
    }
    if (localSet.contains(Integer.valueOf(18))) {
      emj.a(paramParcel, 18, r, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(21))) {
      emj.a(paramParcel, 21, u, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(20))) {
      emj.b(paramParcel, 20, t, true);
    }
    if (localSet.contains(Integer.valueOf(23))) {
      emj.b(paramParcel, 23, w, true);
    }
    if (localSet.contains(Integer.valueOf(22))) {
      emj.b(paramParcel, 22, v, true);
    }
    if (localSet.contains(Integer.valueOf(25))) {
      emj.b(paramParcel, 25, y, true);
    }
    if (localSet.contains(Integer.valueOf(24))) {
      emj.b(paramParcel, 24, x, true);
    }
    if (localSet.contains(Integer.valueOf(27))) {
      emj.b(paramParcel, 27, A, true);
    }
    if (localSet.contains(Integer.valueOf(26))) {
      emj.b(paramParcel, 26, z, true);
    }
    if (localSet.contains(Integer.valueOf(29))) {
      emj.b(paramParcel, 29, C, true);
    }
    if (localSet.contains(Integer.valueOf(28))) {
      emj.a(paramParcel, 28, B, true);
    }
    if (localSet.contains(Integer.valueOf(31))) {
      emj.b(paramParcel, 31, E, true);
    }
    if (localSet.contains(Integer.valueOf(30))) {
      emj.b(paramParcel, 30, D, true);
    }
    if (localSet.contains(Integer.valueOf(34))) {
      emj.b(paramParcel, 34, H, true);
    }
    if (localSet.contains(Integer.valueOf(35))) {
      emj.b(paramParcel, 35, I, true);
    }
    if (localSet.contains(Integer.valueOf(32))) {
      emj.b(paramParcel, 32, F, true);
    }
    if (localSet.contains(Integer.valueOf(33))) {
      emj.a(paramParcel, 33, G, paramInt, true);
    }
    emj.b(paramParcel, i1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.people.identity.internal.models.DefaultPersonImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */