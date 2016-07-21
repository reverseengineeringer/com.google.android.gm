import android.content.Context;
import android.view.LayoutInflater;
import com.android.mail.providers.Account;
import com.android.mail.ui.teasers.EmptyTrashSpamBanner;
import com.android.mail.ui.teasers.NestedFolderTeaserView;
import java.util.ArrayList;

public class csl
{
  public ArrayList<cso> a(ckv paramckv, Account paramAccount)
  {
    Object localObject2 = paramckv.g();
    Object localObject1 = LayoutInflater.from((Context)localObject2);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new csn((Context)localObject2));
    localArrayList.add(new csm((Context)localObject2));
    Object localObject3 = new csp((Context)localObject2);
    e = paramAccount;
    f = cfg.a(((csp)localObject3).getContext(), paramAccount);
    g = paramckv.g();
    localArrayList.add(localObject3);
    localObject2 = new csu((Context)localObject2);
    localObject3 = paramckv.i();
    d = paramAccount;
    e = cfg.a(((csu)localObject2).getContext(), paramAccount);
    f = ((cod)localObject3);
    localArrayList.add(localObject2);
    localObject2 = (EmptyTrashSpamBanner)((LayoutInflater)localObject1).inflate(bue.C, null);
    a = paramckv;
    localArrayList.add(localObject2);
    localObject1 = (NestedFolderTeaserView)((LayoutInflater)localObject1).inflate(bue.Z, null);
    paramckv = paramckv.i();
    a = paramAccount;
    c = paramckv;
    localArrayList.add(localObject1);
    return localArrayList;
  }
}

/* Location:
 * Qualified Name:     csl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */