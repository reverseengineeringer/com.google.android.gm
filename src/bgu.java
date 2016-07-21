import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

public final class bgu
{
  public static bgv a(ArrayList<bdn> paramArrayList)
  {
    bgv localbgv = new bgv();
    Iterator localIterator = paramArrayList.iterator();
    Object localObject = null;
    paramArrayList = null;
    while (localIterator.hasNext())
    {
      bdn localbdn = (bdn)localIterator.next();
      String str = bco.a(localbdn);
      if ("text/html".equalsIgnoreCase(localbdn.e())) {
        paramArrayList = a(paramArrayList, str);
      } else {
        localObject = a((StringBuffer)localObject, str);
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((StringBuffer)localObject).toString();
      a = ((String)localObject);
      c = bhl.b((String)localObject);
    }
    if (!TextUtils.isEmpty(paramArrayList))
    {
      paramArrayList = paramArrayList.toString();
      b = paramArrayList;
      if (c == null) {
        c = bhl.a(paramArrayList);
      }
    }
    return localbgv;
  }
  
  private static StringBuffer a(StringBuffer paramStringBuffer, String paramString)
  {
    if (paramString == null) {
      return paramStringBuffer;
    }
    if (paramStringBuffer == null) {
      return new StringBuffer(paramString);
    }
    if (paramStringBuffer.length() > 0) {
      paramStringBuffer.append('\n');
    }
    paramStringBuffer.append(paramString);
    return paramStringBuffer;
  }
}

/* Location:
 * Qualified Name:     bgu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */