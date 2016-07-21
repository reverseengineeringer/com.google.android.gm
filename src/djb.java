import com.android.mail.providers.Attachment;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import java.util.Iterator;
import java.util.List;

final class djb
  implements bvw
{
  djb(diz paramdiz, djf paramdjf, List paramList) {}
  
  public final void a()
  {
    djj localdjj = new djj(c.d, a);
    Object localObject1 = b;
    eiz localeiz = a.f;
    localObject1 = ((List)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      djn localdjn = (djn)((Iterator)localObject1).next();
      Object localObject2 = new fba().c(a.c).b(a.l());
      Object localObject3 = dje.a;
      enz.a(localObject3, "key");
      enz.a("1", "value");
      int i = fba.a(b);
      i = fba.a("1") + i;
      if (i <= 124) {}
      for (boolean bool = true;; bool = false)
      {
        enz.b(bool, String.format("%s must be no more than %d bytes, but is %d bytes.", new Object[] { "The total size of key string and value string of a custom property", Integer.valueOf(124), Integer.valueOf(i) }));
        ((fba)localObject2).a().a((CustomPropertyKey)localObject3, "1");
        localObject2 = ((fba)localObject2).b();
        localObject3 = new fax();
        a = true;
        localObject3 = ((fax)localObject3).a(b).a();
        fae.h.b(localeiz).a(localeiz, (faz)localObject2, null, (faw)localObject3).a(new djm(localdjj, localdjn));
        break;
      }
    }
  }
  
  public final void b() {}
}

/* Location:
 * Qualified Name:     djb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */