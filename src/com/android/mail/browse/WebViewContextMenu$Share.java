package com.android.mail.browse;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WebViewContextMenu$Share
  implements MenuItem.OnMenuItemClickListener
{
  private final String mUri;
  
  public WebViewContextMenu$Share(WebViewContextMenu paramWebViewContextMenu, String paramString)
  {
    mUri = paramString;
  }
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    WebViewContextMenu.access$100(this$0, mUri);
    return true;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.WebViewContextMenu.Share
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */