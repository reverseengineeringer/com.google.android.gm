import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;

public final class chp
  extends ClickableSpan
{
  final View.OnClickListener a;
  
  public chp(View.OnClickListener paramOnClickListener)
  {
    a = paramOnClickListener;
  }
  
  public final void onClick(View paramView)
  {
    if (a != null) {
      a.onClick(paramView);
    }
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(linkColor);
    paramTextPaint.setUnderlineText(false);
  }
}

/* Location:
 * Qualified Name:     chp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */