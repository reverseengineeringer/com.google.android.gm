import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class gsj
  extends grb
{
  private Object b;
  
  public gsj(Object paramObject)
  {
    super(gsk.a);
    b = hbe.a(paramObject);
  }
  
  private static boolean a(boolean paramBoolean, Writer paramWriter, String paramString, Object paramObject)
  {
    boolean bool = paramBoolean;
    if (paramObject != null)
    {
      if (gtt.a(paramObject)) {
        bool = paramBoolean;
      }
    }
    else {
      return bool;
    }
    if (paramBoolean)
    {
      paramBoolean = false;
      label26:
      paramWriter.write(paramString);
      if (!(paramObject instanceof Enum)) {
        break label89;
      }
    }
    label89:
    for (paramString = ac;; paramString = paramObject.toString())
    {
      paramString = guw.a.a(paramString);
      bool = paramBoolean;
      if (paramString.length() == 0) {
        break;
      }
      paramWriter.write("=");
      paramWriter.write(paramString);
      return paramBoolean;
      paramWriter.write("&");
      break label26;
    }
  }
  
  public final void a(OutputStream paramOutputStream)
  {
    paramOutputStream = new BufferedWriter(new OutputStreamWriter(paramOutputStream, b()));
    Iterator localIterator = gtt.b(b).entrySet().iterator();
    boolean bool = true;
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = ((Map.Entry)localObject2).getValue();
      if (localObject1 == null) {
        break label180;
      }
      localObject2 = (String)((Map.Entry)localObject2).getKey();
      localObject2 = guw.a.a((String)localObject2);
      Class localClass = localObject1.getClass();
      if (((localObject1 instanceof Iterable)) || (localClass.isArray()))
      {
        localObject1 = gus.a(localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          bool = a(bool, paramOutputStream, (String)localObject2, ((Iterator)localObject1).next());
        }
      }
      else
      {
        bool = a(bool, paramOutputStream, (String)localObject2, localObject1);
      }
    }
    label180:
    for (;;)
    {
      break;
      paramOutputStream.flush();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     gsj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */