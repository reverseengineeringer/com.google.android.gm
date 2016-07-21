import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Base64OutputStream;
import com.android.emailcommon.mail.Address;
import com.android.emailcommon.provider.Attachment;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

public class bcp
{
  static byte a;
  private static final SimpleDateFormat b = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US);
  private static final Pattern c = Pattern.compile("(?:<\\s*body[^>]*>)(.*)(?:<\\s*/\\s*body\\s*>)", 34);
  
  private static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("--_com.android.email_").append(System.nanoTime());
    try
    {
      localStringBuilder.append(a);
      a = (byte)((a + 1) % 10);
      return localStringBuilder.toString();
    }
    finally {}
  }
  
  public static void a(Context paramContext, beb parambeb, OutputStream paramOutputStream, boolean paramBoolean1, boolean paramBoolean2, List<Attachment> paramList)
  {
    if (parambeb == null) {
      return;
    }
    BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(paramOutputStream, 1024);
    OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(localBufferedOutputStream);
    a(localOutputStreamWriter, "Date", b.format(new Date(n)));
    Object localObject1 = o;
    if ((localObject1 != null) && (((String)localObject1).length() > 0))
    {
      localOutputStreamWriter.append("Subject");
      localOutputStreamWriter.append(": ");
      localOutputStreamWriter.append(bco.a((String)localObject1, "Subject".length() + 2));
      localOutputStreamWriter.append("\r\n");
    }
    a(localOutputStreamWriter, "Message-ID", P);
    a(localOutputStreamWriter, "X-Android-Message-ID", P);
    a(localOutputStreamWriter, "In-Reply-To", R);
    b(localOutputStreamWriter, "From", X);
    b(localOutputStreamWriter, "To", Y);
    b(localOutputStreamWriter, "Cc", Z);
    if (paramBoolean2) {
      b(localOutputStreamWriter, "Bcc", aa);
    }
    b(localOutputStreamWriter, "Reply-To", ab);
    String str;
    Object localObject2;
    switch (w)
    {
    default: 
      i = w;
      throw new IllegalArgumentException(38 + "Unexpected priority level: " + i);
    case 0: 
      str = "Low";
      localObject2 = "5";
      localObject1 = "Low";
      a(localOutputStreamWriter, "Importance", str);
      a(localOutputStreamWriter, "X-Priority", (String)localObject2);
      a(localOutputStreamWriter, "X-MSMail-Priority", (String)localObject1);
      a(localOutputStreamWriter, "MIME-Version", "1.0");
      localObject1 = bds.a(paramContext, D);
      localObject2 = new String[2];
      if (localObject1 != null)
      {
        localObject2[1] = d;
        localObject2[0] = e;
        i = f;
        if ((paramBoolean1) && (i > 0))
        {
          if (!a(localObject2[1], i)) {
            break;
          }
          localObject2[1] = localObject2[1].substring(0, i);
        }
      }
      label401:
      localObject1 = paramList;
      if (paramList == null) {
        localObject1 = Arrays.asList(Attachment.b(paramContext, D));
      }
      if (((List)localObject1).size() <= 0) {}
      break;
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label525;
      }
      a(localOutputStreamWriter, localBufferedOutputStream, (String[])localObject2);
      localOutputStreamWriter.flush();
      paramOutputStream.flush();
      return;
      str = "Normal";
      localObject2 = "3";
      localObject1 = "Normal";
      break;
      str = "High";
      localObject2 = "1";
      localObject1 = "High";
      break;
      if (!a(localObject2[0], i)) {
        break label401;
      }
      localObject2[0] = localObject2[0].substring(0, i);
      break label401;
    }
    label525:
    paramList = a();
    if ((((List)localObject1).size() == 1) && ((get0s & 0x1) != 0)) {}
    for (parambeb = "alternative";; parambeb = "mixed")
    {
      a(localOutputStreamWriter, "Content-Type", String.valueOf(parambeb).length() + 23 + String.valueOf(paramList).length() + "multipart/" + parambeb + "; boundary=\"" + paramList + "\"");
      localOutputStreamWriter.write("\r\n");
      if ((localObject2[0] != null) || (localObject2[1] != null))
      {
        a(localOutputStreamWriter, paramList, false);
        a(localOutputStreamWriter, localBufferedOutputStream, (String[])localObject2);
      }
      localObject1 = ((List)localObject1).iterator();
      label675:
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Attachment)((Iterator)localObject1).next();
        a(localOutputStreamWriter, paramList, false);
        parambeb = j;
        str = i;
        a(localOutputStreamWriter, "Content-Type", String.valueOf(parambeb).length() + 10 + String.valueOf(str).length() + parambeb + ";\n name=\"" + str + "\"");
        a(localOutputStreamWriter, "Content-Transfer-Encoding", "base64");
        if ((s & 0x1) == 0)
        {
          parambeb = i;
          str = String.valueOf(Long.toString(k));
          a(localOutputStreamWriter, "Content-Disposition", String.valueOf(parambeb).length() + 32 + String.valueOf(str).length() + "attachment;\n filename=\"" + parambeb + "\";\n size=" + str);
        }
        if (l != null) {
          a(localOutputStreamWriter, "Content-ID", l);
        }
        localOutputStreamWriter.append("\r\n");
        parambeb = null;
      }
      label1128:
      for (;;)
      {
        try
        {
          if (t == null) {
            continue;
          }
          parambeb = new ByteArrayInputStream(t);
          localOutputStreamWriter.flush();
          localObject2 = new Base64OutputStream(localBufferedOutputStream, 20);
          idc.a(parambeb, (OutputStream)localObject2);
          ((Base64OutputStream)localObject2).close();
          localBufferedOutputStream.write(13);
          localBufferedOutputStream.write(10);
          localBufferedOutputStream.flush();
        }
        catch (FileNotFoundException parambeb)
        {
          cvm.e("Email", parambeb, "Rfc822Output#writeOneAttachment(), FileNotFoundExceptionwhen sending attachment", new Object[0]);
          continue;
        }
        catch (IOException paramContext)
        {
          cvm.e("Email", paramContext, "Rfc822Output#writeOneAttachment(), IOExceptionwhen sending attachment", new Object[0]);
          throw new bdi(28, "Invalid attachment.", paramContext);
        }
        localOutputStreamWriter.write("\r\n");
        break label675;
        str = n;
        if (!TextUtils.isEmpty(str)) {
          parambeb = Uri.parse(str);
        }
        try
        {
          parambeb = paramContext.getContentResolver().openInputStream(parambeb);
          if (parambeb != null) {
            break label1128;
          }
          parambeb = Uri.parse(((Attachment)localObject2).d());
          parambeb = paramContext.getContentResolver().openInputStream(parambeb);
        }
        catch (FileNotFoundException parambeb)
        {
          parambeb = null;
          cvm.b("Email", "Rfc822Output#writeOneAttachment(), failed to loadcached file, falling back to: %s", new Object[] { ((Attachment)localObject2).d() });
          continue;
        }
        a(localOutputStreamWriter, paramList, true);
        break;
      }
    }
  }
  
  private static void a(Writer paramWriter, OutputStream paramOutputStream, String[] paramArrayOfString)
  {
    int i;
    if (!TextUtils.isEmpty(paramArrayOfString[1]))
    {
      i = 1;
      if (i == 0) {
        break label38;
      }
    }
    label38:
    for (paramArrayOfString = paramArrayOfString[1];; paramArrayOfString = paramArrayOfString[0])
    {
      if (!TextUtils.isEmpty(paramArrayOfString)) {
        break label45;
      }
      paramWriter.write("\r\n");
      return;
      i = 0;
      break;
    }
    label45:
    if (i != 0)
    {
      str = "html";
      str = String.valueOf(str);
      if (str.length() == 0) {
        break label143;
      }
    }
    label143:
    for (String str = "text/".concat(str);; str = new String("text/"))
    {
      a(paramWriter, "Content-Type", String.valueOf(str).concat("; charset=utf-8"));
      a(paramWriter, "Content-Transfer-Encoding", "base64");
      paramWriter.write("\r\n");
      paramArrayOfString = paramArrayOfString.getBytes("UTF-8");
      paramWriter.flush();
      paramOutputStream.write(Base64.encode(paramArrayOfString, 4));
      return;
      str = "plain";
      break;
    }
  }
  
  private static void a(Writer paramWriter, String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      paramWriter.append(paramString1);
      paramWriter.append(": ");
      paramWriter.append(paramString2);
      paramWriter.append("\r\n");
    }
  }
  
  private static void a(Writer paramWriter, String paramString, boolean paramBoolean)
  {
    paramWriter.append("--");
    paramWriter.append(paramString);
    if (paramBoolean) {
      paramWriter.append("--");
    }
    paramWriter.append("\r\n");
  }
  
  private static boolean a(String paramString, int paramInt)
  {
    return (paramString != null) && (paramInt > 0) && (paramInt < paramString.length());
  }
  
  private static void b(Writer paramWriter, String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      paramWriter.append(paramString1);
      paramWriter.append(": ");
      paramWriter.append(bco.b(Address.g(paramString2), paramString1.length() + 2));
      paramWriter.append("\r\n");
    }
  }
}

/* Location:
 * Qualified Name:     bcp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */