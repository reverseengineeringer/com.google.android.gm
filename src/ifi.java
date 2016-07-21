import java.util.ArrayList;

public class ifi
  extends ifc
{
  ifg a;
  String b;
  String c;
  
  public ifi(ifg paramifg, String paramString1, String paramString2)
  {
    a = paramifg;
    b = paramString1;
    c = paramString2;
  }
  
  public String a(boolean paramBoolean)
  {
    Object localObject1;
    String str1;
    if ((!paramBoolean) || (a == null))
    {
      localObject1 = "";
      str1 = b;
      if (c != null) {
        break label233;
      }
    }
    label233:
    for (Object localObject2 = "";; localObject2 = "@")
    {
      String str2 = c;
      return String.valueOf(localObject1).length() + 2 + String.valueOf(str1).length() + String.valueOf(localObject2).length() + String.valueOf(str2).length() + "<" + (String)localObject1 + str1 + (String)localObject2 + str2 + ">";
      localObject1 = a;
      localObject2 = new StringBuffer();
      int i = 0;
      while (i < a.size())
      {
        ((StringBuffer)localObject2).append("@");
        if ((i < 0) || (a.size() <= i)) {
          throw new IndexOutOfBoundsException();
        }
        ((StringBuffer)localObject2).append((String)a.get(i));
        if (i + 1 < a.size()) {
          ((StringBuffer)localObject2).append(",");
        }
        i += 1;
      }
      localObject1 = String.valueOf(((StringBuffer)localObject2).toString()).concat(":");
      break;
    }
  }
  
  protected final void a(ArrayList<ifc> paramArrayList)
  {
    paramArrayList.add(this);
  }
  
  public String toString()
  {
    return a(false);
  }
}

/* Location:
 * Qualified Name:     ifi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */