import android.text.Html;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class gpi
{
  public static final gpy f = gou.c;
  static Pattern h = Pattern.compile("[\"'&<>=\\s]");
  private static boolean i = false;
  private static final Pattern l = Pattern.compile("\\& \\#? [0-9a-zA-Z]{0,8} $", 4);
  public int a;
  public int b = Integer.MAX_VALUE;
  public boolean c;
  public String d;
  public List<gpc> e;
  public final boolean g;
  private List<gpy> j = hgd.a(new gpy[] { f });
  private final boolean k;
  private final HashMap<String, gos> m = new HashMap();
  private final HashMap<String, gor> n = new HashMap();
  
  public gpi()
  {
    this(gpl.a);
  }
  
  private gpi(int paramInt)
  {
    if (paramInt == gpl.c) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      g = bool1;
      if (!g)
      {
        bool1 = bool2;
        if (paramInt != gpl.b) {}
      }
      else
      {
        bool1 = true;
      }
      k = bool1;
      return;
    }
  }
  
  private final gos a(String paramString)
  {
    String str = paramString.toLowerCase();
    gos localgos = (gos)m.get(str);
    paramString = localgos;
    if (localgos == null)
    {
      paramString = new gos(str, 0, false, true, false, got.c);
      m.put(str, paramString);
    }
    return paramString;
  }
  
  public static List<gpc> a(List<gpc> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      gpc localgpc = (gpc)paramList.next();
      if ((localgpc instanceof gpf))
      {
        localLinkedList.add((gpf)localgpc);
      }
      else
      {
        a(localLinkedList, localArrayList);
        localArrayList.add(localgpc);
      }
    }
    a(localLinkedList, localArrayList);
    return localArrayList;
  }
  
  private final void a(gos paramgos, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    if (paramgos != null)
    {
      bool1 = true;
      hby.a(bool1);
      if (d.charAt(paramInt1) != '<') {
        break label119;
      }
      bool1 = true;
      label34:
      hby.a(bool1);
      if (d.charAt(paramInt1 + 1) != '/') {
        break label125;
      }
      bool1 = true;
      label57:
      hby.a(bool1);
      if (!g) {
        break label137;
      }
      if (paramInt1 >= paramInt3) {
        break label131;
      }
    }
    Object localObject;
    label119:
    label125:
    label131:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      hby.a(bool1);
      localObject = d.substring(paramInt1, paramInt3);
      e.add(gow.a(paramgos, (String)localObject));
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label34;
      bool1 = false;
      break label57;
    }
    label137:
    if (k)
    {
      StringBuilder localStringBuilder = new StringBuilder("</");
      if (paramInt1 < paramInt2)
      {
        bool1 = true;
        hby.a(bool1);
        localObject = d.substring(paramInt1 + 2, paramInt2);
        localStringBuilder.append(hjv.a.a((String)localObject));
        if (paramInt2 > paramInt3) {
          break label323;
        }
      }
      label323:
      for (bool1 = bool2;; bool1 = false)
      {
        hby.a(bool1);
        String str = d.substring(paramInt2, paramInt3);
        localObject = str;
        if (str.charAt(str.length() - 1) != '>')
        {
          localObject = String.valueOf(str);
          localObject = String.valueOf(localObject).length() + 1 + (String)localObject + ">";
        }
        localStringBuilder.append(((String)localObject).replaceAll("\\S+.*>", ">"));
        e.add(gow.a(paramgos, localStringBuilder.toString()));
        return;
        bool1 = false;
        break;
      }
    }
    e.add(gow.a(paramgos, null));
  }
  
  private static void a(LinkedList<gpf> paramLinkedList, List<gpc> paramList)
  {
    if (!paramLinkedList.isEmpty())
    {
      if (paramLinkedList.size() == 1) {
        paramList.add((gpc)paramLinkedList.removeFirst());
      }
    }
    else {
      return;
    }
    Object localObject1 = paramLinkedList.iterator();
    int i1 = 0;
    int i2 = 0;
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (gpf)((Iterator)localObject1).next();
      i2 += ((gpf)localObject2).a().length();
      if (a == null) {
        break label196;
      }
      i1 = a.length() + i1;
    }
    label196:
    for (;;)
    {
      break;
      localObject1 = new StringBuilder(i2);
      localObject2 = new StringBuilder(i1);
      while (!paramLinkedList.isEmpty())
      {
        gpf localgpf = (gpf)paramLinkedList.removeFirst();
        ((StringBuilder)localObject1).append(localgpf.a());
        if (a != null) {
          ((StringBuilder)localObject2).append(a);
        }
      }
      if (i1 > 0) {}
      for (paramLinkedList = ((StringBuilder)localObject2).toString();; paramLinkedList = null)
      {
        paramList.add(gow.a(((StringBuilder)localObject1).toString(), paramLinkedList));
        return;
      }
    }
  }
  
  private final gor b(String paramString)
  {
    ListIterator localListIterator = j.listIterator(j.size());
    while (localListIterator.hasPrevious())
    {
      gor localgor = ((gpy)localListIterator.previous()).b(paramString);
      if (localgor != null) {
        return localgor;
      }
    }
    return null;
  }
  
  public final int a(int paramInt1, int paramInt2)
  {
    int i1 = paramInt1;
    label94:
    Object localObject1;
    Object localObject2;
    if (i1 < paramInt2)
    {
      if ((d.charAt(i1) != '<') || (i1 + 1 >= paramInt2)) {
        break label228;
      }
      char c1 = d.charAt(i1 + 1);
      if ((c1 != '/') && (!Character.isLetter(c1)) && (c1 != '!') && (c1 != '?')) {
        break label228;
      }
      if (d.regionMatches(i1 + 1, "!--", 0, 3)) {
        a = gpm.c;
      }
    }
    else if (i1 > paramInt1)
    {
      localObject1 = d.substring(paramInt1, i1);
      if ((i1 != b) || (b >= d.length())) {
        break label262;
      }
      localObject2 = l.matcher((CharSequence)localObject1);
      if (!((Matcher)localObject2).find()) {
        break label262;
      }
      int i2 = ((Matcher)localObject2).start();
      paramInt2 = paramInt1 + i2;
      localObject1 = ((String)localObject1).substring(0, i2);
    }
    for (;;)
    {
      if (paramInt2 > paramInt1)
      {
        localObject2 = null;
        if (!g) {
          break label237;
        }
        localObject2 = localObject1;
      }
      for (;;)
      {
        localObject1 = gow.b((String)localObject1, (String)localObject2);
        e.add(localObject1);
        return i1;
        a = gpm.b;
        break label94;
        label228:
        i1 += 1;
        break;
        label237:
        if (k) {
          localObject2 = gzx.a('<').a((CharSequence)localObject1, "&lt;");
        }
      }
      label262:
      paramInt2 = i1;
    }
  }
  
  public final int b(int paramInt1, int paramInt2)
  {
    boolean bool;
    int i2;
    if (d.charAt(paramInt1) == '<')
    {
      bool = true;
      hby.a(bool);
      i2 = paramInt1 + 1;
      a = gpm.a;
      if (d.charAt(i2) != '/') {
        break label2067;
      }
      i2 += 1;
    }
    label403:
    label476:
    label552:
    label567:
    label633:
    label707:
    label763:
    label783:
    label888:
    label1011:
    label1017:
    label1032:
    label1091:
    label1120:
    label1259:
    label1265:
    label1295:
    label1348:
    label1395:
    label1456:
    label1476:
    label1495:
    label1623:
    label1638:
    label1653:
    label1729:
    label1735:
    label1741:
    label1757:
    label1780:
    label1846:
    label1878:
    label1892:
    label1907:
    label1967:
    label1973:
    label1979:
    label1985:
    label1991:
    label2055:
    label2058:
    label2061:
    label2067:
    for (int i5 = 1;; i5 = 0)
    {
      Object localObject1 = new gpn(d);
      int i1 = i2;
      char c1;
      for (;;)
      {
        if (i1 < paramInt2)
        {
          c1 = a.charAt(i1);
          if ((c1 != '>') && (c1 != '/') && (!Character.isWhitespace(c1)))
          {
            i1 += 1;
            continue;
            bool = false;
            break;
          }
        }
      }
      if (i1 > i2)
      {
        c = i2;
        d = i1;
      }
      if ((b == null) && (c != -1) && (d != -1)) {
        b = a.substring(c, d);
      }
      Object localObject4 = b;
      Object localObject3 = null;
      gpk localgpk;
      int i4;
      if (localObject4 == null)
      {
        if (i5 == 0)
        {
          if (g) {}
          for (localObject1 = "<";; localObject1 = null)
          {
            localObject1 = gow.a("<", (String)localObject1);
            e.add(localObject1);
            a = gpm.a;
            return i2;
          }
        }
        if (g) {
          localObject3 = a("");
        }
        localObject1 = null;
        localgpk = new gpk(d);
        i2 = i1;
        i4 = i1;
        if (i4 >= paramInt2) {
          break label2061;
        }
        c1 = d.charAt(i4);
        if ((i4 + 1 >= paramInt2) || (c1 != '/') || (d.charAt(i4 + 1) != '>')) {
          break label567;
        }
        i4 += 1;
      }
      for (int i3 = 1;; i3 = 0)
      {
        Object localObject2;
        if (i4 == paramInt2) {
          if (paramInt1 < paramInt2)
          {
            bool = true;
            hby.a(bool);
            localObject2 = d.substring(paramInt1, paramInt2);
            localObject1 = null;
            if (!g) {
              break label1495;
            }
            localObject1 = localObject2;
            e.add(gow.b((String)localObject2, (String)localObject1));
            return paramInt2;
            localObject2 = j.listIterator(j.size());
            for (;;)
            {
              if (((ListIterator)localObject2).hasPrevious())
              {
                localObject1 = ((gpy)((ListIterator)localObject2).previous()).a((String)localObject4);
                if (localObject1 != null)
                {
                  localObject3 = localObject1;
                  if (localObject1 != null) {
                    break;
                  }
                  if (i)
                  {
                    localObject2 = String.valueOf(localObject4);
                    if (((String)localObject2).length() == 0) {
                      break label552;
                    }
                  }
                }
              }
            }
            for (localObject2 = "Unknown element: ".concat((String)localObject2);; localObject2 = new String("Unknown element: "))
            {
              System.err.println((String)localObject2);
              localObject3 = localObject1;
              if (!g) {
                break;
              }
              localObject3 = a((String)localObject4);
              break;
              localObject1 = null;
              break label476;
            }
            if (c1 == '>') {
              continue;
            }
            if ((i5 != 0) && ('<' == c1))
            {
              if (localObject3 != null) {
                a((gos)localObject3, paramInt1, i1, i4);
              }
              a = gpm.a;
              return i4;
            }
            if (Character.isWhitespace(c1)) {
              i3 = i4 + 1;
            }
          }
        }
        for (;;)
        {
          if (i3 > i4)
          {
            bool = true;
            hby.a(bool);
            i4 = i3;
            break;
            d = -1;
            e = -1;
            f = -1;
            g = -1;
            h = false;
            b = null;
            c = null;
            i3 = localgpk.a(i4, paramInt2);
            if (i3 > i4)
            {
              bool = true;
              hby.a(bool);
              if (localgpk.a() == null) {
                break label2058;
              }
              i3 = localgpk.b(i3, paramInt2);
              localObject2 = localObject1;
              if (localObject3 != null)
              {
                if (localObject1 != null) {
                  break label2055;
                }
                localObject1 = new ArrayList();
              }
            }
          }
          for (;;)
          {
            String str3;
            gor localgor;
            String str2;
            String str1;
            if (i2 < i3)
            {
              bool = true;
              hby.a(bool);
              str3 = localgpk.a();
              if (str3 == null) {
                break label1011;
              }
              bool = true;
              hby.a(bool);
              localgor = b(str3);
              if ((c == null) && (f != -1) && (g != -1)) {
                c = a.substring(f, g);
              }
              str2 = c;
              if (localgor != null) {
                break label1032;
              }
              if (i)
              {
                localObject2 = String.valueOf(str3);
                if (((String)localObject2).length() == 0) {
                  break label1017;
                }
                localObject2 = "Unknown attribute: ".concat((String)localObject2);
                System.err.println((String)localObject2);
              }
              if (!g) {
                break label1476;
              }
              str1 = d.substring(i2, i3);
              str3 = str3.toLowerCase();
              localObject4 = (gor)n.get(str3);
              localObject2 = localObject4;
              if (localObject4 == null)
              {
                localObject2 = new gor(str3);
                n.put(str3, localObject2);
              }
              ((ArrayList)localObject1).add(gow.a((gor)localObject2, str2, str1));
              localObject2 = localObject1;
            }
            for (;;)
            {
              i2 = i3;
              localObject1 = localObject2;
              break;
              bool = false;
              break label707;
              bool = false;
              break label763;
              bool = false;
              break label783;
              localObject2 = new String("Unknown attribute: ");
              break label888;
              if (str2 == null) {}
              for (localObject2 = null;; localObject2 = Html.fromHtml(str2).toString())
              {
                if (!g) {
                  break label1091;
                }
                ((ArrayList)localObject1).add(gow.a(localgor, (String)localObject2, d.substring(i2, i3)));
                localObject2 = localObject1;
                break;
              }
              if (k)
              {
                StringBuilder localStringBuilder = new StringBuilder();
                if (i2 <= d)
                {
                  bool = true;
                  hby.a(bool);
                  str1 = d.substring(i2, d).replaceAll("\\S+", "");
                  localObject4 = str1;
                  if (str1.length() == 0) {
                    localObject4 = " ";
                  }
                  localStringBuilder.append((String)localObject4);
                  if (str2 != null) {
                    break label1265;
                  }
                  if (d >= i3) {
                    break label1259;
                  }
                }
                for (bool = true;; bool = false)
                {
                  hby.a(bool);
                  localObject4 = d.substring(d, i3);
                  localStringBuilder.append(hjv.a.a((String)localObject4));
                  ((ArrayList)localObject1).add(gow.a(localgor, (String)localObject2, localStringBuilder.toString()));
                  localObject2 = localObject1;
                  break;
                  bool = false;
                  break label1120;
                }
                localStringBuilder.append(hjv.a.a(str3));
                if (e < f)
                {
                  bool = true;
                  hby.a(bool);
                  localStringBuilder.append(d.substring(e, f));
                  if (!h) {
                    break label1395;
                  }
                  localStringBuilder.append(str2.replaceAll("<", "&lt;"));
                  if (g > i3) {
                    break label1456;
                  }
                }
                for (bool = true;; bool = false)
                {
                  hby.a(bool);
                  localStringBuilder.append(d.substring(g, i3));
                  break;
                  bool = false;
                  break label1295;
                  if (h.matcher(str2).find())
                  {
                    localStringBuilder.append('"');
                    localStringBuilder.append(str2.replaceAll("\"", "&quot;"));
                    localStringBuilder.append('"');
                    break label1348;
                  }
                  localStringBuilder.append(str2);
                  break label1348;
                }
              }
              ((ArrayList)localObject1).add(gow.a(localgor, (String)localObject2, null));
              localObject2 = localObject1;
            }
            bool = false;
            break label633;
            bool = false;
            break;
            if (!k) {
              break label403;
            }
            localObject1 = gzx.a('<').a(d.substring(paramInt1, paramInt2), "&lt;");
            break label403;
            if (d.charAt(i4) == '>') {}
            for (bool = true;; bool = false)
            {
              hby.a(bool);
              i4 += 1;
              if (localObject3 != null)
              {
                if (i5 == 0) {
                  break;
                }
                a((gos)localObject3, paramInt1, i1, i4);
              }
              return i4;
            }
            if ((gou.au.equals(localObject3)) || (gou.aA.equals(localObject3))) {
              a = gpm.d;
            }
            if (paramInt1 < i1)
            {
              bool = true;
              hby.a(bool);
              if (i1 > i2) {
                break label1729;
              }
              bool = true;
              hby.a(bool);
              if (i2 > i4) {
                break label1735;
              }
              bool = true;
              hby.a(bool);
              if (!g) {
                break label1757;
              }
              localObject2 = d.substring(paramInt1, i1);
              localObject4 = d.substring(i2, i4);
              if (i3 == 0) {
                break label1741;
              }
            }
            for (localObject1 = gow.b((gos)localObject3, (List)localObject1, (String)localObject2, (String)localObject4);; localObject1 = gow.a((gos)localObject3, (List)localObject1, (String)localObject2, (String)localObject4))
            {
              e.add(localObject1);
              break;
              bool = false;
              break label1623;
              bool = false;
              break label1638;
              bool = false;
              break label1653;
            }
            if (k)
            {
              if (d.charAt(paramInt1) == '<')
              {
                bool = true;
                hby.a(bool);
                localObject2 = new StringBuilder("<");
                localObject4 = d.substring(paramInt1 + 1, i1);
                ((StringBuilder)localObject2).append(hjv.a.a((String)localObject4));
                paramInt2 = i4 - 1;
                if (d.charAt(paramInt2) != '>') {
                  break label1967;
                }
                bool = true;
                hby.a(bool);
                paramInt1 = paramInt2;
                if (i3 != 0)
                {
                  paramInt1 = paramInt2 - 1;
                  if (d.charAt(paramInt1) != '/') {
                    break label1973;
                  }
                  bool = true;
                  hby.a(bool);
                }
                if (i2 > paramInt1) {
                  break label1979;
                }
                bool = true;
                hby.a(bool);
                if (i2 >= i4) {
                  break label1985;
                }
                bool = true;
                hby.a(bool);
                localObject4 = d.substring(i2, i4);
                if (i3 == 0) {
                  break label1991;
                }
              }
              for (localObject1 = gow.b((gos)localObject3, (List)localObject1, ((StringBuilder)localObject2).toString(), (String)localObject4);; localObject1 = gow.a((gos)localObject3, (List)localObject1, ((StringBuilder)localObject2).toString(), (String)localObject4))
              {
                e.add(localObject1);
                break;
                bool = false;
                break label1780;
                bool = false;
                break label1846;
                bool = false;
                break label1878;
                bool = false;
                break label1892;
                bool = false;
                break label1907;
              }
            }
            if (i3 != 0) {}
            for (localObject1 = gow.b((gos)localObject3, (List)localObject1, null, null);; localObject1 = gow.a((gos)localObject3, (List)localObject1, null, null))
            {
              e.add(localObject1);
              break;
            }
          }
        }
      }
    }
  }
  
  public final int c(int paramInt1, int paramInt2)
  {
    Object localObject = e.get(e.size() - 1)).a;
    if ((gou.au.equals(localObject)) || (gou.aA.equals(localObject))) {}
    int i1;
    for (boolean bool = true;; bool = false)
    {
      hby.a(bool);
      i1 = paramInt1;
      while ((i1 < paramInt2) && ((i1 + 2 >= paramInt2) || (d.charAt(i1) != '<') || (d.charAt(i1 + 1) != '/') || (!d.regionMatches(true, i1 + 2, a, 0, a.length())))) {
        i1 += 1;
      }
    }
    if (i1 > paramInt1)
    {
      localObject = new gox(d.substring(paramInt1, i1));
      e.add(localObject);
    }
    a = gpm.b;
    return i1;
  }
}

/* Location:
 * Qualified Name:     gpi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */