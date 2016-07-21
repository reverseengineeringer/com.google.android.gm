import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import com.android.mail.ui.MailActivity;
import com.android.mail.ui.search.MaterialSearchActionView;
import com.android.mail.ui.search.MaterialSearchSuggestionsList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class crr
  implements crb, crk
{
  public MailActivity a;
  public cjw b;
  public final chc c;
  public MaterialSearchActionView d;
  public MaterialSearchSuggestionsList e;
  public cro f;
  public Set<cru> g = new HashSet();
  public int h;
  public int i;
  public boolean j;
  public boolean k;
  private int l;
  
  public crr(MailActivity paramMailActivity, cjw paramcjw, Intent paramIntent, Bundle paramBundle)
  {
    a = paramMailActivity;
    b = paramcjw;
    if (new Intent("android.speech.action.RECOGNIZE_SPEECH").resolveActivity(a.getPackageManager()) != null) {}
    for (boolean bool = true;; bool = false)
    {
      e = ((MaterialSearchSuggestionsList)a.findViewById(buc.ev));
      e.a = this;
      d = ((MaterialSearchActionView)a.findViewById(buc.eq));
      paramMailActivity = d;
      paramcjw = paramIntent.getStringExtra("query");
      a = this;
      d.setText(paramcjw);
      c = bool;
      c = a.A();
      f = a.a(paramBundle);
      f.a(this, c);
      paramMailActivity = e;
      d = f;
      if (c != null) {
        c.setAdapter(d);
      }
      d.a(b);
      if ((paramBundle != null) && (paramBundle.containsKey("extraSearchViewControllerViewState"))) {
        i = paramBundle.getInt("extraSearchViewControllerViewState");
      }
      a.m.a(this);
      return;
    }
  }
  
  private final void a(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      paramView.setVisibility(0);
      paramView.animate().alpha(1.0F).setDuration(150L).setListener(null);
      return;
    }
    paramView.animate().alpha(0.0F).setDuration(150L).setListener(new crs(this, paramView, paramInt));
  }
  
  private static void b(View paramView, int paramInt)
  {
    paramView.setVisibility(paramInt);
    if (paramInt == 0)
    {
      paramView.setAlpha(1.0F);
      return;
    }
    paramView.setAlpha(0.0F);
  }
  
  private final boolean c()
  {
    return (b.as()) && (i == 2) && (crj.c(h));
  }
  
  private final void d()
  {
    if (l != 0) {
      d.a(c(), l);
    }
  }
  
  public final String a()
  {
    return d.d.getText().toString();
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    h = paramInt2;
    if (b.d(h))
    {
      a(2, false);
      return;
    }
    if (paramInt1 == 0)
    {
      a(i, false);
      return;
    }
    a(0, false);
  }
  
  public final void a(int paramInt, boolean paramBoolean)
  {
    int i3 = 8;
    int i4 = 1;
    int m = paramInt;
    if (paramInt == 2)
    {
      m = paramInt;
      if (!b.d(h)) {
        m = 0;
      }
    }
    int i5 = i;
    i = m;
    int n;
    label60:
    int i1;
    label72:
    int i2;
    label80:
    label112:
    Object localObject;
    if (m == 2)
    {
      paramInt = 1;
      if (m != 1) {
        break label278;
      }
      n = 1;
      if ((n == 0) && (paramInt == 0)) {
        break label284;
      }
      i1 = 1;
      if (i1 == 0) {
        break label290;
      }
      i2 = 0;
      if (n != 0) {
        i3 = 0;
      }
      if (!paramBoolean) {
        break label297;
      }
      a(d, i2);
      a(e, i3);
      localObject = d;
      if (n == 0) {
        break label318;
      }
      d.requestFocus();
      b.showSoftInput(d, 0);
      label147:
      i2 = i4;
      if (i1 != 0)
      {
        if (!c()) {
          break label339;
        }
        i2 = i4;
      }
      label167:
      if (cxd.e())
      {
        i1 = d.getSystemUiVisibility();
        if (i2 == 0) {
          break label345;
        }
        i1 &= 0xDFFF;
        label195:
        d.setSystemUiVisibility(i1);
      }
      if (i2 == 0) {
        break label356;
      }
      i1 = btz.C;
      label214:
      cxe.a(a, i1);
      if (paramInt == 0) {
        break label364;
      }
      d();
    }
    for (;;)
    {
      localObject = g.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((cru)((Iterator)localObject).next()).b(i5, m);
      }
      paramInt = 0;
      break;
      label278:
      n = 0;
      break label60;
      label284:
      i1 = 0;
      break label72;
      label290:
      i2 = 8;
      break label80;
      label297:
      b(d, i2);
      b(e, i3);
      break label112;
      label318:
      b.hideSoftInputFromWindow(d.getWindowToken(), 0);
      break label147;
      label339:
      i2 = 0;
      break label167;
      label345:
      i1 |= 0x2000;
      break label195;
      label356:
      i1 = btz.K;
      break label214;
      label364:
      if (n != 0) {
        d.a(false, 0);
      } else if (!crj.c(h)) {
        d.a();
      }
    }
  }
  
  public final void a(cru paramcru)
  {
    g.add(paramcru);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    paramString1 = paramString1.trim();
    if (!TextUtils.isEmpty(paramString1))
    {
      but localbut = buo.a();
      long l1 = d.d.getText().length();
      String str = String.valueOf(b());
      localbut.b("search", l1, "num_chars_inputted", String.valueOf(str).length() + 1 + String.valueOf(paramString2).length() + str + "_" + paramString2);
      d.a();
      b.a(paramString1);
    }
  }
  
  public final String b()
  {
    if (f == null) {
      return "";
    }
    return f.b();
  }
  
  public final void c(int paramInt)
  {
    if (l != paramInt)
    {
      l = paramInt;
      if (crj.c(h)) {
        if (!b.d(h)) {
          break label54;
        }
      }
    }
    label54:
    for (paramInt = 0;; paramInt = 8)
    {
      b(d, paramInt);
      d();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     crr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */