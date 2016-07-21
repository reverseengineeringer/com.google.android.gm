import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;

public class cya
  extends FrameLayout
{
  private ViewGroup a;
  float c;
  ViewTreeObserver.OnPreDrawListener d;
  
  public cya(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    a(paramInt1, paramInt2, null, cxs.a);
  }
  
  public cya(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(0, 0, paramAttributeSet, cxs.a);
  }
  
  public cya(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(0, 0, paramAttributeSet, paramInt);
  }
  
  private final void a(int paramInt1, int paramInt2, AttributeSet paramAttributeSet, int paramInt3)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, cxy.aM, paramInt3, 0);
    paramInt3 = paramInt1;
    if (paramInt1 == 0) {
      paramInt3 = paramAttributeSet.getResourceId(cxy.aN, 0);
    }
    paramInt1 = paramInt2;
    if (paramInt2 == 0) {
      paramInt1 = paramAttributeSet.getResourceId(cxy.aO, 0);
    }
    super.addView(a(LayoutInflater.from(getContext()), paramInt3), -1, generateDefaultLayoutParams());
    a = a(paramInt1);
    if (a == null) {
      throw new IllegalArgumentException("Container cannot be null in TemplateLayout");
    }
    paramAttributeSet.recycle();
  }
  
  public View a(LayoutInflater paramLayoutInflater, int paramInt)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException("android:layout not specified for TemplateLayout");
    }
    return paramLayoutInflater.inflate(paramInt, this, false);
  }
  
  public ViewGroup a(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = 0;
    }
    return (ViewGroup)findViewById(i);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    a.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public float getXFraction()
  {
    return c;
  }
  
  public void setXFraction(float paramFloat)
  {
    c = paramFloat;
    int i = getWidth();
    if (i != 0) {
      setTranslationX(i * paramFloat);
    }
    while (d != null) {
      return;
    }
    d = new cyb(this);
    getViewTreeObserver().addOnPreDrawListener(d);
  }
}

/* Location:
 * Qualified Name:     cya
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */