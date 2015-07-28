package com.google.android.gm.provider;

import java.util.ArrayList;
import java.util.List;

final class CompactSenderInstructions$1
  implements ObjectCache.Callback<List<String>>
{
  public List<String> newInstance()
  {
    return new ArrayList(8);
  }
  
  public void onObjectReleased(List<String> paramList)
  {
    paramList.clear();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.CompactSenderInstructions.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */