import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.android.mail.providers.Attachment;
import com.android.mail.providers.Message;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class cfd
  extends blq
{
  private static final String G = cvl.a;
  private static final String H = String.valueOf(cfd.class.getName()).concat("-downloadaction");
  public final cfc E;
  public bvk F;
  private String I;
  private MenuItem J;
  private MenuItem K;
  private MenuItem L;
  private MenuItem M;
  private MenuItem N;
  private int O;
  private MenuItem P;
  private MenuItem Q;
  private Menu R;
  private boolean S;
  
  public cfd(cfc paramcfc)
  {
    super(paramcfc);
    E = paramcfc;
  }
  
  private final void a(Attachment paramAttachment)
  {
    if ((paramAttachment != null) && (paramAttachment.c()))
    {
      F.c = paramAttachment;
      F.b(1);
    }
  }
  
  private final boolean f(int paramInt)
  {
    int i;
    int j;
    if ((!cuh.a()) && ("com.google.android.gm.exchange".equals(I)))
    {
      i = 1;
      if ((i == 0) || (E.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", "com.google.android.gm.exchange") != 0)) {
        break label85;
      }
      j = 1;
      label43:
      if ((j == 0) && ((i != 0) || (!cwm.a(E, "android.permission.WRITE_EXTERNAL_STORAGE")))) {
        break label97;
      }
      if (i == 0) {
        break label90;
      }
    }
    label85:
    label90:
    for (Object localObject = "storage_attachment_eas";; localObject = "storage_attachment")
    {
      bus.a((String)localObject, "enabled");
      return true;
      i = 0;
      break;
      j = 0;
      break label43;
    }
    label97:
    if (i != 0)
    {
      localObject = "storage_attachment_eas";
      bus.a((String)localObject, "disabled");
      O = paramInt;
      localObject = E;
      if (i == 0) {
        break label183;
      }
    }
    for (;;)
    {
      try
      {
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setPackage("com.google.android.gm.exchange");
        ((cfc)localObject).startActivityForResult(localIntent, 1);
        return false;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        cvm.e(cfc.q, localActivityNotFoundException, "Can't open Exchange to request storage permission.", new Object[0]);
        throw localActivityNotFoundException;
      }
      localObject = "storage_attachment";
      break;
      label183:
      localActivityNotFoundException.requestPermissions(new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" }, 1);
    }
  }
  
  private final void q()
  {
    if (f(1)) {
      a(p());
    }
  }
  
  private final void r()
  {
    Cursor localCursor;
    if (f(3))
    {
      localCursor = l();
      if (localCursor != null) {}
    }
    else
    {
      return;
    }
    int i = -1;
    for (;;)
    {
      i += 1;
      if (!localCursor.moveToPosition(i)) {
        break;
      }
      a(new Attachment(localCursor));
    }
  }
  
  public final void a(bmr parambmr)
  {
    super.a(parambmr);
    parambmr = p();
    if (f == 5)
    {
      F.c = parambmr;
      F.b(g);
    }
  }
  
  public final void a(bmr parambmr, Cursor paramCursor)
  {
    int i = 1;
    super.a(parambmr, paramCursor);
    paramCursor = new Attachment(paramCursor);
    bnn localbnn = ak;
    TextView localTextView = ai;
    ImageView localImageView = aj;
    if (paramCursor.g())
    {
      int j = d;
      a.setMax(j);
      j = h;
      a.setProgress(j);
      localbnn.a(false);
      if (f != 1) {
        break label153;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        localTextView.setText(buj.dD);
        localTextView.setVisibility(0);
        localImageView.setVisibility(0);
        localImageView.setOnClickListener(new cfe(this, localTextView, localImageView));
        localbnn.a(8);
      }
      return;
      if (!ap) {
        break;
      }
      localbnn.a(true);
      break;
      label153:
      i = 0;
    }
  }
  
  public final void a(String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (!TextUtils.equals("android.permission.WRITE_EXTERNAL_STORAGE", paramArrayOfString[0]))
    {
      paramArrayOfString = String.valueOf(paramArrayOfString[0]);
      if (paramArrayOfString.length() != 0) {}
      for (paramArrayOfString = "unexpected permission id ".concat(paramArrayOfString);; paramArrayOfString = new String("unexpected permission id ")) {
        throw new IllegalStateException(paramArrayOfString);
      }
    }
    if (paramArrayOfInt[0] == 0)
    {
      cvm.b(cvm.a, "initiatePendingDownload %d", new Object[] { Integer.valueOf(O) });
      switch (O)
      {
      default: 
        cvm.d(cvm.a, "No pending download action set", new Object[0]);
      }
      for (;;)
      {
        bus.a("storage_photo_attachment", "granted");
        return;
        q();
        continue;
        o();
        continue;
        r();
      }
    }
    Toast.makeText(E, buj.eo, 0).show();
    bus.a("storage_photo_attachment", "denied");
  }
  
  public final boolean a(Menu paramMenu)
  {
    E.getMenuInflater().inflate(buf.l, paramMenu);
    R = paramMenu;
    J = R.findItem(buc.cF);
    K = R.findItem(buc.cG);
    L = R.findItem(buc.cH);
    M = R.findItem(buc.cI);
    N = R.findItem(buc.cE);
    P = R.findItem(buc.cD);
    Q = R.findItem(buc.ej);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getItemId();
    buo.a().a("menu_item", i, "photo_viewer");
    if (i == 16908332) {
      E.finish();
    }
    for (;;)
    {
      return true;
      if (i == buc.cF)
      {
        q();
      }
      else if (i == buc.cG)
      {
        r();
      }
      else
      {
        Object localObject1;
        if (i == buc.cH)
        {
          paramMenuItem = p();
          if (paramMenuItem != null)
          {
            F.c = paramMenuItem;
            paramMenuItem = F;
            if (c.i != null)
            {
              localObject1 = new Intent("android.intent.action.SEND");
              ((Intent)localObject1).setFlags(524289);
              ((Intent)localObject1).putExtra("android.intent.extra.STREAM", cxa.a(c.i));
              ((Intent)localObject1).setType(cxa.e(c.l()));
              try
              {
                f.startActivity((Intent)localObject1);
              }
              catch (ActivityNotFoundException paramMenuItem)
              {
                cvm.e(bvk.i, "Couldn't find Activity for intent", new Object[] { paramMenuItem });
              }
            }
          }
        }
        else
        {
          Object localObject2;
          if (i == buc.cI)
          {
            localObject1 = l();
            if (localObject1 != null)
            {
              paramMenuItem = new ArrayList();
              i = -1;
              for (;;)
              {
                i += 1;
                if (!((Cursor)localObject1).moveToPosition(i)) {
                  break;
                }
                paramMenuItem.add(cxa.a(Attachmenti));
              }
              localObject1 = F;
              localObject2 = new Intent("android.intent.action.SEND_MULTIPLE");
              ((Intent)localObject2).setFlags(524289);
              ((Intent)localObject2).setType("image/*");
              ((Intent)localObject2).putParcelableArrayListExtra("android.intent.extra.STREAM", paramMenuItem);
              try
              {
                f.startActivity((Intent)localObject2);
              }
              catch (ActivityNotFoundException paramMenuItem)
              {
                cvm.e(bvk.i, "Couldn't find Activity for intent", new Object[] { paramMenuItem });
              }
            }
          }
          else if (i == buc.cE)
          {
            localObject1 = p();
            localObject2 = E;
            paramMenuItem = new mo((Context)localObject2);
            try
            {
              a.a(1);
              localObject2 = cft.a((Context)localObject2, c);
              localObject1 = i;
              a.a((String)localObject2, (Uri)localObject1);
            }
            catch (FileNotFoundException paramMenuItem)
            {
              cvm.e(G, paramMenuItem, "Can't print photo", new Object[0]);
            }
          }
          else if (i == buc.cD)
          {
            o();
          }
          else
          {
            if (i != buc.ej) {
              break;
            }
            F.c = p();
            F.a();
          }
        }
      }
    }
    return super.a(paramMenuItem);
  }
  
  public void a_(Bundle paramBundle)
  {
    super.a_(paramBundle);
    F = new bvk(E, null);
    F.h = E.getFragmentManager();
    paramBundle = E.getIntent();
    I = paramBundle.getStringExtra(cfc.n);
    String str = paramBundle.getStringExtra(cfc.m);
    Message localMessage = (Message)paramBundle.getParcelableExtra(cfc.o);
    S = paramBundle.getBooleanExtra(cfc.p, false);
    O = paramBundle.getIntExtra(H, 0);
    F.a = str;
    F.b = localMessage;
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    paramBundle.putInt(H, O);
  }
  
  public final boolean d()
  {
    j();
    return true;
  }
  
  public final void j()
  {
    Attachment localAttachment = null;
    boolean bool2 = true;
    Object localObject1 = p();
    Object localObject2;
    label123:
    int i;
    if ((localObject1 != null) && (J != null) && (L != null))
    {
      localObject2 = J;
      if ((!((Attachment)localObject1).e()) && (((Attachment)localObject1).c()) && (!((Attachment)localObject1).f()))
      {
        bool1 = true;
        ((MenuItem)localObject2).setEnabled(bool1);
        bool1 = ((Attachment)localObject1).d();
        L.setEnabled(bool1);
        N.setEnabled(bool1);
        localObject2 = P;
        if ((!((Attachment)localObject1).c()) || (!((Attachment)localObject1).e())) {
          break label415;
        }
        bool1 = true;
        ((MenuItem)localObject2).setEnabled(bool1);
        localObject2 = Q;
        if (S) {
          break label425;
        }
        String str = I;
        localObject1 = ((Attachment)localObject1).l();
        if ((bvk.j == null) || (!bvk.j.a(str, (String)localObject1))) {
          break label420;
        }
        i = 1;
        label179:
        if (i == 0) {
          break label425;
        }
        bool1 = true;
        label185:
        ((MenuItem)localObject2).setVisible(bool1);
        if (m != null) {
          break label451;
        }
        localObject2 = null;
        label204:
        localObject1 = localAttachment;
        if (localObject2 != null)
        {
          localObject1 = localAttachment;
          if (!((Cursor)localObject2).isClosed())
          {
            if (((Cursor)localObject2).moveToFirst()) {
              break label463;
            }
            localObject1 = localAttachment;
          }
        }
        label241:
        if (localObject1 != null)
        {
          localObject2 = ((List)localObject1).iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localAttachment = (Attachment)((Iterator)localObject2).next();
          } while ((localAttachment.e()) || (!localAttachment.c()) || (localAttachment.f()));
        }
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      K.setEnabled(bool1);
      localObject1 = ((List)localObject1).iterator();
      do
      {
        bool1 = bool2;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
      } while (((Attachment)((Iterator)localObject1).next()).d());
      bool1 = false;
      M.setEnabled(bool1);
      if (!cxd.a())
      {
        L.setVisible(false);
        M.setVisible(false);
      }
      if (!cxd.c()) {
        N.setVisible(false);
      }
      label415:
      label420:
      label425:
      do
      {
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label123;
        i = 0;
        break label179;
        bool1 = false;
        break label185;
      } while (R == null);
      R.setGroupEnabled(buc.di, false);
      return;
      label451:
      localObject2 = m.b;
      break label204;
      label463:
      localObject1 = new ArrayList();
      do
      {
        ((List)localObject1).add(new Attachment((Cursor)localObject2));
      } while (((Cursor)localObject2).moveToNext());
      break label241;
    }
  }
  
  public final void k()
  {
    super.k();
    Attachment localAttachment = p();
    blg localblg = E.j();
    String str = ctr.a(E, d);
    if (localAttachment.f()) {
      localblg.b(E.getResources().getString(buj.ep, new Object[] { str }));
    }
    for (;;)
    {
      j();
      return;
      if ((localAttachment.e()) && (g == 1)) {
        localblg.b(E.getResources().getString(buj.eq));
      } else {
        localblg.b(str);
      }
    }
  }
  
  final void o()
  {
    if (f(2))
    {
      Attachment localAttachment = p();
      if ((localAttachment != null) && (localAttachment.c()))
      {
        F.c = localAttachment;
        bvk localbvk = F;
        ContentValues localContentValues = new ContentValues(1);
        localContentValues.put("state", Integer.valueOf(0));
        d.a(c.e, localContentValues);
        F.b(g);
      }
    }
  }
  
  public final Attachment p()
  {
    Cursor localCursor = l();
    if (localCursor == null) {
      return null;
    }
    return new Attachment(localCursor);
  }
}

/* Location:
 * Qualified Name:     cfd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */