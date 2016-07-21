package android.support.v7.view.menu;

import acf;
import ach;
import ack;
import adu;
import ady;
import aem;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView
  extends LinearLayout
  implements aem
{
  public boolean a;
  public boolean b;
  private ady c;
  private ImageView d;
  private RadioButton e;
  private TextView f;
  private CheckBox g;
  private TextView h;
  private Drawable i;
  private int j;
  private Context k;
  private int l;
  private Context m;
  private LayoutInflater n;
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    m = paramContext;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, ack.bM, paramInt, 0);
    i = paramAttributeSet.getDrawable(ack.bN);
    j = paramAttributeSet.getResourceId(ack.bO, -1);
    a = paramAttributeSet.getBoolean(ack.bP, false);
    k = paramContext;
    paramAttributeSet.recycle();
  }
  
  private final LayoutInflater c()
  {
    if (n == null) {
      n = LayoutInflater.from(m);
    }
    return n;
  }
  
  public final ady a()
  {
    return c;
  }
  
  public final void a(ady paramady)
  {
    c = paramady;
    l = 0;
    int i1;
    Object localObject1;
    label63:
    Object localObject2;
    label144:
    label168:
    label205:
    label233:
    char c1;
    if (paramady.isVisible())
    {
      i1 = 0;
      setVisibility(i1);
      localObject1 = paramady.a(this);
      if (localObject1 == null) {
        break label440;
      }
      f.setText((CharSequence)localObject1);
      if (f.getVisibility() != 0) {
        f.setVisibility(0);
      }
      boolean bool = paramady.isCheckable();
      if ((bool) || (e != null) || (g != null))
      {
        if (!c.e()) {
          break label464;
        }
        if (e == null)
        {
          e = ((RadioButton)c().inflate(ach.l, this, false));
          addView(e);
        }
        localObject1 = e;
        localObject2 = g;
        if (!bool) {
          break label519;
        }
        ((CompoundButton)localObject1).setChecked(c.isChecked());
        if (!bool) {
          break label513;
        }
        i1 = 0;
        if (((CompoundButton)localObject1).getVisibility() != i1) {
          ((CompoundButton)localObject1).setVisibility(i1);
        }
        if ((localObject2 != null) && (((CompoundButton)localObject2).getVisibility() != 8)) {
          ((CompoundButton)localObject2).setVisibility(8);
        }
      }
      bool = paramady.d();
      paramady.c();
      if ((!bool) || (!c.d())) {
        break label554;
      }
      i1 = 0;
      if (i1 == 0)
      {
        localObject2 = h;
        c1 = c.c();
        if (c1 != 0) {
          break label560;
        }
        localObject1 = "";
        ((TextView)localObject2).setText((CharSequence)localObject1);
      }
      if (h.getVisibility() != i1) {
        h.setVisibility(i1);
      }
      localObject1 = paramady.getIcon();
      if ((!c.b.i) && (!b)) {
        break label661;
      }
      i1 = 1;
      label313:
      if (((i1 != 0) || (a)) && ((d != null) || (localObject1 != null) || (a)))
      {
        if (d == null)
        {
          d = ((ImageView)c().inflate(ach.j, this, false));
          addView(d, 0);
        }
        if ((localObject1 == null) && (!a)) {
          break label672;
        }
        localObject2 = d;
        if (i1 == 0) {
          break label666;
        }
        label400:
        ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
        if (d.getVisibility() != 0) {
          d.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      setEnabled(paramady.isEnabled());
      return;
      i1 = 8;
      break;
      label440:
      if (f.getVisibility() == 8) {
        break label63;
      }
      f.setVisibility(8);
      break label63;
      label464:
      if (g == null)
      {
        g = ((CheckBox)c().inflate(ach.i, this, false));
        addView(g);
      }
      localObject1 = g;
      localObject2 = e;
      break label144;
      label513:
      i1 = 8;
      break label168;
      label519:
      if (g != null) {
        g.setVisibility(8);
      }
      if (e == null) {
        break label205;
      }
      e.setVisibility(8);
      break label205;
      label554:
      i1 = 8;
      break label233;
      label560:
      localObject1 = new StringBuilder(ady.f);
      switch (c1)
      {
      default: 
        ((StringBuilder)localObject1).append(c1);
      }
      for (;;)
      {
        localObject1 = ((StringBuilder)localObject1).toString();
        break;
        ((StringBuilder)localObject1).append(ady.g);
        continue;
        ((StringBuilder)localObject1).append(ady.h);
        continue;
        ((StringBuilder)localObject1).append(ady.i);
      }
      label661:
      i1 = 0;
      break label313;
      label666:
      localObject1 = null;
      break label400;
      label672:
      d.setVisibility(8);
    }
  }
  
  public final boolean b()
  {
    return false;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    setBackgroundDrawable(i);
    f = ((TextView)findViewById(acf.D));
    if (j != -1) {
      f.setTextAppearance(k, j);
    }
    h = ((TextView)findViewById(acf.z));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((d != null) && (a))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)d.getLayoutParams();
      if ((height > 0) && (width <= 0)) {
        width = height;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.view.menu.ListMenuItemView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */