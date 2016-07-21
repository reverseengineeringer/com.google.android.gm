import android.text.TextUtils;
import android.text.util.Rfc822Token;
import android.text.util.Rfc822Tokenizer;
import com.android.emailcommon.mail.Address;
import com.android.mail.providers.Account;
import com.android.mail.providers.Message;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class cci
{
  private static final String a = cvl.a;
  private static final int b = 23;
  
  static int a(CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(paramCharSequence)) {
      return -1;
    }
    String str = paramCharSequence.toString();
    int i = str.indexOf("<div class=\"gmail_extra\">");
    int m = 0;
    int k = 0;
    while (i > 0)
    {
      if (m >= 0) {}
      try
      {
        if ((m >= str.length()) || (i < 0) || (i >= str.length()) || (m > i))
        {
          cvm.e(a, "Invalid From/To index", new Object[0]);
          throw new IllegalArgumentException();
        }
        paramCharSequence = String.valueOf("div");
        if (paramCharSequence.length() != 0) {}
        int n;
        int j;
        for (paramCharSequence = "<".concat(paramCharSequence);; paramCharSequence = new String("<"))
        {
          n = str.indexOf(paramCharSequence, m);
          j = 0;
          if ((n < 0) || (n >= i)) {
            break label256;
          }
          n = str.indexOf(">", n + 1);
          if ((n >= 0) && (n < i)) {
            break;
          }
          cvm.e(a, "No corresponding closing bracket", new Object[0]);
          throw new IllegalArgumentException();
        }
        if (str.charAt(n - 1) != '/') {
          j += 1;
        }
        for (;;)
        {
          paramCharSequence = String.valueOf("div");
          if (paramCharSequence.length() != 0) {}
          for (paramCharSequence = "<".concat(paramCharSequence);; paramCharSequence = new String("<"))
          {
            n = str.indexOf(paramCharSequence, n + 1);
            break;
          }
          label256:
          paramCharSequence = String.valueOf("div");
          if (paramCharSequence.length() != 0)
          {
            paramCharSequence = "</".concat(paramCharSequence);
            n = str.indexOf(paramCharSequence, m);
            m = 0;
            label289:
            if ((n < 0) || (n >= i)) {
              break label367;
            }
            paramCharSequence = String.valueOf("div");
            if (paramCharSequence.length() == 0) {
              break label354;
            }
          }
          label354:
          for (paramCharSequence = "</".concat(paramCharSequence);; paramCharSequence = new String("</"))
          {
            n = str.indexOf(paramCharSequence, n + 1);
            m += 1;
            break label289;
            paramCharSequence = new String("</");
            break;
          }
          label367:
          k += j - m;
          if (k == 0) {
            return i;
          }
          j = str.indexOf("<div class=\"gmail_extra\">", i + 1);
          m = i;
          i = j;
          break;
        }
        return -1;
      }
      catch (IllegalArgumentException paramCharSequence) {}
    }
  }
  
  static int a(String paramString)
  {
    int i = paramString.indexOf("<br type=\"attribution\">");
    if (i >= 0) {
      return i + b;
    }
    return -1;
  }
  
  public static List<Rfc822Token[]> a(Collection<String> paramCollection)
  {
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localArrayList.add(Rfc822Tokenizer.tokenize((String)paramCollection.next()));
    }
    return localArrayList;
  }
  
  public static Set<String> a(List<Rfc822Token[]> paramList)
  {
    HashSet localHashSet = new HashSet(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Rfc822Token[] arrayOfRfc822Token = (Rfc822Token[])paramList.next();
      int j = arrayOfRfc822Token.length;
      int i = 0;
      while (i < j)
      {
        localHashSet.add(arrayOfRfc822Token[i].getAddress());
        i += 1;
      }
    }
    return localHashSet;
  }
  
  public static void a(Set<String> paramSet1, Set<String> paramSet2, Account paramAccount, Message paramMessage)
  {
    String[] arrayOfString2 = Message.a(paramMessage.h());
    Object localObject = Message.a(paramMessage.g());
    String[] arrayOfString1;
    int j;
    int i;
    if (localObject.length > 0)
    {
      localObject = localObject[0];
      arrayOfString1 = Message.a(paramMessage.k());
      j = arrayOfString1.length;
      i = 0;
      label47:
      if (i >= j) {
        break label137;
      }
      if (TextUtils.isEmpty(arrayOfString1[i])) {
        break label128;
      }
    }
    for (;;)
    {
      j = arrayOfString1.length;
      i = 0;
      while (i < j)
      {
        String str = arrayOfString1[i];
        if ((!TextUtils.isEmpty(str)) && (!a(paramAccount, str))) {
          paramSet1.add(str);
        }
        i += 1;
      }
      localObject = null;
      break;
      label128:
      i += 1;
      break label47;
      label137:
      arrayOfString1 = new String[1];
      arrayOfString1[0] = localObject;
    }
    if (paramSet1.isEmpty())
    {
      if ((arrayOfString2.length != 1) || (!a(paramAccount, (String)localObject)) || (!a(paramAccount, arrayOfString2[0]))) {
        break label233;
      }
      paramSet1.add(arrayOfString2[0]);
    }
    for (;;)
    {
      if (paramSet2 != null)
      {
        paramSet1 = a(a(paramSet1));
        a(paramSet2, paramSet1, paramAccount, arrayOfString2);
        a(paramSet2, paramSet1, paramAccount, Message.a(paramMessage.i()));
      }
      return;
      label233:
      j = arrayOfString2.length;
      i = 0;
      while (i < j)
      {
        localObject = arrayOfString2[i];
        if (!a(paramAccount, (String)localObject)) {
          paramSet1.add(localObject);
        }
        i += 1;
      }
    }
  }
  
  private static void a(Set<String> paramSet1, Set<String> paramSet2, Account paramAccount, String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    if (i < j)
    {
      String str = paramArrayOfString[i];
      Object localObject = Address.c(str);
      if (localObject == null) {
        cvm.d(a, "obtainCcAddresses: email address is null", new Object[0]);
      }
      for (;;)
      {
        i += 1;
        break;
        localObject = a;
        if ((!paramSet2.contains(localObject)) && (!a(paramAccount, (String)localObject))) {
          paramSet1.add(str.replace("\"\"", ""));
        }
      }
    }
  }
  
  private static boolean a(Account paramAccount, String paramString)
  {
    Object localObject = paramAccount.g();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Rfc822Tokenizer.tokenize(paramString);
      if ((paramString != null) && (paramString.length > 0))
      {
        paramString = cxa.h(paramString[0].getAddress());
        if (TextUtils.equals(cxa.h(c), paramString)) {
          return true;
        }
        paramAccount = ((List)localObject).iterator();
        while (paramAccount.hasNext())
        {
          localObject = (cha)paramAccount.next();
          if ((TextUtils.equals(cxa.h(b), paramString)) && (e)) {
            return true;
          }
        }
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     cci
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */