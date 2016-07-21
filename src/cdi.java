import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;

public abstract class cdi
{
  public final Folder a;
  public final Account b;
  public final ckv c;
  public final LayoutInflater d;
  public final int e;
  
  protected cdi(ckv paramckv, Folder paramFolder, int paramInt, Account paramAccount)
  {
    c = paramckv;
    a = paramFolder;
    e = paramInt;
    b = paramAccount;
    d = LayoutInflater.from(paramckv.g());
  }
  
  public static cdi a(ckv paramckv)
  {
    return new cdn(paramckv);
  }
  
  public static cdi a(ckv paramckv, int paramInt)
  {
    return new cdl(paramckv, paramInt);
  }
  
  public static cdi a(ckv paramckv, Folder paramFolder, int paramInt)
  {
    return new cdj(paramckv, paramFolder, paramInt);
  }
  
  public abstract View a(View paramView, ViewGroup paramViewGroup);
  
  public abstract boolean a();
  
  public abstract boolean a(cus paramcus, int paramInt);
  
  public abstract int b();
  
  public void onClick(View paramView) {}
}

/* Location:
 * Qualified Name:     cdi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */