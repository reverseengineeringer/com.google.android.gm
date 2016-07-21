import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

public class byg
  extends cjp
{
  private static final String o = cvl.a;
  bvu l;
  
  public bvu g()
  {
    return new bvu();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (!l.a(paramInt1, paramInt2, paramIntent)) {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    l = g();
    l.a(this, paramBundle);
    Object localObject1 = getIntent();
    Object localObject2 = ((Intent)localObject1).getAction();
    Object localObject3 = ((Intent)localObject1).getType();
    if (paramBundle == null)
    {
      if (("android.intent.action.VIEW".equals(localObject2)) && (cvr.c((String)localObject3)))
      {
        paramBundle = getFragmentManager().beginTransaction();
        int i = buc.eh;
        localObject1 = ((Intent)localObject1).getData();
        localObject2 = new byc();
        localObject3 = new Bundle(1);
        ((Bundle)localObject3).putParcelable("eml_file_uri", (Parcelable)localObject1);
        ((byc)localObject2).setArguments((Bundle)localObject3);
        paramBundle.add(i, (Fragment)localObject2, "eml_message_fragment");
        paramBundle.commit();
        buo.a().a("eml_viewer", null, null, 0L);
      }
    }
    else {
      return;
    }
    cvm.f(o, "Entered EmlViewerActivity with wrong intent action or type: %s, %s", new Object[] { localObject2, localObject3 });
    finish();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    l.a(paramBundle);
  }
  
  public void onStart()
  {
    super.onStart();
    l.a();
  }
  
  public void onStop()
  {
    super.onStop();
    l.b();
  }
}

/* Location:
 * Qualified Name:     byg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */