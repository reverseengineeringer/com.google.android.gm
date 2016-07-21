import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;

public final class cyc
  extends ClickableSpan
{
  private static final Typeface a = Typeface.create("sans-serif-medium", 0);
  private final String b;
  
  public cyc(String paramString)
  {
    b = paramString;
  }
  
  public final void onClick(View paramView)
  {
    if ((paramView.getContext() instanceof cyd))
    {
      if (Build.VERSION.SDK_INT >= 19) {
        paramView.cancelPendingInputEvents();
      }
      return;
    }
    Log.w("LinkSpan", "Dropping click event. No listener attached.");
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setTypeface(a);
  }
}

/* Location:
 * Qualified Name:     cyc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */