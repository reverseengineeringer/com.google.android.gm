import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.Resources.Theme;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public final class zy
{
  public int A;
  public boolean B = false;
  public boolean[] C;
  public boolean D;
  public boolean E;
  public int F = -1;
  public DialogInterface.OnMultiChoiceClickListener G;
  public Cursor H;
  public String I;
  public String J;
  public AdapterView.OnItemSelectedListener K;
  public boolean L = true;
  public final Context a;
  public final LayoutInflater b;
  public int c = 0;
  public Drawable d;
  public int e = 0;
  public CharSequence f;
  public View g;
  public CharSequence h;
  public CharSequence i;
  public DialogInterface.OnClickListener j;
  public CharSequence k;
  public DialogInterface.OnClickListener l;
  public CharSequence m;
  public DialogInterface.OnClickListener n;
  public boolean o;
  public DialogInterface.OnCancelListener p;
  public DialogInterface.OnDismissListener q;
  public DialogInterface.OnKeyListener r;
  public CharSequence[] s;
  public ListAdapter t;
  public DialogInterface.OnClickListener u;
  public int v;
  public View w;
  public int x;
  public int y;
  public int z;
  
  public zy(Context paramContext)
  {
    a = paramContext;
    o = true;
    b = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  public final void apply(zs paramzs)
  {
    Object localObject;
    ListView localListView;
    if (g != null)
    {
      C = g;
      if (h != null)
      {
        localObject = h;
        e = ((CharSequence)localObject);
        if (B != null) {
          B.setText((CharSequence)localObject);
        }
      }
      if (i != null) {
        paramzs.a(-1, i, j, null);
      }
      if (k != null) {
        paramzs.a(-2, k, l, null);
      }
      if (m != null) {
        paramzs.a(-3, m, n, null);
      }
      if ((s != null) || (H != null) || (t != null))
      {
        localListView = (ListView)b.inflate(H, null);
        if (!D) {
          break label509;
        }
        if (H != null) {
          break label485;
        }
        localObject = new zz(this, a, I, s, localListView);
        label191:
        D = ((ListAdapter)localObject);
        E = F;
        if (u == null) {
          break label614;
        }
        localListView.setOnItemClickListener(new aab(this, paramzs));
        label226:
        if (K != null) {
          localListView.setOnItemSelectedListener(K);
        }
        if (!E) {
          break label640;
        }
        localListView.setChoiceMode(1);
        label255:
        f = localListView;
      }
      if (w == null) {
        break label675;
      }
      if (!B) {
        break label656;
      }
      localObject = w;
      i1 = x;
      i2 = y;
      i3 = z;
      i4 = A;
      g = ((View)localObject);
      h = 0;
      m = true;
      i = i1;
      j = i2;
      k = i3;
      l = i4;
    }
    label473:
    label485:
    label509:
    label577:
    label614:
    label640:
    label656:
    label675:
    while (v == 0)
    {
      int i2;
      int i3;
      int i4;
      return;
      if (f != null) {
        paramzs.a(f);
      }
      if (d != null)
      {
        localObject = d;
        y = ((Drawable)localObject);
        x = 0;
        if (z != null)
        {
          if (localObject == null) {
            break label473;
          }
          z.setVisibility(0);
          z.setImageDrawable((Drawable)localObject);
        }
      }
      for (;;)
      {
        if (c != 0) {
          paramzs.a(c);
        }
        if (e == 0) {
          break;
        }
        i1 = e;
        localObject = new TypedValue();
        a.getTheme().resolveAttribute(i1, (TypedValue)localObject, true);
        paramzs.a(resourceId);
        break;
        z.setVisibility(8);
      }
      localObject = new aaa(this, a, H, localListView, paramzs);
      break label191;
      if (E) {}
      for (i1 = J;; i1 = K)
      {
        if (H == null) {
          break label577;
        }
        localObject = new SimpleCursorAdapter(a, i1, H, new String[] { I }, new int[] { 16908308 });
        break;
      }
      if (t != null)
      {
        localObject = t;
        break label191;
      }
      localObject = new aae(a, i1, s);
      break label191;
      if (G == null) {
        break label226;
      }
      localListView.setOnItemClickListener(new aac(this, localListView, paramzs));
      break label226;
      if (!D) {
        break label255;
      }
      localListView.setChoiceMode(2);
      break label255;
      g = w;
      h = 0;
      m = false;
      return;
    }
    int i1 = v;
    g = null;
    h = i1;
    m = false;
  }
}

/* Location:
 * Qualified Name:     zy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */