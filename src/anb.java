public final class anb
{
  public final ns<alj, anc> a = new ns();
  public final nx<alj> b = new nx();
  
  public final aku a(alj paramalj, int paramInt)
  {
    Object localObject2 = null;
    int i = a.a(paramalj);
    Object localObject1;
    if (i < 0) {
      localObject1 = localObject2;
    }
    anc localanc;
    do
    {
      do
      {
        return (aku)localObject1;
        localanc = (anc)a.c(i);
        localObject1 = localObject2;
      } while (localanc == null);
      localObject1 = localObject2;
    } while ((a & paramInt) == 0);
    a &= (paramInt ^ 0xFFFFFFFF);
    if (paramInt == 4) {}
    for (paramalj = b;; paramalj = c)
    {
      localObject1 = paramalj;
      if ((a & 0xC) != 0) {
        break;
      }
      a.d(i);
      anc.a(localanc);
      return paramalj;
      if (paramInt != 8) {
        break label129;
      }
    }
    label129:
    throw new IllegalArgumentException("Must provide flag PRE or POST");
  }
  
  public final void a()
  {
    a.clear();
    b.b();
  }
  
  public final void a(long paramLong, alj paramalj)
  {
    b.b(paramLong, paramalj);
  }
  
  public final void a(alj paramalj, aku paramaku)
  {
    anc localanc2 = (anc)a.get(paramalj);
    anc localanc1 = localanc2;
    if (localanc2 == null)
    {
      localanc1 = anc.a();
      a.put(paramalj, localanc1);
    }
    b = paramaku;
    a |= 0x4;
  }
  
  public final void a(and paramand)
  {
    int i = a.size() - 1;
    if (i >= 0)
    {
      alj localalj = (alj)a.b(i);
      anc localanc = (anc)a.d(i);
      if ((a & 0x3) == 3) {
        paramand.a(localalj);
      }
      for (;;)
      {
        anc.a(localanc);
        i -= 1;
        break;
        if ((a & 0x1) != 0)
        {
          if (b == null) {
            paramand.a(localalj);
          } else {
            paramand.a(localalj, b, c);
          }
        }
        else if ((a & 0xE) == 14) {
          paramand.b(localalj, b, c);
        } else if ((a & 0xC) == 12) {
          paramand.c(localalj, b, c);
        } else if ((a & 0x4) != 0) {
          paramand.a(localalj, b, null);
        } else if ((a & 0x8) != 0) {
          paramand.b(localalj, b, c);
        } else {
          int j = a;
        }
      }
    }
  }
  
  public final boolean a(alj paramalj)
  {
    paramalj = (anc)a.get(paramalj);
    return (paramalj != null) && ((a & 0x1) != 0);
  }
  
  final void b(alj paramalj)
  {
    anc localanc2 = (anc)a.get(paramalj);
    anc localanc1 = localanc2;
    if (localanc2 == null)
    {
      localanc1 = anc.a();
      a.put(paramalj, localanc1);
    }
    a |= 0x1;
  }
  
  public final void b(alj paramalj, aku paramaku)
  {
    anc localanc2 = (anc)a.get(paramalj);
    anc localanc1 = localanc2;
    if (localanc2 == null)
    {
      localanc1 = anc.a();
      a.put(paramalj, localanc1);
    }
    c = paramaku;
    a |= 0x8;
  }
  
  final void c(alj paramalj)
  {
    paramalj = (anc)a.get(paramalj);
    if (paramalj == null) {
      return;
    }
    a &= 0xFFFFFFFE;
  }
  
  final void d(alj paramalj)
  {
    int i = b.a() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        if (paramalj == b.c(i)) {
          b.a(i);
        }
      }
      else
      {
        paramalj = (anc)a.remove(paramalj);
        if (paramalj != null) {
          anc.a(paramalj);
        }
        return;
      }
      i -= 1;
    }
  }
}

/* Location:
 * Qualified Name:     anb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */