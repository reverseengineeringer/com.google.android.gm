import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public final class apn
  extends View
{
  public boolean a;
  int b;
  int c;
  public float d;
  public float e;
  public boolean f;
  private final Paint g = new Paint();
  private boolean h;
  private int i;
  private int j;
  private int k;
  
  public apn(Context paramContext)
  {
    super(paramContext);
    paramContext = paramContext.getResources();
    b = paramContext.getColor(17170443);
    c = paramContext.getColor(aog.l);
    g.setAntiAlias(true);
    f = false;
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    if ((getWidth() == 0) || (!f)) {
      return;
    }
    if (!h)
    {
      i = (getWidth() / 2);
      j = (getHeight() / 2);
      k = ((int)(Math.min(i, j) * d));
      if (!a)
      {
        int m = (int)(k * e);
        j -= m / 2;
      }
      h = true;
    }
    g.setColor(b);
    paramCanvas.drawCircle(i, j, k, g);
    g.setColor(c);
    paramCanvas.drawCircle(i, j, 2.0F, g);
  }
}

/* Location:
 * Qualified Name:     apn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */