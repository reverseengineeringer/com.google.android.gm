import android.animation.Animator;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import java.util.ArrayList;

final class dm
  extends Drawable.ConstantState
{
  int a;
  dt b;
  ArrayList<Animator> c;
  ns<Animator, String> d;
  
  public dm(dm paramdm, Drawable.Callback paramCallback, Resources paramResources) {}
  
  public final int getChangingConfigurations()
  {
    return a;
  }
  
  public final Drawable newDrawable()
  {
    throw new IllegalStateException("No constant state support for SDK < 23.");
  }
  
  public final Drawable newDrawable(Resources paramResources)
  {
    throw new IllegalStateException("No constant state support for SDK < 23.");
  }
}

/* Location:
 * Qualified Name:     dm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */