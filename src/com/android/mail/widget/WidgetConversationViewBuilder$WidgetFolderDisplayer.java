package com.android.mail.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.widget.RemoteViews;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.ui.FolderDisplayer;
import java.util.Iterator;
import java.util.SortedSet;

public class WidgetConversationViewBuilder$WidgetFolderDisplayer
  extends FolderDisplayer
{
  public WidgetConversationViewBuilder$WidgetFolderDisplayer(Context paramContext)
  {
    super(paramContext);
  }
  
  private int getFolderViewId(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return 2131755281;
    case 1: 
      return 2131755282;
    }
    return 2131755283;
  }
  
  public void displayFolders(RemoteViews paramRemoteViews)
  {
    int i = 0;
    Iterator localIterator = mFoldersSortedSet.iterator();
    int j;
    do
    {
      do
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Folder)localIterator.next();
        j = getFolderViewId(i);
      } while (j == 0);
      paramRemoteViews.setViewVisibility(j, 0);
      int k = ((Folder)localObject).getBackgroundColor(mDefaultBgColor);
      Object localObject = Bitmap.Config.RGB_565;
      paramRemoteViews.setImageViewBitmap(j, Bitmap.createBitmap(new int[] { k }, 1, 1, (Bitmap.Config)localObject));
      j = i + 1;
      i = j;
    } while (j != 3);
    while (j < 3)
    {
      paramRemoteViews.setViewVisibility(getFolderViewId(j), 8);
      j += 1;
    }
  }
  
  public void loadConversationFolders(Conversation paramConversation, Folder paramFolder)
  {
    super.loadConversationFolders(paramConversation, paramFolder);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.widget.WidgetConversationViewBuilder.WidgetFolderDisplayer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */