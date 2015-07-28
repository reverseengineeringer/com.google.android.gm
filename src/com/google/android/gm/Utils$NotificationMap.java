package com.google.android.gm;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gm.persistence.Persistence;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class Utils$NotificationMap
  extends ConcurrentHashMap<Utils.NotificationKey, Pair<Integer, Integer>>
{
  public Integer getUnread(Utils.NotificationKey paramNotificationKey)
  {
    paramNotificationKey = (Pair)get(paramNotificationKey);
    if (paramNotificationKey != null) {
      return (Integer)first;
    }
    return null;
  }
  
  public Integer getUnseen(Utils.NotificationKey paramNotificationKey)
  {
    paramNotificationKey = (Pair)get(paramNotificationKey);
    if (paramNotificationKey != null) {
      return (Integer)second;
    }
    return null;
  }
  
  public void loadNotificationMap(Context paramContext)
  {
    try
    {
      paramContext = Persistence.getInstance().getActiveNotificationSet(paramContext);
      if (paramContext != null)
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          String[] arrayOfString = TextUtils.split((String)paramContext.next(), " ");
          if (arrayOfString.length == 4) {
            put(new Utils.NotificationKey(arrayOfString[0], arrayOfString[1]), new Pair(Integer.valueOf(arrayOfString[2]), Integer.valueOf(arrayOfString[3])));
          }
        }
      }
    }
    finally {}
  }
  
  public void put(Utils.NotificationKey paramNotificationKey, int paramInt1, int paramInt2)
  {
    put(paramNotificationKey, new Pair(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)));
  }
  
  public void saveNotificationMap(Context paramContext)
  {
    try
    {
      HashSet localHashSet = Sets.newHashSet();
      Iterator localIterator = keySet().iterator();
      while (localIterator.hasNext())
      {
        Utils.NotificationKey localNotificationKey = (Utils.NotificationKey)localIterator.next();
        Pair localPair = (Pair)get(localNotificationKey);
        Integer localInteger1 = (Integer)first;
        Integer localInteger2 = (Integer)second;
        if ((localPair != null) && (localInteger1 != null) && (localInteger2 != null)) {
          localHashSet.add(TextUtils.join(" ", new String[] { account, label, localInteger1.toString(), localInteger2.toString() }));
        }
      }
      Persistence.getInstance().cacheActiveNotificationSet(paramContext, localHashSet);
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.Utils.NotificationMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */