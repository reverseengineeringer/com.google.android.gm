package com.android.mail.drawer;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import cdh;
import com.android.mail.providers.Folder;

public class CurrentFolderDialogState
  implements Parcelable
{
  public static final Parcelable.Creator<CurrentFolderDialogState> CREATOR = new cdh();
  public String a;
  public String b;
  public Folder c;
  public boolean d;
  
  public CurrentFolderDialogState(Parcel paramParcel)
  {
    a = paramParcel.readString();
    b = paramParcel.readString();
    c = ((Folder)paramParcel.readParcelable(null));
    if (paramParcel.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      d = bool;
      return;
    }
  }
  
  public CurrentFolderDialogState(String paramString1, String paramString2, Folder paramFolder, boolean paramBoolean)
  {
    a = paramString1;
    b = paramString2;
    c = paramFolder;
    d = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = 0;
    paramParcel.writeString(a);
    paramParcel.writeString(b);
    paramParcel.writeParcelable(c, 0);
    if (d) {
      paramInt = 1;
    }
    paramParcel.writeInt(paramInt);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.drawer.CurrentFolderDialogState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */