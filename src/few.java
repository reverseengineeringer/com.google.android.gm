import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import java.io.FileOutputStream;
import java.io.OutputStream;

public final class few
  implements fam
{
  final Contents a;
  private boolean b = false;
  private boolean c = false;
  private boolean d = false;
  
  public few(Contents paramContents)
  {
    a = ((Contents)enz.a(paramContents));
  }
  
  public final DriveId a()
  {
    return a.e;
  }
  
  public final ejh<Status> a(eiz parameiz, faz paramfaz, faw paramfaw)
  {
    faw localfaw = paramfaw;
    if (paramfaw == null) {
      localfaw = new fax().a();
    }
    if (a.d == 268435456) {
      throw new IllegalStateException("Cannot commit contents opened with MODE_READ_ONLY");
    }
    switch (c)
    {
    }
    for (int i = 0; (i != 0) && (!a.f); i = 1) {
      throw new IllegalStateException("DriveContents must be valid for conflict detection.");
    }
    faw.a(parameiz, localfaw);
    if (b) {
      throw new IllegalStateException("DriveContents already closed.");
    }
    if (a.e == null) {
      throw new IllegalStateException("Only DriveContents obtained through DriveFile.open can be committed.");
    }
    if (paramfaz != null) {}
    for (;;)
    {
      d();
      return parameiz.b(new fex(this, parameiz, paramfaz, localfaw));
      paramfaz = faz.a;
    }
  }
  
  public final OutputStream b()
  {
    if (b) {
      throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
    }
    if (a.d != 536870912) {
      throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
    }
    if (d) {
      throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
    }
    d = true;
    return new FileOutputStream(a.b.getFileDescriptor());
  }
  
  public final Contents c()
  {
    return a;
  }
  
  public final void d()
  {
    eow.a(a.b);
    b = true;
  }
  
  public final boolean e()
  {
    return b;
  }
}

/* Location:
 * Qualified Name:     few
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */