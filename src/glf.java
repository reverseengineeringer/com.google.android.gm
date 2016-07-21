import android.app.Application;
import java.util.concurrent.ScheduledExecutorService;

final class glf
  implements gjz, gme
{
  final Application a;
  final gku b;
  private final gkb c;
  
  glf(Application paramApplication, gna paramgna, gks paramgks)
  {
    a = paramApplication;
    c = gkb.a(paramApplication);
    b = new glb(paramgna, paramgks, gla.a);
  }
  
  public final void a()
  {
    c.b(this);
    glr localglr = glr.c;
    glr.a().submit(new glg(this));
  }
  
  public final void b()
  {
    c.a(this);
  }
}

/* Location:
 * Qualified Name:     glf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */