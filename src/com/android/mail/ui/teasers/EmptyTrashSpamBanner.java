package com.android.mail.ui.teasers;

import android.app.LoaderManager;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import buc;
import buj;
import bwg;
import cjw;
import ckv;
import com.android.mail.providers.Folder;
import cqp;
import cso;

public class EmptyTrashSpamBanner
  extends LinearLayout
  implements View.OnClickListener, cso
{
  public ckv a;
  private cqp b;
  private TextView c;
  private TextView d;
  
  public EmptyTrashSpamBanner(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EmptyTrashSpamBanner(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EmptyTrashSpamBanner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void a(LoaderManager paramLoaderManager, Bundle paramBundle) {}
  
  public final void a(Bundle paramBundle) {}
  
  public final void a(Folder paramFolder, bwg parambwg)
  {
    if (paramFolder != null)
    {
      if (!paramFolder.d(32)) {
        break label34;
      }
      c.setText(buj.bH);
      d.setText(buj.bG);
    }
    label34:
    while (!paramFolder.d(64)) {
      return;
    }
    c.setText(buj.bD);
    d.setText(buj.bC);
  }
  
  public final void a(cqp paramcqp)
  {
    b = paramcqp;
  }
  
  public final void a(boolean paramBoolean) {}
  
  public final boolean a()
  {
    return false;
  }
  
  public final void d() {}
  
  public final void e() {}
  
  public final void f() {}
  
  public final void g() {}
  
  public final void j() {}
  
  public final boolean k()
  {
    return false;
  }
  
  public final boolean n()
  {
    Folder localFolder = b.l();
    return (localFolder != null) && ((localFolder.d(32)) || (localFolder.d(64))) && (localFolder.a(131072)) && (!b.isEmpty());
  }
  
  public final boolean o()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == buc.bs) && (a != null)) {
      a.d().t();
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    c = ((TextView)findViewById(buc.bt));
    d = ((TextView)findViewById(buc.bs));
    d.setOnClickListener(this);
  }
  
  public final int q()
  {
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.teasers.EmptyTrashSpamBanner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */