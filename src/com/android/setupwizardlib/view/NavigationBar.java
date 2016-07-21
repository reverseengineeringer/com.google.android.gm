package com.android.setupwizardlib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import cxs;
import cxv;
import cxw;
import cxx;

public class NavigationBar
  extends LinearLayout
  implements View.OnClickListener
{
  public Button a;
  public Button b;
  private Button c;
  
  public NavigationBar(Context paramContext)
  {
    super(a(paramContext));
    a();
  }
  
  public NavigationBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(a(paramContext), paramAttributeSet);
    a();
  }
  
  public NavigationBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(a(paramContext), paramAttributeSet, paramInt);
    a();
  }
  
  private static Context a(Context paramContext)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(new int[] { cxs.b, 16842800, 16842801 });
    int j = localTypedArray.getResourceId(0, 0);
    int i = j;
    if (j == 0)
    {
      float[] arrayOfFloat1 = new float[3];
      float[] arrayOfFloat2 = new float[3];
      Color.colorToHSV(localTypedArray.getColor(1, 0), arrayOfFloat1);
      Color.colorToHSV(localTypedArray.getColor(2, 0), arrayOfFloat2);
      if (arrayOfFloat1[2] <= arrayOfFloat2[2]) {
        break label105;
      }
      i = 1;
      if (i == 0) {
        break label110;
      }
    }
    label105:
    label110:
    for (i = cxx.a;; i = cxx.b)
    {
      localTypedArray.recycle();
      return new ContextThemeWrapper(paramContext, i);
      i = 0;
      break;
    }
  }
  
  private final void a()
  {
    View.inflate(getContext(), cxw.b, this);
    a = ((Button)findViewById(cxv.j));
    c = ((Button)findViewById(cxv.h));
    b = ((Button)findViewById(cxv.i));
  }
  
  public void onClick(View paramView) {}
}

/* Location:
 * Qualified Name:     com.android.setupwizardlib.view.NavigationBar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */