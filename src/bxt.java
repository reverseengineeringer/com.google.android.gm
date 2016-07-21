import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import com.android.mail.browse.MessageFooterView;

public final class bxt
  extends bxh
{
  private final bxp e;
  private final byv f;
  private final bxu g;
  
  public bxt(bxp parambxp, byv parambyv, bxu parambxu)
  {
    e = parambxp;
    f = parambyv;
    g = parambxu;
  }
  
  public final int a()
  {
    return 3;
  }
  
  public final View a(Context paramContext, LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    paramContext = (MessageFooterView)paramLayoutInflater.inflate(bue.q, paramViewGroup, false);
    paramContext.a(e.c, e.d, e.b, e.f, e.g);
    paramContext.setTag("overlay_item_root");
    paramLayoutInflater = f;
    if (a != null) {
      a.f = paramLayoutInflater;
    }
    a(new View[] { paramContext, paramContext.findViewById(buc.fH) });
    return paramContext;
  }
  
  public final void a(View paramView, boolean paramBoolean)
  {
    ((MessageFooterView)paramView).a(g, paramBoolean);
    d = paramView;
  }
  
  public final boolean b()
  {
    return true;
  }
  
  public final View.OnKeyListener c()
  {
    return e.w;
  }
  
  public final int d()
  {
    return 48;
  }
  
  public final int e()
  {
    if (!g.g) {
      return 0;
    }
    return super.e();
  }
}

/* Location:
 * Qualified Name:     bxt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */