package android.support.design.internal;

import ady;
import aem;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.TextView;
import c;
import e;
import f;
import g;
import k;
import kn;
import yq;
import yw;

public class NavigationMenuItemView
  extends k
  implements aem
{
  private static final int[] c = { 16842912 };
  private final int d;
  private final CheckedTextView e;
  private FrameLayout i;
  private ady j;
  private ColorStateList k;
  
  public NavigationMenuItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(0);
    LayoutInflater.from(paramContext).inflate(g.b, this, true);
    d = paramContext.getResources().getDimensionPixelSize(e.d);
    e = ((CheckedTextView)findViewById(f.b));
    e.setDuplicateParentStateEnabled(true);
  }
  
  public final ady a()
  {
    return j;
  }
  
  public final void a(ady paramady)
  {
    j = paramady;
    int m;
    Object localObject2;
    Object localObject1;
    if (paramady.isVisible())
    {
      m = 0;
      setVisibility(m);
      if (getBackground() == null)
      {
        localObject2 = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(c.a, (TypedValue)localObject2, true)) {
          break label290;
        }
        localObject1 = new StateListDrawable();
        ((StateListDrawable)localObject1).addState(c, new ColorDrawable(data));
        ((StateListDrawable)localObject1).addState(EMPTY_STATE_SET, new ColorDrawable(0));
        label99:
        setBackgroundDrawable((Drawable)localObject1);
      }
      paramady.isCheckable();
      refreshDrawableState();
      boolean bool = paramady.isChecked();
      refreshDrawableState();
      e.setChecked(bool);
      setEnabled(paramady.isEnabled());
      localObject1 = paramady.getTitle();
      e.setText((CharSequence)localObject1);
      localObject1 = paramady.getIcon();
      if (localObject1 == null) {
        break label306;
      }
      localObject2 = ((Drawable)localObject1).getConstantState();
      if (localObject2 != null) {
        break label296;
      }
      label177:
      localObject1 = kn.e((Drawable)localObject1).mutate();
      ((Drawable)localObject1).setBounds(0, 0, d, d);
      kn.a((Drawable)localObject1, k);
    }
    label290:
    label296:
    label306:
    for (;;)
    {
      localObject2 = e;
      yq.a.a((TextView)localObject2, (Drawable)localObject1, null, null, null);
      paramady = paramady.getActionView();
      if (i == null) {
        i = ((FrameLayout)((ViewStub)findViewById(f.a)).inflate());
      }
      i.removeAllViews();
      if (paramady != null) {
        i.addView(paramady);
      }
      return;
      m = 8;
      break;
      localObject1 = null;
      break label99;
      localObject1 = ((Drawable.ConstantState)localObject2).newDrawable();
      break label177;
    }
  }
  
  public final boolean b()
  {
    return false;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if ((j != null) && (j.isCheckable()) && (j.isChecked())) {
      mergeDrawableStates(arrayOfInt, c);
    }
    return arrayOfInt;
  }
}

/* Location:
 * Qualified Name:     android.support.design.internal.NavigationMenuItemView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */