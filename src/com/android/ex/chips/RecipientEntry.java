package com.android.ex.chips;

import android.net.Uri;

public class RecipientEntry
{
  private final long mContactId;
  private final long mDataId;
  private final String mDestination;
  private final String mDestinationLabel;
  private final int mDestinationType;
  private final String mDisplayName;
  private final int mEntryType;
  private final boolean mIsDivider;
  private boolean mIsFirstLevel;
  private byte[] mPhotoBytes;
  private final Uri mPhotoThumbnailUri;
  
  private RecipientEntry(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, long paramLong1, long paramLong2, Uri paramUri, boolean paramBoolean)
  {
    mEntryType = paramInt1;
    mIsFirstLevel = paramBoolean;
    mDisplayName = paramString1;
    mDestination = paramString2;
    mDestinationType = paramInt2;
    mDestinationLabel = paramString3;
    mContactId = paramLong1;
    mDataId = paramLong2;
    mPhotoThumbnailUri = paramUri;
    mPhotoBytes = null;
    mIsDivider = false;
  }
  
  public static RecipientEntry constructFakeEntry(String paramString)
  {
    return new RecipientEntry(0, paramString, paramString, -1, null, -1L, -1L, null, true);
  }
  
  public static RecipientEntry constructGeneratedEntry(String paramString1, String paramString2)
  {
    return new RecipientEntry(0, paramString1, paramString2, -1, null, -2L, -2L, null, true);
  }
  
  public static RecipientEntry constructSecondLevelEntry(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, long paramLong1, long paramLong2, String paramString4)
  {
    String str = pickDisplayName(paramInt1, paramString1, paramString2);
    if (paramString4 != null) {}
    for (paramString1 = Uri.parse(paramString4);; paramString1 = null) {
      return new RecipientEntry(0, str, paramString2, paramInt2, paramString3, paramLong1, paramLong2, paramString1, false);
    }
  }
  
  public static RecipientEntry constructTopLevelEntry(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, long paramLong1, long paramLong2, String paramString4)
  {
    String str = pickDisplayName(paramInt1, paramString1, paramString2);
    if (paramString4 != null) {}
    for (paramString1 = Uri.parse(paramString4);; paramString1 = null) {
      return new RecipientEntry(0, str, paramString2, paramInt2, paramString3, paramLong1, paramLong2, paramString1, true);
    }
  }
  
  public static boolean isCreatedRecipient(long paramLong)
  {
    return (paramLong == -1L) || (paramLong == -2L);
  }
  
  private static String pickDisplayName(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt > 20) {
      return paramString1;
    }
    return paramString2;
  }
  
  public long getContactId()
  {
    return mContactId;
  }
  
  public long getDataId()
  {
    return mDataId;
  }
  
  public String getDestination()
  {
    return mDestination;
  }
  
  public String getDestinationLabel()
  {
    return mDestinationLabel;
  }
  
  public int getDestinationType()
  {
    return mDestinationType;
  }
  
  public String getDisplayName()
  {
    return mDisplayName;
  }
  
  public int getEntryType()
  {
    return mEntryType;
  }
  
  public byte[] getPhotoBytes()
  {
    try
    {
      byte[] arrayOfByte = mPhotoBytes;
      return arrayOfByte;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Uri getPhotoThumbnailUri()
  {
    return mPhotoThumbnailUri;
  }
  
  public boolean isFirstLevel()
  {
    return mIsFirstLevel;
  }
  
  public boolean isSelectable()
  {
    return mEntryType == 0;
  }
  
  public void setPhotoBytes(byte[] paramArrayOfByte)
  {
    try
    {
      mPhotoBytes = paramArrayOfByte;
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.ex.chips.RecipientEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */