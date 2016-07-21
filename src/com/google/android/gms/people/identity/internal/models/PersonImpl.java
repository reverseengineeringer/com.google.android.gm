package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.people.identity.models.Person;
import emj;
import fux;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonImpl
  implements SafeParcelable, Person
{
  public static final fux CREATOR = new fux();
  List<PersonImpl.PlacesLivedImpl> A;
  String B;
  List<PersonImpl.RelationsImpl> C;
  List<PersonImpl.RelationshipInterestsImpl> D;
  List<PersonImpl.RelationshipStatusesImpl> E;
  List<PersonImpl.SkillsImpl> F;
  PersonImpl.SortKeysImpl G;
  List<PersonImpl.TaglinesImpl> H;
  List<PersonImpl.UrlsImpl> I;
  List<PersonImpl.NotesImpl> J;
  final Set<Integer> a;
  final int b;
  List<PersonImpl.AboutsImpl> c;
  List<PersonImpl.AddressesImpl> d;
  String e;
  List<PersonImpl.BirthdaysImpl> f;
  List<PersonImpl.BraggingRightsImpl> g;
  List<PersonImpl.CoverPhotosImpl> h;
  List<PersonImpl.CustomFieldsImpl> i;
  List<PersonImpl.EmailsImpl> j;
  String k;
  List<PersonImpl.EventsImpl> l;
  List<PersonImpl.GendersImpl> m;
  String n;
  List<PersonImpl.ImagesImpl> o;
  List<PersonImpl.InstantMessagingImpl> p;
  String q;
  PersonImpl.LegacyFieldsImpl r;
  List<PersonImpl> s;
  List<PersonImpl.MembershipsImpl> t;
  PersonImpl.PersonMetadataImpl u;
  List<PersonImpl.NamesImpl> v;
  List<PersonImpl.NicknamesImpl> w;
  List<PersonImpl.OccupationsImpl> x;
  List<PersonImpl.OrganizationsImpl> y;
  List<PersonImpl.PhoneNumbersImpl> z;
  
  public PersonImpl()
  {
    a = new HashSet();
    b = 1;
  }
  
  public PersonImpl(Set<Integer> paramSet, int paramInt, List<PersonImpl.AboutsImpl> paramList, List<PersonImpl.AddressesImpl> paramList1, String paramString1, List<PersonImpl.BirthdaysImpl> paramList2, List<PersonImpl.BraggingRightsImpl> paramList3, List<PersonImpl.CoverPhotosImpl> paramList4, List<PersonImpl.CustomFieldsImpl> paramList5, List<PersonImpl.EmailsImpl> paramList6, String paramString2, List<PersonImpl.EventsImpl> paramList7, List<PersonImpl.GendersImpl> paramList8, String paramString3, List<PersonImpl.ImagesImpl> paramList9, List<PersonImpl.InstantMessagingImpl> paramList10, String paramString4, PersonImpl.LegacyFieldsImpl paramLegacyFieldsImpl, List<PersonImpl> paramList11, List<PersonImpl.MembershipsImpl> paramList12, PersonImpl.PersonMetadataImpl paramPersonMetadataImpl, List<PersonImpl.NamesImpl> paramList13, List<PersonImpl.NicknamesImpl> paramList14, List<PersonImpl.OccupationsImpl> paramList15, List<PersonImpl.OrganizationsImpl> paramList16, List<PersonImpl.PhoneNumbersImpl> paramList17, List<PersonImpl.PlacesLivedImpl> paramList18, String paramString5, List<PersonImpl.RelationsImpl> paramList19, List<PersonImpl.RelationshipInterestsImpl> paramList20, List<PersonImpl.RelationshipStatusesImpl> paramList21, List<PersonImpl.SkillsImpl> paramList22, PersonImpl.SortKeysImpl paramSortKeysImpl, List<PersonImpl.TaglinesImpl> paramList23, List<PersonImpl.UrlsImpl> paramList24, List<PersonImpl.NotesImpl> paramList25)
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
    r = paramLegacyFieldsImpl;
    s = paramList11;
    t = paramList12;
    u = paramPersonMetadataImpl;
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
    G = paramSortKeysImpl;
    H = paramList23;
    I = paramList24;
    J = paramList25;
  }
  
  public int describeContents()
  {
    return 0;
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
      emj.a(paramParcel, 17, r, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(16))) {
      emj.a(paramParcel, 16, q, true);
    }
    if (localSet.contains(Integer.valueOf(19))) {
      emj.b(paramParcel, 19, t, true);
    }
    if (localSet.contains(Integer.valueOf(18))) {
      emj.b(paramParcel, 18, s, true);
    }
    if (localSet.contains(Integer.valueOf(21))) {
      emj.b(paramParcel, 21, v, true);
    }
    if (localSet.contains(Integer.valueOf(20))) {
      emj.a(paramParcel, 20, u, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(23))) {
      emj.b(paramParcel, 23, x, true);
    }
    if (localSet.contains(Integer.valueOf(22))) {
      emj.b(paramParcel, 22, w, true);
    }
    if (localSet.contains(Integer.valueOf(25))) {
      emj.b(paramParcel, 25, z, true);
    }
    if (localSet.contains(Integer.valueOf(24))) {
      emj.b(paramParcel, 24, y, true);
    }
    if (localSet.contains(Integer.valueOf(27))) {
      emj.a(paramParcel, 27, B, true);
    }
    if (localSet.contains(Integer.valueOf(26))) {
      emj.b(paramParcel, 26, A, true);
    }
    if (localSet.contains(Integer.valueOf(29))) {
      emj.b(paramParcel, 29, D, true);
    }
    if (localSet.contains(Integer.valueOf(28))) {
      emj.b(paramParcel, 28, C, true);
    }
    if (localSet.contains(Integer.valueOf(31))) {
      emj.b(paramParcel, 31, F, true);
    }
    if (localSet.contains(Integer.valueOf(30))) {
      emj.b(paramParcel, 30, E, true);
    }
    if (localSet.contains(Integer.valueOf(34))) {
      emj.b(paramParcel, 34, I, true);
    }
    if (localSet.contains(Integer.valueOf(35))) {
      emj.b(paramParcel, 35, J, true);
    }
    if (localSet.contains(Integer.valueOf(32))) {
      emj.a(paramParcel, 32, G, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(33))) {
      emj.b(paramParcel, 33, H, true);
    }
    emj.b(paramParcel, i1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.people.identity.internal.models.PersonImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */