package com.google.android.gm;

import aah;
import aaj;
import android.accounts.AccountManager;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import bdv;
import bhx;
import bim;
import bjm;
import bkn;
import buo;
import but;
import bvw;
import cbj;
import cbk;
import ccr;
import cdr;
import cdt;
import cdu;
import cdx;
import cdy;
import cdz;
import ced;
import cee;
import cef;
import ceg;
import cei;
import cgy;
import cha;
import chb;
import com.android.mail.compose.RichBodyView;
import com.android.mail.providers.Attachment;
import com.android.mail.providers.Message;
import com.android.mail.providers.Settings;
import com.google.android.apps.common.drive.aclfix.PotentialFix;
import com.google.android.gm.drive.aclfix.FixPermissionDialogState;
import com.google.android.gm.provider.GmailProvider;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.drive.DriveId;
import cuo;
import cvk;
import cvl;
import cvm;
import cwv;
import cxf;
import dbv;
import dby;
import deq;
import der;
import des;
import det;
import dev;
import dfy;
import dge;
import diq;
import diu;
import dix;
import diy;
import diz;
import djq;
import djs;
import dju;
import dmo;
import dmr;
import dpy;
import dri;
import dyo;
import dyp;
import dyq;
import dyt;
import dyv;
import dyz;
import dzb;
import ehb;
import ehc;
import ehe;
import eis;
import eiz;
import eja;
import ejh;
import fae;
import faj;
import fan;
import fbb;
import fri;
import frm;
import frp;
import ghz;
import glh;
import gnr;
import gnt;
import gpr;
import hgd;
import hli;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import nx;

public class ComposeActivityGmail
  extends cbk
  implements bjm, bvw, cbj, ccr, dyt
{
  public static final String aa = cvl.a;
  cdx ab;
  public dju ac;
  public String ad;
  public diz ae = new diz(true);
  private final det af = null;
  private final des ag = new des(this);
  private dmo ah;
  private dyz ai;
  private ehc aj;
  private MenuItem ak;
  private dyq al;
  private cdu am;
  private cee an;
  
  private final void b(Attachment paramAttachment)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("attachment", paramAttachment);
    djq.a(localBundle).show(getFragmentManager(), "LargeAttachmentDialog");
  }
  
  protected final long a(Attachment paramAttachment)
  {
    if (dju.a(ac))
    {
      b(paramAttachment);
      return 0L;
    }
    try
    {
      long l = super.a(paramAttachment);
      return l;
    }
    catch (cvk localcvk)
    {
      if (s.a(68719476736L))
      {
        b(paramAttachment);
        return 0L;
      }
      throw localcvk;
    }
  }
  
  public final long a(ArrayList<Attachment> paramArrayList)
  {
    long l2 = 0L;
    if (!s.a(68719476736L)) {
      l2 = super.a(paramArrayList);
    }
    Object localObject;
    long l1;
    do
    {
      return l2;
      localObject = new ArrayList();
      Iterator localIterator = paramArrayList.iterator();
      l1 = 0L;
      while (localIterator.hasNext())
      {
        Attachment localAttachment = (Attachment)localIterator.next();
        if (d < 0)
        {
          cvm.d(aa, "Error adding attachment - unknown attachment size", new Object[0]);
          buo.a().a("add_attachment", "unknown_size", null, 0L);
          ((ArrayList)localObject).add(localAttachment);
        }
        else if (d == 0)
        {
          cvm.d(aa, "Error adding attachment - empty attachment", new Object[0]);
          buo.a().a("add_attachment", "zero_size", null, 0L);
          ((ArrayList)localObject).add(localAttachment);
        }
        else
        {
          l1 = d + l1;
        }
      }
      if (!((ArrayList)localObject).isEmpty()) {
        d(dge.bH);
      }
      paramArrayList.removeAll((Collection)localObject);
    } while (paramArrayList.isEmpty());
    l2 = l1;
    if (s.a(67108864L)) {
      l2 = (l1 * 1.3D);
    }
    if (l2 > s.z.c())
    {
      localObject = new Bundle(1);
      ((Bundle)localObject).putParcelableArrayList("attachments", paramArrayList);
      djq.a((Bundle)localObject).show(getFragmentManager(), "LargeAttachmentDialog");
      return 0L;
    }
    return super.a(paramArrayList);
  }
  
  protected final String a(cha paramcha)
  {
    int k = 0;
    if ((paramcha != null) && (d))
    {
      String str = b;
      android.accounts.Account[] arrayOfAccount = AccountManager.get(this).getAccountsByType("com.google");
      int m = arrayOfAccount.length;
      int i = 0;
      for (;;)
      {
        int j = k;
        if (i < m)
        {
          if (name.equals(str)) {
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            break;
          }
          return "";
        }
        i += 1;
      }
    }
    return super.a(paramcha);
  }
  
  protected final String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = new ceg(paramString);
    if (an != null) {
      paramString.a(an);
    }
    return aam).a;
  }
  
  public final void a()
  {
    if (ak != null)
    {
      ak.setEnabled(true);
      f().f();
    }
  }
  
  protected final void a(ContentValues paramContentValues)
  {
    ad = paramContentValues.getAsString("refAdEventId");
    if (ad != null) {
      getLoaderManager().initLoader(100, null, ag);
    }
  }
  
  protected final void a(com.android.mail.providers.Account paramAccount)
  {
    super.a(paramAccount);
    if (dyp.a(paramAccount)) {
      ae.a(s.c, this);
    }
  }
  
  protected final void a(com.android.mail.providers.Account paramAccount, int paramInt)
  {
    Object localObject = dev.a(this);
    dmr localdmr = f;
    if (cxf.a((Context)localObject, paramAccount)) {}
    switch (paramInt)
    {
    default: 
      return;
    }
    for (localObject = hli.d;; localObject = hli.e)
    {
      localdmr.a(new gnr((gnt)localObject), 4, c);
      return;
    }
  }
  
  protected final void a(Message paramMessage)
  {
    super.a(paramMessage);
  }
  
  protected final void a(Message paramMessage, int paramInt)
  {
    if (dju.a(ac))
    {
      ContentResolver localContentResolver = getContentResolver();
      com.android.mail.providers.Account localAccount = s;
      long l1 = I;
      long l2 = d;
      ContentValues localContentValues = new ContentValues(1);
      localContentValues.put("messageKey", Long.valueOf(l2));
      localContentResolver.update(cgy.a(localAccount, "/saveTo/message", l1), localContentValues, null, null);
      super.a(paramMessage, paramInt);
      getLoaderManager().restartLoader(101, Bundle.EMPTY, af);
      return;
    }
    super.a(paramMessage, paramInt);
  }
  
  public final void a(PotentialFix paramPotentialFix, String paramString, FixPermissionDialogState paramFixPermissionDialogState, ArrayList<PotentialFix> paramArrayList, int paramInt, boolean paramBoolean)
  {
    if (paramPotentialFix == null)
    {
      a(false, paramBoolean);
      return;
    }
    Object localObject = g;
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      a(paramPotentialFix, paramString, paramBoolean);
      return;
    }
    localObject = new dix();
    Bundle localBundle = new Bundle(6);
    localBundle.putParcelable("fix", paramPotentialFix);
    localBundle.putString("role", paramString);
    localBundle.putParcelable("dialogState", paramFixPermissionDialogState);
    localBundle.putParcelableArrayList("potentialFixes", paramArrayList);
    localBundle.putInt("numFiles", paramInt);
    localBundle.putBoolean("showToast", paramBoolean);
    ((dix)localObject).setArguments(localBundle);
    buo.a().a("acl_fixer", "outside_domain_dialog", "shown", 0L);
    ((DialogFragment)localObject).show(getFragmentManager(), "outside-domain-warning-dialog");
  }
  
  public final void a(PotentialFix paramPotentialFix, String paramString, boolean paramBoolean)
  {
    a(false, paramBoolean);
    String str = s.c().name;
    paramBoolean = dpy.a(getContentResolver());
    Bundle localBundle = new Bundle(4);
    localBundle.putString("account", str);
    localBundle.putParcelable("fix", paramPotentialFix);
    localBundle.putString("role", paramString);
    localBundle.putBoolean("useConscrypt", paramBoolean);
    AsyncTask.execute(new dby(this, localBundle, new dbv()));
  }
  
  public final void a(FixPermissionDialogState paramFixPermissionDialogState, ArrayList<PotentialFix> paramArrayList, int paramInt, boolean paramBoolean)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty()))
    {
      a(false, paramBoolean);
      return;
    }
    com.android.mail.providers.Account localAccount = s;
    diu localdiu = new diu();
    Bundle localBundle = new Bundle(5);
    localBundle.putParcelable("account", localAccount);
    localBundle.putParcelable("dialogState", paramFixPermissionDialogState);
    localBundle.putParcelableArrayList("potentialFixes", paramArrayList);
    localBundle.putInt("numFiles", paramInt);
    localBundle.putBoolean("showToast", paramBoolean);
    localdiu.setArguments(localBundle);
    paramArrayList = buo.a();
    if (paramFixPermissionDialogState == null) {}
    for (paramFixPermissionDialogState = "shown";; paramFixPermissionDialogState = "re_shown")
    {
      paramArrayList.a("acl_fixer", "acl_fixer_dialog", paramFixPermissionDialogState, 0L);
      localdiu.show(getFragmentManager(), "acl-fixer-dialog");
      return;
    }
  }
  
  public final void a(Map<String, bkn> paramMap)
  {
    if (paramMap.size() > 0) {
      buo.a().a("message_send", "recipient", "matching", paramMap.size());
    }
  }
  
  public final void a(Set<String> paramSet)
  {
    if (paramSet.size() > 0) {
      buo.a().a("message_send", "recipient", "non_matching", paramSet.size());
    }
  }
  
  protected final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = true;
    if (!paramBoolean1)
    {
      dzb.a(this, s);
      ah.a(6, s);
    }
    boolean bool1 = bool2;
    if (dju.a(ac)) {
      if (ac.a()) {
        break label62;
      }
    }
    label62:
    for (bool1 = bool2;; bool1 = false)
    {
      super.b(paramBoolean1, paramBoolean2, bool1);
      return;
    }
  }
  
  protected final void a(boolean paramBoolean1, boolean paramBoolean2, ArrayList<String> paramArrayList)
  {
    Object localObject1 = A.getEditableText();
    Object localObject2 = (cdt[])((Spanned)localObject1).getSpans(0, ((Spanned)localObject1).length(), cdt.class);
    if ((localObject2 == null) || (localObject2.length == 0))
    {
      a(paramBoolean1, paramBoolean2);
      return;
    }
    if (dju.a(ac))
    {
      localObject3 = ac;
      localObject4 = new ArrayList();
      localObject5 = new ArrayList();
      int k = localObject2.length;
      i = 0;
      if (i < k)
      {
        Object localObject6 = localObject2[i];
        long l;
        if (a.a())
        {
          if (!(a instanceof cdr)) {
            break label173;
          }
          l = a).b;
          label141:
          if (l != -1L) {
            break label181;
          }
          dri.d(dju.a, "placeholder doesn't have a valid save ID", new Object[0]);
        }
        label173:
        label181:
        label248:
        label310:
        for (;;)
        {
          i += 1;
          break;
          l = -1L;
          break label141;
          if (b != null) {}
          for (localObject1 = (String)b.a(l, null);; localObject1 = null)
          {
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              break label248;
            }
            ((List)localObject4).add(Long.valueOf(l));
            ((List)localObject5).add(Long.valueOf(l));
            break;
          }
          ((cdt)localObject6).a((String)localObject1);
          if ((c != null) && (c.contains(Long.valueOf(l)))) {}
          for (j = 1;; j = 0)
          {
            if (j != 0) {
              break label310;
            }
            ((List)localObject5).add(Long.valueOf(l));
            break;
          }
        }
      }
      d = chb.a((Iterable)localObject4);
      e = chb.a((Iterable)localObject5);
    }
    if (paramBoolean1)
    {
      a(paramBoolean1, paramBoolean2);
      return;
    }
    localObject1 = hgd.b(localObject2.length);
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      ((ArrayList)localObject1).add(a.f);
      i += 1;
    }
    localObject2 = s.c().name;
    paramBoolean1 = dpy.a(getContentResolver());
    Object localObject3 = new diq();
    Object localObject4 = new Bundle(3);
    Object localObject5 = new Bundle(4);
    ((Bundle)localObject5).putString("account", (String)localObject2);
    ((Bundle)localObject5).putStringArrayList("recipients", paramArrayList);
    ((Bundle)localObject5).putStringArrayList("fileIds", (ArrayList)localObject1);
    ((Bundle)localObject5).putBoolean("useConscrypt", paramBoolean1);
    ((Bundle)localObject4).putBundle("requestArgs", (Bundle)localObject5);
    ((Bundle)localObject4).putInt("numFiles", ((ArrayList)localObject1).size());
    ((Bundle)localObject4).putBoolean("showToast", paramBoolean2);
    ((diq)localObject3).setArguments((Bundle)localObject4);
    ((DialogFragment)localObject3).show(getFragmentManager(), "check-permissions-dialog");
  }
  
  protected final void a(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length == 0) {
      return;
    }
    Object localObject = new frp().a().b();
    localObject = new eja(getApplicationContext()).a(frm.c, (eis)localObject).a();
    ConnectionResult localConnectionResult = ((eiz)localObject).c();
    if (!localConnectionResult.b())
    {
      cvm.c(aa, "ComposeActivityGmail: Increment connection failed: %s", new Object[] { localConnectionResult });
      return;
    }
    frm.j.a((eiz)localObject, paramArrayOfString);
    ((eiz)localObject).d();
    k().a(new ArrayList(Arrays.asList(paramArrayOfString)), this);
  }
  
  public final boolean a_(int paramInt1, int paramInt2)
  {
    if (A == null) {
      return false;
    }
    Editable localEditable = A.getText();
    cdt[] arrayOfcdt = (cdt[])localEditable.getSpans(paramInt1, paramInt2, cdt.class);
    if ((arrayOfcdt == null) || (arrayOfcdt.length == 0)) {
      return false;
    }
    int k = arrayOfcdt.length;
    int i = 0;
    if (i < k)
    {
      cdt localcdt = arrayOfcdt[i];
      int m = localEditable.getSpanStart(localcdt);
      int n = localEditable.getSpanEnd(localcdt);
      int j;
      if ((paramInt2 > m) && (paramInt2 < n))
      {
        j = 1;
        label104:
        if ((j != 0) || ((paramInt1 > m) && (paramInt1 < n)))
        {
          cvm.c(aa, "ComposeActivityGmail: Overriding intra-chip selection, selection=%s/%s chip=%s/%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(m), Integer.valueOf(n) });
          if (paramInt1 != paramInt2) {
            break label192;
          }
          A.setSelection(n);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        j = 0;
        break label104;
        label192:
        if (j != 0) {
          A.setSelection(paramInt1, n);
        } else {
          A.setSelection(m, paramInt2);
        }
      }
    }
    return false;
  }
  
  protected final Spanned b(Spanned paramSpanned)
  {
    if (paramSpanned == null) {
      return null;
    }
    if (am == null) {
      am = new cdu(ab);
    }
    paramSpanned = new cei(paramSpanned).a(am);
    if (an == null) {
      an = new cee();
    }
    paramSpanned.a(new ced()).a(new cef()).a(an);
    return a;
  }
  
  public final void b() {}
  
  public final void b(ArrayList<Attachment> paramArrayList)
  {
    if (J != null) {}
    for (String str = J.e;; str = null)
    {
      FragmentManager localFragmentManager = getFragmentManager();
      com.android.mail.providers.Account localAccount = s;
      long l = I;
      Object localObject2 = (djs)localFragmentManager.findFragmentByTag("SaveAttachmentsDialog");
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new djs();
        localObject2 = new Bundle(4);
        ((Bundle)localObject2).putParcelable("account", localAccount);
        ((Bundle)localObject2).putLong("localMessageId", l);
        ((Bundle)localObject2).putString("serverMessageId", str);
        ((Bundle)localObject2).putParcelableArrayList("attachments", paramArrayList);
        ((djs)localObject1).setArguments((Bundle)localObject2);
      }
      ((djs)localObject1).setCancelable(false);
      ((djs)localObject1).show(localFragmentManager, "SaveAttachmentsDialog");
      if (getLoaderManager().getLoader(101) == null)
      {
        if (ac == null) {
          ac = new dju();
        }
        getLoaderManager().initLoader(101, Bundle.EMPTY, af);
      }
      return;
    }
  }
  
  protected final boolean b(com.android.mail.providers.Account paramAccount)
  {
    return dyp.a(paramAccount);
  }
  
  public final void g(boolean paramBoolean)
  {
    a(false, paramBoolean);
  }
  
  public final void h(int paramInt)
  {
    if (paramInt == 260) {
      ai.g = false;
    }
    do
    {
      diz localdiz;
      do
      {
        return;
        if (paramInt != 257) {
          break;
        }
        localdiz = ae;
      } while (d == null);
      d.g = false;
      return;
    } while (paramInt != 1000);
    finish();
  }
  
  protected final gpr<Spanned> i()
  {
    return new cdz(this);
  }
  
  protected final String j()
  {
    return bdv.F;
  }
  
  public final bhx k()
  {
    return new ehe(this, s.c(), ai.f, aj);
  }
  
  public final bim l()
  {
    return new ehb(LayoutInflater.from(this), this);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((ai.a(paramInt1, paramInt2)) || (ae.a(paramInt1, paramInt2, paramIntent))) {}
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (i == 0)
      {
        j = i;
        if (paramInt1 == 261)
        {
          C = false;
          if (paramInt2 == -1)
          {
            DriveId localDriveId = (DriveId)paramIntent.getParcelableExtra("response_drive_id");
            eiz localeiz = ae.d.f;
            fae.h.a(localeiz, localDriveId).b(localeiz).a(new der(this, localDriveId));
          }
          j = 1;
        }
      }
      if (j == 0) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    if ((localIntent.getExtras() != null) && (localIntent.getExtras().containsKey("in-reference-to")))
    {
      localIntent.putExtra("in-reference-to-message-uri", GmailProvider.d(localIntent.getStringExtra("mail_account"), localIntent.getExtras().getLong("in-reference-to")));
      int j = localIntent.getIntExtra("action", -1);
      int i;
      if (j != 1)
      {
        i = j;
        if (j != -1) {}
      }
      else
      {
        i = 0;
      }
      localIntent.putExtra("action", i);
    }
    ai = new deq(this, this, paramBundle, "state-resolving-people-error", "Autocomplete");
    aj = new ehc(ai.f, getContentResolver());
    ae.a(this, paramBundle);
    ah = ae;
    super.onCreate(paramBundle);
    ab = new cdx(this);
    paramBundle = (RichBodyView)findViewById(dfy.V);
    paramBundle.addTextChangedListener(new diy());
    a = this;
    S = ghz.a(getContentResolver(), "gmail_autosave_draft", 30000L);
    glh.a.a("Application ready", "Application ready compose");
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    if (bool)
    {
      ak = paramMenu.findItem(dfy.v);
      if (ak != null) {
        ak.setVisible(true);
      }
    }
    return bool;
  }
  
  protected void onDestroy()
  {
    aj.d = true;
    super.onDestroy();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    IntentSender localIntentSender = null;
    int j = paramMenuItem.getItemId();
    int i;
    if (j == dfy.v) {
      if (!ae.c())
      {
        cvm.d(aa, "ComposeActivityGmail: ignoring pick; GMS Core connection pending/failed.", new Object[0]);
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0) {
        buo.a().a("menu_item", j, "compose");
      }
      if ((i == 0) && (!super.onOptionsItemSelected(paramMenuItem))) {
        break;
      }
      return true;
      diz localdiz = ae;
      if (!localdiz.c()) {
        cvm.d(diz.a, "ignoring pick; GMS Core connection pending/failed.", new Object[0]);
      }
      for (;;)
      {
        try
        {
          startIntentSenderForResult(localIntentSender, 261, null, 0, 0, 0);
          C = true;
          i = 1;
        }
        catch (IntentSender.SendIntentException localSendIntentException)
        {
          cvm.e(aa, localSendIntentException, "failed to send Drive Picker intent", new Object[0]);
          i = 1;
        }
        localIntentSender = fae.h.a().a(d.f);
      }
      continue;
      if (j == dfy.bg)
      {
        dev.a(this);
        new dyv().a(this, s, "android_compose", null);
        i = 1;
      }
      else
      {
        i = 0;
      }
    }
    return false;
  }
  
  public void onPause()
  {
    super.onPause();
    if (al != null) {
      al.cancel(true);
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    String str;
    if (ak != null)
    {
      boolean bool = ae.c();
      ak.setVisible(dyp.a(s));
      ak.setEnabled(bool);
      but localbut = buo.a();
      if (bool)
      {
        str = "enabled";
        localbut.a("insert_drive", "open_overflow", str, 0L);
      }
    }
    for (;;)
    {
      return super.onPrepareOptionsMenu(paramMenu);
      str = "disabled";
      break;
      buo.a().a("insert_drive", "open_overflow", "no_item", 0L);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (ghz.a(getContentResolver(), "gmail_enable_conscrypt_provider", true))
    {
      al = new dyq(this);
      al.execute(new Void[0]);
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    ai.b(paramBundle);
    ae.a(paramBundle);
    super.onSaveInstanceState(paramBundle);
  }
  
  protected void onStart()
  {
    super.onStart();
    ai.d();
    ae.d.d();
  }
  
  protected void onStop()
  {
    ae.d.e();
    ai.e();
    super.onStop();
  }
  
  protected final void p()
  {
    if (dju.a(ac))
    {
      ContentResolver localContentResolver = getContentResolver();
      Object localObject1 = s;
      long l = I;
      Object localObject2 = new ContentValues(2);
      ((ContentValues)localObject2).put("blocking", Integer.valueOf(0));
      ((ContentValues)localObject2).put("placeholder", Integer.valueOf(0));
      localContentResolver.update(cgy.a((com.android.mail.providers.Account)localObject1, "/saveTo/message", l), (ContentValues)localObject2, null, null);
      localObject1 = ac;
      localObject2 = s;
      cwv.b();
      if (((dju)localObject1).a())
      {
        String str1 = e;
        String str2 = d;
        if (!TextUtils.isEmpty(str1))
        {
          ContentValues localContentValues = new ContentValues(2);
          localContentValues.put("blocking", str1);
          localContentValues.put("placeholder", str2);
          localContentResolver.update(cgy.a((com.android.mail.providers.Account)localObject2, "/saveTo"), localContentValues, null, null);
        }
      }
      d = null;
      e = null;
    }
    super.p();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.ComposeActivityGmail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */