package com.google.android.gm;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gm.provider.Urls;
import com.google.android.gsf.Gservices;

public class GviewActivity
  extends GmailBaseActivity
{
  private GviewAsyncTask mGviewAsyncTask;
  private boolean mProgressDialogCreated;
  private WebView mWebView;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130968646);
    mWebView = ((WebView)findViewById(2131755200));
    paramBundle = mWebView.getSettings();
    paramBundle.setSavePassword(false);
    paramBundle.setSaveFormData(false);
    paramBundle.setJavaScriptEnabled(true);
    paramBundle.setSupportZoom(true);
    paramBundle.setBlockNetworkImage(false);
    mWebView.setScrollBarStyle(0);
    mWebView.setWebViewClient(new WebViewClient()
    {
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        return false;
      }
    });
    Object localObject = getIntent().getData();
    paramBundle = ((Uri)localObject).getQueryParameter("account");
    String str1 = ((Uri)localObject).getQueryParameter("serverMessageId");
    String str2 = ((Uri)localObject).getQueryParameter("attId");
    localObject = ((Uri)localObject).getQueryParameter("mimeType");
    str1 = String.format(Gservices.getString(getContentResolver(), "gmail_gview_url", "https://docs.google.com/viewer?embedded=true&a=v&pid=gmail&user=%s&thid=%s&attid=%s&mt=%s"), new Object[] { paramBundle, str1, str2, localObject });
    showDialog(1);
    mGviewAsyncTask = new GviewAsyncTask(this, paramBundle, mWebView, str1);
    mGviewAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }
  
  protected Dialog onCreateDialog(int paramInt, Bundle paramBundle)
  {
    if (paramInt == 1)
    {
      paramBundle = new ProgressDialog(this);
      paramBundle.setTitle(2131492989);
      paramBundle.setMessage(getResources().getString(2131492990));
      paramBundle.setIndeterminate(true);
      paramBundle.setCancelable(true);
      paramBundle.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          if (mGviewAsyncTask.isLoading())
          {
            mGviewAsyncTask.cancel(true);
            finish();
          }
        }
      });
      mProgressDialogCreated = true;
      return paramBundle;
    }
    if (paramInt == 2) {
      new AlertDialog.Builder(this).setPositiveButton(2131493074, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          if (mProgressDialogCreated) {
            dismissDialog(1);
          }
          finish();
        }
      }).setMessage(getResources().getString(2131493302)).create();
    }
    throw new AssertionError("Invalid dialog ID in GviewActivity: " + paramInt);
  }
  
  protected void onDestroy()
  {
    mWebView.destroy();
    super.onDestroy();
  }
  
  private class GviewAsyncTask
    extends AsyncTask<Void, Void, String>
  {
    private final String mAccount;
    private final Activity mActivity;
    private boolean mLoading;
    private final String mUrl;
    private final WebView mWebView;
    
    GviewAsyncTask(Activity paramActivity, String paramString1, WebView paramWebView, String paramString2)
    {
      mActivity = paramActivity;
      mAccount = paramString1;
      mWebView = paramWebView;
      mUrl = paramString2;
      mLoading = true;
    }
    
    /* Error */
    protected String doInBackground(Void... paramVarArgs)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 11
      //   3: aconst_null
      //   4: astore 12
      //   6: aconst_null
      //   7: astore 13
      //   9: aconst_null
      //   10: astore_1
      //   11: aconst_null
      //   12: astore 9
      //   14: aconst_null
      //   15: astore 10
      //   17: aconst_null
      //   18: astore 4
      //   20: aconst_null
      //   21: astore 8
      //   23: aload_1
      //   24: astore 5
      //   26: aload 11
      //   28: astore 6
      //   30: aload 12
      //   32: astore 7
      //   34: aload 13
      //   36: astore_2
      //   37: aload 4
      //   39: astore_3
      //   40: new 52	android/accounts/Account
      //   43: dup
      //   44: aload_0
      //   45: getfield 30	com/google/android/gm/GviewActivity$GviewAsyncTask:mAccount	Ljava/lang/String;
      //   48: ldc 54
      //   50: invokespecial 57	android/accounts/Account:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   53: astore 15
      //   55: aload_1
      //   56: astore 5
      //   58: aload 11
      //   60: astore 6
      //   62: aload 12
      //   64: astore 7
      //   66: aload 13
      //   68: astore_2
      //   69: aload 4
      //   71: astore_3
      //   72: aload_0
      //   73: getfield 28	com/google/android/gm/GviewActivity$GviewAsyncTask:mActivity	Landroid/app/Activity;
      //   76: invokestatic 63	android/accounts/AccountManager:get	(Landroid/content/Context;)Landroid/accounts/AccountManager;
      //   79: aload 15
      //   81: ldc 65
      //   83: iconst_0
      //   84: invokevirtual 69	android/accounts/AccountManager:blockingGetAuthToken	(Landroid/accounts/Account;Ljava/lang/String;Z)Ljava/lang/String;
      //   87: astore 14
      //   89: aload_1
      //   90: astore 5
      //   92: aload 11
      //   94: astore 6
      //   96: aload 12
      //   98: astore 7
      //   100: aload 13
      //   102: astore_2
      //   103: aload 4
      //   105: astore_3
      //   106: aload_0
      //   107: getfield 28	com/google/android/gm/GviewActivity$GviewAsyncTask:mActivity	Landroid/app/Activity;
      //   110: invokestatic 63	android/accounts/AccountManager:get	(Landroid/content/Context;)Landroid/accounts/AccountManager;
      //   113: aload 15
      //   115: ldc 71
      //   117: iconst_0
      //   118: invokevirtual 69	android/accounts/AccountManager:blockingGetAuthToken	(Landroid/accounts/Account;Ljava/lang/String;Z)Ljava/lang/String;
      //   121: astore 15
      //   123: aload_1
      //   124: astore 5
      //   126: aload 11
      //   128: astore 6
      //   130: aload 12
      //   132: astore 7
      //   134: aload 13
      //   136: astore_2
      //   137: aload 4
      //   139: astore_3
      //   140: new 73	com/google/android/common/http/GoogleHttpClient
      //   143: dup
      //   144: aload_0
      //   145: getfield 28	com/google/android/gm/GviewActivity$GviewAsyncTask:mActivity	Landroid/app/Activity;
      //   148: ldc 75
      //   150: iconst_1
      //   151: invokespecial 78	com/google/android/common/http/GoogleHttpClient:<init>	(Landroid/content/Context;Ljava/lang/String;Z)V
      //   154: new 80	org/apache/http/client/methods/HttpPost
      //   157: dup
      //   158: ldc 82
      //   160: iconst_4
      //   161: anewarray 84	java/lang/String
      //   164: dup
      //   165: iconst_0
      //   166: ldc 65
      //   168: aastore
      //   169: dup
      //   170: iconst_1
      //   171: aload 14
      //   173: aastore
      //   174: dup
      //   175: iconst_2
      //   176: ldc 71
      //   178: aastore
      //   179: dup
      //   180: iconst_3
      //   181: aload 15
      //   183: aastore
      //   184: invokestatic 90	com/google/android/gm/provider/Urls:buildUri	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
      //   187: invokespecial 93	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
      //   190: invokeinterface 99 2 0
      //   195: invokeinterface 105 1 0
      //   200: astore_1
      //   201: aload_1
      //   202: astore 5
      //   204: aload_1
      //   205: astore 6
      //   207: aload_1
      //   208: astore 7
      //   210: aload_1
      //   211: astore_2
      //   212: aload 4
      //   214: astore_3
      //   215: new 107	java/io/ByteArrayOutputStream
      //   218: dup
      //   219: aload_1
      //   220: invokeinterface 113 1 0
      //   225: l2i
      //   226: invokespecial 116	java/io/ByteArrayOutputStream:<init>	(I)V
      //   229: astore 4
      //   231: aload_1
      //   232: aload 4
      //   234: invokeinterface 120 2 0
      //   239: aload 4
      //   241: ldc 122
      //   243: invokevirtual 126	java/io/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
      //   246: invokevirtual 130	java/lang/String:trim	()Ljava/lang/String;
      //   249: astore_2
      //   250: aload_1
      //   251: ifnull +9 -> 260
      //   254: aload_1
      //   255: invokeinterface 133 1 0
      //   260: aload 4
      //   262: ifnull +8 -> 270
      //   265: aload 4
      //   267: invokevirtual 136	java/io/ByteArrayOutputStream:close	()V
      //   270: aload_2
      //   271: areturn
      //   272: astore 4
      //   274: aload 8
      //   276: astore_1
      //   277: aload 5
      //   279: astore_2
      //   280: aload_1
      //   281: astore_3
      //   282: ldc -118
      //   284: ldc -116
      //   286: iconst_1
      //   287: anewarray 142	java/lang/Object
      //   290: dup
      //   291: iconst_0
      //   292: aload 4
      //   294: invokevirtual 144	android/accounts/AuthenticatorException:toString	()Ljava/lang/String;
      //   297: aastore
      //   298: invokestatic 150	com/google/android/gm/provider/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
      //   301: pop
      //   302: aload 5
      //   304: ifnull +10 -> 314
      //   307: aload 5
      //   309: invokeinterface 133 1 0
      //   314: aload_1
      //   315: ifnull +7 -> 322
      //   318: aload_1
      //   319: invokevirtual 136	java/io/ByteArrayOutputStream:close	()V
      //   322: aconst_null
      //   323: areturn
      //   324: astore 4
      //   326: aload 9
      //   328: astore_1
      //   329: aload 6
      //   331: astore_2
      //   332: aload_1
      //   333: astore_3
      //   334: ldc -118
      //   336: ldc -116
      //   338: iconst_1
      //   339: anewarray 142	java/lang/Object
      //   342: dup
      //   343: iconst_0
      //   344: aload 4
      //   346: invokevirtual 151	java/io/IOException:toString	()Ljava/lang/String;
      //   349: aastore
      //   350: invokestatic 150	com/google/android/gm/provider/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
      //   353: pop
      //   354: aload 6
      //   356: ifnull +10 -> 366
      //   359: aload 6
      //   361: invokeinterface 133 1 0
      //   366: aload_1
      //   367: ifnull -45 -> 322
      //   370: aload_1
      //   371: invokevirtual 136	java/io/ByteArrayOutputStream:close	()V
      //   374: goto -52 -> 322
      //   377: astore_1
      //   378: goto -56 -> 322
      //   381: astore 4
      //   383: aload 10
      //   385: astore_1
      //   386: aload 7
      //   388: astore_2
      //   389: aload_1
      //   390: astore_3
      //   391: ldc -118
      //   393: ldc -116
      //   395: iconst_1
      //   396: anewarray 142	java/lang/Object
      //   399: dup
      //   400: iconst_0
      //   401: aload 4
      //   403: invokevirtual 152	android/accounts/OperationCanceledException:toString	()Ljava/lang/String;
      //   406: aastore
      //   407: invokestatic 150	com/google/android/gm/provider/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
      //   410: pop
      //   411: aload 7
      //   413: ifnull +10 -> 423
      //   416: aload 7
      //   418: invokeinterface 133 1 0
      //   423: aload_1
      //   424: ifnull -102 -> 322
      //   427: aload_1
      //   428: invokevirtual 136	java/io/ByteArrayOutputStream:close	()V
      //   431: goto -109 -> 322
      //   434: astore_1
      //   435: goto -113 -> 322
      //   438: astore_1
      //   439: aload_2
      //   440: ifnull +9 -> 449
      //   443: aload_2
      //   444: invokeinterface 133 1 0
      //   449: aload_3
      //   450: ifnull +7 -> 457
      //   453: aload_3
      //   454: invokevirtual 136	java/io/ByteArrayOutputStream:close	()V
      //   457: aload_1
      //   458: athrow
      //   459: astore_1
      //   460: goto -200 -> 260
      //   463: astore_1
      //   464: goto -194 -> 270
      //   467: astore_2
      //   468: goto -154 -> 314
      //   471: astore_1
      //   472: goto -150 -> 322
      //   475: astore_2
      //   476: goto -110 -> 366
      //   479: astore_2
      //   480: goto -57 -> 423
      //   483: astore_2
      //   484: goto -35 -> 449
      //   487: astore_2
      //   488: goto -31 -> 457
      //   491: astore 5
      //   493: aload 4
      //   495: astore_3
      //   496: aload_1
      //   497: astore_2
      //   498: aload 5
      //   500: astore_1
      //   501: goto -62 -> 439
      //   504: astore_3
      //   505: aload 4
      //   507: astore_2
      //   508: aload_3
      //   509: astore 4
      //   511: aload_1
      //   512: astore 7
      //   514: aload_2
      //   515: astore_1
      //   516: goto -130 -> 386
      //   519: astore_3
      //   520: aload 4
      //   522: astore_2
      //   523: aload_3
      //   524: astore 4
      //   526: aload_1
      //   527: astore 6
      //   529: aload_2
      //   530: astore_1
      //   531: goto -202 -> 329
      //   534: astore_3
      //   535: aload 4
      //   537: astore_2
      //   538: aload_3
      //   539: astore 4
      //   541: aload_1
      //   542: astore 5
      //   544: aload_2
      //   545: astore_1
      //   546: goto -269 -> 277
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	549	0	this	GviewAsyncTask
      //   0	549	1	paramVarArgs	Void[]
      //   36	408	2	localObject1	Object
      //   467	1	2	localIOException1	java.io.IOException
      //   475	1	2	localIOException2	java.io.IOException
      //   479	1	2	localIOException3	java.io.IOException
      //   483	1	2	localIOException4	java.io.IOException
      //   487	1	2	localIOException5	java.io.IOException
      //   497	48	2	localObject2	Object
      //   39	457	3	localObject3	Object
      //   504	5	3	localOperationCanceledException1	android.accounts.OperationCanceledException
      //   519	5	3	localIOException6	java.io.IOException
      //   534	5	3	localAuthenticatorException1	android.accounts.AuthenticatorException
      //   18	248	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
      //   272	21	4	localAuthenticatorException2	android.accounts.AuthenticatorException
      //   324	21	4	localIOException7	java.io.IOException
      //   381	125	4	localOperationCanceledException2	android.accounts.OperationCanceledException
      //   509	31	4	localObject4	Object
      //   24	284	5	arrayOfVoid1	Void[]
      //   491	8	5	localObject5	Object
      //   542	1	5	arrayOfVoid2	Void[]
      //   28	500	6	localObject6	Object
      //   32	481	7	localObject7	Object
      //   21	254	8	localObject8	Object
      //   12	315	9	localObject9	Object
      //   15	369	10	localObject10	Object
      //   1	126	11	localObject11	Object
      //   4	127	12	localObject12	Object
      //   7	128	13	localObject13	Object
      //   87	85	14	str	String
      //   53	129	15	localObject14	Object
      // Exception table:
      //   from	to	target	type
      //   40	55	272	android/accounts/AuthenticatorException
      //   72	89	272	android/accounts/AuthenticatorException
      //   106	123	272	android/accounts/AuthenticatorException
      //   140	201	272	android/accounts/AuthenticatorException
      //   215	231	272	android/accounts/AuthenticatorException
      //   40	55	324	java/io/IOException
      //   72	89	324	java/io/IOException
      //   106	123	324	java/io/IOException
      //   140	201	324	java/io/IOException
      //   215	231	324	java/io/IOException
      //   370	374	377	java/io/IOException
      //   40	55	381	android/accounts/OperationCanceledException
      //   72	89	381	android/accounts/OperationCanceledException
      //   106	123	381	android/accounts/OperationCanceledException
      //   140	201	381	android/accounts/OperationCanceledException
      //   215	231	381	android/accounts/OperationCanceledException
      //   427	431	434	java/io/IOException
      //   40	55	438	finally
      //   72	89	438	finally
      //   106	123	438	finally
      //   140	201	438	finally
      //   215	231	438	finally
      //   282	302	438	finally
      //   334	354	438	finally
      //   391	411	438	finally
      //   254	260	459	java/io/IOException
      //   265	270	463	java/io/IOException
      //   307	314	467	java/io/IOException
      //   318	322	471	java/io/IOException
      //   359	366	475	java/io/IOException
      //   416	423	479	java/io/IOException
      //   443	449	483	java/io/IOException
      //   453	457	487	java/io/IOException
      //   231	250	491	finally
      //   231	250	504	android/accounts/OperationCanceledException
      //   231	250	519	java/io/IOException
      //   231	250	534	android/accounts/AuthenticatorException
    }
    
    public boolean isLoading()
    {
      return mLoading;
    }
    
    protected void onPostExecute(String paramString)
    {
      if (mActivity.isFinishing()) {
        return;
      }
      mLoading = false;
      if (mProgressDialogCreated) {
        mActivity.dismissDialog(1);
      }
      if (paramString != null)
      {
        mWebView.loadUrl(Urls.buildUri("https://www.google.com/accounts/TokenAuth?service=writely&source=gmail", new String[] { "auth", paramString, "continue", mUrl }));
        return;
      }
      mActivity.showDialog(2);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.GviewActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */