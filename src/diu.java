import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import com.android.mail.providers.Account;
import com.google.android.apps.common.drive.aclfix.PotentialFix;
import com.google.android.gm.ComposeActivityGmail;
import com.google.android.gm.drive.aclfix.FixPermissionDialogState;
import java.util.ArrayList;

public final class diu
  extends DialogFragment
  implements DialogInterface.OnClickListener, View.OnClickListener, RadioGroup.OnCheckedChangeListener
{
  private RadioGroup a;
  private Spinner b;
  private View c;
  private View d;
  private View e;
  private RadioButton f;
  private View g;
  private Spinner h;
  private Account i;
  private ArrayList<PotentialFix> j;
  private int k;
  private boolean l;
  private boolean m = false;
  
  private static Spinner a(Context paramContext, View paramView, PotentialFix paramPotentialFix, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    int n;
    int i1;
    Object localObject2;
    Object localObject1;
    Resources localResources;
    if (paramBoolean)
    {
      n = dfy.ay;
      i1 = dfy.az;
      localObject2 = (RadioButton)paramView.findViewById(n);
      localObject1 = a;
      localResources = paramContext.getResources();
      if (!"ADD_COLLABORATORS".equals(localObject1)) {
        break label224;
      }
      localObject1 = localResources.getString(dge.cl);
      n = dge.cn;
    }
    for (;;)
    {
      ((RadioButton)localObject2).setText((CharSequence)localObject1);
      localObject2 = paramView.findViewById(i1);
      localObject1 = (Spinner)((View)localObject2).findViewById(dfy.aD);
      paramContext = new div(paramContext, dga.f, d);
      paramContext.setDropDownViewResource(17367049);
      ((Spinner)localObject1).setAdapter(paramContext);
      ((Spinner)localObject1).setSelection(paramInt1);
      if (n != 0)
      {
        paramContext = (TextView)((View)localObject2).findViewById(dfy.aB);
        paramContext.setText(n);
        paramContext.setVisibility(0);
        paramView.post(new diw((Spinner)localObject1, paramContext, (View)localObject2));
      }
      if (!e)
      {
        paramContext = (TextView)((View)localObject2).findViewById(dfy.aA);
        paramContext.setText(localResources.getQuantityString(dgd.b, paramInt2));
        paramContext.setVisibility(0);
      }
      return (Spinner)localObject1;
      n = dfy.bR;
      i1 = dfy.bT;
      break;
      label224:
      if ("INCREASE_PUBLIC_VISIBILITY".equals(localObject1))
      {
        localObject1 = localResources.getString(dge.cp);
        n = dge.cm;
      }
      else
      {
        localObject1 = Html.fromHtml(localResources.getString(dge.co, new Object[] { mx.a().a(f) }));
        n = 0;
      }
    }
  }
  
  private final void a()
  {
    c.setVisibility(0);
    d.setVisibility(8);
    e.setVisibility(0);
    f.setVisibility(0);
    g.setVisibility(0);
    m = true;
  }
  
  public final void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (paramInt == dfy.ay)
    {
      b.setEnabled(true);
      h.setEnabled(false);
      return;
    }
    if (paramInt == dfy.bR)
    {
      b.setEnabled(false);
      h.setEnabled(true);
      return;
    }
    b.setEnabled(false);
    h.setEnabled(false);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == -1)
    {
      n = a.getCheckedRadioButtonId();
      i1 = b.getSelectedItemPosition();
      i2 = h.getSelectedItemPosition();
      if (n == dfy.ay)
      {
        paramDialogInterface = (PotentialFix)j.get(0);
        str1 = (String)b.getSelectedItem();
        paramInt = 0;
        str2 = "0";
        localFixPermissionDialogState = new FixPermissionDialogState(m, n, i1, i2);
        ((ComposeActivityGmail)getActivity()).a(paramDialogInterface, str1, localFixPermissionDialogState, j, k, l);
        buo.a().a("acl_fixer", "fix_selected", str2, paramInt);
        buo.a().a("acl_fixer", "acl_fixer_dialog", "first_spinner_position", i1);
        if (m) {
          buo.a().a("acl_fixer", "acl_fixer_dialog", "second_spinner_position", i2);
        }
        buo.a().a("acl_fixer", "acl_fixer_dialog", "confirm", 0L);
      }
    }
    while (paramInt != -2) {
      for (;;)
      {
        int n;
        int i1;
        int i2;
        String str1;
        String str2;
        FixPermissionDialogState localFixPermissionDialogState;
        return;
        if (n == dfy.bR)
        {
          paramDialogInterface = (PotentialFix)j.get(1);
          str1 = (String)h.getSelectedItem();
          paramInt = 1;
          str2 = "1";
        }
        else
        {
          str1 = null;
          paramInt = 2;
          str2 = "2";
          paramDialogInterface = null;
        }
      }
    }
    buo.a().a("acl_fixer", "acl_fixer_dialog", "cancel", 0L);
  }
  
  public final void onClick(View paramView)
  {
    int n = paramView.getId();
    if (n == dfy.bl)
    {
      a();
      buo.a().a("acl_fixer", "acl_fixer_dialog", "more_options_clicked", 0L);
    }
    while (n != dfy.aC) {
      return;
    }
    dev.a(getActivity());
    new dyv().a(getActivity(), i, "androiddrive", null);
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(getActivity());
    Context localContext = localBuilder.getContext();
    Object localObject2 = LayoutInflater.from(localContext);
    Object localObject3 = getArguments();
    i = ((Account)((Bundle)localObject3).getParcelable("account"));
    Object localObject1 = (FixPermissionDialogState)((Bundle)localObject3).getParcelable("dialogState");
    j = ((Bundle)localObject3).getParcelableArrayList("potentialFixes");
    k = ((Bundle)localObject3).getInt("numFiles");
    l = ((Bundle)localObject3).getBoolean("showToast");
    int n;
    if (paramBundle != null)
    {
      m = paramBundle.getBoolean("secondOptionShown", false);
      paramBundle = null;
      localObject1 = ((LayoutInflater)localObject2).inflate(dga.y, null);
      ((View)localObject1).findViewById(dfy.aC).setOnClickListener(this);
      localObject2 = ((LayoutInflater)localObject2).inflate(dga.x, null);
      a = ((RadioGroup)((View)localObject2).findViewById(dfy.bL));
      if (paramBundle != null) {
        a.check(b);
      }
      localObject3 = (PotentialFix)j.get(0);
      if (paramBundle == null) {
        break label454;
      }
      n = c;
      label198:
      b = a(localContext, (View)localObject2, (PotentialFix)localObject3, true, n, k);
      g = ((View)localObject2).findViewById(dfy.bT);
      if (j.size() <= 1) {
        break label492;
      }
      d = ((View)localObject2).findViewById(dfy.bl);
      localObject3 = (PotentialFix)j.get(1);
      if (paramBundle == null) {
        break label459;
      }
      n = d;
      label274:
      h = a(localContext, (View)localObject2, (PotentialFix)localObject3, false, n, k);
      e = ((View)localObject2).findViewById(dfy.bS);
      f = ((RadioButton)((View)localObject2).findViewById(dfy.bR));
      g.setVisibility(8);
      c = ((View)localObject2).findViewById(dfy.az).findViewById(dfy.bx);
      if (!m) {
        break label464;
      }
      a();
    }
    for (;;)
    {
      h.setId(dfy.aE);
      a.setOnCheckedChangeListener(this);
      onCheckedChanged(a, a.getCheckedRadioButtonId());
      ((RadioButton)((View)localObject2).findViewById(dfy.bj)).setText(dge.cr);
      return localBuilder.setCustomTitle((View)localObject1).setView((View)localObject2).setPositiveButton(dge.fr, this).setNegativeButton(dge.bG, null).create();
      if (localObject1 != null) {
        m = a;
      }
      paramBundle = (Bundle)localObject1;
      break;
      label454:
      n = 0;
      break label198;
      label459:
      n = 0;
      break label274;
      label464:
      c.setVisibility(8);
      d.setVisibility(0);
      d.setOnClickListener(this);
      continue;
      label492:
      g.setVisibility(8);
      h = ((Spinner)g.findViewById(dfy.aD));
      h.setId(dfy.aE);
    }
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("secondOptionShown", m);
  }
}

/* Location:
 * Qualified Name:     diu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */