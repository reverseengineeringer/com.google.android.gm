import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

public final class api
  extends apc
{
  public api(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (A == paramInt3) {
      paramCanvas.drawCircle(paramInt4, paramInt5 - a / 3, e, l);
    }
    if (a(paramInt1, paramInt2, paramInt3)) {
      i.setColor(O);
    }
    for (;;)
    {
      paramCanvas.drawText(String.format("%d", new Object[] { Integer.valueOf(paramInt3) }), paramInt4, paramInt5, i);
      return;
      if ((z) && (B == paramInt3)) {
        i.setColor(N);
      } else {
        i.setColor(M);
      }
    }
  }
}

/* Location:
 * Qualified Name:     api
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */