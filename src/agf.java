import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;

final class agf
{
  private final View a;
  private final agj b;
  private amn c;
  private amn d;
  private amn e;
  
  agf(View paramView, agj paramagj)
  {
    a = paramView;
    b = paramagj;
  }
  
  final ColorStateList a()
  {
    if (d != null) {
      return d.a;
    }
    return null;
  }
  
  final void a(int paramInt)
  {
    if (b != null) {}
    for (ColorStateList localColorStateList = b.b(a.getContext(), paramInt);; localColorStateList = null)
    {
      b(localColorStateList);
      return;
    }
  }
  
  final void a(ColorStateList paramColorStateList)
  {
    if (d == null) {
      d = new amn();
    }
    d.a = paramColorStateList;
    d.d = true;
    c();
  }
  
  final void a(PorterDuff.Mode paramMode)
  {
    if (d == null) {
      d = new amn();
    }
    d.b = paramMode;
    d.c = true;
    c();
  }
  
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = a.getContext().obtainStyledAttributes(paramAttributeSet, ack.dz, paramInt, 0);
    try
    {
      Object localObject1;
      if (paramAttributeSet.hasValue(ack.dA))
      {
        localObject1 = b.b(a.getContext(), paramAttributeSet.getResourceId(ack.dA, -1));
        if (localObject1 != null) {
          b((ColorStateList)localObject1);
        }
      }
      Object localObject3;
      if (paramAttributeSet.hasValue(ack.dB))
      {
        localObject1 = a;
        localObject3 = paramAttributeSet.getColorStateList(ack.dB);
        rg.a.a((View)localObject1, (ColorStateList)localObject3);
      }
      if (paramAttributeSet.hasValue(ack.dC))
      {
        localObject1 = a;
        localObject3 = aij.a(paramAttributeSet.getInt(ack.dC, -1));
        rg.a.a((View)localObject1, (PorterDuff.Mode)localObject3);
      }
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  final PorterDuff.Mode b()
  {
    if (d != null) {
      return d.b;
    }
    return null;
  }
  
  final void b(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      if (c == null) {
        c = new amn();
      }
      c.a = paramColorStateList;
      c.d = true;
    }
    for (;;)
    {
      c();
      return;
      c = null;
    }
  }
  
  final void c()
  {
    int i = 0;
    Drawable localDrawable = a.getBackground();
    if (localDrawable != null)
    {
      if (Build.VERSION.SDK_INT != 21) {
        break label166;
      }
      if (e == null) {
        e = new amn();
      }
      amn localamn = e;
      a = null;
      d = false;
      b = null;
      c = false;
      Object localObject = a;
      localObject = rg.a.D((View)localObject);
      if (localObject != null)
      {
        d = true;
        a = ((ColorStateList)localObject);
      }
      localObject = a;
      localObject = rg.a.E((View)localObject);
      if (localObject != null)
      {
        c = true;
        b = ((PorterDuff.Mode)localObject);
      }
      if ((d) || (c))
      {
        agj.a(localDrawable, localamn, a.getDrawableState());
        i = 1;
      }
      if (i == 0) {
        break label166;
      }
    }
    label166:
    do
    {
      return;
      if (d != null)
      {
        agj.a(localDrawable, d, a.getDrawableState());
        return;
      }
    } while (c == null);
    agj.a(localDrawable, c, a.getDrawableState());
  }
}

/* Location:
 * Qualified Name:     agf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */