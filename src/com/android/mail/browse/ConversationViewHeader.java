package com.android.mail.browse;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import bub;
import buc;
import buj;
import bvz;
import bxr;
import bxw;
import bxx;
import bzw;
import bzx;
import bzy;
import cer;
import chm;
import cll;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Settings;
import cvl;
import cxe;
import mx;

public class ConversationViewHeader
  extends LinearLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  public static final String a = cvl.a;
  public bxw b;
  public bxr c;
  public Conversation d;
  private SubjectAndFolderView e;
  private StarView f;
  private bvz g;
  private cll h;
  
  public ConversationViewHeader(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ConversationViewHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static boolean b(Conversation paramConversation)
  {
    return (paramConversation != null) && (!paramConversation.e());
  }
  
  public final void a(bxr parambxr)
  {
    c = parambxr;
    d = c.e;
    if (e != null) {
      e.m = parambxr;
    }
    a(d.l, false);
  }
  
  public final void a(bxw parambxw, bvz parambvz, cll paramcll)
  {
    b = parambxw;
    g = parambvz;
    h = paramcll;
  }
  
  public final void a(Conversation paramConversation)
  {
    int i;
    SubjectAndFolderView localSubjectAndFolderView;
    bxw localbxw;
    Account localAccount;
    Object localObject1;
    label80:
    SpannableStringBuilder localSpannableStringBuilder;
    Object localObject2;
    int m;
    label134:
    int j;
    if ((g.a() == null) || (g.a().a(16384L)))
    {
      i = 1;
      localSubjectAndFolderView = e;
      localbxw = b;
      localAccount = g.a();
      l = true;
      localObject1 = localSubjectAndFolderView.a();
      if (k != null) {
        break label348;
      }
      localObject1 = "";
      localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)localObject1);
      if ((m == 0) || (m == 2))
      {
        localObject2 = localSubjectAndFolderView.getResources();
        m = localSpannableStringBuilder.length();
        if (m != 0) {
          break label363;
        }
        localObject1 = f;
        if (m != 0) {
          break label373;
        }
        j = h;
        label147:
        if (m != 0) {
          break label382;
        }
      }
    }
    label348:
    label363:
    label373:
    label382:
    for (int k = buj.an;; k = buj.am)
    {
      localObject2 = ((Resources)localObject2).getString(k);
      localSpannableStringBuilder.append(" ");
      localSpannableStringBuilder.append((CharSequence)localObject2);
      k = localSpannableStringBuilder.length();
      localSpannableStringBuilder.setSpan(new bzw(localSubjectAndFolderView, (Drawable)localObject1, j), m, k, 17);
      if (i != 0)
      {
        localObject1 = z;
        localSpannableStringBuilder.append(' ');
        i = localSpannableStringBuilder.length();
        if ((n) && (paramConversation.a()))
        {
          localSpannableStringBuilder.append(". ");
          localSpannableStringBuilder.setSpan(new bzx(localSubjectAndFolderView), i, i + 1, 17);
        }
        j.a(paramConversation, null, -1);
        j.a(localSpannableStringBuilder);
        j = localSpannableStringBuilder.length();
        localSpannableStringBuilder.setSpan(new chm(localbxw), i, j, 33);
      }
      localSubjectAndFolderView.setText(localSpannableStringBuilder);
      localSubjectAndFolderView.setMovementMethod(LinkMovementMethod.getInstance());
      return;
      i = 0;
      break;
      localObject1 = ((mx)localObject1).a(k);
      break label80;
      localObject1 = e;
      break label134;
      j = i;
      break label147;
    }
  }
  
  public final void a(String paramString)
  {
    SubjectAndFolderView localSubjectAndFolderView = e;
    k = Conversation.a(localSubjectAndFolderView.getContext(), null, paramString);
    if (!l) {
      localSubjectAndFolderView.setText(k);
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 0;
    Object localObject;
    label54:
    int j;
    if ((paramBoolean2) || (b(d)))
    {
      i = 1;
      localObject = g.a();
      StarView localStarView = f;
      if ((localObject == null) || (!((Account)localObject).a(2147483648L))) {
        break label109;
      }
      paramBoolean2 = true;
      if (!paramBoolean2) {
        break label114;
      }
      j = bub.g;
      label63:
      localStarView.setImageResource(j);
      a = paramBoolean2;
      f.a(paramBoolean1);
      localObject = f;
      if (i == 0) {
        break label122;
      }
    }
    label109:
    label114:
    label122:
    for (int i = k;; i = 4)
    {
      ((StarView)localObject).setVisibility(i);
      return;
      i = 0;
      break;
      paramBoolean2 = false;
      break label54;
      j = bub.aL;
      break label63;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    boolean bool;
    if ((d != null) && (i == buc.av))
    {
      paramView = getContext();
      Conversation localConversation = d;
      if (d.l) {
        break label146;
      }
      bool = true;
      l = bool;
      a(d.l, false);
      if (h != null) {
        h.a(Conversation.a(d), "starred", d.l);
      }
      if (!f.a) {
        break label162;
      }
      if (!d.l) {
        break label151;
      }
    }
    label146:
    label151:
    for (paramView = paramView.getString(buj.aF);; paramView = paramView.getString(buj.aM))
    {
      cer.a("flag_", "cv", d.l);
      cxe.a(f, paramView);
      return;
      bool = false;
      break;
    }
    label162:
    if (d.l) {}
    for (paramView = paramView.getString(buj.aL);; paramView = paramView.getString(buj.aN))
    {
      cer.a("star_", "cv", d.l);
      break;
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    e = ((SubjectAndFolderView)findViewById(buc.fd));
    e.setOnLongClickListener(this);
    f = ((StarView)findViewById(buc.av));
    f.setOnClickListener(this);
  }
  
  public boolean onLongClick(View paramView)
  {
    if (b != null)
    {
      paramView = e.k;
      bxx localbxx = new bxx();
      Bundle localBundle = new Bundle(1);
      localBundle.putString("subject", paramView);
      localbxx.setArguments(localBundle);
      localbxx.show(b.getActivity().getFragmentManager(), "copy-subject-dialog");
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ConversationViewHeader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */