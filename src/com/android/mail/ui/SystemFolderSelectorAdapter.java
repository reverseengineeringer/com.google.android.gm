package com.android.mail.ui;

import android.content.Context;
import android.database.Cursor;
import com.android.mail.providers.Folder;
import java.util.Set;

public final class SystemFolderSelectorAdapter
  extends FolderSelectorAdapter
{
  public SystemFolderSelectorAdapter(Context paramContext, Cursor paramCursor, int paramInt, String paramString, Folder paramFolder)
  {
    super(paramContext, paramCursor, paramInt, paramString, paramFolder);
  }
  
  public SystemFolderSelectorAdapter(Context paramContext, Cursor paramCursor, Set<String> paramSet, int paramInt, String paramString)
  {
    super(paramContext, paramCursor, paramSet, paramInt, paramString);
  }
  
  protected boolean meetsRequirements(Folder paramFolder)
  {
    return (paramFolder.supportsCapability(8)) && (paramFolder.isProviderFolder());
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.SystemFolderSelectorAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */