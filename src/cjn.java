import android.app.Activity;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.VmPolicy;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class cjn
  extends zh
  implements cpw
{
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    ctp.a(this, paramContext);
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    getLoaderManager().dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    getFragmentManager().dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public final Activity g()
  {
    return this;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
    StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
    super.onCreate(paramBundle);
  }
}

/* Location:
 * Qualified Name:     cjn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */