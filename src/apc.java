import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.util.Log;
import android.util.StateSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.MeasureSpec;
import java.security.InvalidParameterException;
import java.util.Calendar;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Locale;

public abstract class apc
  extends View
{
  public int A = -1;
  public int B = -1;
  public int C = 1;
  public int D = 7;
  public int E = D;
  public int F = -1;
  public int G = -1;
  public boolean H;
  public final Calendar I;
  public final ape J;
  public int K = 6;
  public apf L;
  public int M;
  public int N;
  public int O;
  public int P;
  public int Q;
  public Runnable R;
  boolean S = false;
  private String T;
  private String U;
  private final Formatter V;
  private final StringBuilder W;
  public int a;
  private String aa;
  private final Calendar ab;
  private boolean ac;
  private boolean ad;
  private int ae = 0;
  public int b;
  public int c;
  public int d;
  public int e;
  public aos f;
  public int g = 0;
  public int h = 0;
  public Paint i;
  public Paint j;
  public Paint k;
  public Paint l;
  public Paint m;
  public Paint n;
  public Drawable o;
  public boolean p;
  public final Rect q = new Rect();
  public int r = -1;
  public int s = -1;
  public int t = -1;
  public int u;
  public int v;
  public int w;
  public int x;
  public int y = 32;
  public boolean z = false;
  
  public apc(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private apc(Context paramContext, byte paramByte)
  {
    super(paramContext, null);
    paramContext = paramContext.getResources();
    I = Calendar.getInstance();
    ab = Calendar.getInstance();
    T = paramContext.getString(aol.d);
    U = paramContext.getString(aol.n);
    M = paramContext.getColor(aog.f);
    N = paramContext.getColor(aog.b);
    O = paramContext.getColor(aog.e);
    P = paramContext.getColor(17170443);
    Q = paramContext.getColor(aog.c);
    W = new StringBuilder(50);
    V = new Formatter(W, Locale.getDefault());
    a = paramContext.getDimensionPixelSize(aoh.d);
    b = paramContext.getDimensionPixelSize(aoh.f);
    c = paramContext.getDimensionPixelSize(aoh.e);
    d = paramContext.getDimensionPixelOffset(aoh.g);
    e = paramContext.getDimensionPixelSize(aoh.c);
    x = paramContext.getDimensionPixelSize(aoh.b);
    y = ((paramContext.getDimensionPixelOffset(aoh.a) - d) / 6);
    J = new ape(this, this);
    rg.a(this, J);
    rg.c(this, 1);
    ac = true;
    paramContext = getContext();
    if ((Build.VERSION.SDK_INT >= 17) && (paramContext.getResources().getConfiguration().getLayoutDirection() == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      ad = bool;
      j = new Paint();
      j.setFakeBoldText(true);
      j.setAntiAlias(true);
      j.setTextSize(b);
      j.setTypeface(Typeface.create(U, 1));
      j.setColor(M);
      j.setTextAlign(Paint.Align.CENTER);
      j.setStyle(Paint.Style.FILL);
      k = new Paint();
      k.setFakeBoldText(true);
      k.setAntiAlias(true);
      k.setColor(Q);
      k.setTextAlign(Paint.Align.CENTER);
      k.setStyle(Paint.Style.FILL);
      l = new Paint();
      l.setFakeBoldText(true);
      l.setAntiAlias(true);
      l.setColor(N);
      l.setTextAlign(Paint.Align.CENTER);
      l.setStyle(Paint.Style.FILL);
      l.setAlpha(60);
      m = new Paint();
      m.setAntiAlias(true);
      m.setTextSize(c);
      m.setColor(M);
      m.setTypeface(Typeface.create(T, 0));
      m.setStyle(Paint.Style.FILL);
      m.setTextAlign(Paint.Align.CENTER);
      m.setFakeBoldText(true);
      i = new Paint();
      i.setAntiAlias(true);
      i.setTextSize(a);
      i.setStyle(Paint.Style.FILL);
      i.setTextAlign(Paint.Align.CENTER);
      i.setFakeBoldText(false);
      n = new Paint();
      n.setAntiAlias(true);
      n.setTextSize(a);
      n.setStyle(Paint.Style.FILL);
      n.setTextAlign(Paint.Align.CENTER);
      return;
    }
  }
  
  private final boolean d()
  {
    return (S) && (ad);
  }
  
  private final String e()
  {
    if (TextUtils.isEmpty(aa)) {
      return Time.getCurrentTimezone();
    }
    return aa;
  }
  
  private final int f()
  {
    int i1 = g();
    if (d()) {
      return i1 + g;
    }
    return g;
  }
  
  private final int g()
  {
    if (H) {
      return x + h;
    }
    return 0;
  }
  
  private final void h()
  {
    Drawable localDrawable;
    if (o != null)
    {
      localDrawable = o;
      if (!q.isEmpty()) {
        break label33;
      }
    }
    label33:
    for (int[] arrayOfInt = StateSet.NOTHING;; arrayOfInt = getDrawableState())
    {
      localDrawable.setState(arrayOfInt);
      return;
    }
  }
  
  protected final int a()
  {
    if (ae < C) {}
    for (int i1 = ae + D;; i1 = ae) {
      return i1 - C;
    }
  }
  
  public final int a(float paramFloat1, float paramFloat2)
  {
    int i1 = c();
    if ((paramFloat1 < i1) || (paramFloat1 > w - f())) {}
    int i2;
    for (i1 = -1;; i1 = a((int)((paramFloat1 - i1) * D / (w - i1 - f()))) - a() + 1 + i2 * D)
    {
      if (i1 > 0)
      {
        i2 = i1;
        if (i1 <= E) {}
      }
      else
      {
        i2 = -1;
      }
      return i2;
      i2 = (int)(paramFloat2 - d) / y;
    }
  }
  
  protected final int a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= D)) {
      Log.wtf("MonthView", String.format("Unexpected column index %d. Expected index in range of 0 <= x < %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(D) }));
    }
    int i1 = paramInt;
    if (d()) {
      i1 = D - 1 - paramInt;
    }
    return i1;
  }
  
  public abstract void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public final void a(HashMap<String, Integer> paramHashMap)
  {
    int i3 = 1;
    if ((!paramHashMap.containsKey("month")) && (!paramHashMap.containsKey("year"))) {
      throw new InvalidParameterException("You must specify month and year for this view");
    }
    setTag(paramHashMap);
    if (paramHashMap.containsKey("height"))
    {
      y = ((Integer)paramHashMap.get("height")).intValue();
      if (y < 10) {
        y = 10;
      }
    }
    if (paramHashMap.containsKey("selected_day")) {
      A = ((Integer)paramHashMap.get("selected_day")).intValue();
    }
    boolean bool;
    label278:
    label295:
    int i4;
    if ((paramHashMap.containsKey("show_wk_num")) && (((Integer)paramHashMap.get("show_wk_num")).intValue() != 0))
    {
      bool = true;
      H = bool;
      u = ((Integer)paramHashMap.get("month")).intValue();
      v = ((Integer)paramHashMap.get("year")).intValue();
      Time localTime = new Time(e());
      localTime.setToNow();
      z = false;
      B = -1;
      ab.set(2, u);
      ab.set(1, v);
      ab.set(5, 1);
      ae = ab.get(7);
      if (!paramHashMap.containsKey("week_start")) {
        break label372;
      }
      C = ((Integer)paramHashMap.get("week_start")).intValue();
      E = aom.a(u, v);
      i1 = 0;
      if (i1 >= E) {
        break label391;
      }
      i4 = i1 + 1;
      if ((v != year) || (u != month) || (i4 != monthDay)) {
        break label386;
      }
    }
    label372:
    label386:
    for (int i2 = 1;; i2 = 0)
    {
      if (i2 != 0)
      {
        z = true;
        B = i4;
      }
      i1 += 1;
      break label295;
      bool = false;
      break;
      C = ab.getFirstDayOfWeek();
      break label278;
    }
    label391:
    int i1 = a();
    i2 = (E + i1) / D;
    if ((i1 + E) % D > 0) {}
    for (i1 = i3;; i1 = 0)
    {
      K = (i2 + i1);
      J.a();
      return;
    }
  }
  
  protected final boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    Calendar localCalendar;
    int i1;
    if (f != null)
    {
      localCalendar = f.e();
      if (localCalendar != null) {
        if (paramInt1 < localCalendar.get(1))
        {
          i1 = 1;
          if (i1 == 0) {
            break label101;
          }
        }
      }
    }
    for (;;)
    {
      return true;
      if (paramInt1 <= localCalendar.get(1))
      {
        if (paramInt2 < localCalendar.get(2))
        {
          i1 = 1;
          break;
        }
        if ((paramInt2 <= localCalendar.get(2)) && (paramInt3 < localCalendar.get(5)))
        {
          i1 = 1;
          break;
        }
      }
      i1 = 0;
      break;
      label101:
      if (f != null)
      {
        localCalendar = f.f();
        if (localCalendar != null) {
          if (paramInt1 > localCalendar.get(1)) {
            paramInt1 = 1;
          }
        }
      }
      while (paramInt1 == 0)
      {
        return false;
        if (paramInt1 >= localCalendar.get(1))
        {
          if (paramInt2 > localCalendar.get(2))
          {
            paramInt1 = 1;
            continue;
          }
          if ((paramInt2 >= localCalendar.get(2)) && (paramInt3 > localCalendar.get(5)))
          {
            paramInt1 = 1;
            continue;
          }
        }
        paramInt1 = 0;
      }
    }
  }
  
  protected final int b()
  {
    return c() + f();
  }
  
  final void b(int paramInt)
  {
    if (a(v, u, paramInt)) {
      return;
    }
    if (L != null) {
      L.b(new apb(v, u, paramInt));
    }
    J.a(paramInt, 1);
  }
  
  protected final int c()
  {
    int i1 = g();
    if (d()) {
      return g;
    }
    return i1 + g;
  }
  
  public boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    if (J.a(paramMotionEvent)) {
      return true;
    }
    return super.dispatchHoverEvent(paramMotionEvent);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    h();
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if (o != null) {
      o.jumpToCurrentState();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (R != null)
    {
      getHandler().removeCallbacks(R);
      R = null;
    }
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i5 = 0;
    if (o != null) {
      o.draw(paramCanvas);
    }
    int i1 = (w + b()) / 2;
    int i2 = (d - c) / 2;
    int i3 = b / 3;
    W.setLength(0);
    long l1 = ab.getTimeInMillis();
    paramCanvas.drawText(DateUtils.formatDateRange(getContext(), V, l1, l1, 52, e()).toString(), i1, i2 + i3, j);
    i2 = d;
    i3 = c / 2;
    int i4 = (w - b()) / (D * 2);
    i1 = 0;
    int i6;
    int i7;
    int i8;
    while (i1 < D)
    {
      i6 = a(i1);
      i7 = C;
      i8 = D;
      int i9 = c();
      I.set(7, (i6 + i7) % i8);
      paramCanvas.drawText(I.getDisplayName(7, 1, Locale.getDefault()).toUpperCase(Locale.getDefault()), (i1 * 2 + 1) * i4 + i9, i2 - i3, m);
      i1 += 1;
    }
    i3 = (y + a) / 2 - 1 + d;
    float f1 = (w - b()) / (D * 2.0F);
    i1 = a();
    i2 = 1;
    while (i2 <= E)
    {
      i4 = (int)((a(i1) * 2 + 1) * f1 + c());
      a(paramCanvas, v, u, i2, i4, i3);
      i6 = i1 + 1;
      i1 = i6;
      i4 = i3;
      if (i6 == D)
      {
        i4 = i3 + y;
        i1 = 0;
      }
      i2 += 1;
      i3 = i4;
    }
    if (H)
    {
      i2 = (y + a) / 2 - 1 + d;
      i7 = (y + a) / 2 - 1;
      i1 = x;
      i8 = h + i1;
      if (d()) {}
      for (i3 = paramCanvas.getWidth() - g - i8;; i3 = g)
      {
        i1 = aom.b(r, aom.a(C));
        i4 = i5;
        for (;;)
        {
          i6 = i2;
          if (i4 >= K) {
            break;
          }
          if ((u != 11) || (i4 != K - 1))
          {
            i2 = i1;
            if (u == 0)
            {
              i2 = i1;
              if (i4 != 1) {}
            }
          }
          else
          {
            i2 = aom.b(r + i4 * 7, aom.a(C));
          }
          i5 = i6 + y;
          i1 = (i3 + i8 - i3) / 2;
          i6 = (i6 - i7 + (i6 + i7)) / 2;
          paramCanvas.drawText(String.valueOf(i2), i1 + i3, i6, n);
          i1 = i2 + 1;
          i4 += 1;
          i2 = i5;
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), y * K + d);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    w = paramInt1;
    J.a();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      paramMotionEvent = q;
      paramMotionEvent.setEmpty();
      int i2 = f();
      int i3 = c();
      int i1 = d;
      if ((f1 >= i3) && (f1 <= w - i2) && (f2 >= i1))
      {
        float f3 = (w - i3 - i2) / (D * 1.0F);
        float f4 = i3;
        i2 = (int)((int)((f1 - i3) / f3) * f3 + f4);
        i1 += (int)((f2 - i1) / y) * y;
        paramMotionEvent.set(i2, i1, (int)(f3 + i2), y + i1);
        if (o != null)
        {
          o.setBounds(paramMotionEvent);
          h();
          if (p)
          {
            o.setHotspot(f1, f2);
            continue;
            if (!q.isEmpty()) {
              if (!q.contains((int)f1, (int)f2))
              {
                q.setEmpty();
                h();
              }
              else if (p)
              {
                o.setHotspot(f1, f2);
                continue;
                if (!q.isEmpty()) {
                  if (!q.contains((int)f1, (int)f2))
                  {
                    q.setEmpty();
                    h();
                  }
                  else
                  {
                    i1 = a(paramMotionEvent.getX(), paramMotionEvent.getY());
                    if (i1 >= 0) {
                      if (p)
                      {
                        o.setHotspot(f1, f2);
                        R = new apd(this, i1);
                        postDelayed(R, 75L);
                      }
                      else
                      {
                        b(i1);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void setAccessibilityDelegate(View.AccessibilityDelegate paramAccessibilityDelegate)
  {
    if (!ac) {
      super.setAccessibilityDelegate(paramAccessibilityDelegate);
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (o == paramDrawable) || (super.verifyDrawable(paramDrawable));
  }
}

/* Location:
 * Qualified Name:     apc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */