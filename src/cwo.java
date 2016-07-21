import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Interpolator;
import com.google.android.apps.work.common.richedittext.RichTextToolbar;

public final class cwo
{
  private static final Interpolator a = new vs();
  private static final Interpolator b = new vq();
  
  public static void a(RichTextToolbar paramRichTextToolbar)
  {
    int i = View.MeasureSpec.makeMeasureSpec(0, 0);
    paramRichTextToolbar.measure(i, i);
    Object localObject = paramRichTextToolbar.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams)) {}
    for (i = bottomMargin;; i = 0)
    {
      i += paramRichTextToolbar.getMeasuredHeight();
      localObject = ObjectAnimator.ofFloat(paramRichTextToolbar, View.TRANSLATION_Y, new float[] { i, 0.0F });
      ((ObjectAnimator)localObject).setDuration(300L);
      ((ObjectAnimator)localObject).setInterpolator(a);
      if (l != null) {
        l.removeAllListeners();
      }
      l = ((Animator)localObject);
      localObject = ObjectAnimator.ofFloat(paramRichTextToolbar, View.TRANSLATION_Y, new float[] { 0.0F, i });
      ((ObjectAnimator)localObject).setDuration(300L);
      ((ObjectAnimator)localObject).setInterpolator(b);
      if (m != null) {
        m.removeAllListeners();
      }
      m = ((Animator)localObject);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     cwo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */