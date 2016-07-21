import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.ContextThemeWrapper;
import android.view.View;

public final class aag
{
  public final zy a;
  private int b;
  
  public aag(Context paramContext)
  {
    this(paramContext, aaf.a(paramContext, 0));
  }
  
  private aag(Context paramContext, int paramInt)
  {
    a = new zy(new ContextThemeWrapper(paramContext, aaf.a(paramContext, paramInt)));
    b = paramInt;
  }
  
  public final aaf a()
  {
    aaf localaaf = new aaf(a.a, b);
    a.apply(a);
    localaaf.setCancelable(a.o);
    if (a.o) {
      localaaf.setCanceledOnTouchOutside(true);
    }
    localaaf.setOnCancelListener(a.p);
    localaaf.setOnDismissListener(a.q);
    if (a.r != null) {
      localaaf.setOnKeyListener(a.r);
    }
    return localaaf;
  }
  
  public final aag a(int paramInt)
  {
    a.f = a.a.getText(paramInt);
    return this;
  }
  
  public final aag a(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    a.i = a.a.getText(paramInt);
    a.j = paramOnClickListener;
    return this;
  }
  
  public final aag a(View paramView)
  {
    a.w = paramView;
    a.v = 0;
    a.B = false;
    return this;
  }
  
  public final aag b(int paramInt)
  {
    a.h = a.a.getText(paramInt);
    return this;
  }
  
  public final aag b(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    a.k = a.a.getText(paramInt);
    a.l = paramOnClickListener;
    return this;
  }
}

/* Location:
 * Qualified Name:     aag
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */