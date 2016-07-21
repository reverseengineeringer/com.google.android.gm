import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import com.android.mail.providers.Folder;

public final class csn
  extends csr
{
  private final cfm d;
  private boolean e;
  
  public csn(Context paramContext)
  {
    super(paramContext);
    d = cfm.a(paramContext);
    a(getResources().getString(buj.aK));
  }
  
  private final boolean u()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (d.e())
    {
      bool1 = bool2;
      if (!c.isEmpty())
      {
        bool1 = bool2;
        if (!d.d.getBoolean("conversation-photo-teaser-shown-three", false)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final void a(Folder paramFolder, bwg parambwg)
  {
    e = u();
  }
  
  public final void g()
  {
    if (e) {
      i();
    }
  }
  
  public final void i()
  {
    if (e)
    {
      d.e.putBoolean("conversation-photo-teaser-shown-three", true).apply();
      e = false;
      buo.a().a("list_swipe", "photo_teaser", null, 0L);
    }
    super.i();
  }
  
  public final boolean n()
  {
    e = u();
    return e;
  }
  
  public final boolean o()
  {
    return false;
  }
  
  protected final css p()
  {
    return new css(bub.p, bub.d);
  }
}

/* Location:
 * Qualified Name:     csn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */