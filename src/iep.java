import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class iep
  implements iev
{
  private static idy a = new idy();
  
  public final ieu a(String paramString1, String paramString2, String paramString3)
  {
    localObject9 = null;
    localObject8 = null;
    localObject3 = "";
    localObject10 = new igk(new StringReader(paramString2));
    try
    {
      ((igk)localObject10).a();
      ((igk)localObject10).a(0);
      Object localObject5 = null;
    }
    catch (ign localign1)
    {
      for (;;)
      {
        try
        {
          localObject11 = a;
          localObject1 = localObject3;
          String str = b;
          localObject7 = localObject9;
          localObject6 = localObject3;
          if (localObject11 != null)
          {
            localObject7 = localObject9;
            localObject6 = localObject3;
            if (str != null)
            {
              localObject1 = localObject3;
              localObject6 = String.valueOf(b);
              localObject1 = localObject3;
              localObject3 = (String.valueOf(localObject11).length() + 1 + String.valueOf(localObject6).length() + (String)localObject11 + "/" + (String)localObject6).toLowerCase();
              localObject1 = localObject3;
              localObject11 = c;
              localObject1 = localObject3;
              localObject10 = d;
              localObject7 = localObject9;
              localObject6 = localObject3;
              if (localObject11 != null)
              {
                localObject7 = localObject9;
                localObject6 = localObject3;
                if (localObject10 != null)
                {
                  i = 0;
                  localObject1 = localObject8;
                  localObject7 = localObject1;
                  localObject6 = localObject3;
                }
              }
            }
          }
        }
        catch (NullPointerException localNullPointerException1)
        {
          Object localObject1;
          Object localObject11;
          Object localObject7;
          int i;
          ign localign2;
          Object localObject6 = null;
          Object localObject4 = localObject2;
          Object localObject2 = localObject6;
          continue;
        }
        try
        {
          if (i < ((ArrayList)localObject11).size())
          {
            localObject7 = localObject1;
            localObject6 = localObject3;
            if (i < ((ArrayList)localObject10).size())
            {
              if (localObject1 != null) {
                break label402;
              }
              localObject6 = new HashMap((int)(((ArrayList)localObject11).size() * 1.3D + 1.0D));
              localObject1 = localObject6;
            }
          }
        }
        catch (NullPointerException localNullPointerException3)
        {
          continue;
          continue;
        }
        try
        {
          ((Map)localObject1).put(((String)((ArrayList)localObject11).get(i)).toLowerCase(), (String)((ArrayList)localObject10).get(i));
          i += 1;
        }
        catch (NullPointerException localNullPointerException2)
        {
          continue;
        }
        localign1 = localign1;
        idy.a();
      }
    }
    catch (igq localigq)
    {
      for (;;)
      {
        idy.a();
        localign2 = new ign(localigq.getMessage());
      }
      localObject2 = localObject7;
      localObject3 = localObject6;
      return new ieo(paramString1, paramString2, paramString3, (String)localObject3, (Map)localObject2, localign2);
    }
    localObject1 = localObject3;
  }
}

/* Location:
 * Qualified Name:     iep
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */