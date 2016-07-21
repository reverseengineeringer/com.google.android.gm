package com.android.email.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import bbs;
import com.android.setupwizardlib.SetupWizardLayout;

public class SlidingSetupWizardLayout
  extends SetupWizardLayout
{
  public float a = 0.0F;
  public ViewTreeObserver.OnPreDrawListener b;
  
  public SlidingSetupWizardLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public SlidingSetupWizardLayout(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public SlidingSetupWizardLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SlidingSetupWizardLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public float getXFraction()
  {
    return a;
  }
  
  public void setXFraction(float paramFloat)
  {
    a = paramFloat;
    if (getWidth() == 0)
    {
      if (b == null)
      {
        b = new bbs(this);
        getViewTreeObserver().addOnPreDrawListener(b);
      }
      return;
    }
    setTranslationX(getWidth() * paramFloat);
  }
}

/* Location:
 * Qualified Name:     com.android.email.view.SlidingSetupWizardLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */