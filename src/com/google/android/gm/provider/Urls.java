package com.google.android.gm.provider;

import android.content.ContentResolver;
import android.text.TextUtils;
import com.google.android.gm.provider.protos.GmsProtosMessageTypes;
import com.google.android.gsf.Gservices;
import com.google.common.io.protocol.ProtoBuf;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public class Urls
{
  private String mAccount;
  private URI mUri;
  
  public Urls(String paramString)
  {
    mAccount = paramString;
    mUri = getUri(paramString);
  }
  
  private static boolean accountDomainIsGmail(String paramString)
  {
    return (TextUtils.isEmpty(paramString)) || (paramString.toLowerCase().equals("gmail.com")) || (paramString.toLowerCase().equals("googlemail.com"));
  }
  
  private static String accountGetDomain(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (paramString != null)
    {
      int i = paramString.indexOf("@");
      str1 = str2;
      if (i != -1) {
        str1 = paramString.substring(i + 1);
      }
    }
    return str1;
  }
  
  private void addStandardParams(int paramInt, List<NameValuePair> paramList)
  {
    paramList.add(new BasicNameValuePair("version", Integer.toString(paramInt)));
    paramList.add(new BasicNameValuePair("clientVersion", Integer.toString(25)));
    paramList.add(new BasicNameValuePair("allowAnyVersion", "1"));
  }
  
  public static String buildUri(String paramString, String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    ArrayList localArrayList = new ArrayList(j / 2);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new BasicNameValuePair(paramVarArgs[i], paramVarArgs[(i + 1)]));
      i += 2;
    }
    paramVarArgs = new StringBuilder(paramString);
    if (paramString.indexOf("?") == -1) {
      paramVarArgs.append("?");
    }
    for (;;)
    {
      paramVarArgs.append(URLEncodedUtils.format(localArrayList, "UTF-8"));
      return paramVarArgs.toString();
      if (!paramString.endsWith("&")) {
        paramVarArgs.append("&");
      }
    }
  }
  
  /* Error */
  private void fillEntity(ContentResolver paramContentResolver, ProtoBuf paramProtoBuf, HttpPost paramHttpPost)
  {
    // Byte code:
    //   0: new 123	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 124	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 5
    //   9: aload_2
    //   10: aload 5
    //   12: invokevirtual 130	com/google/common/io/protocol/ProtoBuf:outputTo	(Ljava/io/OutputStream;)V
    //   15: aload_1
    //   16: ldc -124
    //   18: ldc -123
    //   20: invokestatic 139	com/google/android/gsf/Gservices:getInt	(Landroid/content/ContentResolver;Ljava/lang/String;I)I
    //   23: istore 4
    //   25: aload 5
    //   27: invokevirtual 143	java/io/ByteArrayOutputStream:size	()I
    //   30: iload 4
    //   32: if_icmpgt +19 -> 51
    //   35: aload 5
    //   37: invokevirtual 147	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   40: aload_1
    //   41: invokestatic 153	android/net/http/AndroidHttpClient:getCompressedEntity	([BLandroid/content/ContentResolver;)Lorg/apache/http/entity/AbstractHttpEntity;
    //   44: astore_1
    //   45: aload_3
    //   46: aload_1
    //   47: invokevirtual 159	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   50: return
    //   51: new 161	org/apache/http/entity/ByteArrayEntity
    //   54: dup
    //   55: aload 5
    //   57: invokevirtual 147	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   60: invokespecial 164	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
    //   63: astore_1
    //   64: goto -19 -> 45
    //   67: astore_1
    //   68: new 166	java/lang/RuntimeException
    //   71: dup
    //   72: ldc -88
    //   74: invokespecial 169	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	Urls
    //   0	78	1	paramContentResolver	ContentResolver
    //   0	78	2	paramProtoBuf	ProtoBuf
    //   0	78	3	paramHttpPost	HttpPost
    //   23	10	4	i	int
    //   7	49	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   0	45	67	java/io/IOException
    //   45	50	67	java/io/IOException
    //   51	64	67	java/io/IOException
  }
  
  public static Cookie getCookie(String paramString1, String paramString2)
  {
    paramString1 = accountGetDomain(paramString1);
    String str;
    if ((paramString1 != null) && (!accountDomainIsGmail(paramString1))) {
      str = paramString1 + "=";
    }
    for (paramString1 = "GXAS_SEC";; paramString1 = "GX")
    {
      paramString1 = new BasicClientCookie(paramString1, str + paramString2);
      paramString1.setDomain("google.com");
      return paramString1;
      str = "";
    }
  }
  
  public static String getCookieString(String paramString1, String paramString2)
  {
    paramString1 = getCookie(paramString1, paramString2);
    Object localObject = paramString1.getPath();
    paramString2 = paramString1.getDomain();
    StringBuilder localStringBuilder = new StringBuilder(paramString1.getName()).append("=").append(paramString1.getValue()).append("; path=");
    paramString1 = (String)localObject;
    if (localObject == null) {
      paramString1 = "/";
    }
    localObject = localStringBuilder.append(paramString1).append("; domain=");
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "google.com";
    }
    return paramString1;
  }
  
  public static URI getUri(String paramString)
  {
    paramString = accountGetDomain(paramString);
    if ((paramString != null) && (!accountDomainIsGmail(paramString))) {}
    for (paramString = "https://mail.google.com/a/%domain%/g/".replace("%domain%", paramString);; paramString = "https://mail.google.com/mail/g/") {
      return URI.create(paramString);
    }
  }
  
  public static String getUriString(String paramString)
  {
    paramString = accountGetDomain(paramString);
    if ((paramString != null) && (!accountDomainIsGmail(paramString))) {
      return "https://mail.google.com/a/%domain%/g/".replace("%domain%", paramString);
    }
    return "https://mail.google.com/mail/g/";
  }
  
  private URI getUriWithParams(List<NameValuePair> paramList)
  {
    paramList = URLEncodedUtils.format(paramList, "UTF-8");
    if (TextUtils.isEmpty(paramList)) {
      return mUri;
    }
    return URI.create(mUri + "?" + paramList);
  }
  
  public HttpUriRequest getConversationListUrl(ContentResolver paramContentResolver, int paramInt1, String paramString, long paramLong, int paramInt2, int paramInt3)
  {
    if (paramInt1 >= 25)
    {
      ProtoBuf localProtoBuf1 = new ProtoBuf(GmsProtosMessageTypes.REQUEST);
      ProtoBuf localProtoBuf2 = localProtoBuf1.setNewProtoBuf(5);
      localProtoBuf2.setString(1, paramString);
      localProtoBuf2.setLong(2, paramLong);
      localProtoBuf2.setInt(3, paramInt2);
      localProtoBuf2.setInt(4, paramInt3);
      LogUtils.d("Gmail", "getConversationListUrl: query: %s, highestMessageId: %d, maxResults = %d, maxSenders %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      return newProtoRequest(paramContentResolver, paramInt1, 0L, localProtoBuf1, true);
    }
    paramContentResolver = new LinkedList();
    addStandardParams(paramInt1, paramContentResolver);
    paramContentResolver.add(new BasicNameValuePair("view", "query"));
    paramContentResolver.add(new BasicNameValuePair("query", paramString));
    paramContentResolver.add(new BasicNameValuePair("highestMessageId", Long.toString(paramLong)));
    paramContentResolver.add(new BasicNameValuePair("maxResults", Integer.toString(paramInt2)));
    paramContentResolver.add(new BasicNameValuePair("maxSenders", Integer.toString(paramInt3)));
    return new HttpGet(getUriWithParams(paramContentResolver));
  }
  
  public URI getFetchAttachmentUri(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    Object localObject = Gmail.AttachmentOrigin.splitServerExtras(paramString);
    paramString = localObject[1];
    String str = localObject[2];
    localObject = new LinkedList();
    addStandardParams(paramInt1, (List)localObject);
    ((List)localObject).add(new BasicNameValuePair("view", "att"));
    ((List)localObject).add(new BasicNameValuePair("messageId", paramString));
    ((List)localObject).add(new BasicNameValuePair("partId", str));
    ((List)localObject).add(new BasicNameValuePair("maxWidth", Integer.toString(paramInt2)));
    ((List)localObject).add(new BasicNameValuePair("maxHeight", Integer.toString(paramInt2)));
    if (paramBoolean) {}
    for (paramString = "1";; paramString = "0")
    {
      ((List)localObject).add(new BasicNameValuePair("showOriginal", paramString));
      return getUriWithParams((List)localObject);
    }
  }
  
  public HttpUriRequest getGetSyncConfigSuggestionRequest(ContentResolver paramContentResolver, int paramInt1, int paramInt2, int paramInt3, double paramDouble, long paramLong)
  {
    if (paramInt1 >= 25)
    {
      ProtoBuf localProtoBuf = new ProtoBuf(GmsProtosMessageTypes.REQUEST);
      localProtoBuf.setNewProtoBuf(8);
      LogUtils.d("Gmail", "getSyncConfigSuggestion: GetConfigInfo", new Object[0]);
      return newProtoRequest(paramContentResolver, paramInt1, 0L, localProtoBuf, true);
    }
    paramContentResolver = new LinkedList();
    addStandardParams(paramInt1, paramContentResolver);
    paramContentResolver.add(new BasicNameValuePair("view", "configInfo"));
    paramContentResolver.add(new BasicNameValuePair("max_message_count", Long.toString(paramInt2)));
    paramContentResolver.add(new BasicNameValuePair("always_download_label_limit", Long.toString(paramInt3)));
    paramContentResolver.add(new BasicNameValuePair("unread_fraction_limit", Double.toString(paramDouble)));
    paramContentResolver.add(new BasicNameValuePair("recent_label_duration_days", Long.toString(paramLong)));
    return new HttpGet(getUriWithParams(paramContentResolver));
  }
  
  public ProtoBuf getMainSyncRequestProto(ContentResolver paramContentResolver, long paramLong1, long paramLong2, long paramLong3, ArrayList<MailSync.ConversationInfo> paramArrayList, ArrayList<Long> paramArrayList1, ArrayList<Long> paramArrayList2, MailEngine.SyncInfo paramSyncInfo)
  {
    ProtoBuf localProtoBuf1 = new ProtoBuf(GmsProtosMessageTypes.REQUEST);
    ProtoBuf localProtoBuf2 = localProtoBuf1.setNewProtoBuf(4);
    localProtoBuf2.setLong(1, paramLong1);
    localProtoBuf2.setLong(2, paramLong2);
    localProtoBuf2.setInt(3, 200);
    localProtoBuf2.setBool(6, true);
    localProtoBuf2.setBool(8, true);
    localProtoBuf2.setBool(9, true);
    localProtoBuf2.setInt(7, Gservices.getInt(paramContentResolver, "gmail_compression_type", 3));
    localProtoBuf2.setBool(10, true);
    localProtoBuf2.setInt(11, Gservices.getInt(paramContentResolver, "gmail_main_sync_max_conversion_headers", 0));
    localProtoBuf2.setInt(12, 5);
    localProtoBuf1.setNewProtoBuf(7).setLong(2, paramLong3);
    LogUtils.i("Gmail", "MainSyncRequestProto: lowestBkwdConvoId: %d, highestHandledServerOp: %d, normalSync: %b", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(normalSync) });
    Object localObject1 = null;
    int i = 0;
    int j = paramArrayList.size();
    while (i < j)
    {
      MailSync.ConversationInfo localConversationInfo = (MailSync.ConversationInfo)paramArrayList.get(i);
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localProtoBuf1.setNewProtoBuf(3);
      }
      localObject1 = ((ProtoBuf)localObject2).addNewProtoBuf(1);
      ((ProtoBuf)localObject1).setLong(1, id);
      ((ProtoBuf)localObject1).setLong(2, highestFetchedMessageId);
      if (highestFetchedMessageId == 0L) {
        ((ProtoBuf)localObject2).addLong(4, id);
      }
      LogUtils.v("Gmail", "MainSyncRequestProto: fetchConversation: ConvoId: %d, HighestMessageIdOnClient: %d", new Object[] { Long.valueOf(id), Long.valueOf(highestFetchedMessageId) });
      i += 1;
      localObject1 = localObject2;
    }
    i = 0;
    j = paramArrayList2.size();
    while (i < j)
    {
      paramLong1 = ((Long)paramArrayList2.get(i)).longValue();
      paramArrayList = (ArrayList<MailSync.ConversationInfo>)localObject1;
      if (localObject1 == null) {
        paramArrayList = localProtoBuf1.setNewProtoBuf(3);
      }
      paramArrayList.addLong(4, paramLong1);
      LogUtils.d("Gmail", "MainSyncRequestProto: ConversationSyncDirtyConversationId: %d", new Object[] { Long.valueOf(paramLong1) });
      i += 1;
      localObject1 = paramArrayList;
    }
    if (!normalSync) {
      localProtoBuf2.setInt(5, 0);
    }
    for (;;)
    {
      return localProtoBuf1;
      localProtoBuf2.setInt(5, Gservices.getInt(paramContentResolver, "gmail_main_sync_max_forward_sync_items_limit", 1000));
      i = 0;
      j = paramArrayList1.size();
      while (i < j)
      {
        paramLong1 = ((Long)paramArrayList1.get(i)).longValue();
        paramContentResolver = (ContentResolver)localObject1;
        if (localObject1 == null) {
          paramContentResolver = localProtoBuf1.setNewProtoBuf(3);
        }
        paramContentResolver.addLong(2, paramLong1);
        LogUtils.d("Gmail", "MainSyncRequestProto: ConversationSyncMessageId: %d", new Object[] { Long.valueOf(paramLong1) });
        i += 1;
        localObject1 = paramContentResolver;
      }
    }
  }
  
  public HttpUriRequest getStartSyncRequest(ContentResolver paramContentResolver, int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    if (paramInt >= 25)
    {
      ProtoBuf localProtoBuf1 = new ProtoBuf(GmsProtosMessageTypes.REQUEST);
      ProtoBuf localProtoBuf2 = localProtoBuf1.setNewProtoBuf(6);
      localProtoBuf2.setLong(1, paramLong2);
      localProtoBuf2.setLong(2, paramLong3);
      localProtoBuf2.setLong(3, paramLong4);
      localProtoBuf2.setLong(4, paramLong5);
      localProtoBuf2.setBool(5, true);
      localProtoBuf2.setBool(6, true);
      localProtoBuf2.setBool(7, true);
      localProtoBuf2.setBool(9, true);
      LogUtils.i("Gmail", "getStartSyncRequest: handledServerOpId: %d, upperFetchedConvoId: %d, lowerFetchedConvoId: %d, ackedClientOp: %d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Long.valueOf(paramLong5) });
      return newProtoRequest(paramContentResolver, paramInt, paramLong1, localProtoBuf1, true);
    }
    paramContentResolver = new LinkedList();
    addStandardParams(paramInt, paramContentResolver);
    paramContentResolver.add(new BasicNameValuePair("view", "start"));
    paramContentResolver.add(new BasicNameValuePair("client", Long.toString(paramLong1)));
    paramContentResolver.add(new BasicNameValuePair("acked_client_op", Long.toString(paramLong5)));
    paramContentResolver.add(new BasicNameValuePair("server_op", Long.toString(paramLong2)));
    paramContentResolver.add(new BasicNameValuePair("upper_message", Long.toString(paramLong3)));
    paramContentResolver.add(new BasicNameValuePair("lower_message", Long.toString(paramLong4)));
    return new HttpGet(getUriWithParams(paramContentResolver));
  }
  
  public HttpUriRequest getSyncConfigRequest(ContentResolver paramContentResolver, int paramInt, long paramLong1, Set<String> paramSet1, Set<String> paramSet2, long paramLong2, long paramLong3)
  {
    if (paramInt >= 25)
    {
      ProtoBuf localProtoBuf1 = new ProtoBuf(GmsProtosMessageTypes.REQUEST);
      ProtoBuf localProtoBuf2 = localProtoBuf1.setNewProtoBuf(2);
      localProtoBuf2.setInt(1, (int)paramLong2);
      Iterator localIterator = paramSet1.iterator();
      while (localIterator.hasNext()) {
        localProtoBuf2.addString(2, (String)localIterator.next());
      }
      localIterator = paramSet2.iterator();
      while (localIterator.hasNext()) {
        localProtoBuf2.addString(3, (String)localIterator.next());
      }
      LogUtils.d("Gmail", "getSyncConfigRequest: conversationAgeDays: %d, labelsIncluded: %s, labelsPartial: %s", new Object[] { Long.valueOf(paramLong2), paramSet1, paramSet2 });
      return newProtoRequest(paramContentResolver, paramInt, paramLong1, localProtoBuf1, true);
    }
    paramContentResolver = new LinkedList();
    addStandardParams(paramInt, paramContentResolver);
    paramContentResolver.add(new BasicNameValuePair("view", "config"));
    paramContentResolver.add(new BasicNameValuePair("client", Long.toString(paramLong1)));
    paramSet1 = paramSet1.iterator();
    while (paramSet1.hasNext()) {
      paramContentResolver.add(new BasicNameValuePair("labelsIncluded", (String)paramSet1.next()));
    }
    paramSet1 = paramSet2.iterator();
    while (paramSet1.hasNext()) {
      paramContentResolver.add(new BasicNameValuePair("labelsInDuration", (String)paramSet1.next()));
    }
    paramContentResolver.add(new BasicNameValuePair("age", Long.toString(paramLong2)));
    paramContentResolver.add(new BasicNameValuePair("attach_size", Long.toString(paramLong3)));
    paramContentResolver.add(new BasicNameValuePair("includeInDuration", Boolean.toString(true)));
    paramContentResolver.add(new BasicNameValuePair("notificationMethod", "syncServer"));
    return new HttpGet(getUriWithParams(paramContentResolver));
  }
  
  public HttpContext newHttpContext(String paramString, CookieStore paramCookieStore)
  {
    BasicHttpContext localBasicHttpContext = new BasicHttpContext();
    localBasicHttpContext.setAttribute("http.cookie-store", paramCookieStore);
    paramCookieStore.addCookie(getCookie(mAccount, paramString));
    return localBasicHttpContext;
  }
  
  public HttpPost newProtoRequest(ContentResolver paramContentResolver, int paramInt, long paramLong, ProtoBuf paramProtoBuf, boolean paramBoolean)
  {
    if (paramInt < 25) {
      throw new IllegalArgumentException("Cannot make a proto request for version " + paramInt);
    }
    if (paramLong != 0L)
    {
      paramProtoBuf.setLong(1, paramLong);
      LogUtils.d("Gmail", "ProtoRequest: clientid: %d", new Object[] { Long.valueOf(paramLong) });
    }
    Object localObject = new LinkedList();
    addStandardParams(paramInt, (List)localObject);
    localObject = new HttpPost(getUriWithParams((List)localObject));
    if (paramBoolean) {
      fillEntity(paramContentResolver, paramProtoBuf, (HttpPost)localObject);
    }
    return (HttpPost)localObject;
  }
  
  public String serverUrl()
  {
    return mUri.toString();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.Urls
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */