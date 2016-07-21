import android.content.Context;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class jy<D>
{
  public int n;
  public kb<D> o;
  public ka<D> p;
  public Context q;
  public boolean r = false;
  public boolean s = false;
  public boolean t = true;
  public boolean u = false;
  public boolean v = false;
  
  public jy(Context paramContext)
  {
    q = paramContext.getApplicationContext();
  }
  
  public void a() {}
  
  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mId=");
    paramPrintWriter.print(n);
    paramPrintWriter.print(" mListener=");
    paramPrintWriter.println(o);
    if ((r) || (u) || (v))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStarted=");
      paramPrintWriter.print(r);
      paramPrintWriter.print(" mContentChanged=");
      paramPrintWriter.print(u);
      paramPrintWriter.print(" mProcessingChange=");
      paramPrintWriter.println(v);
    }
    if ((s) || (t))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAbandoned=");
      paramPrintWriter.print(s);
      paramPrintWriter.print(" mReset=");
      paramPrintWriter.println(t);
    }
  }
  
  public final void a(ka<D> paramka)
  {
    if (p == null) {
      throw new IllegalStateException("No listener register");
    }
    if (p != paramka) {
      throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    }
    p = null;
  }
  
  public final void a(kb<D> paramkb)
  {
    if (o == null) {
      throw new IllegalStateException("No listener register");
    }
    if (o != paramkb) {
      throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    }
    o = null;
  }
  
  public void b(D paramD)
  {
    if (o != null) {
      o.a(this, paramD);
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void g() {}
  
  public void h() {}
  
  public void i() {}
  
  public final void j()
  {
    a();
  }
  
  public final boolean k()
  {
    boolean bool = u;
    u = false;
    v |= bool;
    return bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    nv.a(this, localStringBuilder);
    localStringBuilder.append(" id=");
    localStringBuilder.append(n);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     jy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */