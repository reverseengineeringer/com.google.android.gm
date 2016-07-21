import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public final class bwz
{
  public final int A;
  public final float B;
  public final int C;
  public final int D;
  public final int E;
  public final int F;
  public final int G;
  public final int H;
  public final int I;
  public final int J;
  public final int K;
  public final int L;
  public final int M;
  public final int N;
  public final int O;
  private final int P;
  private final int Q;
  private final int R;
  private final int S;
  public final int a;
  public final int b;
  public final int c;
  public final int d;
  public final int e;
  public final int f;
  public final int g;
  public final int h;
  public final int i;
  public final float j;
  public final int k;
  public final int l;
  public final int m;
  public final int n;
  public final float o;
  public final int p;
  public final int q;
  public final int r;
  public final int s;
  public final float t;
  public final int u;
  public final int v;
  public final int w;
  public final int x;
  public final Typeface y;
  public final float z;
  
  public bwz(Context paramContext, bxa parambxa, bxb parambxb)
  {
    cxa.g("CIV coordinates constructor");
    Resources localResources = paramContext.getResources();
    int i1 = bue.l;
    Object localObject2 = (ViewGroup)b.get(i1);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = (ViewGroup)LayoutInflater.from(paramContext).inflate(i1, null);
      b.put(i1, localObject1);
    }
    localObject2 = (TextView)((ViewGroup)localObject1).findViewById(buc.bE);
    label95:
    label144:
    label164:
    label191:
    int i2;
    label238:
    ImageView localImageView;
    label309:
    label438:
    boolean bool;
    if (d)
    {
      i1 = 0;
      ((TextView)localObject2).setVisibility(i1);
      parambxb = ((ViewGroup)localObject1).findViewById(buc.ao);
      switch (b)
      {
      default: 
        parambxb.setVisibility(8);
        parambxb = null;
        View localView1 = ((ViewGroup)localObject1).findViewById(buc.dV);
        if (e)
        {
          i1 = 0;
          localView1.setVisibility(i1);
          View localView2 = ((ViewGroup)localObject1).findViewById(buc.dh);
          if (!f) {
            break label983;
          }
          i1 = 0;
          localView2.setVisibility(i1);
          switch (g)
          {
          case 1: 
          default: 
            i3 = 8;
            i2 = 0;
            i1 = 0;
            localImageView = (ImageView)((ViewGroup)localObject1).findViewById(buc.dA);
            localImageView.setVisibility(i3);
            if (i3 != 8)
            {
              localImageView.setImageResource(i2);
              S = paramContext.getResources().getDimensionPixelSize(i1);
              rg.a(localImageView, rg.k(localImageView), localImageView.getPaddingTop(), S, localImageView.getPaddingBottom());
              rg.d((View)localObject1, c);
              ((ViewGroup)localObject1).measure(View.MeasureSpec.makeMeasureSpec(a, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
              ((ViewGroup)localObject1).layout(0, 0, ((ViewGroup)localObject1).getMeasuredWidth(), ((ViewGroup)localObject1).getMeasuredHeight());
              u = ((int)(((ViewGroup)localObject1).getWidth() * localResources.getInteger(bud.q) / 100.0D));
              v = ((int)(((ViewGroup)localObject1).getWidth() * localResources.getInteger(bud.o) / 100.0D));
              if (parambxb == null) {
                break label1030;
              }
              M = parambxb.getWidth();
              L = parambxb.getHeight();
              N = a(parambxb);
              O = b(parambxb);
              bool = cxe.a((View)localObject1);
              paramContext = ((ViewGroup)localObject1).findViewById(buc.eX);
              i1 = localResources.getDimensionPixelSize(bua.u);
              i2 = a(paramContext);
              if (bool) {
                i1 = 0;
              }
              b = (i1 + i2);
              c = b(paramContext);
              d = paramContext.getWidth();
              paramContext = (TextView)((ViewGroup)localObject1).findViewById(buc.eD);
              i2 = a(paramContext);
              e = a(paramContext);
              f = (b(paramContext) + i2);
              g = paramContext.getWidth();
              h = paramContext.getHeight();
              i = 1;
              j = paramContext.getTextSize();
              paramContext = (TextView)((ViewGroup)localObject1).findViewById(buc.fc);
              i1 = a(paramContext);
              k = a(paramContext);
              l = (i1 + b(paramContext));
              m = paramContext.getWidth();
              n = paramContext.getHeight();
              o = paramContext.getTextSize();
              paramContext = (TextView)((ViewGroup)localObject1).findViewById(buc.eS);
              i1 = a(paramContext);
              p = a(paramContext);
              q = (i1 + b(paramContext));
              r = paramContext.getWidth();
              s = paramContext.getHeight();
              t = paramContext.getTextSize();
              if (!d) {
                break label1053;
              }
              P = a((View)localObject2);
              w = (P + ((TextView)localObject2).getWidth());
              x = b((View)localObject2);
              y = ((TextView)localObject2).getTypeface();
              z = ((TextView)localObject2).getTextSize();
              label748:
              if (!e) {
                break label1081;
              }
              H = a(localView1);
              I = b(localView1);
              label773:
              if (!f) {
                break label1094;
              }
              J = a(localView2);
              K = b(localView2);
            }
            break;
          }
        }
        break;
      }
    }
    for (;;)
    {
      paramContext = (TextView)((ViewGroup)localObject1).findViewById(buc.aR);
      Q = a(paramContext);
      R = b(paramContext);
      A = rg.k(paramContext);
      B = paramContext.getTextSize();
      i1 = R;
      i3 = a(paramContext);
      C = (paramContext.getBaseline() + (i1 + i3));
      paramContext = ((ViewGroup)localObject1).findViewById(buc.y);
      D = b(paramContext);
      E = rg.k(paramContext);
      switch (g)
      {
      case 1: 
      default: 
        G = -1;
        F = -1;
        a = (((ViewGroup)localObject1).getHeight() + i2);
        cxa.a();
        return;
        i1 = 8;
        break label95;
        parambxb.setVisibility(0);
        break label144;
        parambxb.setVisibility(8);
        parambxb = null;
        break label144;
        i1 = 8;
        break label164;
        label983:
        i1 = 8;
        break label191;
        i2 = bub.aA;
        i1 = bua.t;
        i3 = 0;
        break label238;
        i2 = bub.aI;
        i1 = bua.t;
        i3 = 0;
        break label238;
        S = 0;
        break label309;
        label1030:
        L = 0;
        M = 0;
        O = 0;
        N = 0;
        break label438;
        label1053:
        P = 0;
        w = 0;
        x = 0;
        y = null;
        z = 0.0F;
        break label748;
        label1081:
        I = 0;
        H = 0;
        break label773;
        label1094:
        K = 0;
        J = 0;
      }
    }
    G = b(localImageView);
    int i3 = a(localImageView);
    if (bool) {}
    for (i1 = S;; i1 = 0)
    {
      F = (i1 + i3);
      break;
    }
  }
  
  private static int a(View paramView)
  {
    int i2;
    for (int i1 = 0; paramView != null; i1 = i2 + i1)
    {
      i2 = (int)paramView.getX();
      paramView = (View)paramView.getParent();
    }
    return i1;
  }
  
  private static int a(TextView paramTextView)
  {
    paramTextView = paramTextView.getPaint().getFontMetricsInt();
    return top - ascent;
  }
  
  private static int b(View paramView)
  {
    int i2;
    for (int i1 = 0; paramView != null; i1 = i2 + i1)
    {
      i2 = (int)paramView.getY();
      paramView = (View)paramView.getParent();
    }
    return i1;
  }
}

/* Location:
 * Qualified Name:     bwz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */