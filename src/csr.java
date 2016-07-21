import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.mail.ui.teasers.AbstractSwipeableConversationSpecialItemView;

public abstract class csr
  extends AbstractSwipeableConversationSpecialItemView
  implements View.OnClickListener
{
  private final View d = LayoutInflater.from(a).inflate(s(), this, false);
  private TextView e;
  public View i;
  
  public csr(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private csr(Context paramContext, byte paramByte)
  {
    super(paramContext, null);
    addView(d);
    t();
  }
  
  protected final void a(CharSequence paramCharSequence)
  {
    e.setText(paramCharSequence);
  }
  
  public ViewGroup.LayoutParams getLayoutParams()
  {
    ViewGroup.LayoutParams localLayoutParams = super.getLayoutParams();
    if (localLayoutParams != null)
    {
      width = -1;
      height = -2;
    }
    return localLayoutParams;
  }
  
  public final cqk l()
  {
    return cqk.a(i);
  }
  
  public void onClick(View paramView)
  {
    i();
  }
  
  protected css p()
  {
    return null;
  }
  
  public final int q()
  {
    return 0;
  }
  
  protected View.OnClickListener r()
  {
    return null;
  }
  
  public int s()
  {
    return bue.v;
  }
  
  public void t()
  {
    i = d.findViewById(buc.aH);
    e = ((TextView)d.findViewById(buc.aI));
    ImageView localImageView1 = (ImageView)d.findViewById(buc.aG);
    ImageView localImageView2 = (ImageView)d.findViewById(buc.bc);
    css localcss = p();
    if (localcss != null)
    {
      localImageView1.setVisibility(0);
      localImageView1.setContentDescription(c);
      localImageView1.setImageResource(a);
      if (b != -1) {
        localImageView1.setBackgroundResource(b);
      }
    }
    for (;;)
    {
      localImageView2.setOnClickListener(this);
      e.setOnClickListener(r());
      return;
      localImageView1.setVisibility(8);
    }
  }
}

/* Location:
 * Qualified Name:     csr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */