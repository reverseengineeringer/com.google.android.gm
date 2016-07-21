package com.android.mail.providers;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import cgl;
import hef;
import hii;
import java.util.Collection;
import java.util.Collections;

public class FolderList
  implements Parcelable
{
  public static final Parcelable.Creator<FolderList> CREATOR = new cgl();
  private static final FolderList b = new FolderList(Collections.emptyList());
  public final hef<Folder> a;
  
  public FolderList(Parcel paramParcel)
  {
    a = hef.a(paramParcel.createTypedArrayList(Folder.CREATOR));
  }
  
  private FolderList(Collection<Folder> paramCollection)
  {
    if (paramCollection == null)
    {
      a = hii.a;
      return;
    }
    a = hef.a(paramCollection);
  }
  
  public static FolderList a(Collection<Folder> paramCollection)
  {
    return new FolderList(paramCollection);
  }
  
  public static FolderList a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return b;
    }
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    paramArrayOfByte = (FolderList)CREATOR.createFromParcel(localParcel);
    localParcel.recycle();
    return paramArrayOfByte;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a.equals(paramObject);
  }
  
  public int hashCode()
  {
    return a.hashCode();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedList(a);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.FolderList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */