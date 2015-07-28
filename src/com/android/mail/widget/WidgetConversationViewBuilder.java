package com.android.mail.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.RemoteViews;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.ui.FolderDisplayer;
import java.util.Iterator;
import java.util.SortedSet;

public class WidgetConversationViewBuilder
{
  private static Bitmap ATTACHMENT;
  private static int DATE_FONT_SIZE;
  private static int DATE_TEXT_COLOR;
  private static int SUBJECT_FONT_SIZE;
  private static int SUBJECT_TEXT_COLOR_READ;
  private static int SUBJECT_TEXT_COLOR_UNREAD;
  private final Context mContext;
  private WidgetFolderDisplayer mFolderDisplayer;
  
  public WidgetConversationViewBuilder(Context paramContext, Account paramAccount)
  {
    mContext = paramContext;
    paramContext = paramContext.getResources();
    DATE_FONT_SIZE = paramContext.getDimensionPixelSize(2131427407);
    SUBJECT_FONT_SIZE = paramContext.getDimensionPixelSize(2131427406);
    SUBJECT_TEXT_COLOR_READ = paramContext.getColor(2131296264);
    SUBJECT_TEXT_COLOR_UNREAD = paramContext.getColor(2131296261);
    DATE_TEXT_COLOR = paramContext.getColor(2131296267);
    ATTACHMENT = BitmapFactory.decodeResource(paramContext, 2130837562);
  }
  
  private CharSequence addStyle(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramCharSequence);
    localSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(paramInt1), 0, paramCharSequence.length(), 33);
    if (paramInt2 != 0) {
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(paramInt2), 0, paramCharSequence.length(), 33);
    }
    return localSpannableStringBuilder;
  }
  
  public RemoteViews getStyledView(CharSequence paramCharSequence1, CharSequence paramCharSequence2, Conversation paramConversation, Folder paramFolder, SpannableStringBuilder paramSpannableStringBuilder, String paramString)
  {
    int i;
    int j;
    label43:
    RemoteViews localRemoteViews;
    if (!read)
    {
      i = 1;
      paramCharSequence1 = paramConversation.getSnippet();
      boolean bool = hasAttachments;
      paramCharSequence2 = addStyle(paramCharSequence2, DATE_FONT_SIZE, DATE_TEXT_COLOR);
      if (i == 0) {
        break label265;
      }
      j = SUBJECT_TEXT_COLOR_UNREAD;
      paramCharSequence1 = Conversation.getSubjectAndSnippetForDisplay(mContext, paramString, paramCharSequence1);
      if (i != 0) {
        paramCharSequence1.setSpan(new StyleSpan(1), 0, paramString.length(), 33);
      }
      paramCharSequence1.setSpan(new ForegroundColorSpan(j), 0, paramCharSequence1.length(), 33);
      paramString = addStyle(paramCharSequence1, SUBJECT_FONT_SIZE, 0);
      paramCharSequence1 = null;
      if (bool) {
        paramCharSequence1 = ATTACHMENT;
      }
      localRemoteViews = new RemoteViews(mContext.getPackageName(), 2130968699);
      localRemoteViews.setTextViewText(2131755287, paramSpannableStringBuilder);
      localRemoteViews.setTextViewText(2131755286, paramCharSequence2);
      localRemoteViews.setTextViewText(2131755288, paramString);
      if (paramCharSequence1 == null) {
        break label273;
      }
      localRemoteViews.setViewVisibility(2131755285, 0);
      localRemoteViews.setImageViewBitmap(2131755285, paramCharSequence1);
      label185:
      if (i == 0) {
        break label285;
      }
      localRemoteViews.setViewVisibility(2131755279, 0);
      localRemoteViews.setViewVisibility(2131755280, 8);
    }
    for (;;)
    {
      if (mContext.getResources().getBoolean(2131689476))
      {
        mFolderDisplayer = new WidgetFolderDisplayer(mContext);
        mFolderDisplayer.loadConversationFolders(paramConversation, paramFolder);
        mFolderDisplayer.displayFolders(localRemoteViews);
      }
      return localRemoteViews;
      i = 0;
      break;
      label265:
      j = SUBJECT_TEXT_COLOR_READ;
      break label43;
      label273:
      localRemoteViews.setViewVisibility(2131755285, 8);
      break label185;
      label285:
      localRemoteViews.setViewVisibility(2131755279, 8);
      localRemoteViews.setViewVisibility(2131755280, 0);
    }
  }
  
  protected static class WidgetFolderDisplayer
    extends FolderDisplayer
  {
    public WidgetFolderDisplayer(Context paramContext)
    {
      super();
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
}

/* Location:
 * Qualified Name:     com.android.mail.widget.WidgetConversationViewBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */