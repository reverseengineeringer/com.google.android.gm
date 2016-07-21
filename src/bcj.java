import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;

public final class bcj
{
  private static final String[] b = { "X-Android-Attachment-StoreData" };
  public final ArrayList<bck> a = new ArrayList();
  
  private static int a(Object[] paramArrayOfObject, Object paramObject)
  {
    int i = 0;
    int j = paramArrayOfObject.length;
    while (i < j)
    {
      if (paramArrayOfObject[i].equals(paramObject)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public final String a(String paramString)
  {
    paramString = b(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString[0];
  }
  
  public final void a(OutputStream paramOutputStream)
  {
    paramOutputStream = new BufferedWriter(new OutputStreamWriter(paramOutputStream), 1024);
    Iterator localIterator = a.iterator();
    label140:
    while (localIterator.hasNext())
    {
      Object localObject = (bck)localIterator.next();
      if (a(b, a) >= 0) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label140;
        }
        String str = a;
        localObject = b;
        paramOutputStream.write(String.valueOf(str).length() + 4 + String.valueOf(localObject).length() + str + ": " + (String)localObject + "\r\n");
        break;
      }
    }
    paramOutputStream.flush();
  }
  
  public final void a(String paramString1, String paramString2)
  {
    a.add(new bck(paramString1, paramString2));
  }
  
  public final void b(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    c(paramString1);
    a(paramString1, paramString2);
  }
  
  public final String[] b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      bck localbck = (bck)localIterator.next();
      if (a.equalsIgnoreCase(paramString)) {
        localArrayList.add(b);
      }
    }
    if (localArrayList.size() == 0) {
      return null;
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public final void c(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      bck localbck = (bck)localIterator.next();
      if (a.equalsIgnoreCase(paramString)) {
        localArrayList.add(localbck);
      }
    }
    a.removeAll(localArrayList);
  }
  
  public final String toString()
  {
    if (a == null) {
      return null;
    }
    return a.toString();
  }
}

/* Location:
 * Qualified Name:     bcj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */