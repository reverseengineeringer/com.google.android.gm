import android.net.Uri;
import android.text.TextUtils;
import com.android.emailcommon.mail.Address;
import com.android.mail.providers.Attachment;
import com.android.mail.providers.Message;
import java.util.ArrayList;

public final class dzj
{
  public static dzu a(Message paramMessage, String paramString)
  {
    Object localObject2 = Address.c(paramMessage.j);
    dzu localdzu = new dzu();
    a = f.toString();
    if (!TextUtils.isEmpty(o)) {}
    for (Object localObject1 = cvb.a(o);; localObject1 = p)
    {
      b = a((String)localObject1);
      c = n;
      if (localObject2 != null)
      {
        d = a(b);
        e = a;
        n = paramString.equals(e);
      }
      f = B;
      g = w;
      h = Message.f(k);
      i = Message.f(l);
      paramString = new dzp[paramMessage.l().size()];
      int j = paramMessage.l().size();
      int i = 0;
      while (i < j)
      {
        localObject1 = (Attachment)paramMessage.l().get(i);
        localObject2 = new dzp();
        a = a(c);
        b = ((Attachment)localObject1).l();
        paramString[i] = localObject2;
        i += 1;
      }
    }
    m = paramString;
    return localdzu;
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
}

/* Location:
 * Qualified Name:     dzj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */