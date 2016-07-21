package org.apache.commons.logging;

import idm;
import idn;
import ido;
import idp;
import idq;
import idr;
import ids;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.security.AccessController;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

public abstract class LogFactory
{
  public static final String DIAGNOSTICS_DEST_PROPERTY = "org.apache.commons.logging.diagnostics.dest";
  public static final String FACTORY_DEFAULT = "org.apache.commons.logging.impl.LogFactoryImpl";
  public static final String FACTORY_PROPERTIES = "commons-logging.properties";
  public static final String FACTORY_PROPERTY = "org.apache.commons.logging.LogFactory";
  public static final String HASHTABLE_IMPLEMENTATION_PROPERTY = "org.apache.commons.logging.LogFactory.HashtableImpl";
  public static final String PRIORITY_KEY = "priority";
  public static final String SERVICE_ID = "META-INF/services/org.apache.commons.logging.LogFactory";
  public static final String TCCL_KEY = "use_tccl";
  private static final String WEAK_HASHTABLE_CLASSNAME = "org.apache.commons.logging.impl.WeakHashtable";
  static Class class$org$apache$commons$logging$LogFactory;
  private static final String diagnosticPrefix;
  private static PrintStream diagnosticsStream = null;
  public static Hashtable factories = null;
  public static volatile LogFactory nullClassLoaderFactory = null;
  private static final ClassLoader thisClassLoader;
  
  static
  {
    Object localObject1;
    if (class$org$apache$commons$logging$LogFactory == null)
    {
      localObject1 = class$("org.apache.commons.logging.LogFactory");
      class$org$apache$commons$logging$LogFactory = (Class)localObject1;
      thisClassLoader = getClassLoader((Class)localObject1);
    }
    for (;;)
    {
      try
      {
        localObject1 = thisClassLoader;
        if (thisClassLoader != null) {
          continue;
        }
        localObject1 = "BOOTLOADER";
      }
      catch (SecurityException localSecurityException)
      {
        Object localObject2 = "UNKNOWN";
        continue;
        localObject2 = class$org$apache$commons$logging$LogFactory;
        continue;
      }
      diagnosticPrefix = "[LogFactory from " + (String)localObject1 + "] ";
      diagnosticsStream = initDiagnostics();
      if (class$org$apache$commons$logging$LogFactory != null) {
        continue;
      }
      localObject1 = class$("org.apache.commons.logging.LogFactory");
      class$org$apache$commons$logging$LogFactory = (Class)localObject1;
      logClassLoaderEnvironment((Class)localObject1);
      factories = createFactoryStore();
      if (isDiagnosticsEnabled()) {
        logDiagnostic("BOOTSTRAP COMPLETED");
      }
      return;
      localObject1 = class$org$apache$commons$logging$LogFactory;
      break;
      localObject1 = objectId(localObject1);
    }
  }
  
  public static void access$000(String paramString)
  {
    logDiagnostic(paramString);
  }
  
  private static void cacheFactory(ClassLoader paramClassLoader, LogFactory paramLogFactory)
  {
    if (paramLogFactory != null)
    {
      if (paramClassLoader == null) {
        nullClassLoaderFactory = paramLogFactory;
      }
    }
    else {
      return;
    }
    factories.put(paramClassLoader, paramLogFactory);
  }
  
  static Class class$(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      throw new NoClassDefFoundError(paramString.getMessage());
    }
  }
  
  /* Error */
  public static Object createFactory(String paramString, ClassLoader paramClassLoader)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 6
    //   12: aload_1
    //   13: ifnull +888 -> 901
    //   16: aload_1
    //   17: aload_0
    //   18: invokevirtual 150	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   21: astore 4
    //   23: aload 4
    //   25: astore 6
    //   27: aload 4
    //   29: astore_3
    //   30: aload 4
    //   32: astore 7
    //   34: aload 4
    //   36: astore 5
    //   38: getstatic 55	org/apache/commons/logging/LogFactory:class$org$apache$commons$logging$LogFactory	Ljava/lang/Class;
    //   41: ifnonnull +165 -> 206
    //   44: aload 4
    //   46: astore 6
    //   48: aload 4
    //   50: astore_3
    //   51: aload 4
    //   53: astore 7
    //   55: aload 4
    //   57: astore 5
    //   59: ldc 17
    //   61: invokestatic 59	org/apache/commons/logging/LogFactory:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   64: astore 8
    //   66: aload 4
    //   68: astore 6
    //   70: aload 4
    //   72: astore_3
    //   73: aload 4
    //   75: astore 7
    //   77: aload 4
    //   79: astore 5
    //   81: aload 8
    //   83: putstatic 55	org/apache/commons/logging/LogFactory:class$org$apache$commons$logging$LogFactory	Ljava/lang/Class;
    //   86: aload 4
    //   88: astore 6
    //   90: aload 4
    //   92: astore_3
    //   93: aload 4
    //   95: astore 7
    //   97: aload 4
    //   99: astore 5
    //   101: aload 8
    //   103: aload 4
    //   105: invokevirtual 154	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   108: ifeq +121 -> 229
    //   111: aload 4
    //   113: astore 6
    //   115: aload 4
    //   117: astore_3
    //   118: aload 4
    //   120: astore 7
    //   122: aload 4
    //   124: astore 5
    //   126: invokestatic 103	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   129: ifeq +53 -> 182
    //   132: aload 4
    //   134: astore 6
    //   136: aload 4
    //   138: astore_3
    //   139: aload 4
    //   141: astore 7
    //   143: aload 4
    //   145: astore 5
    //   147: new 69	java/lang/StringBuffer
    //   150: dup
    //   151: ldc -100
    //   153: invokespecial 75	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   156: aload 4
    //   158: invokevirtual 159	java/lang/Class:getName	()Ljava/lang/String;
    //   161: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   164: ldc -95
    //   166: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   169: aload_1
    //   170: invokestatic 112	org/apache/commons/logging/LogFactory:objectId	(Ljava/lang/Object;)Ljava/lang/String;
    //   173: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   176: invokevirtual 85	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   179: invokestatic 108	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   182: aload 4
    //   184: astore 6
    //   186: aload 4
    //   188: astore_3
    //   189: aload 4
    //   191: astore 7
    //   193: aload 4
    //   195: astore 5
    //   197: aload 4
    //   199: invokevirtual 165	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   202: checkcast 2	org/apache/commons/logging/LogFactory
    //   205: areturn
    //   206: aload 4
    //   208: astore 6
    //   210: aload 4
    //   212: astore_3
    //   213: aload 4
    //   215: astore 7
    //   217: aload 4
    //   219: astore 5
    //   221: getstatic 55	org/apache/commons/logging/LogFactory:class$org$apache$commons$logging$LogFactory	Ljava/lang/Class;
    //   224: astore 8
    //   226: goto -140 -> 86
    //   229: aload 4
    //   231: astore 6
    //   233: aload 4
    //   235: astore_3
    //   236: aload 4
    //   238: astore 7
    //   240: aload 4
    //   242: astore 5
    //   244: invokestatic 103	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   247: ifeq -65 -> 182
    //   250: aload 4
    //   252: astore 6
    //   254: aload 4
    //   256: astore_3
    //   257: aload 4
    //   259: astore 7
    //   261: aload 4
    //   263: astore 5
    //   265: new 69	java/lang/StringBuffer
    //   268: dup
    //   269: ldc -89
    //   271: invokespecial 75	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   274: aload 4
    //   276: invokevirtual 159	java/lang/Class:getName	()Ljava/lang/String;
    //   279: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   282: ldc -87
    //   284: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   287: aload 4
    //   289: invokevirtual 172	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   292: invokestatic 112	org/apache/commons/logging/LogFactory:objectId	(Ljava/lang/Object;)Ljava/lang/String;
    //   295: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   298: ldc -82
    //   300: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   303: astore 9
    //   305: aload 4
    //   307: astore 6
    //   309: aload 4
    //   311: astore_3
    //   312: aload 4
    //   314: astore 7
    //   316: aload 4
    //   318: astore 5
    //   320: getstatic 55	org/apache/commons/logging/LogFactory:class$org$apache$commons$logging$LogFactory	Ljava/lang/Class;
    //   323: ifnonnull +223 -> 546
    //   326: aload 4
    //   328: astore 6
    //   330: aload 4
    //   332: astore_3
    //   333: aload 4
    //   335: astore 7
    //   337: aload 4
    //   339: astore 5
    //   341: ldc 17
    //   343: invokestatic 59	org/apache/commons/logging/LogFactory:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   346: astore 8
    //   348: aload 4
    //   350: astore 6
    //   352: aload 4
    //   354: astore_3
    //   355: aload 4
    //   357: astore 7
    //   359: aload 4
    //   361: astore 5
    //   363: aload 8
    //   365: putstatic 55	org/apache/commons/logging/LogFactory:class$org$apache$commons$logging$LogFactory	Ljava/lang/Class;
    //   368: aload 4
    //   370: astore 6
    //   372: aload 4
    //   374: astore_3
    //   375: aload 4
    //   377: astore 7
    //   379: aload 4
    //   381: astore 5
    //   383: aload 9
    //   385: aload 8
    //   387: invokevirtual 159	java/lang/Class:getName	()Ljava/lang/String;
    //   390: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   393: ldc -80
    //   395: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   398: invokevirtual 85	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   401: invokestatic 108	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   404: aload 4
    //   406: astore 6
    //   408: aload 4
    //   410: astore_3
    //   411: aload 4
    //   413: astore 7
    //   415: aload 4
    //   417: astore 5
    //   419: ldc -78
    //   421: aload_1
    //   422: invokestatic 182	org/apache/commons/logging/LogFactory:logHierarchy	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   425: goto -243 -> 182
    //   428: astore 5
    //   430: aload 6
    //   432: astore_3
    //   433: aload 6
    //   435: astore 4
    //   437: aload_1
    //   438: getstatic 65	org/apache/commons/logging/LogFactory:thisClassLoader	Ljava/lang/ClassLoader;
    //   441: if_acmpne +460 -> 901
    //   444: aload 6
    //   446: astore_3
    //   447: invokestatic 103	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   450: ifeq +37 -> 487
    //   453: aload 6
    //   455: astore_3
    //   456: new 69	java/lang/StringBuffer
    //   459: dup
    //   460: ldc -72
    //   462: invokespecial 75	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   465: aload_0
    //   466: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   469: ldc -70
    //   471: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   474: aload_1
    //   475: invokestatic 112	org/apache/commons/logging/LogFactory:objectId	(Ljava/lang/Object;)Ljava/lang/String;
    //   478: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   481: invokevirtual 85	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   484: invokestatic 108	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   487: aload 6
    //   489: astore_3
    //   490: aload 5
    //   492: athrow
    //   493: astore_0
    //   494: aload_3
    //   495: astore_1
    //   496: invokestatic 103	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   499: ifeq +8 -> 507
    //   502: ldc -68
    //   504: invokestatic 108	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   507: aload_1
    //   508: ifnull +459 -> 967
    //   511: getstatic 55	org/apache/commons/logging/LogFactory:class$org$apache$commons$logging$LogFactory	Ljava/lang/Class;
    //   514: ifnonnull +446 -> 960
    //   517: ldc 17
    //   519: invokestatic 59	org/apache/commons/logging/LogFactory:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   522: astore_3
    //   523: aload_3
    //   524: putstatic 55	org/apache/commons/logging/LogFactory:class$org$apache$commons$logging$LogFactory	Ljava/lang/Class;
    //   527: aload_3
    //   528: aload_1
    //   529: invokevirtual 154	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   532: ifne +435 -> 967
    //   535: new 190	idm
    //   538: dup
    //   539: ldc -64
    //   541: aload_0
    //   542: invokespecial 195	idm:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   545: areturn
    //   546: aload 4
    //   548: astore 6
    //   550: aload 4
    //   552: astore_3
    //   553: aload 4
    //   555: astore 7
    //   557: aload 4
    //   559: astore 5
    //   561: getstatic 55	org/apache/commons/logging/LogFactory:class$org$apache$commons$logging$LogFactory	Ljava/lang/Class;
    //   564: astore 8
    //   566: goto -198 -> 368
    //   569: astore 5
    //   571: aload 7
    //   573: astore_3
    //   574: aload 7
    //   576: astore 4
    //   578: aload_1
    //   579: getstatic 65	org/apache/commons/logging/LogFactory:thisClassLoader	Ljava/lang/ClassLoader;
    //   582: if_acmpne +319 -> 901
    //   585: aload 7
    //   587: astore_3
    //   588: invokestatic 103	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   591: ifeq +42 -> 633
    //   594: aload 7
    //   596: astore_3
    //   597: new 69	java/lang/StringBuffer
    //   600: dup
    //   601: ldc -59
    //   603: invokespecial 75	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   606: aload_0
    //   607: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   610: ldc -57
    //   612: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   615: aload_1
    //   616: invokestatic 112	org/apache/commons/logging/LogFactory:objectId	(Ljava/lang/Object;)Ljava/lang/String;
    //   619: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   622: ldc -55
    //   624: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   627: invokevirtual 85	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   630: invokestatic 108	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   633: aload 7
    //   635: astore_3
    //   636: aload 5
    //   638: athrow
    //   639: astore_3
    //   640: aload 5
    //   642: astore_3
    //   643: aload 5
    //   645: astore 4
    //   647: aload_1
    //   648: getstatic 65	org/apache/commons/logging/LogFactory:thisClassLoader	Ljava/lang/ClassLoader;
    //   651: if_acmpne +250 -> 901
    //   654: aload 5
    //   656: astore_3
    //   657: aload 5
    //   659: invokestatic 204	org/apache/commons/logging/LogFactory:implementsLogFactory	(Ljava/lang/Class;)Z
    //   662: istore_2
    //   663: aload 5
    //   665: astore_3
    //   666: new 69	java/lang/StringBuffer
    //   669: dup
    //   670: invokespecial 205	java/lang/StringBuffer:<init>	()V
    //   673: astore_1
    //   674: aload 5
    //   676: astore_3
    //   677: aload_1
    //   678: ldc -49
    //   680: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   683: pop
    //   684: aload 5
    //   686: astore_3
    //   687: aload_1
    //   688: ldc -47
    //   690: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   693: pop
    //   694: aload 5
    //   696: astore_3
    //   697: aload_1
    //   698: aload_0
    //   699: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   702: pop
    //   703: aload 5
    //   705: astore_3
    //   706: aload_1
    //   707: ldc -45
    //   709: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   712: pop
    //   713: aload 5
    //   715: astore_3
    //   716: getstatic 55	org/apache/commons/logging/LogFactory:class$org$apache$commons$logging$LogFactory	Ljava/lang/Class;
    //   719: ifnonnull +159 -> 878
    //   722: aload 5
    //   724: astore_3
    //   725: ldc 17
    //   727: invokestatic 59	org/apache/commons/logging/LogFactory:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   730: astore_0
    //   731: aload 5
    //   733: astore_3
    //   734: aload_0
    //   735: putstatic 55	org/apache/commons/logging/LogFactory:class$org$apache$commons$logging$LogFactory	Ljava/lang/Class;
    //   738: aload 5
    //   740: astore_3
    //   741: aload_1
    //   742: aload_0
    //   743: invokevirtual 159	java/lang/Class:getName	()Ljava/lang/String;
    //   746: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   749: pop
    //   750: aload 5
    //   752: astore_3
    //   753: aload_1
    //   754: ldc -43
    //   756: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   759: pop
    //   760: iload_2
    //   761: ifeq +127 -> 888
    //   764: aload 5
    //   766: astore_3
    //   767: aload_1
    //   768: ldc -41
    //   770: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   773: pop
    //   774: aload 5
    //   776: astore_3
    //   777: aload_1
    //   778: ldc -39
    //   780: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   783: pop
    //   784: aload 5
    //   786: astore_3
    //   787: aload_1
    //   788: ldc -37
    //   790: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   793: pop
    //   794: aload 5
    //   796: astore_3
    //   797: aload_1
    //   798: ldc -35
    //   800: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   803: pop
    //   804: aload 5
    //   806: astore_3
    //   807: aload_1
    //   808: ldc -33
    //   810: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   813: pop
    //   814: aload 5
    //   816: astore_3
    //   817: aload_1
    //   818: ldc -31
    //   820: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   823: pop
    //   824: aload 5
    //   826: astore_3
    //   827: aload_1
    //   828: ldc -29
    //   830: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   833: pop
    //   834: aload 5
    //   836: astore_3
    //   837: aload_1
    //   838: ldc -27
    //   840: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   843: pop
    //   844: aload 5
    //   846: astore_3
    //   847: invokestatic 103	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   850: ifeq +13 -> 863
    //   853: aload 5
    //   855: astore_3
    //   856: aload_1
    //   857: invokevirtual 85	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   860: invokestatic 108	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   863: aload 5
    //   865: astore_3
    //   866: new 143	java/lang/ClassCastException
    //   869: dup
    //   870: aload_1
    //   871: invokevirtual 85	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   874: invokespecial 230	java/lang/ClassCastException:<init>	(Ljava/lang/String;)V
    //   877: athrow
    //   878: aload 5
    //   880: astore_3
    //   881: getstatic 55	org/apache/commons/logging/LogFactory:class$org$apache$commons$logging$LogFactory	Ljava/lang/Class;
    //   884: astore_0
    //   885: goto -147 -> 738
    //   888: aload 5
    //   890: astore_3
    //   891: aload_1
    //   892: ldc -24
    //   894: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   897: pop
    //   898: goto -64 -> 834
    //   901: aload 4
    //   903: astore_3
    //   904: invokestatic 103	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   907: ifeq +33 -> 940
    //   910: aload 4
    //   912: astore_3
    //   913: new 69	java/lang/StringBuffer
    //   916: dup
    //   917: ldc -22
    //   919: invokespecial 75	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   922: aload_1
    //   923: invokestatic 112	org/apache/commons/logging/LogFactory:objectId	(Ljava/lang/Object;)Ljava/lang/String;
    //   926: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   929: ldc -20
    //   931: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   934: invokevirtual 85	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   937: invokestatic 108	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   940: aload 4
    //   942: astore_3
    //   943: aload_0
    //   944: invokestatic 133	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   947: astore_0
    //   948: aload_0
    //   949: astore_3
    //   950: aload_0
    //   951: invokevirtual 165	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   954: checkcast 2	org/apache/commons/logging/LogFactory
    //   957: astore_0
    //   958: aload_0
    //   959: areturn
    //   960: getstatic 55	org/apache/commons/logging/LogFactory:class$org$apache$commons$logging$LogFactory	Ljava/lang/Class;
    //   963: astore_3
    //   964: goto -437 -> 527
    //   967: new 190	idm
    //   970: dup
    //   971: aload_0
    //   972: invokespecial 239	idm:<init>	(Ljava/lang/Throwable;)V
    //   975: areturn
    //   976: astore_0
    //   977: aconst_null
    //   978: astore_1
    //   979: goto -483 -> 496
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	982	0	paramString	String
    //   0	982	1	paramClassLoader	ClassLoader
    //   662	99	2	bool	boolean
    //   29	607	3	localObject1	Object
    //   639	1	3	localClassCastException	ClassCastException
    //   642	322	3	localObject2	Object
    //   7	934	4	localObject3	Object
    //   4	414	5	localObject4	Object
    //   428	63	5	localClassNotFoundException	ClassNotFoundException
    //   559	1	5	localObject5	Object
    //   569	320	5	localNoClassDefFoundError	NoClassDefFoundError
    //   10	539	6	localObject6	Object
    //   1	633	7	localObject7	Object
    //   64	501	8	localClass	Class
    //   303	81	9	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   16	23	428	java/lang/ClassNotFoundException
    //   38	44	428	java/lang/ClassNotFoundException
    //   59	66	428	java/lang/ClassNotFoundException
    //   81	86	428	java/lang/ClassNotFoundException
    //   101	111	428	java/lang/ClassNotFoundException
    //   126	132	428	java/lang/ClassNotFoundException
    //   147	182	428	java/lang/ClassNotFoundException
    //   197	206	428	java/lang/ClassNotFoundException
    //   221	226	428	java/lang/ClassNotFoundException
    //   244	250	428	java/lang/ClassNotFoundException
    //   265	305	428	java/lang/ClassNotFoundException
    //   320	326	428	java/lang/ClassNotFoundException
    //   341	348	428	java/lang/ClassNotFoundException
    //   363	368	428	java/lang/ClassNotFoundException
    //   383	404	428	java/lang/ClassNotFoundException
    //   419	425	428	java/lang/ClassNotFoundException
    //   561	566	428	java/lang/ClassNotFoundException
    //   38	44	493	java/lang/Exception
    //   59	66	493	java/lang/Exception
    //   81	86	493	java/lang/Exception
    //   101	111	493	java/lang/Exception
    //   126	132	493	java/lang/Exception
    //   147	182	493	java/lang/Exception
    //   197	206	493	java/lang/Exception
    //   221	226	493	java/lang/Exception
    //   244	250	493	java/lang/Exception
    //   265	305	493	java/lang/Exception
    //   320	326	493	java/lang/Exception
    //   341	348	493	java/lang/Exception
    //   363	368	493	java/lang/Exception
    //   383	404	493	java/lang/Exception
    //   419	425	493	java/lang/Exception
    //   437	444	493	java/lang/Exception
    //   447	453	493	java/lang/Exception
    //   456	487	493	java/lang/Exception
    //   490	493	493	java/lang/Exception
    //   561	566	493	java/lang/Exception
    //   578	585	493	java/lang/Exception
    //   588	594	493	java/lang/Exception
    //   597	633	493	java/lang/Exception
    //   636	639	493	java/lang/Exception
    //   647	654	493	java/lang/Exception
    //   657	663	493	java/lang/Exception
    //   666	674	493	java/lang/Exception
    //   677	684	493	java/lang/Exception
    //   687	694	493	java/lang/Exception
    //   697	703	493	java/lang/Exception
    //   706	713	493	java/lang/Exception
    //   716	722	493	java/lang/Exception
    //   725	731	493	java/lang/Exception
    //   734	738	493	java/lang/Exception
    //   741	750	493	java/lang/Exception
    //   753	760	493	java/lang/Exception
    //   767	774	493	java/lang/Exception
    //   777	784	493	java/lang/Exception
    //   787	794	493	java/lang/Exception
    //   797	804	493	java/lang/Exception
    //   807	814	493	java/lang/Exception
    //   817	824	493	java/lang/Exception
    //   827	834	493	java/lang/Exception
    //   837	844	493	java/lang/Exception
    //   847	853	493	java/lang/Exception
    //   856	863	493	java/lang/Exception
    //   866	878	493	java/lang/Exception
    //   881	885	493	java/lang/Exception
    //   891	898	493	java/lang/Exception
    //   904	910	493	java/lang/Exception
    //   913	940	493	java/lang/Exception
    //   943	948	493	java/lang/Exception
    //   950	958	493	java/lang/Exception
    //   16	23	569	java/lang/NoClassDefFoundError
    //   38	44	569	java/lang/NoClassDefFoundError
    //   59	66	569	java/lang/NoClassDefFoundError
    //   81	86	569	java/lang/NoClassDefFoundError
    //   101	111	569	java/lang/NoClassDefFoundError
    //   126	132	569	java/lang/NoClassDefFoundError
    //   147	182	569	java/lang/NoClassDefFoundError
    //   197	206	569	java/lang/NoClassDefFoundError
    //   221	226	569	java/lang/NoClassDefFoundError
    //   244	250	569	java/lang/NoClassDefFoundError
    //   265	305	569	java/lang/NoClassDefFoundError
    //   320	326	569	java/lang/NoClassDefFoundError
    //   341	348	569	java/lang/NoClassDefFoundError
    //   363	368	569	java/lang/NoClassDefFoundError
    //   383	404	569	java/lang/NoClassDefFoundError
    //   419	425	569	java/lang/NoClassDefFoundError
    //   561	566	569	java/lang/NoClassDefFoundError
    //   16	23	639	java/lang/ClassCastException
    //   38	44	639	java/lang/ClassCastException
    //   59	66	639	java/lang/ClassCastException
    //   81	86	639	java/lang/ClassCastException
    //   101	111	639	java/lang/ClassCastException
    //   126	132	639	java/lang/ClassCastException
    //   147	182	639	java/lang/ClassCastException
    //   197	206	639	java/lang/ClassCastException
    //   221	226	639	java/lang/ClassCastException
    //   244	250	639	java/lang/ClassCastException
    //   265	305	639	java/lang/ClassCastException
    //   320	326	639	java/lang/ClassCastException
    //   341	348	639	java/lang/ClassCastException
    //   363	368	639	java/lang/ClassCastException
    //   383	404	639	java/lang/ClassCastException
    //   419	425	639	java/lang/ClassCastException
    //   561	566	639	java/lang/ClassCastException
    //   16	23	976	java/lang/Exception
  }
  
  private static final Hashtable createFactoryStore()
  {
    try
    {
      Object localObject1 = getSystemProperty("org.apache.commons.logging.LogFactory.HashtableImpl", null);
      if (localObject1 == null)
      {
        localObject1 = "org.apache.commons.logging.impl.WeakHashtable";
        try
        {
          localObject3 = (Hashtable)Class.forName((String)localObject1).newInstance();
          localObject1 = localObject3;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Object localObject3;
            Object localObject2;
            handleThrowable(localThrowable);
            if (!"org.apache.commons.logging.impl.WeakHashtable".equals(localObject2))
            {
              if (isDiagnosticsEnabled())
              {
                logDiagnostic("[ERROR] LogFactory: Load of custom hashtable failed");
                localObject2 = null;
              }
              else
              {
                System.err.println("[ERROR] LogFactory: Load of custom hashtable failed");
              }
            }
            else {
              localObject2 = null;
            }
          }
        }
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = new Hashtable();
        }
        return (Hashtable)localObject3;
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        localObject2 = null;
      }
    }
  }
  
  public static ClassLoader directGetContextClassLoader()
  {
    try
    {
      ClassLoader localClassLoader = Thread.currentThread().getContextClassLoader();
      return localClassLoader;
    }
    catch (SecurityException localSecurityException) {}
    return null;
  }
  
  private static LogFactory getCachedFactory(ClassLoader paramClassLoader)
  {
    if (paramClassLoader == null) {
      return nullClassLoaderFactory;
    }
    return (LogFactory)factories.get(paramClassLoader);
  }
  
  protected static ClassLoader getClassLoader(Class paramClass)
  {
    try
    {
      ClassLoader localClassLoader = paramClass.getClassLoader();
      return localClassLoader;
    }
    catch (SecurityException localSecurityException)
    {
      if (isDiagnosticsEnabled()) {
        logDiagnostic("Unable to get classloader for class '" + paramClass + "' due to security restrictions - " + localSecurityException.getMessage());
      }
      throw localSecurityException;
    }
  }
  
  private static final Properties getConfigurationFile(ClassLoader paramClassLoader, String paramString)
  {
    Properties localProperties = null;
    localObject1 = null;
    localObject3 = null;
    for (;;)
    {
      try
      {
        localEnumeration = getResources(paramClassLoader, paramString);
        if (localEnumeration != null) {
          continue;
        }
        paramClassLoader = (ClassLoader)localObject3;
        return paramClassLoader;
      }
      catch (SecurityException paramClassLoader)
      {
        Enumeration localEnumeration;
        String str;
        double d2;
        Object localObject2;
        paramClassLoader = null;
        continue;
        double d1 = 0.0D;
        localObject1 = null;
        paramClassLoader = (ClassLoader)localObject2;
        continue;
        paramClassLoader = (ClassLoader)localObject3;
        d1 = d2;
        localObject1 = localObject2;
        continue;
      }
      try
      {
        if (localEnumeration.hasMoreElements())
        {
          localObject3 = (URL)localEnumeration.nextElement();
          localProperties = getProperties((URL)localObject3);
          if (localProperties == null) {
            continue;
          }
          if (localObject1 != null) {}
        }
      }
      catch (SecurityException localSecurityException)
      {
        localObject3 = paramClassLoader;
        localObject2 = localObject1;
        if (isDiagnosticsEnabled())
        {
          logDiagnostic("SecurityException thrown while trying to find/read config files.");
          localObject2 = localObject1;
          localObject3 = paramClassLoader;
        }
        paramClassLoader = (ClassLoader)localObject2;
      }
      try
      {
        paramClassLoader = localProperties.getProperty("priority");
        if (paramClassLoader == null) {
          continue;
        }
        d1 = Double.parseDouble(paramClassLoader);
      }
      catch (SecurityException paramClassLoader)
      {
        localObject1 = localObject2;
        paramClassLoader = (ClassLoader)localObject3;
        continue;
        d2 = 0.0D;
        continue;
        d1 = 0.0D;
        continue;
      }
      if (isDiagnosticsEnabled()) {
        logDiagnostic("[LOOKUP] Properties file found at '" + localObject3 + "' with priority " + d1);
      }
      paramClassLoader = (ClassLoader)localObject3;
      localObject1 = localProperties;
      continue;
      str = localProperties.getProperty("priority");
      if (str == null) {
        continue;
      }
      d2 = Double.parseDouble(str);
      if (d2 > d1)
      {
        if (!isDiagnosticsEnabled()) {
          continue;
        }
        logDiagnostic("[LOOKUP] Properties file at '" + localObject3 + "' with priority " + d2 + " overrides file at '" + paramClassLoader + "' with priority " + d1);
        continue;
      }
      if (isDiagnosticsEnabled())
      {
        logDiagnostic("[LOOKUP] Properties file at '" + localObject3 + "' with priority " + d2 + " does not override file at '" + paramClassLoader + "' with priority " + d1);
        continue;
        if (isDiagnosticsEnabled())
        {
          if (localObject2 != null) {
            continue;
          }
          logDiagnostic("[LOOKUP] No properties file of name '" + paramString + "' found.");
          return (Properties)localObject2;
          localObject3 = paramClassLoader;
          localObject2 = localObject1;
        }
      }
    }
    logDiagnostic("[LOOKUP] Properties file of name '" + paramString + "' found at '" + localObject3 + '"');
    return (Properties)localObject2;
  }
  
  protected static ClassLoader getContextClassLoader()
  {
    return directGetContextClassLoader();
  }
  
  private static ClassLoader getContextClassLoaderInternal()
  {
    return (ClassLoader)AccessController.doPrivileged(new idn());
  }
  
  /* Error */
  public static LogFactory getFactory()
  {
    // Byte code:
    //   0: invokestatic 369	org/apache/commons/logging/LogFactory:getContextClassLoaderInternal	()Ljava/lang/ClassLoader;
    //   3: astore_3
    //   4: aload_3
    //   5: ifnonnull +15 -> 20
    //   8: invokestatic 103	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   11: ifeq +9 -> 20
    //   14: ldc_w 371
    //   17: invokestatic 108	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   20: aload_3
    //   21: invokestatic 373	org/apache/commons/logging/LogFactory:getCachedFactory	(Ljava/lang/ClassLoader;)Lorg/apache/commons/logging/LogFactory;
    //   24: astore_1
    //   25: aload_1
    //   26: ifnull +5 -> 31
    //   29: aload_1
    //   30: areturn
    //   31: invokestatic 103	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   34: ifeq +33 -> 67
    //   37: new 69	java/lang/StringBuffer
    //   40: dup
    //   41: ldc_w 375
    //   44: invokespecial 75	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   47: aload_3
    //   48: invokestatic 112	org/apache/commons/logging/LogFactory:objectId	(Ljava/lang/Object;)Ljava/lang/String;
    //   51: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   54: invokevirtual 85	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   57: invokestatic 108	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   60: ldc_w 377
    //   63: aload_3
    //   64: invokestatic 182	org/apache/commons/logging/LogFactory:logHierarchy	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   67: aload_3
    //   68: ldc 14
    //   70: invokestatic 379	org/apache/commons/logging/LogFactory:getConfigurationFile	(Ljava/lang/ClassLoader;Ljava/lang/String;)Ljava/util/Properties;
    //   73: astore 4
    //   75: aload 4
    //   77: ifnull +604 -> 681
    //   80: aload 4
    //   82: ldc 29
    //   84: invokevirtual 317	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   87: astore_0
    //   88: aload_0
    //   89: ifnull +592 -> 681
    //   92: aload_0
    //   93: invokestatic 385	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   96: invokevirtual 388	java/lang/Boolean:booleanValue	()Z
    //   99: ifne +582 -> 681
    //   102: getstatic 65	org/apache/commons/logging/LogFactory:thisClassLoader	Ljava/lang/ClassLoader;
    //   105: astore_2
    //   106: invokestatic 103	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   109: ifeq +9 -> 118
    //   112: ldc_w 390
    //   115: invokestatic 108	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   118: ldc 17
    //   120: aconst_null
    //   121: invokestatic 245	org/apache/commons/logging/LogFactory:getSystemProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   124: astore_0
    //   125: aload_0
    //   126: ifnull +319 -> 445
    //   129: invokestatic 103	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   132: ifeq +29 -> 161
    //   135: new 69	java/lang/StringBuffer
    //   138: dup
    //   139: ldc_w 392
    //   142: invokespecial 75	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   145: aload_0
    //   146: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   149: ldc_w 394
    //   152: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   155: invokevirtual 85	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   158: invokestatic 108	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   161: aload_0
    //   162: aload_2
    //   163: aload_3
    //   164: invokestatic 398	org/apache/commons/logging/LogFactory:newFactory	(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/ClassLoader;)Lorg/apache/commons/logging/LogFactory;
    //   167: astore_0
    //   168: aload_0
    //   169: astore_1
    //   170: aload_0
    //   171: ifnonnull +119 -> 290
    //   174: invokestatic 103	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   177: ifeq +9 -> 186
    //   180: ldc_w 400
    //   183: invokestatic 108	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   186: aload_3
    //   187: ldc 26
    //   189: invokestatic 404	org/apache/commons/logging/LogFactory:getResourceAsStream	(Ljava/lang/ClassLoader;Ljava/lang/String;)Ljava/io/InputStream;
    //   192: astore 5
    //   194: aload 5
    //   196: ifnull +426 -> 622
    //   199: new 406	java/io/BufferedReader
    //   202: dup
    //   203: new 408	java/io/InputStreamReader
    //   206: dup
    //   207: aload 5
    //   209: ldc_w 410
    //   212: invokespecial 413	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   215: invokespecial 416	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   218: astore_1
    //   219: aload_1
    //   220: invokevirtual 419	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   223: astore 5
    //   225: aload_1
    //   226: invokevirtual 422	java/io/BufferedReader:close	()V
    //   229: aload_0
    //   230: astore_1
    //   231: aload 5
    //   233: ifnull +57 -> 290
    //   236: aload_0
    //   237: astore_1
    //   238: ldc_w 424
    //   241: aload 5
    //   243: invokevirtual 255	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   246: ifne +44 -> 290
    //   249: invokestatic 103	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   252: ifeq +30 -> 282
    //   255: new 69	java/lang/StringBuffer
    //   258: dup
    //   259: ldc_w 426
    //   262: invokespecial 75	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   265: aload 5
    //   267: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   270: ldc_w 428
    //   273: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   276: invokevirtual 85	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   279: invokestatic 108	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   282: aload 5
    //   284: aload_2
    //   285: aload_3
    //   286: invokestatic 398	org/apache/commons/logging/LogFactory:newFactory	(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/ClassLoader;)Lorg/apache/commons/logging/LogFactory;
    //   289: astore_1
    //   290: aload_1
    //   291: astore_0
    //   292: aload_1
    //   293: ifnonnull +71 -> 364
    //   296: aload 4
    //   298: ifnull +362 -> 660
    //   301: invokestatic 103	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   304: ifeq +9 -> 313
    //   307: ldc_w 430
    //   310: invokestatic 108	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   313: aload 4
    //   315: ldc 17
    //   317: invokevirtual 317	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   320: astore_0
    //   321: aload_0
    //   322: ifnull +319 -> 641
    //   325: invokestatic 103	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   328: ifeq +29 -> 357
    //   331: new 69	java/lang/StringBuffer
    //   334: dup
    //   335: ldc_w 432
    //   338: invokespecial 75	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   341: aload_0
    //   342: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   345: ldc_w 434
    //   348: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   351: invokevirtual 85	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   354: invokestatic 108	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   357: aload_0
    //   358: aload_2
    //   359: aload_3
    //   360: invokestatic 398	org/apache/commons/logging/LogFactory:newFactory	(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/ClassLoader;)Lorg/apache/commons/logging/LogFactory;
    //   363: astore_0
    //   364: aload_0
    //   365: astore_1
    //   366: aload_0
    //   367: ifnonnull +25 -> 392
    //   370: invokestatic 103	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   373: ifeq +9 -> 382
    //   376: ldc_w 436
    //   379: invokestatic 108	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   382: ldc 11
    //   384: getstatic 65	org/apache/commons/logging/LogFactory:thisClassLoader	Ljava/lang/ClassLoader;
    //   387: aload_3
    //   388: invokestatic 398	org/apache/commons/logging/LogFactory:newFactory	(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/ClassLoader;)Lorg/apache/commons/logging/LogFactory;
    //   391: astore_1
    //   392: aload_1
    //   393: ifnull +286 -> 679
    //   396: aload_3
    //   397: aload_1
    //   398: invokestatic 438	org/apache/commons/logging/LogFactory:cacheFactory	(Ljava/lang/ClassLoader;Lorg/apache/commons/logging/LogFactory;)V
    //   401: aload 4
    //   403: ifnull +276 -> 679
    //   406: aload 4
    //   408: invokevirtual 442	java/util/Properties:propertyNames	()Ljava/util/Enumeration;
    //   411: astore_0
    //   412: aload_0
    //   413: invokeinterface 302 1 0
    //   418: ifeq +261 -> 679
    //   421: aload_0
    //   422: invokeinterface 305 1 0
    //   427: checkcast 251	java/lang/String
    //   430: astore_2
    //   431: aload_1
    //   432: aload_2
    //   433: aload 4
    //   435: aload_2
    //   436: invokevirtual 317	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   439: invokevirtual 446	org/apache/commons/logging/LogFactory:setAttribute	(Ljava/lang/String;Ljava/lang/Object;)V
    //   442: goto -30 -> 412
    //   445: aload_1
    //   446: astore_0
    //   447: invokestatic 103	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   450: ifeq -282 -> 168
    //   453: ldc_w 448
    //   456: invokestatic 108	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   459: aload_1
    //   460: astore_0
    //   461: goto -293 -> 168
    //   464: astore 5
    //   466: aload_1
    //   467: astore_0
    //   468: invokestatic 103	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   471: ifeq -303 -> 168
    //   474: new 69	java/lang/StringBuffer
    //   477: dup
    //   478: ldc_w 450
    //   481: invokespecial 75	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   484: aload 5
    //   486: invokevirtual 291	java/lang/SecurityException:getMessage	()Ljava/lang/String;
    //   489: invokestatic 453	org/apache/commons/logging/LogFactory:trim	(Ljava/lang/String;)Ljava/lang/String;
    //   492: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   495: ldc_w 455
    //   498: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   501: invokevirtual 85	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   504: invokestatic 108	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   507: aload_1
    //   508: astore_0
    //   509: goto -341 -> 168
    //   512: astore_0
    //   513: invokestatic 103	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   516: ifeq +35 -> 551
    //   519: new 69	java/lang/StringBuffer
    //   522: dup
    //   523: ldc_w 457
    //   526: invokespecial 75	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   529: aload_0
    //   530: invokevirtual 458	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   533: invokestatic 453	org/apache/commons/logging/LogFactory:trim	(Ljava/lang/String;)Ljava/lang/String;
    //   536: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   539: ldc_w 460
    //   542: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   545: invokevirtual 85	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   548: invokestatic 108	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   551: aload_0
    //   552: athrow
    //   553: astore_1
    //   554: new 406	java/io/BufferedReader
    //   557: dup
    //   558: new 408	java/io/InputStreamReader
    //   561: dup
    //   562: aload 5
    //   564: invokespecial 463	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   567: invokespecial 416	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   570: astore_1
    //   571: goto -352 -> 219
    //   574: astore 5
    //   576: aload_0
    //   577: astore_1
    //   578: invokestatic 103	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   581: ifeq -291 -> 290
    //   584: new 69	java/lang/StringBuffer
    //   587: dup
    //   588: ldc_w 450
    //   591: invokespecial 75	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   594: aload 5
    //   596: invokevirtual 464	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   599: invokestatic 453	org/apache/commons/logging/LogFactory:trim	(Ljava/lang/String;)Ljava/lang/String;
    //   602: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   605: ldc_w 455
    //   608: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   611: invokevirtual 85	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   614: invokestatic 108	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   617: aload_0
    //   618: astore_1
    //   619: goto -329 -> 290
    //   622: aload_0
    //   623: astore_1
    //   624: invokestatic 103	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   627: ifeq -337 -> 290
    //   630: ldc_w 466
    //   633: invokestatic 108	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   636: aload_0
    //   637: astore_1
    //   638: goto -348 -> 290
    //   641: aload_1
    //   642: astore_0
    //   643: invokestatic 103	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   646: ifeq -282 -> 364
    //   649: ldc_w 468
    //   652: invokestatic 108	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   655: aload_1
    //   656: astore_0
    //   657: goto -293 -> 364
    //   660: aload_1
    //   661: astore_0
    //   662: invokestatic 103	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   665: ifeq -301 -> 364
    //   668: ldc_w 470
    //   671: invokestatic 108	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   674: aload_1
    //   675: astore_0
    //   676: goto -312 -> 364
    //   679: aload_1
    //   680: areturn
    //   681: aload_3
    //   682: astore_2
    //   683: goto -577 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   87	422	0	localObject1	Object
    //   512	125	0	localRuntimeException	RuntimeException
    //   642	34	0	localObject2	Object
    //   24	484	1	localObject3	Object
    //   553	1	1	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   570	110	1	localObject4	Object
    //   105	578	2	localObject5	Object
    //   3	679	3	localClassLoader	ClassLoader
    //   73	361	4	localProperties	Properties
    //   192	91	5	localObject6	Object
    //   464	99	5	localSecurityException	SecurityException
    //   574	21	5	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   118	125	464	java/lang/SecurityException
    //   129	161	464	java/lang/SecurityException
    //   161	168	464	java/lang/SecurityException
    //   447	459	464	java/lang/SecurityException
    //   118	125	512	java/lang/RuntimeException
    //   129	161	512	java/lang/RuntimeException
    //   161	168	512	java/lang/RuntimeException
    //   447	459	512	java/lang/RuntimeException
    //   199	219	553	java/io/UnsupportedEncodingException
    //   186	194	574	java/lang/Exception
    //   199	219	574	java/lang/Exception
    //   219	229	574	java/lang/Exception
    //   238	282	574	java/lang/Exception
    //   282	290	574	java/lang/Exception
    //   554	571	574	java/lang/Exception
    //   624	636	574	java/lang/Exception
  }
  
  public static Log getLog(Class paramClass)
  {
    return getFactory().getInstance(paramClass);
  }
  
  public static Log getLog(String paramString)
  {
    return getFactory().getInstance(paramString);
  }
  
  private static Properties getProperties(URL paramURL)
  {
    return (Properties)AccessController.doPrivileged(new idr(paramURL));
  }
  
  private static InputStream getResourceAsStream(ClassLoader paramClassLoader, String paramString)
  {
    return (InputStream)AccessController.doPrivileged(new idp(paramClassLoader, paramString));
  }
  
  private static Enumeration getResources(ClassLoader paramClassLoader, String paramString)
  {
    return (Enumeration)AccessController.doPrivileged(new idq(paramClassLoader, paramString));
  }
  
  private static String getSystemProperty(String paramString1, String paramString2)
  {
    return (String)AccessController.doPrivileged(new ids(paramString1, paramString2));
  }
  
  protected static void handleThrowable(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof ThreadDeath)) {
      throw ((ThreadDeath)paramThrowable);
    }
    if ((paramThrowable instanceof VirtualMachineError)) {
      throw ((VirtualMachineError)paramThrowable);
    }
  }
  
  private static boolean implementsLogFactory(Class paramClass)
  {
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramClass != null)
    {
      boolean bool3 = bool2;
      boolean bool4 = bool5;
      bool1 = bool6;
      try
      {
        ClassLoader localClassLoader = paramClass.getClassLoader();
        if (localClassLoader == null)
        {
          bool3 = bool2;
          bool4 = bool5;
          bool1 = bool6;
          logDiagnostic("[CUSTOM LOG FACTORY] was loaded by the boot classloader");
          return false;
        }
        bool3 = bool2;
        bool4 = bool5;
        bool1 = bool6;
        logHierarchy("[CUSTOM LOG FACTORY] ", localClassLoader);
        bool3 = bool2;
        bool4 = bool5;
        bool1 = bool6;
        bool2 = Class.forName("org.apache.commons.logging.LogFactory", false, localClassLoader).isAssignableFrom(paramClass);
        if (bool2)
        {
          bool3 = bool2;
          bool4 = bool2;
          bool1 = bool2;
          logDiagnostic("[CUSTOM LOG FACTORY] " + paramClass.getName() + " implements LogFactory but was loaded by an incompatible classloader.");
          return bool2;
        }
      }
      catch (SecurityException paramClass)
      {
        logDiagnostic("[CUSTOM LOG FACTORY] SecurityException thrown whilst trying to determine whether the compatibility was caused by a classloader conflict: " + paramClass.getMessage());
        return bool3;
        bool3 = bool2;
        bool4 = bool2;
        bool1 = bool2;
        logDiagnostic("[CUSTOM LOG FACTORY] " + paramClass.getName() + " does not implement LogFactory.");
        return bool2;
      }
      catch (LinkageError paramClass)
      {
        logDiagnostic("[CUSTOM LOG FACTORY] LinkageError thrown whilst trying to determine whether the compatibility was caused by a classloader conflict: " + paramClass.getMessage());
        return bool4;
      }
      catch (ClassNotFoundException paramClass)
      {
        logDiagnostic("[CUSTOM LOG FACTORY] LogFactory class cannot be loaded by classloader which loaded the custom LogFactory implementation. Is the custom factory in the right classloader?");
      }
    }
    return bool1;
  }
  
  private static PrintStream initDiagnostics()
  {
    try
    {
      Object localObject = getSystemProperty("org.apache.commons.logging.diagnostics.dest", null);
      if (localObject == null) {
        return null;
      }
      if (((String)localObject).equals("STDOUT")) {
        return System.out;
      }
      if (((String)localObject).equals("STDERR")) {
        return System.err;
      }
      try
      {
        localObject = new PrintStream(new FileOutputStream((String)localObject, true));
        return (PrintStream)localObject;
      }
      catch (IOException localIOException)
      {
        return null;
      }
      return null;
    }
    catch (SecurityException localSecurityException) {}
  }
  
  public static boolean isDiagnosticsEnabled()
  {
    return diagnosticsStream != null;
  }
  
  private static void logClassLoaderEnvironment(Class paramClass)
  {
    if (!isDiagnosticsEnabled()) {
      return;
    }
    try
    {
      logDiagnostic("[ENV] Extension directories (java.ext.dir): " + System.getProperty("java.ext.dir"));
      logDiagnostic("[ENV] Application classpath (java.class.path): " + System.getProperty("java.class.path"));
      str = paramClass.getName();
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        try
        {
          String str;
          paramClass = getClassLoader(paramClass);
          logDiagnostic("[ENV] Class " + str + " was loaded via classloader " + objectId(paramClass));
          logHierarchy("[ENV] Ancestry of classloader which loaded " + str + " is ", paramClass);
          return;
        }
        catch (SecurityException paramClass)
        {
          logDiagnostic("[ENV] Security forbids determining the classloader for " + localSecurityException);
        }
        localSecurityException = localSecurityException;
        logDiagnostic("[ENV] Security setting prevent interrogation of system classpaths.");
      }
    }
  }
  
  private static final void logDiagnostic(String paramString)
  {
    if (diagnosticsStream != null)
    {
      diagnosticsStream.print(diagnosticPrefix);
      diagnosticsStream.println(paramString);
      diagnosticsStream.flush();
    }
  }
  
  private static void logHierarchy(String paramString, ClassLoader paramClassLoader)
  {
    if (!isDiagnosticsEnabled()) {
      return;
    }
    Object localObject;
    if (paramClassLoader != null)
    {
      localObject = paramClassLoader.toString();
      logDiagnostic(paramString + objectId(paramClassLoader) + " == '" + (String)localObject + "'");
    }
    for (;;)
    {
      StringBuffer localStringBuffer;
      try
      {
        localObject = ClassLoader.getSystemClassLoader();
        if (paramClassLoader == null) {
          break;
        }
        localStringBuffer = new StringBuffer(paramString + "ClassLoader tree:");
        localStringBuffer.append(objectId(paramClassLoader));
        if (paramClassLoader == localObject) {
          localStringBuffer.append(" (SYSTEM) ");
        }
      }
      catch (SecurityException paramClassLoader)
      {
        logDiagnostic(paramString + "Security forbids determining the system classloader.");
        return;
      }
      try
      {
        paramString = paramClassLoader.getParent();
        localStringBuffer.append(" --> ");
        paramClassLoader = paramString;
        if (paramString == null) {
          localStringBuffer.append("BOOT");
        }
      }
      catch (SecurityException paramString)
      {
        localStringBuffer.append(" --> SECRET");
      }
    }
    logDiagnostic(localStringBuffer.toString());
  }
  
  protected static final void logRawDiagnostic(String paramString)
  {
    if (diagnosticsStream != null)
    {
      diagnosticsStream.println(paramString);
      diagnosticsStream.flush();
    }
  }
  
  protected static LogFactory newFactory(String paramString, ClassLoader paramClassLoader)
  {
    return newFactory(paramString, paramClassLoader, null);
  }
  
  protected static LogFactory newFactory(String paramString, ClassLoader paramClassLoader1, ClassLoader paramClassLoader2)
  {
    paramString = AccessController.doPrivileged(new ido(paramString, paramClassLoader1));
    if ((paramString instanceof idm))
    {
      paramString = (idm)paramString;
      if (isDiagnosticsEnabled()) {
        logDiagnostic("An error occurred while loading the factory class:" + paramString.getMessage());
      }
      throw paramString;
    }
    if (isDiagnosticsEnabled()) {
      logDiagnostic("Created object " + objectId(paramString) + " to manage classloader " + objectId(paramClassLoader2));
    }
    return (LogFactory)paramString;
  }
  
  public static String objectId(Object paramObject)
  {
    if (paramObject == null) {
      return "null";
    }
    return paramObject.getClass().getName() + "@" + System.identityHashCode(paramObject);
  }
  
  public static void release(ClassLoader paramClassLoader)
  {
    if (isDiagnosticsEnabled()) {
      logDiagnostic("Releasing factory for classloader " + objectId(paramClassLoader));
    }
    localHashtable = factories;
    if (paramClassLoader == null) {}
    for (;;)
    {
      try
      {
        if (nullClassLoaderFactory != null)
        {
          nullClassLoaderFactory.release();
          nullClassLoaderFactory = null;
        }
        return;
      }
      finally {}
      LogFactory localLogFactory = (LogFactory)localHashtable.get(paramClassLoader);
      if (localLogFactory != null)
      {
        localLogFactory.release();
        localHashtable.remove(paramClassLoader);
      }
    }
  }
  
  public static void releaseAll()
  {
    if (isDiagnosticsEnabled()) {
      logDiagnostic("Releasing factory for all classloaders.");
    }
    synchronized (factories)
    {
      Enumeration localEnumeration = ???.elements();
      if (localEnumeration.hasMoreElements()) {
        ((LogFactory)localEnumeration.nextElement()).release();
      }
    }
    ???.clear();
    if (nullClassLoaderFactory != null)
    {
      nullClassLoaderFactory.release();
      nullClassLoaderFactory = null;
    }
  }
  
  private static String trim(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return paramString.trim();
  }
  
  public abstract Object getAttribute(String paramString);
  
  public abstract String[] getAttributeNames();
  
  public abstract Log getInstance(Class paramClass);
  
  public abstract Log getInstance(String paramString);
  
  public abstract void release();
  
  public abstract void removeAttribute(String paramString);
  
  public abstract void setAttribute(String paramString, Object paramObject);
}

/* Location:
 * Qualified Name:     org.apache.commons.logging.LogFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */