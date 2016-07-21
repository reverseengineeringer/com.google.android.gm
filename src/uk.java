import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;

public final class uk
{
  public static final up a = new uu();
  public final Object b;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 22)
    {
      a = new un();
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      a = new um();
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      a = new ut();
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      a = new us();
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      a = new ur();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      a = new uq();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      a = new uo();
      return;
    }
  }
  
  public uk(Object paramObject)
  {
    b = paramObject;
  }
  
  public static uk a(Object paramObject)
  {
    if (paramObject != null) {
      return new uk(paramObject);
    }
    return null;
  }
  
  public final int a()
  {
    return a.b(b);
  }
  
  public final void a(int paramInt)
  {
    a.a(b, paramInt);
  }
  
  public final void a(Rect paramRect)
  {
    a.a(b, paramRect);
  }
  
  public final void a(View paramView)
  {
    a.b(b, paramView);
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    a.d(b, paramCharSequence);
  }
  
  public final void a(boolean paramBoolean)
  {
    a.c(b, paramBoolean);
  }
  
  public final boolean a(ul paramul)
  {
    return a.b(b, w);
  }
  
  public final void b(Rect paramRect)
  {
    a.c(b, paramRect);
  }
  
  public final void b(CharSequence paramCharSequence)
  {
    a.b(b, paramCharSequence);
  }
  
  public final void b(Object paramObject)
  {
    a.d(b, a);
  }
  
  public final void b(boolean paramBoolean)
  {
    a.d(b, paramBoolean);
  }
  
  public final boolean b()
  {
    return a.k(b);
  }
  
  public final void c(Rect paramRect)
  {
    a.b(b, paramRect);
  }
  
  public final void c(CharSequence paramCharSequence)
  {
    a.c(b, paramCharSequence);
  }
  
  public final void c(boolean paramBoolean)
  {
    a.h(b, paramBoolean);
  }
  
  public final boolean c()
  {
    return a.l(b);
  }
  
  public final void d(Rect paramRect)
  {
    a.d(b, paramRect);
  }
  
  public final void d(boolean paramBoolean)
  {
    a.i(b, paramBoolean);
  }
  
  public final boolean d()
  {
    return a.p(b);
  }
  
  public final void e(boolean paramBoolean)
  {
    a.g(b, paramBoolean);
  }
  
  public final boolean e()
  {
    return a.i(b);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (uk)paramObject;
        if (b != null) {
          break;
        }
      } while (b == null);
      return false;
    } while (b.equals(b));
    return false;
  }
  
  public final void f(boolean paramBoolean)
  {
    a.a(b, paramBoolean);
  }
  
  public final boolean f()
  {
    return a.m(b);
  }
  
  public final void g(boolean paramBoolean)
  {
    a.b(b, paramBoolean);
  }
  
  public final boolean g()
  {
    return a.j(b);
  }
  
  public final CharSequence h()
  {
    return a.e(b);
  }
  
  public final void h(boolean paramBoolean)
  {
    a.f(b, paramBoolean);
  }
  
  public final int hashCode()
  {
    if (b == null) {
      return 0;
    }
    return b.hashCode();
  }
  
  public final CharSequence i()
  {
    return a.c(b);
  }
  
  public final CharSequence j()
  {
    return a.f(b);
  }
  
  public final CharSequence k()
  {
    return a.d(b);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    Object localObject = new Rect();
    a((Rect)localObject);
    localStringBuilder.append("; boundsInParent: " + localObject);
    c((Rect)localObject);
    localStringBuilder.append("; boundsInScreen: " + localObject);
    localStringBuilder.append("; packageName: ").append(h());
    localStringBuilder.append("; className: ").append(i());
    localStringBuilder.append("; text: ").append(j());
    localStringBuilder.append("; contentDescription: ").append(k());
    localStringBuilder.append("; viewId: ").append(a.t(b));
    localStringBuilder.append("; checkable: ").append(a.g(b));
    localStringBuilder.append("; checked: ").append(a.h(b));
    localStringBuilder.append("; focusable: ").append(b());
    localStringBuilder.append("; focused: ").append(c());
    localStringBuilder.append("; selected: ").append(d());
    localStringBuilder.append("; clickable: ").append(e());
    localStringBuilder.append("; longClickable: ").append(f());
    localStringBuilder.append("; enabled: ").append(g());
    localStringBuilder.append("; password: ").append(a.n(b));
    localStringBuilder.append("; scrollable: " + a.o(b));
    localStringBuilder.append("; [");
    int i = a();
    if (i != 0)
    {
      int j = 1 << Integer.numberOfTrailingZeros(i);
      i = (j ^ 0xFFFFFFFF) & i;
      switch (j)
      {
      default: 
        localObject = "ACTION_UNKNOWN";
      }
      for (;;)
      {
        localStringBuilder.append((String)localObject);
        if (i != 0) {
          localStringBuilder.append(", ");
        }
        break;
        localObject = "ACTION_FOCUS";
        continue;
        localObject = "ACTION_CLEAR_FOCUS";
        continue;
        localObject = "ACTION_SELECT";
        continue;
        localObject = "ACTION_CLEAR_SELECTION";
        continue;
        localObject = "ACTION_CLICK";
        continue;
        localObject = "ACTION_LONG_CLICK";
        continue;
        localObject = "ACTION_ACCESSIBILITY_FOCUS";
        continue;
        localObject = "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
        continue;
        localObject = "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
        continue;
        localObject = "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
        continue;
        localObject = "ACTION_NEXT_HTML_ELEMENT";
        continue;
        localObject = "ACTION_PREVIOUS_HTML_ELEMENT";
        continue;
        localObject = "ACTION_SCROLL_FORWARD";
        continue;
        localObject = "ACTION_SCROLL_BACKWARD";
        continue;
        localObject = "ACTION_CUT";
        continue;
        localObject = "ACTION_COPY";
        continue;
        localObject = "ACTION_PASTE";
        continue;
        localObject = "ACTION_SET_SELECTION";
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     uk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */