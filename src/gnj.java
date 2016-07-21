import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;

public final class gnj
{
  private static final byte[] a = ;
  
  static byte[] a()
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
      localDataOutputStream.writeLong(System.currentTimeMillis());
      localDataOutputStream.writeLong(System.nanoTime());
      localDataOutputStream.writeInt(Process.myPid());
      localDataOutputStream.writeInt(Process.myUid());
      localDataOutputStream.write(a);
      localDataOutputStream.close();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return (byte[])localObject;
    }
    catch (IOException localIOException)
    {
      throw new SecurityException("Failed to generate seed", localIOException);
    }
  }
  
  public static void apply()
  {
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 16)
        {
          i = Build.VERSION.SDK_INT;
          if (i <= 18) {
            continue;
          }
        }
      }
      catch (SecurityException localSecurityException2)
      {
        int i;
        Log.w("PrngFixes", "Failed to apply the fix for OpenSSL PRNG having low entropy", localSecurityException2);
        continue;
        try
        {
          Object localObject2 = SecureRandom.getInstance("SHA1PRNG");
          if (gnl.class.equals(((SecureRandom)localObject2).getProvider().getClass())) {
            continue;
          }
          localObject2 = String.valueOf(((SecureRandom)localObject2).getProvider().getClass());
          throw new SecurityException(String.valueOf(localObject2).length() + 63 + "SecureRandom.getInstance(\"SHA1PRNG\") backed by wrong Provider: " + (String)localObject2);
        }
        catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
        {
          throw new SecurityException("SHA1PRNG not available", localNoSuchAlgorithmException);
        }
      }
      try
      {
        if (Build.VERSION.SDK_INT <= 18)
        {
          Object localObject1 = Security.getProviders("SecureRandom.SHA1PRNG");
          if ((localObject1 == null) || (localObject1.length <= 0) || (!gnl.class.equals(localObject1[0].getClass()))) {
            Security.insertProviderAt(new gnl(), 1);
          }
          localObject1 = new SecureRandom();
          if (gnl.class.equals(((SecureRandom)localObject1).getProvider().getClass())) {
            continue;
          }
          localObject1 = String.valueOf(((SecureRandom)localObject1).getProvider().getClass());
          throw new SecurityException(String.valueOf(localObject1).length() + 45 + "new SecureRandom() backed by wrong Provider: " + (String)localObject1);
        }
      }
      catch (SecurityException localSecurityException1)
      {
        Log.w("PrngFixes", "Failed to install a Linux PRNG-backed SecureRandom impl as default, e");
      }
      return;
      try
      {
        Class.forName("org.apache.harmony.xnet.provider.jsse.NativeCrypto").getMethod("RAND_seed", new Class[] { byte[].class }).invoke(null, new Object[] { a() });
        i = ((Integer)Class.forName("org.apache.harmony.xnet.provider.jsse.NativeCrypto").getMethod("RAND_load_file", new Class[] { String.class, Long.TYPE }).invoke(null, new Object[] { "/dev/urandom", Integer.valueOf(1024) })).intValue();
        if (i == 1024) {
          continue;
        }
        throw new IOException(60 + "Unexpected number of bytes read from Linux PRNG: " + i);
      }
      catch (Exception localException)
      {
        throw new SecurityException("Failed to seed OpenSSL PRNG", localException);
      }
    }
  }
  
  private static byte[] b()
  {
    Object localObject = new StringBuilder();
    String str = Build.FINGERPRINT;
    if (str != null) {
      ((StringBuilder)localObject).append(str);
    }
    str = Build.SERIAL;
    if (str != null) {
      ((StringBuilder)localObject).append(str);
    }
    try
    {
      localObject = ((StringBuilder)localObject).toString().getBytes("UTF-8");
      return (byte[])localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException("UTF-8 encoding not supported");
    }
  }
}

/* Location:
 * Qualified Name:     gnj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */