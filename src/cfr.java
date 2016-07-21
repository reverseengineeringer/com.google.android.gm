import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class cfr
{
  public static final String f = cvl.a;
  public final Context b;
  public final String c;
  public final SharedPreferences d;
  public final SharedPreferences.Editor e;
  
  public cfr(Context paramContext, String paramString)
  {
    b = paramContext.getApplicationContext();
    c = paramString;
    d = paramContext.getSharedPreferences(paramString, 0);
    e = d.edit();
    int j = d.getInt("prefs-version-number", 0);
    a(j);
    e.putInt("prefs-version-number", 4);
    if (n()) {
      e.apply();
    }
    if (!r_())
    {
      if (cfo.a == null) {
        break label145;
      }
      paramString = cfo.a.a();
      if (paramString == null) {
        break label150;
      }
      if (cfj.a.getAndSet(false))
      {
        paramString.a(paramContext, j);
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0) {
        i_();
      }
      return;
      label145:
      paramString = null;
      break;
      label150:
      cvm.d(cvm.a, "No preference migrator found, not migrating preferences", new Object[0]);
    }
  }
  
  Object a(String paramString, Object paramObject)
  {
    return paramObject;
  }
  
  public abstract void a(int paramInt);
  
  public final void a(List<cfi> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      cfi localcfi = (cfi)paramList.next();
      String str = localcfi.a();
      Object localObject1 = localcfi.b();
      if ((a(str)) && (localObject1 != null))
      {
        Object localObject2 = b(str, localObject1);
        if ((localObject2 instanceof Boolean))
        {
          e.putBoolean(str, ((Boolean)localObject2).booleanValue());
          cvm.a(f, "MailPrefs Restore: %s", new Object[] { localcfi });
        }
        else if ((localObject2 instanceof Float))
        {
          e.putFloat(str, ((Float)localObject2).floatValue());
          cvm.a(f, "MailPrefs Restore: %s", new Object[] { localcfi });
        }
        else if ((localObject2 instanceof Integer))
        {
          e.putInt(str, ((Integer)localObject2).intValue());
          cvm.a(f, "MailPrefs Restore: %s", new Object[] { localcfi });
        }
        else if ((localObject2 instanceof Long))
        {
          e.putLong(str, ((Long)localObject2).longValue());
          cvm.a(f, "MailPrefs Restore: %s", new Object[] { localcfi });
        }
        else if ((localObject2 instanceof String))
        {
          e.putString(str, (String)localObject2);
          cvm.a(f, "MailPrefs Restore: %s", new Object[] { localcfi });
        }
        else if ((localObject2 instanceof Set))
        {
          e.putStringSet(str, (Set)localObject2);
        }
        else
        {
          cvm.e(f, "Unknown MailPrefs preference data type: %s", new Object[] { localObject1.getClass() });
        }
      }
    }
    e.apply();
  }
  
  public abstract boolean a(String paramString);
  
  Object b(String paramString, Object paramObject)
  {
    return paramObject;
  }
  
  void i_()
  {
    cfm.a(b).i_();
  }
  
  public final void l()
  {
    e.commit();
  }
  
  public final List<cfi> m()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = d.getAll().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      if (a(str))
      {
        localObject = a(str, ((Map.Entry)localObject).getValue());
        if (localObject != null) {
          localArrayList.add(new cfq(str, localObject));
        }
      }
    }
    return localArrayList;
  }
  
  public final boolean n()
  {
    Iterator localIterator = d.getAll().keySet().iterator();
    while (localIterator.hasNext()) {
      if (a((String)localIterator.next())) {
        return true;
      }
    }
    return false;
  }
  
  boolean r_()
  {
    return cfm.a(b).r_();
  }
}

/* Location:
 * Qualified Name:     cfr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */