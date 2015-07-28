package com.android.mail.ui;

import android.content.Context;
import android.content.res.Resources;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.utils.LogTag;
import com.google.common.collect.Sets;
import java.util.SortedSet;

public class FolderDisplayer
{
  public static final String LOG_TAG = ;
  protected Context mContext;
  protected final int mDefaultBgColor;
  protected final int mDefaultFgColor;
  protected final SortedSet<Folder> mFoldersSortedSet = Sets.newTreeSet();
  
  public FolderDisplayer(Context paramContext)
  {
    mContext = paramContext;
    mDefaultFgColor = paramContext.getResources().getColor(2131296276);
    mDefaultBgColor = paramContext.getResources().getColor(2131296275);
  }
  
  public void loadConversationFolders(Conversation paramConversation, Folder paramFolder)
  {
    mFoldersSortedSet.clear();
    mFoldersSortedSet.addAll(paramConversation.getRawFoldersForDisplay(paramFolder));
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.FolderDisplayer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */