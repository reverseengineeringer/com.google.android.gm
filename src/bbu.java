import android.content.Context;
import android.provider.Settings.Secure;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

final class bbu
  extends bbt
{
  protected final String b(Context paramContext)
  {
    File localFile = paramContext.getFileStreamPath("deviceName");
    if (localFile.exists())
    {
      if (!localFile.canRead()) {
        break label79;
      }
      paramContext = new BufferedReader(new FileReader(localFile), 128);
      String str = paramContext.readLine();
      paramContext.close();
      paramContext = str;
      if (str != null) {
        break label77;
      }
      if (!localFile.delete()) {
        cvm.e(bbw.a, "Can't delete null deviceName file; try overwrite.", new Object[0]);
      }
    }
    for (;;)
    {
      paramContext = null;
      label77:
      return paramContext;
      label79:
      cvm.d(bbw.a, String.valueOf(localFile.getAbsolutePath()).concat(": File exists, but can't read?  Trying to remove."), new Object[0]);
      if (!localFile.delete()) {
        cvm.d(bbw.a, "Remove failed. Tring to overwrite.", new Object[0]);
      }
    }
  }
  
  protected final void b(Context paramContext, String paramString)
  {
    paramContext = new BufferedWriter(new FileWriter(paramContext.getFileStreamPath("deviceName")), 128);
    paramContext.write(paramString);
    paramContext.close();
  }
  
  protected final String c(Context paramContext)
  {
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      if (paramContext == null) {
        return null;
      }
    }
    catch (Exception paramContext)
    {
      cvm.e(bbw.a, paramContext, "Error getting AndroidId", new Object[0]);
      return null;
    }
    return bhn.d(paramContext);
  }
}

/* Location:
 * Qualified Name:     bbu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */