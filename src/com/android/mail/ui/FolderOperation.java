package com.android.mail.ui;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import cny;
import com.android.mail.providers.Folder;
import hbc;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class FolderOperation
  implements Parcelable
{
  public static final Parcelable.Creator<FolderOperation> CREATOR = new cny();
  public static final Collection<FolderOperation> a = ;
  public final Folder b;
  public final boolean c;
  
  public FolderOperation(Parcel paramParcel)
  {
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      c = bool;
      b = ((Folder)paramParcel.readParcelable(getClass().getClassLoader()));
      return;
    }
  }
  
  public FolderOperation(Folder paramFolder, Boolean paramBoolean)
  {
    c = paramBoolean.booleanValue();
    b = paramFolder;
  }
  
  public static boolean a(Collection<FolderOperation> paramCollection, Folder paramFolder)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      FolderOperation localFolderOperation = (FolderOperation)paramCollection.next();
      if ((hbc.a(b, paramFolder)) && (!c)) {
        return true;
      }
      if ((paramFolder.d(32)) && (b.d(8194))) {
        return true;
      }
    }
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (c) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeParcelable(b, 0);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.FolderOperation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */