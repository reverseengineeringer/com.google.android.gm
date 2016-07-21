import android.app.ActivityManager;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Process;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.text.Editable;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.text.util.Rfc822Token;
import android.text.util.Rfc822Tokenizer;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.Window;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.JavascriptInterface;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.android.emailcommon.mail.Address;
import com.android.ex.chips.RecipientEditTextView;
import com.android.mail.compose.CcBccView;
import com.android.mail.compose.FromAddressSpinner;
import com.android.mail.compose.ProposedTimeView;
import com.android.mail.compose.QuotedTextView;
import com.android.mail.compose.RichBodyView;
import com.android.mail.providers.Account;
import com.android.mail.providers.Attachment;
import com.android.mail.providers.Event;
import com.android.mail.providers.Folder;
import com.android.mail.providers.Message;
import com.android.mail.providers.Settings;
import com.android.mail.ui.AttachmentTileGrid;
import com.android.mail.ui.ComposeAttachmentTileGrid;
import com.google.android.apps.work.common.richedittext.RichEditText;
import com.google.android.apps.work.common.richedittext.RichTextToolbar;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class cbk
  extends zh
  implements LoaderManager.LoaderCallbacks<Cursor>, TextWatcher, View.OnClickListener, View.OnFocusChangeListener, TextView.OnEditorActionListener, bih, bke, bkf, bkg, bki, cbi, cck, ccl, cco, ccp, ckl, ddb, zf
{
  private static final ConcurrentHashMap<Integer, Long> aa;
  private static final Random ab;
  private static final Handler ac;
  private static final String ad = Environment.getDataDirectory().toString();
  private static final nx<String> ae;
  static final String[] l = { "subject", "body", "to", "cc", "bcc", "quotedText" };
  static ccf m = null;
  public static final String n;
  public static final AtomicInteger o;
  public EditText A;
  public FromAddressSpinner B;
  public boolean C;
  boolean D;
  boolean E;
  boolean F;
  MenuItem G;
  public Message H;
  public long I = -1L;
  public Message J;
  cha K;
  final Object L = new Object();
  public Bundle M;
  ContentValues N = null;
  int O;
  cbv P = new cbv(this);
  boolean Q;
  cby R;
  public long S;
  String T;
  String U;
  boolean V = false;
  final hct<String, String> W = new hct();
  final Queue<String> X = new ConcurrentLinkedQueue();
  final gps Y = new cbp(this);
  boolean Z;
  private ccd aA;
  private ccd aB;
  private ccd aC;
  private boolean aD = false;
  private Uri aE;
  private boolean aF = false;
  private boolean aG = false;
  private boolean aH;
  private boolean aI;
  private String aJ;
  private Account[] aK;
  private boolean aL;
  private boolean aM = false;
  private Runnable aN;
  private final View.OnKeyListener aO = new cbl(this);
  private boolean aP;
  private ArrayList<ccs> aQ = new ArrayList();
  private Long aR;
  private final Rect af = new Rect();
  private ScrollView ag;
  private RecipientEditTextView ah;
  private RecipientEditTextView ai;
  private View aj;
  private CcBccView ak;
  private anv al;
  private TextView am;
  private View an;
  private cch ao;
  private boolean ap;
  private RichBodyView aq;
  private View ar;
  private TextView as;
  private View at;
  private ProposedTimeView au;
  private boolean av;
  private boolean aw;
  private boolean ax = false;
  private int ay = 1;
  private boolean az = false;
  Handler p = new Handler();
  RecipientEditTextView q;
  public ComposeAttachmentTileGrid r;
  public Account s;
  public cha t;
  Settings u;
  ImageView v;
  ImageView w;
  public int x = -1;
  QuotedTextView y;
  public boolean z;
  
  static
  {
    aa = new ConcurrentHashMap(10);
    ab = new Random(System.currentTimeMillis());
    n = cvl.a;
    o = new AtomicInteger(0);
    ae = new nx();
    HandlerThread localHandlerThread = new HandlerThread("Compose Task Thread");
    localHandlerThread.start();
    ac = new Handler(localHandlerThread.getLooper());
  }
  
  private Message B()
  {
    if (a(M)) {
      return (Message)M.getParcelable("extraMessage");
    }
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null)
    {
      if (localBundle.containsKey("extraMessage")) {
        return (Message)localBundle.getParcelable("extraMessage");
      }
      if (localBundle.containsKey("message-uri")) {
        return a((Uri)localBundle.getParcelable("message-uri"));
      }
    }
    return null;
  }
  
  private final void C()
  {
    A.requestFocus();
    D();
  }
  
  private final void D()
  {
    int i = A.getText().length();
    int j = a(aJ, A.getText().toString());
    if (j >= 0) {
      A.setSelection(j);
    }
    while (i < 0) {
      return;
    }
    A.setSelection(i);
  }
  
  private final cbh E()
  {
    if ((R != null) && (!R.b)) {
      return new cbh(R.a);
    }
    return new cbh(this, A.getText());
  }
  
  private final void F()
  {
    am.removeTextChangedListener(this);
    A.removeTextChangedListener(this);
    q.removeTextChangedListener(aA);
    ah.removeTextChangedListener(aB);
    ai.removeTextChangedListener(aC);
    B.c = null;
    r.j = null;
  }
  
  private final void G()
  {
    F();
    am.addTextChangedListener(this);
    A.addTextChangedListener(this);
    if (aA == null) {
      aA = new ccd(this, q, this);
    }
    q.addTextChangedListener(aA);
    if (aB == null) {
      aB = new ccd(this, ah, this);
    }
    ah.addTextChangedListener(aB);
    if (aC == null) {
      aC = new ccd(this, ai, this);
    }
    ai.addTextChangedListener(aC);
    B.c = this;
    r.j = this;
  }
  
  private final void H()
  {
    boolean bool1 = ak.a();
    boolean bool2 = ak.b();
    if (aj != null)
    {
      if ((!bool1) || (!bool2)) {
        aj.setVisibility(0);
      }
    }
    else {
      return;
    }
    aj.setVisibility(8);
  }
  
  private final void I()
  {
    c(q);
    c(ah);
    c(ai);
  }
  
  private final void J()
  {
    a(q.h());
    a(ah.h());
    a(ai.h());
  }
  
  private final void K()
  {
    int i = ay;
    ccn localccn = new ccn();
    Bundle localBundle = new Bundle(1);
    localBundle.putInt("priority", i);
    localccn.setArguments(localBundle);
    localccn.show(getFragmentManager(), "priority-fragment");
  }
  
  private final void L()
  {
    int j = 0;
    int i = 0;
    switch (ay)
    {
    case 1: 
    default: 
      k = 0;
      i = 8;
      j = 0;
      w.setVisibility(i);
      if (i == 0)
      {
        w.setImageResource(k);
        w.setContentDescription(getResources().getString(j));
      }
      M();
      return;
    case 0: 
      k = bub.aB;
      if (T()) {}
      for (;;)
      {
        j = buj.an;
        break;
        i = 8;
      }
    }
    int k = bub.aJ;
    if (T()) {}
    for (i = j;; i = 8)
    {
      j = buj.am;
      break;
    }
  }
  
  private final void M()
  {
    if ((w.getVisibility() == 0) || (v.getVisibility() == 0)) {}
    for (int i = bua.p;; i = bua.o)
    {
      rg.a(an, rg.k(an), an.getPaddingTop(), getResources().getDimensionPixelSize(i), an.getPaddingBottom());
      return;
    }
  }
  
  private final void N()
  {
    int i = 0;
    int j;
    if (W.d() > 0) {
      j = bub.aF;
    }
    for (;;)
    {
      String str;
      if (v.getVisibility() != i)
      {
        v.setVisibility(i);
        if (i != 0) {
          break label72;
        }
        str = "visible";
        v.setImageResource(j);
      }
      for (;;)
      {
        buo.a().a("gmail_tls", "compose_icon", str, 0L);
        M();
        return;
        label72:
        str = "invisible";
      }
      j = 0;
      i = 8;
    }
  }
  
  private final boolean O()
  {
    for (boolean bool = true;; bool = false) {
      synchronized (L)
      {
        if ((J == null) && ((x == 4) || (x == 5))) {
          return true;
        }
        if (((E) || (D) || (av) || (aw) || (ax)) && (!P())) {
          return bool;
        }
      }
    }
  }
  
  private final boolean P()
  {
    if ((am == null) || (A == null) || (q == null) || (ah == null) || (r == null)) {
      cvm.d(n, "ComposeActivity: null views in isBlank check", new Object[0]);
    }
    for (;;)
    {
      return true;
      if ((A.getText().length() == 0) || (a(aJ, A.getText().toString()) == 0)) {}
      for (int i = 1; (am.getText().length() != 0) || (i == 0) || (q.length() != 0) || (ah.length() != 0) || (ai.length() != 0) || (r.b.size() != 0); i = 0) {
        return false;
      }
    }
  }
  
  private final void Q()
  {
    E = false;
    D = false;
    av = false;
    aw = false;
    ax = false;
  }
  
  private final void R()
  {
    String str;
    if (u != null)
    {
      str = u.b;
      if (a(aJ, A.getText().toString()) < 0) {
        break label109;
      }
    }
    label109:
    for (int i = 1;; i = 0)
    {
      if ((!TextUtils.equals(str, aJ)) || (i == 0))
      {
        aJ = str;
        if (!TextUtils.isEmpty(aJ))
        {
          A.removeTextChangedListener(this);
          A.append(k(aJ));
          A.addTextChangedListener(this);
        }
        D();
      }
      return;
      str = null;
      break;
    }
  }
  
  private final void S()
  {
    boolean bool = true;
    t = B.a;
    A.removeTextChangedListener(this);
    String str1 = aJ;
    String str2 = A.getText().toString();
    if (!TextUtils.isEmpty(str1))
    {
      int i = a(str1, str2);
      if (i >= 0) {
        a(str2.substring(0, i), false);
      }
    }
    a(t.a);
    A.addTextChangedListener(this);
    if (!P()) {
      h(true);
    }
    av = true;
    I();
    if (aH)
    {
      Toast.makeText(this, buj.cc, 0);
      if (aH)
      {
        aH = false;
        if (aw) {
          break label168;
        }
      }
    }
    for (;;)
    {
      aw = bool;
      N();
      L();
      invalidateOptionsMenu();
      U();
      return;
      label168:
      bool = false;
    }
  }
  
  private final boolean T()
  {
    return s.a(268435456L);
  }
  
  private final void U()
  {
    if ((!Q) && (S > 0L))
    {
      Q = true;
      p.postDelayed(P, S);
    }
  }
  
  private final crl V()
  {
    return (crl)getFragmentManager().findFragmentByTag("wait-fragment");
  }
  
  private final int a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    int i;
    int j;
    do
    {
      return -1;
      i = paramString2.length();
      j = paramString1.length();
      String str = k(paramString1);
      int k = str.length();
      if ((i >= k) && (paramString2.substring(i - k).equals(str))) {
        return i - k;
      }
    } while ((i < j) || (!paramString2.substring(i - j).equals(paramString1)));
    return i - j;
  }
  
  private static int a(String[] paramArrayOfString, int paramInt, Rfc822Token[] paramArrayOfRfc822Token)
  {
    int j = paramInt;
    if (paramArrayOfRfc822Token != null)
    {
      int k = paramArrayOfRfc822Token.length;
      int i = 0;
      for (;;)
      {
        j = paramInt;
        if (i >= k) {
          break;
        }
        paramArrayOfString[paramInt] = paramArrayOfRfc822Token[i].getAddress();
        i += 1;
        paramInt += 1;
      }
    }
    return j;
  }
  
  private static Intent a(Context paramContext, Account paramAccount, Uri paramUri, int paramInt)
  {
    Intent localIntent = new Intent("com.android.mail.intent.action.LAUNCH_COMPOSE");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("fromemail", true);
    localIntent.putExtra("action", paramInt);
    localIntent.putExtra("mail_account", paramAccount);
    localIntent.putExtra("in-reference-to-message-uri", paramUri);
    return localIntent;
  }
  
  public static Intent a(Context paramContext, Account paramAccount, Uri paramUri, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return a(paramContext, paramAccount, paramUri, i);
    }
  }
  
  private static Intent a(Context paramContext, Account paramAccount, Message paramMessage, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, ContentValues paramContentValues)
  {
    paramString3 = new Intent("com.android.mail.intent.action.LAUNCH_COMPOSE");
    paramString3.setPackage(paramContext.getPackageName());
    paramString3.putExtra("fromemail", true);
    paramString3.putExtra("action", paramInt);
    paramString3.putExtra("mail_account", paramAccount);
    boolean bool1 = Message.b(paramMessage);
    boolean bool2 = Message.g(paramString2);
    int i;
    if ((bool1) || (bool2))
    {
      Toast.makeText(paramContext, buj.dg, 1).show();
      int j = Message.c(paramMessage);
      if (paramString2 != null)
      {
        i = paramString2.length();
        if ((!bool1) || (!bool2)) {
          break label150;
        }
        paramContext = "message_and_body";
        label118:
        buo.a().a("message_too_large", String.valueOf(paramInt), paramContext, j + i);
        paramContext = null;
      }
    }
    label150:
    do
    {
      return paramContext;
      i = 0;
      break;
      if (bool1)
      {
        paramContext = "message";
        break label118;
      }
      paramContext = "body";
      break label118;
      if (paramInt == 3) {
        paramString3.putExtra("extraMessage", paramMessage);
      }
      for (;;)
      {
        if (paramString1 != null) {
          paramString3.putExtra("to", paramString1);
        }
        if (paramString2 != null) {
          paramString3.putExtra("body", paramString2);
        }
        if (paramString4 != null) {
          paramString3.putExtra("subject", paramString4);
        }
        if (paramContentValues != null)
        {
          cvm.b(n, "ComposeActivity: Launching with extraValues: %s", new Object[] { paramContentValues });
          paramString3.putExtra("extra-values", paramContentValues);
        }
        if (paramInt != -1) {
          break;
        }
        paramString3.setFlags(134742016);
        return paramString3;
        paramString3.putExtra("in-reference-to-message", paramMessage);
      }
      paramContext = paramString3;
    } while (paramMessage == null);
    paramString3.setData(cxa.a(f));
    return paramString3;
  }
  
  public static Intent a(Context paramContext, Account paramAccount, Message paramMessage, ContentValues paramContentValues)
  {
    paramContext = a(paramContext, paramAccount, f, 4);
    paramContext.putExtra("in-reference-to-message-uri", f);
    paramContext.putExtra("extra-values", paramContentValues);
    return paramContext;
  }
  
  private static Bundle a(ContentResolver paramContentResolver, Account paramAccount, String paramString, ccg paramccg)
  {
    Bundle localBundle = cwl.a(b);
    paramccg = d;
    if (paramccg != null) {
      localBundle.putParcelable("opened_fds", paramccg);
    }
    return paramContentResolver.call(g, paramString, g.toString(), localBundle);
  }
  
  static Bundle a(Context paramContext, List<Attachment> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    Bundle localBundle = new Bundle(paramList.size());
    ContentResolver localContentResolver = paramContext.getContentResolver();
    paramList = paramList.iterator();
    for (;;)
    {
      if (paramList.hasNext())
      {
        Attachment localAttachment = (Attachment)paramList.next();
        if ((localAttachment == null) || (cxa.b(i))) {
          continue;
        }
        try
        {
          paramContext = localContentResolver.openFileDescriptor(i, "r");
          if (paramContext != null) {
            localBundle.putParcelable(i.toString(), paramContext);
          }
        }
        catch (FileNotFoundException paramContext)
        {
          for (;;)
          {
            cvm.e(n, paramContext, "Exception attempting to open attachment", new Object[0]);
            paramContext = null;
          }
        }
        catch (SecurityException paramContext)
        {
          for (;;)
          {
            cvm.e(n, paramContext, "Exception attempting to open attachment", new Object[0]);
            paramContext = null;
          }
        }
      }
    }
    return localBundle;
  }
  
  private final cha a(Account paramAccount, Message paramMessage)
  {
    if (u.k) {
      paramAccount = c(paramAccount);
    }
    Object localObject;
    do
    {
      return paramAccount;
      localObject = new ArrayList();
      ((List)localObject).addAll(Arrays.asList(Message.a(paramMessage.h())));
      ((List)localObject).addAll(Arrays.asList(Message.a(paramMessage.i())));
      localObject = a(paramAccount, (List)localObject);
      paramAccount = (Account)localObject;
    } while (localObject != null);
    if (I != null)
    {
      paramAccount = B.b.iterator();
      while (paramAccount.hasNext())
      {
        localObject = (cha)paramAccount.next();
        if (I.equals(a.g)) {
          return (cha)localObject;
        }
      }
    }
    return null;
  }
  
  private static cha a(Account paramAccount, List<String> paramList)
  {
    int k = 0;
    int j = 0;
    cha localcha = null;
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    Object localObject;
    int i;
    while (paramList.hasNext())
    {
      localObject = Rfc822Tokenizer.tokenize((String)paramList.next());
      int i1 = localObject.length;
      i = 0;
      while (i < i1)
      {
        localHashSet.add(localObject[i].getAddress());
        i += 1;
      }
    }
    paramList = paramAccount.g();
    if (paramList != null)
    {
      localObject = paramList.iterator();
      paramList = localcha;
      i = j;
      while (((Iterator)localObject).hasNext())
      {
        localcha = (cha)((Iterator)localObject).next();
        if (!localHashSet.contains(b)) {
          break label159;
        }
        paramList = localcha;
        i += 1;
      }
    }
    for (;;)
    {
      if (i > 1) {
        paramList = c(paramAccount);
      }
      return paramList;
      label159:
      break;
      paramList = null;
      i = k;
    }
  }
  
  private final cha a(Message paramMessage, String paramString)
  {
    paramMessage = Address.d(j);
    if (paramMessage.length > 0) {}
    for (paramMessage = 0a;; paramMessage = "")
    {
      cvm.b(n, "ComposeActivity: Finding 'reply from' address in account %s", new Object[] { paramMessage });
      Iterator localIterator = B.b.iterator();
      cha localcha;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localcha = (cha)localIterator.next();
      } while ((!TextUtils.equals(b, paramMessage)) || (!a.c.equals(paramString)));
      return localcha;
    }
    return null;
  }
  
  private final Message a(Uri paramUri)
  {
    if (paramUri == null) {
      return null;
    }
    Cursor localCursor = getContentResolver().query(paramUri, chh.n, null, null, null);
    if (localCursor != null) {
      try
      {
        if (localCursor.moveToFirst())
        {
          paramUri = new Message(localCursor);
          return paramUri;
        }
        throw new IllegalStateException(String.format("Could not query the message. Uri: %s", new Object[] { paramUri.toString() }));
      }
      finally
      {
        localCursor.close();
      }
    }
    throw new NullPointerException(String.format("Null Cursor while trying to query message. Uri: %s", new Object[] { paramUri.toString() }));
  }
  
  public static String a(Resources paramResources, String paramString, int paramInt)
  {
    return b(paramResources, paramString, 2);
  }
  
  private final void a(int paramInt, Intent paramIntent, Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject;
    if ((!a(paramBundle)) && (!paramBoolean))
    {
      localObject = paramIntent.getExtras();
      if (localObject != null) {
        break label1032;
      }
      localObject = Bundle.EMPTY;
    }
    label199:
    label249:
    label262:
    label340:
    label365:
    label431:
    label461:
    label515:
    label544:
    label583:
    label779:
    label789:
    label926:
    label934:
    label967:
    label978:
    label984:
    label990:
    label996:
    label1002:
    label1008:
    label1032:
    for (;;)
    {
      String str = paramIntent.getAction();
      ArrayList localArrayList;
      int i;
      boolean bool;
      if (!D)
      {
        localArrayList = new ArrayList();
        if (((Bundle)localObject).containsKey("attachments"))
        {
          String[] arrayOfString = (String[])((Bundle)localObject).getSerializable("attachments");
          int j = arrayOfString.length;
          i = 0;
          while (i < j)
          {
            localArrayList.add(Uri.parse(arrayOfString[i]));
            i += 1;
          }
        }
        if (((Bundle)localObject).containsKey("android.intent.extra.STREAM"))
        {
          if ("android.intent.action.SEND_MULTIPLE".equals(str)) {
            localArrayList.addAll(((Bundle)localObject).getParcelableArrayList("android.intent.extra.STREAM"));
          }
        }
        else
        {
          localObject = new cbt(this, localArrayList);
          if (!d(localArrayList)) {
            break label779;
          }
          aN = ((Runnable)localObject);
          aG = true;
          cwm.a(this, 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE" });
        }
      }
      else
      {
        cvm.b(n, "ComposeActivity: initializing action bar", new Object[0]);
        localObject = f().a();
        if (localObject != null)
        {
          if (x != -1) {
            break label789;
          }
          ((zc)localObject).d(0);
          ((zc)localObject).b(buj.aq);
          ((zc)localObject).a(4, 4);
        }
        if (paramBundle == null) {
          break label926;
        }
        paramIntent = paramBundle;
        i = paramInt;
        if (paramInt == 3)
        {
          i = paramInt;
          if (J.u == 1) {
            i = -1;
          }
        }
        B.a(i, s, aK, H);
        if (paramIntent != null)
        {
          if (!paramIntent.containsKey("replyFromAccount")) {
            break label934;
          }
          t = cha.a(s, paramIntent.getString("replyFromAccount"));
        }
        if ((J == null) || (J.I == null)) {
          break label967;
        }
        paramIntent = J.I;
        localObject = new Bundle(1);
        ((Bundle)localObject).putParcelable("accountUri", paramIntent);
        getLoaderManager().initLoader(6, (Bundle)localObject, this);
        G();
        if ((TextUtils.isEmpty(ah.getText())) && ((paramBundle == null) || (!paramBundle.getBoolean("showCc")))) {
          break label978;
        }
        paramBoolean = true;
        if ((TextUtils.isEmpty(ai.getText())) && ((paramBundle == null) || (!paramBundle.getBoolean("showBcc")))) {
          break label984;
        }
        bool = true;
        ak.a(false, paramBoolean, bool);
        H();
        paramBoolean = aF;
        y.b(paramBoolean);
        paramIntent = y;
        if (r.b.size() <= 0) {
          break label990;
        }
        paramBoolean = true;
        paramIntent.c(paramBoolean);
        if ((M == null) || (!M.getBoolean("respondedInline"))) {
          break label996;
        }
        paramBoolean = true;
        aL = paramBoolean;
        if (aL) {
          y.setVisibility(8);
        }
        if ((paramBundle == null) || (!paramBundle.getBoolean("extraTextChanged"))) {
          break label1002;
        }
        paramBoolean = true;
        E = paramBoolean;
        paramInt = x;
        paramIntent = H;
        if ((paramInt == 4) && (paramIntent != null) && (T != null))
        {
          paramBundle = au;
          localObject = T.a;
          a.setText((CharSequence)localObject);
          paramBundle = au;
          long l1 = T.b;
          long l2 = T.c;
          paramIntent = car.a(paramBundle.getContext(), l1, l2, false, true);
          b.setText(paramBundle.getResources().getString(buj.ao, new Object[] { paramIntent }));
          if (J != null) {
            break label1008;
          }
          paramIntent = (ContentValues)getIntent().getParcelableExtra("extra-values");
          au.a(paramIntent.getAsLong("start_millis").longValue(), paramIntent.getAsLong("end_millis").longValue());
        }
      }
      for (;;)
      {
        au.setVisibility(0);
        return;
        localArrayList.add((Uri)((Bundle)localObject).getParcelable("android.intent.extra.STREAM"));
        break;
        ((Runnable)localObject).run();
        break label199;
        if ((x == 4) || (x == 5))
        {
          ((zc)localObject).d(0);
          ((zc)localObject).b(buj.eg);
          break label249;
        }
        ((zc)localObject).a(null);
        if (ao == null) {
          ao = new cch(((zc)localObject).l());
        }
        ((zc)localObject).d(1);
        ((zc)localObject).a(ao, this);
        switch (x)
        {
        default: 
          break;
        case 0: 
          ((zc)localObject).a(0);
          break;
        case 1: 
          ((zc)localObject).a(1);
          break;
        case 2: 
          ((zc)localObject).a(2);
          break;
          paramIntent = paramIntent.getExtras();
          break label262;
          if (!paramIntent.containsKey("fromAccountString")) {
            break label340;
          }
          paramIntent = paramIntent.getString("fromAccountString");
          t = B.a(paramIntent);
          break label340;
          paramIntent = s.g;
          break label365;
          paramBoolean = false;
          break label431;
          bool = false;
          break label461;
          paramBoolean = false;
          break label515;
          paramBoolean = false;
          break label544;
          paramBoolean = false;
          break label583;
          au.a(J.aj, J.ak);
        }
      }
    }
  }
  
  private final void a(int paramInt, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    cce localcce = new cce();
    Bundle localBundle = new Bundle(3);
    localBundle.putInt("messageId", paramInt);
    localBundle.putBoolean("showToast", paramBoolean);
    localBundle.putStringArrayList("recipients", paramArrayList);
    localcce.setArguments(localBundle);
    localcce.show(getFragmentManager(), "send confirm");
  }
  
  public static void a(Context paramContext, Account paramAccount)
  {
    cvm.c(n, "[ComposeActivity init] compose", new Object[0]);
    a(paramContext, paramAccount, null, -1, null, null, null, null);
  }
  
  public static void a(Context paramContext, Account paramAccount, Uri paramUri)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", paramUri);
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("fromemail", true);
    localIntent.putExtra("mail_account", paramAccount);
    if (paramUri != null) {
      localIntent.setData(cxa.a(paramUri));
    }
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, Account paramAccount, Message paramMessage)
  {
    int j = -1;
    int i;
    if (paramMessage != null)
    {
      String str = n;
      if (p == null)
      {
        i = -1;
        if (o != null) {
          break label91;
        }
        label28:
        cvm.c(str, "ComposeActivity: editDraft: text %d html %d refMessage %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), t });
      }
    }
    for (;;)
    {
      paramAccount = b(paramContext, paramAccount, paramMessage);
      if (paramAccount != null) {
        paramContext.startActivity(paramAccount);
      }
      return;
      i = TextUtils.getTrimmedLength(p);
      break;
      label91:
      j = TextUtils.getTrimmedLength(o);
      break label28;
      cvm.c(n, "ComposeActivity: editDraft with null message", new Object[0]);
    }
  }
  
  public static void a(Context paramContext, Account paramAccount, Message paramMessage, int paramInt, String paramString1, String paramString2, String paramString3, ContentValues paramContentValues)
  {
    paramAccount = a(paramContext, paramAccount, paramMessage, paramInt, paramString1, paramString2, null, paramString3, paramContentValues);
    if (paramAccount != null) {
      paramContext.startActivity(paramAccount);
    }
  }
  
  public static void a(Context paramContext, Account paramAccount, Message paramMessage, String paramString)
  {
    cvm.c(n, "[ComposeActivity init] reportRenderingFeedback %s", new Object[] { paramMessage });
    a(paramContext, paramAccount, paramMessage, 2, "android-gmail-readability@google.com", paramString, null, null);
  }
  
  private final void a(View paramView)
  {
    if (((AccessibilityManager)getSystemService("accessibility")).isEnabled()) {
      p.post(new cct(paramView));
    }
  }
  
  private final void a(bhx parambhx)
  {
    boolean bool = true;
    String[] arrayOfString = big.a;
    int j = arrayOfString.length;
    int i = 0;
    if (i < j) {
      if (!cwm.a(this, arrayOfString[i]))
      {
        i = 0;
        label32:
        if ((aD) || (i == 0)) {
          break label62;
        }
      }
    }
    for (;;)
    {
      n = bool;
      return;
      i += 1;
      break;
      i = 1;
      break label32;
      label62:
      bool = false;
    }
  }
  
  private static void a(ccg paramccg)
  {
    paramccg = d;
    if (paramccg != null)
    {
      Iterator localIterator = paramccg.keySet().iterator();
      while (localIterator.hasNext())
      {
        ParcelFileDescriptor localParcelFileDescriptor = (ParcelFileDescriptor)paramccg.getParcelable((String)localIterator.next());
        if (localParcelFileDescriptor != null) {
          try
          {
            localParcelFileDescriptor.close();
          }
          catch (IOException localIOException) {}
        }
      }
    }
  }
  
  private static void a(String paramString, RecipientEditTextView paramRecipientEditTextView)
  {
    if ((paramString == null) || (paramRecipientEditTextView == null)) {}
    for (;;)
    {
      return;
      paramString = Rfc822Tokenizer.tokenize(paramString);
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String str1 = String.valueOf(paramString[i]);
        String str2 = String.valueOf(", ");
        paramRecipientEditTextView.append(String.valueOf(str1).length() + 0 + String.valueOf(str2).length() + str1 + str2);
        i += 1;
      }
    }
  }
  
  private final void a(Collection<String> paramCollection)
  {
    a(paramCollection, q);
  }
  
  private static void a(Collection<String> paramCollection, RecipientEditTextView paramRecipientEditTextView)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      a((String)paramCollection.next(), paramRecipientEditTextView);
    }
  }
  
  private final void a(Collection<String> paramCollection1, Collection<String> paramCollection2)
  {
    Object localObject2 = cci.a(paramCollection1);
    label33:
    int j;
    int i;
    label62:
    Object localObject3;
    if (paramCollection2 != null)
    {
      paramCollection1 = cci.a(paramCollection2);
      paramCollection2 = ah;
      if (paramCollection1 != null) {
        break label131;
      }
      localObject1 = ((List)localObject2).iterator();
      if (!((Iterator)localObject1).hasNext()) {
        return;
      }
      localObject2 = (Rfc822Token[])((Iterator)localObject1).next();
      j = localObject2.length;
      i = 0;
      if (i < j)
      {
        paramCollection1 = String.valueOf(localObject2[i].toString());
        localObject3 = String.valueOf(", ");
        if (((String)localObject3).length() == 0) {
          break label119;
        }
      }
    }
    label119:
    for (paramCollection1 = paramCollection1.concat((String)localObject3);; paramCollection1 = new String(paramCollection1))
    {
      paramCollection2.append(paramCollection1);
      i += 1;
      break label62;
      break label33;
      paramCollection1 = null;
      break;
    }
    label131:
    Object localObject1 = cci.a(paramCollection1);
    localObject2 = ((List)localObject2).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Rfc822Token[])((Iterator)localObject2).next();
      j = localObject3.length;
      i = 0;
      label175:
      String str;
      if (i < j)
      {
        paramCollection1 = localObject3[i];
        str = paramCollection1.toString();
        if (!((Set)localObject1).contains(paramCollection1.getAddress()))
        {
          paramCollection1 = String.valueOf(str);
          str = String.valueOf(", ");
          if (str.length() == 0) {
            break label247;
          }
        }
      }
      label247:
      for (paramCollection1 = paramCollection1.concat(str);; paramCollection1 = new String(paramCollection1))
      {
        paramCollection2.append(paramCollection1);
        i += 1;
        break label175;
        break;
      }
    }
  }
  
  private final void a(String[] paramArrayOfString, List<String> paramList)
  {
    if (al == null) {}
    for (;;)
    {
      return;
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramArrayOfString[i];
        if (!al.isValid(str)) {
          paramList.add(str);
        }
        i += 1;
      }
    }
  }
  
  private final boolean a(Intent paramIntent)
  {
    Object localObject1 = paramIntent.getData();
    int i;
    if (localObject1 != null)
    {
      if (!"mailto".equals(((Uri)localObject1).getScheme())) {
        break label654;
      }
      localObject1 = ((Uri)localObject1).toString();
      i = ((String)localObject1).indexOf("?");
      if (i != -1) {
        break label487;
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = e(((String)localObject1).substring(7));
        localObject3 = localObject1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            a(Arrays.asList(TextUtils.split((String)localObject2, ",")));
            localObject3 = localObject1;
          }
          localObject1 = String.valueOf(localObject3);
          if (((String)localObject1).length() == 0) {
            break label639;
          }
          localObject1 = "foo://".concat((String)localObject1);
          localObject1 = Uri.parse((String)localObject1);
          a(c(((Uri)localObject1).getQueryParameters("cc")), null);
          a(c(((Uri)localObject1).getQueryParameters("to")));
          b(c(((Uri)localObject1).getQueryParameters("bcc")));
          Object localObject2 = ((Uri)localObject1).getQueryParameters("subject");
          if (((List)localObject2).size() > 0) {
            am.setText(f((String)((List)localObject2).get(0)));
          }
          localObject1 = ((Uri)localObject1).getQueryParameters("body");
          if (((List)localObject1).size() > 0) {
            a(f((String)((List)localObject1).get(0)), true);
          }
          localObject1 = paramIntent.getStringArrayExtra("android.intent.extra.EMAIL");
          if (localObject1 != null) {
            a(Arrays.asList((Object[])localObject1));
          }
          localObject1 = paramIntent.getStringArrayExtra("android.intent.extra.CC");
          if (localObject1 != null) {
            a(Arrays.asList((Object[])localObject1), null);
          }
          localObject1 = paramIntent.getStringArrayExtra("android.intent.extra.BCC");
          if (localObject1 != null) {
            b(Arrays.asList((Object[])localObject1));
          }
          localObject1 = paramIntent.getStringExtra("android.intent.extra.SUBJECT");
          if (localObject1 != null) {
            am.setText((CharSequence)localObject1);
          }
          localObject1 = l;
          int k = localObject1.length;
          int j = 0;
          if (j >= k) {
            break;
          }
          localObject2 = localObject1[j];
          if (paramIntent.hasExtra((String)localObject2)) {
            localObject3 = paramIntent.getStringExtra((String)localObject2);
          }
          switch (((String)localObject2).hashCode())
          {
          default: 
            i = -1;
            switch (i)
            {
            default: 
              j += 1;
              continue;
              label487:
              localObject2 = e(((String)localObject1).substring(7, i));
              localObject3 = String.valueOf(((String)localObject1).substring(i + 1).replace("%", "%25"));
              localObject3 = String.valueOf(localObject2).length() + 1 + String.valueOf(localObject3).length() + (String)localObject2 + "?" + (String)localObject3;
              localObject1 = localObject3;
            }
            break;
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException2)
        {
          Object localObject3;
          for (;;) {}
        }
        localUnsupportedEncodingException1 = localUnsupportedEncodingException1;
      }
      if (cvm.a(n, 2))
      {
        cvm.e(n, localUnsupportedEncodingException1, "Error decoding mailto: %s", new Object[] { localObject1 });
        localObject3 = localObject1;
      }
      else
      {
        cvm.e(n, localUnsupportedEncodingException1, "Error decoding mailto", new Object[0]);
        localObject3 = localObject1;
        continue;
        label639:
        localObject1 = new String("foo://");
        continue;
        label654:
        if (!s.v.equals(localObject1))
        {
          localObject1 = ((Uri)localObject1).getSchemeSpecificPart();
          if (localObject1 != null)
          {
            q.setText("");
            a(Arrays.asList(TextUtils.split((String)localObject1, ",")));
            continue;
            if (localUnsupportedEncodingException1.equals("to"))
            {
              i = 0;
              continue;
              if (localUnsupportedEncodingException1.equals("cc"))
              {
                i = 1;
                continue;
                if (localUnsupportedEncodingException1.equals("bcc"))
                {
                  i = 2;
                  continue;
                  if (localUnsupportedEncodingException1.equals("subject"))
                  {
                    i = 3;
                    continue;
                    if (localUnsupportedEncodingException1.equals("body"))
                    {
                      i = 4;
                      continue;
                      if (localUnsupportedEncodingException1.equals("quotedText"))
                      {
                        i = 5;
                        continue;
                        a(Arrays.asList(TextUtils.split((String)localObject3, ",")));
                        continue;
                        a(Arrays.asList(TextUtils.split((String)localObject3, ",")), null);
                        continue;
                        b(Arrays.asList(TextUtils.split((String)localObject3, ",")));
                        continue;
                        am.setText((CharSequence)localObject3);
                        continue;
                        a((CharSequence)localObject3, true);
                        continue;
                        a((CharSequence)localObject3, true, true);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    localObject1 = paramIntent.getExtras();
    if ((localObject1 != null) && (((Bundle)localObject1).containsKey("android.intent.extra.TEXT"))) {
      a(((Bundle)localObject1).getCharSequence("android.intent.extra.TEXT"), true);
    }
    N = ((ContentValues)paramIntent.getParcelableExtra("extra-values"));
    if (N != null)
    {
      cvm.b(n, "ComposeActivity: Launched with extra values: %s", new Object[] { N });
      a(N);
      return true;
    }
    return false;
  }
  
  private static boolean a(Bundle paramBundle)
  {
    return (paramBundle != null) && (paramBundle.containsKey("extraMessage"));
  }
  
  public static String[] a(RecipientEditTextView paramRecipientEditTextView)
  {
    int i = 0;
    if (paramRecipientEditTextView == null)
    {
      paramRecipientEditTextView = new String[0];
      return paramRecipientEditTextView;
    }
    Rfc822Token[] arrayOfRfc822Token = Rfc822Tokenizer.tokenize(paramRecipientEditTextView.getText());
    int j = arrayOfRfc822Token.length;
    String[] arrayOfString = new String[j];
    for (;;)
    {
      paramRecipientEditTextView = arrayOfString;
      if (i >= j) {
        break;
      }
      arrayOfString[i] = arrayOfRfc822Token[i].toString();
      i += 1;
    }
  }
  
  public static Intent b(Context paramContext, Account paramAccount, Message paramMessage)
  {
    return a(paramContext, paramAccount, paramMessage, 3, null, null, null, null, null);
  }
  
  public static Intent b(Context paramContext, Account paramAccount, Message paramMessage, ContentValues paramContentValues)
  {
    paramMessage = f;
    paramContext = a(paramContext, paramAccount, paramMessage, 5);
    paramContext.putExtra("in-reference-to-message-uri", paramMessage);
    paramContext.putExtra("extra-values", paramContentValues);
    return paramContext;
  }
  
  private static String b(Resources paramResources, String paramString, int paramInt)
  {
    String str;
    if (paramInt == -1) {
      str = "";
    }
    while (TextUtils.isEmpty(paramString))
    {
      return str;
      if (paramInt == 2) {
        str = paramResources.getString(buj.ca);
      } else if (paramInt == 4) {
        str = paramResources.getString(buj.dX);
      } else {
        str = paramResources.getString(buj.ei);
      }
    }
    if (paramString.toLowerCase().startsWith(str.toLowerCase())) {
      return paramString;
    }
    return String.format(paramResources.getString(buj.bW), new Object[] { str, paramString });
  }
  
  static ArrayList<String> b(String[] paramArrayOfString)
  {
    ArrayList localArrayList = hgd.b(paramArrayOfString.length);
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Rfc822Tokenizer.tokenize(paramArrayOfString[i])[0].getAddress());
      i += 1;
    }
    return localArrayList;
  }
  
  private static void b(RecipientEditTextView paramRecipientEditTextView)
  {
    paramRecipientEditTextView.setTokenizer(new Rfc822Tokenizer());
    paramRecipientEditTextView.setThreshold(1);
  }
  
  private void b(Message paramMessage)
  {
    Bundle localBundle = M;
    ag = ((ScrollView)findViewById(buc.ai));
    ag.setVisibility(0);
    aj = findViewById(buc.p);
    if (aj != null) {
      aj.setOnClickListener(this);
    }
    ak = ((CcBccView)findViewById(buc.R));
    r = ((ComposeAttachmentTileGrid)findViewById(buc.z));
    q = ((RecipientEditTextView)findViewById(buc.fo));
    q.setOnKeyListener(aO);
    b(q);
    q.k = findViewById(buc.al);
    findViewById(buc.fq).setOnClickListener(new ccc(q));
    ah = ((RecipientEditTextView)findViewById(buc.Q));
    ah.setOnKeyListener(aO);
    b(ah);
    findViewById(buc.U).setOnClickListener(new ccc(ah));
    ai = ((RecipientEditTextView)findViewById(buc.J));
    ai.setOnKeyListener(aO);
    b(ai);
    findViewById(buc.M).setOnClickListener(new ccc(ai));
    am = ((TextView)findViewById(buc.fc));
    am.setOnKeyListener(aO);
    am.setOnEditorActionListener(this);
    am.setOnFocusChangeListener(this);
    v = ((ImageView)findViewById(buc.cN));
    v.setOnClickListener(this);
    w = ((ImageView)findViewById(buc.cM));
    w.setOnClickListener(this);
    an = findViewById(buc.fe);
    y = ((QuotedTextView)findViewById(buc.dJ));
    y.c = this;
    aq = ((RichBodyView)findViewById(buc.O));
    A = aq;
    Object localObject1 = (RichTextToolbar)findViewById(buc.eg);
    ((RichTextToolbar)localObject1).a(1023, 65535);
    ((RichTextToolbar)localObject1).a(0, 8);
    ((RichTextToolbar)localObject1).a(0, 64);
    b = this;
    cwo.a((RichTextToolbar)localObject1);
    aq.b = ((dcm)localObject1);
    A.setOnKeyListener(aO);
    A.setOnFocusChangeListener(this);
    ar = findViewById(buc.fa);
    as = ((TextView)findViewById(buc.bI));
    at = findViewById(buc.eW);
    B = ((FromAddressSpinner)findViewById(buc.bL));
    au = ((ProposedTimeView)findViewById(buc.dE));
    findViewById(buc.am).setOnClickListener(new cbs(this));
    Intent localIntent = getIntent();
    aF = false;
    int i;
    Object localObject4;
    Object localObject3;
    int j;
    if (a(localBundle))
    {
      i = localBundle.getInt("action", -1);
      localObject4 = (Account)localBundle.getParcelable("mail_account");
      localObject1 = localBundle.getParcelableArrayList("attachmentPreviews");
      H = ((Message)localBundle.getParcelable("in-reference-to-message"));
      aE = ((Uri)localIntent.getParcelableExtra("in-reference-to-message-uri"));
      localObject3 = localBundle.getCharSequence("quotedText");
      N = ((ContentValues)localBundle.getParcelable("extra-values"));
      if (localBundle.containsKey("requestId"))
      {
        j = localBundle.getInt("requestId");
        if (!aa.containsKey(Integer.valueOf(j))) {}
      }
      for (;;)
      {
        synchronized (L)
        {
          I = ((Long)aa.get(Integer.valueOf(j))).longValue();
          ??? = localObject1;
          localObject1 = localObject4;
          r.a((ArrayList)???);
          a((Account)localObject1);
          if (s != null) {
            break;
          }
          return;
        }
        ??? = localObject1;
        localObject1 = localObject4;
      }
    }
    if (b(localIntent))
    {
      ??? = localIntent.getStringExtra("fromAccountString");
      if (??? == null) {
        throw new IllegalArgumentException("Missing the From-Account in event forwarding");
      }
      localObject3 = aK;
      j = localObject3.length;
      i = 0;
      label820:
      if (i < j)
      {
        localObject1 = localObject3[i];
        if (!((String)???).equals(c)) {}
      }
    }
    for (;;)
    {
      i = localIntent.getIntExtra("action", -1);
      ??? = localIntent.getParcelableArrayListExtra("attachmentPreviews");
      H = ((Message)localIntent.getParcelableExtra("in-reference-to-message"));
      aE = ((Uri)localIntent.getParcelableExtra("in-reference-to-message-uri"));
      if (buo.b())
      {
        if (localIntent.getBooleanExtra("notification", false))
        {
          buo.a().a("notification_action", "compose", i(i), 0L);
          a((Account)localObject1, i);
        }
        if (localIntent.getBooleanExtra("from-widget", false)) {
          buo.a().a("widget", "compose", null, 0L);
        }
      }
      localObject3 = null;
      break;
      i += 1;
      break label820;
      cvm.d(n, "The account cannot be found in mAccounts: %s", new Object[] { cvm.a((String)???) });
      if ((localIntent == null) || (localIntent.getExtras() == null)) {
        break label2477;
      }
      localObject1 = localIntent.getExtras().get("mail_account");
      if (!(localObject1 instanceof Account)) {
        break label1045;
      }
      localObject1 = (Account)localObject1;
    }
    label1045:
    if ((localObject1 instanceof String))
    {
      localObject1 = Account.a((String)localObject1);
      if (localObject1 == null) {
        label1068:
        if (localIntent.hasExtra("mail_account")) {
          ??? = localIntent.getStringExtra("mail_account");
        }
      }
    }
    for (;;)
    {
      Object localObject5 = cgr.b;
      localObject4 = ((cgr)localObject5).d().getString("lastSendFromAccount", null);
      localObject3 = localObject4;
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        localObject3 = ((cgr)localObject5).c();
      }
      localObject4 = ???;
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject4 = Uri.parse((String)localObject3);
      }
      ??? = localObject1;
      if (aK != null)
      {
        ??? = localObject1;
        if (aK.length > 0)
        {
          if (((localObject4 instanceof String)) && (!TextUtils.isEmpty((String)localObject4)))
          {
            localObject5 = aK;
            j = localObject5.length;
            i = 0;
            for (;;)
            {
              localObject3 = localObject1;
              if (i >= j) {
                break;
              }
              ??? = localObject5[i];
              if (!c.equals(localObject4)) {
                break label2461;
              }
              localObject1 = ???;
              label1234:
              i += 1;
            }
            ??? = localIntent.getStringExtra("selectedAccount");
            continue;
          }
          localObject3 = localObject1;
          if ((localObject4 instanceof Uri))
          {
            localObject5 = aK;
            j = localObject5.length;
            i = 0;
            for (;;)
            {
              localObject3 = localObject1;
              if (i >= j) {
                break;
              }
              ??? = localObject5[i];
              if (!g.equals(localObject4)) {
                break label2458;
              }
              localObject1 = ???;
              label1310:
              i += 1;
            }
          }
          ??? = localObject3;
          if (localObject3 != null) {}
        }
      }
      for (??? = aK[0];; ??? = localObject1)
      {
        localObject1 = ???;
        break;
        boolean bool1;
        label1429:
        label1485:
        boolean bool3;
        boolean bool2;
        if ((localBundle != null) && (localBundle.getBoolean("permissionRequestDismissed")))
        {
          bool1 = true;
          aD = bool1;
          I();
          localObject4 = (Folder)localIntent.getParcelableExtra("extra-notification-folder");
          if (localObject4 != null)
          {
            localObject5 = (Uri)localIntent.getParcelableExtra("extra-notification-conversation");
            if (localObject5 == null) {
              break label1583;
            }
            ??? = new Intent("com.android.mail.action.RESEND_NOTIFICATIONS_WEAR");
            ((Intent)???).putExtra("conversationUri", (Parcelable)localObject5);
            ((Intent)???).setPackage(getPackageName());
            ((Intent)???).putExtra("mail_account", (Parcelable)localObject1);
            ((Intent)???).putExtra("folder", (Parcelable)localObject4);
            startService((Intent)???);
          }
          if (!localIntent.getBooleanExtra("fromemail", false)) {
            break label1616;
          }
          az = true;
          bool3 = false;
          bool2 = false;
          if (aE == null) {
            break label1833;
          }
          aF = true;
          x = i;
          if (Build.VERSION.SDK_INT < 16) {
            break label1821;
          }
          paramMessage = null;
          if (!localIntent.getBooleanExtra("from-wear", false)) {
            break label1666;
          }
          paramMessage = localIntent.getStringExtra("replyText");
        }
        for (;;)
        {
          if (!TextUtils.isEmpty(paramMessage))
          {
            new cbq(this, this, aE, x, paramMessage).execute(new Void[0]);
            finish();
            return;
            bool1 = false;
            break;
            label1583:
            ??? = new Intent("com.android.mail.action.CLEAR_NEW_MAIL_NOTIFICATIONS");
            ((Intent)???).setData(cxa.a(this, c.b));
            break label1429;
            label1616:
            if ((!"android.intent.action.SEND".equals(localIntent.getAction())) || (localIntent.getData() == null)) {
              break label1485;
            }
            az = TextUtils.equals(localIntent.getData().getScheme(), s.v.getScheme());
            break label1485;
            label1666:
            localObject1 = is.a.a(localIntent);
            if (localObject1 != null)
            {
              cvm.b(n, "ComposeActivity: Got remote input from new api", new Object[0]);
              if (((Bundle)localObject1).containsKey("wear_reply")) {}
              for (localObject1 = ((Bundle)localObject1).getCharSequence("wear_reply");; localObject1 = null)
              {
                if (localObject1 != null) {
                  paramMessage = ((CharSequence)localObject1).toString();
                }
                break;
              }
            }
            cvm.b(n, "No remote input from new api, falling back to compatibility mode", new Object[0]);
            paramMessage = localIntent.getClipData();
            if ((paramMessage == null) || (!"com.google.android.wearable.extras".equals(paramMessage.getDescription().getLabel()))) {
              break label2453;
            }
            paramMessage = paramMessage.getItemAt(0).getIntent().getExtras();
            if (paramMessage == null) {
              break label2453;
            }
            paramMessage = paramMessage.getString("wear_reply");
            continue;
          }
          cvm.d(n, "ComposeActivity: remote input string is null", new Object[0]);
          label1821:
          getLoaderManager().initLoader(2, null, this);
          return;
          label1833:
          if ((paramMessage != null) && (i != 3))
          {
            a(paramMessage);
            if ((i == 4) || (i == 5))
            {
              aE = ah;
              getLoaderManager().initLoader(0, null, this);
            }
            aF = v;
            if (H != null)
            {
              b(H, i);
              j = i;
              bool1 = bool2;
            }
          }
          for (;;)
          {
            x = j;
            b(j);
            a(j, localIntent, localBundle, bool1);
            return;
            bool1 = bool2;
            j = i;
            if (aF) {
              if (localObject3 != null)
              {
                a((CharSequence)localObject3, false, true);
                bool1 = bool2;
                j = i;
              }
              else
              {
                bool1 = bool2;
                j = i;
                if (N != null)
                {
                  a(N);
                  return;
                  if (i == 3)
                  {
                    if (paramMessage == null) {
                      throw new IllegalStateException("Message must not be null to edit draft");
                    }
                    a(paramMessage);
                    bool1 = bool3;
                    if (cuh.a())
                    {
                      if (TextUtils.isEmpty(af)) {
                        break label2240;
                      }
                      localObject1 = new bdl(af);
                      ??? = ((bdl)localObject1).a("EVENT_FORWARD");
                      if ((!TextUtils.isEmpty((CharSequence)???)) && (Boolean.valueOf((String)???).booleanValue()))
                      {
                        T = ((bdl)localObject1).a("COLLECTION_ID");
                        U = ((bdl)localObject1).a("ITEM_ID");
                      }
                      i = 1;
                      bool1 = bool3;
                      if (i != 0) {
                        bool1 = true;
                      }
                    }
                    switch (u)
                    {
                    default: 
                      i = -1;
                    }
                    for (;;)
                    {
                      cvm.b(n, "ComposeActivity: Previous draft had action type: %d", new Object[] { Integer.valueOf(i) });
                      if ((i == 4) || (i == 5))
                      {
                        aE = ah;
                        getLoaderManager().initLoader(0, null, this);
                      }
                      aF = v;
                      if (t == null) {
                        break label2448;
                      }
                      aE = t;
                      x = i;
                      getLoaderManager().initLoader(0, null, this);
                      return;
                      label2240:
                      i = 0;
                      break;
                      i = 0;
                      continue;
                      i = 1;
                      continue;
                      i = 2;
                      continue;
                      i = 4;
                      continue;
                      i = 5;
                    }
                  }
                  if ((i == 0) || (i == 1) || (i == 2) || (i == 4) || (i == 5))
                  {
                    bool1 = bool2;
                    j = i;
                    if (H != null)
                    {
                      c(i);
                      aF = true;
                      bool1 = bool2;
                      j = i;
                    }
                  }
                  else
                  {
                    if (c(localIntent))
                    {
                      j = 2;
                      T = localIntent.getStringExtra("com.android.mail.intent.extra.FORWARD_EVENT_COLLECTION_ID");
                      U = localIntent.getStringExtra("com.android.mail.intent.extra.FORWARD_EVENT_ITEM_ID");
                      paramMessage = localIntent.getStringExtra("android.intent.extra.SUBJECT");
                      if (!TextUtils.isEmpty(paramMessage)) {
                        am.setText(paramMessage);
                      }
                      paramMessage = localIntent.getCharSequenceExtra("android.intent.extra.TEXT");
                      if (TextUtils.isEmpty(paramMessage)) {}
                      for (paramMessage = "";; paramMessage = Html.toHtml(new SpannableString(paramMessage)))
                      {
                        a(paramMessage, true, false);
                        bool1 = true;
                        break;
                      }
                    }
                    bool1 = bool2;
                    j = i;
                    if (a(localIntent))
                    {
                      return;
                      label2448:
                      j = i;
                    }
                  }
                }
              }
            }
          }
          label2453:
          paramMessage = null;
        }
        label2458:
        break label1310;
        label2461:
        break label1234;
      }
      localObject1 = null;
      break label1068;
      label2477:
      localObject1 = null;
      ??? = null;
    }
  }
  
  private final void b(Message paramMessage, int paramInt)
  {
    QuotedTextView localQuotedTextView;
    boolean bool;
    Object localObject;
    String str1;
    label61:
    StringBuilder localStringBuilder;
    DateFormat localDateFormat;
    Date localDate;
    if ((paramMessage != null) && ((paramInt == 0) || (paramInt == 1) || (paramInt == 2) || (paramInt == 4) || (paramInt == 5)))
    {
      localQuotedTextView = y;
      if (paramInt == 2) {
        break label236;
      }
      bool = true;
      localObject = localQuotedTextView.getContext();
      if (o == null) {
        break label241;
      }
      str1 = o;
      localStringBuilder = new StringBuilder();
      localDateFormat = DateFormat.getDateTimeInstance(2, 3);
      localDate = new Date(n);
      localObject = ((Context)localObject).getResources();
      if ((paramInt != 0) && (paramInt != 1) && (paramInt != 4) && (paramInt != 5)) {
        break label275;
      }
      localStringBuilder.append("<div class=\"gmail_extra\">").append("<br>").append("<div class=\"gmail_quote\">").append(String.format(((Resources)localObject).getString(buj.eh), new Object[] { localDateFormat.format(localDate), cxa.a(j, true) })).append("<br type=\"attribution\">").append("<blockquote class=\"quote\" style=\"margin:0 0 0 .8ex;border-left:1px #ccc solid;padding-left:1ex\">").append(str1).append("</blockquote>").append("</div>").append("<br>").append("</div>");
    }
    for (;;)
    {
      localQuotedTextView.a(localStringBuilder);
      localQuotedTextView.a(bool);
      localQuotedTextView.a();
      return;
      label236:
      bool = false;
      break;
      label241:
      if (p != null)
      {
        str1 = Html.toHtml(new SpannedString(p));
        break label61;
      }
      str1 = "";
      break label61;
      label275:
      if (paramInt == 2)
      {
        String str2 = l;
        localStringBuilder.append("<div class=\"gmail_quote\">").append(String.format(((Resources)localObject).getString(buj.bY), new Object[] { cxa.a(j, true), localDateFormat.format(localDate), cxa.a(h, false), cxa.a(k, true) })).append(String.format(((Resources)localObject).getString(buj.U), new Object[] { cxa.a(str2, true) })).append("<br type=\"attribution\">").append("<blockquote class=\"quote\" style=\"margin:0 0 0 .8ex;border-left:1px #ccc solid;padding-left:1ex\">").append(str1).append("</blockquote>").append("</div>").append("<br>");
      }
    }
  }
  
  private final void b(Collection<String> paramCollection)
  {
    a(paramCollection, ai);
  }
  
  private static boolean b(Intent paramIntent)
  {
    if ((paramIntent == null) || (!"android.intent.action.SEND".equals(paramIntent.getAction()))) {}
    while ((TextUtils.isEmpty(paramIntent.getStringExtra("com.android.mail.intent.extra.FORWARD_EVENT_UID"))) || (TextUtils.isEmpty(paramIntent.getStringExtra("fromAccountString")))) {
      return false;
    }
    return true;
  }
  
  private static cha c(Account paramAccount)
  {
    Object localObject1 = paramAccount.g().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (cha)((Iterator)localObject1).next();
      if (d) {
        return (cha)localObject2;
      }
    }
    localObject1 = paramAccount.i();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = paramAccount.g().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        cha localcha = (cha)((Iterator)localObject2).next();
        if (TextUtils.equals((CharSequence)localObject1, b)) {
          return localcha;
        }
      }
    }
    return new cha(paramAccount, c, b, c, true, false);
  }
  
  private static List<String> c(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str1 = (String)paramList.next();
      try
      {
        String str2 = e(str1);
        if (str2 != null) {
          localArrayList.add(str2);
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        cvm.e(n, localUnsupportedEncodingException, "Error decoding email: %s", new Object[] { cvm.a(str1) });
      }
    }
    return localArrayList;
  }
  
  public static void c(Context paramContext, Account paramAccount, Message paramMessage)
  {
    cvm.c(n, "[ComposeActivity init] reply %s", new Object[] { paramMessage });
    a(paramContext, paramAccount, paramMessage, 0, null, null, null, null);
  }
  
  private final void c(RecipientEditTextView paramRecipientEditTextView)
  {
    Object localObject = l();
    if (localObject != null) {
      paramRecipientEditTextView.a((bim)localObject);
    }
    localObject = k();
    a((bhx)localObject);
    paramRecipientEditTextView.setAdapter((ListAdapter)localObject);
    A = this;
    B = null;
    C = null;
    D = this;
    if (al == null)
    {
      String str = s.c;
      int i = str.indexOf("@") + 1;
      localObject = str;
      if (i > 0) {
        localObject = str.substring(i);
      }
      al = new anv((String)localObject);
    }
    paramRecipientEditTextView.setValidator(al);
  }
  
  private static boolean c(Intent paramIntent)
  {
    if ((!cuh.a()) || (paramIntent == null) || (!"android.intent.action.SEND".equals(paramIntent.getAction()))) {
      return false;
    }
    boolean bool = true;
    if (TextUtils.isEmpty(paramIntent.getStringExtra("com.android.mail.intent.extra.FORWARD_EVENT_COLLECTION_ID")))
    {
      cvm.d(n, "No collectionId found for event forward", new Object[0]);
      bool = false;
    }
    if (TextUtils.isEmpty(paramIntent.getStringExtra("com.android.mail.intent.extra.FORWARD_EVENT_ITEM_ID")))
    {
      cvm.d(n, "No itemId found for event forward", new Object[0]);
      return false;
    }
    return bool;
  }
  
  private static String d(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (paramString.charAt(paramString.length() - 1) == ',') {
        str = paramString.substring(0, paramString.length() - 1);
      }
    }
    return str;
  }
  
  public static void d(Context paramContext, Account paramAccount, Message paramMessage)
  {
    cvm.c(n, "[ComposeActivity init] replyAll %s", new Object[] { paramMessage });
    a(paramContext, paramAccount, paramMessage, 1, null, null, null, null);
  }
  
  private static boolean d(Account paramAccount)
  {
    return (paramAccount != null) && (paramAccount.a(536870912L));
  }
  
  private final boolean d(List<Uri> paramList)
  {
    if (!cxd.e()) {
      return false;
    }
    if (cwm.a(this, "android.permission.READ_EXTERNAL_STORAGE")) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Uri localUri = (Uri)paramList.next();
      int i;
      if (localUri != null) {
        if ("file".equals(localUri.getScheme())) {
          i = 1;
        }
      }
      while (i != 0)
      {
        return true;
        if ("com.android.providers.media.documents".equals(localUri.getAuthority())) {
          i = 1;
        } else if ("com.android.providers.downloads.documents".equals(localUri.getAuthority())) {
          i = 1;
        } else {
          i = 0;
        }
      }
    }
    return false;
  }
  
  private static String e(String paramString)
  {
    try
    {
      String str = URLDecoder.decode(paramString.replace("+", "%2B"), "UTF-8");
      return str;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      cvm.e(n, localIllegalArgumentException, "Exception while decoding '%s'", new Object[] { cvm.a(n, paramString) });
    }
    return null;
  }
  
  public static void e(Context paramContext, Account paramAccount, Message paramMessage)
  {
    cvm.c(n, "[ComposeActivity init] forward %s", new Object[] { paramMessage });
    a(paramContext, paramAccount, paramMessage, 2, null, null, null, null);
  }
  
  private final void e(Account paramAccount)
  {
    Object localObject = V();
    if (localObject != null)
    {
      ((crl)localObject).a(paramAccount);
      return;
    }
    findViewById(buc.fJ).setVisibility(0);
    paramAccount = crl.a(paramAccount, false);
    localObject = getFragmentManager().beginTransaction();
    ((FragmentTransaction)localObject).setTransition(4097);
    ((FragmentTransaction)localObject).replace(buc.fJ, paramAccount, "wait-fragment");
    ((FragmentTransaction)localObject).commitAllowingStateLoss();
  }
  
  private static String f(String paramString)
  {
    try
    {
      String str = URLDecoder.decode(paramString, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      if (cvm.a(n, 2)) {
        cvm.e(n, localUnsupportedEncodingException, "Error decoding message: %s", new Object[] { paramString });
      }
      for (;;)
      {
        return "";
        cvm.e(n, localUnsupportedEncodingException, "Error decoding message", new Object[0]);
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      if (cvm.a(n, 2))
      {
        cvm.e(n, localIllegalArgumentException, "Given string is not url encoded: '%s'", new Object[] { paramString });
        return paramString;
      }
      cvm.e(n, localIllegalArgumentException, "Given string is not url encoded", new Object[0]);
    }
    return paramString;
  }
  
  private final void g(String paramString)
  {
    Toast localToast = Toast.makeText(this, paramString, 1);
    localToast.setText(paramString);
    localToast.setGravity(1, 0, getResources().getDimensionPixelSize(bua.i));
    localToast.show();
  }
  
  private final void g(boolean paramBoolean)
  {
    if ((!buo.b()) || (r == null)) {
      return;
    }
    String str1;
    int i;
    String str3;
    String str2;
    if (paramBoolean)
    {
      str1 = "message_save";
      i = r.b.size();
      str3 = i(x);
      if (x != -1) {
        break label86;
      }
      str2 = Integer.toString(i);
    }
    for (long l1 = i;; l1 = 0L)
    {
      buo.a().a(str1, str3, str2, l1);
      return;
      str1 = "message_send";
      break;
      label86:
      str2 = null;
    }
  }
  
  private static int h(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return -1;
    case -1: 
      return 1;
    case 0: 
      return 2;
    case 1: 
      return 3;
    case 2: 
      return 4;
    case 4: 
      return 5;
    }
    return 6;
  }
  
  private final void h(boolean paramBoolean)
  {
    if (G != null) {
      G.setEnabled(paramBoolean);
    }
  }
  
  private static Rfc822Token[] h(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return Rfc822Tokenizer.tokenize(paramString);
  }
  
  private static String i(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknown";
    case -1: 
      return "new_message";
    case 0: 
      return "reply";
    case 1: 
      return "reply_all";
    }
    return "forward";
  }
  
  private final void i(String paramString)
  {
    cca localcca = new cca();
    Bundle localBundle = new Bundle(1);
    localBundle.putString("message", paramString);
    localcca.setArguments(localBundle);
    localcca.show(getFragmentManager(), "recipient error");
  }
  
  private final void j(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.GET_CONTENT");
    localIntent.addCategory("android.intent.category.OPENABLE");
    localIntent.addFlags(524288);
    localIntent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
    localIntent.setType(paramString);
    C = true;
    startActivityForResult(Intent.createChooser(localIntent, getText(buj.eA)), 1);
  }
  
  private final String k(String paramString)
  {
    String str2 = getResources().getString(buj.eR);
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    return String.format(str2, new Object[] { str1 });
  }
  
  private final void l(String paramString)
  {
    String str = bur.a(this, s);
    buo.a().a("compose_body_actions", paramString, str, 0L);
  }
  
  public static boolean o()
  {
    return false;
  }
  
  public final void A()
  {
    l("format_clicked");
  }
  
  public final void B_()
  {
    aD = true;
    J();
  }
  
  public long a(Attachment paramAttachment)
  {
    return r.a(s, paramAttachment);
  }
  
  public long a(ArrayList<Attachment> paramArrayList)
  {
    long l1 = 0L;
    Iterator localIterator = paramArrayList.iterator();
    Object localObject = null;
    while (localIterator.hasNext())
    {
      Attachment localAttachment = (Attachment)localIterator.next();
      try
      {
        long l2 = r.a(s, localAttachment);
        l1 += l2;
      }
      catch (ctq localctq) {}
    }
    if (localctq != null)
    {
      cvm.e(n, localctq, "Error adding attachment", new Object[0]);
      if (paramArrayList.size() > 1) {
        d(buj.fi);
      }
    }
    else
    {
      return l1;
    }
    d(a);
    return l1;
  }
  
  final long a(List<Uri> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        paramList = (Uri)localIterator.next();
        if (paramList == null) {
          continue;
        }
        try
        {
          if ("file".equals(paramList.getScheme()))
          {
            if (!new File(paramList.getPath()).getCanonicalPath().startsWith(ad)) {
              break label222;
            }
            g(getString(buj.y));
            buo.a().a("compose_errors", "send_intent_attachment", "data_dir", 0L);
          }
        }
        catch (ctq paramList)
        {
          cvm.e(n, paramList, "Error adding attachment", new Object[0]);
          d(a);
          continue;
          if (("content".equals(paramList.getScheme())) && (j().equals(paramList.getAuthority())))
          {
            g(getString(buj.y));
            buo.a().a("compose_errors", "send_intent_attachment", "email_provider", 0L);
          }
        }
        catch (IOException paramList)
        {
          cvm.e(n, paramList, "Error adding attachment", new Object[0]);
          g(getString(buj.y));
          continue;
          paramList = ctr.a(this, paramList);
          localArrayList.add(paramList);
          buo.a().a("send_intent_attachment", cxa.e(paramList.l()), null, d);
        }
        catch (SecurityException paramList)
        {
          label222:
          for (;;) {}
        }
      }
    }
    return a(localArrayList);
  }
  
  final Message a(cha paramcha, Message paramMessage, int paramInt, cbh paramcbh)
  {
    int i = 1;
    Message localMessage = new Message();
    d = -1L;
    e = null;
    f = null;
    g = null;
    h = am.getText().toString();
    i = null;
    localMessage.b(d(q.getText().toString()));
    localMessage.c(d(ah.getText().toString()));
    localMessage.d(d(ai.getText().toString()));
    localMessage.e(null);
    n = 0L;
    String str;
    label196:
    label370:
    label398:
    boolean bool;
    if (b != null)
    {
      if (c == null) {
        throw new NullPointerException("SpannedToHtmlConverter is null.");
      }
      str = c.a(b);
      o = str;
      if (b == null) {
        break label672;
      }
      paramcbh = b.toString();
      p = paramcbh;
      paramcbh = cxa.b(o);
      if ((p != null) && (p.trim().length() > 0) && (TextUtils.isEmpty(paramcbh)))
      {
        cvm.d(n, "ComposeActivity: Failed HTML conversion: from %d to %d", new Object[] { Integer.valueOf(p.length()), Integer.valueOf(paramcbh.length()) });
        buo.a().a("compose_errors", "failed_html_conversion", null, 0L);
        paramcbh = p;
        o = (String.valueOf(paramcbh).length() + 7 + "<p>" + paramcbh + "</p>");
      }
      s = false;
      if (H == null) {
        break label685;
      }
      paramcbh = H.f;
      t = paramcbh;
      paramcbh = y;
      if (!b) {
        break label691;
      }
      paramcbh = a;
      if (paramcbh == null) {
        break label697;
      }
      bool = true;
      label406:
      v = bool;
      paramcbh = r.b;
      if ((paramcbh == null) || (paramcbh.size() <= 0)) {
        break label703;
      }
      bool = true;
      label440:
      w = bool;
      x = null;
      z = 0L;
      if (T()) {
        E = ay;
      }
      A = false;
      H = Attachment.a(paramcbh);
      G = -1;
      paramcbh = y.a;
      if ((paramMessage != null) && (!TextUtils.isEmpty(paramcbh)))
      {
        if (TextUtils.isEmpty(o)) {
          break label709;
        }
        G = cci.a(String.valueOf(paramcbh));
      }
      label541:
      I = s.g;
      localMessage.a(a(paramcha));
      u = h(paramInt);
      if (paramInt != 4) {
        break label732;
      }
    }
    label672:
    label685:
    label691:
    label697:
    label703:
    label709:
    label732:
    for (paramInt = i;; paramInt = 0)
    {
      if (paramInt != 0)
      {
        if (J != null) {
          break label737;
        }
        ah = f;
        paramcha = (ContentValues)getIntent().getParcelableExtra("extra-values");
        ai = paramcha.getAsInteger("rsvp").intValue();
        aj = paramcha.getAsLong("start_millis").longValue();
        ak = paramcha.getAsLong("end_millis").longValue();
      }
      return localMessage;
      str = a;
      break;
      paramcbh = cxa.b(a);
      break label196;
      paramcbh = null;
      break label370;
      paramcbh = null;
      break label398;
      bool = false;
      break label406;
      bool = false;
      break label440;
      if (TextUtils.isEmpty(p)) {
        break label541;
      }
      G = cci.a(paramcbh);
      break label541;
    }
    label737:
    ah = J.ah;
    ai = J.ai;
    aj = J.aj;
    ak = J.ak;
    return localMessage;
  }
  
  public final String a(Spanned paramSpanned)
  {
    return a(Html.toHtml(b(paramSpanned)));
  }
  
  public String a(cha paramcha)
  {
    Object localObject = null;
    String str;
    if (paramcha != null)
    {
      str = b;
      if (paramcha == null) {
        break label56;
      }
      paramcha = c;
    }
    for (;;)
    {
      return new Address(str, paramcha).b();
      if (s != null)
      {
        str = s.c;
        break;
      }
      str = null;
      break;
      label56:
      paramcha = (cha)localObject;
      if (s != null) {
        paramcha = s.b;
      }
    }
  }
  
  public String a(String paramString)
  {
    return paramString;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    buo.a().a("suggest_click", Integer.toString(paramInt1), Integer.toString(paramInt2), 0L);
  }
  
  public final void a(int paramInt, Intent paramIntent, Bundle paramBundle)
  {
    a(paramInt, paramIntent, paramBundle, false);
  }
  
  public final void a(acz paramacz)
  {
    super.a(paramacz);
    cxe.a(this, btz.a);
  }
  
  public void a(ContentValues paramContentValues) {}
  
  final void a(Context paramContext, int paramInt1, cha paramcha1, cha paramcha2, Message paramMessage1, Message paramMessage2, CharSequence paramCharSequence, ccf paramccf, boolean paramBoolean, int paramInt2, ContentValues paramContentValues, Bundle paramBundle)
  {
    if (!paramBoolean) {
      Z = true;
    }
    ContentValues localContentValues = paramMessage1.c();
    localContentValues.put("customFrom", j);
    String str2 = o;
    String str3 = p;
    int i1;
    String str1;
    label100:
    Object localObject;
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      i1 = 1;
      if (i1 == 0) {
        break label1357;
      }
      String str4 = paramCharSequence.toString();
      paramCharSequence = String.valueOf(str2);
      str1 = String.valueOf(str4);
      if (str1.length() == 0) {
        break label545;
      }
      paramCharSequence = paramCharSequence.concat(str1);
      str1 = String.valueOf(cxa.b(str4));
      str1 = String.valueOf(str3).length() + 2 + String.valueOf(str1).length() + str3 + "\n\n" + str1;
      localContentValues.put("draftType", Integer.valueOf(4));
      localContentValues.put("appendRefMessageContent", Integer.valueOf(1));
      localObject = paramCharSequence;
      paramCharSequence = str4;
    }
    for (;;)
    {
      int j = -1;
      int i;
      int k;
      if ((paramMessage2 != null) && ((!TextUtils.isEmpty(o)) || (!TextUtils.isEmpty(p))))
      {
        i = j;
        if (!TextUtils.isEmpty(o))
        {
          localContentValues.put("bodyHtml", (String)localObject);
          i = j;
          if (i1 != 0)
          {
            j = cci.a(paramCharSequence);
            i = j;
            if (j >= 0) {
              i = j + str2.length();
            }
          }
        }
        j = i;
        if (!TextUtils.isEmpty(p))
        {
          localContentValues.put("bodyText", str1);
          j = i;
          if (i1 != 0)
          {
            j = i;
            if (i == -1) {
              j = str3.length();
            }
          }
        }
        k = j;
        if (j == -1) {
          break label654;
        }
        cgw.a(localContentValues, j);
        i = j;
        localContentValues.put("draftType", Integer.valueOf(h(paramInt2)));
        localContentValues.put("attachments", Attachment.a(paramMessage1.l()));
        if (paramMessage2 != null) {
          if (f == null) {
            break label680;
          }
        }
      }
      label545:
      label654:
      label661:
      label680:
      for (paramMessage2 = f.toString();; paramMessage2 = "")
      {
        if (!TextUtils.isEmpty(paramMessage2)) {
          localContentValues.put("refMessageId", paramMessage2);
        }
        if (c(getIntent()))
        {
          paramMessage2 = T;
          paramCharSequence = U;
          localContentValues.put("collectionId", paramMessage2);
          localContentValues.put("itemId", paramCharSequence);
          localContentValues.put("eventForward", Boolean.valueOf(true));
        }
        if (paramContentValues != null) {
          localContentValues.putAll(paramContentValues);
        }
        if (paramBoolean) {
          break label731;
        }
        paramMessage2 = paramMessage1.l().iterator();
        for (paramInt2 = 0; paramMessage2.hasNext(); paramInt2 = nextd + paramInt2) {}
        i1 = 0;
        break;
        paramCharSequence = new String(paramCharSequence);
        break label100;
        k = j;
        if (c(getIntent()))
        {
          k = j;
          if (i1 != 0)
          {
            if (str2 == null) {
              break label661;
            }
            j = cci.a(paramCharSequence);
            i = j;
            if (j >= 0) {
              i = j + str2.length();
            }
          }
        }
        for (;;)
        {
          k = i;
          if (i != -1)
          {
            cgw.a(localContentValues, i);
            k = i;
          }
          localContentValues.put("bodyHtml", (String)localObject);
          localContentValues.put("bodyText", str1);
          i = k;
          break;
          i = j;
          if (str3 != null) {
            i = str3.length();
          }
        }
      }
      paramCharSequence = cui.d(b);
      label731:
      long l1;
      if (a != null)
      {
        paramMessage2 = a.e;
        buo.a().a("send_mail", paramMessage2, paramCharSequence, paramInt2);
        paramMessage2 = new ccg(paramContext, paramInt1, localContentValues, paramMessage1.l(), paramBundle, paramBoolean);
        l1 = paramccf.b();
        if ((paramcha2 == null) || (a.g.equals(a.g)) || (l1 == -1L)) {
          break label1354;
        }
        paramContext = getContentResolver();
        paramCharSequence = new ContentValues();
        paramCharSequence.put("_id", Long.valueOf(l1));
        if (a.o != null) {
          new ctw().a(paramContext, a.o, paramCharSequence, null, null);
        }
        l1 = -1L;
      }
      label881:
      label893:
      label1208:
      label1215:
      label1336:
      label1342:
      label1348:
      label1354:
      for (;;)
      {
        paramCharSequence = getContentResolver();
        if (l1 != -1L)
        {
          paramInt2 = 1;
          if (!c) {
            break label1208;
          }
          paramContext = "save_message";
          if (paramInt2 == 0) {
            break label1215;
          }
        }
        for (;;)
        {
          try
          {
            b.put("_id", Long.valueOf(l1));
            a(paramCharSequence, a, paramContext, paramMessage2);
            a(paramMessage2);
            paramInt2 = 1;
            if (cxd.e())
            {
              if (getApplicationContext().checkPermission("android.permission.READ_CONTACTS", Process.myPid(), Process.myUid()) == 0) {
                paramInt2 = 1;
              }
            }
            else
            {
              if ((paramInt2 != 0) && (!c))
              {
                paramContext = (String)b.get("toAddresses");
                paramcha2 = (String)b.get("ccAddresses");
                paramcha1 = (String)b.get("bccAddresses");
                paramContext = h(paramContext);
                paramcha2 = h(paramcha2);
                paramcha1 = h(paramcha1);
                if (paramContext == null) {
                  break label1336;
                }
                paramInt2 = paramContext.length;
                if (paramcha2 == null) {
                  break label1342;
                }
                j = paramcha2.length;
                if (paramcha1 == null) {
                  break label1348;
                }
                k = paramcha1.length;
                paramCharSequence = new String[k + (paramInt2 + j)];
                a(paramCharSequence, a(paramCharSequence, a(paramCharSequence, 0, paramContext), paramcha2), paramcha1);
                a(paramCharSequence);
              }
              paramccf.a(paramMessage2, true);
              cvm.c(n, "ComposeActivity: sendOrSaveMessage [%s] posted (isSave: %s) - bodyHtml length: %d, bodyText length: %d, quoted text pos: %d, attach count: %d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(o.length()), Integer.valueOf(p.length()), Integer.valueOf(i), Integer.valueOf(paramMessage1.c(true)) });
              return;
              paramMessage2 = "unknown";
              break;
              paramInt2 = 0;
              break label881;
              paramContext = "send_message";
              break label893;
              paramcha2 = null;
              paramcha1 = a(paramCharSequence, a, paramContext, paramMessage2);
              paramContext = paramcha2;
              if (paramcha1 != null) {
                paramContext = (Uri)paramcha1.getParcelable("messageUri");
              }
              if ((!c) || (paramContext == null)) {
                continue;
              }
              paramContext = paramCharSequence.query(paramContext, chh.n, null, null, null);
              if (paramContext == null) {
                continue;
              }
            }
          }
          finally
          {
            try
            {
              if (paramContext.moveToFirst()) {
                paramccf.a(paramMessage2, new Message(paramContext));
              }
              paramContext.close();
              continue;
            }
            finally
            {
              paramContext.close();
            }
            paramContext = finally;
            a(paramMessage2);
          }
          paramInt2 = 0;
          continue;
          paramInt2 = 0;
          continue;
          j = 0;
          continue;
          k = 0;
        }
      }
      label1357:
      paramCharSequence = null;
      str1 = str3;
      localObject = str2;
    }
  }
  
  public final void a(bkn parambkn)
  {
    new cbr(hef.a(d), null, null, this).execute(new Void[0]);
  }
  
  public final void a(RecipientEditTextView paramRecipientEditTextView, String[] paramArrayOfString)
  {
    int i;
    if (q == paramRecipientEditTextView) {
      i = 0;
    }
    for (;;)
    {
      aG = true;
      cwm.a(this, i, paramArrayOfString);
      return;
      if (ah == paramRecipientEditTextView) {
        i = 1;
      } else if (ai == paramRecipientEditTextView) {
        i = 2;
      } else {
        i = -1;
      }
    }
  }
  
  public void a(Account paramAccount)
  {
    if (paramAccount == null) {}
    do
    {
      return;
      if (!paramAccount.equals(s))
      {
        s = paramAccount;
        u = s.z;
        R();
        z = d(s);
        paramAccount = aq;
        c = z;
        paramAccount.c();
      }
    } while (s == null);
    com.android.mail.ui.MailActivity.t = s.c;
  }
  
  public void a(Account paramAccount, int paramInt) {}
  
  public void a(Message paramMessage)
  {
    Object localObject1 = null;
    int j = -1;
    boolean bool2 = true;
    cvm.b(n, "ComposeActivity: Initializing draft from previous draft message: %s", new Object[] { paramMessage });
    boolean bool1;
    for (;;)
    {
      synchronized (L)
      {
        if (I == -1L)
        {
          I = d;
          J = paramMessage;
          am.setText(h);
          if (u == 4)
          {
            bool1 = true;
            ap = bool1;
            ??? = Arrays.asList(Message.a(paramMessage.h()));
            a((Collection)???);
            a(Arrays.asList(Message.a(paramMessage.i())), (Collection)???);
            b(Arrays.asList(Message.a(paramMessage.j())));
            if (w) {
              a(paramMessage.l());
            }
            ay = E;
            L();
            if ((M == null) || (!M.getBoolean("extraSkipParsingBody"))) {
              break;
            }
            cvm.c(n, "ComposeActivity: Skipping manually populating body and quoted text from draft.", new Object[0]);
          }
        }
        else
        {
          d = I;
        }
      }
      bool1 = false;
    }
    int i;
    if (v)
    {
      i = G;
      if (TextUtils.isEmpty(o)) {
        break label405;
      }
      localObject1 = o;
      if (i < 0) {
        break label537;
      }
      i = cci.a(o);
      if (i < 0) {
        break label532;
      }
      localObject1 = o.substring(0, i);
      paramMessage = o.subSequence(i, o.length());
    }
    for (;;)
    {
      R = new cby(this, (String)localObject1);
      localObject1 = R;
      c.A.setEnabled(false);
      c.A.setHint(buj.P);
      ac.post(R);
      label405:
      String str;
      for (;;)
      {
        if ((i < 0) || (paramMessage == null)) {
          break label435;
        }
        localObject1 = y;
        bool1 = ap;
        ((QuotedTextView)localObject1).a(paramMessage);
        if (bool1) {
          break label521;
        }
        bool1 = bool2;
        ((QuotedTextView)localObject1).a(bool1);
        ((QuotedTextView)localObject1).a();
        return;
        i = -1;
        break;
        str = p;
        if (!TextUtils.isEmpty(str)) {
          break label437;
        }
        ??? = "";
        a((CharSequence)???, false);
        paramMessage = (Message)localObject1;
      }
      label435:
      break;
      label437:
      if (i > str.length()) {
        cvm.f(n, "ComposeActivity: quotedTextIndex (%d) > body.length() (%d)", new Object[] { Integer.valueOf(-1), Integer.valueOf(str.length()) });
      }
      for (;;)
      {
        if (j >= 0) {}
        for (paramMessage = str.substring(0, j);; paramMessage = str)
        {
          ??? = paramMessage;
          i = j;
          if (j < 0) {
            break;
          }
          localObject1 = str.substring(j);
          ??? = paramMessage;
          i = j;
          break;
        }
        label521:
        bool1 = false;
        break;
        j = i;
      }
      label532:
      paramMessage = null;
      continue;
      label537:
      paramMessage = null;
    }
  }
  
  public void a(Message paramMessage, int paramInt)
  {
    I = d;
    J = paramMessage;
    cvm.c(n, "Saving draft id: %d. requestId: %d", new Object[] { Long.valueOf(I), Integer.valueOf(paramInt) });
    aa.put(Integer.valueOf(paramInt), Long.valueOf(I));
  }
  
  public final void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    if (!TextUtils.isEmpty(A.getText())) {
      cvm.e(n, "ComposeActivity: Potential DATA LOSS setBody on a non-empty body (%d -> %d)", new Object[] { Integer.valueOf(A.getText().length()), Integer.valueOf(((CharSequence)localObject).length()) });
    }
    A.setText((CharSequence)localObject);
    cvm.c(n, "ComposeActivity: Body populated, len: %d, sig: %b", new Object[] { Integer.valueOf(((CharSequence)localObject).length()), Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      R();
    }
  }
  
  public final void a(CharSequence paramCharSequence, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = paramCharSequence;
    if (paramBoolean1) {
      localObject = new StringBuilder("<div class=\"gmail_quote\">").append(getResources().getString(buj.bZ)).append("<br type=\"attribution\"><blockquote class=\"quote\" style=\"margin:0 0 0 .8ex;border-left:1px #ccc solid;padding-left:1ex\">").append(paramCharSequence).append("</blockquote></div>");
    }
    paramCharSequence = y;
    paramCharSequence.a((CharSequence)localObject);
    if (paramBoolean2)
    {
      paramCharSequence.findViewById(buc.bd).setVisibility(8);
      paramCharSequence.findViewById(buc.dI).setVisibility(8);
    }
    aF = true;
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    if ("android.permission.READ_CONTACTS".equals(paramString))
    {
      if (paramBoolean) {}
      for (paramString = "enabled";; paramString = "disabled")
      {
        bus.a("contacts_auto_complete", paramString);
        return;
      }
    }
    cvm.f(n, "Unexpected permission checked: %s", new Object[] { paramString });
  }
  
  public final void a(boolean paramBoolean, cha paramcha)
  {
    if (paramBoolean)
    {
      paramcha = A.getText().toString();
      A.removeTextChangedListener(this);
      a(paramcha, false);
      A.addTextChangedListener(this);
      S();
      return;
    }
    B.a(paramcha);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    b(paramBoolean1, paramBoolean2, true);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, ArrayList<String> paramArrayList)
  {
    a(paramBoolean1, paramBoolean2);
  }
  
  protected final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int j = 1;
    if ((aK == null) || (s == null))
    {
      Toast.makeText(this, buj.eC, 0).show();
      if (paramBoolean3) {
        finish();
      }
      return;
    }
    Object localObject = a(q);
    String[] arrayOfString1 = a(ah);
    String[] arrayOfString2 = a(ai);
    ArrayList localArrayList1 = b((String[])localObject);
    localArrayList1.addAll(b(arrayOfString1));
    localArrayList1.addAll(b(arrayOfString2));
    if ((!paramBoolean1) && (localObject.length == 0) && (arrayOfString1.length == 0) && (arrayOfString2.length == 0))
    {
      i(getString(buj.ea));
      return;
    }
    ArrayList localArrayList2 = new ArrayList();
    if (!paramBoolean1)
    {
      a((String[])localObject, localArrayList2);
      a(arrayOfString1, localArrayList2);
      a(arrayOfString2, localArrayList2);
    }
    if (localArrayList2.size() > 0)
    {
      i(String.format(getString(buj.cJ), new Object[] { localArrayList2.get(0) }));
      return;
    }
    if (!paramBoolean1)
    {
      if (paramBoolean3)
      {
        a(paramBoolean1, paramBoolean2);
        return;
      }
      if ((r.b.isEmpty()) && (g()))
      {
        if (TextUtils.getTrimmedLength(am.getText()) == 0) {}
        for (int i = 1; i != 0; i = 0)
        {
          a(buj.au, paramBoolean2, localArrayList1);
          return;
        }
        if ((!ap) || (!y.b))
        {
          localObject = A.getEditableText();
          i = j;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            if (TextUtils.getTrimmedLength((CharSequence)localObject) != 0) {
              break label345;
            }
          }
        }
        label345:
        for (i = j; i != 0; i = 0)
        {
          a(buj.at, paramBoolean2, localArrayList1);
          return;
        }
      }
      if (h())
      {
        a(buj.as, paramBoolean2, localArrayList1);
        return;
      }
    }
    a(paramBoolean1, paramBoolean2, localArrayList1);
  }
  
  public void a(String[] paramArrayOfString)
  {
    new anw(this).a(Arrays.asList(paramArrayOfString));
  }
  
  public final boolean a(int paramInt)
  {
    int i = x;
    boolean bool1;
    label117:
    boolean bool2;
    if (paramInt == 0)
    {
      x = 0;
      F();
      if (i != x)
      {
        q.setText("");
        ah.setText("");
        ai.setText("");
        am.setText("");
        if (!D) {
          r.a();
        }
        if (H != null) {
          c(x);
        }
        if (J == null) {
          break label265;
        }
        if (TextUtils.isEmpty(J.m)) {
          break label230;
        }
        bool1 = true;
        if ((!bool1) && ((TextUtils.isEmpty(J.l)) || (x != 1))) {
          break label235;
        }
        bool2 = true;
      }
    }
    for (;;)
    {
      label145:
      if (H != null) {
        if (!TextUtils.isEmpty(ah.getText()))
        {
          bool1 = true;
          label167:
          if (TextUtils.isEmpty(ai.getText())) {
            break label246;
          }
          bool2 = true;
        }
      }
      for (;;)
      {
        ak.a(false, bool1, bool2);
        H();
        G();
        return true;
        if (paramInt == 1)
        {
          x = 1;
          break;
        }
        if (paramInt != 2) {
          break;
        }
        x = 2;
        break;
        label230:
        bool1 = false;
        break label117;
        label235:
        bool2 = false;
        break label145;
        bool1 = false;
        break label167;
        label246:
        bool2 = false;
        continue;
        boolean bool3 = bool1;
        bool1 = bool2;
        bool2 = bool3;
      }
      label265:
      bool1 = false;
      bool2 = false;
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    u();
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    ctp.a(this, paramContext);
  }
  
  public Spanned b(Spanned paramSpanned)
  {
    return paramSpanned;
  }
  
  final void b(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 3) {}
    switch (J.u)
    {
    case 2: 
    case 3: 
    default: 
      i = 0;
      switch (i)
      {
      }
      break;
    }
    do
    {
      C();
      a(A);
      return;
      i = -1;
      break;
    } while (!TextUtils.isEmpty(q.getText()));
    q.requestFocus();
    a(q);
  }
  
  public final void b(acz paramacz)
  {
    super.b(paramacz);
    cxe.a(this, btz.G);
  }
  
  public final void b(bkn parambkn)
  {
    String str = cui.b(d);
    synchronized (W)
    {
      if (W.b(str, d)) {
        N();
      }
      return;
    }
  }
  
  public final void b(String paramString)
  {
    int i = A.getSelectionStart();
    int j = A.getSelectionEnd();
    Editable localEditable = A.getEditableText();
    if ((localEditable != null) && (localEditable.length() > 0)) {
      a(TextUtils.concat(new CharSequence[] { localEditable, paramString }), false);
    }
    for (;;)
    {
      A.setSelection(i, j);
      y.c(false);
      aL = true;
      if (!A.hasFocus()) {
        A.requestFocus();
      }
      return;
      a(paramString, false);
    }
  }
  
  protected final void b(List<Uri> paramList)
  {
    if (d(paramList))
    {
      aN = new cbu(this, paramList);
      aG = true;
      cwm.a(this, 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE" });
    }
    do
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Uri localUri = (Uri)paramList.next();
        if (localUri != null) {
          try
          {
            if (a(ctr.a(this, localUri)) > 0L) {
              D = true;
            }
          }
          catch (ctq localctq)
          {
            cvm.e(n, localctq, "Error adding attachment", new Object[0]);
            d(a);
          }
        }
      }
    } while (!D);
    n();
    U();
  }
  
  final void b(boolean paramBoolean)
  {
    if (s == null) {}
    while ((x == 4) || (x == 5) || (!O())) {
      return;
    }
    if ((paramBoolean) && (!C)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      a(true, paramBoolean, false);
      return;
    }
  }
  
  public final void b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (ActivityManager.isUserAMonkey()) {
      return;
    }
    cbm localcbm = new cbm(this);
    if (t == null) {
      cvm.d(n, "ComposeActivity: mReplyFromAccountWasNull - defaulting to current account %s", new Object[] { cvm.a(s.c) });
    }
    Object localObject1;
    label67:
    Object localObject2;
    if (t == null)
    {
      localObject1 = c(s);
      a(a);
      localcbm.a();
      if (cxd.a()) {
        break label273;
      }
      localObject2 = a(this, r.b);
      label102:
      O = ab.nextInt();
      cbh localcbh = E();
      ac.post(new cbn(this, localcbh, (cha)localObject1, localcbm, paramBoolean1, paramBoolean3, (Bundle)localObject2));
      if ((getChangingConfigurations() & 0x80) == 0) {
        break label360;
      }
      paramBoolean2 = false;
    }
    label186:
    label210:
    label273:
    label329:
    label337:
    label345:
    label360:
    for (;;)
    {
      paramBoolean3 = paramBoolean2;
      if (paramBoolean1)
      {
        paramBoolean3 = paramBoolean2;
        if (aG) {
          paramBoolean3 = false;
        }
      }
      int i;
      if (paramBoolean3)
      {
        if (paramBoolean1)
        {
          i = buj.df;
          Toast.makeText(this, i, 1).show();
        }
      }
      else
      {
        localObject2 = n;
        if (!paramBoolean1) {
          break label337;
        }
        localObject1 = "saved";
        localObject1 = String.valueOf(localObject1);
        if (((String)localObject1).length() == 0) {
          break label345;
        }
      }
      for (localObject1 = "ComposeActivity: message ".concat((String)localObject1);; localObject1 = new String("ComposeActivity: message "))
      {
        cvm.c((String)localObject2, (String)localObject1, new Object[0]);
        Q();
        n();
        if (paramBoolean1) {
          break;
        }
        finish();
        return;
        localObject1 = t;
        break label67;
        localObject2 = null;
        break label102;
        localObject1 = ((ConnectivityManager)getSystemService("connectivity")).getActiveNetworkInfo();
        if ((localObject1 != null) && (((NetworkInfo)localObject1).isConnected())) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label329;
          }
          i = buj.eH;
          break;
        }
        i = buj.eI;
        break label186;
        localObject1 = "sent";
        break label210;
      }
    }
  }
  
  public boolean b(Account paramAccount)
  {
    return false;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  final void c(int paramInt)
  {
    Message localMessage = H;
    Object localObject = (ContentValues)getIntent().getParcelableExtra("extra-values");
    HashSet localHashSet;
    if (localObject == null)
    {
      am.setText(b(getResources(), h, paramInt));
      if (paramInt == 2) {
        ap = true;
      }
      localMessage = H;
      if (paramInt != 2)
      {
        localObject = new HashSet();
        localHashSet = new HashSet();
        if ((paramInt != 0) && (paramInt != 4) && (paramInt != 5)) {
          break label181;
        }
        cci.a((Set)localObject, null, s, localMessage);
        a((Collection)localObject);
      }
    }
    for (;;)
    {
      b(H, paramInt);
      if ((paramInt == 2) || (D)) {
        a(H.l());
      }
      return;
      localObject = ((ContentValues)localObject).getAsInteger("rsvp");
      if (localObject != null) {
        ((Integer)localObject).intValue();
      }
      am.setText(b(getResources(), h, paramInt));
      break;
      label181:
      if (paramInt == 1)
      {
        cci.a((Set)localObject, localHashSet, s, localMessage);
        a((Collection)localObject);
        a(localHashSet, null);
      }
    }
  }
  
  public final void c(String paramString)
  {
    if (z)
    {
      if (aq.hasSelection())
      {
        localRichBodyView = aq;
        localRichBodyView.a(localRichBodyView.a(), localRichBodyView.b(), new Class[] { TypefaceSpan.class });
        if (!paramString.equalsIgnoreCase("sans-serif")) {
          localRichBodyView.a(new TypefaceSpan(paramString), true);
        }
        u();
      }
    }
    else {
      return;
    }
    RichBodyView localRichBodyView = aq;
    localRichBodyView.d();
    f.i = paramString;
  }
  
  public final void c(boolean paramBoolean)
  {
    if (z)
    {
      if (!aq.hasSelection()) {
        break label37;
      }
      aq.e(paramBoolean);
      u();
    }
    for (;;)
    {
      l("bold");
      return;
      label37:
      aq.a(paramBoolean);
    }
  }
  
  public final void d(int paramInt)
  {
    g(getString(paramInt, new Object[] { ctr.a(getApplicationContext(), s.z.c()) }));
  }
  
  public final void d(boolean paramBoolean)
  {
    if (z)
    {
      if (!aq.hasSelection()) {
        break label37;
      }
      aq.f(paramBoolean);
      u();
    }
    for (;;)
    {
      l("italics");
      return;
      label37:
      aq.b(paramBoolean);
    }
  }
  
  public final void e(int paramInt)
  {
    if (ay != paramInt) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      L();
      h(true);
      return;
      ay = paramInt;
      ax = true;
    }
  }
  
  public final void e(boolean paramBoolean)
  {
    if (z)
    {
      if (!aq.hasSelection()) {
        break label37;
      }
      aq.g(paramBoolean);
      u();
    }
    for (;;)
    {
      l("underline");
      return;
      label37:
      aq.c(paramBoolean);
    }
  }
  
  public final void f(int paramInt)
  {
    RichBodyView localRichBodyView;
    if (z)
    {
      if (!aq.hasSelection()) {
        break label76;
      }
      localRichBodyView = aq;
      localRichBodyView.a(localRichBodyView.a(), localRichBodyView.b(), new Class[] { ForegroundColorSpan.class });
      if (paramInt != -16777216) {
        localRichBodyView.a(new ForegroundColorSpan(paramInt), true);
      }
      u();
    }
    for (;;)
    {
      l("foreground_color");
      return;
      label76:
      localRichBodyView = aq;
      localRichBodyView.d();
      f.g = paramInt;
    }
  }
  
  public final void f(boolean paramBoolean)
  {
    if (z)
    {
      if (!aq.hasSelection()) {
        break label37;
      }
      aq.h(paramBoolean);
      u();
    }
    for (;;)
    {
      l("strikethrough");
      return;
      label37:
      aq.d(paramBoolean);
    }
  }
  
  public final void g(int paramInt)
  {
    if (z)
    {
      if (!aq.hasSelection()) {
        break label74;
      }
      RichBodyView localRichBodyView = aq;
      localRichBodyView.a(localRichBodyView.a(), localRichBodyView.b(), new Class[] { BackgroundColorSpan.class });
      if (paramInt != -1) {
        localRichBodyView.a(new BackgroundColorSpan(paramInt), true);
      }
      u();
    }
    for (;;)
    {
      l("background_color");
      return;
      label74:
      aq.setBackgroundColor(paramInt);
    }
  }
  
  protected boolean g()
  {
    return r.b.size() == 0;
  }
  
  protected boolean h()
  {
    return (u != null) && (u.g);
  }
  
  public gpr<Spanned> i()
  {
    return new cvf();
  }
  
  public String j()
  {
    throw new UnsupportedOperationException("unimplemented, EmailProvider unknown");
  }
  
  public bhx k()
  {
    return new ccq(this, s);
  }
  
  public bim l()
  {
    return null;
  }
  
  final void m()
  {
    if (x == 4)
    {
      String str = A.getText().toString();
      Intent localIntent = new Intent();
      localIntent.putExtra("note", str);
      setResult(-1, localIntent);
      finish();
      return;
    }
    a(false, true, false);
    g(false);
    aM = true;
  }
  
  public final void n()
  {
    MenuItem localMenuItem;
    if (G != null)
    {
      localMenuItem = G;
      if ((!O()) || (P())) {
        break label37;
      }
    }
    label37:
    for (boolean bool = true;; bool = false)
    {
      localMenuItem.setEnabled(bool);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 3;
    if (paramInt1 == 1)
    {
      C = false;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        if (Build.VERSION.SDK_INT < 16) {
          break label91;
        }
        localObject = paramIntent.getClipData();
        if (localObject == null) {
          break label91;
        }
        paramIntent = new ArrayList();
        paramInt2 = ((ClipData)localObject).getItemCount();
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          paramIntent.add(((ClipData)localObject).getItemAt(paramInt1).getUri());
          paramInt1 += 1;
        }
        b(paramIntent);
      }
    }
    label91:
    do
    {
      return;
      b(Collections.singletonList(paramIntent.getData()));
      return;
      if (paramInt1 == 2)
      {
        if (paramInt2 != -1)
        {
          finish();
          return;
        }
        getLoaderManager().initLoader(1, null, this);
        e(null);
        return;
      }
    } while (((paramInt1 != 3) && (paramInt1 != 4) && (paramInt1 != 5)) || (paramInt2 != -1) || (paramIntent == null));
    Object localObject = new Bundle(1);
    ((Bundle)localObject).putParcelable("contactLoaderUri", paramIntent.getData());
    if (paramInt1 == 3) {
      paramInt1 = i;
    }
    for (;;)
    {
      getLoaderManager().initLoader(paramInt1, (Bundle)localObject, this);
      return;
      if (paramInt1 == 4) {
        paramInt1 = 4;
      } else {
        paramInt1 = 5;
      }
    }
  }
  
  public void onBackPressed()
  {
    if ((aI) || (V() != null))
    {
      finish();
      return;
    }
    super.onBackPressed();
  }
  
  @JavascriptInterface
  public void onBodyChanged()
  {
    if (!aP)
    {
      E = true;
      F = true;
      runOnUiThread(new cbo(this));
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == buc.p)
    {
      ak.a(true, true, true);
      if (aj != null) {
        aj.setVisibility(8);
      }
    }
    while (i != buc.cM) {
      return;
    }
    K();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setTitle(buj.aq);
    setContentView(bue.j);
    zc localzc = f().a();
    if (localzc != null)
    {
      localzc.b();
      localzc.c();
    }
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getBundle("compose_state");; paramBundle = null)
    {
      M = paramBundle;
      paramBundle = ctl.b(this);
      if ((paramBundle != null) && (paramBundle.length != 0)) {
        break;
      }
      paramBundle = cgr.b.a(this);
      aK = null;
      startActivityForResult(paramBundle, 2);
      return;
    }
    int j = paramBundle.length;
    int i = 0;
    if (i < j) {
      if (!paramBundle[i].f()) {}
    }
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        aK = null;
        getLoaderManager().initLoader(1, null, this);
        return;
        i += 1;
        break;
      }
      aK = ctl.a(this);
      b(B());
      return;
    }
  }
  
  public Loader<Cursor> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 2: 
      Uri localUri = aE;
      if (b(getIntent()))
      {
        if (paramBundle != null) {
          localUri = (Uri)paramBundle.getParcelable("searchMessageUri");
        }
      }
      else {
        return new CursorLoader(this, localUri, chh.n, null, null, null);
      }
      throw new IllegalStateException("no URI found to create event forwarding loader");
    case 0: 
      return new CursorLoader(this, aE, chh.n, null, null, null);
    case 1: 
      return new CursorLoader(this, cgr.b(), chh.c, null, null, null);
    case 3: 
    case 4: 
    case 5: 
      return new CursorLoader(this, (Uri)paramBundle.getParcelable("contactLoaderUri"), new String[] { "data1" }, null, null, null);
    case 6: 
      return new CursorLoader(this, (Uri)paramBundle.getParcelable("accountUri"), chh.c, null, null, null);
    }
    return new CursorLoader(this, (Uri)paramBundle.getParcelable("domainTlsPredictionUri"), chh.h, null, null, null);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    boolean bool2 = true;
    boolean bool1 = super.onCreateOptionsMenu(paramMenu);
    if ((aK == null) || (aK.length == 0)) {
      return bool1;
    }
    getMenuInflater().inflate(buf.b, paramMenu);
    G = paramMenu.findItem(buc.ei);
    Object localObject;
    if (getIntent() != null)
    {
      localObject = getIntent().getAction();
      label65:
      if (M == null) {
        break label318;
      }
      bool1 = M.getBoolean("saveEnabled");
      label83:
      h(bool1);
      localObject = paramMenu.findItem(buc.eF);
      if (localObject != null) {
        ((MenuItem)localObject).setVisible(T());
      }
      localObject = paramMenu.findItem(buc.bO);
      MenuItem localMenuItem1 = paramMenu.findItem(buc.bx);
      MenuItem localMenuItem2 = paramMenu.findItem(buc.q);
      if (localObject != null)
      {
        if ((s == null) || (!s.a(32768L))) {
          break label368;
        }
        bool1 = true;
        label176:
        ((MenuItem)localObject).setVisible(bool1);
      }
      if (localMenuItem1 != null)
      {
        if ((s == null) || (!s.a(65536L))) {
          break label373;
        }
        bool1 = true;
        label212:
        localMenuItem1.setVisible(bool1);
      }
      if (localMenuItem2 != null) {
        localMenuItem2.setVisible(b(s));
      }
      localObject = paramMenu.findItem(buc.t);
      if (cxd.c()) {
        break label378;
      }
    }
    label318:
    label368:
    label373:
    label378:
    for (bool1 = true;; bool1 = false)
    {
      ((MenuItem)localObject).setVisible(bool1);
      localObject = new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Email.CONTENT_URI);
      bool1 = bool2;
      if (getPackageManager().resolveActivity((Intent)localObject, 65536) != null) {
        break;
      }
      cxa.a(paramMenu, buc.ak, false);
      return true;
      localObject = null;
      break label65;
      if (("android.intent.action.SEND".equals(localObject)) || ("android.intent.action.SEND_MULTIPLE".equals(localObject)) || ("android.intent.action.SENDTO".equals(localObject)) || (O()))
      {
        bool1 = true;
        break label83;
      }
      bool1 = false;
      break label83;
      bool1 = false;
      break label176;
      bool1 = false;
      break label212;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (isChangingConfigurations()) {
      buo.a().a("compose", "onDestroy_configurations", String.format(Locale.US, "%#X", new Object[] { Integer.valueOf(getChangingConfigurations()) }), 0L);
    }
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      C();
      return true;
    }
    return false;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    int i = paramView.getId();
    boolean bool;
    if ((paramBoolean) && ((i == buc.fc) || (i == buc.O)))
    {
      if (TextUtils.isEmpty(ah.getText())) {
        break label175;
      }
      paramBoolean = true;
      if (TextUtils.isEmpty(ai.getText())) {
        break label180;
      }
      bool = true;
      label54:
      if ((!paramBoolean) || (!bool)) {
        break label186;
      }
      i = 1;
      label65:
      ak.a(false, paramBoolean, bool);
      paramView = aj;
      if (i == 0) {
        break label191;
      }
    }
    label175:
    label180:
    label186:
    label191:
    for (int j = 8;; j = 0)
    {
      paramView.setVisibility(j);
      if ((getResources().getBoolean(bty.a)) && (i != 0))
      {
        paramView = new int[2];
        ah.getLocationOnScreen(paramView);
        getWindow().getDecorView().getWindowVisibleDisplayFrame(af);
        i = paramView[1] - f().a().h() - af.top;
        if (i > 0) {
          ag.smoothScrollBy(0, i);
        }
      }
      return;
      paramBoolean = false;
      break;
      bool = false;
      break label54;
      i = 0;
      break label65;
    }
  }
  
  public void onLoaderReset(Loader<Cursor> paramLoader) {}
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getItemId();
    buo.a().a("menu_item", i, "compose");
    if (i == buc.s)
    {
      j("*/*");
      i = 1;
    }
    while ((i != 0) || (super.onOptionsItemSelected(paramMenuItem)))
    {
      return true;
      if (i == buc.t)
      {
        j("image/*");
        i = 1;
      }
      else if (i == buc.ei)
      {
        a(true, true, false);
        i = 1;
      }
      else if (i == buc.eA)
      {
        m();
        i = 1;
      }
      else if (i == buc.aZ)
      {
        if (O())
        {
          new cbw().show(getFragmentManager(), "discard confirm");
          i = 1;
        }
        else
        {
          r();
          i = 1;
        }
      }
      else if (i == buc.eG)
      {
        cxa.a(this, s);
        i = 1;
      }
      else
      {
        Intent localIntent;
        if (i == 16908332)
        {
          if (az)
          {
            onBackPressed();
            i = 1;
          }
          else
          {
            localIntent = cxa.a(s);
            localIntent.setFlags(268484608);
            startActivity(localIntent);
            finish();
            i = 1;
          }
        }
        else if (i == buc.bO)
        {
          cxa.a(this, s, getString(buj.al));
          i = 1;
        }
        else
        {
          if (i == buc.ak)
          {
            localIntent = new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Email.CONTENT_URI);
            if (ah.hasFocus()) {
              i = 4;
            }
            for (;;)
            {
              startActivityForResult(localIntent, i);
              i = 1;
              break;
              if (ai.hasFocus()) {
                i = 5;
              } else {
                i = 3;
              }
            }
          }
          if (i == buc.eF)
          {
            K();
            i = 1;
          }
          else
          {
            i = 0;
          }
        }
      }
    }
    return false;
  }
  
  public void onPause()
  {
    boolean bool2 = false;
    super.onPause();
    if (P != null)
    {
      Q = false;
      p.removeCallbacks(P);
    }
    if (!isChangingConfigurations())
    {
      if (aR == null) {
        aR = Long.valueOf(System.currentTimeMillis());
      }
      boolean bool1 = bool2;
      if (!isChangingConfigurations())
      {
        bool1 = bool2;
        if (O()) {
          bool1 = true;
        }
      }
      b(bool1);
      if ((isFinishing()) && (!aM) && (!P())) {
        g(true);
      }
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    int i = 0;
    Object localObject;
    if (i < paramArrayOfString.length)
    {
      if ("android.permission.READ_CONTACTS".equals(paramArrayOfString[i]))
      {
        localObject = "contacts_auto_complete";
        label35:
        if (paramArrayOfInt[i] != 0) {
          break label108;
        }
      }
      label108:
      for (String str = "granted";; str = "denied")
      {
        bus.a((String)localObject, str);
        for (;;)
        {
          i += 1;
          break;
          if ("android.permission.READ_EXTERNAL_STORAGE".equals(paramArrayOfString[i]))
          {
            localObject = "storage_attachment";
            break label35;
          }
          cvm.f(n, "Unexpected permission requested: %s", new Object[] { paramArrayOfString[i] });
        }
      }
    }
    aG = false;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
    case 1: 
    case 2: 
      J();
      switch (paramInt)
      {
      default: 
        cvm.f(n, "onRecipientsRequestPermissionsResult shouldn't handle this request: %d", new Object[] { Integer.valueOf(paramInt) });
        return;
      case 0: 
        paramArrayOfString = q;
      }
      for (;;)
      {
        ((InputMethodManager)getSystemService("input_method")).showSoftInput(paramArrayOfString, 0);
        paramArrayOfString.showDropDown();
        paramArrayOfString.performFiltering(paramArrayOfString.getText(), 0);
        return;
        paramArrayOfString = ah;
        continue;
        paramArrayOfString = ai;
      }
    }
    paramInt = 0;
    label259:
    if (paramInt < paramArrayOfString.length) {
      if ("android.permission.READ_EXTERNAL_STORAGE".equals(paramArrayOfString[paramInt]))
      {
        if (paramArrayOfInt[paramInt] != 0) {
          break label332;
        }
        if (aN == null) {
          break label315;
        }
        localObject = aN;
        aN = null;
        ((Runnable)localObject).run();
      }
    }
    for (;;)
    {
      paramInt += 1;
      break label259;
      break;
      label315:
      cvm.d(n, "Storage permission granted but mOnStoragePermissionGrantedRunnable is null", new Object[0]);
      continue;
      label332:
      aN = null;
      cfa.a(getString(buj.bS)).show(getFragmentManager(), "permanent-permission-denial-dialog");
    }
  }
  
  protected final void onRestoreInstanceState(Bundle paramBundle)
  {
    if ((aK != null) && (aK.length > 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        F();
      }
      super.onRestoreInstanceState(paramBundle);
      if ((M != null) && (M.containsKey("focusSelectionStart")))
      {
        int j = M.getInt("focusSelectionStart");
        int k = M.getInt("focusSelectionEnd");
        if ((j >= 0) && (k >= 0))
        {
          paramBundle = (EditText)getCurrentFocus();
          int i1 = paramBundle.getText().length();
          if ((j < i1) && (k < i1)) {
            paramBundle.setSelection(j, k);
          }
        }
      }
      if (i != 0) {
        G();
      }
      return;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((B != null) && (s != null)) {
      B.a(x, s, aK, H);
    }
    aI = false;
    aR = null;
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    Bundle localBundle = new Bundle();
    if ((aK == null) || (aK.length == 0))
    {
      paramBundle.putBundle("compose_state", localBundle);
      aI = true;
      return;
    }
    Object localObject = getCurrentFocus();
    if ((localObject != null) && ((localObject instanceof EditText)))
    {
      localObject = (EditText)localObject;
      localBundle.putInt("focusSelectionStart", ((EditText)localObject).getSelectionStart());
      localBundle.putInt("focusSelectionEnd", ((EditText)localObject).getSelectionEnd());
    }
    localObject = B.b;
    int i = B.getSelectedItemPosition();
    if ((localObject != null) && (((List)localObject).size() > 0) && (((List)localObject).size() > i))
    {
      localObject = (cha)((List)localObject).get(i);
      label152:
      if (localObject == null) {
        break label477;
      }
      localBundle.putString("replyFromAccount", ((cha)localObject).a().toString());
      localBundle.putParcelable("mail_account", a);
      label186:
      if ((I == -1L) && (O != 0)) {
        localBundle.putInt("requestId", O);
      }
      i = x;
      localBundle.putInt("action", i);
      cbh localcbh = E();
      localObject = a((cha)localObject, H, i, localcbh);
      if (J != null)
      {
        d = J.d;
        e = J.e;
        f = J.f;
      }
      localBundle.putParcelable("extraMessage", (Parcelable)localObject);
      localBundle.putBoolean("extraSkipParsingBody", isChangingConfigurations());
      localBundle.putBoolean("respondedInline", aL);
      if (H == null) {
        break label492;
      }
      localBundle.putParcelable("in-reference-to-message", H);
      label347:
      localBundle.putBoolean("showCc", ak.a());
      localBundle.putBoolean("showBcc", ak.b());
      if ((G == null) || (!G.isEnabled())) {
        break label539;
      }
    }
    label477:
    label492:
    label539:
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("saveEnabled", bool);
      localBundle.putParcelableArrayList("attachmentPreviews", new ArrayList(r.d.values()));
      localBundle.putParcelable("extra-values", N);
      localBundle.putBoolean("extraTextChanged", E);
      localBundle.putBoolean("permissionRequestDismissed", aD);
      break;
      localObject = null;
      break label152;
      localBundle.putParcelable("mail_account", s);
      break label186;
      if (!v) {
        break label347;
      }
      localObject = y;
      if (b) {}
      for (localObject = a;; localObject = null)
      {
        localBundle.putCharSequence("quotedText", (CharSequence)localObject);
        break;
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    buo.a().a(this);
  }
  
  public void onStop()
  {
    super.onStop();
    buo.a().b(this);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void p()
  {
    Q();
  }
  
  public final void q()
  {
    cha localcha = B.a;
    if (!s.equals(a))
    {
      if (d(a))
      {
        S();
        return;
      }
      localcha = t;
      ccj localccj = new ccj();
      Bundle localBundle = new Bundle(2);
      localBundle.putString("replyFromAccount", localcha.a().toString());
      localBundle.putParcelable("account", a);
      localccj.setArguments(localBundle);
      localccj.show(getFragmentManager(), "confirm-discard-text-formatting-fragment");
      return;
    }
    t = localcha;
    av = true;
    U();
  }
  
  final void r()
  {
    synchronized (L)
    {
      if (I != -1L)
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("_id", Long.valueOf(I));
        if (!s.o.equals(Uri.EMPTY))
        {
          new ctw().a(getContentResolver(), s.o, localContentValues, null, null);
          I = -1L;
        }
      }
      else
      {
        Toast.makeText(this, buj.db, 0).show();
        Q();
        Z = true;
        aM = true;
        finish();
        return;
      }
      getContentResolver().delete(J.f, null, null);
    }
  }
  
  public final void s()
  {
    boolean bool = true;
    D = true;
    QuotedTextView localQuotedTextView = y;
    if (r.b.size() > 0) {}
    for (;;)
    {
      localQuotedTextView.c(bool);
      n();
      U();
      return;
      bool = false;
    }
  }
  
  @JavascriptInterface
  public void save(String paramString)
  {
    if ((aR != null) && (aQ.size() == 1)) {
      ae.b(aR.longValue(), paramString);
    }
    ccs localccs = (ccs)aQ.remove(0);
    a = paramString;
    localccs.run();
  }
  
  public final void t()
  {
    Object localObject = y;
    if (r.b.size() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((QuotedTextView)localObject).c(bool);
      ComposeAttachmentTileGrid localComposeAttachmentTileGrid = r;
      localObject = null;
      int i = localComposeAttachmentTileGrid.getChildCount() - 1;
      if (i > 0) {
        localObject = localComposeAttachmentTileGrid.getChildAt(i);
      }
      if (localObject != null) {
        ((View)localObject).requestFocus();
      }
      U();
      return;
    }
  }
  
  final void u()
  {
    cvm.a(n, "ComposeActivity: text changed", new Object[0]);
    E = true;
    n();
    U();
  }
  
  final Bundle v()
  {
    if (X.size() == 0) {
      return null;
    }
    Object localObject2 = new HashSet();
    Object localObject1 = X.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((Set)localObject2).add(cui.b((String)((Iterator)localObject1).next()));
    }
    localObject1 = new StringBuilder();
    localObject2 = ((Set)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ((StringBuilder)localObject1).append((String)((Iterator)localObject2).next());
      ((StringBuilder)localObject1).append(',');
    }
    localObject2 = s.R.buildUpon();
    ((Uri.Builder)localObject2).appendQueryParameter("tlsp_domain", ((StringBuilder)localObject1).toString());
    localObject1 = new Bundle(1);
    ((Bundle)localObject1).putParcelable("domainTlsPredictionUri", ((Uri.Builder)localObject2).build());
    return (Bundle)localObject1;
  }
  
  public final void w()
  {
    if ((z) && (aq.hasSelection())) {
      aq.f();
    }
  }
  
  public final void x()
  {
    if ((z) && (aq.hasSelection())) {
      aq.f();
    }
  }
  
  public final void y()
  {
    if (z)
    {
      aq.e();
      if (aq.hasSelection()) {
        u();
      }
    }
    l("reset_format");
  }
  
  public final void z()
  {
    if (z)
    {
      A.requestFocus();
      A.setSelection(A.getSelectionEnd());
      aq.f();
    }
    l("close_format");
  }
}

/* Location:
 * Qualified Name:     cbk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */