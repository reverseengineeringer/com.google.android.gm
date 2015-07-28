package com.android.mail.ui;

import android.content.Context;
import com.android.mail.providers.Message;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import java.util.Formatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlConversationTemplates
{
  public static final int MESSAGE_PREFIX_LENGTH = "m".length();
  private static final String TAG = LogTag.getLogTag();
  private static final Pattern sAbsoluteImgUrlPattern = Pattern.compile("(<\\s*img\\s+(?:[^>]*\\s+)?)src(\\s*=[\\s'\"]*http)", 10);
  private static String sConversationLower;
  private static String sConversationUpper;
  private static boolean sLoadedTemplates;
  private static String sMessage;
  private static String sSuperCollapsed;
  private StringBuilder mBuilder;
  private Context mContext;
  private Formatter mFormatter;
  private boolean mInProgress = false;
  
  public HtmlConversationTemplates(Context paramContext)
  {
    mContext = paramContext;
    if (!sLoadedTemplates)
    {
      sLoadedTemplates = true;
      sSuperCollapsed = readTemplate(2131230724);
      sMessage = readTemplate(2131230723);
      sConversationUpper = readTemplate(2131230722);
      sConversationLower = readTemplate(2131230721);
    }
  }
  
  private void append(String paramString, Object... paramVarArgs)
  {
    mFormatter.format(paramString, paramVarArgs);
  }
  
  /* Error */
  private String readTemplate(int paramInt)
    throws android.content.res.Resources.NotFoundException
  {
    // Byte code:
    //   0: new 96	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 4
    //   12: new 99	java/io/InputStreamReader
    //   15: dup
    //   16: aload_0
    //   17: getfield 62	com/android/mail/ui/HtmlConversationTemplates:mContext	Landroid/content/Context;
    //   20: invokevirtual 105	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   23: iload_1
    //   24: invokevirtual 111	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   27: ldc 113
    //   29: invokespecial 116	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   32: astore_3
    //   33: sipush 4096
    //   36: newarray <illegal type>
    //   38: astore 4
    //   40: aload_3
    //   41: aload 4
    //   43: invokevirtual 120	java/io/InputStreamReader:read	([C)I
    //   46: istore_2
    //   47: iload_2
    //   48: ifle +72 -> 120
    //   51: aload 5
    //   53: aload 4
    //   55: iconst_0
    //   56: iload_2
    //   57: invokevirtual 123	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: goto -21 -> 40
    //   64: astore 4
    //   66: aload_3
    //   67: ifnull +7 -> 74
    //   70: aload_3
    //   71: invokevirtual 126	java/io/InputStreamReader:close	()V
    //   74: aload 4
    //   76: athrow
    //   77: astore_3
    //   78: new 92	android/content/res/Resources$NotFoundException
    //   81: dup
    //   82: new 96	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   89: ldc -128
    //   91: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: iload_1
    //   95: invokestatic 136	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   98: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: ldc -118
    //   103: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_3
    //   107: invokevirtual 141	java/io/IOException:getMessage	()Ljava/lang/String;
    //   110: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokespecial 147	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   119: athrow
    //   120: aload 5
    //   122: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: astore 4
    //   127: aload_3
    //   128: ifnull +7 -> 135
    //   131: aload_3
    //   132: invokevirtual 126	java/io/InputStreamReader:close	()V
    //   135: aload 4
    //   137: areturn
    //   138: astore_3
    //   139: goto -61 -> 78
    //   142: astore 5
    //   144: aload 4
    //   146: astore_3
    //   147: aload 5
    //   149: astore 4
    //   151: goto -85 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	HtmlConversationTemplates
    //   0	154	1	paramInt	int
    //   46	11	2	i	int
    //   32	39	3	localInputStreamReader	java.io.InputStreamReader
    //   77	55	3	localIOException1	java.io.IOException
    //   138	1	3	localIOException2	java.io.IOException
    //   146	1	3	localObject1	Object
    //   10	44	4	arrayOfChar	char[]
    //   64	11	4	localObject2	Object
    //   125	25	4	localObject3	Object
    //   7	114	5	localStringBuilder	StringBuilder
    //   142	6	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   33	40	64	finally
    //   40	47	64	finally
    //   51	61	64	finally
    //   120	127	64	finally
    //   70	74	77	java/io/IOException
    //   74	77	77	java/io/IOException
    //   131	135	138	java/io/IOException
    //   12	33	142	finally
  }
  
  static String replaceAbsoluteImgUrls(String paramString)
  {
    return sAbsoluteImgUrlPattern.matcher(paramString).replaceAll("$1src='data:' blocked-src$2");
  }
  
  public void appendMessageHtml(Message paramMessage, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    String str1;
    String str2;
    if (paramBoolean1)
    {
      str1 = "block";
      if (!paramBoolean1) {
        break label127;
      }
      str2 = "expanded";
      label16:
      if (!paramBoolean2) {
        break label134;
      }
    }
    label127:
    label134:
    for (String str3 = "mail-show-images";; str3 = "")
    {
      String str5 = paramMessage.getBodyAsHtml();
      String str4 = str5;
      if (!paramBoolean2)
      {
        str4 = str5;
        if (embedsExternalResources) {
          str4 = replaceAbsoluteImgUrls(str5);
        }
      }
      append(sMessage, new Object[] { getMessageDomId(paramMessage), str2, Integer.valueOf(paramInt1), str3, str1, str4, str1, Integer.valueOf(paramInt2) });
      return;
      str1 = "none";
      break;
      str2 = "";
      break label16;
    }
  }
  
  public void appendSuperCollapsedHtml(int paramInt1, int paramInt2)
  {
    if (!mInProgress) {
      throw new IllegalStateException("must call startConversation first");
    }
    append(sSuperCollapsed, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public String emit()
  {
    String str = mFormatter.toString();
    mFormatter = null;
    mBuilder = null;
    return str;
  }
  
  public String endConversation(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!mInProgress) {
      throw new IllegalStateException("must call startConversation first");
    }
    append(sConversationLower, new Object[] { mContext.getString(2131493066), mContext.getString(2131493065), paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    mInProgress = false;
    LogUtils.d(TAG, "rendered conversation of %d bytes, buffer capacity=%d", new Object[] { Integer.valueOf(mBuilder.length() << 1), Integer.valueOf(mBuilder.capacity() << 1) });
    return emit();
  }
  
  public String getMessageDomId(Message paramMessage)
  {
    return "m" + id;
  }
  
  public void reset()
  {
    mBuilder = new StringBuilder(65536);
    mFormatter = new Formatter(mBuilder, null);
  }
  
  public void startConversation(int paramInt1, int paramInt2)
  {
    if (mInProgress) {
      throw new IllegalStateException("must call startConversation first");
    }
    reset();
    append(sConversationUpper, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    mInProgress = true;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.HtmlConversationTemplates
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */