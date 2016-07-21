import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.android.emailcommon.mail.Address;

public abstract class byz
  extends ImageView
  implements View.OnClickListener
{
  public Drawable a;
  public Drawable b;
  public bva c;
  public int d = 0;
  public bvz e;
  
  public byz(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public byz(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public byz(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public abstract void a(Address paramAddress, btn parambtn);
}

/* Location:
 * Qualified Name:     byz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */