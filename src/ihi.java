import java.util.NoSuchElementException;

final class ihi
{
  private static void a(ihq paramihq)
  {
    int i = 0;
    while (paramihq.hasNext()) {
      switch (ihj.a[paramihq.d().ordinal()])
      {
      default: 
        paramihq.e();
        break;
      case 1: 
        paramihq.e();
      }
    }
    int j;
    do
    {
      return;
      i += 1;
      break;
      j = i - 1;
      i = j;
      if (j > 0) {
        break;
      }
    } while (j == 0);
    paramihq.e();
  }
  
  private static void a(ihq paramihq, ihk paramihk)
  {
    Object localObject;
    String str;
    if (paramihq.hasNext())
    {
      localObject = paramihq.d();
      str = paramihq.b();
      switch (ihj.a[localObject.ordinal()])
      {
      }
    }
    for (;;)
    {
      paramihq.e();
      break;
      paramihq.e();
      return;
      if (!paramihq.hasNext()) {
        throw new NoSuchElementException();
      }
      localObject = b.b;
      int i = ((iho)localObject).a(a);
      if (i < 0)
      {
        i = -1;
        label194:
        if (i >= 0) {
          break label236;
        }
        localObject = null;
      }
      for (;;)
      {
        paramihk.g(str);
        a((ihq)localObject, paramihk);
        paramihk.b();
        break;
        i = a[((i << 1) + 1)];
        break label194;
        label236:
        localObject = new ihq(b, i);
        a = (a + 1);
        a = (i + 1);
      }
      paramihk.c(str);
      continue;
      if ((str.length() == 4) || (str.length() == 7))
      {
        paramihk.d(str);
        continue;
        paramihk.e(str);
        continue;
        paramihk.a();
        continue;
        paramihk.b(str);
        continue;
        paramihk.f(str);
      }
    }
  }
  
  static void a(String paramString, ihk paramihk)
  {
    paramString = ihn.a(paramString);
    paramString = new ihq(paramString, d.length);
    while (paramString.c()) {
      if (paramString.d() != ihr.a)
      {
        a(paramString);
      }
      else
      {
        String str = paramString.a();
        if ((!paramString.c()) || (!":".equals(paramString.b())))
        {
          a(paramString);
        }
        else
        {
          paramString.e();
          paramihk.a(ijj.a(str));
          a(paramString, paramihk);
          paramihk.c();
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     ihi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */