package org.apache.james.mime4j.decoder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.james.mime4j.Log;
import org.apache.james.mime4j.LogFactory;
import org.apache.james.mime4j.util.CharsetUtil;

public class DecoderUtil
{
  private static Log log = LogFactory.getLog(DecoderUtil.class);
  
  public static String decodeB(String paramString1, String paramString2)
    throws UnsupportedEncodingException
  {
    return new String(decodeBase64(paramString1), paramString2);
  }
  
  public static byte[] decodeBase64(String paramString)
  {
    localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramString = new Base64InputStream(new ByteArrayInputStream(paramString.getBytes("US-ASCII")));
      for (;;)
      {
        int i = paramString.read();
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(i);
      }
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException paramString)
    {
      log.error(paramString);
    }
  }
  
  public static byte[] decodeBaseQuotedPrintable(String paramString)
  {
    localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramString = new QuotedPrintableInputStream(new ByteArrayInputStream(paramString.getBytes("US-ASCII")));
      for (;;)
      {
        int i = paramString.read();
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(i);
      }
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException paramString)
    {
      log.error(paramString);
    }
  }
  
  private static String decodeEncodedWord(String paramString, int paramInt1, int paramInt2)
  {
    int i = paramString.indexOf('?', paramInt1 + 2);
    if (i == paramInt2 - 2) {}
    do
    {
      for (;;)
      {
        return null;
        int j = paramString.indexOf('?', i + 1);
        if (j != paramInt2 - 2)
        {
          String str1 = paramString.substring(paramInt1 + 2, i);
          String str2 = paramString.substring(i + 1, j);
          String str3 = paramString.substring(j + 1, paramInt2 - 2);
          String str4 = CharsetUtil.toJavaCharset(str1);
          if (str4 == null)
          {
            if (log.isWarnEnabled())
            {
              log.warn("MIME charset '" + str1 + "' in encoded word '" + paramString.substring(paramInt1, paramInt2) + "' doesn't have a " + "corresponding Java charset");
              return null;
            }
          }
          else if (!CharsetUtil.isDecodingSupported(str4))
          {
            if (log.isWarnEnabled())
            {
              log.warn("Current JDK doesn't support decoding of charset '" + str4 + "' (MIME charset '" + str1 + "' in encoded word '" + paramString.substring(paramInt1, paramInt2) + "')");
              return null;
            }
          }
          else if (str3.length() == 0)
          {
            if (log.isWarnEnabled())
            {
              log.warn("Missing encoded text in encoded word: '" + paramString.substring(paramInt1, paramInt2) + "'");
              return null;
            }
          }
          else {
            try
            {
              if (str2.equalsIgnoreCase("Q")) {
                return decodeQ(str3, str4);
              }
              if (str2.equalsIgnoreCase("B")) {
                return decodeB(str3, str4);
              }
              if (log.isWarnEnabled())
              {
                log.warn("Warning: Unknown encoding in encoded word '" + paramString.substring(paramInt1, paramInt2) + "'");
                return null;
              }
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException)
            {
              if (log.isWarnEnabled())
              {
                log.warn("Unsupported encoding in encoded word '" + paramString.substring(paramInt1, paramInt2) + "'", localUnsupportedEncodingException);
                return null;
              }
            }
            catch (RuntimeException localRuntimeException) {}
          }
        }
      }
    } while (!log.isWarnEnabled());
    log.warn("Could not decode encoded word '" + paramString.substring(paramInt1, paramInt2) + "'", localRuntimeException);
    return null;
  }
  
  public static String decodeEncodedWords(String paramString)
  {
    if (paramString.indexOf("=?") == -1) {
      return paramString;
    }
    int j = 0;
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    int n = paramString.indexOf("=?", j);
    int m = n + 2;
    int k = m;
    if (n != -1)
    {
      int i1 = paramString.indexOf('?', paramString.indexOf(63, m + 2) + 1);
      k = m;
      if (i1 != -1) {
        k = i1 + 1;
      }
    }
    if (n == -1) {}
    for (k = -1;; k = paramString.indexOf("?=", k))
    {
      if (k != -1) {
        break label128;
      }
      if (j == 0) {
        break;
      }
      localStringBuilder.append(paramString.substring(j));
      return localStringBuilder.toString();
    }
    label128:
    k += 2;
    String str1 = paramString.substring(j, n);
    String str2 = decodeEncodedWord(paramString, n, k);
    if (str2 == null)
    {
      localStringBuilder.append(str1);
      localStringBuilder.append(paramString.substring(n, k));
      label176:
      j = k;
      if (str2 == null) {
        break label219;
      }
    }
    label219:
    for (i = 1;; i = 0)
    {
      break;
      if ((i == 0) || (!CharsetUtil.isWhitespace(str1))) {
        localStringBuilder.append(str1);
      }
      localStringBuilder.append(str2);
      break label176;
    }
  }
  
  public static String decodeQ(String paramString1, String paramString2)
    throws UnsupportedEncodingException
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (i < paramString1.length())
    {
      char c = paramString1.charAt(i);
      if (c == '_') {
        localStringBuffer.append("=20");
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuffer.append(c);
      }
    }
    return new String(decodeBaseQuotedPrintable(localStringBuffer.toString()), paramString2);
  }
}

/* Location:
 * Qualified Name:     org.apache.james.mime4j.decoder.DecoderUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */