import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.mail.browse.SuperCollapsedBlock;
import java.text.NumberFormat;

public final class bxv
  extends bxh
{
  public final int e;
  public final int f;
  final boolean g;
  
  public bxv(bxp parambxp, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    e = paramInt1;
    f = paramInt2;
    g = paramBoolean;
  }
  
  public final int a()
  {
    return 4;
  }
  
  public final View a(Context paramContext, LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    paramContext = (SuperCollapsedBlock)paramLayoutInflater.inflate(bue.aj, paramViewGroup, false);
    b = h.m;
    paramContext.setOnKeyListener(h.w);
    paramContext.setTag("overlay_item_root");
    a(new View[] { paramContext });
    return paramContext;
  }
  
  public final void a(View paramView, boolean paramBoolean)
  {
    SuperCollapsedBlock localSuperCollapsedBlock = (SuperCollapsedBlock)paramView;
    a = this;
    c.setVisibility(0);
    d.setVisibility(8);
    e = (f - e + 1);
    Object localObject = NumberFormat.getIntegerInstance().format(e);
    c.setText((CharSequence)localObject);
    localObject = localSuperCollapsedBlock.getResources();
    if (a.g) {}
    for (int i = btz.aa;; i = btz.j)
    {
      c.setTextColor(((Resources)localObject).getColor(i));
      localSuperCollapsedBlock.setContentDescription(((Resources)localObject).getQuantityString(buh.v, e, new Object[] { Integer.valueOf(e) }));
      d = paramView;
      return;
    }
  }
  
  public final boolean b()
  {
    return true;
  }
  
  public final View.OnKeyListener c()
  {
    return h.w;
  }
}

/* Location:
 * Qualified Name:     bxv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */