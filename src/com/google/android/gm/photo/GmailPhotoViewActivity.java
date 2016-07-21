package com.google.android.gm.photo;

import android.os.Bundle;
import android.view.MotionEvent;
import blq;
import cfc;
import com.android.mail.ui.toastbar.ActionableToastBar;
import dfy;
import dnc;

public class GmailPhotoViewActivity
  extends cfc
{
  private ActionableToastBar r;
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    ActionableToastBar.a(r, paramMotionEvent);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public final blq g()
  {
    return new dnc(this);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    r = ((ActionableToastBar)findViewById(dfy.cr));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.photo.GmailPhotoViewActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */