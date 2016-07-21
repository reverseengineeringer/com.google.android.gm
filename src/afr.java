import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class afr
  implements afq
{
  private final Map<ComponentName, afp> b = new HashMap();
  
  afr(afo paramafo) {}
  
  public final void a(List<afp> paramList)
  {
    Map localMap = b;
    localMap.clear();
    int j = paramList.size();
    int i = 0;
    Object localObject2;
    while (i < j)
    {
      localObject2 = (afp)paramList.get(i);
      b = 0.0F;
      localMap.put(new ComponentName(a.activityInfo.packageName, a.activityInfo.name), localObject2);
      i += 1;
    }
    Object localObject1;
    i = ((List)localObject1).size();
    float f1 = 1.0F;
    i -= 1;
    if (i >= 0)
    {
      localObject2 = (afs)((List)localObject1).get(i);
      afp localafp = (afp)localMap.get(a);
      if (localafp == null) {
        break label195;
      }
      float f2 = b;
      b = (c * f1 + f2);
      f1 = 0.95F * f1;
    }
    label195:
    for (;;)
    {
      i -= 1;
      break;
      Collections.sort(paramList);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     afr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */