import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.android.mail.providers.Account;
import java.util.HashMap;
import java.util.Map;

public final class dxv
  extends csr
{
  boolean d;
  Account e;
  drj f;
  
  public dxv(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void i()
  {
    if (d)
    {
      drj localdrj = f;
      HashMap localHashMap = new HashMap();
      localHashMap.put("bx_eidps", "true");
      localdrj.a(localHashMap, true);
      d = false;
      buo.a().a("list_swipe", "always_show_images_tip", null, 0L);
    }
    super.i();
  }
  
  public final boolean n()
  {
    return d;
  }
  
  public final boolean o()
  {
    return false;
  }
  
  protected final int s()
  {
    return dga.o;
  }
  
  protected final void t()
  {
    i = findViewById(dfy.cp);
    findViewById(dfy.av).setOnClickListener(new dxw(this));
    Object localObject1 = getResources();
    Object localObject2 = ((Resources)localObject1).getString(dge.ef);
    localObject2 = cwt.a(getContext(), ((Resources)localObject1).getString(dge.bl, new Object[] { localObject2 }), (String)localObject2, dgf.b);
    TextView localTextView = (TextView)findViewById(dfy.au);
    localTextView.setText((CharSequence)localObject2);
    localTextView.setOnClickListener(new dxx(this));
    localObject2 = ((Resources)localObject1).getString(dge.eo);
    localObject1 = ((Resources)localObject1).getString(dge.bm, new Object[] { ((Resources)localObject1).getString(dge.eN), localObject2 });
    localObject1 = cwt.a(getContext(), (String)localObject1, (String)localObject2, dgf.b);
    localObject2 = (TextView)findViewById(dfy.ad);
    ((TextView)localObject2).setText((CharSequence)localObject1);
    ((TextView)localObject2).setOnClickListener(new dxy(this));
  }
}

/* Location:
 * Qualified Name:     dxv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */