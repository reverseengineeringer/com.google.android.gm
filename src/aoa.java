import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.util.Log;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class aoa
{
  private static final Pattern a = Pattern.compile("^.*$");
  private static final Pattern b = Pattern.compile("([-+NnSs](\\s)*)?[1-9]?[0-9](°)(\\s)*([1-5]?[0-9]')?(\\s)*([1-5]?[0-9](\\.[0-9]+)?\")?((\\s)*[NnSs])?(\\s)*,(\\s)*([-+EeWw](\\s)*)?(1)?[0-9]?[0-9](°)(\\s)*([1-5]?[0-9]')?(\\s)*([1-5]?[0-9](\\.[0-9]+)?\")?((\\s)*[EeWw])?|[+-]?[1-9]?[0-9](\\.[0-9]+)(°)?(\\s)*,(\\s)*[+-]?(1)?[0-9]?[0-9](\\.[0-9]+)(°)?");
  
  private static int a(CharSequence paramCharSequence, int paramInt)
  {
    int k = 0;
    int j = paramInt;
    if (paramCharSequence.length() > paramInt + 4)
    {
      j = paramInt;
      if (paramCharSequence.subSequence(paramInt, paramInt + 4).toString().equalsIgnoreCase("tel:")) {
        j = paramInt + 4;
      }
    }
    int i2 = paramCharSequence.length();
    paramInt = 120;
    int n = 0;
    int m = j;
    j = n;
    int i;
    if (m <= i2) {
      if (m < i2)
      {
        i = paramCharSequence.charAt(m);
        label89:
        if (!Character.isDigit(i)) {
          break label122;
        }
        if (j != 0) {
          break label310;
        }
        paramInt = i;
      }
    }
    label122:
    label263:
    label310:
    for (;;)
    {
      n = j + 1;
      if (n > 11)
      {
        return -1;
        i = 27;
        break label89;
        if (Character.isWhitespace(i)) {
          if (((paramInt == 49) && (j == 4)) || (j == 3))
          {
            n = 1;
            k = j;
            j = paramInt;
            paramInt = n;
          }
        }
      }
      for (;;)
      {
        n = m + 1;
        m = k;
        k = paramInt;
        paramInt = j;
        j = m;
        m = n;
        break;
        if ((paramInt != 49) || (j != 1))
        {
          if (k == 0) {
            break label263;
          }
          if ((paramInt != 49) || (j != 7))
          {
            if (j != 6) {
              break label263;
            }
            n = paramInt;
            i1 = j;
            paramInt = k;
            j = n;
            k = i1;
            continue;
            if ("()+-*#.".indexOf(i) == -1) {
              break label263;
            }
          }
        }
        n = paramInt;
        int i1 = j;
        paramInt = k;
        j = n;
        k = i1;
        continue;
        if (((paramInt != 49) && ((j == 7) || (j == 10))) || ((paramInt == 49) && (j == 11))) {
          return m;
        }
        return -1;
        j = paramInt;
        paramInt = k;
        k = n;
      }
    }
  }
  
  public static Spannable a(String paramString)
  {
    int i = 0;
    SpannableString localSpannableString = SpannableString.valueOf(paramString);
    int k;
    int j;
    if (!System.getProperty("user.region", "US").equals("US"))
    {
      Linkify.addLinks(localSpannableString, 15);
      localObject1 = (URLSpan[])localSpannableString.getSpans(0, localSpannableString.length(), URLSpan.class);
      if (localObject1.length == 1)
      {
        k = localSpannableString.getSpanStart(localObject1[0]);
        j = localSpannableString.getSpanEnd(localObject1[0]);
        i = 0;
        if (i < localSpannableString.length()) {
          if (!Character.isWhitespace(localSpannableString.charAt(i)))
          {
            label112:
            if (k > i) {
              break label180;
            }
            i = localSpannableString.length() - 1;
            label128:
            if (i < 0) {
              break label175;
            }
            if (Character.isWhitespace(localSpannableString.charAt(i))) {
              break label168;
            }
          }
        }
        for (;;)
        {
          if (j < i + 1) {
            break label180;
          }
          return localSpannableString;
          i += 1;
          break;
          i = -1;
          break label112;
          label168:
          i -= 1;
          break label128;
          label175:
          i = -1;
        }
      }
      label180:
      return SpannableString.valueOf(paramString);
    }
    Linkify.addLinks(localSpannableString, 11);
    Object localObject2 = (URLSpan[])localSpannableString.getSpans(0, localSpannableString.length(), URLSpan.class);
    Matcher localMatcher = b.matcher(localSpannableString);
    while (localMatcher.find())
    {
      j = localMatcher.start();
      k = localMatcher.end();
      if (!a(localSpannableString, (URLSpan[])localObject2, j, k))
      {
        localObject1 = String.valueOf("geo:0,0?q=");
        String str = String.valueOf(localMatcher.group());
        if (str.length() != 0) {}
        for (localObject1 = ((String)localObject1).concat(str);; localObject1 = new String((String)localObject1))
        {
          localSpannableString.setSpan(new URLSpan((String)localObject1), j, k, 33);
          break;
        }
      }
    }
    Object localObject1 = (URLSpan[])localSpannableString.getSpans(0, localSpannableString.length(), URLSpan.class);
    localObject2 = a(paramString);
    if (i < localObject2.length / 2)
    {
      k = localObject2[(i * 2)];
      int m = localObject2[(i * 2 + 1)];
      if (!a(localSpannableString, (URLSpan[])localObject1, k, m))
      {
        paramString = new StringBuilder();
        j = k;
        while (j < m)
        {
          char c = localSpannableString.charAt(j);
          if ((c == '+') || (Character.isDigit(c))) {
            paramString.append(c);
          }
          j += 1;
        }
        paramString = String.valueOf(paramString.toString());
        if (paramString.length() == 0) {
          break label502;
        }
      }
      label502:
      for (paramString = "tel:".concat(paramString);; paramString = new String("tel:"))
      {
        localSpannableString.setSpan(new URLSpan(paramString), k, m, 33);
        i += 1;
        break;
      }
    }
    return localSpannableString;
  }
  
  private static boolean a(Spannable paramSpannable, URLSpan[] paramArrayOfURLSpan, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfURLSpan.length;
      int i = 0;
      while (i < j)
      {
        URLSpan localURLSpan = paramArrayOfURLSpan[i];
        int k = paramSpannable.getSpanStart(localURLSpan);
        int m = paramSpannable.getSpanEnd(localURLSpan);
        if (((paramInt1 >= k) && (paramInt1 < m)) || ((paramInt2 > k) && (paramInt2 <= m)))
        {
          if (Log.isLoggable("ExtendedLinkify", 2))
          {
            paramSpannable = String.valueOf(paramSpannable.subSequence(paramInt1, paramInt2));
            new StringBuilder(String.valueOf(paramSpannable).length() + 46).append("Not linkifying ").append(paramSpannable).append(" as phone number due to overlap");
          }
          return true;
        }
        i += 1;
      }
    }
  }
  
  private static int[] a(CharSequence paramCharSequence)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    int m = paramCharSequence.length() - 7 + 1;
    if (m < 0) {
      return new int[0];
    }
    while (i != m)
    {
      int k = a(paramCharSequence, i);
      int j = i;
      if (k > i)
      {
        localArrayList.add(Integer.valueOf(i));
        localArrayList.add(Integer.valueOf(k));
        i = k;
        if (i < m) {
          while ((Character.isWhitespace(paramCharSequence.charAt(i))) && (i < m)) {
            i += 1;
          }
        }
      }
      else
      {
        for (;;)
        {
          i = j;
          if (Character.isWhitespace(paramCharSequence.charAt(j))) {
            break;
          }
          i = j;
          if (j >= m) {
            break;
          }
          j += 1;
        }
      }
    }
    paramCharSequence = new int[localArrayList.size()];
    i = localArrayList.size() - 1;
    while (i >= 0)
    {
      paramCharSequence[i] = ((Integer)localArrayList.get(i)).intValue();
      i -= 1;
    }
    return paramCharSequence;
  }
}

/* Location:
 * Qualified Name:     aoa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */