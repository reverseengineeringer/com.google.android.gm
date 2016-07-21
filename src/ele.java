import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.io.FileDescriptor;
import java.io.PrintWriter;

final class ele
  extends jy<ConnectionResult>
  implements ejc, eje
{
  public final eiz a;
  boolean b;
  private ConnectionResult c;
  
  public ele(Context paramContext, eiz parameiz)
  {
    super(paramContext);
    a = parameiz;
  }
  
  private final void b(ConnectionResult paramConnectionResult)
  {
    c = paramConnectionResult;
    if ((r) && (!s)) {
      b(paramConnectionResult);
    }
  }
  
  public final void a(int paramInt) {}
  
  public final void a(Bundle paramBundle)
  {
    b = false;
    b(ConnectionResult.a);
  }
  
  public final void a(ConnectionResult paramConnectionResult)
  {
    b = true;
    b(paramConnectionResult);
  }
  
  public final void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.a(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    a.a(paramString, paramPrintWriter);
  }
  
  protected final void g()
  {
    super.g();
    a.a(this);
    a.a(this);
    if (c != null) {
      b(c);
    }
    if ((!a.e()) && (!a.f()) && (!b)) {
      a.b();
    }
  }
  
  protected final void h()
  {
    a.d();
  }
  
  protected final void i()
  {
    c = null;
    b = false;
    a.b(this);
    a.b(this);
    a.d();
  }
}

/* Location:
 * Qualified Name:     ele
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */