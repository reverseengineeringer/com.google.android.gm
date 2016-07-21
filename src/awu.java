import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONException;
import org.json.JSONObject;

public class awu
{
  public static final String a = bbw.a;
  HttpClient b;
  
  public awu()
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 20000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 30000);
    HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
    b = new DefaultHttpClient(localBasicHttpParams);
  }
  
  public static awu a(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return new awu();
        if (paramString.equals("google"))
        {
          i = 0;
          continue;
          if (paramString.equals("yahoo"))
          {
            i = 1;
            continue;
            if (paramString.equals("yahoo_v2"))
            {
              i = 2;
              continue;
              if (paramString.equals("microsoft"))
              {
                i = 3;
                continue;
                if (paramString.equals("mail.ru"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("yandex")) {
                    i = 5;
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    return new aww();
    return new awz();
    return new awy();
    return new awx();
    return new axa();
  }
  
  /* Error */
  private static awv a(HttpResponse paramHttpResponse)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 89	awu:c	(Lorg/apache/http/HttpResponse;)Lorg/json/JSONObject;
    //   4: astore_0
    //   5: aload_0
    //   6: ldc 91
    //   8: invokevirtual 97	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   11: astore_2
    //   12: aload_0
    //   13: ldc 99
    //   15: invokevirtual 97	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   18: astore_1
    //   19: aload_0
    //   20: ldc 101
    //   22: invokevirtual 105	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   25: ifeq +29 -> 54
    //   28: aload_0
    //   29: ldc 101
    //   31: invokevirtual 97	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   34: astore_0
    //   35: new 107	awv
    //   38: dup
    //   39: aload_2
    //   40: aload_0
    //   41: aload_1
    //   42: invokestatic 113	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   45: invokevirtual 116	java/lang/Integer:intValue	()I
    //   48: invokespecial 119	awv:<init>	(Ljava/lang/String;Ljava/lang/String;I)V
    //   51: astore_0
    //   52: aload_0
    //   53: areturn
    //   54: aconst_null
    //   55: astore_0
    //   56: goto -21 -> 35
    //   59: astore_0
    //   60: getstatic 15	awu:a	Ljava/lang/String;
    //   63: aload_0
    //   64: ldc 121
    //   66: iconst_1
    //   67: anewarray 4	java/lang/Object
    //   70: dup
    //   71: iconst_0
    //   72: aload_1
    //   73: aastore
    //   74: invokestatic 127	cvm:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   77: pop
    //   78: new 129	bdi
    //   81: dup
    //   82: bipush 24
    //   84: ldc -125
    //   86: aload_0
    //   87: invokespecial 134	bdi:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   90: athrow
    //   91: astore_0
    //   92: new 129	bdi
    //   95: dup
    //   96: bipush 24
    //   98: ldc -120
    //   100: aload_0
    //   101: invokespecial 134	bdi:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	paramHttpResponse	HttpResponse
    //   18	55	1	str1	String
    //   11	29	2	str2	String
    // Exception table:
    //   from	to	target	type
    //   35	52	59	java/lang/NumberFormatException
    //   0	35	91	org/json/JSONException
    //   35	52	91	org/json/JSONException
    //   60	91	91	org/json/JSONException
  }
  
  protected static void a(HttpPost paramHttpPost, bcb parambcb)
  {
    String str = String.valueOf(j);
    parambcb = String.valueOf(k);
    parambcb = String.valueOf(new String(Base64.encode((String.valueOf(str).length() + 1 + String.valueOf(parambcb).length() + str + ":" + parambcb).getBytes(), 2)));
    if (parambcb.length() != 0) {}
    for (parambcb = "Basic ".concat(parambcb);; parambcb = new String("Basic "))
    {
      paramHttpPost.setHeader("Authorization", parambcb);
      return;
    }
  }
  
  private static String b(HttpResponse paramHttpResponse)
  {
    if (bhk.a()) {
      return "Running in Test";
    }
    try
    {
      paramHttpResponse = c(paramHttpResponse).getString("error");
      return paramHttpResponse;
    }
    catch (JSONException paramHttpResponse) {}
    return null;
  }
  
  private static JSONObject c(HttpResponse paramHttpResponse)
  {
    paramHttpResponse = new BufferedReader(new InputStreamReader(paramHttpResponse.getEntity().getContent(), "UTF-8"));
    Object localObject = new StringBuilder();
    for (;;)
    {
      String str = paramHttpResponse.readLine();
      if (str == null) {
        break;
      }
      ((StringBuilder)localObject).append(str).append('\n');
    }
    paramHttpResponse = ((StringBuilder)localObject).toString();
    try
    {
      localObject = new JSONObject(paramHttpResponse);
      return (JSONObject)localObject;
    }
    catch (JSONException localJSONException)
    {
      cvm.b(a, localJSONException, "Invalid JSON: %s", new Object[] { paramHttpResponse });
      throw localJSONException;
    }
  }
  
  public Uri.Builder a(bcb parambcb, String paramString)
  {
    paramString = Uri.parse(c).buildUpon();
    paramString.appendQueryParameter("response_type", g);
    paramString.appendQueryParameter("client_id", j);
    paramString.appendQueryParameter("redirect_uri", h);
    return paramString;
  }
  
  public final awv a(HttpPost paramHttpPost, String paramString1, String paramString2)
  {
    paramHttpPost = b.execute(paramHttpPost);
    int i = paramHttpPost.getStatusLine().getStatusCode();
    if (("microsoft".equals(paramString1)) && (i == 400)) {
      i = 403;
    }
    for (;;)
    {
      paramString1 = String.format(Locale.US, "%s_%s", new Object[] { paramString1, paramString2 });
      buo.a().a("oauth", paramString1, String.valueOf(i), 0L);
      switch (i)
      {
      default: 
        cvm.e(a, "HTTP %d Error getting oauth tokens", new Object[] { Integer.valueOf(i) });
        throw new bdi(19, 36 + "HTTP " + i + " getting oauth token");
      case 200: 
        return a(paramHttpPost);
      }
      cvm.e(a, "HTTP %d: Authentication error getting oauth tokens", new Object[] { Integer.valueOf(i) });
      paramHttpPost = b(paramHttpPost);
      if (paramHttpPost != null)
      {
        paramHttpPost = String.valueOf(paramHttpPost);
        if (paramHttpPost.length() != 0) {
          paramHttpPost = " ".concat(paramHttpPost);
        }
      }
      for (;;)
      {
        throw new bcs(String.valueOf(paramHttpPost).length() + 36 + "HTTP " + i + " getting oauth token" + paramHttpPost);
        paramHttpPost = new String(" ");
        continue;
        paramHttpPost = "";
      }
    }
  }
  
  protected String a(bcb parambcb)
  {
    return h;
  }
  
  public final HttpPost a(Context paramContext, bcb parambcb, String paramString)
  {
    HttpPost localHttpPost = new HttpPost(d);
    a(paramContext, localHttpPost, parambcb);
    paramContext = new ArrayList();
    paramContext.add(new BasicNameValuePair("code", paramString));
    paramContext.add(new BasicNameValuePair("client_id", j));
    paramContext.add(new BasicNameValuePair("client_secret", k));
    paramContext.add(new BasicNameValuePair("redirect_uri", h));
    paramContext.add(new BasicNameValuePair("grant_type", "authorization_code"));
    try
    {
      localHttpPost.setEntity(new UrlEncodedFormEntity(paramContext));
      return localHttpPost;
    }
    catch (UnsupportedEncodingException paramContext)
    {
      cvm.e(a, paramContext, "unsupported encoding", new Object[0]);
      throw new bcs("Unsupported encoding", paramContext);
    }
  }
  
  protected void a(Context paramContext, HttpPost paramHttpPost, bcb parambcb)
  {
    paramHttpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
  }
  
  protected final HttpPost b(Context paramContext, bcb parambcb, String paramString)
  {
    HttpPost localHttpPost = new HttpPost(e);
    a(paramContext, localHttpPost, parambcb);
    paramContext = new ArrayList();
    paramContext.add(new BasicNameValuePair("refresh_token", paramString));
    paramContext.add(new BasicNameValuePair("client_id", j));
    paramContext.add(new BasicNameValuePair("client_secret", k));
    paramContext.add(new BasicNameValuePair("redirect_uri", a(parambcb)));
    paramContext.add(new BasicNameValuePair("grant_type", "refresh_token"));
    try
    {
      localHttpPost.setEntity(new UrlEncodedFormEntity(paramContext));
      return localHttpPost;
    }
    catch (UnsupportedEncodingException paramContext)
    {
      cvm.e(a, paramContext, "unsupported encoding", new Object[0]);
      throw new bcs("Unsupported encoding", paramContext);
    }
  }
}

/* Location:
 * Qualified Name:     awu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */