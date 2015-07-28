package com.android.ex.photo.views;

class PhotoView$ScaleRunnable
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
  
  public PhotoView$ScaleRunnable(PhotoView paramPhotoView)
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
    PhotoView.access$100(mHeader, f, mCenterX, mCenterY);
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
        PhotoView.access$100(mHeader, mTargetScale, mCenterX, mCenterY);
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

/* Location:
 * Qualified Name:     com.android.ex.photo.views.PhotoView.ScaleRunnable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */