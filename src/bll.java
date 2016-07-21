import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class bll
{
  public Integer a;
  public String b;
  public String c;
  public String d;
  public String[] e;
  public String f;
  public String g;
  public Float h;
  public boolean i;
  private final Intent j;
  private boolean k;
  private boolean l;
  private boolean m;
  private int n;
  private int o;
  private int p;
  private int q;
  private boolean r;
  
  public bll(Context paramContext, Class<?> paramClass)
  {
    j = new Intent(paramContext, paramClass);
    b();
  }
  
  bll(Context paramContext, String paramString)
  {
    j = new Intent();
    j.setClassName(paramContext, paramString);
    b();
  }
  
  private final void b()
  {
    m = false;
    r = false;
    i = false;
    k = true;
  }
  
  public final Intent a()
  {
    j.setAction("android.intent.action.VIEW");
    j.setFlags(67633152);
    if (a != null) {
      j.putExtra("photo_index", a.intValue());
    }
    if (b != null) {
      j.putExtra("initial_photo_uri", b);
    }
    if ((b != null) && (a != null)) {
      throw new IllegalStateException("specified both photo index and photo uri");
    }
    if (c != null)
    {
      j.putExtra("photos_uri", c);
      j.setData(Uri.parse(c));
    }
    if (d != null) {
      j.putExtra("resolved_photo_uri", d);
    }
    if (e != null) {
      j.putExtra("projection", e);
    }
    if (f != null) {
      j.putExtra("thumbnail_uri", f);
    }
    if (g != null) {
      j.putExtra("content_description", g);
    }
    if (h != null) {
      j.putExtra("max_scale", h);
    }
    j.putExtra("watch_network", l);
    j.putExtra("scale_up_animation", m);
    if (m)
    {
      j.putExtra("start_x_extra", n);
      j.putExtra("start_y_extra", o);
      j.putExtra("start_width_extra", p);
      j.putExtra("start_height_extra", q);
    }
    j.putExtra("action_bar_hidden_initially", r);
    j.putExtra("display_thumbs_fullscreen", i);
    j.putExtra("enable_timer_lights_out", k);
    return j;
  }
}

/* Location:
 * Qualified Name:     bll
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */