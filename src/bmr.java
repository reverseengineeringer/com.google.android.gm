import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.android.ex.photo.views.PhotoView;

public class bmr
  extends Fragment
  implements View.OnClickListener, blo, blp, gp<bmv>
{
  public String a;
  public TextView ai;
  public ImageView aj;
  public bnn ak;
  public int al;
  public boolean am;
  public boolean an;
  public boolean ao;
  public boolean ap = true;
  public View aq;
  public boolean ar;
  public boolean as;
  public boolean at;
  public String b;
  public String c;
  public Intent d;
  public bln e;
  public bmq f;
  public BroadcastReceiver g;
  public PhotoView h;
  public ImageView i;
  
  public static void a(Intent paramIntent, int paramInt, boolean paramBoolean, bmr parambmr)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("arg-intent", paramIntent);
    localBundle.putInt("arg-position", paramInt);
    localBundle.putBoolean("arg-show-spinner", paramBoolean);
    if (p >= 0) {
      throw new IllegalStateException("Fragment already active");
    }
    r = localBundle;
  }
  
  private final void a(bmv parambmv)
  {
    if (c == 1)
    {
      ap = false;
      ai.setText(bmm.a);
      ai.setVisibility(0);
      e.a(this, false);
      return;
    }
    ai.setVisibility(8);
    parambmv = parambmv.a(g());
    PhotoView localPhotoView;
    if (parambmv != null) {
      if (h != null)
      {
        localPhotoView = h;
        if ((parambmv == null) || (parambmv == a)) {
          break label164;
        }
        if (a != null) {
          a.setCallback(null);
        }
        a = parambmv;
        j = 0.0F;
        a.setCallback(localPhotoView);
      }
    }
    label164:
    for (boolean bool = true;; bool = false)
    {
      localPhotoView.b(bool);
      localPhotoView.invalidate();
      b(true);
      aq.setVisibility(8);
      ap = false;
      e.a(this, true);
      return;
    }
  }
  
  private final void b(boolean paramBoolean)
  {
    h.a(paramBoolean);
  }
  
  private final void v()
  {
    if (h != null) {
      h.a();
    }
  }
  
  private final void w()
  {
    if (e == null) {}
    for (boolean bool = false;; bool = e.b(this))
    {
      am = bool;
      return;
    }
  }
  
  public final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(bml.b, paramViewGroup, false);
    h = ((PhotoView)paramLayoutInflater.findViewById(bmj.i));
    h.d = d.getFloatExtra("max_scale", 1.0F);
    h.setOnClickListener(this);
    paramViewGroup = h;
    boolean bool = am;
    if (bool != c)
    {
      c = bool;
      paramViewGroup.requestLayout();
      paramViewGroup.invalidate();
    }
    h.a(false);
    h.setContentDescription(c);
    aq = paramLayoutInflater.findViewById(bmj.g);
    i = ((ImageView)paramLayoutInflater.findViewById(bmj.h));
    ar = false;
    paramViewGroup = (ProgressBar)paramLayoutInflater.findViewById(bmj.c);
    ak = new bnn((ProgressBar)paramLayoutInflater.findViewById(bmj.a), paramViewGroup);
    ai = ((TextView)paramLayoutInflater.findViewById(bmj.b));
    aj = ((ImageView)paramLayoutInflater.findViewById(bmj.k));
    w();
    return paramLayoutInflater;
  }
  
  public final jy<bmv> a(int paramInt, Bundle paramBundle)
  {
    paramBundle = null;
    if (ao) {
      return null;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      return e.a(paramInt, paramBundle);
      paramBundle = b;
      continue;
      paramBundle = a;
    }
  }
  
  public final void a()
  {
    e = null;
    super.a();
  }
  
  public final void a(Cursor paramCursor)
  {
    if (f == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((!paramCursor.moveToPosition(al)) || (u()));
        e.a(this, paramCursor);
        localObject1 = j();
        Object localObject2 = ((go)localObject1).b(3);
        if (localObject2 != null)
        {
          localObject2 = (bmu)localObject2;
          a = f.a(paramCursor, "contentUri");
          ((bmu)localObject2).a(a);
          ((bmu)localObject2).j();
        }
      } while (ar);
      localObject1 = ((go)localObject1).b(2);
    } while (localObject1 == null);
    Object localObject1 = (bmu)localObject1;
    b = f.a(paramCursor, "thumbnailUri");
    ((bmu)localObject1).a(b);
    ((bmu)localObject1).j();
  }
  
  public final void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    Bundle localBundle = r;
    if (localBundle == null) {}
    do
    {
      return;
      d = ((Intent)localBundle.getParcelable("arg-intent"));
      at = d.getBooleanExtra("display_thumbs_fullscreen", false);
      al = localBundle.getInt("arg-position");
      ao = localBundle.getBoolean("arg-show-spinner");
      ap = true;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getBundle("com.android.mail.photo.fragments.PhotoViewFragment.INTENT");
        if (paramBundle != null) {
          d = new Intent().putExtras(paramBundle);
        }
      }
    } while (d == null);
    a = d.getStringExtra("resolved_photo_uri");
    b = d.getStringExtra("thumbnail_uri");
    c = d.getStringExtra("content_description");
    an = d.getBooleanExtra("watch_network", false);
  }
  
  public final void b() {}
  
  public final void c()
  {
    w();
  }
  
  public final void c(Bundle paramBundle)
  {
    super.c(paramBundle);
    e = ((blz)f()).h();
    if (e == null) {
      throw new IllegalArgumentException("Activity must be a derived class of PhotoViewActivity");
    }
    f = e.c();
    if (f == null) {
      throw new IllegalStateException("Callback reported null adapter");
    }
    w();
  }
  
  public final void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    if (d != null) {
      paramBundle.putParcelable("com.android.mail.photo.fragments.PhotoViewFragment.INTENT", d.getExtras());
    }
  }
  
  public final void e()
  {
    if (h != null)
    {
      PhotoView localPhotoView = h;
      e = null;
      f = null;
      a = null;
      i.a();
      i = null;
      l.a();
      l = null;
      m.a();
      m = null;
      n.a();
      n = null;
      localPhotoView.setOnClickListener(null);
      g = null;
      s = false;
      h = null;
    }
    super.e();
  }
  
  public final void j_()
  {
    v();
  }
  
  public final void k_()
  {
    if (!e.a(this))
    {
      v();
      return;
    }
    if (!u()) {
      j().a(2, this);
    }
    e.a(this);
  }
  
  public final boolean l_()
  {
    if (!e.a(this)) {}
    for (;;)
    {
      return false;
      if (h != null)
      {
        PhotoView localPhotoView = h;
        int j;
        if (!h) {
          j = 0;
        }
        while (j != 0)
        {
          return true;
          if (!l.g)
          {
            b.getValues(r);
            q.set(p);
            b.mapRect(q);
            float f1 = localPhotoView.getWidth();
            float f2 = r[2];
            float f3 = q.right;
            float f4 = q.left;
            if ((!h) || (f3 - f4 <= f1))
            {
              j = 0;
              continue;
            }
            if (f2 == 0.0F)
            {
              j = 0;
              continue;
            }
          }
          j = 1;
        }
      }
    }
  }
  
  public final boolean m_()
  {
    if (!e.a(this)) {}
    for (;;)
    {
      return false;
      if (h != null)
      {
        PhotoView localPhotoView = h;
        int j;
        if (!h) {
          j = 0;
        }
        while (j != 0)
        {
          return true;
          if (!l.g)
          {
            b.getValues(r);
            q.set(p);
            b.mapRect(q);
            float f1 = localPhotoView.getWidth();
            float f2 = r[2];
            float f3 = q.right - q.left;
            if ((!h) || (f3 <= f1))
            {
              j = 0;
              continue;
            }
            if ((f2 != 0.0F) && (f1 >= f3 + f2))
            {
              j = 0;
              continue;
            }
          }
          j = 1;
        }
      }
    }
  }
  
  public final void o()
  {
    super.o();
    e.a(al, this);
    e.a(this);
    NetworkInfo localNetworkInfo;
    if (an)
    {
      if (g == null) {
        g = new bms(this);
      }
      f().registerReceiver(g, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
      localNetworkInfo = ((ConnectivityManager)f().getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo == null) {
        break label148;
      }
    }
    label148:
    for (as = localNetworkInfo.isConnected();; as = false)
    {
      if (!u())
      {
        ap = true;
        aq.setVisibility(0);
        j().a(2, null, this);
        j().a(3, null, this);
      }
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    e.a();
  }
  
  public final void p()
  {
    if (an) {
      f().unregisterReceiver(g);
    }
    e.b(this);
    e.b(al);
    super.p();
  }
  
  public final boolean u()
  {
    if (h != null)
    {
      if (h.a != null) {}
      for (int j = 1; j != 0; j = 0) {
        return true;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     bmr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */