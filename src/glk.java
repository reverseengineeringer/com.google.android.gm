import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import java.util.ArrayList;
import java.util.List;

final class glk
  implements Runnable
{
  glk(glj paramglj) {}
  
  public final void run()
  {
    Object localObject1 = a.c;
    Object localObject2 = a.b;
    if ((c) || (!b)) {}
    for (;;)
    {
      localObject1 = a;
      if (((glj)localObject1).c())
      {
        localObject2 = new ArrayList();
        glq localglq = f;
        if (h.b) {
          ((List)localObject2).add(new glf(b, a, h));
        }
        if (!((List)localObject2).isEmpty())
        {
          localObject2 = new gmf((List)localObject2);
          localObject1 = b;
          gkb.a((Application)localObject1).a(new gmg((gmf)localObject2, (Application)localObject1));
          ((gmf)localObject2).a();
        }
      }
      gke.a(a.a, a.b).a();
      return;
      ((gmk)localObject1).a((Context)localObject2);
      ((Context)localObject2).registerReceiver(new gml(), new IntentFilter("com.google.gservices.intent.action.GSERVICES_CHANGED"));
    }
  }
}

/* Location:
 * Qualified Name:     glk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */