package com.android.mail.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;

public class ConversationListCopy
  extends View
{
  private static final String LOG_TAG = ;
  private Bitmap mBitmap;
  
  public ConversationListCopy(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ConversationListCopy(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void bind(View paramView)
  {
    unbind();
    if ((paramView.getWidth() == 0) || (paramView.getHeight() == 0)) {
      return;
    }
    try
    {
      mBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
      paramView.draw(new Canvas(mBitmap));
      return;
    }
    catch (OutOfMemoryError paramView)
    {
      LogUtils.e(LOG_TAG, paramView, "Unable to create fancy list transition bitmap", new Object[0]);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (mBitmap == null) {
      return;
    }
    paramCanvas.drawBitmap(mBitmap, 0.0F, 0.0F, null);
  }
  
  public void unbind()
  {
    if (mBitmap != null)
    {
      mBitmap.recycle();
      mBitmap = null;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ConversationListCopy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */