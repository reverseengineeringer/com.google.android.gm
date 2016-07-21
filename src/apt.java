import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;

public final class apt
  extends View
{
  private float[] A;
  private float B;
  private float C;
  private float D;
  private apu E;
  ObjectAnimator a;
  ObjectAnimator b;
  private final Paint c = new Paint();
  private boolean d;
  private boolean e = false;
  private Typeface f;
  private Typeface g;
  private String[] h;
  private String[] i;
  private boolean j;
  private boolean k;
  private float l;
  private float m;
  private float n;
  private float o;
  private float p;
  private float q;
  private int r;
  private int s;
  private float t;
  private boolean u;
  private float v;
  private float w;
  private float[] x;
  private float[] y;
  private float[] z;
  
  public apt(Context paramContext)
  {
    super(paramContext);
  }
  
  private final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float f1 = (float)Math.sqrt(3.0D) * paramFloat1 / 2.0F;
    float f2 = paramFloat1 / 2.0F;
    c.setTextSize(paramFloat4);
    paramFloat3 -= (c.descent() + c.ascent()) / 2.0F;
    paramArrayOfFloat1[0] = (paramFloat3 - paramFloat1);
    paramArrayOfFloat2[0] = (paramFloat2 - paramFloat1);
    paramArrayOfFloat1[1] = (paramFloat3 - f1);
    paramArrayOfFloat2[1] = (paramFloat2 - f1);
    paramArrayOfFloat1[2] = (paramFloat3 - f2);
    paramArrayOfFloat2[2] = (paramFloat2 - f2);
    paramArrayOfFloat1[3] = paramFloat3;
    paramArrayOfFloat2[3] = paramFloat2;
    paramArrayOfFloat1[4] = (paramFloat3 + f2);
    paramArrayOfFloat2[4] = (f2 + paramFloat2);
    paramArrayOfFloat1[5] = (paramFloat3 + f1);
    paramArrayOfFloat2[5] = (f1 + paramFloat2);
    paramArrayOfFloat1[6] = (paramFloat3 + paramFloat1);
    paramArrayOfFloat2[6] = (paramFloat2 + paramFloat1);
  }
  
  private final void a(Canvas paramCanvas, float paramFloat, Typeface paramTypeface, String[] paramArrayOfString, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    c.setTextSize(paramFloat);
    c.setTypeface(paramTypeface);
    paramCanvas.drawText(paramArrayOfString[0], paramArrayOfFloat1[3], paramArrayOfFloat2[0], c);
    paramCanvas.drawText(paramArrayOfString[1], paramArrayOfFloat1[4], paramArrayOfFloat2[1], c);
    paramCanvas.drawText(paramArrayOfString[2], paramArrayOfFloat1[5], paramArrayOfFloat2[2], c);
    paramCanvas.drawText(paramArrayOfString[3], paramArrayOfFloat1[6], paramArrayOfFloat2[3], c);
    paramCanvas.drawText(paramArrayOfString[4], paramArrayOfFloat1[5], paramArrayOfFloat2[4], c);
    paramCanvas.drawText(paramArrayOfString[5], paramArrayOfFloat1[4], paramArrayOfFloat2[5], c);
    paramCanvas.drawText(paramArrayOfString[6], paramArrayOfFloat1[3], paramArrayOfFloat2[6], c);
    paramCanvas.drawText(paramArrayOfString[7], paramArrayOfFloat1[2], paramArrayOfFloat2[5], c);
    paramCanvas.drawText(paramArrayOfString[8], paramArrayOfFloat1[1], paramArrayOfFloat2[4], c);
    paramCanvas.drawText(paramArrayOfString[9], paramArrayOfFloat1[0], paramArrayOfFloat2[3], c);
    paramCanvas.drawText(paramArrayOfString[10], paramArrayOfFloat1[1], paramArrayOfFloat2[2], c);
    paramCanvas.drawText(paramArrayOfString[11], paramArrayOfFloat1[2], paramArrayOfFloat2[1], c);
  }
  
  public final ObjectAnimator a()
  {
    if ((!e) || (!d) || (a == null))
    {
      Log.e("RadialTextsView", "RadialTextView was not ready for animation.");
      return null;
    }
    return a;
  }
  
  final void a(Context paramContext, boolean paramBoolean)
  {
    paramContext = paramContext.getResources();
    if (paramBoolean) {}
    for (int i1 = paramContext.getColor(17170443);; i1 = paramContext.getColor(aog.l))
    {
      c.setColor(i1);
      return;
    }
  }
  
  public final void a(Resources paramResources, String[] paramArrayOfString1, String[] paramArrayOfString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = -1;
    boolean bool = false;
    if (e)
    {
      Log.e("RadialTextsView", "This RadialTextsView may only be initialized once.");
      return;
    }
    int i1 = paramResources.getColor(aog.l);
    c.setColor(i1);
    f = Typeface.create(paramResources.getString(aol.m), 0);
    g = Typeface.create(paramResources.getString(aol.n), 0);
    c.setAntiAlias(true);
    c.setTextAlign(Paint.Align.CENTER);
    h = paramArrayOfString1;
    i = paramArrayOfString2;
    j = paramBoolean1;
    if (paramArrayOfString2 != null) {
      bool = true;
    }
    k = bool;
    if (paramBoolean1)
    {
      l = Float.parseFloat(paramResources.getString(aol.c));
      x = new float[7];
      y = new float[7];
      if (!k) {
        break label334;
      }
      n = Float.parseFloat(paramResources.getString(aol.l));
      p = Float.parseFloat(paramResources.getString(aol.v));
      o = Float.parseFloat(paramResources.getString(aol.j));
      q = Float.parseFloat(paramResources.getString(aol.t));
      z = new float[7];
      A = new float[7];
      label231:
      B = 1.0F;
      if (!paramBoolean2) {
        break label365;
      }
    }
    label334:
    label365:
    for (i1 = -1;; i1 = 1)
    {
      C = (i1 * 0.05F + 1.0F);
      i1 = i2;
      if (paramBoolean2) {
        i1 = 1;
      }
      D = (0.3F * i1 + 1.0F);
      E = new apu(this);
      u = true;
      e = true;
      return;
      l = Float.parseFloat(paramResources.getString(aol.b));
      m = Float.parseFloat(paramResources.getString(aol.a));
      break;
      n = Float.parseFloat(paramResources.getString(aol.k));
      p = Float.parseFloat(paramResources.getString(aol.u));
      break label231;
    }
  }
  
  public final ObjectAnimator b()
  {
    if ((!e) || (!d) || (b == null))
    {
      Log.e("RadialTextsView", "RadialTextView was not ready for animation.");
      return null;
    }
    return b;
  }
  
  public final boolean hasOverlappingRendering()
  {
    return false;
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    if ((getWidth() == 0) || (!e)) {}
    do
    {
      return;
      float f1;
      float f2;
      if (!d)
      {
        r = (getWidth() / 2);
        s = (getHeight() / 2);
        t = (Math.min(r, s) * l);
        if (!j)
        {
          f1 = t;
          f2 = m;
          s = ((int)(s - f1 * f2 / 2.0F));
        }
        v = (t * p);
        if (k) {
          w = (t * q);
        }
        a = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("animationRadiusMultiplier", new Keyframe[] { Keyframe.ofFloat(0.0F, 1.0F), Keyframe.ofFloat(0.2F, C), Keyframe.ofFloat(1.0F, D) }), PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { Keyframe.ofFloat(0.0F, 1.0F), Keyframe.ofFloat(1.0F, 0.0F) }) }).setDuration(500L);
        a.addUpdateListener(E);
        b = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("animationRadiusMultiplier", new Keyframe[] { Keyframe.ofFloat(0.0F, D), Keyframe.ofFloat(0.2F, D), Keyframe.ofFloat(0.84F, C), Keyframe.ofFloat(1.0F, 1.0F) }), PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.2F, 0.0F), Keyframe.ofFloat(1.0F, 1.0F) }) }).setDuration(625L);
        b.addUpdateListener(E);
        u = true;
        d = true;
      }
      if (u)
      {
        f1 = t;
        f2 = n;
        a(B * (f1 * f2), r, s, v, x, y);
        if (k)
        {
          f1 = t;
          f2 = o;
          a(B * (f1 * f2), r, s, w, z, A);
        }
        u = false;
      }
      a(paramCanvas, v, f, h, y, x);
    } while (!k);
    a(paramCanvas, w, g, i, A, z);
  }
}

/* Location:
 * Qualified Name:     apt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */