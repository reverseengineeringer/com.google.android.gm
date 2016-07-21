import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.android.mail.browse.ConversationMessage;

public class cfc
  extends blm
  implements bvv
{
  static final String m = String.valueOf(cfc.class.getName()).concat("-acct");
  static final String n = String.valueOf(cfc.class.getName()).concat("-accttype");
  static final String o = String.valueOf(cfc.class.getName()).concat("-msg");
  static final String p = String.valueOf(cfc.class.getName()).concat("-hide-extra-option-one");
  static final String q = cvl.a;
  private bvu r;
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, ConversationMessage paramConversationMessage, String paramString3)
  {
    if (x == null)
    {
      cvm.e(q, "No attachmentListUri in message", new Object[0]);
      return null;
    }
    paramContext = blk.a(paramContext, paramContext.getString(buj.dE));
    c = x.toString();
    e = chh.o;
    b = paramString3;
    return a(paramContext.a(), paramString1, paramString2, paramConversationMessage);
  }
  
  private static Intent a(Intent paramIntent, String paramString1, String paramString2, ConversationMessage paramConversationMessage)
  {
    paramIntent.putExtra(o, paramConversationMessage);
    paramIntent.putExtra(m, paramString1);
    paramIntent.putExtra(n, paramString2);
    paramString1 = p;
    if (paramConversationMessage.a() == null) {}
    for (boolean bool = true;; bool = false)
    {
      paramIntent.putExtra(paramString1, bool);
      return paramIntent;
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, ConversationMessage paramConversationMessage, int paramInt)
  {
    bll localbll = blk.a(paramContext, paramContext.getString(buj.dE));
    c = x.toString();
    e = chh.o;
    a = Integer.valueOf(paramInt);
    paramContext.startActivity(a(localbll.a(), paramString1, paramString2, paramConversationMessage));
  }
  
  public final bvu a()
  {
    return r;
  }
  
  public blq g()
  {
    return new cfd(this);
  }
  
  public bvu k()
  {
    return new bvu();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (!r.a(paramInt1, paramInt2, paramIntent)) {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if ((paramInt1 == 1) && (paramInt2 == -1) && (paramIntent != null)) {
      ((cfd)l).a(paramIntent.getStringArrayExtra("permissions"), paramIntent.getIntArrayExtra("grantResults"));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    r = k();
    r.a(this, paramBundle);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramInt != 1) {
      throw new IllegalStateException(40 + "unexpected permission result " + paramInt);
    }
    ((cfd)l).a(paramArrayOfString, paramArrayOfInt);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    r.a(paramBundle);
  }
  
  protected void onStart()
  {
    super.onStart();
    r.a();
  }
  
  protected void onStop()
  {
    super.onStop();
    r.b();
  }
}

/* Location:
 * Qualified Name:     cfc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */