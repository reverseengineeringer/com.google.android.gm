import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.animation.Interpolator;

public final class aa
{
  private static final boolean D;
  private static final Paint E;
  public float A;
  public float B;
  public int C;
  private final RectF F;
  private int G = 16;
  private float H;
  private float I;
  private float J;
  private float K;
  private Typeface L;
  private boolean M;
  private float N;
  private float O;
  private float P;
  private float Q;
  private float R;
  private int S;
  public final View a;
  public boolean b;
  public float c;
  public final Rect d;
  public final Rect e;
  public int f = 16;
  public float g = 15.0F;
  public float h = 15.0F;
  public int i;
  public int j;
  public float k;
  public float l;
  public Typeface m;
  public Typeface n;
  public CharSequence o;
  public CharSequence p;
  public boolean q;
  public Bitmap r;
  public Paint s;
  public float t;
  public float u;
  public boolean v;
  public final TextPaint w;
  public Interpolator x;
  public Interpolator y;
  public float z;
  
  static
  {
    if (Build.VERSION.SDK_INT < 18) {}
    for (boolean bool = true;; bool = false)
    {
      D = bool;
      E = null;
      return;
    }
  }
  
  public aa(View paramView)
  {
    a = paramView;
    w = new TextPaint(129);
    e = new Rect();
    d = new Rect();
    F = new RectF();
  }
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3, Interpolator paramInterpolator)
  {
    float f1 = paramFloat3;
    if (paramInterpolator != null) {
      f1 = paramInterpolator.getInterpolation(paramFloat3);
    }
    return p.a(paramFloat1, paramFloat2, f1);
  }
  
  private static int a(int paramInt1, int paramInt2, float paramFloat)
  {
    float f1 = 1.0F - paramFloat;
    float f2 = Color.alpha(paramInt1);
    float f3 = Color.alpha(paramInt2);
    float f4 = Color.red(paramInt1);
    float f5 = Color.red(paramInt2);
    float f6 = Color.green(paramInt1);
    float f7 = Color.green(paramInt2);
    float f8 = Color.blue(paramInt1);
    float f9 = Color.blue(paramInt2);
    return Color.argb((int)(f2 * f1 + f3 * paramFloat), (int)(f4 * f1 + f5 * paramFloat), (int)(f6 * f1 + f7 * paramFloat), (int)(f1 * f8 + f9 * paramFloat));
  }
  
  private static boolean a(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) < 0.001F;
  }
  
  public static boolean a(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (left == paramInt1) && (top == paramInt2) && (right == paramInt3) && (bottom == paramInt4);
  }
  
  private final void b(float paramFloat)
  {
    F.left = a(d.left, e.left, paramFloat, x);
    F.top = a(H, I, paramFloat, x);
    F.right = a(d.right, e.right, paramFloat, x);
    F.bottom = a(d.bottom, e.bottom, paramFloat, x);
    k = a(J, K, paramFloat, x);
    l = a(H, I, paramFloat, x);
    c(a(g, h, paramFloat, y));
    if (j != i) {
      w.setColor(a(i, j, paramFloat));
    }
    for (;;)
    {
      w.setShadowLayer(a(P, z, paramFloat, null), a(Q, A, paramFloat, null), a(R, B, paramFloat, null), a(S, C, paramFloat));
      rg.c(a);
      return;
      w.setColor(j);
    }
  }
  
  private final void c(float paramFloat)
  {
    d(paramFloat);
    boolean bool;
    if ((D) && (u != 1.0F))
    {
      bool = true;
      q = bool;
      if ((q) && (r == null) && (!d.isEmpty()) && (!TextUtils.isEmpty(p))) {
        break label77;
      }
    }
    for (;;)
    {
      rg.c(a);
      return;
      bool = false;
      break;
      label77:
      b(0.0F);
      t = w.ascent();
      N = w.descent();
      int i1 = Math.round(w.measureText(p, 0, p.length()));
      int i2 = Math.round(N - t);
      if ((i1 > 0) && (i2 > 0))
      {
        r = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_8888);
        new Canvas(r).drawText(p, 0, p.length(), 0.0F, i2 - w.descent(), w);
        if (s == null) {
          s = new Paint(3);
        }
      }
    }
  }
  
  private final void d()
  {
    b(c);
  }
  
  private final void d(float paramFloat)
  {
    int i3 = 1;
    if (o == null) {
      return;
    }
    float f1;
    int i1;
    if (a(paramFloat, h))
    {
      f1 = e.width();
      paramFloat = h;
      u = 1.0F;
      if (L == m) {
        break label362;
      }
      L = m;
      i1 = 1;
    }
    for (;;)
    {
      int i2 = i1;
      label97:
      Object localObject;
      boolean bool;
      label164:
      label227:
      label237:
      float f2;
      if (f1 > 0.0F)
      {
        if ((O != paramFloat) || (v) || (i1 != 0))
        {
          i1 = 1;
          O = paramFloat;
          v = false;
          i2 = i1;
        }
      }
      else
      {
        if ((p != null) && (i2 == 0)) {
          break;
        }
        w.setTextSize(O);
        w.setTypeface(L);
        localObject = w;
        if (u == 1.0F) {
          break label336;
        }
        bool = true;
        ((TextPaint)localObject).setLinearText(bool);
        localObject = TextUtils.ellipsize(o, w, f1, TextUtils.TruncateAt.END);
        if (TextUtils.equals((CharSequence)localObject, p)) {
          break;
        }
        p = ((CharSequence)localObject);
        CharSequence localCharSequence = p;
        if (rg.g(a) != 1) {
          break label342;
        }
        i1 = i3;
        if (i1 == 0) {
          break label348;
        }
        localObject = ni.d;
        M = ((nh)localObject).a(localCharSequence, localCharSequence.length());
        return;
        f1 = d.width();
        f2 = g;
        if (L == n) {
          break label356;
        }
        L = n;
      }
      label336:
      label342:
      label348:
      label356:
      for (i1 = 1;; i1 = 0)
      {
        if (a(paramFloat, g))
        {
          u = 1.0F;
          paramFloat = f2;
          break;
        }
        u = (paramFloat / g);
        paramFloat = f2;
        break;
        i1 = 0;
        break label97;
        bool = false;
        break label164;
        i1 = 0;
        break label227;
        localObject = ni.c;
        break label237;
      }
      label362:
      i1 = 0;
    }
  }
  
  public final void a()
  {
    if ((e.width() > 0) && (e.height() > 0) && (d.width() > 0) && (d.height() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      return;
    }
  }
  
  public final void a(float paramFloat)
  {
    float f1;
    if (paramFloat < 0.0F) {
      f1 = 0.0F;
    }
    for (;;)
    {
      if (f1 != c)
      {
        c = f1;
        d();
      }
      return;
      f1 = paramFloat;
      if (paramFloat > 1.0F) {
        f1 = 1.0F;
      }
    }
  }
  
  public final void a(int paramInt)
  {
    if (j != paramInt)
    {
      j = paramInt;
      b();
    }
  }
  
  public final void b()
  {
    int i2 = 1;
    float f2 = 0.0F;
    float f3;
    float f1;
    int i1;
    if ((a.getHeight() > 0) && (a.getWidth() > 0))
    {
      f3 = O;
      d(h);
      if (p == null) {
        break label402;
      }
      f1 = w.measureText(p, 0, p.length());
      int i3 = G;
      if (!M) {
        break label407;
      }
      i1 = 1;
      label83:
      i1 = pg.a(i3, i1);
      switch (i1 & 0x70)
      {
      default: 
        I = ((w.descent() - w.ascent()) / 2.0F - w.descent() + e.centerY());
        label162:
        switch (i1 & 0x800007)
        {
        default: 
          K = e.left;
          label208:
          d(g);
          f1 = f2;
          if (p != null) {
            f1 = w.measureText(p, 0, p.length());
          }
          i3 = f;
          if (M)
          {
            i1 = i2;
            label264:
            i1 = pg.a(i3, i1);
            switch (i1 & 0x70)
            {
            default: 
              H = ((w.descent() - w.ascent()) / 2.0F - w.descent() + d.centerY());
              label342:
              switch (i1 & 0x800007)
              {
              default: 
                J = d.left;
              }
              break;
            }
          }
          break;
        }
        break;
      }
    }
    for (;;)
    {
      c();
      c(f3);
      d();
      return;
      label402:
      f1 = 0.0F;
      break;
      label407:
      i1 = 0;
      break label83;
      I = e.bottom;
      break label162;
      I = (e.top - w.ascent());
      break label162;
      K = (e.centerX() - f1 / 2.0F);
      break label208;
      K = (e.right - f1);
      break label208;
      i1 = 0;
      break label264;
      H = d.bottom;
      break label342;
      H = (d.top - w.ascent());
      break label342;
      J = (d.centerX() - f1 / 2.0F);
      continue;
      J = (d.right - f1);
    }
  }
  
  public final void b(int paramInt)
  {
    if (G != paramInt)
    {
      G = paramInt;
      b();
    }
  }
  
  public final Typeface c(int paramInt)
  {
    TypedArray localTypedArray = a.getContext().obtainStyledAttributes(paramInt, new int[] { 16843692 });
    try
    {
      Object localObject1 = localTypedArray.getString(0);
      if (localObject1 != null)
      {
        localObject1 = Typeface.create((String)localObject1, 0);
        return (Typeface)localObject1;
      }
      return null;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }
  
  public final void c()
  {
    if (r != null)
    {
      r.recycle();
      r = null;
    }
  }
}

/* Location:
 * Qualified Name:     aa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */