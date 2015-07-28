package com.android.ex.photo.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.GestureDetectorCompat;
import android.util.AttributeSet;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import com.android.ex.photo.R.color;
import com.android.ex.photo.R.dimen;

public class PhotoView
  extends View
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener
{
  private static Paint sCropDimPaint;
  private static Paint sCropPaint;
  private static int sCropSize;
  private static boolean sInitialized;
  private static Bitmap sVideoImage;
  private static Bitmap sVideoNotReadyImage;
  private boolean mAllowCrop;
  private Rect mCropRect = new Rect();
  private int mCropSize;
  private boolean mDoubleTapDebounce;
  private boolean mDoubleTapToZoomEnabled = true;
  private Matrix mDrawMatrix;
  private BitmapDrawable mDrawable;
  private View.OnClickListener mExternalClickListener;
  private int mFixedHeight = -1;
  private boolean mFullScreen;
  private GestureDetectorCompat mGestureDetector;
  private boolean mHaveLayout;
  private boolean mIsDoubleTouch;
  private Matrix mMatrix = new Matrix();
  private float mMaxScale;
  private float mMinScale;
  private Matrix mOriginalMatrix = new Matrix();
  private RotateRunnable mRotateRunnable;
  private float mRotation;
  private ScaleGestureDetector mScaleGetureDetector;
  private ScaleRunnable mScaleRunnable;
  private SnapRunnable mSnapRunnable;
  private RectF mTempDst = new RectF();
  private RectF mTempSrc = new RectF();
  private boolean mTransformsEnabled;
  private RectF mTranslateRect = new RectF();
  private TranslateRunnable mTranslateRunnable;
  private float[] mValues = new float[9];
  private byte[] mVideoBlob;
  private boolean mVideoReady;
  
  public PhotoView(Context paramContext)
  {
    super(paramContext);
    initialize();
  }
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initialize();
  }
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initialize();
  }
  
  private void configureBounds(boolean paramBoolean)
  {
    if ((mDrawable == null) || (!mHaveLayout)) {
      return;
    }
    int j = mDrawable.getIntrinsicWidth();
    int k = mDrawable.getIntrinsicHeight();
    int i = getWidth();
    int m = getHeight();
    if (((j < 0) || (i == j)) && ((k < 0) || (m == k))) {}
    for (i = 1;; i = 0)
    {
      mDrawable.setBounds(0, 0, j, k);
      if ((paramBoolean) || ((mMinScale == 0.0F) && (mDrawable != null) && (mHaveLayout)))
      {
        generateMatrix();
        generateScale();
      }
      if ((i == 0) && (!mMatrix.isIdentity())) {
        break;
      }
      mDrawMatrix = null;
      return;
    }
    mDrawMatrix = mMatrix;
  }
  
  private void generateMatrix()
  {
    int m = mDrawable.getIntrinsicWidth();
    int n = mDrawable.getIntrinsicHeight();
    int i;
    int j;
    label40:
    int k;
    if (mAllowCrop)
    {
      i = sCropSize;
      if (!mAllowCrop) {
        break label102;
      }
      j = sCropSize;
      if (((m >= 0) && (i != m)) || ((n >= 0) && (j != n))) {
        break label110;
      }
      k = 1;
      label64:
      if ((k == 0) || (mAllowCrop)) {
        break label115;
      }
      mMatrix.reset();
    }
    for (;;)
    {
      mOriginalMatrix.set(mMatrix);
      return;
      i = getWidth();
      break;
      label102:
      j = getHeight();
      break label40;
      label110:
      k = 0;
      break label64;
      label115:
      mTempSrc.set(0.0F, 0.0F, m, n);
      if (mAllowCrop) {
        mTempDst.set(mCropRect);
      }
      for (;;)
      {
        if ((m >= i) || (n >= j) || (mAllowCrop)) {
          break label211;
        }
        mMatrix.setTranslate(i / 2 - m / 2, j / 2 - n / 2);
        break;
        mTempDst.set(0.0F, 0.0F, i, j);
      }
      label211:
      mMatrix.setRectToRect(mTempSrc, mTempDst, Matrix.ScaleToFit.CENTER);
    }
  }
  
  private void generateScale()
  {
    int k = mDrawable.getIntrinsicWidth();
    int m = mDrawable.getIntrinsicHeight();
    int i;
    int j;
    if (mAllowCrop)
    {
      i = getCropSize();
      if (!mAllowCrop) {
        break label89;
      }
      j = getCropSize();
      label41:
      if ((k >= i) || (m >= j) || (mAllowCrop)) {
        break label97;
      }
    }
    label89:
    label97:
    for (mMinScale = 1.0F;; mMinScale = getScale())
    {
      mMaxScale = Math.max(mMinScale * 8.0F, 8.0F);
      return;
      i = getWidth();
      break;
      j = getHeight();
      break label41;
    }
  }
  
  private int getCropSize()
  {
    if (mCropSize > 0) {
      return mCropSize;
    }
    return sCropSize;
  }
  
  private float getScale()
  {
    mMatrix.getValues(mValues);
    return mValues[0];
  }
  
  private void initialize()
  {
    Context localContext = getContext();
    if (!sInitialized)
    {
      sInitialized = true;
      Resources localResources = localContext.getApplicationContext().getResources();
      sCropSize = localResources.getDimensionPixelSize(R.dimen.photo_crop_width);
      sCropDimPaint = new Paint();
      sCropDimPaint.setAntiAlias(true);
      sCropDimPaint.setColor(localResources.getColor(R.color.photo_crop_dim_color));
      sCropDimPaint.setStyle(Paint.Style.FILL);
      sCropPaint = new Paint();
      sCropPaint.setAntiAlias(true);
      sCropPaint.setColor(localResources.getColor(R.color.photo_crop_highlight_color));
      sCropPaint.setStyle(Paint.Style.STROKE);
      sCropPaint.setStrokeWidth(localResources.getDimension(R.dimen.photo_crop_stroke_width));
    }
    mGestureDetector = new GestureDetectorCompat(localContext, this, null);
    mScaleGetureDetector = new ScaleGestureDetector(localContext, this);
    mScaleRunnable = new ScaleRunnable(this);
    mTranslateRunnable = new TranslateRunnable(this);
    mSnapRunnable = new SnapRunnable(this);
    mRotateRunnable = new RotateRunnable(this);
  }
  
  private void rotate(float paramFloat, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      mRotateRunnable.start(paramFloat);
      return;
    }
    mRotation += paramFloat;
    mMatrix.postRotate(paramFloat, getWidth() / 2, getHeight() / 2);
    invalidate();
  }
  
  private void scale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    mMatrix.postRotate(-mRotation, getWidth() / 2, getHeight() / 2);
    paramFloat1 = Math.min(Math.max(paramFloat1, mMinScale), mMaxScale) / getScale();
    mMatrix.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    snap();
    mMatrix.postRotate(mRotation, getWidth() / 2, getHeight() / 2);
    invalidate();
  }
  
  private void snap()
  {
    mTranslateRect.set(mTempSrc);
    mMatrix.mapRect(mTranslateRect);
    float f1;
    float f2;
    label55:
    float f3;
    float f4;
    label96:
    label112:
    label128:
    float f5;
    if (mAllowCrop)
    {
      f1 = mCropRect.left;
      if (!mAllowCrop) {
        break label210;
      }
      f2 = mCropRect.right;
      f3 = mTranslateRect.left;
      f4 = mTranslateRect.right;
      if (f4 - f3 >= f2 - f1) {
        break label219;
      }
      f1 += (f2 - f1 - (f4 + f3)) / 2.0F;
      if (!mAllowCrop) {
        break label252;
      }
      f2 = mCropRect.top;
      if (!mAllowCrop) {
        break label257;
      }
      f3 = mCropRect.bottom;
      f4 = mTranslateRect.top;
      f5 = mTranslateRect.bottom;
      if (f5 - f4 >= f3 - f2) {
        break label266;
      }
      f2 += (f3 - f2 - (f5 + f4)) / 2.0F;
    }
    for (;;)
    {
      if ((Math.abs(f1) <= 20.0F) && (Math.abs(f2) <= 20.0F)) {
        break label301;
      }
      mSnapRunnable.start(f1, f2);
      return;
      f1 = 0.0F;
      break;
      label210:
      f2 = getWidth();
      break label55;
      label219:
      if (f3 > f1)
      {
        f1 -= f3;
        break label96;
      }
      if (f4 < f2)
      {
        f1 = f2 - f4;
        break label96;
      }
      f1 = 0.0F;
      break label96;
      label252:
      f2 = 0.0F;
      break label112;
      label257:
      f3 = getHeight();
      break label128;
      label266:
      if (f4 > f2) {
        f2 -= f4;
      } else if (f5 < f3) {
        f2 = f3 - f5;
      } else {
        f2 = 0.0F;
      }
    }
    label301:
    mMatrix.postTranslate(f1, f2);
    invalidate();
  }
  
  private boolean translate(float paramFloat1, float paramFloat2)
  {
    mTranslateRect.set(mTempSrc);
    mMatrix.mapRect(mTranslateRect);
    float f1;
    float f2;
    label56:
    float f3;
    float f4;
    label108:
    label125:
    label142:
    float f5;
    if (mAllowCrop)
    {
      f1 = mCropRect.left;
      if (!mAllowCrop) {
        break label231;
      }
      f2 = mCropRect.right;
      f3 = mTranslateRect.left;
      f4 = mTranslateRect.right;
      if (!mAllowCrop) {
        break label241;
      }
      f1 = Math.max(f1 - mTranslateRect.right, Math.min(f2 - mTranslateRect.left, paramFloat1));
      if (!mAllowCrop) {
        break label292;
      }
      f2 = mCropRect.top;
      if (!mAllowCrop) {
        break label298;
      }
      f3 = mCropRect.bottom;
      f4 = mTranslateRect.top;
      f5 = mTranslateRect.bottom;
      if (!mAllowCrop) {
        break label308;
      }
      f2 = Math.max(f2 - mTranslateRect.bottom, Math.min(f3 - mTranslateRect.top, paramFloat2));
    }
    for (;;)
    {
      mMatrix.postTranslate(f1, f2);
      invalidate();
      if ((f1 != paramFloat1) || (f2 != paramFloat2)) {
        break label365;
      }
      return true;
      f1 = 0.0F;
      break;
      label231:
      f2 = getWidth();
      break label56;
      label241:
      if (f4 - f3 < f2 - f1)
      {
        f1 += (f2 - f1 - (f4 + f3)) / 2.0F;
        break label108;
      }
      f1 = Math.max(f2 - f4, Math.min(f1 - f3, paramFloat1));
      break label108;
      label292:
      f2 = 0.0F;
      break label125;
      label298:
      f3 = getHeight();
      break label142;
      label308:
      if (f5 - f4 < f3 - f2) {
        f2 += (f3 - f2 - (f5 + f4)) / 2.0F;
      } else {
        f2 = Math.max(f3 - f5, Math.min(f2 - f4, paramFloat2));
      }
    }
    label365:
    return false;
  }
  
  public void bindPhoto(Bitmap paramBitmap)
  {
    boolean bool = false;
    if (mDrawable != null)
    {
      if (paramBitmap == mDrawable.getBitmap()) {
        return;
      }
      if ((paramBitmap == null) || ((mDrawable.getIntrinsicWidth() == paramBitmap.getWidth()) && (mDrawable.getIntrinsicHeight() == paramBitmap.getHeight()))) {
        break label102;
      }
    }
    label102:
    for (bool = true;; bool = false)
    {
      mMinScale = 0.0F;
      mDrawable = null;
      if ((mDrawable == null) && (paramBitmap != null)) {
        mDrawable = new BitmapDrawable(getResources(), paramBitmap);
      }
      configureBounds(bool);
      invalidate();
      return;
    }
  }
  
  public void clear()
  {
    mGestureDetector = null;
    mScaleGetureDetector = null;
    mDrawable = null;
    mScaleRunnable.stop();
    mScaleRunnable = null;
    mTranslateRunnable.stop();
    mTranslateRunnable = null;
    mSnapRunnable.stop();
    mSnapRunnable = null;
    mRotateRunnable.stop();
    mRotateRunnable = null;
    setOnClickListener(null);
    mExternalClickListener = null;
  }
  
  public void enableImageTransforms(boolean paramBoolean)
  {
    mTransformsEnabled = paramBoolean;
    if (!mTransformsEnabled) {
      resetTransformations();
    }
  }
  
  public boolean interceptMoveLeft(float paramFloat1, float paramFloat2)
  {
    if (!mTransformsEnabled) {}
    float f;
    do
    {
      return false;
      if (mTranslateRunnable.mRunning) {
        return true;
      }
      mMatrix.getValues(mValues);
      mTranslateRect.set(mTempSrc);
      mMatrix.mapRect(mTranslateRect);
      paramFloat1 = getWidth();
      paramFloat2 = mValues[2];
      f = mTranslateRect.right - mTranslateRect.left;
    } while ((!mTransformsEnabled) || (f <= paramFloat1) || (paramFloat2 == 0.0F));
    return paramFloat1 >= f + paramFloat2;
  }
  
  public boolean interceptMoveRight(float paramFloat1, float paramFloat2)
  {
    if (!mTransformsEnabled) {}
    float f;
    do
    {
      do
      {
        return false;
        if (mTranslateRunnable.mRunning) {
          return true;
        }
        mMatrix.getValues(mValues);
        mTranslateRect.set(mTempSrc);
        mMatrix.mapRect(mTranslateRect);
        paramFloat1 = getWidth();
        paramFloat2 = mValues[2];
        f = mTranslateRect.right - mTranslateRect.left;
      } while ((!mTransformsEnabled) || (f <= paramFloat1));
      if (paramFloat2 == 0.0F) {
        return true;
      }
    } while (paramFloat1 >= f + paramFloat2);
    return true;
  }
  
  public boolean isPhotoBound()
  {
    return mDrawable != null;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if ((mDoubleTapToZoomEnabled) && (mTransformsEnabled))
    {
      if (!mDoubleTapDebounce)
      {
        float f1 = getScale();
        float f2 = Math.max(mMinScale, f1 * 1.5F);
        f2 = Math.min(mMaxScale, f2);
        mScaleRunnable.start(f1, f2, paramMotionEvent.getX(), paramMotionEvent.getY());
      }
      mDoubleTapDebounce = false;
    }
    return true;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if (mTransformsEnabled)
    {
      mTranslateRunnable.stop();
      mSnapRunnable.stop();
    }
    return true;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i;
    if (mDrawable != null)
    {
      i = paramCanvas.getSaveCount();
      paramCanvas.save();
      if (mDrawMatrix != null) {
        paramCanvas.concat(mDrawMatrix);
      }
      mDrawable.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
      if (mVideoBlob != null) {
        if (!mVideoReady) {
          break label224;
        }
      }
    }
    label224:
    for (Bitmap localBitmap = sVideoImage;; localBitmap = sVideoNotReadyImage)
    {
      i = (getWidth() - localBitmap.getWidth()) / 2;
      int j = (getHeight() - localBitmap.getHeight()) / 2;
      paramCanvas.drawBitmap(localBitmap, i, j, null);
      mTranslateRect.set(mDrawable.getBounds());
      if (mDrawMatrix != null) {
        mDrawMatrix.mapRect(mTranslateRect);
      }
      if (mAllowCrop)
      {
        i = paramCanvas.getSaveCount();
        paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), sCropDimPaint);
        paramCanvas.save();
        paramCanvas.clipRect(mCropRect);
        if (mDrawMatrix != null) {
          paramCanvas.concat(mDrawMatrix);
        }
        mDrawable.draw(paramCanvas);
        paramCanvas.restoreToCount(i);
        paramCanvas.drawRect(mCropRect, sCropPaint);
      }
      return;
    }
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (mTransformsEnabled) {
      mTranslateRunnable.start(paramFloat1, paramFloat2);
    }
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    mHaveLayout = true;
    paramInt1 = getWidth();
    paramInt2 = getHeight();
    if (mAllowCrop)
    {
      mCropSize = Math.min(sCropSize, Math.min(paramInt1, paramInt2));
      paramInt1 = (paramInt1 - mCropSize) / 2;
      paramInt2 = (paramInt2 - mCropSize) / 2;
      paramInt3 = mCropSize;
      paramInt4 = mCropSize;
      mCropRect.set(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    }
    configureBounds(paramBoolean);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (mFixedHeight != -1)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(mFixedHeight, Integer.MIN_VALUE));
      setMeasuredDimension(getMeasuredWidth(), mFixedHeight);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (mTransformsEnabled)
    {
      mIsDoubleTouch = false;
      scale(getScale() * paramScaleGestureDetector.getScaleFactor(), paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
    }
    return true;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (mTransformsEnabled)
    {
      mScaleRunnable.stop();
      mIsDoubleTouch = true;
    }
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    if ((mTransformsEnabled) && (mIsDoubleTouch))
    {
      mDoubleTapDebounce = true;
      resetTransformations();
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (mTransformsEnabled) {
      translate(-paramFloat1, -paramFloat2);
    }
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if ((mExternalClickListener != null) && (!mIsDoubleTouch)) {
      mExternalClickListener.onClick(this);
    }
    mIsDoubleTouch = false;
    return true;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((mScaleGetureDetector == null) || (mGestureDetector == null)) {}
    do
    {
      return true;
      mScaleGetureDetector.onTouchEvent(paramMotionEvent);
      mGestureDetector.onTouchEvent(paramMotionEvent);
      switch (paramMotionEvent.getAction())
      {
      case 2: 
      default: 
        return true;
      }
    } while (mTranslateRunnable.mRunning);
    snap();
    return true;
  }
  
  public void resetTransformations()
  {
    mMatrix.set(mOriginalMatrix);
    invalidate();
  }
  
  public void setFullScreen(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1 != mFullScreen)
    {
      mFullScreen = paramBoolean1;
      requestLayout();
      invalidate();
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    mExternalClickListener = paramOnClickListener;
  }
  
  private static class RotateRunnable
    implements Runnable
  {
    private float mAppliedRotation;
    private final PhotoView mHeader;
    private long mLastRuntime;
    private boolean mRunning;
    private boolean mStop;
    private float mTargetRotation;
    private float mVelocity;
    
    public RotateRunnable(PhotoView paramPhotoView)
    {
      mHeader = paramPhotoView;
    }
    
    public void run()
    {
      if (mStop) {
        return;
      }
      long l2;
      if (mAppliedRotation != mTargetRotation)
      {
        l2 = System.currentTimeMillis();
        if (mLastRuntime == -1L) {
          break label176;
        }
      }
      label176:
      for (long l1 = l2 - mLastRuntime;; l1 = 0L)
      {
        float f2 = mVelocity * (float)l1;
        float f1;
        if ((mAppliedRotation >= mTargetRotation) || (mAppliedRotation + f2 <= mTargetRotation))
        {
          f1 = f2;
          if (mAppliedRotation > mTargetRotation)
          {
            f1 = f2;
            if (mAppliedRotation + f2 >= mTargetRotation) {}
          }
        }
        else
        {
          f1 = mTargetRotation - mAppliedRotation;
        }
        mHeader.rotate(f1, false);
        mAppliedRotation += f1;
        if (mAppliedRotation == mTargetRotation) {
          stop();
        }
        mLastRuntime = l2;
        if (mStop) {
          break;
        }
        mHeader.post(this);
        return;
      }
    }
    
    public void start(float paramFloat)
    {
      if (mRunning) {
        return;
      }
      mTargetRotation = paramFloat;
      mVelocity = (mTargetRotation / 500.0F);
      mAppliedRotation = 0.0F;
      mLastRuntime = -1L;
      mStop = false;
      mRunning = true;
      mHeader.post(this);
    }
    
    public void stop()
    {
      mRunning = false;
      mStop = true;
    }
  }
  
  private static class ScaleRunnable
    implements Runnable
  {
    private float mCenterX;
    private float mCenterY;
    private final PhotoView mHeader;
    private boolean mRunning;
    private float mStartScale;
    private long mStartTime;
    private boolean mStop;
    private float mTargetScale;
    private float mVelocity;
    private boolean mZoomingIn;
    
    public ScaleRunnable(PhotoView paramPhotoView)
    {
      mHeader = paramPhotoView;
    }
    
    public void run()
    {
      if (mStop) {
        return;
      }
      long l1 = System.currentTimeMillis();
      long l2 = mStartTime;
      float f = mStartScale + mVelocity * (float)(l1 - l2);
      mHeader.scale(f, mCenterX, mCenterY);
      boolean bool2;
      if (f != mTargetScale)
      {
        bool2 = mZoomingIn;
        if (f <= mTargetScale) {
          break label124;
        }
      }
      label124:
      for (boolean bool1 = true;; bool1 = false)
      {
        if (bool2 == bool1)
        {
          mHeader.scale(mTargetScale, mCenterX, mCenterY);
          stop();
        }
        if (mStop) {
          break;
        }
        mHeader.post(this);
        return;
      }
    }
    
    public boolean start(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      if (mRunning) {
        return false;
      }
      mCenterX = paramFloat3;
      mCenterY = paramFloat4;
      mTargetScale = paramFloat2;
      mStartTime = System.currentTimeMillis();
      mStartScale = paramFloat1;
      if (mTargetScale > mStartScale) {}
      for (boolean bool = true;; bool = false)
      {
        mZoomingIn = bool;
        mVelocity = ((mTargetScale - mStartScale) / 300.0F);
        mRunning = true;
        mStop = false;
        mHeader.post(this);
        return true;
      }
    }
    
    public void stop()
    {
      mRunning = false;
      mStop = true;
    }
  }
  
  private static class SnapRunnable
    implements Runnable
  {
    private final PhotoView mHeader;
    private boolean mRunning;
    private long mStartRunTime = -1L;
    private boolean mStop;
    private float mTranslateX;
    private float mTranslateY;
    
    public SnapRunnable(PhotoView paramPhotoView)
    {
      mHeader = paramPhotoView;
    }
    
    public void run()
    {
      if (mStop) {
        return;
      }
      long l = System.currentTimeMillis();
      float f1;
      label33:
      float f3;
      float f2;
      if (mStartRunTime != -1L)
      {
        f1 = (float)(l - mStartRunTime);
        if (mStartRunTime == -1L) {
          mStartRunTime = l;
        }
        if (f1 < 100.0F) {
          break label141;
        }
        f3 = mTranslateX;
        f2 = mTranslateY;
      }
      for (;;)
      {
        mHeader.translate(f3, f2);
        mTranslateX -= f3;
        mTranslateY -= f2;
        if ((mTranslateX == 0.0F) && (mTranslateY == 0.0F)) {
          stop();
        }
        if (mStop) {
          break;
        }
        mHeader.post(this);
        return;
        f1 = 0.0F;
        break label33;
        label141:
        f2 = mTranslateX / (100.0F - f1) * 10.0F;
        float f4 = mTranslateY / (100.0F - f1) * 10.0F;
        if (Math.abs(f2) <= Math.abs(mTranslateX))
        {
          f1 = f2;
          if (f2 != NaN.0F) {}
        }
        else
        {
          f1 = mTranslateX;
        }
        if (Math.abs(f4) <= Math.abs(mTranslateY))
        {
          f3 = f1;
          f2 = f4;
          if (f4 != NaN.0F) {}
        }
        else
        {
          f2 = mTranslateY;
          f3 = f1;
        }
      }
    }
    
    public boolean start(float paramFloat1, float paramFloat2)
    {
      if (mRunning) {
        return false;
      }
      mStartRunTime = -1L;
      mTranslateX = paramFloat1;
      mTranslateY = paramFloat2;
      mStop = false;
      mRunning = true;
      mHeader.postDelayed(this, 250L);
      return true;
    }
    
    public void stop()
    {
      mRunning = false;
      mStop = true;
    }
  }
  
  private static class TranslateRunnable
    implements Runnable
  {
    private final PhotoView mHeader;
    private long mLastRunTime = -1L;
    private boolean mRunning;
    private boolean mStop;
    private float mVelocityX;
    private float mVelocityY;
    
    public TranslateRunnable(PhotoView paramPhotoView)
    {
      mHeader = paramPhotoView;
    }
    
    public void run()
    {
      if (mStop) {
        return;
      }
      long l = System.currentTimeMillis();
      float f;
      label34:
      boolean bool;
      if (mLastRunTime != -1L)
      {
        f = (float)(l - mLastRunTime) / 1000.0F;
        bool = mHeader.translate(mVelocityX * f, mVelocityY * f);
        mLastRunTime = l;
        f = 1000.0F * f;
        if (mVelocityX <= 0.0F) {
          break label187;
        }
        mVelocityX -= f;
        if (mVelocityX < 0.0F) {
          mVelocityX = 0.0F;
        }
        label98:
        if (mVelocityY <= 0.0F) {
          break label214;
        }
        mVelocityY -= f;
        if (mVelocityY < 0.0F) {
          mVelocityY = 0.0F;
        }
      }
      for (;;)
      {
        if (((mVelocityX == 0.0F) && (mVelocityY == 0.0F)) || (!bool))
        {
          stop();
          mHeader.snap();
        }
        if (mStop) {
          break;
        }
        mHeader.post(this);
        return;
        f = 0.0F;
        break label34;
        label187:
        mVelocityX += f;
        if (mVelocityX <= 0.0F) {
          break label98;
        }
        mVelocityX = 0.0F;
        break label98;
        label214:
        mVelocityY += f;
        if (mVelocityY > 0.0F) {
          mVelocityY = 0.0F;
        }
      }
    }
    
    public boolean start(float paramFloat1, float paramFloat2)
    {
      if (mRunning) {
        return false;
      }
      mLastRunTime = -1L;
      mVelocityX = paramFloat1;
      mVelocityY = paramFloat2;
      mStop = false;
      mRunning = true;
      mHeader.post(this);
      return true;
    }
    
    public void stop()
    {
      mRunning = false;
      mStop = true;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.ex.photo.views.PhotoView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */