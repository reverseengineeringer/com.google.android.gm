package com.android.mail.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.android.mail.providers.Folder;

public class ToastBarOperation
  implements Parcelable
{
  public static final Parcelable.Creator<ToastBarOperation> CREATOR = new Parcelable.Creator()
  {
    public ToastBarOperation createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ToastBarOperation(paramAnonymousParcel);
    }
    
    public ToastBarOperation[] newArray(int paramAnonymousInt)
    {
      return new ToastBarOperation[paramAnonymousInt];
    }
  };
  private final int mAction;
  private final boolean mBatch;
  private final int mCount;
  private final int mType;
  
  public ToastBarOperation(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    mCount = paramInt1;
    mAction = paramInt2;
    mBatch = paramBoolean;
    mType = paramInt3;
  }
  
  public ToastBarOperation(Parcel paramParcel)
  {
    mCount = paramParcel.readInt();
    mAction = paramParcel.readInt();
    if (paramParcel.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      mBatch = bool;
      mType = paramParcel.readInt();
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getDescription(Context paramContext, Folder paramFolder)
  {
    int i;
    switch (mAction)
    {
    case 2131755302: 
    case 2131755304: 
    case 2131755305: 
    case 2131755311: 
    case 2131755312: 
    case 2131755313: 
    case 2131755314: 
    case 2131755315: 
    default: 
      i = -1;
    }
    while (i == -1)
    {
      return "";
      i = 2131820562;
      continue;
      return paramContext.getString(2131493026, new Object[] { name });
      i = 2131820567;
      continue;
      i = 2131820560;
      continue;
      i = 2131820556;
      continue;
      i = 2131820557;
      continue;
      i = 2131820558;
      continue;
      i = 2131820555;
      continue;
      i = 2131820553;
      continue;
      i = 2131820559;
    }
    return String.format(paramContext.getResources().getQuantityString(i, mCount), new Object[] { Integer.valueOf(mCount) });
  }
  
  public String getSingularDescription(Context paramContext, Folder paramFolder)
  {
    if (mAction == 2131755300) {
      return paramContext.getString(2131493026, new Object[] { name });
    }
    int j = -1;
    int i = j;
    switch (mAction)
    {
    default: 
      i = j;
    }
    while (i == -1)
    {
      return "";
      i = 2131493024;
      continue;
      i = 2131493025;
    }
    return paramContext.getString(i);
  }
  
  public int getType()
  {
    return mType;
  }
  
  public boolean isBatchUndo()
  {
    return mBatch;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(mCount);
    paramParcel.writeInt(mAction);
    if (mBatch) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(mType);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ToastBarOperation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */