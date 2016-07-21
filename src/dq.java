import android.graphics.Path;
import android.util.Log;

public final class dq
{
  char a;
  float[] b;
  
  dq(char paramChar, float[] paramArrayOfFloat)
  {
    a = paramChar;
    b = paramArrayOfFloat;
  }
  
  dq(dq paramdq)
  {
    a = a;
    b = do.a(b, 0, b.length);
  }
  
  private static void a(Path paramPath, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8, double paramDouble9)
  {
    int j = (int)Math.ceil(Math.abs(4.0D * paramDouble9 / 3.141592653589793D));
    double d6 = Math.cos(paramDouble7);
    double d7 = Math.sin(paramDouble7);
    paramDouble7 = Math.cos(paramDouble8);
    double d2 = Math.sin(paramDouble8);
    double d3 = -paramDouble3;
    double d1 = -paramDouble3;
    double d8 = paramDouble9 / j;
    int i = 0;
    d1 = d2 * (d1 * d7) + paramDouble7 * (paramDouble4 * d6);
    d2 = d3 * d6 * d2 - paramDouble4 * d7 * paramDouble7;
    paramDouble9 = paramDouble8;
    paramDouble8 = paramDouble6;
    paramDouble7 = paramDouble5;
    paramDouble6 = d2;
    for (paramDouble5 = d1; i < j; paramDouble5 = d3)
    {
      double d4 = paramDouble9 + d8;
      d3 = Math.sin(d4);
      double d9 = Math.cos(d4);
      d1 = paramDouble3 * d6 * d9 + paramDouble1 - paramDouble4 * d7 * d3;
      d2 = paramDouble4 * d6 * d3 + (paramDouble3 * d7 * d9 + paramDouble2);
      double d5 = -paramDouble3 * d6 * d3 - paramDouble4 * d7 * d9;
      d3 = d9 * (paramDouble4 * d6) + d3 * (-paramDouble3 * d7);
      d9 = Math.tan((d4 - paramDouble9) / 2.0D);
      paramDouble9 = Math.sin(d4 - paramDouble9);
      paramDouble9 = (Math.sqrt(d9 * (3.0D * d9) + 4.0D) - 1.0D) * paramDouble9 / 3.0D;
      paramPath.cubicTo((float)(paramDouble6 * paramDouble9 + paramDouble7), (float)(paramDouble8 + paramDouble5 * paramDouble9), (float)(d1 - paramDouble9 * d5), (float)(d2 - paramDouble9 * d3), (float)d1, (float)d2);
      i += 1;
      paramDouble6 = d5;
      paramDouble9 = d4;
      paramDouble8 = d2;
      paramDouble7 = d1;
    }
  }
  
  static void a(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, boolean paramBoolean1, boolean paramBoolean2)
  {
    double d5;
    double d6;
    double d7;
    double d8;
    double d9;
    double d4;
    double d11;
    double d10;
    double d3;
    double d2;
    double d13;
    for (;;)
    {
      d5 = Math.toRadians(paramFloat7);
      d6 = Math.cos(d5);
      d7 = Math.sin(d5);
      d8 = (paramFloat1 * d6 + paramFloat2 * d7) / paramFloat5;
      d9 = (-paramFloat1 * d7 + paramFloat2 * d6) / paramFloat6;
      d1 = (paramFloat3 * d6 + paramFloat4 * d7) / paramFloat5;
      d4 = (-paramFloat3 * d7 + paramFloat4 * d6) / paramFloat6;
      d11 = d8 - d1;
      d10 = d9 - d4;
      d3 = (d8 + d1) / 2.0D;
      d2 = (d9 + d4) / 2.0D;
      d12 = d11 * d11 + d10 * d10;
      if (d12 == 0.0D)
      {
        Log.w("PathParser", " Points are coincident");
        return;
      }
      d13 = 1.0D / d12 - 0.25D;
      if (d13 >= 0.0D) {
        break;
      }
      Log.w("PathParser", "Points are too far apart " + d12);
      float f = (float)(Math.sqrt(d12) / 1.99999D);
      paramFloat5 *= f;
      paramFloat6 *= f;
    }
    double d12 = Math.sqrt(d13);
    d11 *= d12;
    d10 *= d12;
    if (paramBoolean1 == paramBoolean2)
    {
      d3 -= d10;
      d2 = d11 + d2;
      d8 = Math.atan2(d9 - d2, d8 - d3);
      d4 = Math.atan2(d4 - d2, d1 - d3) - d8;
      if (d4 < 0.0D) {
        break label415;
      }
      paramBoolean1 = true;
      label313:
      d1 = d4;
      if (paramBoolean2 != paramBoolean1) {
        if (d4 <= 0.0D) {
          break label421;
        }
      }
    }
    label415:
    label421:
    for (double d1 = d4 - 6.283185307179586D;; d1 = d4 + 6.283185307179586D)
    {
      d3 *= paramFloat5;
      d2 = paramFloat6 * d2;
      a(paramPath, d3 * d6 - d2 * d7, d3 * d7 + d6 * d2, paramFloat5, paramFloat6, paramFloat1, paramFloat2, d5, d8, d1);
      return;
      d3 = d10 + d3;
      d2 -= d11;
      break;
      paramBoolean1 = false;
      break label313;
    }
  }
}

/* Location:
 * Qualified Name:     dq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */