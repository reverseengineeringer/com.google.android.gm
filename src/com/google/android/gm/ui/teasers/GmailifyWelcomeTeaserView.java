package com.google.android.gm.ui.teasers;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import bwg;
import cfr;
import com.android.mail.providers.Folder;
import dfy;
import dge;
import dnm;
import dxz;
import ghz;

public class GmailifyWelcomeTeaserView
  extends dxz
{
  public dnm n;
  private boolean o;
  
  public GmailifyWelcomeTeaserView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GmailifyWelcomeTeaserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GmailifyWelcomeTeaserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void a(Folder paramFolder, bwg parambwg)
  {
    boolean bool = false;
    if (((paramFolder != null) && (paramFolder.d(8194)) && (!paramFolder.d(8192)) && (n.d.getBoolean("g6y-welcome-teaser-enabled", false)) && (!TextUtils.isEmpty(n.g()))) || (ghz.a(getContext().getContentResolver(), "gmail_g6y_force_welcome_teaser", false))) {
      bool = true;
    }
    o = bool;
  }
  
  public final void i()
  {
    n.b(false);
    super.i();
  }
  
  public final boolean n()
  {
    return o;
  }
  
  public final boolean o()
  {
    return false;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    d = findViewById(dfy.cp);
    e.setVisibility(8);
    f.setText(dge.cN);
    g.setText(dge.cM);
    a(null);
    b(17039370);
  }
  
  protected final void r()
  {
    i();
  }
  
  protected final void s()
  {
    i();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.ui.teasers.GmailifyWelcomeTeaserView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */