final class vv
{
  int a;
  int b;
  float c;
  float d;
  long e = Long.MIN_VALUE;
  long f = 0L;
  int g = 0;
  int h = 0;
  long i = -1L;
  float j;
  int k;
  
  final float a(long paramLong)
  {
    if (paramLong < e) {
      return 0.0F;
    }
    if ((i < 0L) || (paramLong < i)) {
      return vu.a((float)(paramLong - e) / a, 0.0F, 1.0F) * 0.5F;
    }
    long l = i;
    float f1 = j;
    float f2 = j;
    return vu.a((float)(paramLong - l) / k, 0.0F, 1.0F) * f2 + (1.0F - f1);
  }
}

/* Location:
 * Qualified Name:     vv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */