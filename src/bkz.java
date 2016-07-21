import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.util.Log;

public final class bkz
  extends ShapeDrawable
{
  static boolean b = false;
  int a;
  private Spannable c;
  
  public final void draw(Canvas paramCanvas)
  {
    Object localObject1 = c;
    Object localObject2 = (bla[])((Spannable)localObject1).getSpans(0, ((Spannable)localObject1).length(), bla.class);
    int i;
    if (localObject2.length > 0)
    {
      int j = localObject2.length;
      i = 0;
      if (i < j)
      {
        localObject1 = localObject2[i];
        if (((bla)localObject1).getDrawable() != this) {}
      }
    }
    for (;;)
    {
      localObject2 = c;
      localObject1 = (ForegroundColorSpan[])((Spannable)localObject2).getSpans(((Spannable)localObject2).getSpanStart(localObject1), ((Spannable)localObject2).getSpanEnd(localObject1), ForegroundColorSpan.class);
      if (b)
      {
        i = localObject1.length;
        new StringBuilder(26).append("--- renewColor:").append(i);
      }
      if (localObject1.length > 0)
      {
        i = localObject1[(localObject1.length - 1)].getForegroundColor();
        if (b) {
          new StringBuilder(26).append("--- renewColor:").append(i);
        }
        getPaint().setColor(i);
      }
      paramCanvas.drawRect(new Rect(0, 9, a, 11), getPaint());
      return;
      i += 1;
      break;
      Log.e("EditStyledTextSpan", "---renewBounds: Couldn't find");
      localObject1 = null;
    }
  }
}

/* Location:
 * Qualified Name:     bkz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */