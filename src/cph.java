import android.animation.AnimatorSet;
import android.app.Fragment;
import android.view.View;

final class cph
  implements Runnable
{
  cph(cpf paramcpf) {}
  
  public final void run()
  {
    if (a.X != null) {
      a.X.cancel();
    }
    Object localObject1 = a.g();
    Object localObject2 = a.G.a();
    if ((localObject1 == null) || (localObject2 == null))
    {
      localObject2 = cht.I;
      localObject1 = String.valueOf(localObject1);
      if (String.valueOf(localObject1).length() + 40 + "OPC.mAnimateFromConvViewToListRunnable: " + (String)localObject1 == null) {}
      for (localObject1 = "listFragment is null";; localObject1 = "conversationView is null")
      {
        cvm.d((String)localObject2, (String)localObject1, new Object[0]);
        cpf.a(a, null, -1L, true);
        return;
      }
    }
    View localView = ((cje)localObject1).getView();
    if (localView == null)
    {
      cvm.d(cht.I, "OPC.mAnimateFromConvViewToListRunnable: listFragmentRootView is null", new Object[0]);
      cpf.a(a, null, -1L, true);
      return;
    }
    cqp localcqp = ((cje)localObject1).c();
    localcqp.a(new cpi(this, "cvClose", (Fragment)localObject2, (cjf)localObject2, localcqp, localView, (cje)localObject1));
  }
}

/* Location:
 * Qualified Name:     cph
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */