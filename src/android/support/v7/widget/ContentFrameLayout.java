package android.support.v7.widget;

import ahu;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class ContentFrameLayout
  extends FrameLayout
{
  public TypedValue b;
  public TypedValue c;
  public TypedValue d;
  public TypedValue e;
  public TypedValue f;
  public TypedValue g;
  public final Rect h = new Rect();
  public ahu i;
  
  public ContentFrameLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ContentFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ContentFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void a(Rect paramRect)
  {
    fitSystemWindows(paramRect);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (i != null) {
      i.a();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = 0;
    DisplayMetrics localDisplayMetrics = getContext().getResources().getDisplayMetrics();
    int k;
    int i2;
    int i3;
    TypedValue localTypedValue;
    label61:
    int j;
    if (widthPixels < heightPixels)
    {
      k = 1;
      i2 = View.MeasureSpec.getMode(paramInt1);
      i3 = View.MeasureSpec.getMode(paramInt2);
      if (i2 != Integer.MIN_VALUE) {
        break label495;
      }
      if (k == 0) {
        break label353;
      }
      localTypedValue = e;
      if ((localTypedValue == null) || (type == 0)) {
        break label495;
      }
      if (type != 5) {
        break label362;
      }
      j = (int)localTypedValue.getDimension(localDisplayMetrics);
    }
    for (;;)
    {
      label92:
      int n;
      int m;
      if (j > 0)
      {
        n = View.MeasureSpec.makeMeasureSpec(Math.min(j - (h.left + h.right), View.MeasureSpec.getSize(paramInt1)), 1073741824);
        m = 1;
      }
      for (;;)
      {
        j = paramInt2;
        if (i3 == Integer.MIN_VALUE)
        {
          if (k == 0) {
            break label394;
          }
          localTypedValue = f;
          label150:
          j = paramInt2;
          if (localTypedValue != null)
          {
            j = paramInt2;
            if (type != 0)
            {
              if (type != 5) {
                break label403;
              }
              paramInt1 = (int)localTypedValue.getDimension(localDisplayMetrics);
            }
          }
        }
        for (;;)
        {
          label185:
          j = paramInt2;
          if (paramInt1 > 0) {
            j = View.MeasureSpec.makeMeasureSpec(Math.min(paramInt1 - (h.top + h.bottom), View.MeasureSpec.getSize(paramInt2)), 1073741824);
          }
          super.onMeasure(n, j);
          i3 = getMeasuredWidth();
          n = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
          if ((m == 0) && (i2 == Integer.MIN_VALUE)) {
            if (k != 0)
            {
              localTypedValue = c;
              label266:
              if ((localTypedValue == null) || (type == 0)) {
                break label476;
              }
              if (type != 5) {
                break label444;
              }
              paramInt1 = (int)localTypedValue.getDimension(localDisplayMetrics);
            }
          }
          for (;;)
          {
            label297:
            paramInt2 = paramInt1;
            if (paramInt1 > 0) {
              paramInt2 = paramInt1 - (h.left + h.right);
            }
            if (i3 < paramInt2) {
              paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
            }
            for (paramInt2 = 1;; paramInt2 = i1)
            {
              if (paramInt2 != 0) {
                super.onMeasure(paramInt1, j);
              }
              return;
              k = 0;
              break;
              label353:
              localTypedValue = d;
              break label61;
              label362:
              if (type != 6) {
                break label504;
              }
              j = (int)localTypedValue.getFraction(widthPixels, widthPixels);
              break label92;
              label394:
              localTypedValue = g;
              break label150;
              label403:
              if (type != 6) {
                break label490;
              }
              paramInt1 = (int)localTypedValue.getFraction(heightPixels, heightPixels);
              break label185;
              localTypedValue = b;
              break label266;
              label444:
              if (type != 6) {
                break label485;
              }
              paramInt1 = (int)localTypedValue.getFraction(widthPixels, widthPixels);
              break label297;
              label476:
              paramInt1 = n;
            }
            label485:
            paramInt1 = 0;
          }
          label490:
          paramInt1 = 0;
        }
        label495:
        m = 0;
        n = paramInt1;
      }
      label504:
      j = 0;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ContentFrameLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */