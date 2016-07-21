import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import com.android.mail.browse.SubjectAndFolderView;

public final class bzx
  extends ReplacementSpan
{
  public bzx(SubjectAndFolderView paramSubjectAndFolderView) {}
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCanvas.save();
    paramCanvas.translate(paramFloat, a.g + paramInt4 - a.d.getIntrinsicHeight());
    a.d.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public final int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    return a.d.getIntrinsicWidth();
  }
}

/* Location:
 * Qualified Name:     bzx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */