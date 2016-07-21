package com.google.android.gm.browse;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.net.Uri.Builder;
import android.util.AttributeSet;
import android.view.View;
import btn;
import bua;
import buo;
import but;
import bvz;
import byz;
import cff;
import com.android.emailcommon.mail.Address;
import com.android.mail.providers.Account;
import cop;
import cui;
import cvm;
import dfv;
import dge;
import dyv;
import gdd;
import ghz;
import hbw;
import hlt;
import hmn;
import hmo;
import hnc;
import hnd;
import idf;
import java.io.OutputStream;

public class MessageHeaderSmartProfileBadge
  extends byz
{
  private static final String f = cvm.a;
  private Address g;
  
  public MessageHeaderSmartProfileBadge(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MessageHeaderSmartProfileBadge(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MessageHeaderSmartProfileBadge(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void a(Address paramAddress, btn parambtn)
  {
    g = paramAddress;
  }
  
  public void onClick(View paramView)
  {
    buo.a().a("smart_profile", "clicked", null, 0L);
    if (g == null)
    {
      cvm.b(f, "SmartProfileBadge: Contact address was not assigned.", new Object[0]);
      return;
    }
    Object localObject1 = g.a;
    gdd localgdd = new gdd();
    paramView = String.valueOf(localObject1);
    if (paramView.length() != 0) {}
    Resources localResources;
    Object localObject2;
    for (paramView = "e:".concat(paramView);; paramView = new String("e:"))
    {
      a.putExtra("com.google.android.gms.people.smart_profile.QUALIFIED_ID", paramView);
      paramView = e.a().c;
      a.putExtra("com.google.android.gms.people.smart_profile.VIEWER_ACCOUNT_NAME", paramView);
      a.putExtra("com.google.android.gms.people.smart_profile.APPLICATION_ID", 135);
      int i = getResources().getColor(dfv.z);
      a.putExtra("com.google.android.gms.people.smart_profile.THEME_COLOR_INT", i);
      if (!hbw.b(g.b))
      {
        paramView = g.b;
        a.putExtra("com.google.android.gms.people.smart_profile.DISPLAY_NAME", paramView);
      }
      if (d != 2) {
        break label557;
      }
      paramView = getContext();
      localResources = paramView.getResources();
      localObject2 = new cff(localResources).a(new cop(localResources.getDimensionPixelSize(17104901), localResources.getDimensionPixelSize(17104902), 1.0F, localResources.getDimensionPixelSize(bua.Y)), 2);
      localObject3 = new idf();
      ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject3);
      localObject2 = ((idf)localObject3).a();
      a.putExtra("com.google.android.gms.people.smart_profile.AVATAR_BYTES", (byte[])localObject2);
      localObject2 = new hnc();
      localObject3 = localResources.getString(dge.fJ);
      if (localObject3 != null) {
        break;
      }
      throw new NullPointerException();
    }
    c = ((String)localObject3);
    a |= 0x1;
    Object localObject3 = new hnd();
    localObject1 = cui.b((String)localObject1);
    localObject1 = localResources.getString(dge.fU, new Object[] { "", localObject1 });
    if (localObject1 == null) {
      throw new NullPointerException();
    }
    b = ((String)localObject1);
    a |= 0x8;
    paramView = Uri.parse(ghz.a(paramView.getContentResolver(), "gmail_context_sensitive_help_url", "https://support.google.com/mail")).buildUpon().appendQueryParameter("p", "email_auth").appendQueryParameter("hl", dyv.a()).build().toString();
    if (paramView == null) {
      throw new NullPointerException();
    }
    c = paramView;
    a |= 0x10;
    d = new hnd[] { localObject3 };
    paramView = new hmn();
    d = ((hnc)localObject2);
    localObject1 = new hmo();
    a = new hmn[] { paramView };
    paramView = hmo.a((hlt)localObject1);
    a.putExtra("com.google.android.gms.people.smart_profile.CARD_BYTES", paramView);
    label557:
    ((Activity)getContext()).startActivityForResult(a, 0);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.browse.MessageHeaderSmartProfileBadge
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */