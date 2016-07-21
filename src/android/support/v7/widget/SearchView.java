package android.support.v7.widget;

import acd;
import adb;
import ajh;
import alx;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import java.lang.reflect.Method;

public final class SearchView
  extends ajh
  implements adb
{
  static final alx a;
  private static final boolean b;
  private final SearchView.SearchAutoComplete c;
  private final View d;
  private final View e;
  private final ImageView i;
  private final ImageView j;
  private final ImageView k;
  private final ImageView l;
  private final ImageView m;
  private View.OnClickListener n;
  private boolean o;
  private boolean p;
  private boolean q;
  private boolean r;
  private int s;
  private boolean t;
  private CharSequence u;
  private boolean v;
  private int w;
  private Runnable x;
  private final Runnable y;
  private Runnable z;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 8) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      a = new alx();
      return;
    }
  }
  
  static boolean a(Context paramContext)
  {
    return getResourcesgetConfigurationorientation == 2;
  }
  
  private final void b(boolean paramBoolean)
  {
    int i5 = 1;
    int i4 = 8;
    p = paramBoolean;
    int i1;
    if (paramBoolean)
    {
      i2 = 0;
      if (TextUtils.isEmpty(c.getText())) {
        break label312;
      }
      i1 = 1;
      label33:
      i.setVisibility(i2);
      if ((!q) || (!f()) || (!hasFocus()) || ((i1 == 0) && (t))) {
        break label364;
      }
    }
    label96:
    label122:
    label145:
    label166:
    label180:
    label210:
    label225:
    label312:
    label322:
    label327:
    label332:
    label338:
    label345:
    label353:
    label358:
    label364:
    for (int i2 = 0;; i2 = 8)
    {
      j.setVisibility(i2);
      Object localObject = d;
      int i3;
      if (paramBoolean)
      {
        i2 = 8;
        ((View)localObject).setVisibility(i2);
        if ((m.getDrawable() != null) && (!o)) {
          break label322;
        }
        i2 = 8;
        m.setVisibility(i2);
        if (TextUtils.isEmpty(c.getText())) {
          break label327;
        }
        i2 = 1;
        if ((i2 == 0) && ((!o) || (v))) {
          break label332;
        }
        i3 = 1;
        localObject = k;
        if (i3 == 0) {
          break label338;
        }
        i3 = 0;
        ((ImageView)localObject).setVisibility(i3);
        Drawable localDrawable = k.getDrawable();
        if (localDrawable != null)
        {
          if (i2 == 0) {
            break label345;
          }
          localObject = ENABLED_STATE_SET;
          localDrawable.setState((int[])localObject);
        }
        if (i1 != 0) {
          break label353;
        }
        i1 = i5;
        if ((!t) || (p) || (i1 == 0)) {
          break label358;
        }
        j.setVisibility(8);
      }
      for (i1 = 0;; i1 = 8)
      {
        l.setVisibility(i1);
        i1 = i4;
        if (f()) {
          if (j.getVisibility() != 0)
          {
            i1 = i4;
            if (l.getVisibility() != 0) {}
          }
          else
          {
            i1 = 0;
          }
        }
        e.setVisibility(i1);
        return;
        i2 = 8;
        break;
        i1 = 0;
        break label33;
        i2 = 0;
        break label96;
        i2 = 0;
        break label122;
        i2 = 0;
        break label145;
        i3 = 0;
        break label166;
        i3 = 8;
        break label180;
        localObject = EMPTY_STATE_SET;
        break label210;
        i1 = 0;
        break label225;
      }
    }
  }
  
  private final int e()
  {
    return getContext().getResources().getDimensionPixelSize(acd.d);
  }
  
  private final boolean f()
  {
    return ((q) || (t)) && (!p);
  }
  
  private final void g()
  {
    post(y);
  }
  
  public final void a()
  {
    if (v) {}
    do
    {
      return;
      v = true;
      w = c.getImeOptions();
      c.setImeOptions(w | 0x2000000);
      c.setText("");
      b(false);
      c.requestFocus();
      a(true);
    } while (n == null);
    n.onClick(this);
  }
  
  final void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      post(x);
    }
    InputMethodManager localInputMethodManager;
    do
    {
      return;
      removeCallbacks(x);
      localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    } while (localInputMethodManager == null);
    localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
  }
  
  public final void b()
  {
    c.setText("");
    c.setSelection(c.length());
    u = "";
    clearFocus();
    b(true);
    c.setImeOptions(w);
    v = false;
  }
  
  final void c()
  {
    b(p);
    g();
    alx localalx;
    SearchView.SearchAutoComplete localSearchAutoComplete;
    if (c.hasFocus())
    {
      localalx = a;
      localSearchAutoComplete = c;
      if (a == null) {}
    }
    try
    {
      a.invoke(localSearchAutoComplete, new Object[0]);
      localalx = a;
      localSearchAutoComplete = c;
      if (b != null) {}
      try
      {
        b.invoke(localSearchAutoComplete, new Object[0]);
        return;
      }
      catch (Exception localException1) {}
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
  
  public final void clearFocus()
  {
    r = true;
    a(false);
    super.clearFocus();
    c.clearFocus();
    r = false;
  }
  
  protected final void onDetachedFromWindow()
  {
    removeCallbacks(y);
    post(z);
    super.onDetachedFromWindow();
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    if (p)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    int i2 = View.MeasureSpec.getMode(paramInt1);
    int i1 = View.MeasureSpec.getSize(paramInt1);
    switch (i2)
    {
    default: 
      paramInt1 = i1;
    }
    for (;;)
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), paramInt2);
      return;
      if (s > 0)
      {
        paramInt1 = Math.min(s, i1);
      }
      else
      {
        paramInt1 = Math.min(e(), i1);
        continue;
        paramInt1 = i1;
        if (s > 0)
        {
          paramInt1 = Math.min(s, i1);
          continue;
          if (s > 0) {
            paramInt1 = s;
          } else {
            paramInt1 = e();
          }
        }
      }
    }
  }
  
  protected final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SearchView.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SearchView.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    b(a);
    requestLayout();
  }
  
  protected final Parcelable onSaveInstanceState()
  {
    SearchView.SavedState localSavedState = new SearchView.SavedState(super.onSaveInstanceState());
    a = p;
    return localSavedState;
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    g();
  }
  
  public final boolean requestFocus(int paramInt, Rect paramRect)
  {
    if (r) {}
    while (!isFocusable()) {
      return false;
    }
    if (!p)
    {
      boolean bool = c.requestFocus(paramInt, paramRect);
      if (bool) {
        b(false);
      }
      return bool;
    }
    return super.requestFocus(paramInt, paramRect);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.SearchView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */