package android.support.v4.view;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

class GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr1
  implements GestureDetectorCompat.GestureDetectorCompatImpl
{
  private final GestureDetector mDetector;
  
  public GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr1(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, Handler paramHandler)
  {
    mDetector = new GestureDetector(paramContext, paramOnGestureListener, paramHandler);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return mDetector.onTouchEvent(paramMotionEvent);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.GestureDetectorCompat.GestureDetectorCompatImplJellybeanMr1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */