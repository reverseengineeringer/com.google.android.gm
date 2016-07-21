import java.util.ArrayList;

public final class ifj
{
  public ArrayList<ifc> a;
  
  public ifj(ArrayList<ifc> paramArrayList, boolean paramBoolean)
  {
    if (paramArrayList != null)
    {
      if (paramBoolean) {}
      for (;;)
      {
        a = paramArrayList;
        return;
        paramArrayList = new ArrayList(paramArrayList);
      }
    }
    a = new ArrayList(0);
  }
  
  public final ifi a(int paramInt)
  {
    if ((paramInt < 0) || (a.size() <= paramInt)) {
      throw new IndexOutOfBoundsException();
    }
    return (ifi)a.get(paramInt);
  }
}

/* Location:
 * Qualified Name:     ifj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */