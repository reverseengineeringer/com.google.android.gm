import android.util.Log;
import android.widget.ImageView;

final class fsd
  extends fsj
{
  public final int a;
  public final String b;
  public final fyb c;
  
  public fsd(fsc paramfsc, ImageView paramImageView, fyb paramfyb, int paramInt)
  {
    super(paramfsc);
    boolean bool = fto.a(paramfyb);
    f = paramImageView;
    c = paramfyb;
    if (bool) {}
    for (paramfsc = paramfyb.b();; paramfsc = null)
    {
      g = paramfsc;
      paramfsc = (fsc)localObject;
      if (bool) {
        paramfsc = paramfyb.d();
      }
      b = paramfsc;
      a = paramInt;
      if (!bool) {
        Log.w("AvatarManager", "OwnerAvatarRequest: Owner not valid -- account name andpage id will be null");
      }
      return;
    }
  }
  
  public final void a()
  {
    frm.g.a(d.c, g, b, a, 1).a(new fse(this));
  }
}

/* Location:
 * Qualified Name:     fsd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */