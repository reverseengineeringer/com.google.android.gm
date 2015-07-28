package com.android.mail.browse;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import com.android.mail.providers.Folder;
import com.android.mail.ui.FolderDisplayer;
import java.util.Iterator;
import java.util.SortedSet;

class ConversationViewHeader$ConversationFolderDisplayer
  extends FolderDisplayer
{
  private FolderSpan.FolderSpanDimensions mDims;
  
  public ConversationViewHeader$ConversationFolderDisplayer(Context paramContext, FolderSpan.FolderSpanDimensions paramFolderSpanDimensions)
  {
    super(paramContext);
    mDims = paramFolderSpanDimensions;
  }
  
  private void addSpan(SpannableStringBuilder paramSpannableStringBuilder, Folder paramFolder)
  {
    int i = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.append(name);
    int j = paramSpannableStringBuilder.length();
    int k = paramFolder.getForegroundColor(mDefaultFgColor);
    paramSpannableStringBuilder.setSpan(new BackgroundColorSpan(paramFolder.getBackgroundColor(mDefaultBgColor)), i, j, 33);
    paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(k), i, j, 33);
    paramSpannableStringBuilder.setSpan(new FolderSpan(paramSpannableStringBuilder, mDims), i, j, 33);
  }
  
  public void appendFolderSpans(SpannableStringBuilder paramSpannableStringBuilder)
  {
    Object localObject = mFoldersSortedSet.iterator();
    while (((Iterator)localObject).hasNext()) {
      addSpan(paramSpannableStringBuilder, (Folder)((Iterator)localObject).next());
    }
    if (mFoldersSortedSet.isEmpty())
    {
      localObject = Folder.newUnsafeInstance();
      Resources localResources = mContext.getResources();
      name = localResources.getString(2131493038);
      bgColor = ("" + localResources.getColor(2131296286));
      fgColor = ("" + localResources.getColor(2131296285));
      addSpan(paramSpannableStringBuilder, (Folder)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ConversationViewHeader.ConversationFolderDisplayer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */