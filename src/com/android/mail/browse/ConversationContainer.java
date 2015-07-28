package com.android.mail.browse;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.android.mail.utils.DequeMap;
import com.android.mail.utils.InputSmoother;
import com.android.mail.utils.LogUtils;
import com.android.mail.utils.Utils;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public class ConversationContainer
  extends ViewGroup
  implements ScrollNotifier.ScrollListener
{
  private static final int[] BOTTOM_LAYER_VIEW_IDS = { 2131755181 };
  private static final int[] TOP_LAYER_VIEW_IDS = { 2131755182 };
  private int mActivePointerId;
  private final DataSetObserver mAdapterObserver = new AdapterObserver(null);
  private boolean mAttachedOverlaySinceLastDraw;
  private boolean mDisableLayoutTracing;
  private float mLastMotionY;
  private boolean mMissedPointerDown;
  private final List<View> mNonScrollingChildren = Lists.newArrayList();
  private int mOffsetY;
  private ConversationViewAdapter mOverlayAdapter;
  private OverlayPosition[] mOverlayPositions;
  private final SparseArray<OverlayView> mOverlayViews = new SparseArray();
  private float mScale;
  private final DequeMap<Integer, View> mScrapViews = new DequeMap();
  private MessageHeaderView mSnapHeader;
  private int mSnapIndex;
  private View mTopMostOverlay;
  private boolean mTouchInitialized;
  private boolean mTouchIsDown = false;
  private final int mTouchSlop;
  private final InputSmoother mVelocityTracker;
  private ConversationWebView mWebView;
  private int mWidthMeasureSpec;
  
  public ConversationContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ConversationContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    mVelocityTracker = new InputSmoother(paramContext);
    mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    setMotionEventSplittingEnabled(false);
  }
  
  private View addOverlayView(int paramInt)
  {
    int i = mOverlayAdapter.getItemViewType(paramInt);
    View localView1 = (View)mScrapViews.poll(Integer.valueOf(i));
    View localView2 = mOverlayAdapter.getView(paramInt, localView1, this);
    mOverlayViews.put(paramInt, new OverlayView(localView2, i));
    i = BOTTOM_LAYER_VIEW_IDS.length;
    if (localView1 == localView2) {
      LogUtils.d("ConvLayout", "want to REUSE scrolled-in view: index=%d obj=%s", new Object[] { Integer.valueOf(paramInt), localView2 });
    }
    for (;;)
    {
      addViewInLayout(localView2, i, localView2.getLayoutParams(), true);
      mAttachedOverlaySinceLastDraw = true;
      return localView2;
      LogUtils.d("ConvLayout", "want to CREATE scrolled-in view: index=%d obj=%s", new Object[] { Integer.valueOf(paramInt), localView2 });
    }
  }
  
  private OverlayPosition calculatePosition(ConversationOverlayItem paramConversationOverlayItem, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramConversationOverlayItem.getHeight() == 0)
    {
      if (paramInt3 == 48) {}
      for (;;)
      {
        return new OverlayPosition(paramInt1, paramInt1);
        paramInt1 = paramInt2;
      }
    }
    if (paramInt3 != 0) {}
    for (;;)
    {
      paramInt3 &= 0x70;
      switch (paramInt3)
      {
      default: 
        throw new UnsupportedOperationException("unsupported gravity: " + paramInt3);
        paramInt3 = paramConversationOverlayItem.getGravity();
      }
    }
    return new OverlayPosition(paramInt2 - paramConversationOverlayItem.getHeight(), paramInt2);
    return new OverlayPosition(paramInt1, paramConversationOverlayItem.getHeight() + paramInt1);
  }
  
  private void clearOverlays()
  {
    int i = 0;
    int j = mOverlayViews.size();
    while (i < j)
    {
      detachOverlay((OverlayView)mOverlayViews.valueAt(i));
      i += 1;
    }
    mOverlayViews.clear();
  }
  
  private void detachOverlay(OverlayView paramOverlayView)
  {
    removeViewInLayout(view);
    mScrapViews.add(Integer.valueOf(itemType), view);
    if ((view instanceof DetachListener)) {
      ((DetachListener)view).onDetachedFromParent();
    }
  }
  
  private ConversationOverlayItem findNextPushingOverlay(int paramInt)
  {
    int i = mOverlayAdapter.getCount();
    while (paramInt < i)
    {
      ConversationOverlayItem localConversationOverlayItem = mOverlayAdapter.getItem(paramInt);
      if (localConversationOverlayItem.canPushSnapHeader()) {
        return localConversationOverlayItem;
      }
      paramInt += 1;
    }
    return null;
  }
  
  private void forwardFakeMotionEvent(MotionEvent paramMotionEvent, int paramInt)
  {
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    paramMotionEvent.setAction(paramInt);
    mWebView.onTouchEvent(paramMotionEvent);
    LogUtils.v("ConvLayout", "in Container.OnTouch. fake: action=%d x/y=%f/%f pointers=%d", new Object[] { Integer.valueOf(paramMotionEvent.getActionMasked()), Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()), Integer.valueOf(paramMotionEvent.getPointerCount()) });
  }
  
  private int getOverlayBottom(int paramInt)
  {
    return webPxToScreenPx(mOverlayPositions[paramInt].bottom);
  }
  
  private int getOverlayTop(int paramInt)
  {
    return webPxToScreenPx(mOverlayPositions[paramInt].top);
  }
  
  private void layoutOverlay(View paramView, int paramInt1, int paramInt2)
  {
    int i = mOffsetY;
    int j = mOffsetY;
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int k = getPaddingLeft() + leftMargin;
    paramView.layout(k, paramInt1 - i, paramView.getMeasuredWidth() + k, paramInt2 - j);
  }
  
  private void measureOverlayView(View paramView)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams2 = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    ViewGroup.MarginLayoutParams localMarginLayoutParams1 = localMarginLayoutParams2;
    if (localMarginLayoutParams2 == null) {
      localMarginLayoutParams1 = (ViewGroup.MarginLayoutParams)generateDefaultLayoutParams();
    }
    int j = ViewGroup.getChildMeasureSpec(mWidthMeasureSpec, getPaddingLeft() + getPaddingRight() + leftMargin + rightMargin, width);
    int i = height;
    if (i > 0) {}
    for (i = View.MeasureSpec.makeMeasureSpec(i, 1073741824);; i = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(j, i);
      return;
    }
  }
  
  private void onDataSetChanged()
  {
    clearOverlays();
    mSnapHeader.unbind();
    positionOverlays(0, mOffsetY);
  }
  
  private void onOverlayScrolledOff(int paramInt1, final OverlayView paramOverlayView, int paramInt2, int paramInt3)
  {
    mOverlayViews.remove(paramInt1);
    post(new Runnable()
    {
      public void run()
      {
        ConversationContainer.this.detachOverlay(paramOverlayView);
      }
    });
    layoutOverlay(view, paramInt2, paramInt3);
  }
  
  private void positionOverlay(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject1 = (OverlayView)mOverlayViews.get(paramInt1);
    ConversationOverlayItem localConversationOverlayItem = mOverlayAdapter.getItem(paramInt1);
    localConversationOverlayItem.setTop(paramInt2);
    Object localObject2;
    if ((paramInt2 != paramInt3) && (paramInt3 > mOffsetY) && (paramInt2 < mOffsetY + getHeight())) {
      if (localObject1 != null)
      {
        localObject1 = view;
        if (localObject1 != null) {
          break label187;
        }
        localObject2 = addOverlayView(paramInt1);
        measureOverlayView((View)localObject2);
        localConversationOverlayItem.markMeasurementValid();
        traceLayout("show/measure overlay %d", new Object[] { Integer.valueOf(paramInt1) });
        label108:
        traceLayout("laying out overlay %d with h=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(((View)localObject2).getMeasuredHeight()) });
        layoutOverlay((View)localObject2, paramInt2, ((View)localObject2).getMeasuredHeight() + paramInt2);
        label151:
        if ((paramInt2 <= mOffsetY) && (localConversationOverlayItem.canPushSnapHeader()))
        {
          if (mSnapIndex != -1) {
            break label331;
          }
          mSnapIndex = paramInt1;
        }
      }
    }
    label187:
    label331:
    while (paramInt1 <= mSnapIndex)
    {
      return;
      localObject1 = null;
      break;
      traceLayout("move overlay %d", new Object[] { Integer.valueOf(paramInt1) });
      localObject2 = localObject1;
      if (localConversationOverlayItem.isMeasurementValid()) {
        break label108;
      }
      measureOverlayView((View)localObject1);
      localConversationOverlayItem.markMeasurementValid();
      traceLayout("and (re)measure overlay %d, old/new heights=%d/%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(((View)localObject1).getHeight()), Integer.valueOf(((View)localObject1).getMeasuredHeight()) });
      localObject2 = localObject1;
      break label108;
      if (localObject1 != null)
      {
        traceLayout("hide overlay %d", new Object[] { Integer.valueOf(paramInt1) });
        onOverlayScrolledOff(paramInt1, (OverlayView)localObject1, paramInt2, paramInt3);
        break label151;
      }
      traceLayout("ignore non-visible overlay %d", new Object[] { Integer.valueOf(paramInt1) });
      break label151;
    }
    mSnapIndex = paramInt1;
  }
  
  private void positionOverlays(int paramInt1, int paramInt2)
  {
    mOffsetY = paramInt2;
    if (mTouchInitialized) {
      mScale = mWebView.getScale();
    }
    for (;;)
    {
      traceLayout("in positionOverlays, raw scale=%f, effective scale=%f", new Object[] { Float.valueOf(mWebView.getScale()), Float.valueOf(mScale) });
      if ((mOverlayPositions != null) && (mOverlayAdapter != null)) {
        break;
      }
      return;
      if (mScale == 0.0F) {
        mScale = mWebView.getInitialScale();
      }
    }
    traceLayout("IN positionOverlays, spacerCount=%d overlayCount=%d", new Object[] { Integer.valueOf(mOverlayPositions.length), Integer.valueOf(mOverlayAdapter.getCount()) });
    mSnapIndex = -1;
    paramInt1 = mOverlayAdapter.getCount() - 1;
    paramInt2 = mOverlayPositions.length - 1;
    if ((paramInt2 >= 0) && (paramInt1 >= 0))
    {
      int i2 = getOverlayTop(paramInt2);
      int i3 = getOverlayBottom(paramInt2);
      int i;
      int j;
      int k;
      label188:
      label198:
      ConversationOverlayItem localConversationOverlayItem;
      OverlayPosition localOverlayPosition;
      if (paramInt2 == 0)
      {
        i = 1;
        j = paramInt1;
        k = 48;
        if (i == 0) {
          break label351;
        }
        m = j - paramInt1;
        localConversationOverlayItem = mOverlayAdapter.getItem(m);
        localOverlayPosition = calculatePosition(localConversationOverlayItem, i2, i3, k);
        traceLayout("in loop, spacer=%d overlay=%d t/b=%d/%d (%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(m), Integer.valueOf(top), Integer.valueOf(bottom), localConversationOverlayItem });
        positionOverlay(m, top, bottom);
        paramInt1 -= 1;
        if (paramInt1 >= 0) {
          if (i == 0) {
            break label357;
          }
        }
      }
      label351:
      label357:
      for (int m = j - paramInt1;; m = paramInt1)
      {
        localConversationOverlayItem = mOverlayAdapter.getItem(m);
        if ((paramInt2 <= 0) || (localConversationOverlayItem.isContiguous())) {
          break label363;
        }
        paramInt2 -= 1;
        break;
        i = 0;
        j = 0;
        k = 0;
        break label188;
        m = paramInt1;
        break label198;
      }
      label363:
      int n;
      if (i != 0)
      {
        n = bottom;
        label374:
        if (i == 0) {
          break label475;
        }
      }
      label475:
      for (int i1 = i3;; i1 = top)
      {
        localOverlayPosition = calculatePosition(localConversationOverlayItem, n, i1, k);
        traceLayout("in contig loop, spacer=%d overlay=%d t/b=%d/%d (%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(m), Integer.valueOf(top), Integer.valueOf(bottom), localConversationOverlayItem });
        positionOverlay(m, top, bottom);
        break;
        n = i2;
        break label374;
      }
    }
    positionSnapHeader(mSnapIndex);
  }
  
  private void positionSnapHeader(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt != -1)
    {
      ConversationOverlayItem localConversationOverlayItem = mOverlayAdapter.getItem(paramInt);
      localObject1 = localObject2;
      if (localConversationOverlayItem.canBecomeSnapHeader()) {
        localObject1 = localConversationOverlayItem;
      }
    }
    if (localObject1 == null)
    {
      mSnapHeader.setVisibility(8);
      mSnapHeader.unbind();
      return;
    }
    ((ConversationOverlayItem)localObject1).bindView(mSnapHeader, false);
    mSnapHeader.setVisibility(0);
    int i = 0;
    localObject1 = findNextPushingOverlay(paramInt + 1);
    paramInt = i;
    if (localObject1 != null)
    {
      i = Math.min(0, ((ConversationOverlayItem)localObject1).getTop() - mSnapHeader.getHeight() - mOffsetY);
      paramInt = i;
      if (i < 0)
      {
        localObject1 = mVelocityTracker.getSmoothedVelocity();
        paramInt = i;
        if (localObject1 != null)
        {
          paramInt = i;
          if (((Float)localObject1).floatValue() > 600.0F) {
            paramInt = 0;
          }
        }
      }
    }
    mSnapHeader.setTranslationY(paramInt);
  }
  
  private void traceLayout(String paramString, Object... paramVarArgs)
  {
    if (mDisableLayoutTracing) {
      return;
    }
    LogUtils.d("ConvLayout", paramString, paramVarArgs);
  }
  
  private int webPxToScreenPx(int paramInt)
  {
    return (int)(paramInt * mScale);
  }
  
  public void addScrapView(int paramInt, View paramView)
  {
    mScrapViews.add(Integer.valueOf(paramInt), paramView);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof ViewGroup.MarginLayoutParams;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (mAttachedOverlaySinceLastDraw)
    {
      drawChild(paramCanvas, mTopMostOverlay, getDrawingTime());
      mAttachedOverlaySinceLastDraw = false;
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.MarginLayoutParams(-1, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new ViewGroup.MarginLayoutParams(paramLayoutParams);
  }
  
  public View getScrapView(int paramInt)
  {
    return (View)mScrapViews.peek(Integer.valueOf(paramInt));
  }
  
  public MessageHeaderView getSnapHeader()
  {
    return mSnapHeader;
  }
  
  public void invalidateSpacerGeometry()
  {
    mOverlayPositions = null;
  }
  
  public int measureOverlay(View paramView)
  {
    measureOverlayView(paramView);
    return paramView.getMeasuredHeight();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    mWebView = ((ConversationWebView)findViewById(2131755181));
    mWebView.addScrollListener(this);
    mTopMostOverlay = findViewById(2131755182);
    mSnapHeader = ((MessageHeaderView)findViewById(2131755183));
    mSnapHeader.setSnappy(true);
    int[] arrayOfInt = BOTTOM_LAYER_VIEW_IDS;
    int j = arrayOfInt.length;
    int i = 0;
    int k;
    while (i < j)
    {
      k = arrayOfInt[i];
      mNonScrollingChildren.add(findViewById(k));
      i += 1;
    }
    arrayOfInt = TOP_LAYER_VIEW_IDS;
    j = arrayOfInt.length;
    i = 0;
    while (i < j)
    {
      k = arrayOfInt[i];
      mNonScrollingChildren.add(findViewById(k));
      i += 1;
    }
  }
  
  public void onGeometryChange(OverlayPosition[] paramArrayOfOverlayPosition)
  {
    traceLayout("*** got overlay spacer positions:", new Object[0]);
    int j = paramArrayOfOverlayPosition.length;
    int i = 0;
    while (i < j)
    {
      OverlayPosition localOverlayPosition = paramArrayOfOverlayPosition[i];
      traceLayout("top=%d bottom=%d", new Object[] { Integer.valueOf(top), Integer.valueOf(bottom) });
      i += 1;
    }
    mOverlayPositions = paramArrayOfOverlayPosition;
    positionOverlays(0, mOffsetY);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!mTouchInitialized) {
      mTouchInitialized = true;
    }
    if (mWebView.isHandlingTouch()) {}
    float f;
    do
    {
      return false;
      switch (paramMotionEvent.getActionMasked())
      {
      case 1: 
      case 3: 
      case 4: 
      default: 
        return false;
      case 0: 
        mLastMotionY = paramMotionEvent.getY();
        mActivePointerId = paramMotionEvent.getPointerId(0);
        return false;
      case 5: 
        LogUtils.d("ConvLayout", "Container is intercepting non-primary touch!", new Object[0]);
        mMissedPointerDown = true;
        requestDisallowInterceptTouchEvent(true);
        return true;
      }
      f = paramMotionEvent.getY(paramMotionEvent.findPointerIndex(mActivePointerId));
    } while ((int)Math.abs(f - mLastMotionY) <= mTouchSlop);
    mLastMotionY = f;
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    LogUtils.d("ConvLayout", "*** IN header container onLayout", new Object[0]);
    Iterator localIterator = mNonScrollingChildren.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (localView.getVisibility() != 8)
      {
        paramInt1 = localView.getMeasuredWidth();
        paramInt2 = localView.getMeasuredHeight();
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
        paramInt3 = leftMargin;
        paramInt4 = topMargin;
        localView.layout(paramInt3, paramInt4, paramInt3 + paramInt1, paramInt4 + paramInt2);
      }
    }
    if (mOverlayAdapter != null)
    {
      paramInt1 = 0;
      paramInt2 = mOverlayAdapter.getCount();
      while (paramInt1 < paramInt2)
      {
        mOverlayAdapter.getItem(paramInt1).invalidateMeasurement();
        paramInt1 += 1;
      }
    }
    positionOverlays(0, mOffsetY);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (LogUtils.isLoggable("ConvLayout", 3)) {
      LogUtils.d("ConvLayout", "*** IN header container onMeasure spec for w/h=%s/%s", new Object[] { View.MeasureSpec.toString(paramInt1), View.MeasureSpec.toString(paramInt2) });
    }
    Iterator localIterator = mNonScrollingChildren.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (localView.getVisibility() != 8) {
        measureChildWithMargins(localView, paramInt1, 0, paramInt2, 0);
      }
    }
    mWidthMeasureSpec = paramInt1;
  }
  
  public void onNotifierScroll(int paramInt1, int paramInt2)
  {
    mVelocityTracker.onInput(paramInt2);
    mDisableLayoutTracing = true;
    positionOverlays(paramInt1, paramInt2);
    mDisableLayoutTracing = false;
  }
  
  public void onOverlayModelUpdate(List<Integer> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Integer localInteger = (Integer)paramList.next();
      ConversationOverlayItem localConversationOverlayItem = mOverlayAdapter.getItem(localInteger.intValue());
      OverlayView localOverlayView = (OverlayView)mOverlayViews.get(localInteger.intValue());
      if ((localOverlayView != null) && (view != null) && (localConversationOverlayItem != null)) {
        localConversationOverlayItem.onModelUpdated(view);
      }
      if (localInteger.intValue() == mSnapIndex) {
        mSnapHeader.refresh();
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if ((i == 1) || (i == 3)) {}
    for (mTouchIsDown = false;; mTouchIsDown = true)
    {
      do
      {
        return mWebView.onTouchEvent(paramMotionEvent);
      } while ((mTouchIsDown) || ((i != 2) && (i != 5)));
      forwardFakeMotionEvent(paramMotionEvent, 0);
      if (mMissedPointerDown)
      {
        forwardFakeMotionEvent(paramMotionEvent, 5);
        mMissedPointerDown = false;
      }
    }
  }
  
  public void requestLayout()
  {
    Utils.checkRequestLayout(this);
    super.requestLayout();
  }
  
  public void setOverlayAdapter(ConversationViewAdapter paramConversationViewAdapter)
  {
    if (mOverlayAdapter != null)
    {
      mOverlayAdapter.unregisterDataSetObserver(mAdapterObserver);
      clearOverlays();
    }
    mOverlayAdapter = paramConversationViewAdapter;
    if (mOverlayAdapter != null) {
      mOverlayAdapter.registerDataSetObserver(mAdapterObserver);
    }
  }
  
  private class AdapterObserver
    extends DataSetObserver
  {
    private AdapterObserver() {}
    
    public void onChanged()
    {
      ConversationContainer.this.onDataSetChanged();
    }
  }
  
  public static abstract interface DetachListener
  {
    public abstract void onDetachedFromParent();
  }
  
  public static class OverlayPosition
  {
    public final int bottom;
    public final int top;
    
    public OverlayPosition(int paramInt1, int paramInt2)
    {
      top = paramInt1;
      bottom = paramInt2;
    }
  }
  
  private static class OverlayView
  {
    int itemType;
    public View view;
    
    public OverlayView(View paramView, int paramInt)
    {
      view = paramView;
      itemType = paramInt;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ConversationContainer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */