import android.app.FragmentManager;
import android.app.LoaderManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.android.emailcommon.mail.Address;
import com.android.mail.browse.ConversationMessage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class bxp
  extends BaseAdapter
{
  private static final String x = cvl.a;
  public final btq a;
  public final bvz b;
  final LoaderManager c;
  final FragmentManager d;
  final bzg e;
  final byy f;
  final bvu g;
  final bto h;
  final bxw i;
  public final bxo j;
  final bwx k;
  final cll l;
  final caa m;
  final cas n;
  final Map<String, Address> o;
  public final List<bxh> p = new ArrayList();
  public byv q;
  public bzf r;
  public cbf s;
  public cba t;
  public bzh u;
  public final mx v;
  public final View.OnKeyListener w;
  private final Context y;
  private final LayoutInflater z;
  
  public bxp(ckv paramckv, bvz parambvz, LoaderManager paramLoaderManager, bzg parambzg, byy parambyy, bvu parambvu, bto parambto, bxw parambxw, bxo parambxo, bwx parambwx, cll paramcll, caa paramcaa, Map<String, Address> paramMap, btq parambtq, mx parammx, View.OnKeyListener paramOnKeyListener, cas paramcas)
  {
    y = paramckv.g();
    a = parambtq;
    b = parambvz;
    c = paramLoaderManager;
    d = paramckv.getFragmentManager();
    e = parambzg;
    f = parambyy;
    g = parambvu;
    h = parambto;
    i = parambxw;
    j = parambxo;
    k = parambwx;
    l = paramcll;
    m = paramcaa;
    o = paramMap;
    n = paramcas;
    z = LayoutInflater.from(y);
    v = parammx;
    w = paramOnKeyListener;
  }
  
  public static bxu a(bxp parambxp, btq parambtq, ConversationMessage paramConversationMessage, boolean paramBoolean1, boolean paramBoolean2)
  {
    return new bxu(parambxp, parambtq, paramConversationMessage, paramBoolean1, paramBoolean2);
  }
  
  public final int a(bxh parambxh)
  {
    int i1 = p.size();
    c = i1;
    p.add(parambxh);
    return i1;
  }
  
  public final View a(View paramView, boolean paramBoolean, Set<View> paramSet)
  {
    while (paramView.getTag() != "overlay_item_root")
    {
      paramView = paramView.getParent();
      if ((paramView != null) && ((paramView instanceof View))) {
        paramView = (View)paramView;
      } else {
        return null;
      }
    }
    int i1 = 0;
    while (i1 < p.size())
    {
      if (p.get(i1)).d == paramView)
      {
        int i2 = i1;
        View localView;
        if (paramBoolean)
        {
          i2 = i1;
          if (i1 >= 0)
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    i2 = i1 + 1;
                    if (i2 >= p.size()) {
                      break;
                    }
                    paramView = (bxh)p.get(i2);
                    localView = paramView.f();
                    i1 = i2;
                  } while (d == null);
                  i1 = i2;
                } while (paramSet.contains(d));
                i1 = i2;
              } while (localView == null);
              i1 = i2;
            } while (!localView.isFocusable());
            return localView;
          }
        }
        do
        {
          i2 -= 1;
          if (i2 < 0) {
            break;
          }
          paramView = (bxh)p.get(i2);
          localView = paramView.f();
        } while ((d == null) || (paramSet.contains(d)) || (localView == null) || (!localView.isFocusable()));
        return localView;
        return null;
      }
      i1 += 1;
    }
    return null;
  }
  
  public final View a(bxh parambxh, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = parambxh.a(y, z, paramViewGroup);
    }
    parambxh.a(localView, paramBoolean);
    return localView;
  }
  
  public final bxh a(int paramInt)
  {
    return (bxh)p.get(paramInt);
  }
  
  public final void a()
  {
    p.clear();
    notifyDataSetChanged();
  }
  
  public final void a(bxv parambxv, Collection<bxh> paramCollection)
  {
    int i1 = p.indexOf(parambxv);
    if (i1 == -1) {}
    for (;;)
    {
      return;
      p.remove(i1);
      p.addAll(i1, paramCollection);
      int i2 = p.size();
      i1 = 0;
      while (i1 < i2)
      {
        p.get(i1)).c = i1;
        i1 += 1;
      }
    }
  }
  
  public final void a(ConversationMessage paramConversationMessage, List<Integer> paramList)
  {
    int i2 = p.size();
    int i1 = 0;
    while (i1 < i2)
    {
      bxh localbxh = (bxh)p.get(i1);
      if (localbxh.a(paramConversationMessage))
      {
        localbxh.b(paramConversationMessage);
        paramList.add(Integer.valueOf(i1));
      }
      i1 += 1;
    }
  }
  
  public final bxq b()
  {
    int i1 = p.size();
    if (i1 < 4)
    {
      cvm.e(x, "not enough items in the adapter. count: %s", new Object[] { Integer.valueOf(i1) });
      return null;
    }
    bxh localbxh = (bxh)p.remove(i1 - 1);
    if (localbxh == null)
    {
      cvm.f(x, "removed overlay item: null", new Object[0]);
      return null;
    }
    try
    {
      bxq localbxq = (bxq)localbxh;
      return localbxq;
    }
    catch (ClassCastException localClassCastException)
    {
      cvm.f(x, localClassCastException, "Failed to remove ConversationFooterItem %s in %s", new Object[] { localbxh, this });
    }
    return null;
  }
  
  public final bxq c()
  {
    int i1 = p.size();
    if (i1 < 4)
    {
      cvm.e(x, "not enough items in the adapter. count: %s", new Object[] { Integer.valueOf(i1) });
      return null;
    }
    bxh localbxh = (bxh)p.get(i1 - 1);
    try
    {
      bxq localbxq = (bxq)localbxh;
      return localbxq;
    }
    catch (ClassCastException localClassCastException)
    {
      cvm.e(x, "Last item is not a conversation footer. type: %s", new Object[] { Integer.valueOf(localbxh.a()) });
    }
    return null;
  }
  
  public final boolean d()
  {
    if (p.size() > 1)
    {
      View localView = ((bxh)p.get(1)).f();
      if ((localView != null) && (localView.isShown()) && (localView.isFocusable()))
      {
        localView.requestFocus();
        return true;
      }
    }
    return false;
  }
  
  public final int getCount()
  {
    return p.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return ((bxh)p.get(paramInt)).a();
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return a(a(paramInt), paramView, paramViewGroup, false);
  }
  
  public final int getViewTypeCount()
  {
    return 9;
  }
  
  public final String toString()
  {
    String str1 = String.valueOf(super.toString());
    String str2 = String.valueOf(TextUtils.join(", ", p));
    return String.valueOf(str1).length() + 4 + String.valueOf(str2).length() + str1 + ": [" + str2 + "]";
  }
}

/* Location:
 * Qualified Name:     bxp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */