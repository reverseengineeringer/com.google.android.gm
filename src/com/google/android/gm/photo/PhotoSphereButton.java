package com.google.android.gm.photo;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;

public class PhotoSphereButton
  extends ImageButton
{
  public PhotoSphereButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public PhotoSphereButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PhotoSphereButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)getLayoutParams();
    bottomMargin = bottom;
    setLayoutParams(localMarginLayoutParams);
    return true;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.photo.PhotoSphereButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */