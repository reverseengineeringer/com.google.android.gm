package com.android.mail.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.print.PrintAttributes.Builder;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import buc;
import bue;
import buf;
import buj;
import cok;
import mo;

public final class HelpFragment
  extends Fragment
{
  private WebView a;
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = (Uri)getActivity().getIntent().getParcelableExtra("help.url");
    a.loadUrl(paramBundle.toString());
  }
  
  public final void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenuInflater.inflate(buf.j, paramMenu);
    paramMenuInflater = paramMenu.findItem(buc.fG);
    if (paramMenuInflater != null) {
      if (TextUtils.isEmpty(getString(buj.q))) {
        break label70;
      }
    }
    label70:
    for (boolean bool = true;; bool = false)
    {
      paramMenuInflater.setVisible(bool);
      paramMenu = paramMenu.findItem(buc.dy);
      if (paramMenu != null) {
        paramMenu.setVisible(mo.a());
      }
      return;
    }
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    setHasOptionsMenu(true);
    paramLayoutInflater = paramLayoutInflater.inflate(bue.O, paramViewGroup, false);
    if (paramLayoutInflater != null)
    {
      a = ((WebView)paramLayoutInflater.findViewById(buc.fN));
      a.setWebViewClient(new WebViewClient());
      if (paramBundle != null) {
        a.restoreState(paramBundle);
      }
    }
    return paramLayoutInflater;
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
  }
  
  public final boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getItemId();
    if (i == 16908332)
    {
      paramMenuItem = getActivity();
      if (paramMenuItem != null) {
        paramMenuItem.finish();
      }
      return true;
    }
    if (i == buc.fG)
    {
      startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getString(buj.q))));
      return true;
    }
    if (i == buc.dy)
    {
      paramMenuItem = getActivity().getActionBar().getTitle().toString();
      paramMenuItem = getString(buj.dV, new Object[] { paramMenuItem });
      PrintDocumentAdapter localPrintDocumentAdapter = a.createPrintDocumentAdapter();
      ((PrintManager)getActivity().getSystemService("print")).print(paramMenuItem, localPrintDocumentAdapter, new PrintAttributes.Builder().build());
      return true;
    }
    if (i == buc.aP)
    {
      new cok().show(getFragmentManager(), "copyright");
      return true;
    }
    if (i == buc.dD)
    {
      startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getString(buj.dW))));
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.HelpFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */