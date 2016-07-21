import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.android.mail.providers.Account;
import java.util.Iterator;
import java.util.List;

public class cjl
  extends WebViewClient
{
  private static final String a = cvl.a;
  Account b;
  public Activity c;
  
  public cjl(Account paramAccount)
  {
    b = paramAccount;
  }
  
  public static Intent a(Context paramContext, Uri paramUri1, Uri paramUri2, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", paramUri1);
    localIntent.putExtra("original_uri", paramUri2);
    localIntent.putExtra("account_name", paramString);
    paramUri1 = null;
    try
    {
      paramUri2 = paramContext.getPackageManager();
      paramUri1 = paramUri2;
    }
    catch (UnsupportedOperationException paramUri2)
    {
      for (;;)
      {
        cvm.e(a, paramUri2, "Error getting package manager", new Object[0]);
      }
    }
    if (paramUri1 != null)
    {
      paramUri1 = paramUri1.queryIntentActivities(localIntent, 65536);
      paramContext = paramContext.getPackageName();
      paramUri1 = paramUri1.iterator();
      while (paramUri1.hasNext())
      {
        paramUri2 = nextactivityInfo;
        if (paramContext.equals(packageName)) {
          localIntent.setClassName(packageName, name);
        }
      }
    }
    return localIntent;
  }
  
  /* Error */
  public final android.webkit.WebResourceResponse a(Uri paramUri, com.android.mail.browse.ConversationMessage paramConversationMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 119	cxa:c	(Landroid/net/Uri;)Ljava/lang/String;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: aload_2
    //   12: getfield 125	com/android/mail/browse/ConversationMessage:y	Landroid/net/Uri;
    //   15: ifnull -6 -> 9
    //   18: aload_2
    //   19: getfield 125	com/android/mail/browse/ConversationMessage:y	Landroid/net/Uri;
    //   22: aload_1
    //   23: invokestatic 131	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   26: astore_2
    //   27: aload_0
    //   28: getfield 133	cjl:c	Landroid/app/Activity;
    //   31: invokevirtual 139	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   34: astore_1
    //   35: aload_1
    //   36: aload_2
    //   37: getstatic 145	chh:o	[Ljava/lang/String;
    //   40: aconst_null
    //   41: aconst_null
    //   42: aconst_null
    //   43: invokevirtual 151	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   46: astore_2
    //   47: aload_2
    //   48: ifnull -39 -> 9
    //   51: aload_2
    //   52: invokeinterface 156 1 0
    //   57: istore_3
    //   58: iload_3
    //   59: ifne +11 -> 70
    //   62: aload_2
    //   63: invokeinterface 159 1 0
    //   68: aconst_null
    //   69: areturn
    //   70: new 161	com/android/mail/providers/Attachment
    //   73: dup
    //   74: aload_2
    //   75: invokespecial 164	com/android/mail/providers/Attachment:<init>	(Landroid/database/Cursor;)V
    //   78: astore 4
    //   80: aload_2
    //   81: invokeinterface 159 1 0
    //   86: new 166	java/io/FileInputStream
    //   89: dup
    //   90: aload_1
    //   91: aload 4
    //   93: getfield 169	com/android/mail/providers/Attachment:i	Landroid/net/Uri;
    //   96: ldc -85
    //   98: invokevirtual 175	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   101: invokevirtual 181	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   104: invokespecial 184	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   107: astore_1
    //   108: new 186	android/webkit/WebResourceResponse
    //   111: dup
    //   112: aload 4
    //   114: invokevirtual 189	com/android/mail/providers/Attachment:l	()Ljava/lang/String;
    //   117: aconst_null
    //   118: aload_1
    //   119: invokespecial 192	android/webkit/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   122: astore_1
    //   123: aload_1
    //   124: areturn
    //   125: astore_1
    //   126: aload_2
    //   127: invokeinterface 159 1 0
    //   132: aload_1
    //   133: athrow
    //   134: astore_1
    //   135: aconst_null
    //   136: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	cjl
    //   0	137	1	paramUri	Uri
    //   0	137	2	paramConversationMessage	com.android.mail.browse.ConversationMessage
    //   57	2	3	bool	boolean
    //   78	35	4	localAttachment	com.android.mail.providers.Attachment
    // Exception table:
    //   from	to	target	type
    //   51	58	125	finally
    //   70	80	125	finally
    //   86	123	134	java/io/FileNotFoundException
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (c == null) {
      return false;
    }
    paramWebView = Uri.parse(paramString);
    buo.a().a("link_click", bur.a(c, b), paramWebView.getScheme(), 0L);
    if (cxa.b(c, paramWebView, b)) {
      return true;
    }
    if ((b != null) && (!cxa.b(b.B))) {
      paramWebView = a(c, b.B, paramWebView, b.c);
    }
    try
    {
      for (;;)
      {
        paramWebView.setFlags(589824);
        c.startActivity(paramWebView);
        return true;
        paramWebView = new Intent("android.intent.action.VIEW", paramWebView);
        paramWebView.putExtra("com.android.browser.application_id", c.getPackageName());
        paramWebView.putExtra("create_new_tab", true);
        paramWebView.addCategory("android.intent.category.BROWSABLE");
      }
    }
    catch (ActivityNotFoundException paramWebView)
    {
      for (;;)
      {
        cvm.e(a, "No app can handle intent from conversation view.", new Object[0]);
      }
    }
  }
}

/* Location:
 * Qualified Name:     cjl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */