import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.android.mail.providers.Folder;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public final class cup
{
  public static SpannableStringBuilder a(String paramString, Context paramContext)
  {
    CharSequence localCharSequence = null;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = paramString.split("/");
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = localObject.length;
      if (i <= 2) {
        break label182;
      }
      paramString = localObject[0];
      localCharSequence = localObject[(i - 2)];
      localObject = localObject[(i - 1)];
      if (TextUtils.isEmpty(localCharSequence)) {
        break label216;
      }
      if (i <= 3) {
        break label209;
      }
      i = buj.ck;
      label79:
      localSpannableStringBuilder.append(paramContext.getResources().getString(i, new Object[] { paramString, localCharSequence }));
    }
    for (;;)
    {
      i = localSpannableStringBuilder.length();
      if (i > 0) {
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(btz.s)), 0, i, 33);
      }
      localSpannableStringBuilder.append((CharSequence)localObject);
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(btz.Z)), i, localSpannableStringBuilder.length(), 33);
      return localSpannableStringBuilder;
      label182:
      if (i > 1)
      {
        paramString = localObject[0];
        localObject = localObject[(i - 1)];
        break;
      }
      localObject = localObject[0];
      paramString = null;
      break;
      label209:
      i = buj.cj;
      break label79;
      label216:
      if (!TextUtils.isEmpty(paramString)) {
        localSpannableStringBuilder.append(paramContext.getResources().getString(buj.cl, new Object[] { paramString }));
      }
    }
  }
  
  public static void a(List<cuq> paramList)
  {
    cur localcur = new cur(null);
    d = true;
    HashMap localHashMap = new HashMap(paramList.size());
    localHashMap.put(Uri.EMPTY, localcur);
    Iterator localIterator = paramList.iterator();
    Object localObject2;
    Object localObject1;
    while (localIterator.hasNext())
    {
      localObject2 = (cuq)localIterator.next();
      Folder localFolder = a;
      localObject1 = (cur)localHashMap.get(c.a());
      if (localObject1 == null)
      {
        localObject1 = new cur((cuq)localObject2);
        localHashMap.put(c.a(), localObject1);
      }
      for (;;)
      {
        if (!cxa.b(a.v)) {
          break label158;
        }
        localcur.a((cur)localObject1);
        break;
        a = ((cuq)localObject2);
      }
      label158:
      localObject3 = (cur)localHashMap.get(v);
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        localObject2 = new cur(null);
        localHashMap.put(v, localObject2);
      }
      ((cur)localObject2).a((cur)localObject1);
    }
    paramList.clear();
    Object localObject3 = new ArrayDeque(10);
    ((Deque)localObject3).push(localcur);
    localcur = (cur)((Deque)localObject3).poll();
    if (localcur != null)
    {
      localObject1 = (cur)((Deque)localObject3).peek();
      if ((localObject1 != null) && (!d))
      {
        if ((a == null) || (TextUtils.isEmpty(a.c)))
        {
          localObject1 = a.a.d;
          a.c = ((String)localObject1);
          paramList.add(a);
          d = true;
        }
      }
      else {
        if (b.size() <= 0) {
          break label517;
        }
      }
      label517:
      for (localObject1 = (cur)b.remove(0);; localObject1 = null)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = (cur)c.poll();
        }
        if (localObject2 == null) {
          break;
        }
        ((Deque)localObject3).push(localcur);
        ((Deque)localObject3).push(localObject2);
        break;
        if (a.a.a()) {
          a.d = a;
        }
        for (;;)
        {
          localObject1 = a.c;
          localObject2 = a.a.d;
          localObject1 = String.valueOf(localObject1).length() + 1 + String.valueOf(localObject2).length() + (String)localObject1 + "/" + (String)localObject2;
          break;
          if (a.d != null) {
            a.d = a.d;
          }
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     cup
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */