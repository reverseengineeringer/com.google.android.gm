package com.android.mail.ui;

import com.android.mail.providers.Folder;
import com.google.common.base.Objects;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class FolderOperation
{
  public static final Collection<FolderOperation> EMPTY = ;
  public boolean mAdd;
  public Folder mFolder;
  
  public FolderOperation(Folder paramFolder, Boolean paramBoolean)
  {
    mAdd = paramBoolean.booleanValue();
    mFolder = paramFolder;
  }
  
  public static boolean isDestructive(Collection<FolderOperation> paramCollection, Folder paramFolder)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      FolderOperation localFolderOperation = (FolderOperation)paramCollection.next();
      if ((Objects.equal(mFolder.uri, uri)) && (!mAdd)) {
        return true;
      }
      if ((paramFolder.isTrash()) && (mFolder.type == 1)) {
        return true;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.FolderOperation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */