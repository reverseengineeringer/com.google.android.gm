import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.android.mail.providers.Account;
import java.util.Calendar;

public abstract class csg
  extends zh
  implements TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener, aor, csj
{
  private static final String s = cvl.a;
  private aon A = new aon(this);
  private csi B;
  private csh C;
  public boolean l;
  public Calendar m = Calendar.getInstance();
  public Calendar n = Calendar.getInstance();
  public boolean o;
  public SwitchCompat p;
  public ViewGroup q;
  public Account r;
  private boolean t;
  private boolean u;
  private Calendar v = Calendar.getInstance();
  private View w;
  private View x;
  private TextView y;
  private TextView z;
  
  private final void a(long paramLong)
  {
    if ((l) || (!k()))
    {
      a(z, paramLong);
      return;
    }
    z.setText(buj.aU);
  }
  
  private final void a(TextView paramTextView, long paramLong)
  {
    paramTextView.setText(DateUtils.formatDateTime(this, paramLong, 65556));
  }
  
  public static void a(Calendar paramCalendar)
  {
    paramCalendar.setTimeInMillis(System.currentTimeMillis());
    paramCalendar.set(paramCalendar.get(1), paramCalendar.get(2), paramCalendar.get(5), 0, 0, 0);
  }
  
  private final void a(Calendar paramCalendar, boolean paramBoolean)
  {
    u = paramBoolean;
    A.a(paramCalendar.get(1), paramCalendar.get(2), paramCalendar.get(5));
    A.c.show(getFragmentManager(), "DatePickerDialog");
  }
  
  private final void c(int paramInt)
  {
    if (o) {
      Toast.makeText(this, getString(paramInt), 0).show();
    }
    finish();
  }
  
  private final void t()
  {
    long l1 = m.getTimeInMillis();
    long l2 = n.getTimeInMillis();
    a(y, l1);
    a(l2);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    cvm.b(s, "onDateSet: %s %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (u)
    {
      m.set(paramInt1, paramInt2, paramInt3, 0, 0, 0);
      if (n.before(m)) {
        n.setTimeInMillis(m.getTimeInMillis());
      }
    }
    for (;;)
    {
      t();
      o = true;
      return;
      l = true;
      n.set(paramInt1, paramInt2, paramInt3, 0, 0, 0);
      if (n.before(m)) {
        m.setTimeInMillis(n.getTimeInMillis());
      }
    }
  }
  
  public final void a(CheckedTextView paramCheckedTextView)
  {
    if (!paramCheckedTextView.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramCheckedTextView.setChecked(bool);
      o = true;
      return;
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    o = true;
  }
  
  public boolean b(int paramInt)
  {
    if (paramInt == buc.i) {
      o();
    }
    for (;;)
    {
      return true;
      if (paramInt == buc.j)
      {
        m();
      }
      else if (paramInt == buc.eZ)
      {
        a(m, true);
      }
      else
      {
        if (paramInt != buc.bw) {
          break;
        }
        if (!l) {
          s();
        }
        FragmentManager localFragmentManager = getFragmentManager();
        B = ((csi)localFragmentManager.findFragmentByTag("EndDateDialog"));
        if (B == null)
        {
          String str = DateUtils.formatDateTime(this, n.getTimeInMillis(), 65556);
          boolean bool = k();
          csi localcsi = new csi();
          Bundle localBundle = new Bundle(2);
          localBundle.putString("endDate", str);
          localBundle.putBoolean("supportsNoEndDate", bool);
          localcsi.setArguments(localBundle);
          B = localcsi;
          B.show(localFragmentManager, "EndDateDialog");
        }
      }
    }
    return false;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void g()
  {
    p = ((SwitchCompat)findViewById(buc.fF));
    q = ((ViewGroup)findViewById(buc.fE));
    w = findViewById(buc.eZ);
    x = findViewById(buc.bw);
    y = ((TextView)findViewById(buc.eY));
    z = ((TextView)findViewById(buc.bv));
  }
  
  public void h()
  {
    p.setOnCheckedChangeListener(this);
    w.setOnClickListener(this);
    x.setOnClickListener(this);
  }
  
  public abstract void i();
  
  public abstract void j();
  
  public abstract boolean k();
  
  public abstract void l();
  
  public abstract void m();
  
  public void n()
  {
    c(buj.fx);
  }
  
  public void o()
  {
    c(buj.fw);
  }
  
  public void onBackPressed()
  {
    if (o)
    {
      if (C != null) {
        C.dismiss();
      }
      C = new csh();
      C.show(getFragmentManager(), "DiscardDialog");
      return;
    }
    super.onBackPressed();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (m.before(v)) {
        m.setTimeInMillis(v.getTimeInMillis());
      }
      if (n.before(m)) {
        s();
      }
      t();
    }
    cxe.a(q, paramBoolean);
    o = true;
  }
  
  public void onClick(View paramView)
  {
    b(paramView.getId());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(bue.an);
    j();
    boolean bool;
    zc localzc;
    if (!cxa.a(getResources()))
    {
      bool = true;
      t = bool;
      r = ((Account)getIntent().getParcelableExtra("account"));
      i();
      localzc = f().a();
      if (!t) {
        break label185;
      }
      View localView = ((LayoutInflater)localzc.l().getSystemService("layout_inflater")).inflate(bue.ao, null, false);
      localView.findViewById(buc.i).setOnClickListener(this);
      localView.findViewById(buc.j).setOnClickListener(this);
      localzc.e();
      localzc.a(false);
      localzc.b(false);
      localzc.d();
      localzc.a(localView, new zd(-1, -1));
    }
    for (;;)
    {
      g();
      v.setTimeInMillis(System.currentTimeMillis());
      if (paramBundle == null) {
        l();
      }
      h();
      t();
      return;
      bool = false;
      break;
      label185:
      localzc.a(false);
      localzc.b(buj.fv);
      localzc.b(r.c);
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    super.onCreateOptionsMenu(paramMenu);
    if (!t)
    {
      getMenuInflater().inflate(buf.n, paramMenu);
      return true;
    }
    return false;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return (b(paramMenuItem.getItemId())) || (super.onOptionsItemSelected(paramMenuItem));
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    cxe.a(q, p.isChecked());
    u = paramBundle.getBoolean("start-date-selected", false);
    l = paramBundle.getBoolean("end-date-set", false);
    long l1 = paramBundle.getLong("start-date");
    m.setTimeInMillis(l1);
    l1 = paramBundle.getLong("end-date");
    n.setTimeInMillis(l1);
    DialogFragment localDialogFragment = (DialogFragment)getFragmentManager().findFragmentByTag("DatePickerDialog");
    if (localDialogFragment != null) {
      A.a(localDialogFragment);
    }
    t();
    o = paramBundle.getBoolean("changes-made", false);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("start-date-selected", u);
    paramBundle.putBoolean("end-date-set", l);
    paramBundle.putBoolean("changes-made", o);
    paramBundle.putLong("start-date", m.getTimeInMillis());
    paramBundle.putLong("end-date", n.getTimeInMillis());
  }
  
  protected void onStart()
  {
    super.onStart();
    buo.a().a(this);
  }
  
  protected void onStop()
  {
    super.onStop();
    buo.a().b(this);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void p()
  {
    l = true;
    a(n.getTimeInMillis());
    o = true;
  }
  
  public final void q()
  {
    a(n, false);
  }
  
  public final void r()
  {
    l = false;
    a(0L);
    o = true;
  }
  
  public final void s()
  {
    n.set(m.get(1), m.get(2), m.get(5) + 7, 0, 0, 0);
  }
}

/* Location:
 * Qualified Name:     csg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */