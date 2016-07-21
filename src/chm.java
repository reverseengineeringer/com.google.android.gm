import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

public final class chm
  extends ClickableSpan
{
  private final bxw a;
  
  public chm(bxw parambxw)
  {
    a = parambxw;
  }
  
  public final void onClick(View paramView)
  {
    if (a != null) {
      a.s_();
    }
  }
  
  public final void updateDrawState(TextPaint paramTextPaint) {}
}

/* Location:
 * Qualified Name:     chm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */