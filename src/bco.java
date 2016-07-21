import android.text.TextUtils;
import android.util.Base64DataException;
import android.util.Base64InputStream;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class bco
{
  private static final Pattern a = Pattern.compile("\r|\n");
  
  public static InputStream a(InputStream paramInputStream, String paramString)
  {
    Object localObject = paramInputStream;
    if (paramString != null)
    {
      paramString = a(paramString, null);
      if (!"quoted-printable".equalsIgnoreCase(paramString)) {
        break label32;
      }
      localObject = new iei(paramInputStream);
    }
    label32:
    do
    {
      return (InputStream)localObject;
      localObject = paramInputStream;
    } while (!"base64".equalsIgnoreCase(paramString));
    return new Base64InputStream(paramInputStream, 0);
  }
  
  public static String a(bdn parambdn)
  {
    if (parambdn != null) {}
    try
    {
      if (parambdn.a() == null) {
        break label131;
      }
      localObject1 = parambdn.a().g_();
      localObject2 = parambdn.e();
      if ((localObject2 == null) || (!b((String)localObject2, "text/*"))) {
        break label131;
      }
      localObject2 = new ByteArrayOutputStream();
      idc.a((InputStream)localObject1, (OutputStream)localObject2);
      ((InputStream)localObject1).close();
      localObject1 = a(parambdn.b(), "charset");
      parambdn = (bdn)localObject1;
      if (localObject1 == null) {
        break label192;
      }
      parambdn = ihb.b((String)localObject1);
    }
    catch (OutOfMemoryError parambdn)
    {
      Object localObject2;
      parambdn = String.valueOf(parambdn.toString());
      if (parambdn.length() == 0) {
        break label133;
      }
      for (parambdn = "Unable to getTextFromPart ".concat(parambdn);; parambdn = new String("Unable to getTextFromPart "))
      {
        Log.e("Email", parambdn);
        return null;
      }
    }
    catch (Exception parambdn)
    {
      for (;;)
      {
        parambdn = String.valueOf(parambdn.toString());
        if (parambdn.length() != 0) {}
        for (parambdn = "Unable to getTextFromPart ".concat(parambdn);; parambdn = new String("Unable to getTextFromPart "))
        {
          Log.e("Email", parambdn);
          break;
        }
        Object localObject1 = parambdn;
        if (parambdn == null) {
          localObject1 = "ASCII";
        }
      }
    }
    parambdn = ((ByteArrayOutputStream)localObject2).toString((String)localObject1);
    ((ByteArrayOutputStream)localObject2).close();
    return parambdn;
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    Matcher localMatcher;
    do
    {
      return paramString;
      localMatcher = a.matcher(paramString);
    } while (!localMatcher.find());
    localMatcher.reset();
    return localMatcher.replaceAll("");
  }
  
  public static String a(String paramString, int paramInt)
  {
    return b(iec.a(paramString, iee.a, paramInt), paramInt);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    int i = 0;
    Object localObject = null;
    if (paramString1 == null)
    {
      paramString1 = (String)localObject;
      return paramString1;
    }
    String[] arrayOfString = a(paramString1).split(";");
    if (paramString2 == null) {
      return arrayOfString[0].trim();
    }
    paramString2 = paramString2.toLowerCase();
    int j = arrayOfString.length;
    for (;;)
    {
      paramString1 = (String)localObject;
      if (i >= j) {
        break;
      }
      paramString1 = arrayOfString[i];
      if (paramString1.trim().toLowerCase().startsWith(paramString2))
      {
        paramString2 = paramString1.split("=", 2);
        paramString1 = (String)localObject;
        if (paramString2.length < 2) {
          break;
        }
        paramString2 = paramString2[1].trim();
        paramString1 = paramString2;
        if (!paramString2.startsWith("\"")) {
          break;
        }
        paramString1 = paramString2;
        if (!paramString2.endsWith("\"")) {
          break;
        }
        return paramString2.substring(1, paramString2.length() - 1);
      }
      i += 1;
    }
  }
  
  public static void a(bdn parambdn, ArrayList<bdn> paramArrayList1, ArrayList<bdn> paramArrayList2)
  {
    int k = 1;
    int j = 0;
    Object localObject = a(parambdn.c(), null);
    int i;
    if ((TextUtils.isEmpty((CharSequence)localObject)) || ("inline".equalsIgnoreCase((String)localObject)))
    {
      i = 1;
      label38:
      localObject = parambdn.e().toLowerCase();
      if (!(parambdn.a() instanceof bdj)) {
        break label174;
      }
      parambdn = (bcn)parambdn.a();
      if (!d.equals("alternative")) {
        break label237;
      }
      i = 0;
      label85:
      if (i >= f.size()) {
        break label237;
      }
      if (!parambdn.a(i).b("text/html")) {
        break label167;
      }
      i = k;
    }
    for (;;)
    {
      if (j < f.size())
      {
        localObject = parambdn.a(j);
        if ((i == 0) || (!((bcv)localObject).b("text/plain"))) {
          a((bdn)localObject, paramArrayList1, paramArrayList2);
        }
        j += 1;
        continue;
        i = 0;
        break label38;
        label167:
        i += 1;
        break label85;
        label174:
        if ((parambdn.a() instanceof bdg))
        {
          parambdn = (bdg)parambdn.a();
          break;
        }
        if ((i == 0) || ((!((String)localObject).startsWith("text")) && (!((String)localObject).startsWith("image")))) {
          break label230;
        }
        paramArrayList1.add(parambdn);
      }
      return;
      label230:
      paramArrayList2.add(parambdn);
      return;
      label237:
      i = 0;
    }
  }
  
  public static boolean a(String paramString, String[] paramArrayOfString)
  {
    boolean bool2 = false;
    int j = paramArrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (b(paramString, paramArrayOfString[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static bcu b(InputStream paramInputStream, String paramString)
  {
    InputStream localInputStream = a(paramInputStream, paramString);
    paramString = new bcg();
    paramInputStream = paramString.a();
    try
    {
      idc.a(localInputStream, paramInputStream);
      paramInputStream.close();
      return paramString;
    }
    catch (Base64DataException localBase64DataException)
    {
      localBase64DataException = localBase64DataException;
      paramInputStream.close();
      return paramString;
    }
    finally
    {
      paramString = finally;
      paramInputStream.close();
      throw paramString;
    }
  }
  
  public static String b(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return null;
    }
    return ieh.a(paramString);
  }
  
  public static String b(String paramString, int paramInt)
  {
    int k = paramString.length();
    if (paramInt + k <= 76) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = -paramInt;
    paramInt = c(paramString, 0);
    if (paramInt == k)
    {
      localStringBuilder.append(paramString.substring(Math.max(0, i)));
      return localStringBuilder.toString();
    }
    int j = c(paramString, paramInt + 1);
    if (j - i > 76)
    {
      localStringBuilder.append(paramString.substring(Math.max(0, i), paramInt));
      localStringBuilder.append("\r\n");
    }
    for (;;)
    {
      i = paramInt;
      paramInt = j;
      break;
      paramInt = i;
    }
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    return Pattern.compile(paramString2.replaceAll("\\*", "\\.\\*"), 2).matcher(paramString1).matches();
  }
  
  private static int c(String paramString, int paramInt)
  {
    int i = paramString.length();
    while (paramInt < i)
    {
      int j = paramString.charAt(paramInt);
      if ((j == 32) || (j == 9)) {
        return paramInt;
      }
      paramInt += 1;
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     bco
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */