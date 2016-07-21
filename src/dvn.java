import android.net.Uri;
import com.android.mail.providers.Attachment;
import java.util.List;

public final class dvn
{
  public final String a;
  public final long b;
  public final long c;
  public final long d;
  public final String e;
  public final List<String> f;
  
  private dvn(String paramString1, long paramLong1, long paramLong2, long paramLong3, String paramString2, List<String> paramList)
  {
    a = paramString1;
    b = paramLong1;
    c = paramLong2;
    d = paramLong3;
    e = paramString2;
    f = paramList;
  }
  
  public static dvn a(Uri paramUri)
  {
    Object localObject = paramUri.getPathSegments();
    String str = (String)((List)localObject).get(0);
    List localList = paramUri.getQueryParameters("contentType");
    long l1 = Long.parseLong((String)((List)localObject).get(2));
    long l2 = Long.parseLong((String)((List)localObject).get(3));
    if (((List)localObject).size() >= 5)
    {
      localObject = (String)((List)localObject).get(4);
      if (!((String)localObject).equals("empty")) {
        break label139;
      }
      dri.e(Attachment.a, "Parsed message attachment uri with partId = \"empty\"", new Object[] { paramUri });
    }
    label139:
    for (;;)
    {
      return new dvn(str, l1, Long.parseLong(paramUri.getQueryParameter("serverMessageId")), l2, (String)localObject, localList);
      localObject = null;
    }
  }
}

/* Location:
 * Qualified Name:     dvn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */