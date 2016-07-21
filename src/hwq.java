import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public final class hwq
  extends TimeZone
{
  private static final long serialVersionUID = -5620979316746547234L;
  private final hyc a;
  private final int b;
  
  protected hwq()
  {
    a = null;
    b = 0;
  }
  
  public hwq(hyc paramhyc)
  {
    a = paramhyc;
    setID(((ibu)paramhyc.b("TZID")).a());
    b = a(paramhyc);
  }
  
  private static final int a(hyc paramhyc)
  {
    Object localObject1 = null;
    Object localObject3 = d.a("STANDARD");
    Object localObject2 = localObject3;
    if (((List)localObject3).isEmpty())
    {
      paramhyc = d.a("DAYLIGHT");
      localObject2 = paramhyc;
      if (paramhyc.isEmpty()) {
        return 0;
      }
    }
    int i;
    if (((List)localObject2).size() > 1)
    {
      hsq localhsq = new hsq();
      i = 0;
      paramhyc = null;
      label72:
      localObject3 = paramhyc;
      if (i >= ((List)localObject2).size()) {
        break label157;
      }
      hxc localhxc = (hxc)((List)localObject2).get(i);
      localObject3 = localhxc.a(localhsq);
      if ((localObject3 == null) || ((localObject1 != null) && (!((Date)localObject3).after((Date)localObject1)))) {
        break label186;
      }
      localObject1 = localhxc;
      paramhyc = (hyc)localObject3;
    }
    for (;;)
    {
      i += 1;
      localObject3 = localObject1;
      localObject1 = paramhyc;
      paramhyc = (hyc)localObject3;
      break label72;
      localObject3 = (hxc)((List)localObject2).get(0);
      label157:
      if (localObject3 == null) {
        break;
      }
      paramhyc = (ibx)((hxc)localObject3).b("TZOFFSETTO");
      if (paramhyc == null) {
        break;
      }
      return (int)c.a;
      label186:
      localObject3 = paramhyc;
      paramhyc = (hyc)localObject1;
      localObject1 = localObject3;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (hwq)paramObject;
      if (b != b) {
        return false;
      }
      if (a == null) {
        break;
      }
    } while (a.equals(a));
    for (;;)
    {
      return false;
      if (a == null) {
        break;
      }
    }
  }
  
  public final int getOffset(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    int i = 0;
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).set(0, paramInt1);
    ((Calendar)localObject).set(1, paramInt2);
    ((Calendar)localObject).set(2, paramInt3);
    ((Calendar)localObject).set(6, paramInt4);
    ((Calendar)localObject).set(7, paramInt5);
    ((Calendar)localObject).set(14, paramInt6);
    localObject = a.a(new hsq(((Calendar)localObject).getTime()));
    paramInt1 = i;
    if (localObject != null) {
      paramInt1 = (int)b"TZOFFSETTO"c.a;
    }
    return paramInt1;
  }
  
  public final int getOffset(long paramLong)
  {
    Object localObject = a.a(new hsq(paramLong));
    if (localObject != null)
    {
      localObject = (ibx)((hxc)localObject).b("TZOFFSETTO");
      if (c.a < getRawOffset()) {
        return getRawOffset();
      }
      return (int)c.a;
    }
    return 0;
  }
  
  public final int getRawOffset()
  {
    return b;
  }
  
  public final int hashCode()
  {
    if (a != null) {}
    for (int i = a.hashCode();; i = 0) {
      return i * 31 + b;
    }
  }
  
  public final boolean inDaylightTime(Date paramDate)
  {
    paramDate = a.a(new hsq(paramDate));
    return (paramDate != null) && ((paramDate instanceof hxb));
  }
  
  public final void setRawOffset(int paramInt)
  {
    throw new UnsupportedOperationException("Updates to the VTIMEZONE object must be performed directly");
  }
  
  public final boolean useDaylightTime()
  {
    return !a.d.a("DAYLIGHT").isEmpty();
  }
}

/* Location:
 * Qualified Name:     hwq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */