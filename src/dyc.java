import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.android.mail.providers.Account;
import com.google.android.gm.ads.AdTeaserItemView;
import com.google.android.gm.ads.AdTeaserView;
import com.google.android.gm.provider.GmailProvider;
import com.google.android.gm.ui.teasers.DogfoodPromoTeaserView;
import com.google.android.gm.ui.teasers.EasPromoTeaserView;
import com.google.android.gm.ui.teasers.GmailifyPromoTeaserView;
import com.google.android.gm.ui.teasers.GmailifyWelcomeTeaserView;
import com.google.android.gm.ui.teasers.PromoTeaserView;
import com.google.android.gm.ui.teasers.SectionedInboxTeaserView;
import java.util.ArrayList;

public final class dyc
  extends csl
{
  public final ArrayList<cso> a(ckv paramckv, Account paramAccount)
  {
    boolean bool2 = true;
    Object localObject2 = paramckv.g();
    LayoutInflater localLayoutInflater = LayoutInflater.from((Context)localObject2);
    ArrayList localArrayList = super.a(paramckv, paramAccount);
    if (dyp.a(paramAccount))
    {
      localObject1 = (SectionedInboxTeaserView)localLayoutInflater.inflate(dga.U, null);
      e = paramckv.g();
      h = paramckv.i();
      g = paramAccount;
      localArrayList.add(localObject1);
      localAdTeaserView = (AdTeaserView)localLayoutInflater.inflate(dga.n, null);
      d = paramckv;
      e = paramAccount;
      f = GmailProvider.h(e.c);
      str = c;
      if (i != null)
      {
        localObject1 = i;
        if (k != null) {
          break label662;
        }
        localObject1 = null;
        if (str.equals(localObject1)) {}
      }
      else
      {
        i = ((AdTeaserItemView)LayoutInflater.from(localAdTeaserView.getContext()).inflate(dga.m, localAdTeaserView, false));
        localObject1 = i;
        k = paramAccount;
        u.b = k;
        if (h.getChildCount() > 1) {
          h.removeViews(1, h.getChildCount() - 1);
        }
        h.addView(i);
        i.setOnClickListener(localAdTeaserView);
      }
      localObject1 = drp.a(e.c);
      if (localObject1 != null)
      {
        localObject1 = o.d();
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || ("google.com".equals(localObject1)))
        {
          bool1 = true;
          o = bool1;
        }
      }
      else
      {
        localArrayList.add(localAdTeaserView);
        localObject1 = drp.a(c);
        if (localObject1 == null) {
          break label681;
        }
        localObject1 = o;
        if ((localObject1 == null) || (!((drj)localObject1).h()) || (!((drj)localObject1).i()) || (((drj)localObject1).a("bx_eidps", false))) {
          break label687;
        }
        i = 1;
        if (i != 0)
        {
          localObject2 = new dxv((Context)localObject2);
          e = paramAccount;
          localObject1 = drp.a(c);
          if (localObject1 == null) {
            break label692;
          }
          localObject1 = o;
          f = ((drj)localObject1);
          if (f == null) {
            break label698;
          }
          bool1 = bool2;
          d = bool1;
          localArrayList.add(localObject2);
        }
        localObject1 = (PromoTeaserView)localLayoutInflater.inflate(dga.T, null);
        localObject2 = paramckv.r();
        if ((p == null) || (!TextUtils.equals(p.h(), paramAccount.h())))
        {
          p = paramAccount;
          o = drp.a(p.c);
        }
        n = ((cpb)localObject2);
        localArrayList.add(localObject1);
        if (dkn.a())
        {
          localObject1 = (GmailifyWelcomeTeaserView)localLayoutInflater.inflate(dga.B, null);
          n = dnm.a(((GmailifyWelcomeTeaserView)localObject1).getContext(), c);
          localArrayList.add(localObject1);
        }
        localObject1 = (EasPromoTeaserView)localLayoutInflater.inflate(dga.w, null);
        n = paramckv;
        localArrayList.add(localObject1);
        localObject1 = (DogfoodPromoTeaserView)localLayoutInflater.inflate(dga.v, null);
        n = paramckv;
        o = paramAccount;
        localArrayList.add(localObject1);
      }
    }
    label662:
    label681:
    label687:
    label692:
    label698:
    while ((!TextUtils.equals(e, ((Activity)localObject2).getString(dge.b))) || (!dkn.a())) {
      for (;;)
      {
        AdTeaserView localAdTeaserView;
        String str;
        return localArrayList;
        localObject1 = k.c;
        continue;
        boolean bool1 = false;
        continue;
        localObject1 = null;
        continue;
        int i = 0;
        continue;
        localObject1 = null;
        continue;
        bool1 = false;
      }
    }
    Object localObject1 = (GmailifyPromoTeaserView)localLayoutInflater.inflate(dga.A, null);
    n = paramckv;
    o = paramAccount;
    localArrayList.add(localObject1);
    return localArrayList;
  }
}

/* Location:
 * Qualified Name:     dyc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */