package com.android.mail.browse;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Shader.TileMode;
import android.text.TextPaint;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.ui.FolderDisplayer;
import com.android.mail.utils.Utils;
import java.util.Iterator;
import java.util.SortedSet;

class ConversationItemView$ConversationItemFolderDisplayer
  extends FolderDisplayer
{
  private int mFoldersCount;
  private boolean mHasMoreFolders;
  
  public ConversationItemView$ConversationItemFolderDisplayer(Context paramContext)
  {
    super(paramContext);
  }
  
  private int measureFolders(int paramInt)
  {
    int k = ConversationItemViewCoordinates.getFoldersWidth(mContext, paramInt);
    int m = ConversationItemViewCoordinates.getFolderCellWidth(mContext, paramInt, mFoldersCount);
    paramInt = 0;
    Iterator localIterator = mFoldersSortedSet.iterator();
    int i;
    do
    {
      i = paramInt;
      if (!localIterator.hasNext()) {
        break;
      }
      String str = nextname;
      int j = (int)ConversationItemView.access$000().measureText(str) + m;
      i = j;
      if (j % m != 0) {
        i = j + (m - j % m);
      }
      i = paramInt + i;
      paramInt = i;
    } while (i <= k);
    return i;
  }
  
  public void drawFolders(Canvas paramCanvas, ConversationItemViewCoordinates paramConversationItemViewCoordinates, int paramInt1, int paramInt2)
  {
    if (mFoldersCount == 0) {
      return;
    }
    int i2;
    int i3;
    int i4;
    int i5;
    int j;
    int n;
    int i6;
    int i7;
    int i;
    Iterator localIterator;
    while (!localIterator.hasNext())
    {
      i2 = foldersY - foldersAscent;
      i3 = foldersHeight;
      i4 = foldersTopPadding;
      i5 = foldersAscent;
      ConversationItemView.access$000().setTextSize(foldersFontSize);
      j = ConversationItemViewCoordinates.getFoldersWidth(mContext, paramInt2);
      n = j / mFoldersCount;
      i6 = ConversationItemViewCoordinates.getFolderCellWidth(mContext, paramInt2, mFoldersCount);
      i7 = measureFolders(paramInt2);
      i = paramInt1 - Math.min(j, i7);
      localIterator = mFoldersSortedSet.iterator();
    }
    Object localObject = (Folder)localIterator.next();
    String str = name;
    int i8 = ((Folder)localObject).getForegroundColor(mDefaultFgColor);
    int i9 = ((Folder)localObject).getBackgroundColor(mDefaultBgColor);
    int i1 = 0;
    int k = (int)ConversationItemView.access$000().measureText(str) + i6;
    paramInt2 = k;
    if (k % i6 != 0) {
      paramInt2 = k + (i6 - k % i6);
    }
    int m = i1;
    k = paramInt2;
    if (i7 > j)
    {
      m = i1;
      k = paramInt2;
      if (paramInt2 > n)
      {
        k = n;
        m = 1;
      }
    }
    ConversationItemView.access$000().setColor(i9);
    ConversationItemView.access$000().setStyle(Paint.Style.FILL_AND_STROKE);
    paramCanvas.drawRect(i, i2 + i5, i + k, i2 + i5 + i3, ConversationItemView.access$000());
    paramInt2 = ConversationItemView.access$100(k, (int)ConversationItemView.access$000().measureText(str));
    if (m != 0)
    {
      localObject = new TextPaint();
      ((TextPaint)localObject).setColor(i8);
      ((TextPaint)localObject).setTextSize(foldersFontSize);
      paramInt2 = i6 / 2;
      m = i + k - paramInt2;
      ((TextPaint)localObject).setShader(new LinearGradient(m - paramInt2, i2, m, i2, i8, Utils.getTransparentColor(i8), Shader.TileMode.CLAMP));
      paramCanvas.drawText(str, i + paramInt2, i2 + i4, (Paint)localObject);
    }
    for (;;)
    {
      paramInt2 = j - k;
      k = i + k;
      j = paramInt2;
      i = k;
      if (paramInt2 > 0) {
        break;
      }
      j = paramInt2;
      i = k;
      if (!mHasMoreFolders) {
        break;
      }
      paramCanvas.drawBitmap(ConversationItemView.access$200(), paramInt1, i2 + i5, ConversationItemView.access$000());
      return;
      ConversationItemView.access$000().setColor(i8);
      paramCanvas.drawText(str, i + paramInt2, i2 + i4, ConversationItemView.access$000());
    }
  }
  
  public boolean hasVisibleFolders()
  {
    return mFoldersCount > 0;
  }
  
  public void loadConversationFolders(Conversation paramConversation, Folder paramFolder)
  {
    super.loadConversationFolders(paramConversation, paramFolder);
    mFoldersCount = mFoldersSortedSet.size();
    if (mFoldersCount > 4) {}
    for (boolean bool = true;; bool = false)
    {
      mHasMoreFolders = bool;
      mFoldersCount = Math.min(mFoldersCount, 4);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ConversationItemView.ConversationItemFolderDisplayer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */