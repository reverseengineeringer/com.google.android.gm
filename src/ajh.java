import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public class ajh
  extends ViewGroup
{
  private int a = -1;
  private int b = 0;
  private int c;
  private int d = 8388659;
  private int e;
  public boolean f = true;
  boolean g;
  public int h;
  private float i;
  private int[] j;
  private int[] k;
  private Drawable l;
  private int m;
  private int n;
  private int o;
  
  public ajh(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ajh(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ajh(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = amp.a(paramContext, paramAttributeSet, ack.aW, paramInt);
    paramInt = paramContext.a(ack.ba, -1);
    if (paramInt >= 0) {
      b(paramInt);
    }
    paramInt = paramContext.a(ack.aZ, -1);
    if (paramInt >= 0) {
      c(paramInt);
    }
    boolean bool2 = paramContext.a(ack.aX, true);
    if (!bool2) {
      f = bool2;
    }
    paramInt = ack.bb;
    i = a.getFloat(paramInt, -1.0F);
    a = paramContext.a(ack.aY, -1);
    g = paramContext.a(ack.be, false);
    paramAttributeSet = paramContext.a(ack.bc);
    if (paramAttributeSet != l)
    {
      l = paramAttributeSet;
      if (paramAttributeSet == null) {
        break label227;
      }
      h = paramAttributeSet.getIntrinsicWidth();
      m = paramAttributeSet.getIntrinsicHeight();
      if (paramAttributeSet != null) {
        break label240;
      }
    }
    for (;;)
    {
      setWillNotDraw(bool1);
      requestLayout();
      n = paramContext.a(ack.bf, 0);
      o = paramContext.c(ack.bd, 0);
      a.recycle();
      return;
      label227:
      h = 0;
      m = 0;
      break;
      label240:
      bool1 = false;
    }
  }
  
  private final void a(int paramInt1, int paramInt2)
  {
    int i2 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
    int i1 = 0;
    while (i1 < paramInt1)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() != 8)
      {
        aji localaji = (aji)localView.getLayoutParams();
        if (width == -1)
        {
          int i3 = height;
          height = localView.getMeasuredHeight();
          measureChildWithMargins(localView, i2, 0, paramInt2, 0);
          height = i3;
        }
      }
      i1 += 1;
    }
  }
  
  private final void a(Canvas paramCanvas, int paramInt)
  {
    l.setBounds(getPaddingLeft() + o, paramInt, getWidth() - getPaddingRight() - o, m + paramInt);
    l.draw(paramCanvas);
  }
  
  private final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private final boolean a(int paramInt)
  {
    if (paramInt == 0) {
      if ((n & 0x1) == 0) {}
    }
    do
    {
      return true;
      return false;
      if (paramInt != getChildCount()) {
        break;
      }
    } while ((n & 0x4) != 0);
    return false;
    if ((n & 0x2) != 0)
    {
      paramInt -= 1;
      for (;;)
      {
        if (paramInt < 0) {
          break label75;
        }
        if (getChildAt(paramInt).getVisibility() != 8) {
          break;
        }
        paramInt -= 1;
      }
    }
    return false;
    label75:
    return false;
  }
  
  private final void b(int paramInt1, int paramInt2)
  {
    e = 0;
    int i6 = 0;
    int i4 = 0;
    int i3 = 0;
    int i8 = 0;
    int i5 = 1;
    float f1 = 0.0F;
    int i15 = getChildCount();
    int i17 = View.MeasureSpec.getMode(paramInt1);
    int i16 = View.MeasureSpec.getMode(paramInt2);
    int i7 = 0;
    int i2 = 0;
    if ((j == null) || (k == null))
    {
      j = new int[4];
      k = new int[4];
    }
    Object localObject1 = j;
    Object localObject2 = k;
    localObject1[3] = -1;
    localObject1[2] = -1;
    localObject1[1] = -1;
    localObject1[0] = -1;
    localObject2[3] = -1;
    localObject2[2] = -1;
    localObject2[1] = -1;
    localObject2[0] = -1;
    boolean bool1 = f;
    boolean bool2 = g;
    if (i17 == 1073741824) {}
    int i1;
    int i9;
    Object localObject3;
    int i12;
    int i11;
    for (int i10 = 1;; i10 = 0)
    {
      i1 = Integer.MIN_VALUE;
      for (i9 = 0;; i9 = i12)
      {
        if (i9 >= i15) {
          break label894;
        }
        localObject3 = getChildAt(i9);
        if (localObject3 != null) {
          break;
        }
        e += 0;
        i12 = i9;
        i11 = i4;
        i9 = i3;
        i4 = i8;
        i3 = i5;
        i12 += 1;
        i5 = i3;
        i8 = i4;
        i3 = i9;
        i4 = i11;
      }
    }
    aji localaji;
    label340:
    label361:
    label386:
    int i13;
    int i14;
    if (((View)localObject3).getVisibility() != 8)
    {
      if (a(i9)) {
        e += h;
      }
      localaji = (aji)((View)localObject3).getLayoutParams();
      f1 += g;
      if ((i17 == 1073741824) && (width == 0) && (g > 0.0F)) {
        if (i10 != 0)
        {
          e += leftMargin + rightMargin;
          if (!bool1) {
            break label643;
          }
          i11 = View.MeasureSpec.makeMeasureSpec(0, 0);
          ((View)localObject3).measure(i11, i11);
          i11 = 0;
          if ((i16 == 1073741824) || (height != -1)) {
            break label2320;
          }
          i7 = 1;
          i11 = 1;
          i12 = topMargin + bottomMargin;
          i13 = ((View)localObject3).getMeasuredHeight() + i12;
          i14 = ane.a(i4, rg.i((View)localObject3));
          if (bool1)
          {
            int i18 = ((View)localObject3).getBaseline();
            if (i18 != -1)
            {
              if (h >= 0) {
                break label823;
              }
              i4 = d;
              label453:
              i4 = ((i4 & 0x70) >> 4 & 0xFFFFFFFE) >> 1;
              localObject1[i4] = Math.max(localObject1[i4], i18);
              localObject2[i4] = Math.max(localObject2[i4], i13 - i18);
            }
          }
          i6 = Math.max(i6, i13);
          if ((i5 == 0) || (height != -1)) {
            break label833;
          }
          i4 = 1;
          label526:
          if (g <= 0.0F) {
            break label846;
          }
          if (i11 == 0) {
            break label839;
          }
          label541:
          i5 = Math.max(i8, i12);
          i11 = i4;
          i4 = i5;
          i12 = i1;
          i8 = i14;
          i5 = i3;
          i3 = i11;
          i1 = i2;
          i2 = i12;
        }
      }
    }
    for (;;)
    {
      i12 = i9 + 0;
      i9 = i1;
      i1 = i2;
      i2 = i9;
      i9 = i5;
      i11 = i8;
      break;
      i11 = e;
      e = Math.max(i11, leftMargin + i11 + rightMargin);
      break label340;
      label643:
      i2 = 1;
      break label361;
      i12 = Integer.MIN_VALUE;
      i11 = i12;
      if (width == 0)
      {
        i11 = i12;
        if (g > 0.0F)
        {
          i11 = 0;
          width = -2;
        }
      }
      if (f1 == 0.0F)
      {
        i12 = e;
        label701:
        a((View)localObject3, paramInt1, i12, paramInt2, 0);
        if (i11 != Integer.MIN_VALUE) {
          width = i11;
        }
        i11 = ((View)localObject3).getMeasuredWidth();
        if (i10 == 0) {
          break label786;
        }
        e += leftMargin + i11 + rightMargin + 0;
      }
      for (;;)
      {
        if (bool2)
        {
          i1 = Math.max(i11, i1);
          break;
          i12 = 0;
          break label701;
          label786:
          i12 = e;
          e = Math.max(i12, i12 + i11 + leftMargin + rightMargin + 0);
          continue;
          label823:
          i4 = h;
          break label453;
          label833:
          i4 = 0;
          break label526;
          label839:
          i12 = i13;
          break label541;
          label846:
          if (i11 != 0) {}
          for (;;)
          {
            i5 = Math.max(i3, i12);
            i3 = i4;
            i11 = i2;
            i4 = i8;
            i2 = i1;
            i1 = i11;
            i8 = i14;
            break;
            i12 = i13;
          }
          label894:
          if ((e > 0) && (a(i15))) {
            e += h;
          }
          if ((localObject1[1] != -1) || (localObject1[0] != -1) || (localObject1[2] != -1) || (localObject1[3] != -1)) {}
          for (i9 = Math.max(i6, Math.max(localObject1[3], Math.max(localObject1[0], Math.max(localObject1[1], localObject1[2]))) + Math.max(localObject2[3], Math.max(localObject2[0], Math.max(localObject2[1], localObject2[2]))));; i9 = i6)
          {
            if ((bool2) && ((i17 == Integer.MIN_VALUE) || (i17 == 0)))
            {
              e = 0;
              i6 = 0;
              if (i6 < i15)
              {
                localObject3 = getChildAt(i6);
                if (localObject3 == null) {
                  e += 0;
                }
                for (;;)
                {
                  i6 += 1;
                  break;
                  if (((View)localObject3).getVisibility() == 8)
                  {
                    i6 += 0;
                  }
                  else
                  {
                    localObject3 = (aji)((View)localObject3).getLayoutParams();
                    if (i10 != 0)
                    {
                      i11 = e;
                      i12 = leftMargin;
                      e = (rightMargin + (i12 + i1) + 0 + i11);
                    }
                    else
                    {
                      i11 = e;
                      i12 = leftMargin;
                      e = Math.max(i11, rightMargin + (i11 + i1 + i12) + 0);
                    }
                  }
                }
              }
            }
            e += getPaddingLeft() + getPaddingRight();
            i13 = rg.a(Math.max(e, getSuggestedMinimumWidth()), paramInt1, 0);
            i6 = (0xFFFFFF & i13) - e;
            if ((i2 != 0) || ((i6 != 0) && (f1 > 0.0F)))
            {
              if (i > 0.0F) {
                f1 = i;
              }
              localObject1[3] = -1;
              localObject1[2] = -1;
              localObject1[1] = -1;
              localObject1[0] = -1;
              localObject2[3] = -1;
              localObject2[2] = -1;
              localObject2[1] = -1;
              localObject2[0] = -1;
              e = 0;
              i8 = 0;
              i2 = i5;
              i5 = -1;
              i1 = i4;
              i4 = i5;
              i5 = i6;
              if (i8 < i15)
              {
                localObject3 = getChildAt(i8);
                if ((localObject3 == null) || (((View)localObject3).getVisibility() == 8)) {
                  break label2282;
                }
                localaji = (aji)((View)localObject3).getLayoutParams();
                float f2 = g;
                if (f2 <= 0.0F) {
                  break label2267;
                }
                i9 = (int)(i5 * f2 / f1);
                i12 = getChildMeasureSpec(paramInt2, getPaddingTop() + getPaddingBottom() + topMargin + bottomMargin, height);
                if ((width != 0) || (i17 != 1073741824))
                {
                  i11 = i9 + ((View)localObject3).getMeasuredWidth();
                  i6 = i11;
                  if (i11 < 0) {
                    i6 = 0;
                  }
                  label1468:
                  ((View)localObject3).measure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), i12);
                  i1 = ane.a(i1, rg.i((View)localObject3) & 0xFF000000);
                  f1 -= f2;
                  i6 = i5 - i9;
                  i5 = i1;
                  i1 = i6;
                  label1518:
                  if (i10 == 0) {
                    break label1791;
                  }
                  e += ((View)localObject3).getMeasuredWidth() + leftMargin + rightMargin + 0;
                  label1551:
                  if ((i16 == 1073741824) || (height != -1)) {
                    break label1831;
                  }
                  i6 = 1;
                  label1570:
                  i12 = topMargin + bottomMargin;
                  i11 = ((View)localObject3).getMeasuredHeight() + i12;
                  i9 = Math.max(i4, i11);
                  if (i6 == 0) {
                    break label1837;
                  }
                  i4 = i12;
                  label1611:
                  i4 = Math.max(i3, i4);
                  if ((i2 == 0) || (height != -1)) {
                    break label1844;
                  }
                  i2 = 1;
                  label1637:
                  if (bool1)
                  {
                    i6 = ((View)localObject3).getBaseline();
                    if (i6 != -1)
                    {
                      if (h >= 0) {
                        break label1850;
                      }
                      i3 = d;
                      label1669:
                      i3 = ((i3 & 0x70) >> 4 & 0xFFFFFFFE) >> 1;
                      localObject1[i3] = Math.max(localObject1[i3], i6);
                      localObject2[i3] = Math.max(localObject2[i3], i11 - i6);
                    }
                  }
                  i6 = i5;
                  i5 = i2;
                  i3 = i9;
                  i2 = i6;
                }
              }
            }
            for (;;)
            {
              i9 = i8 + 1;
              i6 = i5;
              i8 = i3;
              i5 = i1;
              i1 = i2;
              i2 = i6;
              i3 = i4;
              i4 = i8;
              i8 = i9;
              break;
              if (i9 > 0)
              {
                i6 = i9;
                break label1468;
              }
              i6 = 0;
              break label1468;
              label1791:
              i6 = e;
              e = Math.max(i6, ((View)localObject3).getMeasuredWidth() + i6 + leftMargin + rightMargin + 0);
              break label1551;
              label1831:
              i6 = 0;
              break label1570;
              label1837:
              i4 = i11;
              break label1611;
              label1844:
              i2 = 0;
              break label1637;
              label1850:
              i3 = h;
              break label1669;
              e += getPaddingLeft() + getPaddingRight();
              if ((localObject1[1] == -1) && (localObject1[0] == -1) && (localObject1[2] == -1))
              {
                i5 = i4;
                if (localObject1[3] == -1) {}
              }
              else
              {
                i5 = Math.max(i4, Math.max(localObject1[3], Math.max(localObject1[0], Math.max(localObject1[1], localObject1[2]))) + Math.max(localObject2[3], Math.max(localObject2[0], Math.max(localObject2[1], localObject2[2]))));
              }
              i4 = i1;
              i6 = i2;
              i2 = i5;
              i1 = i3;
              for (;;)
              {
                if ((i6 == 0) && (i16 != 1073741824)) {}
                for (;;)
                {
                  setMeasuredDimension(0xFF000000 & i4 | i13, rg.a(Math.max(i1 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), paramInt2, i4 << 16));
                  if (i7 != 0)
                  {
                    i1 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
                    paramInt2 = 0;
                    while (paramInt2 < i15)
                    {
                      localObject1 = getChildAt(paramInt2);
                      if (((View)localObject1).getVisibility() != 8)
                      {
                        localObject2 = (aji)((View)localObject1).getLayoutParams();
                        if (height == -1)
                        {
                          i2 = width;
                          width = ((View)localObject1).getMeasuredWidth();
                          measureChildWithMargins((View)localObject1, paramInt1, 0, i1, 0);
                          width = i2;
                        }
                      }
                      paramInt2 += 1;
                      continue;
                      i3 = Math.max(i3, i8);
                      if ((!bool2) || (i17 == 1073741824)) {
                        break label2252;
                      }
                      i2 = 0;
                      while (i2 < i15)
                      {
                        localObject1 = getChildAt(i2);
                        if ((localObject1 != null) && (((View)localObject1).getVisibility() != 8) && (getLayoutParamsg > 0.0F)) {
                          ((View)localObject1).measure(View.MeasureSpec.makeMeasureSpec(i1, 1073741824), View.MeasureSpec.makeMeasureSpec(((View)localObject1).getMeasuredHeight(), 1073741824));
                        }
                        i2 += 1;
                      }
                    }
                  }
                  return;
                  i1 = i2;
                }
                label2252:
                i1 = i3;
                i2 = i9;
                i6 = i5;
              }
              label2267:
              i6 = i1;
              i1 = i5;
              i5 = i6;
              break label1518;
              label2282:
              i9 = i2;
              i2 = i1;
              i6 = i4;
              i1 = i5;
              i5 = i9;
              i4 = i3;
              i3 = i6;
            }
          }
          label2320:
          break label386;
        }
      }
      break label361;
      i12 = i2;
      i11 = i3;
      i13 = i4;
      i2 = i1;
      i1 = i12;
      i3 = i5;
      i4 = i8;
      i5 = i11;
      i8 = i13;
    }
  }
  
  private final void b(Canvas paramCanvas, int paramInt)
  {
    l.setBounds(paramInt, getPaddingTop() + o, h + paramInt, getHeight() - getPaddingBottom() - o);
    l.draw(paramCanvas);
  }
  
  private static void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.layout(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
  }
  
  public aji a(AttributeSet paramAttributeSet)
  {
    return new aji(getContext(), paramAttributeSet);
  }
  
  public aji b(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new aji(paramLayoutParams);
  }
  
  public final void b(int paramInt)
  {
    if (c != paramInt)
    {
      c = paramInt;
      requestLayout();
    }
  }
  
  public final void c(int paramInt)
  {
    if (d != paramInt)
    {
      if ((0x800007 & paramInt) != 0) {
        break label46;
      }
      paramInt = 0x800003 | paramInt;
    }
    label46:
    for (;;)
    {
      int i1 = paramInt;
      if ((paramInt & 0x70) == 0) {
        i1 = paramInt | 0x30;
      }
      d = i1;
      requestLayout();
      return;
    }
  }
  
  public boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof aji;
  }
  
  public aji d()
  {
    if (c == 0) {
      return new aji(-2, -2);
    }
    if (c == 1) {
      return new aji(-1, -2);
    }
    return null;
  }
  
  public int getBaseline()
  {
    int i1 = -1;
    if (a < 0) {
      i1 = super.getBaseline();
    }
    View localView;
    int i2;
    do
    {
      return i1;
      if (getChildCount() <= a) {
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
      }
      localView = getChildAt(a);
      i2 = localView.getBaseline();
      if (i2 != -1) {
        break;
      }
    } while (a == 0);
    throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
    i1 = b;
    if (c == 1)
    {
      int i3 = d & 0x70;
      if (i3 != 48) {
        switch (i3)
        {
        }
      }
    }
    for (;;)
    {
      return getLayoutParamstopMargin + i1 + i2;
      i1 = getBottom() - getTop() - getPaddingBottom() - e;
      continue;
      i1 += (getBottom() - getTop() - getPaddingTop() - getPaddingBottom() - e) / 2;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (l == null) {}
    int i1;
    aji localaji;
    int i3;
    boolean bool;
    label259:
    do
    {
      int i2;
      do
      {
        return;
        if (c != 1) {
          break;
        }
        i2 = getChildCount();
        i1 = 0;
        while (i1 < i2)
        {
          localView = getChildAt(i1);
          if ((localView != null) && (localView.getVisibility() != 8) && (a(i1)))
          {
            localaji = (aji)localView.getLayoutParams();
            a(paramCanvas, localView.getTop() - topMargin - m);
          }
          i1 += 1;
        }
      } while (!a(i2));
      localView = getChildAt(i2 - 1);
      if (localView == null) {}
      for (i1 = getHeight() - getPaddingBottom() - m;; i1 = bottomMargin + i1)
      {
        a(paramCanvas, i1);
        return;
        localaji = (aji)localView.getLayoutParams();
        i1 = localView.getBottom();
      }
      i3 = getChildCount();
      bool = ane.a(this);
      i1 = 0;
      if (i1 < i3)
      {
        localView = getChildAt(i1);
        if ((localView != null) && (localView.getVisibility() != 8) && (a(i1)))
        {
          localaji = (aji)localView.getLayoutParams();
          if (!bool) {
            break label259;
          }
          i2 = localView.getRight();
        }
        for (i2 = rightMargin + i2;; i2 = localView.getLeft() - leftMargin - h)
        {
          b(paramCanvas, i2);
          i1 += 1;
          break;
        }
      }
    } while (!a(i3));
    View localView = getChildAt(i3 - 1);
    if (localView == null) {
      if (bool) {
        i1 = getPaddingLeft();
      }
    }
    for (;;)
    {
      b(paramCanvas, i1);
      return;
      i1 = getWidth() - getPaddingRight() - h;
      continue;
      localaji = (aji)localView.getLayoutParams();
      if (bool)
      {
        i1 = localView.getLeft() - leftMargin - h;
      }
      else
      {
        i1 = localView.getRight();
        i1 = rightMargin + i1;
      }
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(ajh.class.getName());
    }
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
      paramAccessibilityNodeInfo.setClassName(ajh.class.getName());
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1;
    int i2;
    int i3;
    int i4;
    int i5;
    int i6;
    label93:
    Object localObject1;
    if (c == 1)
    {
      i1 = getPaddingLeft();
      i2 = paramInt3 - paramInt1;
      i3 = getPaddingRight();
      i4 = getPaddingRight();
      i5 = getChildCount();
      paramInt1 = d;
      i6 = d;
      switch (paramInt1 & 0x70)
      {
      default: 
        paramInt1 = getPaddingTop();
        paramInt3 = 0;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        if (paramInt1 < i5)
        {
          localObject1 = getChildAt(paramInt1);
          if (localObject1 == null) {
            paramInt2 += 0;
          }
        }
        break;
      }
    }
    for (;;)
    {
      paramInt1 += 1;
      break label93;
      paramInt1 = getPaddingTop() + paramInt4 - paramInt2 - e;
      break;
      paramInt1 = getPaddingTop() + (paramInt4 - paramInt2 - e) / 2;
      break;
      if (((View)localObject1).getVisibility() != 8)
      {
        int i7 = ((View)localObject1).getMeasuredWidth();
        int i8 = ((View)localObject1).getMeasuredHeight();
        Object localObject2 = (aji)((View)localObject1).getLayoutParams();
        paramInt4 = h;
        paramInt3 = paramInt4;
        if (paramInt4 < 0) {
          paramInt3 = 0x800007 & i6;
        }
        switch (pg.a(paramInt3, rg.g(this)) & 0x7)
        {
        default: 
          paramInt3 = leftMargin + i1;
        }
        for (;;)
        {
          paramInt4 = paramInt2;
          if (a(paramInt1)) {
            paramInt4 = paramInt2 + m;
          }
          paramInt2 = paramInt4 + topMargin;
          b((View)localObject1, paramInt3, paramInt2 + 0, i7, i8);
          paramInt2 += bottomMargin + i8 + 0;
          paramInt1 += 0;
          break;
          paramInt3 = (i2 - i1 - i4 - i7) / 2 + i1 + leftMargin - rightMargin;
          continue;
          paramInt3 = i2 - i3 - i7 - rightMargin;
        }
        paramBoolean = ane.a(this);
        i3 = getPaddingTop();
        i5 = paramInt4 - paramInt2;
        i6 = getPaddingBottom();
        i7 = getPaddingBottom();
        i8 = getChildCount();
        paramInt2 = d;
        int i9 = d;
        boolean bool = f;
        localObject1 = j;
        localObject2 = k;
        switch (pg.a(paramInt2 & 0x800007, rg.g(this)))
        {
        default: 
          paramInt1 = getPaddingLeft();
          if (paramBoolean) {
            i1 = i8 - 1;
          }
          break;
        }
        for (paramInt4 = -1;; paramInt4 = 1)
        {
          paramInt2 = 0;
          paramInt3 = paramInt1;
          label507:
          int i12;
          View localView;
          if (paramInt2 < i8)
          {
            i12 = i1 + paramInt4 * paramInt2;
            localView = getChildAt(i12);
            if (localView == null)
            {
              paramInt3 += 0;
              paramInt1 = paramInt2;
            }
          }
          for (;;)
          {
            paramInt2 = paramInt1 + 1;
            break label507;
            paramInt1 = getPaddingLeft() + paramInt3 - paramInt1 - e;
            break;
            paramInt1 = getPaddingLeft() + (paramInt3 - paramInt1 - e) / 2;
            break;
            if (localView.getVisibility() != 8)
            {
              int i10 = localView.getMeasuredWidth();
              int i11 = localView.getMeasuredHeight();
              paramInt1 = -1;
              aji localaji = (aji)localView.getLayoutParams();
              i2 = paramInt1;
              if (bool)
              {
                i2 = paramInt1;
                if (height != -1) {
                  i2 = localView.getBaseline();
                }
              }
              i4 = h;
              paramInt1 = i4;
              if (i4 < 0) {
                paramInt1 = i9 & 0x70;
              }
              switch (paramInt1 & 0x70)
              {
              default: 
                paramInt1 = i3;
              }
              label715:
              label895:
              for (;;)
              {
                if (a(i12)) {
                  paramInt3 = h + paramInt3;
                }
                for (;;)
                {
                  paramInt3 += leftMargin;
                  b(localView, paramInt3 + 0, paramInt1, i10, i11);
                  paramInt3 += rightMargin + i10 + 0;
                  paramInt1 = paramInt2 + 0;
                  break;
                  i4 = topMargin + i3;
                  paramInt1 = i4;
                  if (i2 == -1) {
                    break label895;
                  }
                  paramInt1 = localObject1[1] - i2 + i4;
                  break label715;
                  paramInt1 = (i5 - i3 - i7 - i11) / 2 + i3 + topMargin - bottomMargin;
                  break label715;
                  i4 = i5 - i6 - i11 - bottomMargin;
                  paramInt1 = i4;
                  if (i2 == -1) {
                    break label895;
                  }
                  paramInt1 = localView.getMeasuredHeight();
                  paramInt1 = i4 - (localObject2[2] - (paramInt1 - i2));
                  break label715;
                  return;
                }
              }
            }
            paramInt1 = paramInt2;
          }
          i1 = 0;
        }
      }
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i3;
    int i1;
    int i2;
    int i8;
    int i4;
    float f1;
    int i14;
    int i15;
    int i16;
    int i7;
    int i6;
    boolean bool;
    int i5;
    int i9;
    Object localObject;
    int i13;
    int i12;
    int i11;
    int i10;
    aji localaji;
    if (c == 1)
    {
      e = 0;
      i3 = 0;
      i1 = 0;
      i2 = 0;
      i8 = 0;
      i4 = 1;
      f1 = 0.0F;
      i14 = getChildCount();
      i15 = View.MeasureSpec.getMode(paramInt1);
      i16 = View.MeasureSpec.getMode(paramInt2);
      i7 = 0;
      i6 = 0;
      int i17 = a;
      bool = g;
      i5 = Integer.MIN_VALUE;
      i9 = 0;
      for (;;)
      {
        if (i9 < i14)
        {
          localObject = getChildAt(i9);
          if (localObject == null)
          {
            e += 0;
            i13 = i9;
            i12 = i3;
            i11 = i1;
            i10 = i2;
            i9 = i8;
            i3 = i4;
            i2 = i6;
            i1 = i5;
            i13 += 1;
            i5 = i1;
            i6 = i2;
            i4 = i3;
            i8 = i9;
            i2 = i10;
            i1 = i11;
            i3 = i12;
            i9 = i13;
          }
          else
          {
            if (((View)localObject).getVisibility() == 8) {
              break label1662;
            }
            if (a(i9)) {
              e += m;
            }
            localaji = (aji)((View)localObject).getLayoutParams();
            f1 += g;
            if ((i16 == 1073741824) && (height == 0) && (g > 0.0F))
            {
              i6 = e;
              e = Math.max(i6, topMargin + i6 + bottomMargin);
              i6 = 1;
              label283:
              if ((i17 >= 0) && (i17 == i9 + 1)) {
                b = e;
              }
              if ((i9 < i17) && (g > 0.0F)) {
                throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
              }
            }
            else
            {
              i11 = Integer.MIN_VALUE;
              i10 = i11;
              if (height == 0)
              {
                i10 = i11;
                if (g > 0.0F)
                {
                  i10 = 0;
                  height = -2;
                }
              }
              if (f1 == 0.0F) {}
              for (i11 = e;; i11 = 0)
              {
                a((View)localObject, paramInt1, 0, paramInt2, i11);
                if (i10 != Integer.MIN_VALUE) {
                  height = i10;
                }
                i10 = ((View)localObject).getMeasuredHeight();
                i11 = e;
                e = Math.max(i11, i11 + i10 + topMargin + bottomMargin + 0);
                if (!bool) {
                  break label1659;
                }
                i5 = Math.max(i10, i5);
                break;
              }
            }
            i10 = 0;
            if ((i15 == 1073741824) || (width != -1)) {
              break label1656;
            }
            i7 = 1;
            i10 = 1;
            label499:
            i11 = leftMargin + rightMargin;
            i12 = ((View)localObject).getMeasuredWidth() + i11;
            i3 = Math.max(i3, i12);
            i13 = ane.a(i1, rg.i((View)localObject));
            if ((i4 != 0) && (width == -1))
            {
              i1 = 1;
              label560:
              if (g <= 0.0F) {
                break label678;
              }
              if (i10 == 0) {
                break label671;
              }
              label575:
              i8 = Math.max(i8, i11);
              i4 = i2;
              i2 = i6;
              i6 = i3;
              i3 = i8;
              i10 = i5;
              i8 = i13;
              i5 = i4;
              i4 = i3;
              i3 = i1;
              i1 = i2;
              i2 = i10;
            }
          }
        }
      }
    }
    for (;;)
    {
      i13 = i9 + 0;
      i9 = i1;
      i1 = i2;
      i2 = i9;
      i9 = i4;
      i10 = i5;
      i11 = i8;
      i12 = i6;
      break;
      i1 = 0;
      break label560;
      label671:
      i11 = i12;
      break label575;
      label678:
      if (i10 != 0) {}
      for (;;)
      {
        i10 = Math.max(i2, i11);
        i4 = i1;
        i1 = i6;
        i2 = i5;
        i6 = i3;
        i3 = i4;
        i4 = i8;
        i5 = i10;
        i8 = i13;
        break;
        i11 = i12;
      }
      if ((e > 0) && (a(i14))) {
        e += m;
      }
      if ((bool) && ((i16 == Integer.MIN_VALUE) || (i16 == 0)))
      {
        e = 0;
        i9 = 0;
        if (i9 < i14)
        {
          localObject = getChildAt(i9);
          if (localObject == null) {
            e += 0;
          }
          for (;;)
          {
            i9 += 1;
            break;
            if (((View)localObject).getVisibility() == 8)
            {
              i9 += 0;
            }
            else
            {
              localObject = (aji)((View)localObject).getLayoutParams();
              i10 = e;
              i11 = topMargin;
              e = Math.max(i10, bottomMargin + (i10 + i5 + i11) + 0);
            }
          }
        }
      }
      e += getPaddingTop() + getPaddingBottom();
      i11 = rg.a(Math.max(e, getSuggestedMinimumHeight()), paramInt2, 0);
      i9 = (0xFFFFFF & i11) - e;
      if ((i6 != 0) || ((i9 != 0) && (f1 > 0.0F)))
      {
        if (i > 0.0F) {
          f1 = i;
        }
        e = 0;
        i5 = i4;
        i8 = 0;
        i4 = i3;
        i3 = i2;
        i2 = i5;
        i5 = i9;
        if (i8 < i14)
        {
          localObject = getChildAt(i8);
          if (((View)localObject).getVisibility() == 8) {
            break label1629;
          }
          localaji = (aji)((View)localObject).getLayoutParams();
          float f2 = g;
          if (f2 <= 0.0F) {
            break label1614;
          }
          i9 = (int)(i5 * f2 / f1);
          i12 = getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + leftMargin + rightMargin, width);
          if ((height != 0) || (i16 != 1073741824))
          {
            i10 = i9 + ((View)localObject).getMeasuredHeight();
            i6 = i10;
            if (i10 < 0) {
              i6 = 0;
            }
            ((View)localObject).measure(i12, View.MeasureSpec.makeMeasureSpec(i6, 1073741824));
            i1 = ane.a(i1, rg.i((View)localObject) & 0xFF00);
            i6 = i5 - i9;
            i5 = i1;
            f1 -= f2;
            i1 = i6;
            label1183:
            i9 = leftMargin + rightMargin;
            i10 = ((View)localObject).getMeasuredWidth() + i9;
            i6 = Math.max(i4, i10);
            if ((i15 == 1073741824) || (width != -1)) {
              break label1383;
            }
            i4 = 1;
            label1234:
            if (i4 == 0) {
              break label1389;
            }
            i4 = i9;
            label1243:
            i4 = Math.max(i3, i4);
            if ((i2 == 0) || (width != -1)) {
              break label1396;
            }
            i2 = 1;
            label1269:
            i3 = e;
            i9 = ((View)localObject).getMeasuredHeight();
            i10 = topMargin;
            e = Math.max(i3, bottomMargin + (i9 + i3 + i10) + 0);
            i3 = i6;
          }
        }
      }
      for (;;)
      {
        i8 += 1;
        i6 = i3;
        i3 = i5;
        i5 = i1;
        i1 = i3;
        i3 = i4;
        i4 = i6;
        break;
        if (i9 > 0) {}
        for (i6 = i9;; i6 = 0)
        {
          ((View)localObject).measure(i12, View.MeasureSpec.makeMeasureSpec(i6, 1073741824));
          break;
        }
        label1383:
        i4 = 0;
        break label1234;
        label1389:
        i4 = i10;
        break label1243;
        label1396:
        i2 = 0;
        break label1269;
        e += getPaddingTop() + getPaddingBottom();
        i5 = i2;
        i2 = i3;
        i3 = i4;
        i4 = i5;
        for (;;)
        {
          if ((i4 == 0) && (i15 != 1073741824)) {}
          for (;;)
          {
            setMeasuredDimension(rg.a(Math.max(i2 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), paramInt1, i1), i11);
            if (i7 != 0) {
              a(i14, paramInt2);
            }
            return;
            i6 = Math.max(i2, i8);
            if ((!bool) || (i16 == 1073741824)) {
              break;
            }
            i2 = 0;
            while (i2 < i14)
            {
              localObject = getChildAt(i2);
              if ((localObject != null) && (((View)localObject).getVisibility() != 8) && (getLayoutParamsg > 0.0F)) {
                ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(((View)localObject).getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i5, 1073741824));
              }
              i2 += 1;
            }
            b(paramInt1, paramInt2);
            return;
            i2 = i3;
          }
          i2 = i6;
        }
        label1614:
        i6 = i1;
        i1 = i5;
        i5 = i6;
        break label1183;
        label1629:
        i6 = i3;
        i3 = i4;
        i9 = i1;
        i4 = i6;
        i1 = i5;
        i5 = i9;
      }
      label1656:
      break label499;
      label1659:
      break label283;
      label1662:
      i10 = i5;
      i11 = i6;
      i5 = i2;
      i6 = i3;
      i12 = i1;
      i2 = i10;
      i1 = i11;
      i3 = i4;
      i4 = i8;
      i8 = i12;
    }
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     ajh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */