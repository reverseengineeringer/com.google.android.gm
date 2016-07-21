import android.net.Uri;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

final class brb
{
  final long a;
  final Integer b;
  final String c;
  final String d;
  final String e;
  final String f;
  final String g;
  final List<brc> h;
  final String i;
  
  brb(long paramLong, brk parambrk)
  {
    a = paramLong;
    h = new ArrayList();
    a(h, parambrk.a("workPhone"), 3);
    a(h, parambrk.a("office"), 10);
    a(h, parambrk.a("homePhone"), 1);
    a(h, parambrk.a("mobilePhone"), 2);
    g = parambrk.a("emailAddress");
    e = parambrk.a("firstName");
    f = parambrk.a("lastName");
    String str2 = parambrk.a("displayName");
    String str1;
    if ((!TextUtils.isEmpty(e)) || (!TextUtils.isEmpty(f))) {
      if ((!TextUtils.isEmpty(e)) && (!TextUtils.isEmpty(f)))
      {
        str1 = e;
        String str3 = f;
        str1 = String.valueOf(str1).length() + 1 + String.valueOf(str3).length() + str1 + " " + str3;
        if (TextUtils.isEmpty(str2)) {
          break label428;
        }
        c = str2;
        b = Integer.valueOf(40);
        label236:
        str1 = c;
        if ((!TextUtils.isEmpty(e)) || (!TextUtils.isEmpty(f)))
        {
          if ((TextUtils.isEmpty(e)) || (TextUtils.isEmpty(f))) {
            break label548;
          }
          str1 = f;
          str2 = e;
          str1 = String.valueOf(str1).length() + 1 + String.valueOf(str2).length() + str1 + " " + str2;
        }
      }
    }
    for (;;)
    {
      d = str1;
      parambrk.a("displayName", c);
      parambrk.a("display_name_source", String.valueOf(b));
      parambrk.a("display_name_alt", d);
      i = Uri.encode(a.toString());
      return;
      if (!TextUtils.isEmpty(e))
      {
        str1 = e;
        break;
      }
      str1 = f;
      break;
      str1 = null;
      break;
      label428:
      if (!TextUtils.isEmpty(str1))
      {
        c = str1;
        b = Integer.valueOf(40);
        break label236;
      }
      if (!TextUtils.isEmpty(g))
      {
        c = g;
        b = Integer.valueOf(10);
        break label236;
      }
      if ((h != null) && (h.size() > 0))
      {
        c = h.get(0)).a;
        b = Integer.valueOf(20);
        break label236;
      }
      c = null;
      b = null;
      break label236;
      label548:
      if (!TextUtils.isEmpty(f)) {
        str1 = f;
      } else {
        str1 = e;
      }
    }
  }
  
  private static void a(List<brc> paramList, String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString)) {
      paramList.add(new brc(paramString, paramInt));
    }
  }
}

/* Location:
 * Qualified Name:     brb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */