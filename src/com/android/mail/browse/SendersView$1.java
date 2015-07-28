package com.android.mail.browse;

import com.android.mail.utils.ObjectCache.Callback;
import com.google.common.collect.Maps;
import java.util.Map;

final class SendersView$1
  implements ObjectCache.Callback<Map<Integer, Integer>>
{
  public Map<Integer, Integer> newInstance()
  {
    return Maps.newHashMap();
  }
  
  public void onObjectReleased(Map<Integer, Integer> paramMap)
  {
    paramMap.clear();
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.SendersView.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */