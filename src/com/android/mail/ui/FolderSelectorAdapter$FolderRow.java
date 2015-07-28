package com.android.mail.ui;

import com.android.mail.providers.Folder;

public class FolderSelectorAdapter$FolderRow
  implements Comparable<FolderRow>
{
  private final Folder mFolder;
  private boolean mIsPresent;
  
  public FolderSelectorAdapter$FolderRow(Folder paramFolder, boolean paramBoolean)
  {
    mFolder = paramFolder;
    mIsPresent = paramBoolean;
  }
  
  public int compareTo(FolderRow paramFolderRow)
  {
    if (equals(paramFolderRow)) {
      return 0;
    }
    if (mIsPresent != mIsPresent)
    {
      if (mIsPresent) {
        return -1;
      }
      return 1;
    }
    return mFolder.name.compareToIgnoreCase(mFolder.name);
  }
  
  public Folder getFolder()
  {
    return mFolder;
  }
  
  public boolean isPresent()
  {
    return mIsPresent;
  }
  
  public void setIsPresent(boolean paramBoolean)
  {
    mIsPresent = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.FolderSelectorAdapter.FolderRow
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */