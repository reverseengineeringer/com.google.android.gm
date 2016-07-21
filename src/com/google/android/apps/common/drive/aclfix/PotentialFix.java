package com.google.android.apps.common.drive.aclfix;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import dbw;
import gvn;
import gvo;
import gvp;
import java.util.ArrayList;
import java.util.List;

public class PotentialFix
  implements Parcelable
{
  public static final Parcelable.Creator<PotentialFix> CREATOR = new dbw();
  public final String a;
  public final List<String> b;
  public final List<String> c;
  public final List<String> d;
  public final boolean e;
  public final String f;
  public final List<String> g;
  
  public PotentialFix(Parcel paramParcel)
  {
    a = paramParcel.readString();
    b = new ArrayList();
    paramParcel.readStringList(b);
    c = new ArrayList();
    paramParcel.readStringList(c);
    d = new ArrayList();
    paramParcel.readStringList(d);
    if (paramParcel.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      e = bool;
      f = paramParcel.readString();
      g = new ArrayList();
      paramParcel.readStringList(g);
      return;
    }
  }
  
  public PotentialFix(gvn paramgvn)
  {
    a = optionType;
    b = fixableRecipientEmailAddresses;
    c = fixableFileIds;
    e = fixesEverything.booleanValue();
    Object localObject1 = allowedRoles;
    d = new ArrayList();
    if (((List)localObject1).contains("READER")) {
      d.add("READER");
    }
    if (((List)localObject1).contains("COMMENTER")) {
      d.add("COMMENTER");
    }
    if (((List)localObject1).contains("WRITER")) {
      d.add("WRITER");
    }
    localObject1 = increaseDomainVisibilityInfo;
    if (localObject1 != null) {}
    for (localObject1 = domainDisplayName;; localObject1 = null)
    {
      f = ((String)localObject1);
      localObject1 = addCollaboratorsInfo;
      paramgvn = (gvn)localObject2;
      if (localObject1 != null) {
        paramgvn = outOfDomainWarningEmailAddresses;
      }
      g = paramgvn;
      return;
    }
  }
  
  public static boolean a(String paramString)
  {
    return ("ADD_COLLABORATORS".equals(paramString)) || ("INCREASE_PUBLIC_VISIBILITY".equals(paramString)) || ("INCREASE_DOMAIN_VISIBILITY".equals(paramString));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(a);
    paramParcel.writeStringList(b);
    paramParcel.writeStringList(c);
    paramParcel.writeStringList(d);
    if (e) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(f);
      paramParcel.writeStringList(g);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.apps.common.drive.aclfix.PotentialFix
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */