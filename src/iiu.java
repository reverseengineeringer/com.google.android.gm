import java.util.LinkedList;
import java.util.List;

public final class iiu
{
  public static void a(String paramString, iiw paramiiw)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramiiw = new ijm(paramiiw);
    if (b.size() > 256) {
      throw new IllegalStateException();
    }
    a = 256;
    paramiiw.a();
    iim localiim = new iim(str);
    LinkedList localLinkedList = hgd.b();
    ijd localijd;
    int j;
    while (localiim.a())
    {
      localijd = localiim.b();
      switch (iiv.a[(c - 1)])
      {
      default: 
        break;
      case 4: 
        paramiiw.a(ihz.a(str.substring(a, b)));
        break;
      case 5: 
        paramiiw.a(ihz.b(str.substring(a, b)));
        break;
      case 6: 
        if (str.charAt(a + 1) == '/')
        {
          paramiiw.b(iim.a(str.substring(a + 2, b)));
          while ((localiim.a()) && (bc != ije.i)) {}
        }
        else
        {
          localLinkedList.clear();
          i = 1;
          for (;;)
          {
            if (localiim.a())
            {
              paramString = localiim.b();
              switch (iiv.a[(c - 1)])
              {
              default: 
                break;
              case 1: 
                if (i == 0) {
                  localLinkedList.add(localLinkedList.getLast());
                }
                for (;;)
                {
                  localLinkedList.add(iim.a(str.substring(a, b)));
                  break;
                  i = 0;
                }
              case 2: 
                paramString = str.substring(a, b);
                j = paramString.length();
                if (j > 0)
                {
                  i = paramString.charAt(j - 1);
                  if ((i == 34) || (i == 39)) {
                    if ((j == 1) || (i != paramString.charAt(0))) {
                      break label483;
                    }
                  }
                }
                break;
              }
            }
          }
        }
        break;
      }
    }
    label483:
    for (int i = 1;; i = 0)
    {
      paramString = paramString.substring(i, j - 1);
      for (;;)
      {
        localLinkedList.add(ihz.a(paramString));
        i = 1;
        break;
      }
      if (i == 0) {
        localLinkedList.add(localLinkedList.getLast());
      }
      paramiiw.a(iim.a(str.substring(a + 1, b)), localLinkedList);
      break;
      paramiiw.b();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     iiu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */