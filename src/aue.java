import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.android.email.activity.setup.SetupDataFragment;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.Policy;

public final class aue
  extends ats
{
  public Spinner a;
  public Spinner b;
  public CheckBox c;
  public CheckBox d;
  public CheckBox e;
  public CheckBox f;
  public CheckBox g;
  private View h;
  
  private final void a(Account paramAccount)
  {
    int i = 0;
    b.setVisibility(0);
    h.setVisibility(0);
    Object localObject1 = getResources().getTextArray(aqz.c);
    CharSequence[] arrayOfCharSequence = getResources().getTextArray(aqz.a);
    int k = arrayOfCharSequence.length;
    Object localObject2 = v;
    int j = k;
    int m;
    if (localObject2 != null)
    {
      m = s;
      j = k;
      if (m != 0) {
        j = m + 1;
      }
    }
    localObject2 = new awq[j];
    k = -1;
    while (i < j)
    {
      m = Integer.valueOf(localObject1[i].toString()).intValue();
      localObject2[i] = new awq(Integer.valueOf(m), arrayOfCharSequence[i].toString());
      if (m == 3) {
        k = i;
      }
      i += 1;
    }
    localObject1 = new ArrayAdapter(getActivity(), 17367048, (Object[])localObject2);
    ((ArrayAdapter)localObject1).setDropDownViewResource(17367049);
    b.setAdapter((SpinnerAdapter)localObject1);
    awq.a(b, Integer.valueOf(f));
    if (k >= 0) {
      b.setSelection(k);
    }
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    Object localObject2 = getActivity();
    paramBundle = ((awp)getActivity()).l();
    Account localAccount = b;
    Object localObject1 = paramBundle.a((Context)localObject2);
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = bam.e((Context)localObject2, localAccount.f((Context)localObject2));
    }
    localObject1 = y;
    localObject2 = x;
    if ((localObject1 != null) && (localObject2 != null))
    {
      awq[] arrayOfawq = new awq[localObject2.length];
      int i = 0;
      while (i < localObject2.length)
      {
        arrayOfawq[i] = new awq(Integer.valueOf(localObject1[i].toString()), localObject2[i].toString());
        i += 1;
      }
      localObject1 = new ArrayAdapter(getActivity(), 17367048, arrayOfawq);
      ((ArrayAdapter)localObject1).setDropDownViewResource(17367049);
      a.setAdapter((SpinnerAdapter)localObject1);
      awq.a(a, Integer.valueOf(g));
    }
    if (r) {
      a(localAccount);
    }
    if (u)
    {
      d.setVisibility(0);
      d.setChecked(true);
    }
    if (v)
    {
      e.setVisibility(0);
      e.setChecked(true);
    }
    if (!w) {
      g.setVisibility(8);
    }
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = a(paramLayoutInflater, paramViewGroup, arf.s, arh.aC, true);
    a = ((Spinner)paramLayoutInflater.findViewById(are.b));
    b = ((Spinner)paramLayoutInflater.findViewById(are.x));
    c = ((CheckBox)paramLayoutInflater.findViewById(are.i));
    c.setChecked(true);
    d = ((CheckBox)paramLayoutInflater.findViewById(are.v));
    e = ((CheckBox)paramLayoutInflater.findViewById(are.u));
    f = ((CheckBox)paramLayoutInflater.findViewById(are.w));
    f.setChecked(true);
    g = ((CheckBox)paramLayoutInflater.findViewById(are.a));
    g.setChecked(true);
    h = paramLayoutInflater.findViewById(are.y);
    return paramLayoutInflater;
  }
}

/* Location:
 * Qualified Name:     aue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */