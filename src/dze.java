import com.android.mail.providers.Account;
import com.google.android.gm.vacation.GmailVacationResponderActivity;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public final class dze
  implements Runnable
{
  public dze(GmailVacationResponderActivity paramGmailVacationResponderActivity) {}
  
  public final void run()
  {
    Object localObject1 = a.s;
    dvf localdvf = a.t;
    Object localObject2 = a.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      h.a((String)localEntry.getKey(), (String)localEntry.getValue(), true);
    }
    localObject1 = h;
    localObject2 = (String)a.get("lx_vst");
    c.a("lx_vst", (String)localObject2);
    a.clear();
    drp.a(a.r.c).k();
  }
}

/* Location:
 * Qualified Name:     dze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */