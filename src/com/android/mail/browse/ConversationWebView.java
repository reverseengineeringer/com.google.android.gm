package com.android.mail.browse;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.webkit.WebView;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class ConversationWebView
  extends WebView
  implements ScrollNotifier
{
  private static final String LOG_TAG = ;
  private Bitmap mBitmap;
  private int mCachedContentHeight;
  private Canvas mCanvas;
  private final float mDensity;
  private boolean mHandlingTouch;
  private final Runnable mNotifyPageRenderedInHardwareLayer = new Runnable()
  {
    public void run()
    {
      ConversationWebView.access$002(ConversationWebView.this, false);
      ConversationWebView.this.destroyBitmap();
      invalidate();
    }
  };
  private final Set<ScrollNotifier.ScrollListener> mScrollListeners = new CopyOnWriteArraySet();
  private ContentSizeChangeListener mSizeChangeListener;
  private boolean mUseSoftwareLayer;
  private final int mViewportWidth;
  private boolean mVisible;
  private final int mWebviewInitialDelay;
  
  public ConversationWebView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ConversationWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = getResources();
    mViewportWidth = paramContext.getInteger(2131361829);
    mWebviewInitialDelay = paramContext.getInteger(2131361836);
    mDensity = getDisplayMetricsdensity;
  }
  
  private void destroyBitmap()
  {
    if (mBitmap != null)
    {
      mBitmap.recycle();
      mBitmap = null;
      mCanvas = null;
    }
  }
  
  public void addScrollListener(ScrollNotifier.ScrollListener paramScrollListener)
  {
    mScrollListeners.add(paramScrollListener);
  }
  
  public int computeHorizontalScrollExtent()
  {
    return super.computeHorizontalScrollExtent();
  }
  
  public int computeHorizontalScrollOffset()
  {
    return super.computeHorizontalScrollOffset();
  }
  
  public int computeHorizontalScrollRange()
  {
    return super.computeHorizontalScrollRange();
  }
  
  public int computeVerticalScrollExtent()
  {
    return super.computeVerticalScrollExtent();
  }
  
  public int computeVerticalScrollOffset()
  {
    return super.computeVerticalScrollOffset();
  }
  
  public int computeVerticalScrollRange()
  {
    return super.computeVerticalScrollRange();
  }
  
  public void destroy()
  {
    destroyBitmap();
    removeCallbacks(mNotifyPageRenderedInHardwareLayer);
    super.destroy();
  }
  
  public float getInitialScale()
  {
    return mDensity;
  }
  
  public int getViewportWidth()
  {
    return mViewportWidth;
  }
  
  public void invalidate()
  {
    super.invalidate();
    if (mSizeChangeListener != null)
    {
      int i = getContentHeight();
      if (i != mCachedContentHeight)
      {
        mCachedContentHeight = i;
        mSizeChangeListener.onHeightChange(i);
      }
    }
  }
  
  public boolean isHandlingTouch()
  {
    return mHandlingTouch;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((!mUseSoftwareLayer) || (!mVisible) || (getWidth() <= 0) || (getHeight() <= 0) || (mBitmap == null)) {}
    try
    {
      mBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
      mCanvas = new Canvas(mBitmap);
      if (mBitmap != null)
      {
        int i = getScrollX();
        int j = getScrollY();
        mCanvas.save();
        mCanvas.translate(-i, -j);
        super.onDraw(mCanvas);
        mCanvas.restore();
        paramCanvas.drawBitmap(mBitmap, i, j, null);
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        mBitmap = null;
        mCanvas = null;
        mUseSoftwareLayer = false;
      }
    }
  }
  
  public void onRenderComplete()
  {
    if (mUseSoftwareLayer) {
      postDelayed(mNotifyPageRenderedInHardwareLayer, mWebviewInitialDelay);
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Iterator localIterator = mScrollListeners.iterator();
    while (localIterator.hasNext()) {
      ((ScrollNotifier.ScrollListener)localIterator.next()).onNotifierScroll(paramInt1, paramInt2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      mHandlingTouch = true;
      continue;
      LogUtils.d(LOG_TAG, "WebView disabling intercepts: POINTER_DOWN", new Object[0]);
      requestDisallowInterceptTouchEvent(true);
      continue;
      mHandlingTouch = false;
    }
  }
  
  public void onUserVisibilityChanged(boolean paramBoolean)
  {
    mVisible = paramBoolean;
  }
  
  public int screenPxToWebPx(int paramInt)
  {
    return (int)(paramInt / getInitialScale());
  }
  
  public float screenPxToWebPxError(int paramInt)
  {
    return paramInt / getInitialScale() - screenPxToWebPx(paramInt);
  }
  
  public void setContentSizeChangeListener(ContentSizeChangeListener paramContentSizeChangeListener)
  {
    mSizeChangeListener = paramContentSizeChangeListener;
  }
  
  public void setUseSoftwareLayer(boolean paramBoolean)
  {
    mUseSoftwareLayer = paramBoolean;
  }
  
  public static abstract interface ContentSizeChangeListener
  {
    public abstract void onHeightChange(int paramInt);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ConversationWebView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */