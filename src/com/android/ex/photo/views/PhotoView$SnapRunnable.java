package com.android.ex.photo.views;

class PhotoView$SnapRunnable
  implements Runnable
{
  private final PhotoView mHeader;
  private boolean mRunning;
  private long mStartRunTime = -1L;
  private boolean mStop;
  private float mTranslateX;
  private float mTranslateY;
  
  public PhotoView$SnapRunnable(PhotoView paramPhotoView)
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
      PhotoView.access$200(mHeader, f3, f2);
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

/* Location:
 * Qualified Name:     com.android.ex.photo.views.PhotoView.SnapRunnable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */