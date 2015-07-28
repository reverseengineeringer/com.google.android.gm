package com.android.ex.photo.views;

class PhotoView$RotateRunnable
  implements Runnable
{
  private float mAppliedRotation;
  private final PhotoView mHeader;
  private long mLastRuntime;
  private boolean mRunning;
  private boolean mStop;
  private float mTargetRotation;
  private float mVelocity;
  
  public PhotoView$RotateRunnable(PhotoView paramPhotoView)
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
      PhotoView.access$400(mHeader, f1, false);
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

/* Location:
 * Qualified Name:     com.android.ex.photo.views.PhotoView.RotateRunnable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */