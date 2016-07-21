import android.text.TextUtils;
import android.text.util.Rfc822Token;
import android.text.util.Rfc822Tokenizer;
import android.widget.AutoCompleteTextView.Validator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Deprecated
public final class anv
  implements AutoCompleteTextView.Validator
{
  private static final Pattern a = Pattern.compile("((?!\\s)[\\.\\w!#$%&'*+\\-/=?^`{|}~-￾])+@(([a-zA-Z0-9 -퟿豈-﷏ﷰ-￯][a-zA-Z0-9 -퟿豈-﷏ﷰ-￯\\-]{0,61})?[a-zA-Z0-9 -퟿豈-﷏ﷰ-￯]\\.)+[a-zA-Z0-9 -퟿豈-﷏ﷰ-￯][a-zA-Z0-9 -퟿豈-﷏ﷰ-￯\\-]{0,61}[a-zA-Z0-9 -퟿豈-﷏ﷰ-￯]");
  private String b;
  private boolean c = false;
  
  public anv(String paramString)
  {
    b = paramString;
  }
  
  private static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      char c1 = paramString.charAt(i);
      if ((c1 > ' ') && (c1 <= '~') && (c1 != '(') && (c1 != ')') && (c1 != '<') && (c1 != '>') && (c1 != '@') && (c1 != ',') && (c1 != ';') && (c1 != ':') && (c1 != '\\') && (c1 != '"') && (c1 != '[') && (c1 != ']')) {
        localStringBuilder.append(c1);
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public final CharSequence fixText(CharSequence paramCharSequence)
  {
    if (TextUtils.getTrimmedLength(paramCharSequence) == 0) {
      return "";
    }
    Rfc822Token[] arrayOfRfc822Token = Rfc822Tokenizer.tokenize(paramCharSequence);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < arrayOfRfc822Token.length)
    {
      Object localObject = arrayOfRfc822Token[i].getAddress();
      int j;
      String str;
      if ((!c) || (isValid((CharSequence)localObject)))
      {
        j = ((String)localObject).indexOf('@');
        if (j >= 0) {
          break label184;
        }
        if (b != null)
        {
          paramCharSequence = arrayOfRfc822Token[i];
          str = String.valueOf(a((String)localObject));
          localObject = b;
          paramCharSequence.setAddress(String.valueOf(str).length() + 1 + String.valueOf(localObject).length() + str + "@" + (String)localObject);
        }
        localStringBuilder.append(arrayOfRfc822Token[i].toString());
        if (i + 1 < arrayOfRfc822Token.length) {
          localStringBuilder.append(", ");
        }
      }
      label184:
      do
      {
        i += 1;
        break;
        str = a(((String)localObject).substring(0, j));
      } while (TextUtils.isEmpty(str));
      paramCharSequence = a(((String)localObject).substring(j + 1));
      if (paramCharSequence.length() == 0)
      {
        j = 1;
        label225:
        if ((j != 0) && (b == null)) {
          break label299;
        }
        localObject = arrayOfRfc822Token[i];
        if (j != 0) {
          break label301;
        }
      }
      for (;;)
      {
        ((Rfc822Token)localObject).setAddress(String.valueOf(str).length() + 1 + String.valueOf(paramCharSequence).length() + str + "@" + paramCharSequence);
        break;
        j = 0;
        break label225;
        label299:
        break;
        label301:
        paramCharSequence = b;
      }
    }
    return localStringBuilder;
  }
  
  public final boolean isValid(CharSequence paramCharSequence)
  {
    paramCharSequence = Rfc822Tokenizer.tokenize(paramCharSequence);
    return (paramCharSequence.length == 1) && (a.matcher(paramCharSequence[0].getAddress()).matches());
  }
}

/* Location:
 * Qualified Name:     anv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */