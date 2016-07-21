import android.text.TextUtils;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public final class edh
{
  private final TreeSet<Character> a = new TreeSet();
  private final List<String> b = new ArrayList();
  private final List<Integer> c = new ArrayList();
  private int d = 12;
  private int e = 16;
  
  private static TreeSet<Character> a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      throw new edi(paramString2 + " cannot be null or empty");
    }
    TreeSet localTreeSet = new TreeSet();
    paramString1 = paramString1.toCharArray();
    int j = paramString1.length;
    int i = 0;
    while (i < j)
    {
      char c1 = paramString1[i];
      if (PasswordSpecification.a(c1)) {
        throw new edi(paramString2 + " must only contain ASCII printable characters");
      }
      localTreeSet.add(Character.valueOf(c1));
      i += 1;
    }
    return localTreeSet;
  }
  
  public final edh a()
  {
    d = 12;
    e = 16;
    return this;
  }
  
  public final edh a(String paramString)
  {
    a.addAll(a(paramString, "allowedChars"));
    return this;
  }
  
  public final PasswordSpecification b()
  {
    if (a.isEmpty()) {
      throw new edi("no allowed characters specified");
    }
    Object localObject = c.iterator();
    for (int i = 0; ((Iterator)localObject).hasNext(); i = ((Integer)((Iterator)localObject).next()).intValue() + i) {}
    if (i > e) {
      throw new edi("required character count cannot be greater than the max password size");
    }
    localObject = new boolean[95];
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext())
    {
      char[] arrayOfChar = ((String)localIterator.next()).toCharArray();
      int j = arrayOfChar.length;
      i = 0;
      while (i < j)
      {
        char c1 = arrayOfChar[i];
        if (localObject[(c1 - ' ')] != 0) {
          throw new edi("character " + c1 + " occurs in more than one required character set");
        }
        localObject[(c1 - ' ')] = 1;
        i += 1;
      }
    }
    return new PasswordSpecification(1, PasswordSpecification.a(a), b, c, d, e);
  }
  
  public final edh b(String paramString)
  {
    paramString = a(paramString, "requiredChars");
    b.add(PasswordSpecification.a(paramString));
    c.add(Integer.valueOf(1));
    return this;
  }
}

/* Location:
 * Qualified Name:     edh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */