import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public final class gsf
  extends grb
{
  public ArrayList<gsg> b = new ArrayList();
  
  public gsf()
  {
    super(new grr("multipart/related").a("boundary", "__END_OF_PART__"));
  }
  
  public final void a(OutputStream paramOutputStream)
  {
    OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(paramOutputStream, b());
    String str = a.a("boundary");
    Iterator localIterator = b.iterator();
    grn localgrn;
    Object localObject1;
    long l;
    if (localIterator.hasNext())
    {
      localObject2 = (gsg)localIterator.next();
      localgrn = new grn();
      acceptEncoding = grn.a(null);
      if (b != null) {
        localgrn.a(b);
      }
      localgrn.b(null).f(null).d(null).a(null).a("Content-Transfer-Encoding", null);
      localObject1 = a;
      if (localObject1 == null) {
        break label344;
      }
      localgrn.a("Content-Transfer-Encoding", Arrays.asList(new String[] { "binary" }));
      localgrn.d(((grj)localObject1).c());
      localObject2 = c;
      if (localObject2 == null)
      {
        l = ((grj)localObject1).a();
        label182:
        localObject2 = localObject1;
        if (l != -1L) {
          localgrn.a(Long.valueOf(l));
        }
      }
    }
    label344:
    for (Object localObject2 = localObject1;; localObject2 = null)
    {
      localOutputStreamWriter.write("--");
      localOutputStreamWriter.write(str);
      localOutputStreamWriter.write("\r\n");
      grn.a(localgrn, localOutputStreamWriter);
      if (localObject2 != null)
      {
        localOutputStreamWriter.write("\r\n");
        localOutputStreamWriter.flush();
        ((guq)localObject2).a(paramOutputStream);
      }
      localOutputStreamWriter.write("\r\n");
      break;
      localgrn.b(((grk)localObject2).a());
      localObject2 = new grl((guq)localObject1, (grk)localObject2);
      l = grb.a((grj)localObject1);
      localObject1 = localObject2;
      break label182;
      localOutputStreamWriter.write("--");
      localOutputStreamWriter.write(str);
      localOutputStreamWriter.write("--");
      localOutputStreamWriter.write("\r\n");
      localOutputStreamWriter.flush();
      return;
    }
  }
  
  public final boolean d()
  {
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext()) {
      if (!nexta.d()) {
        return false;
      }
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     gsf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */