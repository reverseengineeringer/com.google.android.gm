package com.android.ex.photo.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import bmg;
import bmh;
import bni;
import bnj;
import bnk;
import bnl;
import bnm;
import pb;
import pc;
import qw;
import qz;

public class PhotoView
  extends View
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener
{
  private static int t;
  private static boolean u;
  private static int v;
  private static Bitmap w;
  private static Bitmap x;
  private static Paint y;
  private static Paint z;
  private Matrix A;
  private Matrix B = new Matrix();
  private int C = -1;
  private boolean D;
  private byte[] E;
  private boolean F;
  private boolean G;
  private Rect H = new Rect();
  private int I;
  private boolean J = true;
  private boolean K;
  private boolean L;
  private RectF M = new RectF();
  private float N;
  private float O;
  private boolean P;
  public Drawable a;
  public Matrix b = new Matrix();
  public boolean c;
  public float d;
  public pb e;
  public ScaleGestureDetector f;
  public View.OnClickListener g;
  public boolean h;
  public bnk i;
  public float j;
  public float k;
  public bnm l;
  public bnl m;
  public bnj n;
  public float o;
  public RectF p = new RectF();
  public RectF q = new RectF();
  public float[] r = new float[9];
  public boolean s;
  
  public PhotoView(Context paramContext)
  {
    super(paramContext);
    e();
  }
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e();
  }
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e();
  }
  
  private final boolean a(MotionEvent paramMotionEvent)
  {
    float f5;
    float f3;
    float f1;
    float f2;
    boolean bool;
    if ((J) && (h) && (s)) {
      if (!K)
      {
        f5 = b();
        if (f5 > j)
        {
          f3 = j;
          f1 = f3 / f5;
          f2 = (getWidth() / 2 - q.centerX() * f1) / (1.0F - f1);
          f1 = (getHeight() / 2 - q.centerY() * f1) / (1.0F - f1);
          i.a(f5, f3, f2, f1);
          bool = true;
          label117:
          K = false;
        }
      }
    }
    for (;;)
    {
      s = false;
      return bool;
      f1 = Math.max(j, f5 * 2.0F);
      f3 = Math.min(k, f1);
      f2 = f3 / f5;
      f1 = (getWidth() - q.width()) / f2;
      f2 = (getHeight() - q.height()) / f2;
      if (q.width() <= f1 * 2.0F) {}
      for (f1 = q.centerX();; f1 = Math.min(Math.max(q.left + f1, paramMotionEvent.getX()), q.right - f1))
      {
        if (q.height() > f2 * 2.0F) {
          break label275;
        }
        f4 = q.centerY();
        f2 = f1;
        f1 = f4;
        break;
      }
      label275:
      float f4 = Math.min(Math.max(q.top + f2, paramMotionEvent.getY()), q.bottom - f2);
      f2 = f1;
      f1 = f4;
      break;
      bool = false;
      break label117;
      bool = false;
    }
  }
  
  private final int d()
  {
    if (I > 0) {
      return I;
    }
    return v;
  }
  
  private final void e()
  {
    Object localObject = getContext();
    if (!u)
    {
      u = true;
      Resources localResources = ((Context)localObject).getApplicationContext().getResources();
      v = localResources.getDimensionPixelSize(bmh.b);
      Paint localPaint = new Paint();
      y = localPaint;
      localPaint.setAntiAlias(true);
      y.setColor(localResources.getColor(bmg.a));
      y.setStyle(Paint.Style.FILL);
      localPaint = new Paint();
      z = localPaint;
      localPaint.setAntiAlias(true);
      z.setColor(localResources.getColor(bmg.b));
      z.setStyle(Paint.Style.STROKE);
      z.setStrokeWidth(localResources.getDimension(bmh.a));
      int i1 = ViewConfiguration.get((Context)localObject).getScaledTouchSlop();
      t = i1 * i1;
    }
    e = new pb((Context)localObject, this);
    f = new ScaleGestureDetector((Context)localObject, this);
    localObject = f;
    P = qw.a.a(localObject);
    i = new bnk(this);
    l = new bnm(this);
    m = new bnl(this);
    n = new bnj(this);
  }
  
  public final int a(float paramFloat1, float paramFloat2)
  {
    float f3 = 0.0F;
    q.set(p);
    b.mapRect(q);
    float f1;
    float f2;
    label59:
    float f4;
    float f5;
    label111:
    label149:
    label203:
    int i1;
    if (G)
    {
      f1 = H.left;
      if (!G) {
        break label254;
      }
      f2 = H.right;
      f4 = q.left;
      f5 = q.right;
      if (!G) {
        break label264;
      }
      f1 = Math.max(f1 - q.right, Math.min(f2 - q.left, paramFloat1));
      f2 = f3;
      if (G) {
        f2 = H.top;
      }
      if (!G) {
        break label315;
      }
      f3 = H.bottom;
      f4 = q.top;
      f5 = q.bottom;
      if (!G) {
        break label325;
      }
      f2 = Math.max(f2 - q.bottom, Math.min(f3 - q.top, paramFloat2));
      b.postTranslate(f1, f2);
      invalidate();
      if (f1 != paramFloat1) {
        break label382;
      }
      i1 = 1;
      label227:
      if (f2 != paramFloat2) {
        break label388;
      }
    }
    label254:
    label264:
    label315:
    label325:
    label382:
    label388:
    for (int i2 = 1;; i2 = 0)
    {
      if ((i1 == 0) || (i2 == 0)) {
        break label394;
      }
      return 3;
      f1 = 0.0F;
      break;
      f2 = getWidth();
      break label59;
      if (f5 - f4 < f2 - f1)
      {
        f1 += (f2 - f1 - (f4 + f5)) / 2.0F;
        break label111;
      }
      f1 = Math.max(f2 - f5, Math.min(f1 - f4, paramFloat1));
      break label111;
      f3 = getHeight();
      break label149;
      if (f5 - f4 < f3 - f2)
      {
        f2 += (f3 - f2 - (f4 + f5)) / 2.0F;
        break label203;
      }
      f2 = Math.max(f3 - f5, Math.min(f2 - f4, paramFloat2));
      break label203;
      i1 = 0;
      break label227;
    }
    label394:
    if (i1 != 0) {
      return 1;
    }
    if (i2 != 0) {
      return 2;
    }
    return 0;
  }
  
  public final void a()
  {
    b.set(B);
    invalidate();
  }
  
  public final void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    b.postRotate(-o, getWidth() / 2, getHeight() / 2);
    paramFloat1 = Math.min(Math.max(paramFloat1, j), k * 1.5F);
    float f1 = b();
    if ((paramFloat1 > k) && (f1 <= k)) {
      postDelayed(new bni(this), 600L);
    }
    paramFloat1 /= f1;
    b.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    b.postRotate(o, getWidth() / 2, getHeight() / 2);
    invalidate();
  }
  
  public final void a(boolean paramBoolean)
  {
    h = paramBoolean;
    if (!h) {
      a();
    }
  }
  
  public final float b()
  {
    b.getValues(r);
    return r[0];
  }
  
  public final void b(boolean paramBoolean)
  {
    int i5 = 0;
    if ((a == null) || (!D)) {
      return;
    }
    int i2 = a.getIntrinsicWidth();
    int i3 = a.getIntrinsicHeight();
    int i1 = getWidth();
    int i4 = getHeight();
    int i6;
    int i7;
    if (((i2 < 0) || (i1 == i2)) && ((i3 < 0) || (i4 == i3)))
    {
      i1 = 1;
      a.setBounds(0, 0, i2, i3);
      if ((paramBoolean) || ((j == 0.0F) && (a != null) && (D)))
      {
        i6 = a.getIntrinsicWidth();
        i7 = a.getIntrinsicHeight();
        if (!G) {
          break label324;
        }
        i2 = v;
        label137:
        if (!G) {
          break label332;
        }
        i3 = v;
        label149:
        if (i6 >= 0)
        {
          i4 = i5;
          if (i2 != i6) {}
        }
        else if (i7 >= 0)
        {
          i4 = i5;
          if (i3 != i7) {}
        }
        else
        {
          i4 = 1;
        }
        if ((i4 == 0) || (G)) {
          break label341;
        }
        b.reset();
        label202:
        B.set(b);
        i4 = a.getIntrinsicWidth();
        i5 = a.getIntrinsicHeight();
        if (!G) {
          break label516;
        }
        i2 = d();
        label243:
        if (!G) {
          break label524;
        }
        i3 = d();
        label256:
        if ((i4 >= i2) || (i5 >= i3) || (G)) {
          break label533;
        }
      }
    }
    label324:
    label332:
    label341:
    label494:
    label516:
    label524:
    label533:
    for (j = 1.0F;; j = b())
    {
      k = Math.max(j * 4.0F, 4.0F);
      if ((i1 == 0) && (!b.isIdentity())) {
        break label544;
      }
      A = null;
      return;
      i1 = 0;
      break;
      i2 = getWidth();
      break label137;
      i3 = getHeight();
      break label149;
      p.set(0.0F, 0.0F, i6, i7);
      if (G) {
        M.set(H);
      }
      for (;;)
      {
        RectF localRectF = new RectF(i2 / 2 - i6 * d / 2.0F, i3 / 2 - i7 * d / 2.0F, i2 / 2 + i6 * d / 2.0F, i3 / 2 + i7 * d / 2.0F);
        if (!M.contains(localRectF)) {
          break label494;
        }
        b.setRectToRect(p, localRectF, Matrix.ScaleToFit.CENTER);
        break;
        M.set(0.0F, 0.0F, i2, i3);
      }
      b.setRectToRect(p, M, Matrix.ScaleToFit.CENTER);
      break label202;
      i2 = getWidth();
      break label243;
      i3 = getHeight();
      break label256;
    }
    label544:
    A = b;
  }
  
  public final void c()
  {
    float f4 = 0.0F;
    q.set(p);
    b.mapRect(q);
    float f1;
    float f2;
    label58:
    float f3;
    float f5;
    label99:
    label115:
    label131:
    float f6;
    if (G)
    {
      f1 = H.left;
      if (!G) {
        break label263;
      }
      f2 = H.right;
      f3 = q.left;
      f5 = q.right;
      if (f5 - f3 >= f2 - f1) {
        break label272;
      }
      f1 += (f2 - f1 - (f3 + f5)) / 2.0F;
      if (!G) {
        break label305;
      }
      f2 = H.top;
      if (!G) {
        break label310;
      }
      f3 = H.bottom;
      f6 = q.top;
      f5 = q.bottom;
      if (f5 - f6 >= f3 - f2) {
        break label319;
      }
      f2 = (f3 - f2 - (f5 + f6)) / 2.0F + f2;
    }
    for (;;)
    {
      if ((Math.abs(f1) <= 20.0F) && (Math.abs(f2) <= 20.0F)) {
        break label352;
      }
      bnl localbnl = m;
      if (!e)
      {
        d = -1L;
        b = f1;
        c = f2;
        f = false;
        e = true;
        a.postDelayed(localbnl, 250L);
      }
      return;
      f1 = 0.0F;
      break;
      label263:
      f2 = getWidth();
      break label58;
      label272:
      if (f3 > f1)
      {
        f1 -= f3;
        break label99;
      }
      if (f5 < f2)
      {
        f1 = f2 - f5;
        break label99;
      }
      f1 = 0.0F;
      break label99;
      label305:
      f2 = 0.0F;
      break label115;
      label310:
      f3 = getHeight();
      break label131;
      label319:
      if (f6 > f2)
      {
        f2 -= f6;
      }
      else
      {
        f2 = f4;
        if (f5 < f3) {
          f2 = f3 - f5;
        }
      }
    }
    label352:
    b.postTranslate(f1, f2);
    invalidate();
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (a == paramDrawable)
    {
      invalidate();
      return;
    }
    super.invalidateDrawable(paramDrawable);
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    s = true;
    if (!P) {
      return a(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    int i1;
    int i2;
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
          } while (!P);
          N = paramMotionEvent.getX();
          O = paramMotionEvent.getY();
          return false;
        } while (!P);
        return a(paramMotionEvent);
      } while ((!P) || (!s));
      i1 = (int)(paramMotionEvent.getX() - N);
      i2 = (int)(paramMotionEvent.getY() - O);
    } while (i1 * i1 + i2 * i2 <= t);
    s = false;
    return false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if (h)
    {
      l.a();
      m.a();
    }
    return true;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i1;
    if (a != null)
    {
      i1 = paramCanvas.getSaveCount();
      paramCanvas.save();
      if (A != null) {
        paramCanvas.concat(A);
      }
      a.draw(paramCanvas);
      paramCanvas.restoreToCount(i1);
      if (E != null) {
        if (!F) {
          break label224;
        }
      }
    }
    label224:
    for (Bitmap localBitmap = w;; localBitmap = x)
    {
      i1 = (getWidth() - localBitmap.getWidth()) / 2;
      int i2 = (getHeight() - localBitmap.getHeight()) / 2;
      paramCanvas.drawBitmap(localBitmap, i1, i2, null);
      q.set(a.getBounds());
      if (A != null) {
        A.mapRect(q);
      }
      if (G)
      {
        i1 = paramCanvas.getSaveCount();
        paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), y);
        paramCanvas.save();
        paramCanvas.clipRect(H);
        if (A != null) {
          paramCanvas.concat(A);
        }
        a.draw(paramCanvas);
        paramCanvas.restoreToCount(i1);
        paramCanvas.drawRect(H, z);
      }
      return;
    }
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((h) && (!i.a))
    {
      paramMotionEvent1 = l;
      if (!g)
      {
        f = -1L;
        b = paramFloat1;
        c = paramFloat2;
        paramFloat1 = (float)Math.atan2(c, b);
        d = ((float)(Math.cos(paramFloat1) * 20000.0D));
        e = ((float)(Math.sin(paramFloat1) * 20000.0D));
        h = false;
        g = true;
        a.post(paramMotionEvent1);
      }
    }
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    D = true;
    paramInt1 = getWidth();
    paramInt2 = getHeight();
    if (G)
    {
      I = Math.min(v, Math.min(paramInt1, paramInt2));
      paramInt1 = (paramInt1 - I) / 2;
      paramInt2 = (paramInt2 - I) / 2;
      paramInt3 = I;
      paramInt4 = I;
      H.set(paramInt1, paramInt2, paramInt3 + paramInt1, paramInt4 + paramInt2);
    }
    b(paramBoolean);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (C != -1)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(C, Integer.MIN_VALUE));
      setMeasuredDimension(getMeasuredWidth(), C);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if ((h) && (!i.a))
    {
      L = false;
      a(b() * paramScaleGestureDetector.getScaleFactor(), paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
    }
    return true;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    if ((h) && (!i.a))
    {
      i.a();
      L = true;
    }
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    if ((h) && (L))
    {
      K = true;
      a();
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((h) && (!i.a)) {
      a(-paramFloat1, -paramFloat2);
    }
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if ((g != null) && (!L)) {
      g.onClick(this);
    }
    L = false;
    return true;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((f == null) || (e == null)) {}
    do
    {
      return true;
      f.onTouchEvent(paramMotionEvent);
      e.a.a(paramMotionEvent);
      switch (paramMotionEvent.getAction())
      {
      case 2: 
      default: 
        return true;
      }
    } while (l.g);
    c();
    return true;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    g = paramOnClickListener;
  }
  
  public boolean verifyDrawable(Drawable paramDrawable)
  {
    return (a == paramDrawable) || (super.verifyDrawable(paramDrawable));
  }
}

/* Location:
 * Qualified Name:     com.android.ex.photo.views.PhotoView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */