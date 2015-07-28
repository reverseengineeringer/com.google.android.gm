package com.android.mail.ui;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import com.android.mail.utils.Utils;

public class SearchMailActionBarView
  extends MailActionBarView
{
  public SearchMailActionBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SearchMailActionBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SearchMailActionBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void clearSearchFocus()
  {
    MenuItem localMenuItem = getSearch();
    if (localMenuItem != null) {
      ((SearchView)localMenuItem.getActionView()).clearFocus();
    }
  }
  
  private void setPopulatedSearchView()
  {
    Object localObject = getSearch();
    if (localObject != null)
    {
      ((MenuItem)localObject).expandActionView();
      String str = mActivity.getIntent().getStringExtra("query");
      localObject = (SearchView)((MenuItem)localObject).getActionView();
      if (!TextUtils.isEmpty(str)) {
        ((SearchView)localObject).setQuery(str, false);
      }
      ((SearchView)localObject).clearFocus();
    }
  }
  
  public boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
  {
    super.onMenuItemActionCollapse(paramMenuItem);
    int i = getMode();
    if ((i == 4) || ((Utils.showTwoPaneSearchResults(getContext())) && (i == 5))) {
      mController.exitSearchMode();
    }
    return true;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    super.onPrepareOptionsMenu(paramMenu);
    switch (getMode())
    {
    }
    for (;;)
    {
      return false;
      mActionBar.setDisplayHomeAsUpEnabled(true);
      setEmptyMode();
      if (!showConversationSubject()) {
        setPopulatedSearchView();
      }
      clearSearchFocus();
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.SearchMailActionBarView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */