import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

final class zs
{
  TextView A;
  TextView B;
  View C;
  ListAdapter D;
  int E = -1;
  int F;
  int G;
  int H;
  int I;
  int J;
  int K;
  int L = 0;
  Handler M;
  final View.OnClickListener N = new zt(this);
  final Context a;
  final abf b;
  final Window c;
  CharSequence d;
  CharSequence e;
  ListView f;
  View g;
  int h;
  int i;
  int j;
  int k;
  int l;
  boolean m = false;
  Button n;
  CharSequence o;
  Message p;
  Button q;
  CharSequence r;
  Message s;
  Button t;
  CharSequence u;
  Message v;
  NestedScrollView w;
  int x = 0;
  Drawable y;
  ImageView z;
  
  public zs(Context paramContext, abf paramabf, Window paramWindow)
  {
    a = paramContext;
    b = paramabf;
    c = paramWindow;
    M = new aad(paramabf);
    paramContext = paramContext.obtainStyledAttributes(null, ack.I, aca.o, 0);
    F = paramContext.getResourceId(ack.J, 0);
    G = paramContext.getResourceId(ack.K, 0);
    H = paramContext.getResourceId(ack.M, 0);
    I = paramContext.getResourceId(ack.N, 0);
    J = paramContext.getResourceId(ack.O, 0);
    K = paramContext.getResourceId(ack.L, 0);
    paramContext.recycle();
    paramabf.a().c(1);
  }
  
  static ViewGroup a(View paramView1, View paramView2)
  {
    if (paramView1 == null) {
      if (!(paramView2 instanceof ViewStub)) {
        break label71;
      }
    }
    label71:
    for (paramView1 = ((ViewStub)paramView2).inflate();; paramView1 = paramView2)
    {
      return (ViewGroup)paramView1;
      if (paramView2 != null)
      {
        ViewParent localViewParent = paramView2.getParent();
        if ((localViewParent instanceof ViewGroup)) {
          ((ViewGroup)localViewParent).removeView(paramView2);
        }
      }
      if ((paramView1 instanceof ViewStub)) {
        paramView1 = ((ViewStub)paramView1).inflate();
      }
      for (;;)
      {
        return (ViewGroup)paramView1;
      }
    }
  }
  
  static boolean a(View paramView)
  {
    if (paramView.onCheckIsTextEditor()) {
      return true;
    }
    if (!(paramView instanceof ViewGroup)) {
      return false;
    }
    paramView = (ViewGroup)paramView;
    int i1 = paramView.getChildCount();
    while (i1 > 0)
    {
      int i2 = i1 - 1;
      i1 = i2;
      if (a(paramView.getChildAt(i2))) {
        return true;
      }
    }
    return false;
  }
  
  public final void a(int paramInt)
  {
    y = null;
    x = paramInt;
    if (z != null)
    {
      if (paramInt != 0)
      {
        z.setVisibility(0);
        z.setImageResource(x);
      }
    }
    else {
      return;
    }
    z.setVisibility(8);
  }
  
  public final void a(int paramInt, CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener, Message paramMessage)
  {
    if (paramOnClickListener != null) {
      paramMessage = M.obtainMessage(paramInt, paramOnClickListener);
    }
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Button does not exist");
    case -1: 
      o = paramCharSequence;
      p = paramMessage;
      return;
    case -2: 
      r = paramCharSequence;
      s = paramMessage;
      return;
    }
    u = paramCharSequence;
    v = paramMessage;
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    d = paramCharSequence;
    if (A != null) {
      A.setText(paramCharSequence);
    }
  }
}

/* Location:
 * Qualified Name:     zs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */