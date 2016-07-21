import android.app.Activity;
import android.content.Context;

final class zl
  extends acr
  implements zm
{
  private final Activity c;
  
  public zl(Activity paramActivity, Context paramContext)
  {
    super(paramContext);
    c = paramActivity;
  }
  
  public final void a(float paramFloat)
  {
    if (paramFloat == 1.0F) {
      a(true);
    }
    for (;;)
    {
      b(paramFloat);
      return;
      if (paramFloat == 0.0F) {
        a(false);
      }
    }
  }
}

/* Location:
 * Qualified Name:     zl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */