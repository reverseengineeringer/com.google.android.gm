import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class bz
{
  final ArrayList<cb> a = new ArrayList();
  cb b = null;
  Animation c = null;
  WeakReference<View> d;
  private Animation.AnimationListener e = new ca(this);
  
  final View a()
  {
    if (d == null) {
      return null;
    }
    return (View)d.get();
  }
  
  public final void a(int[] paramArrayOfInt, Animation paramAnimation)
  {
    paramArrayOfInt = new cb(paramArrayOfInt, paramAnimation);
    paramAnimation.setAnimationListener(e);
    a.add(paramArrayOfInt);
  }
}

/* Location:
 * Qualified Name:     bz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */