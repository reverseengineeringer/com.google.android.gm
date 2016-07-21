package com.android.mail.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import bue;
import buj;
import buo;
import but;
import ckl;
import cks;
import com.android.mail.compose.ComposeAttachmentTile;
import com.android.mail.providers.Account;
import com.android.mail.providers.Attachment;
import com.android.mail.providers.Settings;
import ctq;
import cvk;
import java.util.Iterator;
import java.util.List;

public class ComposeAttachmentTileGrid
  extends AttachmentTileGrid
{
  public int i = 0;
  public ckl j;
  
  public ComposeAttachmentTileGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private final long b()
  {
    Iterator localIterator = b.iterator();
    for (long l = 0L; localIterator.hasNext(); l = nextd + l) {}
    return l;
  }
  
  public final long a(Account paramAccount, Attachment paramAttachment)
  {
    long l = z.c();
    int k = d;
    if (d == 0)
    {
      buo.a().a("add_attachment", "zero_size", null, 0L);
      throw new ctq("Cannot attach empty attachment", buj.S);
    }
    if (k < 0)
    {
      buo.a().a("add_attachment", "unknown_size", null, 0L);
      throw new ctq("Unknown attachment size", buj.fj);
    }
    if (!paramAccount.a(67108864L)) {
      k = (int)(k * 1.3D);
    }
    for (;;)
    {
      if (k > l)
      {
        buo.a().a("add_attachment", "too_large_to_attach_single", String.valueOf(l), d);
        throw new cvk(buj.fj);
      }
      if (b() + k > l)
      {
        buo.a().a("add_attachment", "too_large_to_attach_additional", String.valueOf(l), b() + d);
        throw new cvk(buj.fh);
      }
      int m;
      if (paramAttachment.j())
      {
        m = i;
        if (!paramAttachment.m()) {
          i += 1;
        }
        b.add(m, paramAttachment);
      }
      for (;;)
      {
        if (!paramAttachment.m())
        {
          if (!isShown()) {
            setVisibility(0);
          }
          paramAccount = (ComposeAttachmentTile)a.inflate(bue.f, this, false);
          addView(paramAccount, m);
          paramAccount.a(paramAttachment, this);
          paramAttachment = new cks(this, paramAccount, paramAttachment);
          a.setOnClickListener(paramAttachment);
          if (j != null) {
            j.t();
          }
          paramAccount = (InputMethodManager)getContext().getSystemService("input_method");
          if (paramAccount != null) {
            paramAccount.hideSoftInputFromWindow(getWindowToken(), 0);
          }
        }
        return k;
        m = getChildCount();
        b.add(paramAttachment);
      }
    }
  }
  
  public final void a()
  {
    b.clear();
    removeAllViews();
    setVisibility(8);
    i = 0;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ComposeAttachmentTileGrid
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */