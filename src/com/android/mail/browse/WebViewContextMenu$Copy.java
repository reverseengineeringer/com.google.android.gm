package com.android.mail.browse;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WebViewContextMenu$Copy
  implements MenuItem.OnMenuItemClickListener
{
  private final CharSequence mText;
  
  public WebViewContextMenu$Copy(WebViewContextMenu paramWebViewContextMenu, CharSequence paramCharSequence)
  {
    mText = paramCharSequence;
  }
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    WebViewContextMenu.access$000(this$0, mText);
    return true;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.WebViewContextMenu.Copy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */