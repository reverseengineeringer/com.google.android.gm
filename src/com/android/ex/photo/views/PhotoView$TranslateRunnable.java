package com.android.ex.photo.views;

class PhotoView$TranslateRunnable
  implements Runnable
{
  private final PhotoView mHeader;
  private long mLastRunTime = -1L;
  private boolean mRunning;
  private boolean mStop;
  private float mVelocityX;
  private float mVelocityY;
  
  public PhotoView$TranslateRunnable(PhotoView paramPhotoView)
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
      bool = PhotoView.access$200(mHeader, mVelocityX * f, mVelocityY * f);
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
        PhotoView.access$300(mHeader);
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

/* Location:
 * Qualified Name:     com.android.ex.photo.views.PhotoView.TranslateRunnable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */