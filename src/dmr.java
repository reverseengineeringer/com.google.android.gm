import android.view.View;
import android.view.ViewParent;

public final class dmr
{
  public final dmo a;
  
  public dmr(dmo paramdmo)
  {
    a = paramdmo;
  }
  
  public static dmq a(View paramView, dmq paramdmq)
  {
    cxa.g("VEL.viewTraversal");
    a(paramdmq, paramView);
    for (paramView = paramView.getParent(); paramView != null; paramView = paramView.getParent()) {
      if ((paramView instanceof View)) {
        a(paramdmq, (View)paramView);
      }
    }
    cxa.a();
    return paramdmq;
  }
  
  private static void a(dmq paramdmq, View paramView)
  {
    paramView = gnu.a(paramView);
    if (paramView != null) {
      paramdmq.a(paramView);
    }
  }
  
  public final void a(gnr paramgnr, int paramInt, String paramString)
  {
    dmo localdmo = a;
    dmq localdmq = new dmq(paramInt);
    localdmq.a(paramgnr);
    localdmo.a(localdmq, paramString);
  }
  
  public final void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {}
    for (Object localObject = hlj.b;; localObject = hlj.a)
    {
      localObject = new gnr((gnt)localObject);
      cvm.a(cvl.a, "VisualElement: Recording app visibility with address %s", new Object[] { paramString });
      a((gnr)localObject, 25, paramString);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     dmr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */