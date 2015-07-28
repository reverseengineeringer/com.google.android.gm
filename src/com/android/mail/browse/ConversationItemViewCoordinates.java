package com.android.mail.browse;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.android.mail.ui.ViewMode;

public class ConversationItemViewCoordinates
{
  private static int COLOR_BLOCK_HEIGHT;
  private static int COLOR_BLOCK_WIDTH;
  private static int FOLDER_CELL_WIDTH;
  private static int TOTAL_FOLDER_WIDTH = -1;
  private static int TOTAL_FOLDER_WIDTH_WIDE = -1;
  private static SparseArray<ConversationItemViewCoordinates> mCache;
  private static int[] sConversationHeights;
  private static TextPaint sPaint;
  int checkmarkX;
  int checkmarkY;
  int dateAscent;
  int dateFontSize;
  int dateXEnd;
  int dateY;
  int foldersAscent;
  int foldersFontSize;
  int foldersHeight;
  int foldersTopPadding;
  int foldersXEnd;
  int foldersY;
  int paperclipY;
  int personalLevelX;
  int personalLevelY;
  int replyStateX;
  int replyStateY;
  int sendersAscent;
  int sendersFontSize;
  int sendersLineCount;
  int sendersLineHeight;
  TextView sendersView;
  int sendersWidth;
  int sendersX;
  int sendersY;
  boolean showColorBlock;
  boolean showFolders;
  boolean showPersonalLevel;
  boolean showReplyState;
  int starX;
  int starY;
  int subjectAscent;
  int subjectFontSize;
  int subjectLineCount;
  int subjectWidth;
  int subjectX;
  int subjectY;
  
  static
  {
    FOLDER_CELL_WIDTH = -1;
    COLOR_BLOCK_WIDTH = -1;
    COLOR_BLOCK_HEIGHT = -1;
    mCache = new SparseArray();
    sPaint = new TextPaint();
    sPaint.setAntiAlias(true);
  }
  
  public static boolean displaySendersInline(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Unknown conversation header view mode " + paramInt);
    case 0: 
      return false;
    }
    return true;
  }
  
  public static ConversationItemViewCoordinates forWidth(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject2 = (ConversationItemViewCoordinates)mCache.get(paramInt1 ^ paramInt3);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new ConversationItemViewCoordinates();
      mCache.put(paramInt1 ^ paramInt3, localObject1);
      paramInt3 = getHeight(paramContext, paramInt2);
      paramContext = LayoutInflater.from(paramContext).inflate(getLayoutId(paramInt2), null);
      paramContext.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt3, 1073741824));
      paramContext.layout(0, 0, paramInt1, paramInt3);
      localObject2 = paramContext.findViewById(2131755103);
      checkmarkX = getX((View)localObject2);
      checkmarkY = getY((View)localObject2);
      localObject2 = paramContext.findViewById(2131755104);
      starX = getX((View)localObject2);
      starY = getY((View)localObject2);
      localObject2 = paramContext.findViewById(2131755009);
      if (localObject2 == null) {
        break label628;
      }
      showPersonalLevel = true;
      personalLevelX = getX((View)localObject2);
      personalLevelY = getY((View)localObject2);
      localObject2 = (TextView)paramContext.findViewById(2131755100);
      sendersView = ((TextView)localObject2);
      sendersX = getX((View)localObject2);
      sendersY = getY((View)localObject2);
      sendersWidth = ((TextView)localObject2).getWidth();
      sendersLineCount = getLineCount((TextView)localObject2);
      sendersLineHeight = ((TextView)localObject2).getLineHeight();
      sendersFontSize = ((int)((TextView)localObject2).getTextSize());
      sPaint.setTextSize(sendersFontSize);
      sendersAscent = ((int)sPaint.ascent());
      localObject2 = (TextView)paramContext.findViewById(2131755083);
      subjectX = getX((View)localObject2);
      subjectY = getY((View)localObject2);
      subjectWidth = ((TextView)localObject2).getWidth();
      subjectLineCount = getLineCount((TextView)localObject2);
      subjectFontSize = ((int)((TextView)localObject2).getTextSize());
      sPaint.setTextSize(subjectFontSize);
      subjectAscent = ((int)sPaint.ascent());
      localObject2 = paramContext.findViewById(2131755051);
      if (localObject2 == null) {
        break label637;
      }
      showFolders = true;
      foldersXEnd = (getX((View)localObject2) + ((View)localObject2).getWidth());
      foldersY = getY((View)localObject2);
      foldersHeight = ((View)localObject2).getHeight();
      foldersTopPadding = ((View)localObject2).getPaddingTop();
      if ((localObject2 instanceof TextView))
      {
        foldersFontSize = ((int)((TextView)localObject2).getTextSize());
        sPaint.setTextSize(foldersFontSize);
        foldersAscent = ((int)sPaint.ascent());
      }
      label481:
      if (paramContext.findViewById(2131755196) != null) {
        showColorBlock = true;
      }
      localObject2 = paramContext.findViewById(2131755010);
      if (localObject2 == null) {
        break label646;
      }
      showReplyState = true;
      replyStateX = getX((View)localObject2);
      replyStateY = getY((View)localObject2);
    }
    for (;;)
    {
      localObject2 = (TextView)paramContext.findViewById(2131755102);
      dateXEnd = (getX((View)localObject2) + ((TextView)localObject2).getWidth());
      dateY = getY((View)localObject2);
      dateFontSize = ((int)((TextView)localObject2).getTextSize());
      sPaint.setTextSize(dateFontSize);
      dateAscent = ((int)sPaint.ascent());
      paperclipY = getY(paramContext.findViewById(2131755101));
      return (ConversationItemViewCoordinates)localObject1;
      label628:
      showPersonalLevel = false;
      break;
      label637:
      showFolders = false;
      break label481;
      label646:
      showReplyState = false;
    }
  }
  
  public static int getColorBlockHeight(Context paramContext)
  {
    paramContext = paramContext.getResources();
    if (COLOR_BLOCK_HEIGHT <= 0) {
      COLOR_BLOCK_HEIGHT = paramContext.getDimensionPixelSize(2131427356);
    }
    return COLOR_BLOCK_HEIGHT;
  }
  
  public static int getColorBlockWidth(Context paramContext)
  {
    paramContext = paramContext.getResources();
    if (COLOR_BLOCK_WIDTH <= 0) {
      COLOR_BLOCK_WIDTH = paramContext.getDimensionPixelSize(2131427355);
    }
    return COLOR_BLOCK_WIDTH;
  }
  
  public static int[] getDensityDependentArray(int[] paramArrayOfInt, float paramFloat)
  {
    int[] arrayOfInt = new int[paramArrayOfInt.length];
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      arrayOfInt[i] = ((int)(paramArrayOfInt[i] * paramFloat));
      i += 1;
    }
    return arrayOfInt;
  }
  
  public static int getFolderCellWidth(Context paramContext, int paramInt1, int paramInt2)
  {
    paramContext = paramContext.getResources();
    if (FOLDER_CELL_WIDTH <= 0) {
      FOLDER_CELL_WIDTH = paramContext.getDimensionPixelSize(2131427368);
    }
    switch (paramInt1)
    {
    default: 
      throw new IllegalArgumentException("Unknown conversation header view mode " + paramInt1);
    }
    return FOLDER_CELL_WIDTH;
  }
  
  public static int getFoldersWidth(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources();
    if (TOTAL_FOLDER_WIDTH <= 0)
    {
      TOTAL_FOLDER_WIDTH = paramContext.getDimensionPixelSize(2131427353);
      TOTAL_FOLDER_WIDTH_WIDE = paramContext.getDimensionPixelSize(2131427354);
    }
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Unknown conversation header view mode " + paramInt);
    case 0: 
      return TOTAL_FOLDER_WIDTH_WIDE;
    }
    return TOTAL_FOLDER_WIDTH;
  }
  
  public static int getHeight(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources();
    float f = getDisplayMetricsscaledDensity;
    if (sConversationHeights == null) {
      sConversationHeights = getDensityDependentArray(paramContext.getIntArray(2131623936), f);
    }
    return sConversationHeights[paramInt];
  }
  
  private static int getLayoutId(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Unknown conversation header view mode " + paramInt);
    case 0: 
      return 2130968608;
    }
    return 2130968607;
  }
  
  private static int getLineCount(TextView paramTextView)
  {
    return Math.round(paramTextView.getHeight() / paramTextView.getLineHeight());
  }
  
  public static int getMinHeight(Context paramContext, ViewMode paramViewMode)
  {
    int i = getMode(paramContext, paramViewMode);
    paramContext = paramContext.getResources();
    if (i == 0) {}
    for (i = 2131427413;; i = 2131427412) {
      return paramContext.getDimensionPixelSize(i);
    }
  }
  
  public static int getMode(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources();
    switch (paramInt)
    {
    case 3: 
    default: 
      return paramContext.getInteger(2131361812);
    case 2: 
      return paramContext.getInteger(2131361811);
    }
    return paramContext.getInteger(2131361813);
  }
  
  public static int getMode(Context paramContext, ViewMode paramViewMode)
  {
    return getMode(paramContext, paramViewMode.getMode());
  }
  
  public static int getSubjectLength(Context paramContext, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        return paramContext.getResources().getIntArray(2131623937)[paramInt];
      }
      return paramContext.getResources().getIntArray(2131623938)[paramInt];
    }
    if (paramBoolean2) {
      return paramContext.getResources().getIntArray(2131623939)[paramInt];
    }
    return paramContext.getResources().getIntArray(2131623940)[paramInt];
  }
  
  private static int getX(View paramView)
  {
    int i = 0;
    if (paramView != null)
    {
      i += (int)paramView.getX();
      paramView = paramView.getParent();
      if (paramView != null) {}
      for (paramView = (View)paramView;; paramView = null) {
        break;
      }
    }
    return i;
  }
  
  private static int getY(View paramView)
  {
    int i = 0;
    if (paramView != null)
    {
      i += (int)paramView.getY();
      paramView = paramView.getParent();
      if (paramView != null) {}
      for (paramView = (View)paramView;; paramView = null) {
        break;
      }
    }
    return i;
  }
  
  public static boolean isWideMode(int paramInt)
  {
    return paramInt == 0;
  }
  
  public static void refreshConversationHeights(Context paramContext)
  {
    paramContext = paramContext.getResources();
    float f = getDisplayMetricsscaledDensity;
    sConversationHeights = getDensityDependentArray(paramContext.getIntArray(2131623936), f);
  }
  
  public static boolean showAttachmentBackground(int paramInt)
  {
    return paramInt != 0;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ConversationItemViewCoordinates
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */