import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public final class dha
  extends DialogFragment
  implements DialogInterface.OnClickListener, View.OnClickListener
{
  private static final SparseIntArray b = new SparseIntArray();
  private static final SparseIntArray c = new SparseIntArray();
  public dhb a;
  private int[] d;
  private int e = -1;
  private Button f;
  
  static
  {
    b.append(2, dge.aW);
    b.append(4, dge.aX);
    b.append(5, dge.aJ);
    b.append(8, dge.aK);
    b.append(300, dge.aP);
    b.append(301, dge.aL);
    b.append(302, dge.aG);
    b.append(303, dge.aO);
    b.append(304, dge.bb);
    b.append(305, dge.aZ);
    b.append(306, dge.aN);
    b.append(307, dge.aM);
    b.append(400, dge.aQ);
    b.append(401, dge.aH);
    b.append(402, dge.aY);
    b.append(3000, dge.aU);
    b.append(3001, dge.ba);
    b.append(3002, dge.aT);
    b.append(3003, dge.aV);
    b.append(3004, dge.aI);
    b.append(3005, dge.aF);
    b.append(1000, dge.aR);
    b.append(1001, dge.aR);
    b.append(1002, dge.aR);
    b.append(1003, dge.aR);
    b.append(1004, dge.aR);
    b.append(1005, dge.aR);
    b.append(1006, dge.aR);
    b.append(1007, dge.aR);
    b.append(1008, dge.aR);
    b.append(1009, dge.aR);
    b.append(1010, dge.aR);
    b.append(1011, dge.aR);
    b.append(1012, dge.aR);
    b.append(1013, dge.aR);
    b.append(1014, dge.aR);
    b.append(1015, dge.aR);
    b.append(1016, dge.aR);
    b.append(1017, dge.aR);
    b.append(1018, dge.aR);
    b.append(1019, dge.aR);
    b.append(1020, dge.aR);
    b.append(1021, dge.aR);
    b.append(1022, dge.aR);
    b.append(1023, dge.aR);
    b.append(1024, dge.aR);
    b.append(1025, dge.aR);
    b.append(2000, dge.aS);
    b.append(2001, dge.aS);
    b.append(2002, dge.aS);
    b.append(2003, dge.aS);
    b.append(2004, dge.aS);
    b.append(2005, dge.aS);
    b.append(2006, dge.aS);
    b.append(2007, dge.aS);
    b.append(2008, dge.aS);
    b.append(2010, dge.aS);
    b.append(2009, dge.aS);
    b.append(2011, dge.aS);
    b.append(2012, dge.aS);
    b.append(2013, dge.aS);
    b.append(2014, dge.aS);
    b.append(2015, dge.aS);
    b.append(2016, dge.aS);
    b.append(2017, dge.aS);
    b.append(4000, dge.aR);
    b.append(4001, dge.aR);
    b.append(4002, dge.aR);
    b.append(4003, dge.aR);
    b.append(4004, dge.aR);
    b.append(4005, dge.aR);
    b.append(4006, dge.aR);
    b.append(4007, dge.aR);
    b.append(4008, dge.aR);
    b.append(4009, dge.aR);
    b.append(4010, dge.aR);
    b.append(4011, dge.aR);
    b.append(4012, dge.aR);
    b.append(4013, dge.aR);
    b.append(4014, dge.aR);
    b.append(4015, dge.aR);
    b.append(4016, dge.aR);
    b.append(4017, dge.aR);
    b.append(4018, dge.aR);
    b.append(4019, dge.aR);
    c.append(1000, dge.e);
    c.append(1001, dge.f);
    c.append(1002, dge.g);
    c.append(1003, dge.h);
    c.append(1004, dge.i);
    c.append(1005, dge.j);
    c.append(1006, dge.k);
    c.append(1007, dge.l);
    c.append(1008, dge.m);
    c.append(1009, dge.n);
    c.append(1010, dge.o);
    c.append(1011, dge.p);
    c.append(1012, dge.q);
    c.append(1013, dge.r);
    c.append(1014, dge.s);
    c.append(1015, dge.t);
    c.append(1016, dge.u);
    c.append(1017, dge.v);
    c.append(1018, dge.w);
    c.append(1019, dge.x);
    c.append(1020, dge.y);
    c.append(1021, dge.z);
    c.append(1022, dge.A);
    c.append(1023, dge.B);
    c.append(1024, dge.C);
    c.append(1025, dge.D);
    c.append(2000, dge.E);
    c.append(2001, dge.F);
    c.append(2002, dge.G);
    c.append(2003, dge.H);
    c.append(2004, dge.I);
    c.append(2005, dge.J);
    c.append(2006, dge.K);
    c.append(2007, dge.L);
    c.append(2008, dge.M);
    c.append(2010, dge.O);
    c.append(2009, dge.N);
    c.append(2011, dge.P);
    c.append(2012, dge.Q);
    c.append(2013, dge.R);
    c.append(2014, dge.S);
    c.append(2015, dge.T);
    c.append(2016, dge.U);
    c.append(2017, dge.V);
    c.append(4000, dge.ai);
    c.append(4001, dge.aj);
    c.append(4002, dge.ak);
    c.append(4003, dge.al);
    c.append(4004, dge.am);
    c.append(4005, dge.an);
    c.append(4006, dge.ao);
    c.append(4007, dge.ap);
    c.append(4008, dge.aq);
    c.append(4009, dge.ar);
    c.append(4010, dge.as);
    c.append(4011, dge.at);
    c.append(4012, dge.au);
    c.append(4013, dge.av);
    c.append(4014, dge.aw);
    c.append(4015, dge.ax);
    c.append(4016, dge.ay);
    c.append(4017, dge.az);
    c.append(4018, dge.aA);
    c.append(4019, dge.aB);
  }
  
  private final void a(int paramInt)
  {
    if (a != null)
    {
      if ((paramInt >= 0) && (paramInt < d.length)) {
        a.a(d[paramInt]);
      }
    }
    else {
      return;
    }
    a.a(-1);
  }
  
  public static boolean a(int[] paramArrayOfInt)
  {
    int i = c(paramArrayOfInt);
    return (i >= 3) && (i <= 8);
  }
  
  private static String[] a(Resources paramResources, int[] paramArrayOfInt)
  {
    String[] arrayOfString = new String[paramArrayOfInt.length];
    int k = paramArrayOfInt.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      int n = paramArrayOfInt[j];
      int m = b.get(n, -1);
      n = c.get(n, -1);
      if (n != -1) {}
      for (String str = paramResources.getString(m, new Object[] { paramResources.getString(n) });; str = paramResources.getString(m))
      {
        arrayOfString[i] = str;
        j += 1;
        i += 1;
        break;
      }
    }
    return arrayOfString;
  }
  
  public static int[] b(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      arrayOfInt = null;
    }
    do
    {
      return arrayOfInt;
      i = c(paramArrayOfInt);
      arrayOfInt = paramArrayOfInt;
    } while (paramArrayOfInt.length == i);
    int[] arrayOfInt = new int[i];
    int m = paramArrayOfInt.length;
    int j = 0;
    int i = 0;
    if (j < m)
    {
      int n = paramArrayOfInt[j];
      if (b.indexOfKey(n) < 0) {
        break label81;
      }
      int k = i + 1;
      arrayOfInt[i] = n;
      i = k;
    }
    label81:
    for (;;)
    {
      j += 1;
      break;
      return arrayOfInt;
    }
  }
  
  private static int c(int[] paramArrayOfInt)
  {
    int i = 0;
    int k = 0;
    if (paramArrayOfInt == null) {
      return k;
    }
    int m = paramArrayOfInt.length;
    int j = 0;
    for (;;)
    {
      k = i;
      if (j >= m) {
        break;
      }
      int n = paramArrayOfInt[j];
      k = i;
      if (b.indexOfKey(n) >= 0) {
        k = i + 1;
      }
      j += 1;
      i = k;
    }
  }
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    super.onCancel(paramDialogInterface);
    a(-1);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == -1)
    {
      a(e);
      return;
    }
    if (paramInt == -2)
    {
      a(-1);
      return;
    }
    e = paramInt;
    f.setEnabled(true);
  }
  
  public final void onClick(View paramView)
  {
    if (paramView.getId() == dfy.n) {
      dfh.b(getActivity());
    }
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = new AlertDialog.Builder(getActivity());
    Context localContext = paramBundle.getContext();
    LayoutInflater localLayoutInflater = LayoutInflater.from(localContext);
    Resources localResources1 = localContext.getResources();
    d = getArguments().getIntArray("option_list");
    View localView = localLayoutInflater.inflate(dga.k, null);
    TextView localTextView = (TextView)localView.findViewById(dfy.n);
    Resources localResources2 = localContext.getResources();
    String str = localResources2.getString(dge.fh);
    localTextView.setText(cwt.a(localContext, localResources2.getString(dge.bc, new Object[] { str }), str, dgf.b));
    localTextView.setOnClickListener(this);
    paramBundle.setCustomTitle(localLayoutInflater.inflate(dga.l, null)).setSingleChoiceItems(a(localResources1, d), -1, this).setView(localView).setPositiveButton(dge.eA, this).setNegativeButton(dge.bG, this);
    return paramBundle.create();
  }
  
  public final void onDetach()
  {
    super.onDetach();
    a = null;
  }
  
  public final void onStart()
  {
    super.onStart();
    Object localObject = (AlertDialog)getDialog();
    f = ((AlertDialog)localObject).getButton(-1);
    e = ((AlertDialog)localObject).getListView().getCheckedItemPosition();
    localObject = f;
    if (e >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((Button)localObject).setEnabled(bool);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     dha
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */