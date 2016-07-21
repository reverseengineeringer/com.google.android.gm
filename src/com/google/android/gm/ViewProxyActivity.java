package com.google.android.gm;

import android.app.Activity;

public class ViewProxyActivity
  extends Activity
{
  /* Error */
  protected void onCreate(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 17	android/app/Activity:onCreate	(Landroid/os/Bundle;)V
    //   5: aload_0
    //   6: invokevirtual 21	com/google/android/gm/ViewProxyActivity:getIntent	()Landroid/content/Intent;
    //   9: ldc 23
    //   11: invokevirtual 29	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   14: checkcast 31	android/net/Uri
    //   17: astore_3
    //   18: aload_0
    //   19: invokevirtual 21	com/google/android/gm/ViewProxyActivity:getIntent	()Landroid/content/Intent;
    //   22: ldc 33
    //   24: invokevirtual 37	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   27: astore_2
    //   28: new 25	android/content/Intent
    //   31: dup
    //   32: ldc 39
    //   34: aload_3
    //   35: invokespecial 42	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   38: astore_1
    //   39: aload_1
    //   40: ldc 43
    //   42: invokevirtual 47	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   45: pop
    //   46: aload_1
    //   47: ldc 49
    //   49: aload_0
    //   50: invokevirtual 53	com/google/android/gm/ViewProxyActivity:getPackageName	()Ljava/lang/String;
    //   53: invokevirtual 57	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   56: pop
    //   57: aload_1
    //   58: ldc 59
    //   60: iconst_1
    //   61: invokevirtual 62	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   64: pop
    //   65: aload_1
    //   66: ldc 64
    //   68: invokevirtual 68	android/content/Intent:addCategory	(Ljava/lang/String;)Landroid/content/Intent;
    //   71: pop
    //   72: aload_3
    //   73: invokevirtual 71	android/net/Uri:getHost	()Ljava/lang/String;
    //   76: astore_3
    //   77: aload_0
    //   78: invokevirtual 75	com/google/android/gm/ViewProxyActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   81: aload_3
    //   82: invokestatic 81	dyp:a	(Landroid/content/ContentResolver;Ljava/lang/String;)Z
    //   85: ifeq +126 -> 211
    //   88: ldc 83
    //   90: invokestatic 89	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   93: astore_3
    //   94: new 91	java/util/Random
    //   97: dup
    //   98: invokespecial 92	java/util/Random:<init>	()V
    //   101: invokevirtual 96	java/util/Random:nextLong	()J
    //   104: invokestatic 102	java/lang/Long:toString	(J)Ljava/lang/String;
    //   107: astore 4
    //   109: ldc 104
    //   111: invokestatic 110	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   114: astore 5
    //   116: aload_3
    //   117: new 112	java/lang/StringBuilder
    //   120: dup
    //   121: aload 4
    //   123: invokestatic 110	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   126: invokevirtual 116	java/lang/String:length	()I
    //   129: iconst_0
    //   130: iadd
    //   131: aload_2
    //   132: invokestatic 110	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   135: invokevirtual 116	java/lang/String:length	()I
    //   138: iadd
    //   139: aload 5
    //   141: invokestatic 110	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   144: invokevirtual 116	java/lang/String:length	()I
    //   147: iadd
    //   148: invokespecial 119	java/lang/StringBuilder:<init>	(I)V
    //   151: aload 4
    //   153: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_2
    //   157: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload 5
    //   162: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokevirtual 129	java/lang/String:getBytes	()[B
    //   171: invokevirtual 133	java/security/MessageDigest:update	([B)V
    //   174: aload_1
    //   175: ldc -121
    //   177: aload 4
    //   179: invokevirtual 57	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   182: pop
    //   183: aload_1
    //   184: ldc -119
    //   186: aload_3
    //   187: invokevirtual 139	java/security/MessageDigest:digest	()[B
    //   190: invokevirtual 142	android/content/Intent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   193: pop
    //   194: aload_2
    //   195: invokestatic 147	com/google/android/gm/provider/MailProvider:a	(Ljava/lang/String;)Landroid/net/Uri;
    //   198: astore_2
    //   199: aload_2
    //   200: ifnull +11 -> 211
    //   203: aload_1
    //   204: ldc -107
    //   206: aload_2
    //   207: invokevirtual 152	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   210: pop
    //   211: aload_0
    //   212: aload_1
    //   213: invokevirtual 156	com/google/android/gm/ViewProxyActivity:startActivity	(Landroid/content/Intent;)V
    //   216: aload_0
    //   217: invokevirtual 159	com/google/android/gm/ViewProxyActivity:finish	()V
    //   220: return
    //   221: astore_2
    //   222: getstatic 164	cvl:a	Ljava/lang/String;
    //   225: aload_2
    //   226: ldc -90
    //   228: iconst_0
    //   229: anewarray 168	java/lang/Object
    //   232: invokestatic 174	dri:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   235: pop
    //   236: goto -25 -> 211
    //   239: astore_1
    //   240: goto -24 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	ViewProxyActivity
    //   0	243	1	paramBundle	android.os.Bundle
    //   27	180	2	localObject1	Object
    //   221	5	2	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   17	170	3	localObject2	Object
    //   107	71	4	str1	String
    //   114	47	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   88	199	221	java/security/NoSuchAlgorithmException
    //   203	211	221	java/security/NoSuchAlgorithmException
    //   211	216	239	android/content/ActivityNotFoundException
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.ViewProxyActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */