import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public final class apm
  extends View
{
  public final Paint a = new Paint();
  public int b;
  public int c;
  public int d;
  public int e;
  public float f;
  public float g;
  public String h;
  public String i;
  public boolean j = false;
  public int k;
  public int l;
  private boolean m;
  private int n;
  private int o;
  private int p;
  private int q;
  
  public apm(Context paramContext)
  {
    super(paramContext);
  }
  
  public final int a(float paramFloat1, float paramFloat2)
  {
    if (!m) {}
    int i1;
    float f1;
    do
    {
      return -1;
      i1 = (int)((paramFloat2 - q) * (paramFloat2 - q));
      if ((int)Math.sqrt((paramFloat1 - o) * (paramFloat1 - o) + i1) <= n) {
        return 0;
      }
      paramFloat2 = p;
      f1 = p;
    } while ((int)Math.sqrt(i1 + (paramFloat1 - paramFloat2) * (paramFloat1 - f1)) > n);
    return 1;
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    int i2 = 255;
    if ((getWidth() == 0) || (!j)) {
      return;
    }
    int i1;
    int i5;
    if (!m)
    {
      i1 = getWidth() / 2;
      i3 = getHeight() / 2;
      i4 = (int)(Math.min(i1, i3) * f);
      n = ((int)(i4 * g));
      i5 = n * 3 / 4;
      a.setTextSize(i5);
      q = (i3 - n / 2 + i4);
      o = (i1 - i4 + n);
      p = (i1 + i4 - n);
      m = true;
    }
    int i4 = c;
    int i3 = c;
    if (k == 0)
    {
      i4 = e;
      i1 = b;
    }
    for (;;)
    {
      int i6;
      if (l == 0)
      {
        i5 = e;
        i6 = b;
      }
      for (;;)
      {
        a.setColor(i5);
        a.setAlpha(i6);
        paramCanvas.drawCircle(o, q, n, a);
        a.setColor(i3);
        a.setAlpha(i2);
        paramCanvas.drawCircle(p, q, n, a);
        a.setColor(d);
        i1 = q - (int)(a.descent() + a.ascent()) / 2;
        paramCanvas.drawText(h, o, i1, a);
        paramCanvas.drawText(i, p, i1, a);
        return;
        if (k != 1) {
          break label402;
        }
        i3 = e;
        i2 = b;
        i1 = 255;
        break;
        i6 = i1;
        i5 = i4;
        if (l == 1)
        {
          i3 = e;
          i2 = b;
          i6 = i1;
          i5 = i4;
        }
      }
      label402:
      i1 = 255;
    }
  }
}

/* Location:
 * Qualified Name:     apm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */