import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;

public class k
  extends ajh
{
  public boolean a = true;
  boolean b = false;
  private Drawable c;
  private final Rect d = new Rect();
  private final Rect e = new Rect();
  private int i = 119;
  
  public k(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public k(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public k(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, j.aa, paramInt, 0);
    i = paramContext.getInt(j.ac, i);
    paramAttributeSet = paramContext.getDrawable(j.ab);
    if (paramAttributeSet != null) {
      setForeground(paramAttributeSet);
    }
    a = paramContext.getBoolean(j.ad, true);
    paramContext.recycle();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Drawable localDrawable;
    Rect localRect1;
    Rect localRect2;
    int j;
    int k;
    if (c != null)
    {
      localDrawable = c;
      if (b)
      {
        b = false;
        localRect1 = d;
        localRect2 = e;
        j = getRight() - getLeft();
        k = getBottom() - getTop();
        if (!a) {
          break label113;
        }
        localRect1.set(0, 0, j, k);
      }
    }
    for (;;)
    {
      Gravity.apply(i, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight(), localRect1, localRect2);
      localDrawable.setBounds(localRect2);
      localDrawable.draw(paramCanvas);
      return;
      label113:
      localRect1.set(getPaddingLeft(), getPaddingTop(), j - getPaddingRight(), k - getPaddingBottom());
    }
  }
  
  public void drawableHotspotChanged(float paramFloat1, float paramFloat2)
  {
    super.drawableHotspotChanged(paramFloat1, paramFloat2);
    if (c != null) {
      c.setHotspot(paramFloat1, paramFloat2);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if ((c != null) && (c.isStateful())) {
      c.setState(getDrawableState());
    }
  }
  
  public Drawable getForeground()
  {
    return c;
  }
  
  public int getForegroundGravity()
  {
    return i;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if (c != null) {
      c.jumpToCurrentState();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    b |= paramBoolean;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    b = true;
  }
  
  public void setForeground(Drawable paramDrawable)
  {
    if (c != paramDrawable)
    {
      if (c != null)
      {
        c.setCallback(null);
        unscheduleDrawable(c);
      }
      c = paramDrawable;
      if (paramDrawable == null) {
        break label96;
      }
      setWillNotDraw(false);
      paramDrawable.setCallback(this);
      if (paramDrawable.isStateful()) {
        paramDrawable.setState(getDrawableState());
      }
      if (i == 119) {
        paramDrawable.getPadding(new Rect());
      }
    }
    for (;;)
    {
      requestLayout();
      invalidate();
      return;
      label96:
      setWillNotDraw(true);
    }
  }
  
  public void setForegroundGravity(int paramInt)
  {
    if (i != paramInt)
    {
      if ((0x800007 & paramInt) != 0) {
        break label77;
      }
      paramInt = 0x800003 | paramInt;
    }
    label77:
    for (;;)
    {
      int j = paramInt;
      if ((paramInt & 0x70) == 0) {
        j = paramInt | 0x30;
      }
      i = j;
      if ((i == 119) && (c != null))
      {
        Rect localRect = new Rect();
        c.getPadding(localRect);
      }
      requestLayout();
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == c);
  }
}

/* Location:
 * Qualified Name:     k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */