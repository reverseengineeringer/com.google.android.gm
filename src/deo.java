import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class deo<T>
  extends BaseAdapter
  implements ejl<frc>, frl
{
  public final Map<String, fyb> a;
  public final ArrayList<T> b;
  public final LayoutInflater c;
  public final eiz d;
  public final Context e;
  public bvd f;
  private final fsc g;
  private final buy h;
  private final buy i;
  
  public deo(Context paramContext, eiz parameiz, ArrayList<T> paramArrayList)
  {
    b = paramArrayList;
    e = paramContext;
    c = LayoutInflater.from(paramContext);
    g = new fsc(paramContext, parameiz);
    paramContext = e.getResources();
    h = new bvh(paramContext);
    a = new HashMap();
    i = new buz(paramContext, dfs.b);
    d = parameiz;
    f = new bvd(null, null);
  }
  
  public final void a(int paramInt)
  {
    if ((paramInt & 0x20) == 32) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if ((d.e()) && (paramInt != 0))
      {
        frb localfrb = new frb();
        b = false;
        frm.e.a(d, localfrb).a(this);
      }
      return;
    }
  }
  
  public final void a(View paramView, dep paramdep)
  {
    String str = paramdep.a();
    fyb localfyb = (fyb)a.get(str);
    ((TextView)paramView.findViewById(dfy.b)).setText(str);
    Object localObject2 = (TextView)paramView.findViewById(dfy.c);
    Object localObject1;
    if (localfyb != null)
    {
      localObject1 = localfyb.c();
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.equals((CharSequence)localObject1, str))) {
        break label205;
      }
      ((TextView)localObject2).setVisibility(8);
      label90:
      localObject1 = (ImageView)paramView.findViewById(dfy.L);
      localObject2 = new bva(e.getResources());
      c = f;
      boolean bool = "com.google".equals(paramdep.c());
      if (!bool) {
        break label221;
      }
      paramView = i;
      label148:
      g = paramView;
      if (!bool) {
        break label229;
      }
    }
    label205:
    label221:
    label229:
    for (paramView = " ";; paramView = paramdep.b())
    {
      ((bva)localObject2).a(paramView, str);
      ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
      if (localfyb != null) {
        g.a((ImageView)localObject1, localfyb, 1);
      }
      return;
      localObject1 = paramdep.b();
      break;
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setVisibility(0);
      break label90;
      paramView = h;
      break label148;
    }
  }
  
  public final void a(frc paramfrc)
  {
    paramfrc = paramfrc.c().iterator();
    int j = 1;
    while (paramfrc.hasNext())
    {
      fyb localfyb = (fyb)paramfrc.next();
      if (TextUtils.equals(localfyb.b(), localfyb.c()))
      {
        if (localfyb.g() == 0)
        {
          frm.m.a(d, this);
          frm.h.a(d, localfyb.b(), localfyb.e());
        }
        j = 0;
      }
      else
      {
        a.put(localfyb.b(), localfyb);
      }
    }
    if (j != 0) {
      frm.m.b(d, this);
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (b == null) {
      return 0;
    }
    return b.size();
  }
  
  public T getItem(int paramInt)
  {
    if (b == null) {
      return null;
    }
    return (T)b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
}

/* Location:
 * Qualified Name:     deo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */