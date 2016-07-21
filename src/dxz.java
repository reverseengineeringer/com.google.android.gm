import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.mail.ui.teasers.AbstractSwipeableConversationSpecialItemView;

public abstract class dxz
  extends AbstractSwipeableConversationSpecialItemView
  implements View.OnClickListener
{
  public View d;
  public ImageView e;
  public TextView f;
  public TextView g;
  public View h;
  public TextView i;
  public TextView j;
  public View k;
  public TextView l;
  public TextView m;
  
  public dxz(Context paramContext)
  {
    super(paramContext);
    setBackgroundResource(dfv.A);
  }
  
  public dxz(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setBackgroundResource(dfv.A);
  }
  
  public dxz(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setBackgroundResource(dfv.A);
  }
  
  private static void a(CharSequence paramCharSequence, TextView paramTextView1, TextView paramTextView2)
  {
    if (TextUtils.isEmpty(paramCharSequence))
    {
      paramTextView1.setVisibility(8);
      paramTextView2.setVisibility(8);
      return;
    }
    paramTextView1.setVisibility(0);
    paramTextView2.setVisibility(0);
    paramTextView1.setText(paramCharSequence);
    paramTextView2.setText(paramCharSequence);
  }
  
  public final void a(int paramInt)
  {
    a(getContext().getString(paramInt));
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    a(paramCharSequence, i, l);
  }
  
  public final void b(int paramInt)
  {
    b(getContext().getString(paramInt));
  }
  
  public final void b(CharSequence paramCharSequence)
  {
    a(paramCharSequence, j, m);
  }
  
  public final cqk l()
  {
    return cqk.a(d);
  }
  
  public final void onClick(View paramView)
  {
    int n = paramView.getId();
    if ((n == dfy.bE) || (n == dfy.bD)) {
      r();
    }
    while ((n != dfy.bC) && (n != dfy.bB)) {
      return;
    }
    s();
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    d = findViewById(dfy.cp);
    e = ((ImageView)findViewById(dfy.bI));
    f = ((TextView)findViewById(dfy.bK));
    g = ((TextView)findViewById(dfy.bH));
    h = findViewById(dfy.bG);
    i = ((TextView)h.findViewById(dfy.bE));
    j = ((TextView)h.findViewById(dfy.bC));
    k = findViewById(dfy.bF);
    l = ((TextView)k.findViewById(dfy.bD));
    m = ((TextView)k.findViewById(dfy.bB));
    i.setOnClickListener(this);
    j.setOnClickListener(this);
    l.setOnClickListener(this);
    m.setOnClickListener(this);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    p();
  }
  
  public final void p()
  {
    if (i.getMeasuredHeight() > j.getMeasuredHeight()) {}
    for (int n = 1; n != 0; n = 0)
    {
      h.setVisibility(8);
      k.setVisibility(0);
      return;
    }
    h.setVisibility(0);
    k.setVisibility(8);
  }
  
  public final int q()
  {
    return 0;
  }
  
  public abstract void r();
  
  public abstract void s();
}

/* Location:
 * Qualified Name:     dxz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */