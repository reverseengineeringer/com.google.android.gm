import java.util.ArrayList;

final class ife
{
  static ife a = new ife();
  
  private final ifi a(ifg paramifg, ifl paramifl)
  {
    paramifl = new iff(paramifl);
    return new ifi(paramifg, a((ifr)paramifl.a(), true), a((ifp)paramifl.a(), true));
  }
  
  private final ifi a(ifo paramifo)
  {
    paramifo = new iff(paramifo);
    Object localObject1 = null;
    Object localObject2 = paramifo.a();
    if ((localObject2 instanceof ifv))
    {
      localObject2 = (ifv)localObject2;
      localObject1 = new ArrayList(((ifv)localObject2).a());
      localObject2 = new iff((igh)localObject2);
      while (((iff)localObject2).hasNext())
      {
        ige localige = ((iff)localObject2).a();
        if ((localige instanceof ifp)) {
          ((ArrayList)localObject1).add(a((ifp)localige, true));
        } else {
          throw new IllegalStateException();
        }
      }
      localObject1 = new ifg((ArrayList)localObject1);
      paramifo = paramifo.a();
    }
    while ((paramifo instanceof ifl))
    {
      return a((ifg)localObject1, (ifl)paramifo);
      paramifo = (ifo)localObject2;
      if (!(localObject2 instanceof ifl)) {
        throw new IllegalStateException();
      }
    }
    throw new IllegalStateException();
  }
  
  private final ifj a(ifq paramifq)
  {
    ArrayList localArrayList = new ArrayList();
    iff localiff = new iff(paramifq);
    if (localiff.hasNext())
    {
      paramifq = localiff.a();
      if ((paramifq instanceof ifs))
      {
        paramifq = new iff((ifs)paramifq).a();
        if ((paramifq instanceof ifl)) {
          paramifq = a(null, (ifl)paramifq);
        }
        for (;;)
        {
          localArrayList.add(paramifq);
          break;
          if ((paramifq instanceof ifo))
          {
            paramifq = a((ifo)paramifq);
          }
          else
          {
            if (!(paramifq instanceof ift)) {
              break label193;
            }
            paramifq = new iff((ift)paramifq);
            Object localObject = paramifq.a();
            if (!(localObject instanceof ifu)) {
              break label177;
            }
            localObject = a((ifu)localObject, false);
            paramifq = paramifq.a();
            if (!(paramifq instanceof ifo)) {
              break label185;
            }
            paramifq = new ifk(ieh.a((String)localObject), a((ifo)paramifq));
          }
        }
        label177:
        throw new IllegalStateException();
        label185:
        throw new IllegalStateException();
        label193:
        throw new IllegalStateException();
      }
      throw new IllegalStateException();
    }
    return new ifj(localArrayList, true);
  }
  
  private final String a(igh paramigh, boolean paramBoolean)
  {
    igi localigi1 = a;
    igi localigi2 = b;
    StringBuffer localStringBuffer = new StringBuffer();
    paramigh = localigi1;
    while (paramigh != localigi2)
    {
      localStringBuffer.append(f);
      localigi1 = g;
      paramigh = localigi1;
      if (!paramBoolean)
      {
        a(localStringBuffer, h);
        paramigh = localigi1;
      }
    }
    localStringBuffer.append(f);
    return localStringBuffer.toString();
  }
  
  private final void a(StringBuffer paramStringBuffer, igi paramigi)
  {
    if (paramigi != null)
    {
      a(paramStringBuffer, h);
      paramStringBuffer.append(f);
    }
  }
  
  public final ifd a(ifn paramifn)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramifn.a())
    {
      Object localObject1 = new iff((ifm)d[i]);
      Object localObject2 = ((iff)localObject1).a();
      if ((localObject2 instanceof ifl)) {
        localObject1 = a(null, (ifl)localObject2);
      }
      for (;;)
      {
        localArrayList.add(localObject1);
        i += 1;
        break;
        if ((localObject2 instanceof ifo))
        {
          localObject1 = a((ifo)localObject2);
        }
        else
        {
          if (!(localObject2 instanceof ifu)) {
            break label188;
          }
          localObject2 = a((ifu)localObject2, false);
          localObject1 = ((iff)localObject1).a();
          if ((localObject1 instanceof ifq))
          {
            localObject1 = new ifh((String)localObject2, a((ifq)localObject1));
          }
          else
          {
            if (!(localObject1 instanceof ifo)) {
              break label180;
            }
            localObject1 = new ifk(ieh.a((String)localObject2), a((ifo)localObject1));
          }
        }
      }
      label180:
      throw new IllegalStateException();
      label188:
      throw new IllegalStateException();
    }
    return new ifd(localArrayList);
  }
}

/* Location:
 * Qualified Name:     ife
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */