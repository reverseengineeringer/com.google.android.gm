import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class goz
  implements gph
{
  private final PrintWriter a;
  
  public goz(PrintWriter paramPrintWriter)
  {
    a = paramPrintWriter;
  }
  
  private final void a(String paramString1, String paramString2)
  {
    a.print(paramString1);
    a.print(": ");
    paramString1 = paramString2.replace("\n", " ");
    paramString2 = gzx.c();
    int k = paramString1.length();
    int i = 0;
    while ((i < k) && (paramString2.b(paramString1.charAt(i)))) {
      i += 1;
    }
    for (;;)
    {
      int j;
      if ((j > i) && (paramString2.b(paramString1.charAt(j))))
      {
        j -= 1;
      }
      else
      {
        if ((i == 0) && (j == k - 1)) {}
        for (paramString1 = paramString2.b(paramString1, ' ');; paramString1 = paramString2.a(paramString1, i, j + 1, ' ', new StringBuilder(j + 1 - i), false))
        {
          a.print(paramString1);
          return;
        }
        j = k - 1;
      }
    }
  }
  
  public final void a() {}
  
  public final void a(goy paramgoy)
  {
    a("COMMENT", a);
  }
  
  public final void a(gpa paramgpa)
  {
    PrintWriter localPrintWriter = a;
    paramgpa = String.valueOf(a.a);
    localPrintWriter.println(String.valueOf(paramgpa).length() + 5 + "==</" + paramgpa + ">");
  }
  
  public final void a(gpd paramgpd)
  {
    Object localObject1 = a;
    Object localObject2 = String.valueOf(a.a);
    ((PrintWriter)localObject1).print(String.valueOf(localObject2).length() + 4 + "==<" + (String)localObject2 + ">");
    localObject1 = b;
    if (localObject1 != null)
    {
      paramgpd = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (gpe)((Iterator)localObject1).next();
        localObject2 = String.valueOf(a.a);
        localObject3 = String.valueOf(((gpe)localObject3).a());
        paramgpd.add(String.valueOf(localObject2).length() + 5 + String.valueOf(localObject3).length() + "[" + (String)localObject2 + " : " + (String)localObject3 + "]");
      }
      localObject1 = (String[])paramgpd.toArray(new String[paramgpd.size()]);
      Arrays.sort((Object[])localObject1);
      int i = 0;
      if (i < localObject1.length)
      {
        localObject2 = a;
        paramgpd = String.valueOf(localObject1[i]);
        if (paramgpd.length() != 0) {}
        for (paramgpd = " ".concat(paramgpd);; paramgpd = new String(" "))
        {
          ((PrintWriter)localObject2).print(paramgpd);
          i += 1;
          break;
        }
      }
    }
    a.println();
  }
  
  public final void a(gpf paramgpf)
  {
    a("TEXT", paramgpf.a());
  }
  
  public final void b() {}
}

/* Location:
 * Qualified Name:     goz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */