package android.support.v7.widget;

import agb;
import ahr;
import ahs;
import aht;
import akl;
import akp;
import akr;
import aks;
import akt;
import aku;
import akw;
import akx;
import aky;
import ala;
import alb;
import alc;
import ale;
import alg;
import ali;
import alj;
import alk;
import anb;
import anc;
import and;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;
import mn;
import ns;
import nx;
import og;
import qk;
import qq;
import qr;
import ra;
import rc;
import rg;
import ub;
import uf;
import wu;
import xu;

public class RecyclerView
  extends ViewGroup
  implements qq, ra
{
  public static final Interpolator F;
  private static final int[] G = { 16843830 };
  private static final Class<?>[] H;
  static final boolean a;
  public static final boolean b;
  public final alg A;
  public boolean B;
  public boolean C;
  public boolean D;
  alk E;
  private final alc I;
  private RecyclerView.SavedState J;
  private final Runnable K;
  private boolean L;
  private boolean M;
  private int N;
  private boolean O;
  private int P;
  private boolean Q;
  private final boolean R;
  private final AccessibilityManager S;
  private int T;
  private int U;
  private VelocityTracker V;
  private int W;
  private int aa;
  private int ab;
  private int ac;
  private int ad;
  private final int ae;
  private final int af;
  private float ag;
  private List<Object> ah;
  private akt ai;
  private akr aj;
  private final int[] ak;
  private qr al;
  private final int[] am;
  private final int[] an;
  private final int[] ao;
  private Runnable ap;
  private final and aq;
  public final ala c;
  public agb d;
  public ahr e;
  public final anb f;
  boolean g;
  public final Rect h;
  public akp i;
  public akw j;
  public alb k;
  public final ArrayList<Object> l;
  public final ArrayList<aky> m;
  public aky n;
  public boolean o;
  public boolean p;
  public boolean q;
  public List<Object> r;
  public boolean s;
  public wu t;
  public wu u;
  public wu v;
  public wu w;
  public aks x;
  public int y;
  public final ali z;
  
  static
  {
    if ((Build.VERSION.SDK_INT == 18) || (Build.VERSION.SDK_INT == 19) || (Build.VERSION.SDK_INT == 20))
    {
      bool = true;
      a = bool;
      if (Build.VERSION.SDK_INT < 23) {
        break label100;
      }
    }
    label100:
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      H = new Class[] { Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE };
      F = new akl();
      return;
      bool = false;
      break;
    }
  }
  
  public RecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  /* Error */
  public RecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: aload_0
    //   4: aload_1
    //   5: aload_2
    //   6: iload_3
    //   7: invokespecial 163	android/view/ViewGroup:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   10: aload_0
    //   11: new 165	alc
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 168	alc:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   19: putfield 170	android/support/v7/widget/RecyclerView:I	Lalc;
    //   22: aload_0
    //   23: new 172	ala
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 173	ala:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   31: putfield 175	android/support/v7/widget/RecyclerView:c	Lala;
    //   34: aload_0
    //   35: new 177	anb
    //   38: dup
    //   39: invokespecial 178	anb:<init>	()V
    //   42: putfield 180	android/support/v7/widget/RecyclerView:f	Lanb;
    //   45: aload_0
    //   46: new 182	akj
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 183	akj:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   54: putfield 185	android/support/v7/widget/RecyclerView:K	Ljava/lang/Runnable;
    //   57: aload_0
    //   58: new 187	android/graphics/Rect
    //   61: dup
    //   62: invokespecial 188	android/graphics/Rect:<init>	()V
    //   65: putfield 190	android/support/v7/widget/RecyclerView:h	Landroid/graphics/Rect;
    //   68: aload_0
    //   69: new 192	java/util/ArrayList
    //   72: dup
    //   73: invokespecial 193	java/util/ArrayList:<init>	()V
    //   76: putfield 195	android/support/v7/widget/RecyclerView:l	Ljava/util/ArrayList;
    //   79: aload_0
    //   80: new 192	java/util/ArrayList
    //   83: dup
    //   84: invokespecial 193	java/util/ArrayList:<init>	()V
    //   87: putfield 197	android/support/v7/widget/RecyclerView:m	Ljava/util/ArrayList;
    //   90: aload_0
    //   91: iconst_0
    //   92: putfield 199	android/support/v7/widget/RecyclerView:N	I
    //   95: aload_0
    //   96: iconst_0
    //   97: putfield 201	android/support/v7/widget/RecyclerView:s	Z
    //   100: aload_0
    //   101: iconst_0
    //   102: putfield 203	android/support/v7/widget/RecyclerView:T	I
    //   105: aload_0
    //   106: new 205	ahx
    //   109: dup
    //   110: invokespecial 206	ahx:<init>	()V
    //   113: putfield 208	android/support/v7/widget/RecyclerView:x	Laks;
    //   116: aload_0
    //   117: iconst_0
    //   118: putfield 210	android/support/v7/widget/RecyclerView:y	I
    //   121: aload_0
    //   122: iconst_m1
    //   123: putfield 212	android/support/v7/widget/RecyclerView:U	I
    //   126: aload_0
    //   127: ldc -43
    //   129: putfield 215	android/support/v7/widget/RecyclerView:ag	F
    //   132: aload_0
    //   133: new 217	ali
    //   136: dup
    //   137: aload_0
    //   138: invokespecial 218	ali:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   141: putfield 220	android/support/v7/widget/RecyclerView:z	Lali;
    //   144: aload_0
    //   145: new 222	alg
    //   148: dup
    //   149: invokespecial 223	alg:<init>	()V
    //   152: putfield 225	android/support/v7/widget/RecyclerView:A	Lalg;
    //   155: aload_0
    //   156: iconst_0
    //   157: putfield 227	android/support/v7/widget/RecyclerView:B	Z
    //   160: aload_0
    //   161: iconst_0
    //   162: putfield 229	android/support/v7/widget/RecyclerView:C	Z
    //   165: aload_0
    //   166: new 231	akv
    //   169: dup
    //   170: aload_0
    //   171: invokespecial 232	akv:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   174: putfield 234	android/support/v7/widget/RecyclerView:ai	Lakt;
    //   177: aload_0
    //   178: iconst_0
    //   179: putfield 236	android/support/v7/widget/RecyclerView:D	Z
    //   182: aload_0
    //   183: iconst_2
    //   184: newarray <illegal type>
    //   186: putfield 238	android/support/v7/widget/RecyclerView:ak	[I
    //   189: aload_0
    //   190: iconst_2
    //   191: newarray <illegal type>
    //   193: putfield 240	android/support/v7/widget/RecyclerView:am	[I
    //   196: aload_0
    //   197: iconst_2
    //   198: newarray <illegal type>
    //   200: putfield 242	android/support/v7/widget/RecyclerView:an	[I
    //   203: aload_0
    //   204: iconst_2
    //   205: newarray <illegal type>
    //   207: putfield 244	android/support/v7/widget/RecyclerView:ao	[I
    //   210: aload_0
    //   211: new 246	akk
    //   214: dup
    //   215: aload_0
    //   216: invokespecial 247	akk:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   219: putfield 249	android/support/v7/widget/RecyclerView:ap	Ljava/lang/Runnable;
    //   222: aload_0
    //   223: new 251	akm
    //   226: dup
    //   227: aload_0
    //   228: invokespecial 252	akm:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   231: putfield 254	android/support/v7/widget/RecyclerView:aq	Land;
    //   234: aload_0
    //   235: iconst_1
    //   236: invokevirtual 258	android/support/v7/widget/RecyclerView:setScrollContainer	(Z)V
    //   239: aload_0
    //   240: iconst_1
    //   241: invokevirtual 261	android/support/v7/widget/RecyclerView:setFocusableInTouchMode	(Z)V
    //   244: getstatic 117	android/os/Build$VERSION:SDK_INT	I
    //   247: bipush 16
    //   249: if_icmplt +385 -> 634
    //   252: iconst_1
    //   253: istore 4
    //   255: aload_0
    //   256: iload 4
    //   258: putfield 263	android/support/v7/widget/RecyclerView:R	Z
    //   261: aload_1
    //   262: invokestatic 269	android/view/ViewConfiguration:get	(Landroid/content/Context;)Landroid/view/ViewConfiguration;
    //   265: astore 6
    //   267: aload_0
    //   268: aload 6
    //   270: invokevirtual 273	android/view/ViewConfiguration:getScaledTouchSlop	()I
    //   273: putfield 275	android/support/v7/widget/RecyclerView:ad	I
    //   276: aload_0
    //   277: aload 6
    //   279: invokevirtual 278	android/view/ViewConfiguration:getScaledMinimumFlingVelocity	()I
    //   282: putfield 280	android/support/v7/widget/RecyclerView:ae	I
    //   285: aload_0
    //   286: aload 6
    //   288: invokevirtual 283	android/view/ViewConfiguration:getScaledMaximumFlingVelocity	()I
    //   291: putfield 285	android/support/v7/widget/RecyclerView:af	I
    //   294: aload_0
    //   295: invokestatic 290	rg:a	(Landroid/view/View;)I
    //   298: iconst_2
    //   299: if_icmpne +341 -> 640
    //   302: iconst_1
    //   303: istore 4
    //   305: aload_0
    //   306: iload 4
    //   308: invokevirtual 293	android/support/v7/widget/RecyclerView:setWillNotDraw	(Z)V
    //   311: aload_0
    //   312: getfield 208	android/support/v7/widget/RecyclerView:x	Laks;
    //   315: aload_0
    //   316: getfield 234	android/support/v7/widget/RecyclerView:ai	Lakt;
    //   319: putfield 297	aks:h	Lakt;
    //   322: aload_0
    //   323: new 299	agb
    //   326: dup
    //   327: new 301	ako
    //   330: dup
    //   331: aload_0
    //   332: invokespecial 302	ako:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   335: invokespecial 305	agb:<init>	(Lagc;)V
    //   338: putfield 307	android/support/v7/widget/RecyclerView:d	Lagb;
    //   341: aload_0
    //   342: new 309	ahr
    //   345: dup
    //   346: new 311	akn
    //   349: dup
    //   350: aload_0
    //   351: invokespecial 312	akn:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   354: invokespecial 315	ahr:<init>	(Laht;)V
    //   357: putfield 317	android/support/v7/widget/RecyclerView:e	Lahr;
    //   360: aload_0
    //   361: invokestatic 319	rg:d	(Landroid/view/View;)I
    //   364: ifne +8 -> 372
    //   367: aload_0
    //   368: iconst_1
    //   369: invokestatic 322	rg:c	(Landroid/view/View;I)V
    //   372: aload_0
    //   373: aload_0
    //   374: invokevirtual 326	android/support/v7/widget/RecyclerView:getContext	()Landroid/content/Context;
    //   377: ldc_w 328
    //   380: invokevirtual 332	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   383: checkcast 334	android/view/accessibility/AccessibilityManager
    //   386: putfield 336	android/support/v7/widget/RecyclerView:S	Landroid/view/accessibility/AccessibilityManager;
    //   389: aload_0
    //   390: new 338	alk
    //   393: dup
    //   394: aload_0
    //   395: invokespecial 339	alk:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   398: putfield 341	android/support/v7/widget/RecyclerView:E	Lalk;
    //   401: aload_0
    //   402: aload_0
    //   403: getfield 341	android/support/v7/widget/RecyclerView:E	Lalk;
    //   406: invokestatic 344	rg:a	(Landroid/view/View;Lol;)V
    //   409: iload 5
    //   411: istore 4
    //   413: aload_2
    //   414: ifnull +213 -> 627
    //   417: aload_1
    //   418: aload_2
    //   419: getstatic 348	acw:Z	[I
    //   422: iload_3
    //   423: iconst_0
    //   424: invokevirtual 352	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   427: astore 6
    //   429: aload 6
    //   431: getstatic 354	acw:aa	I
    //   434: invokevirtual 360	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   437: astore 7
    //   439: aload 6
    //   441: invokevirtual 363	android/content/res/TypedArray:recycle	()V
    //   444: aload 7
    //   446: ifnull +146 -> 592
    //   449: aload 7
    //   451: invokevirtual 369	java/lang/String:trim	()Ljava/lang/String;
    //   454: astore 6
    //   456: aload 6
    //   458: invokevirtual 372	java/lang/String:length	()I
    //   461: ifeq +131 -> 592
    //   464: aload 6
    //   466: iconst_0
    //   467: invokevirtual 376	java/lang/String:charAt	(I)C
    //   470: bipush 46
    //   472: if_icmpne +174 -> 646
    //   475: new 378	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 379	java/lang/StringBuilder:<init>	()V
    //   482: aload_1
    //   483: invokevirtual 382	android/content/Context:getPackageName	()Ljava/lang/String;
    //   486: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: aload 6
    //   491: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: invokevirtual 389	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   497: astore 6
    //   499: aload_0
    //   500: invokevirtual 393	android/support/v7/widget/RecyclerView:isInEditMode	()Z
    //   503: ifeq +193 -> 696
    //   506: aload_0
    //   507: invokevirtual 399	java/lang/Object:getClass	()Ljava/lang/Class;
    //   510: invokevirtual 403	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   513: astore 7
    //   515: aload 7
    //   517: aload 6
    //   519: invokevirtual 409	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   522: ldc_w 411
    //   525: invokevirtual 415	java/lang/Class:asSubclass	(Ljava/lang/Class;)Ljava/lang/Class;
    //   528: astore 9
    //   530: aload 9
    //   532: getstatic 135	android/support/v7/widget/RecyclerView:H	[Ljava/lang/Class;
    //   535: invokevirtual 419	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   538: astore 8
    //   540: iconst_4
    //   541: anewarray 395	java/lang/Object
    //   544: astore 7
    //   546: aload 7
    //   548: iconst_0
    //   549: aload_1
    //   550: aastore
    //   551: aload 7
    //   553: iconst_1
    //   554: aload_2
    //   555: aastore
    //   556: aload 7
    //   558: iconst_2
    //   559: iload_3
    //   560: invokestatic 423	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   563: aastore
    //   564: aload 7
    //   566: iconst_3
    //   567: iconst_0
    //   568: invokestatic 423	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   571: aastore
    //   572: aload 8
    //   574: iconst_1
    //   575: invokevirtual 428	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   578: aload_0
    //   579: aload 8
    //   581: aload 7
    //   583: invokevirtual 432	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   586: checkcast 411	akw
    //   589: invokevirtual 435	android/support/v7/widget/RecyclerView:a	(Lakw;)V
    //   592: iload 5
    //   594: istore 4
    //   596: getstatic 117	android/os/Build$VERSION:SDK_INT	I
    //   599: bipush 21
    //   601: if_icmplt +26 -> 627
    //   604: aload_1
    //   605: aload_2
    //   606: getstatic 112	android/support/v7/widget/RecyclerView:G	[I
    //   609: iload_3
    //   610: iconst_0
    //   611: invokevirtual 352	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   614: astore_1
    //   615: aload_1
    //   616: iconst_0
    //   617: iconst_1
    //   618: invokevirtual 439	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   621: istore 4
    //   623: aload_1
    //   624: invokevirtual 363	android/content/res/TypedArray:recycle	()V
    //   627: aload_0
    //   628: iload 4
    //   630: invokevirtual 442	android/support/v7/widget/RecyclerView:setNestedScrollingEnabled	(Z)V
    //   633: return
    //   634: iconst_0
    //   635: istore 4
    //   637: goto -382 -> 255
    //   640: iconst_0
    //   641: istore 4
    //   643: goto -338 -> 305
    //   646: aload 6
    //   648: ldc_w 444
    //   651: invokevirtual 448	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   654: ifeq +6 -> 660
    //   657: goto -158 -> 499
    //   660: new 378	java/lang/StringBuilder
    //   663: dup
    //   664: invokespecial 379	java/lang/StringBuilder:<init>	()V
    //   667: ldc 2
    //   669: invokevirtual 452	java/lang/Class:getPackage	()Ljava/lang/Package;
    //   672: invokevirtual 457	java/lang/Package:getName	()Ljava/lang/String;
    //   675: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: bipush 46
    //   680: invokevirtual 460	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   683: aload 6
    //   685: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: invokevirtual 389	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   691: astore 6
    //   693: goto -194 -> 499
    //   696: aload_1
    //   697: invokevirtual 461	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   700: astore 7
    //   702: goto -187 -> 515
    //   705: astore 7
    //   707: aload 9
    //   709: iconst_0
    //   710: anewarray 123	java/lang/Class
    //   713: invokevirtual 419	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   716: astore 8
    //   718: aconst_null
    //   719: astore 7
    //   721: goto -149 -> 572
    //   724: astore_1
    //   725: aload_1
    //   726: aload 7
    //   728: invokevirtual 465	java/lang/NoSuchMethodException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   731: pop
    //   732: new 467	java/lang/IllegalStateException
    //   735: dup
    //   736: new 378	java/lang/StringBuilder
    //   739: dup
    //   740: invokespecial 379	java/lang/StringBuilder:<init>	()V
    //   743: aload_2
    //   744: invokeinterface 470 1 0
    //   749: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: ldc_w 472
    //   755: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: aload 6
    //   760: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: invokevirtual 389	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   766: aload_1
    //   767: invokespecial 475	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   770: athrow
    //   771: astore_1
    //   772: new 467	java/lang/IllegalStateException
    //   775: dup
    //   776: new 378	java/lang/StringBuilder
    //   779: dup
    //   780: invokespecial 379	java/lang/StringBuilder:<init>	()V
    //   783: aload_2
    //   784: invokeinterface 470 1 0
    //   789: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: ldc_w 477
    //   795: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: aload 6
    //   800: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: invokevirtual 389	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   806: aload_1
    //   807: invokespecial 475	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   810: athrow
    //   811: astore_1
    //   812: new 467	java/lang/IllegalStateException
    //   815: dup
    //   816: new 378	java/lang/StringBuilder
    //   819: dup
    //   820: invokespecial 379	java/lang/StringBuilder:<init>	()V
    //   823: aload_2
    //   824: invokeinterface 470 1 0
    //   829: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   832: ldc_w 479
    //   835: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: aload 6
    //   840: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   843: invokevirtual 389	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   846: aload_1
    //   847: invokespecial 475	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   850: athrow
    //   851: astore_1
    //   852: new 467	java/lang/IllegalStateException
    //   855: dup
    //   856: new 378	java/lang/StringBuilder
    //   859: dup
    //   860: invokespecial 379	java/lang/StringBuilder:<init>	()V
    //   863: aload_2
    //   864: invokeinterface 470 1 0
    //   869: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: ldc_w 479
    //   875: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: aload 6
    //   880: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   883: invokevirtual 389	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   886: aload_1
    //   887: invokespecial 475	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   890: athrow
    //   891: astore_1
    //   892: new 467	java/lang/IllegalStateException
    //   895: dup
    //   896: new 378	java/lang/StringBuilder
    //   899: dup
    //   900: invokespecial 379	java/lang/StringBuilder:<init>	()V
    //   903: aload_2
    //   904: invokeinterface 470 1 0
    //   909: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   912: ldc_w 481
    //   915: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: aload 6
    //   920: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   923: invokevirtual 389	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   926: aload_1
    //   927: invokespecial 475	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   930: athrow
    //   931: astore_1
    //   932: new 467	java/lang/IllegalStateException
    //   935: dup
    //   936: new 378	java/lang/StringBuilder
    //   939: dup
    //   940: invokespecial 379	java/lang/StringBuilder:<init>	()V
    //   943: aload_2
    //   944: invokeinterface 470 1 0
    //   949: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   952: ldc_w 483
    //   955: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   958: aload 6
    //   960: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   963: invokevirtual 389	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   966: aload_1
    //   967: invokespecial 475	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   970: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	971	0	this	RecyclerView
    //   0	971	1	paramContext	Context
    //   0	971	2	paramAttributeSet	AttributeSet
    //   0	971	3	paramInt	int
    //   253	389	4	bool1	boolean
    //   1	592	5	bool2	boolean
    //   265	694	6	localObject1	Object
    //   437	264	7	localObject2	Object
    //   705	1	7	localNoSuchMethodException	NoSuchMethodException
    //   719	8	7	localThrowable	Throwable
    //   538	179	8	localConstructor	java.lang.reflect.Constructor
    //   528	180	9	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   530	546	705	java/lang/NoSuchMethodException
    //   556	572	705	java/lang/NoSuchMethodException
    //   707	718	724	java/lang/NoSuchMethodException
    //   499	515	771	java/lang/ClassNotFoundException
    //   515	530	771	java/lang/ClassNotFoundException
    //   530	546	771	java/lang/ClassNotFoundException
    //   556	572	771	java/lang/ClassNotFoundException
    //   572	592	771	java/lang/ClassNotFoundException
    //   696	702	771	java/lang/ClassNotFoundException
    //   707	718	771	java/lang/ClassNotFoundException
    //   725	771	771	java/lang/ClassNotFoundException
    //   499	515	811	java/lang/reflect/InvocationTargetException
    //   515	530	811	java/lang/reflect/InvocationTargetException
    //   530	546	811	java/lang/reflect/InvocationTargetException
    //   556	572	811	java/lang/reflect/InvocationTargetException
    //   572	592	811	java/lang/reflect/InvocationTargetException
    //   696	702	811	java/lang/reflect/InvocationTargetException
    //   707	718	811	java/lang/reflect/InvocationTargetException
    //   725	771	811	java/lang/reflect/InvocationTargetException
    //   499	515	851	java/lang/InstantiationException
    //   515	530	851	java/lang/InstantiationException
    //   530	546	851	java/lang/InstantiationException
    //   556	572	851	java/lang/InstantiationException
    //   572	592	851	java/lang/InstantiationException
    //   696	702	851	java/lang/InstantiationException
    //   707	718	851	java/lang/InstantiationException
    //   725	771	851	java/lang/InstantiationException
    //   499	515	891	java/lang/IllegalAccessException
    //   515	530	891	java/lang/IllegalAccessException
    //   530	546	891	java/lang/IllegalAccessException
    //   556	572	891	java/lang/IllegalAccessException
    //   572	592	891	java/lang/IllegalAccessException
    //   696	702	891	java/lang/IllegalAccessException
    //   707	718	891	java/lang/IllegalAccessException
    //   725	771	891	java/lang/IllegalAccessException
    //   499	515	931	java/lang/ClassCastException
    //   515	530	931	java/lang/ClassCastException
    //   530	546	931	java/lang/ClassCastException
    //   556	572	931	java/lang/ClassCastException
    //   572	592	931	java/lang/ClassCastException
    //   696	702	931	java/lang/ClassCastException
    //   707	718	931	java/lang/ClassCastException
    //   725	771	931	java/lang/ClassCastException
  }
  
  private final void a(MotionEvent paramMotionEvent)
  {
    int i1 = qk.b(paramMotionEvent);
    if (qk.b(paramMotionEvent, i1) == U) {
      if (i1 != 0) {
        break label75;
      }
    }
    label75:
    for (i1 = 1;; i1 = 0)
    {
      U = qk.b(paramMotionEvent, i1);
      int i2 = (int)(qk.c(paramMotionEvent, i1) + 0.5F);
      ab = i2;
      W = i2;
      i1 = (int)(qk.d(paramMotionEvent, i1) + 0.5F);
      ac = i1;
      aa = i1;
      return;
    }
  }
  
  private final void a(int[] paramArrayOfInt)
  {
    int i7 = e.a();
    if (i7 == 0)
    {
      paramArrayOfInt[0] = 0;
      paramArrayOfInt[1] = 0;
      return;
    }
    int i1 = Integer.MAX_VALUE;
    int i3 = Integer.MIN_VALUE;
    int i5 = 0;
    int i4;
    int i2;
    if (i5 < i7)
    {
      alj localalj = b(e.b(i5));
      i4 = i1;
      if (localalj.b()) {
        break label122;
      }
      int i6 = localalj.c();
      i2 = i1;
      if (i6 < i1) {
        i2 = i6;
      }
      i4 = i2;
      if (i6 <= i3) {
        break label122;
      }
      i1 = i6;
    }
    for (;;)
    {
      i5 += 1;
      i3 = i1;
      i1 = i2;
      break;
      paramArrayOfInt[0] = i1;
      paramArrayOfInt[1] = i3;
      return;
      label122:
      i1 = i3;
      i2 = i4;
    }
  }
  
  private final boolean a(int paramInt1, int paramInt2, MotionEvent paramMotionEvent)
  {
    int i2 = 0;
    int i8 = 0;
    int i4 = 0;
    int i6 = 0;
    int i5 = 0;
    int i1 = 0;
    int i3 = 0;
    int i7 = 0;
    a();
    if (i != null)
    {
      b();
      g();
      mn.a("RV Scroll");
      i2 = i8;
      if (paramInt1 != 0)
      {
        i1 = j.a(paramInt1, c, A);
        i2 = paramInt1 - i1;
      }
      i3 = i7;
      i4 = i6;
      if (paramInt2 != 0)
      {
        i3 = j.b(paramInt2, c, A);
        i4 = paramInt2 - i3;
      }
      mn.a();
      l();
      h();
      a(false);
      i5 = i1;
    }
    if (!l.isEmpty()) {
      invalidate();
    }
    if (dispatchNestedScroll(i5, i3, i2, i4, am))
    {
      ab -= am[0];
      ac -= am[1];
      if (paramMotionEvent != null) {
        paramMotionEvent.offsetLocation(am[0], am[1]);
      }
      paramMotionEvent = ao;
      paramMotionEvent[0] += am[0];
      paramMotionEvent = ao;
      paramMotionEvent[1] += am[1];
    }
    while (rg.a(this) == 2)
    {
      if ((i5 != 0) || (i3 != 0)) {
        k();
      }
      if (!awakenScrollBars()) {
        invalidate();
      }
      if ((i5 == 0) && (i3 == 0)) {
        break;
      }
      return true;
    }
    float f1;
    float f2;
    float f3;
    float f4;
    if (paramMotionEvent != null)
    {
      f1 = paramMotionEvent.getX();
      f2 = i2;
      f3 = paramMotionEvent.getY();
      f4 = i4;
      i2 = 0;
      if (f2 >= 0.0F) {
        break label456;
      }
      c();
      i1 = i2;
      if (t.a(-f2 / getWidth(), 1.0F - f3 / getHeight())) {
        i1 = 1;
      }
      label379:
      if (f4 >= 0.0F) {
        break label507;
      }
      e();
      i2 = i1;
      if (u.a(-f4 / getHeight(), f1 / getWidth())) {
        i2 = 1;
      }
    }
    for (;;)
    {
      if ((i2 != 0) || (f2 != 0.0F) || (f4 != 0.0F)) {
        rg.c(this);
      }
      a(paramInt1, paramInt2);
      break;
      label456:
      i1 = i2;
      if (f2 <= 0.0F) {
        break label379;
      }
      d();
      i1 = i2;
      if (!v.a(f2 / getWidth(), f3 / getHeight())) {
        break label379;
      }
      i1 = 1;
      break label379;
      label507:
      i2 = i1;
      if (f4 > 0.0F)
      {
        f();
        i2 = i1;
        if (w.a(f4 / getHeight(), 1.0F - f1 / getWidth())) {
          i2 = 1;
        }
      }
    }
    return false;
  }
  
  private final long b(alj paramalj)
  {
    if (i.a) {
      return d;
    }
    return b;
  }
  
  public static alj b(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    return getLayoutParamsa;
  }
  
  public static int c(View paramView)
  {
    paramView = b(paramView);
    if (paramView != null) {
      return paramView.c();
    }
    return -1;
  }
  
  private final boolean c(int paramInt1, int paramInt2)
  {
    if (j == null) {
      Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
    }
    boolean bool2;
    int i1;
    do
    {
      do
      {
        return false;
      } while (q);
      bool1 = j.c();
      bool2 = j.d();
      if (bool1)
      {
        i1 = paramInt1;
        if (Math.abs(paramInt1) >= ae) {}
      }
      else
      {
        i1 = 0;
      }
      if (bool2)
      {
        paramInt1 = paramInt2;
        if (Math.abs(paramInt2) >= ae) {}
      }
      else
      {
        paramInt1 = 0;
      }
    } while (((i1 == 0) && (paramInt1 == 0)) || (dispatchNestedPreFling(i1, paramInt1)));
    if ((bool1) || (bool2)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      dispatchNestedFling(i1, paramInt1, bool1);
      if (!bool1) {
        break;
      }
      paramInt2 = Math.max(-af, Math.min(i1, af));
      paramInt1 = Math.max(-af, Math.min(paramInt1, af));
      ali localali = z;
      d.a(2);
      b = 0;
      a = 0;
      c.a(0, paramInt2, paramInt1, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
      localali.a();
      return true;
    }
  }
  
  private final void m()
  {
    a(0);
    n();
  }
  
  private final void n()
  {
    z.b();
    if (j != null)
    {
      akw localakw = j;
      if (j != null) {
        j.a();
      }
    }
  }
  
  private final void o()
  {
    w = null;
    u = null;
    v = null;
    t = null;
  }
  
  private final void p()
  {
    if (V != null) {
      V.clear();
    }
    stopNestedScroll();
    boolean bool2 = false;
    if (t != null) {
      bool2 = t.c();
    }
    boolean bool1 = bool2;
    if (u != null) {
      bool1 = bool2 | u.c();
    }
    bool2 = bool1;
    if (v != null) {
      bool2 = bool1 | v.c();
    }
    bool1 = bool2;
    if (w != null) {
      bool1 = bool2 | w.c();
    }
    if (bool1) {
      rg.c(this);
    }
  }
  
  private final void q()
  {
    p();
    a(0);
  }
  
  private boolean r()
  {
    return T > 0;
  }
  
  private final boolean s()
  {
    return (x != null) && (j.f());
  }
  
  private final void t()
  {
    boolean bool2 = true;
    Object localObject1;
    int i1;
    if (s)
    {
      localObject1 = d;
      ((agb)localObject1).a(a);
      ((agb)localObject1).a(b);
      g = 0;
      int i2 = e.b();
      i1 = 0;
      while (i1 < i2)
      {
        localObject1 = b(e.c(i1));
        if ((localObject1 != null) && (!((alj)localObject1).b())) {
          ((alj)localObject1).b(6);
        }
        i1 += 1;
      }
      i2 = e.b();
      i1 = 0;
      while (i1 < i2)
      {
        e.c(i1).getLayoutParams()).c = true;
        i1 += 1;
      }
      localObject1 = c;
      i2 = c.size();
      i1 = 0;
      Object localObject2;
      while (i1 < i2)
      {
        localObject2 = (akx)c.get(i1)).a.getLayoutParams();
        if (localObject2 != null) {
          c = true;
        }
        i1 += 1;
      }
      localObject1 = c;
      if ((f.i != null) && (f.i.a))
      {
        i2 = c.size();
        i1 = 0;
      }
      while (i1 < i2)
      {
        localObject2 = (alj)c.get(i1);
        if (localObject2 != null)
        {
          ((alj)localObject2).b(6);
          ((alj)localObject2).a(null);
        }
        i1 += 1;
        continue;
        ((ala)localObject1).b();
      }
      j.n();
    }
    if (s())
    {
      d.a();
      if ((!B) && (!C)) {
        break label448;
      }
      i1 = 1;
      label328:
      localObject1 = A;
      if ((!o) || (x == null) || ((!s) && (i1 == 0) && (!j.k)) || ((s) && (!i.a))) {
        break label453;
      }
      bool1 = true;
      label388:
      h = bool1;
      localObject1 = A;
      if ((!A.h) || (i1 == 0) || (s) || (!s())) {
        break label458;
      }
    }
    label448:
    label453:
    label458:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      i = bool1;
      return;
      d.d();
      break;
      i1 = 0;
      break label328;
      bool1 = false;
      break label388;
    }
  }
  
  private final void u()
  {
    if (i == null) {
      Log.e("RecyclerView", "No adapter attached; skipping layout");
    }
    for (;;)
    {
      return;
      if (j == null)
      {
        Log.e("RecyclerView", "No layout manager attached; skipping layout");
        return;
      }
      A.k = false;
      label115:
      Object localObject1;
      long l1;
      Object localObject3;
      Object localObject2;
      boolean bool1;
      boolean bool2;
      if (A.b == 1)
      {
        v();
        j.b(this);
        w();
        A.a(4);
        b();
        g();
        A.b = 1;
        if (!A.h) {
          break label725;
        }
        i1 = e.a() - 1;
        if (i1 < 0) {
          break label714;
        }
        localObject1 = b(e.b(i1));
        if (!((alj)localObject1).b())
        {
          l1 = b((alj)localObject1);
          localObject3 = new aku();
          localObject2 = a;
          a = ((View)localObject2).getLeft();
          b = ((View)localObject2).getTop();
          c = ((View)localObject2).getRight();
          d = ((View)localObject2).getBottom();
          localObject2 = (alj)f.b.a(l1, null);
          if ((localObject2 == null) || (((alj)localObject2).b())) {
            break label700;
          }
          bool1 = f.a((alj)localObject2);
          bool2 = f.a((alj)localObject1);
          if ((!bool1) || (localObject2 != localObject1)) {
            break label380;
          }
          f.b((alj)localObject1, (aku)localObject3);
        }
      }
      for (;;)
      {
        i1 -= 1;
        break label115;
        localObject1 = d;
        if ((!b.isEmpty()) && (!a.isEmpty())) {}
        for (i1 = 1;; i1 = 0)
        {
          if ((i1 == 0) && (j.q == getWidth()) && (j.r == getHeight())) {
            break label369;
          }
          j.b(this);
          w();
          break;
        }
        label369:
        j.b(this);
        break;
        label380:
        aku localaku = f.a((alj)localObject2, 4);
        f.b((alj)localObject1, (aku)localObject3);
        localObject3 = f.a((alj)localObject1, 8);
        if (localaku == null)
        {
          int i3 = e.a();
          i2 = 0;
          while (i2 < i3)
          {
            localObject3 = b(e.b(i2));
            if ((localObject3 != localObject1) && (b((alj)localObject3) == l1))
            {
              if ((i != null) && (i.a)) {
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + localObject3 + " \n View Holder 2:" + localObject1);
              }
              throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + localObject3 + " \n View Holder 2:" + localObject1);
            }
            i2 += 1;
          }
          Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + localObject2 + " cannot be found but it is necessary for " + localObject1);
        }
        else
        {
          ((alj)localObject2).a(false);
          if (bool1) {
            a((alj)localObject2);
          }
          if (localObject2 != localObject1)
          {
            if (bool2) {
              a((alj)localObject1);
            }
            g = ((alj)localObject1);
            a((alj)localObject2);
            c.b((alj)localObject2);
            ((alj)localObject1).a(false);
            h = ((alj)localObject2);
          }
          if (x.a((alj)localObject2, (alj)localObject1, localaku, (aku)localObject3))
          {
            j();
            continue;
            label700:
            f.b((alj)localObject1, (aku)localObject3);
          }
        }
      }
      label714:
      f.a(aq);
      label725:
      j.b(c);
      A.d = A.c;
      s = false;
      A.h = false;
      A.i = false;
      j.k = false;
      if (c.b != null) {
        c.b.clear();
      }
      h();
      a(false);
      f.a();
      int i1 = ak[0];
      int i2 = ak[1];
      if (e.a() == 0) {
        if ((i1 != 0) || (i2 != 0)) {
          i1 = 1;
        }
      }
      while (i1 != 0)
      {
        k();
        return;
        i1 = 0;
        continue;
        a(ak);
        if ((ak[0] != i1) || (ak[1] != i2)) {
          i1 = 1;
        } else {
          i1 = 0;
        }
      }
    }
  }
  
  private final void v()
  {
    A.a(1);
    A.k = false;
    b();
    f.a();
    g();
    t();
    Object localObject1 = A;
    if ((A.h) && (C)) {}
    int i2;
    int i1;
    Object localObject2;
    Object localObject3;
    for (boolean bool = true;; bool = false)
    {
      j = bool;
      C = false;
      B = false;
      A.g = A.i;
      A.c = i.b();
      a(ak);
      if (!A.h) {
        break;
      }
      i2 = e.a();
      i1 = 0;
      while (i1 < i2)
      {
        localObject1 = b(e.b(i1));
        if ((!((alj)localObject1).b()) && ((!((alj)localObject1).i()) || (i.a)))
        {
          aks.d((alj)localObject1);
          ((alj)localObject1).o();
          localObject2 = new aku();
          localObject3 = a;
          a = ((View)localObject3).getLeft();
          b = ((View)localObject3).getTop();
          c = ((View)localObject3).getRight();
          d = ((View)localObject3).getBottom();
          f.a((alj)localObject1, (aku)localObject2);
          if ((A.j) && (((alj)localObject1).r()) && (!((alj)localObject1).l()) && (!((alj)localObject1).b()) && (!((alj)localObject1).i()))
          {
            long l1 = b((alj)localObject1);
            f.a(l1, (alj)localObject1);
          }
        }
        i1 += 1;
      }
    }
    if (A.i)
    {
      i2 = e.b();
      i1 = 0;
      while (i1 < i2)
      {
        localObject1 = b(e.c(i1));
        if ((!((alj)localObject1).b()) && (c == -1)) {
          c = b;
        }
        i1 += 1;
      }
      bool = A.f;
      A.f = false;
      j.a(c, A);
      A.f = bool;
      i1 = 0;
      if (i1 < e.a())
      {
        localObject3 = b(e.b(i1));
        label507:
        aku localaku;
        if (!((alj)localObject3).b())
        {
          localObject1 = (anc)f.a.get(localObject3);
          if ((localObject1 == null) || ((a & 0x4) == 0)) {
            break label607;
          }
          i2 = 1;
          if (i2 == 0)
          {
            aks.d((alj)localObject3);
            bool = ((alj)localObject3).a(8192);
            ((alj)localObject3).o();
            localaku = new aku();
            localObject1 = a;
            a = ((View)localObject1).getLeft();
            b = ((View)localObject1).getTop();
            c = ((View)localObject1).getRight();
            d = ((View)localObject1).getBottom();
            if (!bool) {
              break label612;
            }
            a((alj)localObject3, localaku);
          }
        }
        for (;;)
        {
          i1 += 1;
          break;
          label607:
          i2 = 0;
          break label507;
          label612:
          anb localanb = f;
          localObject2 = (anc)a.get(localObject3);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = anc.a();
            a.put(localObject3, localObject1);
          }
          a |= 0x2;
          b = localaku;
        }
      }
      x();
    }
    for (;;)
    {
      h();
      a(false);
      A.b = 2;
      return;
      x();
    }
  }
  
  private final void w()
  {
    b();
    g();
    A.a(6);
    d.d();
    A.c = i.b();
    A.e = 0;
    A.g = false;
    j.a(c, A);
    A.f = false;
    J = null;
    alg localalg = A;
    if ((A.h) && (x != null)) {}
    for (boolean bool = true;; bool = false)
    {
      h = bool;
      A.b = 4;
      h();
      a(false);
      return;
    }
  }
  
  private final void x()
  {
    int i2 = 0;
    int i3 = e.b();
    int i1 = 0;
    while (i1 < i3)
    {
      localObject = b(e.c(i1));
      if (!((alj)localObject).b()) {
        ((alj)localObject).a();
      }
      i1 += 1;
    }
    Object localObject = c;
    i3 = c.size();
    i1 = 0;
    while (i1 < i3)
    {
      ((alj)c.get(i1)).a();
      i1 += 1;
    }
    i3 = a.size();
    i1 = 0;
    while (i1 < i3)
    {
      ((alj)a.get(i1)).a();
      i1 += 1;
    }
    if (b != null)
    {
      i3 = b.size();
      i1 = i2;
      while (i1 < i3)
      {
        ((alj)b.get(i1)).a();
        i1 += 1;
      }
    }
  }
  
  private final qr y()
  {
    if (al == null) {
      al = new qr(this);
    }
    return al;
  }
  
  public final alj a(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent != null) && (localViewParent != this)) {
      throw new IllegalArgumentException("View " + paramView + " is not a direct child of " + this);
    }
    return b(paramView);
  }
  
  public final void a()
  {
    int i3 = 0;
    if (!o) {}
    label160:
    label167:
    do
    {
      do
      {
        return;
        if (s)
        {
          mn.a("RV FullInvalidate");
          u();
          mn.a();
          return;
        }
      } while (!d.c());
      if ((d.a(4)) && (!d.a(11)))
      {
        mn.a("RV PartialInvalidate");
        b();
        d.a();
        int i1;
        if (!p)
        {
          int i4 = e.a();
          i1 = 0;
          int i2 = i3;
          if (i1 < i4)
          {
            alj localalj = b(e.b(i1));
            if ((localalj == null) || (localalj.b()) || (!localalj.r())) {
              break label160;
            }
            i2 = 1;
          }
          if (i2 == 0) {
            break label167;
          }
          u();
        }
        for (;;)
        {
          a(true);
          mn.a();
          return;
          i1 += 1;
          break;
          d.b();
        }
      }
    } while (!d.c());
    mn.a("RV FullInvalidate");
    u();
    mn.a();
  }
  
  public final void a(int paramInt)
  {
    if (paramInt == y) {}
    for (;;)
    {
      return;
      y = paramInt;
      if (paramInt != 2) {
        n();
      }
      if (j != null) {
        j.f(paramInt);
      }
      c(paramInt);
      if (ah != null)
      {
        paramInt = ah.size() - 1;
        while (paramInt >= 0)
        {
          ah.get(paramInt);
          paramInt -= 1;
        }
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (t != null)
    {
      bool1 = bool2;
      if (!t.a())
      {
        bool1 = bool2;
        if (paramInt1 > 0) {
          bool1 = t.c();
        }
      }
    }
    bool2 = bool1;
    if (v != null)
    {
      bool2 = bool1;
      if (!v.a())
      {
        bool2 = bool1;
        if (paramInt1 < 0) {
          bool2 = bool1 | v.c();
        }
      }
    }
    bool1 = bool2;
    if (u != null)
    {
      bool1 = bool2;
      if (!u.a())
      {
        bool1 = bool2;
        if (paramInt2 > 0) {
          bool1 = bool2 | u.c();
        }
      }
    }
    bool2 = bool1;
    if (w != null)
    {
      bool2 = bool1;
      if (!w.a())
      {
        bool2 = bool1;
        if (paramInt2 < 0) {
          bool2 = bool1 | w.c();
        }
      }
    }
    if (bool2) {
      rg.c(this);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i2 = e.b();
    int i1 = 0;
    if (i1 < i2)
    {
      localObject = b(e.c(i1));
      if ((localObject != null) && (!((alj)localObject).b()))
      {
        if (b < paramInt1 + paramInt2) {
          break label82;
        }
        ((alj)localObject).a(-paramInt2, paramBoolean);
        A.f = true;
      }
      for (;;)
      {
        i1 += 1;
        break;
        label82:
        if (b >= paramInt1)
        {
          int i3 = -paramInt2;
          ((alj)localObject).b(8);
          ((alj)localObject).a(i3, paramBoolean);
          b = (paramInt1 - 1);
          A.f = true;
        }
      }
    }
    Object localObject = c;
    i1 = c.size() - 1;
    if (i1 >= 0)
    {
      alj localalj = (alj)c.get(i1);
      if (localalj != null)
      {
        if (b < paramInt1 + paramInt2) {
          break label200;
        }
        localalj.a(-paramInt2, paramBoolean);
      }
      for (;;)
      {
        i1 -= 1;
        break;
        label200:
        if (b >= paramInt1)
        {
          localalj.b(8);
          ((ala)localObject).a(i1);
        }
      }
    }
    requestLayout();
  }
  
  public void a(akw paramakw)
  {
    if (paramakw == j) {
      return;
    }
    m();
    if (j != null)
    {
      if (L) {
        j.b(this, c);
      }
      j.a(null);
    }
    c.a();
    ahr localahr = e;
    for (ahs localahs = b;; localahs = b)
    {
      a = 0L;
      if (b == null) {
        break;
      }
    }
    int i1 = c.size() - 1;
    while (i1 >= 0)
    {
      a.d((View)c.get(i1));
      c.remove(i1);
      i1 -= 1;
    }
    a.b();
    j = paramakw;
    if (paramakw != null)
    {
      if (i != null) {
        throw new IllegalArgumentException("LayoutManager " + paramakw + " is already attached to a RecyclerView: " + i);
      }
      j.a(this);
      if (L) {
        j.l = true;
      }
    }
    requestLayout();
  }
  
  public final void a(alj paramalj)
  {
    View localView = a;
    if (localView.getParent() == this) {}
    for (int i1 = 1;; i1 = 0)
    {
      c.b(a(localView));
      if (!paramalj.m()) {
        break;
      }
      e.a(localView, -1, localView.getLayoutParams(), true);
      return;
    }
    if (i1 == 0)
    {
      e.a(localView, -1, true);
      return;
    }
    paramalj = e;
    i1 = a.a(localView);
    if (i1 < 0) {
      throw new IllegalArgumentException("view is not a child, cannot hide " + localView);
    }
    b.a(i1);
    paramalj.a(localView);
  }
  
  final void a(alj paramalj, aku paramaku)
  {
    paramalj.a(0, 8192);
    if ((A.j) && (paramalj.r()) && (!paramalj.l()) && (!paramalj.b()))
    {
      long l1 = b(paramalj);
      f.a(l1, paramalj);
    }
    f.a(paramalj, paramaku);
  }
  
  public final void a(String paramString)
  {
    if (r())
    {
      if (paramString == null) {
        throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
      }
      throw new IllegalStateException(paramString);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if (N <= 0) {
      N = 1;
    }
    if (!paramBoolean) {
      p = false;
    }
    if (N == 1)
    {
      if ((paramBoolean) && (p) && (!q) && (j != null) && (i != null)) {
        u();
      }
      if (!q) {
        p = false;
      }
    }
    N -= 1;
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    super.addFocusables(paramArrayList, paramInt1, paramInt2);
  }
  
  public final void b()
  {
    N += 1;
    if ((N == 1) && (!q)) {
      p = false;
    }
  }
  
  public final void b(int paramInt)
  {
    if (j == null) {
      return;
    }
    j.b(paramInt);
    awakenScrollBars();
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(akw.a(paramInt1, getPaddingLeft() + getPaddingRight(), rg.o(this)), akw.a(paramInt2, getPaddingTop() + getPaddingBottom(), rg.p(this)));
  }
  
  public final void c()
  {
    if (t != null) {
      return;
    }
    t = new wu(getContext());
    if (g)
    {
      t.a(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    t.a(getMeasuredHeight(), getMeasuredWidth());
  }
  
  public void c(int paramInt) {}
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof akx)) && (j.a((akx)paramLayoutParams));
  }
  
  public int computeHorizontalScrollExtent()
  {
    if (j == null) {}
    while (!j.c()) {
      return 0;
    }
    return j.c(A);
  }
  
  public int computeHorizontalScrollOffset()
  {
    if (j == null) {}
    while (!j.c()) {
      return 0;
    }
    return j.a(A);
  }
  
  public int computeHorizontalScrollRange()
  {
    if (j == null) {}
    while (!j.c()) {
      return 0;
    }
    return j.e(A);
  }
  
  public int computeVerticalScrollExtent()
  {
    if (j == null) {}
    while (!j.d()) {
      return 0;
    }
    return j.d(A);
  }
  
  public int computeVerticalScrollOffset()
  {
    if (j == null) {}
    while (!j.d()) {
      return 0;
    }
    return j.b(A);
  }
  
  public int computeVerticalScrollRange()
  {
    if (j == null) {}
    while (!j.d()) {
      return 0;
    }
    return j.f(A);
  }
  
  final Rect d(View paramView)
  {
    akx localakx = (akx)paramView.getLayoutParams();
    if (!c) {
      return b;
    }
    Rect localRect1 = b;
    localRect1.set(0, 0, 0, 0);
    int i2 = l.size();
    int i1 = 0;
    while (i1 < i2)
    {
      h.set(0, 0, 0, 0);
      l.get(i1);
      Rect localRect2 = h;
      getLayoutParamsa.c();
      localRect2.set(0, 0, 0, 0);
      left += h.left;
      top += h.top;
      right += h.right;
      bottom += h.bottom;
      i1 += 1;
    }
    c = false;
    return localRect1;
  }
  
  public final void d()
  {
    if (v != null) {
      return;
    }
    v = new wu(getContext());
    if (g)
    {
      v.a(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    v.a(getMeasuredHeight(), getMeasuredWidth());
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return y().a(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return y().a(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return y().a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return y().a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchThawSelfOnly(paramSparseArray);
  }
  
  protected void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchFreezeSelfOnly(paramSparseArray);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i3 = 1;
    int i4 = 0;
    super.draw(paramCanvas);
    int i2 = l.size();
    int i1 = 0;
    while (i1 < i2)
    {
      l.get(i1);
      i1 += 1;
    }
    int i5;
    if ((t != null) && (!t.a()))
    {
      i5 = paramCanvas.save();
      if (g)
      {
        i1 = getPaddingBottom();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(i1 + -getHeight(), 0.0F);
        if ((t == null) || (!t.a(paramCanvas))) {
          break label445;
        }
        i2 = 1;
        label117:
        paramCanvas.restoreToCount(i5);
      }
    }
    for (;;)
    {
      i1 = i2;
      if (u != null)
      {
        i1 = i2;
        if (!u.a())
        {
          i5 = paramCanvas.save();
          if (g) {
            paramCanvas.translate(getPaddingLeft(), getPaddingTop());
          }
          if ((u == null) || (!u.a(paramCanvas))) {
            break label450;
          }
          i1 = 1;
          label191:
          i1 = i2 | i1;
          paramCanvas.restoreToCount(i5);
        }
      }
      i2 = i1;
      if (v != null)
      {
        i2 = i1;
        if (!v.a())
        {
          i5 = paramCanvas.save();
          int i6 = getWidth();
          if (!g) {
            break label455;
          }
          i2 = getPaddingTop();
          label246:
          paramCanvas.rotate(90.0F);
          paramCanvas.translate(-i2, -i6);
          if ((v == null) || (!v.a(paramCanvas))) {
            break label460;
          }
          i2 = 1;
          label284:
          i2 = i1 | i2;
          paramCanvas.restoreToCount(i5);
        }
      }
      i1 = i2;
      if (w != null)
      {
        i1 = i2;
        if (!w.a())
        {
          i5 = paramCanvas.save();
          paramCanvas.rotate(180.0F);
          if (!g) {
            break label465;
          }
          paramCanvas.translate(-getWidth() + getPaddingRight(), -getHeight() + getPaddingBottom());
          label361:
          i1 = i4;
          if (w != null)
          {
            i1 = i4;
            if (w.a(paramCanvas)) {
              i1 = 1;
            }
          }
          i1 = i2 | i1;
          paramCanvas.restoreToCount(i5);
        }
      }
      if ((i1 == 0) && (x != null) && (l.size() > 0) && (x.b())) {
        i1 = i3;
      }
      for (;;)
      {
        if (i1 != 0) {
          rg.c(this);
        }
        return;
        i1 = 0;
        break;
        label445:
        i2 = 0;
        break label117;
        label450:
        i1 = 0;
        break label191;
        label455:
        i2 = 0;
        break label246;
        label460:
        i2 = 0;
        break label284;
        label465:
        paramCanvas.translate(-getWidth(), -getHeight());
        break label361;
      }
      i2 = 0;
    }
  }
  
  public boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  public final void e()
  {
    if (u != null) {
      return;
    }
    u = new wu(getContext());
    if (g)
    {
      u.a(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    u.a(getMeasuredWidth(), getMeasuredHeight());
  }
  
  public final void e(View paramView)
  {
    b(paramView);
    if (r != null)
    {
      int i1 = r.size() - 1;
      while (i1 >= 0)
      {
        r.get(i1);
        i1 -= 1;
      }
    }
  }
  
  public final void f()
  {
    if (w != null) {
      return;
    }
    w = new wu(getContext());
    if (g)
    {
      w.a(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    w.a(getMeasuredWidth(), getMeasuredHeight());
  }
  
  public View focusSearch(View paramView, int paramInt)
  {
    View localView2 = FocusFinder.getInstance().findNextFocus(this, paramView, paramInt);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = localView2;
      if (i != null)
      {
        localView1 = localView2;
        if (j != null)
        {
          localView1 = localView2;
          if (!r())
          {
            localView1 = localView2;
            if (!q)
            {
              b();
              localView1 = j.a(paramView, paramInt, c, A);
              a(false);
            }
          }
        }
      }
    }
    if (localView1 != null) {
      return localView1;
    }
    return super.focusSearch(paramView, paramInt);
  }
  
  public final void g()
  {
    T += 1;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    if (j == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager");
    }
    return j.a();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    if (j == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager");
    }
    return j.a(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (j == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager");
    }
    return j.a(paramLayoutParams);
  }
  
  public int getBaseline()
  {
    if (j != null) {
      return -1;
    }
    return super.getBaseline();
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (aj == null) {
      return super.getChildDrawingOrder(paramInt1, paramInt2);
    }
    return aj.a();
  }
  
  public final void h()
  {
    T -= 1;
    if (T <= 0)
    {
      T = 0;
      int i1 = P;
      P = 0;
      if ((i1 != 0) && (i()))
      {
        AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain();
        localAccessibilityEvent.setEventType(2048);
        ub.a.a(localAccessibilityEvent, i1);
        sendAccessibilityEventUnchecked(localAccessibilityEvent);
      }
    }
  }
  
  public boolean hasNestedScrollingParent()
  {
    return y().a();
  }
  
  final boolean i()
  {
    return (S != null) && (S.isEnabled());
  }
  
  public boolean isAttachedToWindow()
  {
    return L;
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return ya;
  }
  
  public final void j()
  {
    if ((!D) && (L))
    {
      rg.a(this, ap);
      D = true;
    }
  }
  
  public final void k()
  {
    int i1 = getScrollX();
    int i2 = getScrollY();
    onScrollChanged(i1, i2, i1, i2);
    if (ah != null)
    {
      i1 = ah.size() - 1;
      while (i1 >= 0)
      {
        ah.get(i1);
        i1 -= 1;
      }
    }
  }
  
  public final void l()
  {
    int i2 = e.a();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = e.b(i1);
      Object localObject = a(localView);
      if ((localObject != null) && (h != null))
      {
        localObject = h.a;
        int i3 = localView.getLeft();
        int i4 = localView.getTop();
        if ((i3 != ((View)localObject).getLeft()) || (i4 != ((View)localObject).getTop())) {
          ((View)localObject).layout(i3, i4, ((View)localObject).getWidth() + i3, ((View)localObject).getHeight() + i4);
        }
      }
      i1 += 1;
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    T = 0;
    L = true;
    o = false;
    if (j != null) {
      j.l = true;
    }
    D = false;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (x != null) {
      x.d();
    }
    o = false;
    m();
    L = false;
    if (j != null) {
      j.b(this, c);
    }
    removeCallbacks(ap);
    while (anc.d.a() != null) {}
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i2 = l.size();
    int i1 = 0;
    while (i1 < i2)
    {
      l.get(i1);
      i1 += 1;
    }
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    float f3 = 0.0F;
    if (j == null) {}
    label170:
    label173:
    for (;;)
    {
      return false;
      if ((!q) && ((qk.d(paramMotionEvent) & 0x2) != 0) && (paramMotionEvent.getAction() == 8))
      {
        float f1;
        if (j.d())
        {
          f1 = -qk.e(paramMotionEvent, 9);
          if (!j.c()) {
            break label170;
          }
        }
        for (float f2 = qk.e(paramMotionEvent, 10);; f2 = 0.0F)
        {
          if ((f1 == 0.0F) && (f2 == 0.0F)) {
            break label173;
          }
          if (ag == Float.MIN_VALUE)
          {
            TypedValue localTypedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(16842829, localTypedValue, true)) {
              ag = localTypedValue.getDimension(getContext().getResources().getDisplayMetrics());
            }
          }
          else
          {
            f3 = ag;
          }
          a((int)(f2 * f3), (int)(f1 * f3), paramMotionEvent);
          return false;
          f1 = 0.0F;
          break;
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i3 = -1;
    boolean bool1 = true;
    if (q)
    {
      bool1 = false;
      return bool1;
    }
    int i2 = paramMotionEvent.getAction();
    if ((i2 == 3) || (i2 == 0)) {
      n = null;
    }
    int i4 = m.size();
    int i1 = 0;
    if (i1 < i4)
    {
      aky localaky = (aky)m.get(i1);
      if ((localaky.a()) && (i2 != 3)) {
        n = localaky;
      }
    }
    for (i1 = 1;; i1 = 0)
    {
      if (i1 == 0) {
        break label113;
      }
      q();
      return true;
      i1 += 1;
      break;
    }
    label113:
    if (j == null) {
      return false;
    }
    boolean bool2 = j.c();
    boolean bool3 = j.d();
    if (V == null) {
      V = VelocityTracker.obtain();
    }
    V.addMovement(paramMotionEvent);
    i2 = qk.a(paramMotionEvent);
    i1 = qk.b(paramMotionEvent);
    switch (i2)
    {
    case 4: 
    default: 
      if (y != 1) {
        return false;
      }
      break;
    case 0: 
      label216:
      if (O) {
        O = false;
      }
      U = qk.b(paramMotionEvent, 0);
      i1 = (int)(paramMotionEvent.getX() + 0.5F);
      ab = i1;
      W = i1;
      i1 = (int)(paramMotionEvent.getY() + 0.5F);
      ac = i1;
      aa = i1;
      if (y == 2)
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        a(1);
      }
      paramMotionEvent = ao;
      ao[1] = 0;
      paramMotionEvent[0] = 0;
      if (!bool2) {}
      break;
    }
    for (i1 = 1;; i1 = 0)
    {
      i2 = i1;
      if (bool3) {
        i2 = i1 | 0x2;
      }
      startNestedScroll(i2);
      break label216;
      U = qk.b(paramMotionEvent, i1);
      i2 = (int)(qk.c(paramMotionEvent, i1) + 0.5F);
      ab = i2;
      W = i2;
      i1 = (int)(qk.d(paramMotionEvent, i1) + 0.5F);
      ac = i1;
      aa = i1;
      break label216;
      i2 = qk.a(paramMotionEvent, U);
      if (i2 < 0)
      {
        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + U + " not found. Did any MotionEvents get skipped?");
        return false;
      }
      i1 = (int)(qk.c(paramMotionEvent, i2) + 0.5F);
      i2 = (int)(qk.d(paramMotionEvent, i2) + 0.5F);
      if (y == 1) {
        break label216;
      }
      i1 -= W;
      i4 = i2 - aa;
      int i5;
      if ((bool2) && (Math.abs(i1) > ad))
      {
        i2 = W;
        i5 = ad;
        if (i1 < 0)
        {
          i1 = -1;
          label533:
          ab = (i1 * i5 + i2);
        }
      }
      for (i1 = 1;; i1 = 0)
      {
        i2 = i1;
        if (bool3)
        {
          i2 = i1;
          if (Math.abs(i4) > ad)
          {
            i2 = aa;
            i5 = ad;
            if (i4 >= 0) {
              break label614;
            }
          }
        }
        label614:
        for (i1 = i3;; i1 = 1)
        {
          ac = (i2 + i1 * i5);
          i2 = 1;
          if (i2 == 0) {
            break;
          }
          a(1);
          break;
          i1 = 1;
          break label533;
        }
        a(paramMotionEvent);
        break label216;
        V.clear();
        stopNestedScroll();
        break label216;
        q();
        break label216;
        break;
      }
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    mn.a("RV OnLayout");
    u();
    mn.a();
    o = true;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i2 = 0;
    if (j == null) {
      b(paramInt1, paramInt2);
    }
    do
    {
      int i1;
      do
      {
        return;
        if (!j.m) {
          break;
        }
        int i3 = View.MeasureSpec.getMode(paramInt1);
        int i4 = View.MeasureSpec.getMode(paramInt2);
        i1 = i2;
        if (i3 == 1073741824)
        {
          i1 = i2;
          if (i4 == 1073741824) {
            i1 = 1;
          }
        }
        j.g(paramInt1, paramInt2);
      } while ((i1 != 0) || (i == null));
      if (A.b == 1) {
        v();
      }
      j.a(paramInt1, paramInt2);
      A.k = true;
      w();
      j.b(paramInt1, paramInt2);
    } while (!j.e());
    j.a(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
    A.k = true;
    w();
    j.b(paramInt1, paramInt2);
    return;
    if (M)
    {
      j.g(paramInt1, paramInt2);
      return;
    }
    if (Q)
    {
      b();
      t();
      if (A.i)
      {
        A.g = true;
        Q = false;
        a(false);
      }
    }
    else
    {
      if (i == null) {
        break label313;
      }
    }
    label313:
    for (A.c = i.b();; A.c = 0)
    {
      b();
      j.g(paramInt1, paramInt2);
      a(false);
      A.g = false;
      return;
      d.d();
      A.g = false;
      break;
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof RecyclerView.SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
    }
    do
    {
      return;
      J = ((RecyclerView.SavedState)paramParcelable);
      super.onRestoreInstanceState(J.getSuperState());
    } while ((j == null) || (J.a == null));
    j.a(J.a);
  }
  
  public Parcelable onSaveInstanceState()
  {
    RecyclerView.SavedState localSavedState = new RecyclerView.SavedState(super.onSaveInstanceState());
    if (J != null)
    {
      a = J.a;
      return localSavedState;
    }
    if (j != null)
    {
      a = j.b();
      return localSavedState;
    }
    a = null;
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
      o();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i7 = 0;
    if ((q) || (O)) {}
    label133:
    label142:
    label148:
    do
    {
      return false;
      i1 = paramMotionEvent.getAction();
      if (n != null)
      {
        if (i1 == 0) {
          n = null;
        }
      }
      else
      {
        if (i1 == 0) {
          break label142;
        }
        i2 = m.size();
        i1 = 0;
        if (i1 >= i2) {
          break label142;
        }
        localObject = (aky)m.get(i1);
        if (!((aky)localObject).a()) {
          break label133;
        }
        n = ((aky)localObject);
        i1 = 1;
      }
      for (;;)
      {
        if (i1 == 0) {
          break label148;
        }
        q();
        return true;
        if ((i1 == 3) || (i1 == 1)) {
          n = null;
        }
        i1 = 1;
        continue;
        i1 += 1;
        break;
        i1 = 0;
      }
    } while (j == null);
    boolean bool1 = j.c();
    boolean bool2 = j.d();
    if (V == null) {
      V = VelocityTracker.obtain();
    }
    Object localObject = MotionEvent.obtain(paramMotionEvent);
    int i3 = qk.a(paramMotionEvent);
    int i2 = qk.b(paramMotionEvent);
    if (i3 == 0)
    {
      int[] arrayOfInt = ao;
      ao[1] = 0;
      arrayOfInt[0] = 0;
    }
    ((MotionEvent)localObject).offsetLocation(ao[0], ao[1]);
    int i1 = i7;
    switch (i3)
    {
    default: 
      i1 = i7;
    case 4: 
      if (i1 == 0) {
        V.addMovement((MotionEvent)localObject);
      }
      ((MotionEvent)localObject).recycle();
      return true;
    case 0: 
      U = qk.b(paramMotionEvent, 0);
      i1 = (int)(paramMotionEvent.getX() + 0.5F);
      ab = i1;
      W = i1;
      i1 = (int)(paramMotionEvent.getY() + 0.5F);
      ac = i1;
      aa = i1;
      if (!bool1) {
        break;
      }
    }
    for (i1 = 1;; i1 = 0)
    {
      i2 = i1;
      if (bool2) {
        i2 = i1 | 0x2;
      }
      startNestedScroll(i2);
      i1 = i7;
      break;
      U = qk.b(paramMotionEvent, i2);
      i1 = (int)(qk.c(paramMotionEvent, i2) + 0.5F);
      ab = i1;
      W = i1;
      i1 = (int)(qk.d(paramMotionEvent, i2) + 0.5F);
      ac = i1;
      aa = i1;
      i1 = i7;
      break;
      i1 = qk.a(paramMotionEvent, U);
      if (i1 < 0)
      {
        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + U + " not found. Did any MotionEvents get skipped?");
        return false;
      }
      int i8 = (int)(qk.c(paramMotionEvent, i1) + 0.5F);
      int i9 = (int)(qk.d(paramMotionEvent, i1) + 0.5F);
      int i4 = ab - i8;
      i3 = ac - i9;
      i1 = i3;
      i2 = i4;
      if (dispatchNestedPreScroll(i4, i3, an, am))
      {
        i2 = i4 - an[0];
        i1 = i3 - an[1];
        ((MotionEvent)localObject).offsetLocation(am[0], am[1]);
        paramMotionEvent = ao;
        paramMotionEvent[0] += am[0];
        paramMotionEvent = ao;
        paramMotionEvent[1] += am[1];
      }
      i3 = i1;
      i4 = i2;
      if (y != 1)
      {
        if ((!bool1) || (Math.abs(i2) <= ad)) {
          break label1053;
        }
        if (i2 <= 0) {
          break label886;
        }
        i2 -= ad;
      }
      label725:
      label775:
      label847:
      label886:
      label898:
      label916:
      label976:
      label1037:
      label1053:
      for (i3 = 1;; i3 = 0)
      {
        int i5 = i1;
        int i6 = i3;
        if (bool2)
        {
          i5 = i1;
          i6 = i3;
          if (Math.abs(i1) > ad)
          {
            if (i1 <= 0) {
              break label898;
            }
            i5 = i1 - ad;
            i6 = 1;
          }
        }
        i3 = i5;
        i4 = i2;
        if (i6 != 0)
        {
          a(1);
          i4 = i2;
          i3 = i5;
        }
        i1 = i7;
        if (y != 1) {
          break;
        }
        ab = (i8 - am[0]);
        ac = (i9 - am[1]);
        if (bool1) {
          if (!bool2) {
            break label916;
          }
        }
        for (;;)
        {
          i1 = i7;
          if (!a(i4, i3, (MotionEvent)localObject)) {
            break;
          }
          getParent().requestDisallowInterceptTouchEvent(true);
          i1 = i7;
          break;
          i2 += ad;
          break label725;
          i5 = i1 + ad;
          break label775;
          i4 = 0;
          break label847;
          i3 = 0;
        }
        a(paramMotionEvent);
        i1 = i7;
        break;
        V.addMovement((MotionEvent)localObject);
        V.computeCurrentVelocity(1000, af);
        float f1;
        if (bool1)
        {
          f1 = -rc.a(V, U);
          if (!bool2) {
            break label1037;
          }
        }
        for (float f2 = -rc.b(V, U);; f2 = 0.0F)
        {
          if (((f1 == 0.0F) && (f2 == 0.0F)) || (!c((int)f1, (int)f2))) {
            a(0);
          }
          p();
          i1 = 1;
          break;
          f1 = 0.0F;
          break label976;
        }
        q();
        i1 = i7;
        break;
      }
    }
  }
  
  public void removeDetachedView(View paramView, boolean paramBoolean)
  {
    alj localalj = b(paramView);
    if (localalj != null)
    {
      if (!localalj.m()) {
        break label32;
      }
      localalj.h();
    }
    label32:
    while (localalj.b())
    {
      e(paramView);
      super.removeDetachedView(paramView, paramBoolean);
      return;
    }
    throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + localalj);
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    int i1;
    Object localObject;
    if ((j.h()) || (r()))
    {
      i1 = 1;
      if ((i1 == 0) && (paramView2 != null))
      {
        h.set(0, 0, paramView2.getWidth(), paramView2.getHeight());
        localObject = paramView2.getLayoutParams();
        if ((localObject instanceof akx))
        {
          localObject = (akx)localObject;
          if (!c)
          {
            localObject = b;
            Rect localRect = h;
            left -= left;
            localRect = h;
            right += right;
            localRect = h;
            top -= top;
            localRect = h;
            i1 = bottom;
            bottom = (bottom + i1);
          }
        }
        offsetDescendantRectToMyCoords(paramView2, h);
        offsetRectIntoDescendantCoords(paramView1, h);
        localObject = h;
        if (o) {
          break label226;
        }
      }
    }
    label226:
    for (boolean bool = true;; bool = false)
    {
      requestChildRectangleOnScreen(paramView1, (Rect)localObject, bool);
      super.requestChildFocus(paramView1, paramView2);
      return;
      i1 = 0;
      break;
    }
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    akw localakw = j;
    int i7 = localakw.j();
    int i4 = localakw.k();
    int i8 = q - localakw.l();
    int i6 = r;
    int i11 = localakw.m();
    int i9 = paramView.getLeft() + left - paramView.getScrollX();
    int i5 = paramView.getTop() + top - paramView.getScrollY();
    int i10 = i9 + paramRect.width();
    int i12 = paramRect.height();
    int i1 = Math.min(0, i9 - i7);
    int i2 = Math.min(0, i5 - i4);
    int i3 = Math.max(0, i10 - i8);
    i6 = Math.max(0, i5 + i12 - (i6 - i11));
    if (rg.g(i) == 1) {
      if (i3 != 0)
      {
        i1 = i3;
        if (i2 == 0) {
          break label232;
        }
        label170:
        if ((i1 == 0) && (i2 == 0)) {
          break label324;
        }
        if (!paramBoolean) {
          break label247;
        }
        scrollBy(i1, i2);
      }
    }
    for (;;)
    {
      return true;
      i1 = Math.max(i1, i10 - i8);
      break;
      if (i1 != 0) {
        break;
      }
      i1 = Math.min(i9 - i7, i3);
      break;
      label232:
      i2 = Math.min(i5 - i4, i6);
      break label170;
      label247:
      if (j == null)
      {
        Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      }
      else if (!q)
      {
        if (!j.c()) {
          i1 = 0;
        }
        if (!j.d()) {
          i2 = 0;
        }
        if ((i1 != 0) || (i2 != 0)) {
          z.a(i1, i2);
        }
      }
    }
    label324:
    return false;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    int i2 = m.size();
    int i1 = 0;
    while (i1 < i2)
    {
      m.get(i1);
      i1 += 1;
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    if ((N == 0) && (!q))
    {
      super.requestLayout();
      return;
    }
    p = true;
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    if (j == null) {}
    boolean bool1;
    boolean bool2;
    do
    {
      Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      do
      {
        return;
      } while (q);
      bool1 = j.c();
      bool2 = j.d();
    } while ((!bool1) && (!bool2));
    if (bool1) {
      if (!bool2) {
        break label74;
      }
    }
    for (;;)
    {
      a(paramInt1, paramInt2, null);
      return;
      paramInt1 = 0;
      break;
      label74:
      paramInt2 = 0;
    }
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
  }
  
  public void sendAccessibilityEventUnchecked(AccessibilityEvent paramAccessibilityEvent)
  {
    int i1 = 0;
    int i2 = 0;
    if (r()) {
      if (paramAccessibilityEvent == null) {
        break label57;
      }
    }
    label57:
    for (i1 = ub.a.a(paramAccessibilityEvent);; i1 = 0)
    {
      if (i1 == 0) {
        i1 = i2;
      }
      for (;;)
      {
        P = (i1 | P);
        i1 = 1;
        if (i1 != 0) {
          return;
        }
        super.sendAccessibilityEventUnchecked(paramAccessibilityEvent);
        return;
      }
    }
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    if (paramBoolean != g) {
      o();
    }
    g = paramBoolean;
    super.setClipToPadding(paramBoolean);
    if (o) {
      requestLayout();
    }
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    y().a(paramBoolean);
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return y().a(paramInt);
  }
  
  public void stopNestedScroll()
  {
    y().b();
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.RecyclerView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */