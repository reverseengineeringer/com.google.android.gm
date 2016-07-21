import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;
import java.util.Set;

public final class eim
{
  public static final eim a = new eim();
  
  static epk a(PackageInfo paramPackageInfo, epk... paramVarArgs)
  {
    if (signatures.length != 1)
    {
      Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
      return null;
    }
    paramPackageInfo = new esl(signatures[0].toByteArray());
    int i = 0;
    while (i < paramVarArgs.length)
    {
      if (paramVarArgs[i].equals(paramPackageInfo)) {
        return paramVarArgs[i];
      }
      i += 1;
    }
    if (Log.isLoggable("GoogleSignatureVerifier", 2)) {
      new StringBuilder("Signature not valid.  Found: \n").append(Base64.encodeToString(paramPackageInfo.a(), 0));
    }
    return null;
  }
  
  private static boolean a(PackageInfo paramPackageInfo, boolean paramBoolean)
  {
    if (signatures.length != 1)
    {
      Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
      return false;
    }
    esl localesl = new esl(signatures[0].toByteArray());
    if (paramBoolean) {
      if (epj.c == null) {
        epj.c = epj.a(epj.b);
      }
    }
    for (paramPackageInfo = epj.c; paramPackageInfo.contains(localesl); paramPackageInfo = epj.d)
    {
      return true;
      if (epj.d == null) {
        epj.d = epj.a(epj.a);
      }
    }
    if (Log.isLoggable("GoogleSignatureVerifier", 2)) {
      new StringBuilder("Signature not valid.  Found: \n").append(Base64.encodeToString(localesl.a(), 0));
    }
    return false;
  }
  
  public final void a(PackageManager paramPackageManager, int paramInt)
  {
    boolean bool2 = false;
    if (paramPackageManager == null) {
      throw new SecurityException("Unknown error: invalid Package Manager");
    }
    String[] arrayOfString = paramPackageManager.getPackagesForUid(paramInt);
    boolean bool1 = bool2;
    if (arrayOfString != null) {
      if (arrayOfString.length != 0) {
        break label55;
      }
    }
    label55:
    for (bool1 = bool2; !bool1; bool1 = a(paramPackageManager, arrayOfString[0])) {
      throw new SecurityException("Uid is not Google Signed");
    }
  }
  
  public final boolean a(PackageManager paramPackageManager, String paramString)
  {
    boolean bool1 = false;
    PackageInfo localPackageInfo;
    label49:
    boolean bool2;
    do
    {
      do
      {
        try
        {
          localPackageInfo = paramPackageManager.getPackageInfo(paramString, 64);
          if (localPackageInfo != null) {
            break label49;
          }
        }
        catch (PackageManager.NameNotFoundException paramPackageManager)
        {
          while (!Log.isLoggable("GoogleSignatureVerifier", 3)) {}
          new StringBuilder("Package manager can't find package ").append(paramString).append(", defaulting to false");
          return false;
        }
        return bool1;
        if (eik.a(paramPackageManager)) {
          return a(localPackageInfo, true);
        }
        bool2 = a(localPackageInfo, false);
        bool1 = bool2;
      } while (bool2);
      bool1 = bool2;
    } while (!a(localPackageInfo, true));
    Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
    return bool2;
  }
}

/* Location:
 * Qualified Name:     eim
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */