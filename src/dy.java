import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Region.Op;
import java.util.ArrayList;

final class dy
{
  private static final Matrix m = new Matrix();
  Paint a;
  Paint b;
  final dw c;
  float d = 0.0F;
  float e = 0.0F;
  float f = 0.0F;
  float g = 0.0F;
  int h = 255;
  String i = null;
  final ns<String, Object> j = new ns();
  private final Path k;
  private final Path l;
  private final Matrix n = new Matrix();
  private PathMeasure o;
  private int p;
  
  public dy()
  {
    c = new dw();
    k = new Path();
    l = new Path();
  }
  
  public dy(dy paramdy)
  {
    c = new dw(c, j);
    k = new Path(k);
    l = new Path(l);
    d = d;
    e = e;
    f = f;
    g = g;
    p = p;
    h = h;
    i = i;
    if (i != null) {
      j.put(i, this);
    }
  }
  
  private final void a(dw paramdw, Matrix paramMatrix, Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
  {
    a.set(paramMatrix);
    a.preConcat(j);
    int i3 = 0;
    if (i3 < b.size())
    {
      paramMatrix = b.get(i3);
      if ((paramMatrix instanceof dw)) {
        a((dw)paramMatrix, a, paramCanvas, paramInt1, paramInt2, paramColorFilter);
      }
    }
    label314:
    label558:
    label740:
    label2441:
    label2539:
    label2606:
    label2692:
    label3198:
    label3246:
    for (;;)
    {
      i3 += 1;
      break;
      if ((paramMatrix instanceof dx))
      {
        paramMatrix = (dx)paramMatrix;
        float f1 = paramInt1 / f;
        float f2 = paramInt2 / g;
        float f10 = Math.min(f1, f2);
        Object localObject1 = a;
        n.set((Matrix)localObject1);
        n.postScale(f1, f2);
        Object localObject2 = new float[4];
        tmp155_153 = localObject2;
        tmp155_153[0] = 0.0F;
        tmp159_155 = tmp155_153;
        tmp159_155[1] = 1.0F;
        tmp163_159 = tmp159_155;
        tmp163_159[2] = 1.0F;
        tmp167_163 = tmp163_159;
        tmp167_163[3] = 0.0F;
        tmp167_163;
        ((Matrix)localObject1).mapVectors((float[])localObject2);
        float f5 = (float)Math.hypot(localObject2[0], localObject2[1]);
        float f6 = (float)Math.hypot(localObject2[2], localObject2[3]);
        f1 = localObject2[0];
        f2 = localObject2[1];
        float f3 = localObject2[2];
        float f4 = localObject2[3];
        f5 = Math.max(f5, f6);
        if (f5 > 0.0F) {}
        for (float f9 = Math.abs(f4 * f1 - f2 * f3) / f5;; f9 = 0.0F)
        {
          if (f9 == 0.0F) {
            break label3246;
          }
          localObject1 = k;
          ((Path)localObject1).reset();
          float[] arrayOfFloat1;
          int i2;
          int i4;
          float[] arrayOfFloat2;
          int i5;
          float f7;
          float f8;
          if (n != null)
          {
            localObject2 = n;
            arrayOfFloat1 = new float[6];
            i2 = 109;
            i4 = 0;
            if (i4 < localObject2.length)
            {
              int i6 = a;
              arrayOfFloat2 = b;
              f6 = arrayOfFloat1[0];
              f5 = arrayOfFloat1[1];
              f4 = arrayOfFloat1[2];
              f3 = arrayOfFloat1[3];
              f1 = arrayOfFloat1[4];
              f2 = arrayOfFloat1[5];
              int i1;
              switch (i6)
              {
              default: 
                i1 = 2;
                i5 = 0;
                if (i5 < arrayOfFloat2.length) {
                  switch (i6)
                  {
                  default: 
                    f7 = f2;
                    f2 = f3;
                    f3 = f1;
                    f1 = f7;
                  }
                }
                break;
              case 90: 
              case 122: 
              case 76: 
              case 77: 
              case 84: 
              case 108: 
              case 109: 
              case 116: 
              case 72: 
              case 86: 
              case 104: 
              case 118: 
              case 67: 
              case 99: 
              case 81: 
              case 83: 
              case 113: 
              case 115: 
              case 65: 
              case 97: 
                for (;;)
                {
                  i5 += i1;
                  f7 = f3;
                  i2 = i6;
                  f3 = f2;
                  f2 = f1;
                  f1 = f7;
                  break label558;
                  ((Path)localObject1).close();
                  ((Path)localObject1).moveTo(f1, f2);
                  f3 = f2;
                  f4 = f1;
                  f5 = f2;
                  f6 = f1;
                  i1 = 2;
                  break;
                  i1 = 2;
                  break;
                  i1 = 1;
                  break;
                  i1 = 6;
                  break;
                  i1 = 4;
                  break;
                  i1 = 7;
                  break;
                  f6 += arrayOfFloat2[(i5 + 0)];
                  f5 = arrayOfFloat2[(i5 + 1)] + f5;
                  if (i5 > 0)
                  {
                    ((Path)localObject1).rLineTo(arrayOfFloat2[(i5 + 0)], arrayOfFloat2[(i5 + 1)]);
                    f7 = f1;
                    f1 = f2;
                    f2 = f3;
                    f3 = f7;
                  }
                  else
                  {
                    ((Path)localObject1).rMoveTo(arrayOfFloat2[(i5 + 0)], arrayOfFloat2[(i5 + 1)]);
                    f8 = f5;
                    f7 = f6;
                    f2 = f3;
                    f1 = f5;
                    f3 = f6;
                    f5 = f8;
                    f6 = f7;
                    continue;
                    f5 = arrayOfFloat2[(i5 + 0)];
                    f6 = arrayOfFloat2[(i5 + 1)];
                    if (i5 > 0)
                    {
                      ((Path)localObject1).lineTo(arrayOfFloat2[(i5 + 0)], arrayOfFloat2[(i5 + 1)]);
                      f7 = f5;
                      f5 = f1;
                      f1 = f2;
                      f2 = f3;
                      f3 = f5;
                      f5 = f6;
                      f6 = f7;
                    }
                    else
                    {
                      ((Path)localObject1).moveTo(arrayOfFloat2[(i5 + 0)], arrayOfFloat2[(i5 + 1)]);
                      f8 = f6;
                      f7 = f5;
                      f2 = f3;
                      f1 = f6;
                      f3 = f5;
                      f5 = f8;
                      f6 = f7;
                      continue;
                      ((Path)localObject1).rLineTo(arrayOfFloat2[(i5 + 0)], arrayOfFloat2[(i5 + 1)]);
                      f8 = arrayOfFloat2[(i5 + 0)];
                      f7 = arrayOfFloat2[(i5 + 1)];
                      f7 += f5;
                      f6 += f8;
                      f5 = f1;
                      f1 = f2;
                      f2 = f3;
                      f3 = f5;
                      f5 = f7;
                      continue;
                      ((Path)localObject1).lineTo(arrayOfFloat2[(i5 + 0)], arrayOfFloat2[(i5 + 1)]);
                      f6 = arrayOfFloat2[(i5 + 0)];
                      f5 = arrayOfFloat2[(i5 + 1)];
                      f7 = f1;
                      f1 = f2;
                      f2 = f3;
                      f3 = f7;
                      continue;
                      ((Path)localObject1).rLineTo(arrayOfFloat2[(i5 + 0)], 0.0F);
                      f7 = arrayOfFloat2[(i5 + 0)];
                      f7 = f6 + f7;
                      f6 = f1;
                      f1 = f2;
                      f2 = f3;
                      f3 = f6;
                      f6 = f7;
                      continue;
                      ((Path)localObject1).lineTo(arrayOfFloat2[(i5 + 0)], f5);
                      f6 = arrayOfFloat2[(i5 + 0)];
                      f7 = f1;
                      f1 = f2;
                      f2 = f3;
                      f3 = f7;
                      continue;
                      ((Path)localObject1).rLineTo(0.0F, arrayOfFloat2[(i5 + 0)]);
                      f8 = arrayOfFloat2[(i5 + 0)];
                      f7 = f1;
                      f5 = f8 + f5;
                      f1 = f2;
                      f2 = f3;
                      f3 = f7;
                      continue;
                      ((Path)localObject1).lineTo(f6, arrayOfFloat2[(i5 + 0)]);
                      f7 = arrayOfFloat2[(i5 + 0)];
                      f5 = f1;
                      f1 = f2;
                      f2 = f3;
                      f3 = f5;
                      f5 = f7;
                      continue;
                      ((Path)localObject1).rCubicTo(arrayOfFloat2[(i5 + 0)], arrayOfFloat2[(i5 + 1)], arrayOfFloat2[(i5 + 2)], arrayOfFloat2[(i5 + 3)], arrayOfFloat2[(i5 + 4)], arrayOfFloat2[(i5 + 5)]);
                      f4 = arrayOfFloat2[(i5 + 2)];
                      f8 = arrayOfFloat2[(i5 + 3)];
                      f3 = arrayOfFloat2[(i5 + 4)];
                      f7 = arrayOfFloat2[(i5 + 5)];
                      f4 = f6 + f4;
                      f7 += f5;
                      f6 += f3;
                      f3 = f1;
                      f5 = f8 + f5;
                      f1 = f2;
                      f2 = f5;
                      f5 = f7;
                      continue;
                      ((Path)localObject1).cubicTo(arrayOfFloat2[(i5 + 0)], arrayOfFloat2[(i5 + 1)], arrayOfFloat2[(i5 + 2)], arrayOfFloat2[(i5 + 3)], arrayOfFloat2[(i5 + 4)], arrayOfFloat2[(i5 + 5)]);
                      f6 = arrayOfFloat2[(i5 + 4)];
                      f5 = arrayOfFloat2[(i5 + 5)];
                      f4 = arrayOfFloat2[(i5 + 2)];
                      f7 = arrayOfFloat2[(i5 + 3)];
                      f3 = f1;
                      f1 = f2;
                      f2 = f7;
                    }
                  }
                }
                if ((i2 == 99) || (i2 == 115) || (i2 == 67) || (i2 == 83))
                {
                  f3 = f5 - f3;
                  f7 = f6 - f4;
                  f4 = f3;
                }
                break;
              }
            }
          }
          for (f3 = f7;; f3 = 0.0F)
          {
            ((Path)localObject1).rCubicTo(f3, f4, arrayOfFloat2[(i5 + 0)], arrayOfFloat2[(i5 + 1)], arrayOfFloat2[(i5 + 2)], arrayOfFloat2[(i5 + 3)]);
            f4 = arrayOfFloat2[(i5 + 0)];
            f8 = arrayOfFloat2[(i5 + 1)];
            f3 = arrayOfFloat2[(i5 + 2)];
            f7 = arrayOfFloat2[(i5 + 3)];
            f4 = f6 + f4;
            f7 += f5;
            f6 += f3;
            f3 = f1;
            f5 = f8 + f5;
            f1 = f2;
            f2 = f5;
            f5 = f7;
            break label740;
            if ((i2 == 99) || (i2 == 115) || (i2 == 67) || (i2 == 83)) {
              f5 = 2.0F * f5 - f3;
            }
            for (f3 = 2.0F * f6 - f4;; f3 = f6)
            {
              ((Path)localObject1).cubicTo(f3, f5, arrayOfFloat2[(i5 + 0)], arrayOfFloat2[(i5 + 1)], arrayOfFloat2[(i5 + 2)], arrayOfFloat2[(i5 + 3)]);
              f4 = arrayOfFloat2[(i5 + 0)];
              f7 = arrayOfFloat2[(i5 + 1)];
              f6 = arrayOfFloat2[(i5 + 2)];
              f5 = arrayOfFloat2[(i5 + 3)];
              f3 = f1;
              f1 = f2;
              f2 = f7;
              break label740;
              ((Path)localObject1).rQuadTo(arrayOfFloat2[(i5 + 0)], arrayOfFloat2[(i5 + 1)], arrayOfFloat2[(i5 + 2)], arrayOfFloat2[(i5 + 3)]);
              f4 = arrayOfFloat2[(i5 + 0)];
              f8 = arrayOfFloat2[(i5 + 1)];
              f3 = arrayOfFloat2[(i5 + 2)];
              f7 = arrayOfFloat2[(i5 + 3)];
              f4 = f6 + f4;
              f7 += f5;
              f6 += f3;
              f3 = f1;
              f5 = f8 + f5;
              f1 = f2;
              f2 = f5;
              f5 = f7;
              break label740;
              ((Path)localObject1).quadTo(arrayOfFloat2[(i5 + 0)], arrayOfFloat2[(i5 + 1)], arrayOfFloat2[(i5 + 2)], arrayOfFloat2[(i5 + 3)]);
              f4 = arrayOfFloat2[(i5 + 0)];
              f7 = arrayOfFloat2[(i5 + 1)];
              f6 = arrayOfFloat2[(i5 + 2)];
              f5 = arrayOfFloat2[(i5 + 3)];
              f3 = f1;
              f1 = f2;
              f2 = f7;
              break label740;
              if ((i2 == 113) || (i2 == 116) || (i2 == 81) || (i2 == 84))
              {
                f4 = f6 - f4;
                f3 = f5 - f3;
              }
              for (;;)
              {
                ((Path)localObject1).rQuadTo(f4, f3, arrayOfFloat2[(i5 + 0)], arrayOfFloat2[(i5 + 1)]);
                float f11 = arrayOfFloat2[(i5 + 0)];
                f8 = arrayOfFloat2[(i5 + 1)];
                f7 = f6 + f4;
                f8 += f5;
                f6 += f11;
                f4 = f1;
                f3 += f5;
                f1 = f2;
                f2 = f3;
                f3 = f4;
                f4 = f7;
                f5 = f8;
                break label740;
                if ((i2 != 113) && (i2 != 116) && (i2 != 81))
                {
                  f8 = f5;
                  f7 = f6;
                  if (i2 != 84) {}
                }
                else
                {
                  f7 = 2.0F * f6 - f4;
                  f8 = 2.0F * f5 - f3;
                }
                ((Path)localObject1).quadTo(f7, f8, arrayOfFloat2[(i5 + 0)], arrayOfFloat2[(i5 + 1)]);
                f6 = arrayOfFloat2[(i5 + 0)];
                f5 = arrayOfFloat2[(i5 + 1)];
                f4 = f7;
                f3 = f1;
                f1 = f2;
                f2 = f8;
                break label740;
                f3 = arrayOfFloat2[(i5 + 5)];
                f4 = arrayOfFloat2[(i5 + 6)];
                f7 = arrayOfFloat2[(i5 + 0)];
                f8 = arrayOfFloat2[(i5 + 1)];
                f11 = arrayOfFloat2[(i5 + 2)];
                boolean bool1;
                if (arrayOfFloat2[(i5 + 3)] != 0.0F)
                {
                  bool1 = true;
                  if (arrayOfFloat2[(i5 + 4)] == 0.0F) {
                    break label2539;
                  }
                }
                for (boolean bool2 = true;; bool2 = false)
                {
                  dq.a((Path)localObject1, f6, f5, f3 + f6, f4 + f5, f7, f8, f11, bool1, bool2);
                  f6 += arrayOfFloat2[(i5 + 5)];
                  f7 = arrayOfFloat2[(i5 + 6)] + f5;
                  f3 = f1;
                  f4 = f6;
                  f5 = f7;
                  f1 = f2;
                  f2 = f7;
                  break;
                  bool1 = false;
                  break label2441;
                }
                f3 = arrayOfFloat2[(i5 + 5)];
                f4 = arrayOfFloat2[(i5 + 6)];
                f7 = arrayOfFloat2[(i5 + 0)];
                f8 = arrayOfFloat2[(i5 + 1)];
                f11 = arrayOfFloat2[(i5 + 2)];
                if (arrayOfFloat2[(i5 + 3)] != 0.0F)
                {
                  bool1 = true;
                  if (arrayOfFloat2[(i5 + 4)] == 0.0F) {
                    break label2692;
                  }
                }
                for (bool2 = true;; bool2 = false)
                {
                  dq.a((Path)localObject1, f6, f5, f3, f4, f7, f8, f11, bool1, bool2);
                  f6 = arrayOfFloat2[(i5 + 5)];
                  f7 = arrayOfFloat2[(i5 + 6)];
                  f3 = f1;
                  f4 = f6;
                  f5 = f7;
                  f1 = f2;
                  f2 = f7;
                  break;
                  bool1 = false;
                  break label2606;
                }
                arrayOfFloat1[0] = f6;
                arrayOfFloat1[1] = f5;
                arrayOfFloat1[2] = f4;
                arrayOfFloat1[3] = f3;
                arrayOfFloat1[4] = f1;
                arrayOfFloat1[5] = f2;
                i2 = a;
                i4 += 1;
                break label314;
                localObject1 = k;
                l.reset();
                if (paramMatrix.a())
                {
                  l.addPath((Path)localObject1, n);
                  paramCanvas.clipPath(l, Region.Op.REPLACE);
                  break;
                }
                paramMatrix = (dv)paramMatrix;
                if ((h != 0.0F) || (i != 1.0F))
                {
                  f4 = h;
                  f5 = j;
                  f2 = i;
                  f3 = j;
                  if (o == null) {
                    o = new PathMeasure();
                  }
                  o.setPath(k, false);
                  f1 = o.getLength();
                  f4 = (f4 + f5) % 1.0F * f1;
                  f2 = (f2 + f3) % 1.0F * f1;
                  ((Path)localObject1).reset();
                  if (f4 <= f2) {
                    break label3198;
                  }
                  o.getSegment(f4, f1, (Path)localObject1, true);
                  o.getSegment(0.0F, f2, (Path)localObject1, true);
                }
                for (;;)
                {
                  ((Path)localObject1).rLineTo(0.0F, 0.0F);
                  l.addPath((Path)localObject1, n);
                  if (d != 0)
                  {
                    if (b == null)
                    {
                      b = new Paint();
                      b.setStyle(Paint.Style.FILL);
                      b.setAntiAlias(true);
                    }
                    localObject1 = b;
                    ((Paint)localObject1).setColor(dt.a(d, g));
                    ((Paint)localObject1).setColorFilter(paramColorFilter);
                    paramCanvas.drawPath(l, (Paint)localObject1);
                  }
                  if (b == 0) {
                    break;
                  }
                  if (a == null)
                  {
                    a = new Paint();
                    a.setStyle(Paint.Style.STROKE);
                    a.setAntiAlias(true);
                  }
                  localObject1 = a;
                  if (l != null) {
                    ((Paint)localObject1).setStrokeJoin(l);
                  }
                  if (k != null) {
                    ((Paint)localObject1).setStrokeCap(k);
                  }
                  ((Paint)localObject1).setStrokeMiter(m);
                  ((Paint)localObject1).setColor(dt.a(b, e));
                  ((Paint)localObject1).setColorFilter(paramColorFilter);
                  ((Paint)localObject1).setStrokeWidth(f10 * f9 * c);
                  paramCanvas.drawPath(l, (Paint)localObject1);
                  break;
                  o.getSegment(f4, f2, (Path)localObject1, true);
                }
                return;
                f3 = 0.0F;
                f4 = 0.0F;
              }
            }
            f4 = 0.0F;
          }
        }
      }
    }
  }
  
  public final void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    a(c, m, paramCanvas, paramInt1, paramInt2, null);
  }
}

/* Location:
 * Qualified Name:     dy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */