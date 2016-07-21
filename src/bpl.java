import android.net.Uri;
import android.util.Xml;
import com.android.emailcommon.provider.HostAuth;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.entity.StringEntity;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class bpl
  extends bqc
{
  static double a = -1.0D;
  static imw[] b;
  final int c;
  public HostAuth d;
  public String e;
  private final int k;
  private final String l;
  private final String m;
  private final String n;
  private final String o;
  
  /* Error */
  public bpl(android.content.Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: new 30	com/android/emailcommon/provider/HostAuth
    //   3: dup
    //   4: invokespecial 32	com/android/emailcommon/provider/HostAuth:<init>	()V
    //   7: astore 8
    //   9: aload 8
    //   11: aload 5
    //   13: putfield 35	com/android/emailcommon/provider/HostAuth:f	Ljava/lang/String;
    //   16: aload 8
    //   18: aload 6
    //   20: putfield 38	com/android/emailcommon/provider/HostAuth:g	Ljava/lang/String;
    //   23: aload 8
    //   25: sipush 443
    //   28: putfield 40	com/android/emailcommon/provider/HostAuth:d	I
    //   31: aload 8
    //   33: getstatic 44	bnq:e	Ljava/lang/String;
    //   36: putfield 46	com/android/emailcommon/provider/HostAuth:b	Ljava/lang/String;
    //   39: aload 8
    //   41: iconst_5
    //   42: putfield 48	com/android/emailcommon/provider/HostAuth:e	I
    //   45: new 50	com/android/emailcommon/provider/Account
    //   48: dup
    //   49: invokespecial 51	com/android/emailcommon/provider/Account:<init>	()V
    //   52: astore 9
    //   54: aload 9
    //   56: aload 7
    //   58: putfield 53	com/android/emailcommon/provider/Account:d	Ljava/lang/String;
    //   61: aload 9
    //   63: aload 8
    //   65: putfield 56	com/android/emailcommon/provider/Account:t	Lcom/android/emailcommon/provider/HostAuth;
    //   68: aload_0
    //   69: aload_1
    //   70: aload 9
    //   72: invokespecial 59	bqc:<init>	(Landroid/content/Context;Lcom/android/emailcommon/provider/Account;)V
    //   75: aload_0
    //   76: iload_3
    //   77: putfield 61	bpl:c	I
    //   80: aload_0
    //   81: iload 4
    //   83: putfield 63	bpl:k	I
    //   86: aload_0
    //   87: aload_2
    //   88: putfield 65	bpl:l	Ljava/lang/String;
    //   91: aload_0
    //   92: aload 5
    //   94: putfield 67	bpl:m	Ljava/lang/String;
    //   97: aload_0
    //   98: aload 6
    //   100: putfield 69	bpl:n	Ljava/lang/String;
    //   103: aload_0
    //   104: aload 7
    //   106: putfield 71	bpl:o	Ljava/lang/String;
    //   109: aload_0
    //   110: aload_0
    //   111: getfield 74	bpl:g	Lcom/android/emailcommon/provider/Account;
    //   114: getfield 56	com/android/emailcommon/provider/Account:t	Lcom/android/emailcommon/provider/HostAuth;
    //   117: putfield 76	bpl:d	Lcom/android/emailcommon/provider/HostAuth;
    //   120: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	bpl
    //   0	121	1	paramContext	android.content.Context
    //   0	121	2	paramString1	String
    //   0	121	3	paramInt1	int
    //   0	121	4	paramInt2	int
    //   0	121	5	paramString2	String
    //   0	121	6	paramString3	String
    //   0	121	7	paramString4	String
    //   7	57	8	localHostAuth	HostAuth
    //   52	19	9	localAccount	com.android.emailcommon.provider.Account
  }
  
  private static HostAuth a(InputStream paramInputStream)
  {
    Object localObject1 = null;
    XmlPullParser localXmlPullParser;
    try
    {
      localObject2 = XmlPullParserFactory.newInstance();
      ((XmlPullParserFactory)localObject2).setNamespaceAware(true);
      localXmlPullParser = ((XmlPullParserFactory)localObject2).newPullParser();
      localXmlPullParser.setInput(paramInputStream, "UTF-8");
      if (localXmlPullParser.getEventType() != 0)
      {
        cvm.b("Exchange", "EasAutodiscover.parseAutodiscover: Incorrect event type", new Object[0]);
        return null;
      }
      if (localXmlPullParser.next() != 2)
      {
        cvm.b("Exchange", "EasAutodiscover.parseAutodiscover: Missing START_TAG", new Object[0]);
        return null;
      }
    }
    catch (XmlPullParserException paramInputStream)
    {
      cvm.b("Exchange", "EasAutodiscover.parseAd: Parser error - %s", new Object[] { paramInputStream });
      return null;
      if (!"Autodiscover".equals(localXmlPullParser.getName()))
      {
        cvm.b("Exchange", "EasAutodiscover.parseAutodiscover: Missing %s tag name", new Object[] { "Autodiscover" });
        return null;
      }
    }
    catch (IOException paramInputStream)
    {
      cvm.b("Exchange", "EasAutodiscover.parseError: IOException, failed to parse", new Object[0]);
      return null;
    }
    Object localObject2 = new HostAuth();
    do
    {
      i = localXmlPullParser.nextTag();
      if (i == 3)
      {
        paramInputStream = (InputStream)localObject1;
        if ("Autodiscover".equals(localXmlPullParser.getName())) {
          break;
        }
      }
    } while ((i != 2) || (!"Response".equals(localXmlPullParser.getName())));
    label206:
    do
    {
      i = localXmlPullParser.next();
      if ((i == 3) && (localXmlPullParser.getName().equals("Response"))) {
        break;
      }
    } while (i != 2);
    paramInputStream = localXmlPullParser.getName();
    int i = -1;
    switch (paramInputStream.hashCode())
    {
    case 2645995: 
    case 1955883606: 
    case 67232232: 
      for (;;)
      {
        i = localXmlPullParser.next();
        if ((i == 3) && (localXmlPullParser.getName().equals("User"))) {
          break;
        }
        if (i == 2)
        {
          paramInputStream = localXmlPullParser.getName();
          if (paramInputStream.equals("EMailAddress"))
          {
            cvm.b("Exchange", "EasAutodiscover.parseUser: Email=%s", new Object[] { localXmlPullParser.nextText() });
            continue;
            if (!paramInputStream.equals("User")) {
              break label812;
            }
            i = 0;
            break label812;
            if (!paramInputStream.equals("Action")) {
              break label812;
            }
            i = 1;
            break label812;
            if (!paramInputStream.equals("Error")) {
              break label812;
            }
            i = 2;
            break label812;
          }
          else if (paramInputStream.equals("DisplayName"))
          {
            cvm.b("Exchange", "EasAutodiscover.parseUser: DisplayName=%s", new Object[] { localXmlPullParser.nextText() });
          }
        }
      }
    }
    for (;;)
    {
      i = localXmlPullParser.next();
      if ((i == 3) && (localXmlPullParser.getName().equals("Action"))) {
        break label206;
      }
      if (i == 2)
      {
        paramInputStream = localXmlPullParser.getName();
        i = -1;
        switch (paramInputStream.hashCode())
        {
        case 67232232: 
          a(localXmlPullParser);
          continue;
          if (paramInputStream.equals("Error")) {
            i = 0;
          }
          break;
        case -711500804: 
          if (paramInputStream.equals("Redirect")) {
            i = 1;
          }
          break;
        case 1499275331: 
          if (paramInputStream.equals("Settings"))
          {
            i = 2;
            break label843;
            cvm.b("Exchange", "EasAutodiscover.parseAction: Redirect=%s", new Object[] { localXmlPullParser.nextText() });
            continue;
            do
            {
              i = localXmlPullParser.next();
              if ((i == 3) && (localXmlPullParser.getName().equals("Settings"))) {
                break;
              }
            } while ((i != 2) || (!localXmlPullParser.getName().equals("Server")));
            i = 0;
            for (;;)
            {
              int j = localXmlPullParser.next();
              if ((j == 3) && (localXmlPullParser.getName().equals("Server"))) {
                break;
              }
              if (j == 2)
              {
                paramInputStream = localXmlPullParser.getName();
                if (paramInputStream.equals("Type"))
                {
                  if (localXmlPullParser.nextText().equals("MobileSync")) {
                    i = 1;
                  }
                }
                else if ((i != 0) && (paramInputStream.equals("Url")))
                {
                  paramInputStream = localXmlPullParser.nextText();
                  if (paramInputStream != null)
                  {
                    cvm.b("Exchange", "EasAutodiscover.parseServer: URL=%s", new Object[] { paramInputStream });
                    paramInputStream = Uri.parse(paramInputStream);
                    c = paramInputStream.getHost();
                    j = paramInputStream.getPort();
                    if (j != -1) {
                      d = j;
                    }
                  }
                }
              }
            }
            a(localXmlPullParser);
            break label206;
            paramInputStream = c;
            if (paramInputStream == null) {
              break;
            }
            paramInputStream = (InputStream)localObject2;
            return paramInputStream;
            switch (i)
            {
            }
          }
          break;
        default: 
          label812:
          label843:
          switch (i)
          {
          }
          break;
        }
      }
    }
  }
  
  private static ing a(ing[] paramArrayOfing)
  {
    Object localObject = new ArrayList();
    int i5 = paramArrayOfing.length;
    int i2 = 0;
    int i1 = 0;
    int j = 0;
    int i = 65536;
    ing localing;
    int i4;
    int i3;
    if (i2 < i5)
    {
      localing = paramArrayOfing[i2];
      if (localing == null) {
        break label325;
      }
      i4 = a;
      i3 = b;
      cvm.b("Exchange", "EasAutodiscover: srvRecords[%s]=(%s, %s, Priority=%s, Weight=%s)", new Object[] { Integer.valueOf(i1), c, c, Integer.valueOf(i4), Integer.valueOf(i3) });
      if (i4 == i)
      {
        ((List)localObject).add(localing);
        i3 = b + j;
        j = i;
        i = i3;
      }
    }
    for (;;)
    {
      i2 += 1;
      i3 = i1 + 1;
      i1 = j;
      j = i;
      i = i1;
      i1 = i3;
      break;
      if (i4 < i)
      {
        ((List)localObject).clear();
        ((List)localObject).add(localing);
        j = i4;
        i = i3;
        continue;
        double d2 = j;
        double d1;
        if (a >= 0.0D)
        {
          d1 = a;
          Iterator localIterator = ((List)localObject).iterator();
          i = 0;
          paramArrayOfing = null;
          label241:
          if (!localIterator.hasNext()) {
            break label317;
          }
          localing = (ing)localIterator.next();
          j = b;
          if (d2 * d1 < i) {
            break label319;
          }
          localObject = localing;
          if (paramArrayOfing != null) {
            if (j == 0) {
              break label319;
            }
          }
        }
        label317:
        label319:
        for (localObject = localing;; localObject = paramArrayOfing)
        {
          i += j;
          paramArrayOfing = (ing[])localObject;
          break label241;
          d1 = Math.random();
          break;
          return paramArrayOfing;
        }
      }
      else
      {
        label325:
        i3 = i;
        i = j;
        j = i3;
      }
    }
  }
  
  public static String a(String paramString)
  {
    int i = paramString.indexOf('@');
    if (i == -1)
    {
      cvm.e("Exchange", "EasAutodiscover.getStrippedUsername: Invalid email - no @ sign", new Object[0]);
      return paramString;
    }
    return paramString.substring(0, i);
  }
  
  private static void a(XmlPullParser paramXmlPullParser)
  {
    for (;;)
    {
      int i = paramXmlPullParser.next();
      String str = paramXmlPullParser.getName();
      if ((i == 3) && ("Error".equals(str))) {
        break;
      }
      if (i == 2)
      {
        i = -1;
        switch (str.hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            break;
          case 0: 
            cvm.e("Exchange", "EasAutodiscover.parseError: Error code=%s", new Object[] { paramXmlPullParser.nextText() });
            break;
            if (str.equals("ErrorCode"))
            {
              i = 0;
              continue;
              if (str.equals("Status"))
              {
                i = 1;
                continue;
                if (str.equals("Message"))
                {
                  i = 2;
                  continue;
                  if (str.equals("DebugData")) {
                    i = 3;
                  }
                }
              }
            }
            break;
          }
        }
        cvm.e("Exchange", "EasAutodiscover.parseError: Status=%s", new Object[] { paramXmlPullParser.nextText() });
        continue;
        cvm.e("Exchange", "EasAutodiscover.parseError: Message=%s", new Object[] { paramXmlPullParser.nextText() });
        continue;
        cvm.e("Exchange", "EasAutodiscover.parseError: Debug data=%s", new Object[] { paramXmlPullParser.nextText() });
      }
    }
  }
  
  public static String b(String paramString)
  {
    Object localObject;
    for (;;)
    {
      try
      {
        localObject = String.valueOf("_autodiscover._tcp.");
        paramString = String.valueOf(paramString);
        if (paramString.length() == 0) {
          break label208;
        }
        paramString = ((String)localObject).concat(paramString);
        localObject = new ilp(paramString);
        if (b == null) {
          break label220;
        }
        paramString = b;
        if ((paramString != null) && (paramString.length != 0)) {
          break label311;
        }
        if ((d) && (e != -1)) {
          break;
        }
        paramString = String.valueOf(a);
        paramString = new StringBuffer(String.valueOf(paramString).length() + 11 + "Lookup of " + paramString + " ");
        if (c != 1)
        {
          i = c;
          paramString.append(String.valueOf(ikm.a.c(i)).concat(" "));
        }
        int i = b;
        paramString.append(String.valueOf(inx.a.c(i)).concat(" isn't done"));
        throw new IllegalStateException(paramString.toString());
      }
      catch (inw paramString)
      {
        cvm.e("Exchange", "EasAutodiscover: srvLookup error - unable to parse text", new Object[0]);
      }
      return null;
      label208:
      paramString = new String((String)localObject);
      continue;
      label220:
      paramString = ((ilp)localObject).a();
    }
    if (f != null) {
      paramString = f;
    }
    for (;;)
    {
      cvm.e("Exchange", "EasAutodiscover: srvLookup error - %s", new Object[] { paramString });
      break;
      switch (e)
      {
      default: 
        for (;;)
        {
          throw new IllegalStateException("unknown result");
          paramString = acopyOflengthc.a(true);
          return paramString;
        }
      case 0: 
        paramString = "successful";
        break;
      case 1: 
        paramString = "unrecoverable error";
        break;
      case 2: 
        paramString = "try again";
        break;
      case 3: 
        paramString = "host not found";
        break;
      case 4: 
        label311:
        paramString = "type not found";
      }
    }
  }
  
  private final boolean j()
  {
    return (c == 2) && (k == 0);
  }
  
  protected final int a(bns parambns)
  {
    if (j())
    {
      cvm.e("Exchange", "EasAutodiscover.handleResponse: Received 200 for first GET request (bad)", new Object[0]);
      return -102;
    }
    d = a(parambns.d());
    if (d != null)
    {
      d.f = m;
      d.g = n;
      if (d.d == -1) {
        d.d = 443;
      }
      d.b = bnq.e;
      d.e = 5;
      return 0;
    }
    return -11;
  }
  
  protected final String a()
  {
    return l;
  }
  
  protected final int b(bns parambns)
  {
    int i = b;
    if ((j()) && (!parambns.c()))
    {
      cvm.d("Exchange", "EasAutodiscover.handleHttpError: Non-redirect error for first GET request", new Object[0]);
      return -102;
    }
    if (parambns.c())
    {
      parambns = parambns.a("Location");
      if (parambns != null) {}
      for (parambns = Uri.parse(parambns.getValue()); (parambns != null) && ("https".equalsIgnoreCase(parambns.getScheme())); parambns = null)
      {
        cvm.b("Exchange", "EasAutodiscover.handleHttpError: Redirect=[%s]", new Object[] { parambns });
        e = parambns.toString();
        return -101;
      }
      cvm.d("Exchange", "EasAutodiscover.handleHttpError: Invalid redirect %s", new Object[] { parambns });
      return -102;
    }
    if (i == 401)
    {
      cvm.d("Exchange", "EasAutodiscover.handleHttpError: Unauthorized", new Object[0]);
      return -100;
    }
    cvm.d("Exchange", "EasAutodiscover.handleHttpError: BAD_RESPONSE, status=[%s]", new Object[] { Integer.valueOf(i) });
    return -102;
  }
  
  protected final String b()
  {
    return "Autodiscover";
  }
  
  protected final HttpEntity c()
  {
    try
    {
      Object localObject = Xml.newSerializer();
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(1024);
      ((XmlSerializer)localObject).setOutput(localByteArrayOutputStream, "UTF-8");
      ((XmlSerializer)localObject).startDocument("UTF-8", Boolean.valueOf(false));
      ((XmlSerializer)localObject).startTag(null, "Autodiscover");
      ((XmlSerializer)localObject).attribute(null, "xmlns", "http://schemas.microsoft.com/exchange/autodiscover/mobilesync/requestschema/2006");
      ((XmlSerializer)localObject).startTag(null, "Request");
      ((XmlSerializer)localObject).startTag(null, "EMailAddress").text(o).endTag(null, "EMailAddress");
      ((XmlSerializer)localObject).startTag(null, "AcceptableResponseSchema");
      ((XmlSerializer)localObject).text("http://schemas.microsoft.com/exchange/autodiscover/mobilesync/responseschema/2006");
      ((XmlSerializer)localObject).endTag(null, "AcceptableResponseSchema");
      ((XmlSerializer)localObject).endTag(null, "Request");
      ((XmlSerializer)localObject).endTag(null, "Autodiscover");
      ((XmlSerializer)localObject).endDocument();
      localObject = new StringEntity(localByteArrayOutputStream.toString());
      return (HttpEntity)localObject;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      return null;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
  }
  
  protected final String d()
  {
    return "text/xml";
  }
  
  protected final HttpUriRequest e()
  {
    Object localObject = l;
    if ((c == 2) && (k == 0)) {}
    for (localObject = brt.b((String)localObject);; localObject = h.a((String)localObject, c(), "text/xml", o()))
    {
      HttpClientParams.setRedirecting(((HttpUriRequest)localObject).getParams(), false);
      return (HttpUriRequest)localObject;
    }
  }
}

/* Location:
 * Qualified Name:     bpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */