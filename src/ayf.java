import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class ayf
{
  final int a;
  final List<String> b = new ArrayList();
  
  private ayf(int paramInt)
  {
    a = paramInt;
  }
  
  public static ayf a(List<String> paramList)
  {
    localObject = ((String)paramList.get(0)).substring(0, 3);
    try
    {
      int i = Integer.parseInt((String)localObject);
      localObject = new ayf(i);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (str.length() >= 4) {
          b.add(str.substring(4));
        }
      }
      return (ayf)localObject;
    }
    catch (NumberFormatException paramList)
    {
      throw new bdi(28, "Couldn't parse SMTP response code", paramList);
    }
  }
  
  public final String a(String paramString)
  {
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (str.contains(paramString)) {
        return str;
      }
    }
    return null;
  }
  
  public final String toString()
  {
    String str1 = String.valueOf(Integer.toString(a));
    String str2 = String.valueOf(TextUtils.join(" - ", b));
    return String.valueOf(str1).length() + 7 + String.valueOf(str2).length() + "[ " + str1 + " # " + str2 + " ]";
  }
}

/* Location:
 * Qualified Name:     ayf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */