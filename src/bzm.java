import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.android.emailcommon.mail.Address;
import java.util.Map;

public final class bzm
{
  public final Context a;
  public final CharSequence b;
  public final SpannableStringBuilder c = new SpannableStringBuilder();
  public int d = 0;
  public boolean e = true;
  public boolean f = true;
  public boolean g = true;
  private final String h;
  private final String i;
  private final Map<String, Address> j;
  private final mx k;
  
  public bzm(Context paramContext, String paramString1, String paramString2, CharSequence paramCharSequence, Map<String, Address> paramMap, mx parammx)
  {
    a = paramContext;
    h = paramString1;
    i = paramString2;
    b = paramCharSequence;
    j = paramMap;
    k = parammx;
  }
  
  private final void a()
  {
    if (e)
    {
      e = false;
      return;
    }
    c.append(b);
  }
  
  public static boolean a(String[] paramArrayOfString, int paramInt)
  {
    return (paramArrayOfString != null) && (paramArrayOfString.length != 0) && (paramInt != 0);
  }
  
  public final void a(String paramString)
  {
    int m;
    if ((50 - d != 0) && (!TextUtils.isEmpty(paramString)))
    {
      m = 1;
      if (m != 0) {
        break label29;
      }
    }
    label29:
    Address localAddress;
    do
    {
      return;
      m = 0;
      break;
      localAddress = cxa.a(j, paramString);
    } while (localAddress == null);
    Object localObject = b;
    paramString = (String)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramString = a;
    }
    a();
    localObject = new SpannableString(a.getText(buj.cy));
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(jr.b(a, btz.ab)), 0, ((SpannableString)localObject).length(), 33);
    c.append(TextUtils.expandTemplate(a.getText(buj.cz), new CharSequence[] { k.a(paramString), localObject }));
    d += 1;
  }
  
  public final void a(String[] paramArrayOfString)
  {
    int m = 0;
    int n = 50 - d;
    if (!a(paramArrayOfString, n)) {}
    for (;;)
    {
      if (m != 0) {
        d += Math.min(n, paramArrayOfString.length);
      }
      return;
      int i1 = Math.min(n, paramArrayOfString.length);
      m = 0;
      if (m < i1)
      {
        Address localAddress = cxa.a(j, paramArrayOfString[m]);
        Object localObject;
        String str;
        if (localAddress != null)
        {
          localObject = a;
          str = b;
          if ((!g) || (!h.equals(localObject))) {
            break label138;
          }
          localObject = i;
        }
        for (;;)
        {
          a();
          c.append(k.a((String)localObject));
          m += 1;
          break;
          label138:
          if (f) {
            localObject = localAddress.a();
          } else if (!TextUtils.isEmpty(str)) {
            localObject = str;
          }
        }
      }
      m = 1;
    }
  }
}

/* Location:
 * Qualified Name:     bzm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */