import java.io.InputStream;
import java.util.Stack;

final class bcm
  implements idv
{
  private final Stack<Object> b = new Stack();
  
  public bcm(bcl parambcl) {}
  
  private final void a(Class<?> paramClass)
  {
    if (!paramClass.isInstance(b.peek()))
    {
      paramClass = String.valueOf(paramClass.getName());
      String str = String.valueOf(b.peek().getClass().getName());
      throw new IllegalStateException(String.valueOf(paramClass).length() + 42 + String.valueOf(str).length() + "Internal stack error: Expected '" + paramClass + "' found '" + str + "'");
    }
  }
  
  public final void a()
  {
    if (b.isEmpty())
    {
      b.push(a);
      return;
    }
    a(bdn.class);
    try
    {
      bcl localbcl = new bcl();
      ((bdn)b.peek()).a(localbcl);
      b.push(localbcl);
      return;
    }
    catch (bdi localbdi)
    {
      throw new Error(localbdi);
    }
  }
  
  public final void a(idt paramidt, InputStream paramInputStream)
  {
    a(bdn.class);
    paramidt = bco.b(paramInputStream, c);
    try
    {
      ((bdn)b.peek()).a(paramidt);
      return;
    }
    catch (bdi paramidt)
    {
      throw new Error(paramidt);
    }
  }
  
  public final void a(InputStream paramInputStream)
  {
    a(bcn.class);
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      int i = paramInputStream.read();
      if (i == -1) {
        break;
      }
      localStringBuilder.append((char)i);
    }
  }
  
  public final void a(String paramString)
  {
    a(bdn.class);
    try
    {
      paramString = paramString.split(":", 2);
      ((bdn)b.peek()).a(paramString[0], paramString[1].trim());
      return;
    }
    catch (bdi paramString)
    {
      throw new Error(paramString);
    }
  }
  
  public final void b()
  {
    a(bcl.class);
    b.pop();
  }
  
  public final void b(InputStream paramInputStream)
  {
    a(bcn.class);
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      int i = paramInputStream.read();
      if (i == -1) {
        break;
      }
      localStringBuilder.append((char)i);
    }
    try
    {
      b.peek()).a = localStringBuilder.toString();
      return;
    }
    catch (bdi paramInputStream)
    {
      throw new Error(paramInputStream);
    }
  }
  
  public final void c()
  {
    a(bdn.class);
  }
  
  public final void d()
  {
    a(bdn.class);
  }
  
  public final void e()
  {
    a(bdn.class);
    bdn localbdn = (bdn)b.peek();
    try
    {
      bcn localbcn = new bcn(localbdn.b());
      localbdn.a(localbcn);
      b.push(localbcn);
      return;
    }
    catch (bdi localbdi)
    {
      throw new Error(localbdi);
    }
  }
  
  public final void f()
  {
    b.pop();
  }
  
  public final void g()
  {
    a(bcn.class);
    try
    {
      bci localbci = new bci();
      ((bcn)b.peek()).a(localbci);
      b.push(localbci);
      return;
    }
    catch (bdi localbdi)
    {
      throw new Error(localbdi);
    }
  }
  
  public final void h()
  {
    a(bcv.class);
    b.pop();
  }
  
  public final void i()
  {
    throw new UnsupportedOperationException("Not supported");
  }
}

/* Location:
 * Qualified Name:     bcm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */