import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class cro
  extends BaseAdapter
{
  private static final String e = cvl.a;
  public Context a;
  public crr b;
  public chc c;
  public List<crq> d;
  private LayoutInflater f;
  private final Filter g = new crp(this);
  
  public cro(Context paramContext)
  {
    a = paramContext;
  }
  
  public void a()
  {
    a = null;
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(crr paramcrr, chc paramchc)
  {
    b = paramcrr;
    c = paramchc;
  }
  
  public void a(String paramString)
  {
    g.filter(paramString);
  }
  
  public Cursor b(String paramString)
  {
    return c.a(paramString);
  }
  
  public String b()
  {
    return "offline_adapter";
  }
  
  /* Error */
  public final List<crq> c(String paramString)
  {
    // Byte code:
    //   0: invokestatic 69	cwv:b	()V
    //   3: aload_1
    //   4: astore 5
    //   6: aload_1
    //   7: ifnonnull +7 -> 14
    //   10: ldc 71
    //   12: astore 5
    //   14: aconst_null
    //   15: astore 4
    //   17: aconst_null
    //   18: astore_1
    //   19: new 73	java/util/ArrayList
    //   22: dup
    //   23: invokespecial 74	java/util/ArrayList:<init>	()V
    //   26: astore 6
    //   28: aload_0
    //   29: aload 5
    //   31: invokevirtual 76	cro:b	(Ljava/lang/String;)Landroid/database/Cursor;
    //   34: astore 5
    //   36: aload 5
    //   38: ifnull +131 -> 169
    //   41: aload 5
    //   43: astore_1
    //   44: aload 5
    //   46: astore 4
    //   48: aload 5
    //   50: ldc 78
    //   52: invokeinterface 84 2 0
    //   57: istore_2
    //   58: aload 5
    //   60: astore_1
    //   61: aload 5
    //   63: astore 4
    //   65: aload 5
    //   67: ldc 86
    //   69: invokeinterface 84 2 0
    //   74: istore_3
    //   75: aload 5
    //   77: astore_1
    //   78: aload 5
    //   80: astore 4
    //   82: aload 5
    //   84: invokeinterface 90 1 0
    //   89: ifeq +80 -> 169
    //   92: aload 5
    //   94: astore_1
    //   95: aload 5
    //   97: astore 4
    //   99: aload 6
    //   101: new 92	crq
    //   104: dup
    //   105: aload 5
    //   107: iload_2
    //   108: invokeinterface 96 2 0
    //   113: aload 5
    //   115: iload_3
    //   116: invokeinterface 96 2 0
    //   121: invokestatic 102	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   124: invokespecial 105	crq:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   127: invokeinterface 111 2 0
    //   132: pop
    //   133: goto -58 -> 75
    //   136: astore 5
    //   138: aload_1
    //   139: astore 4
    //   141: getstatic 27	cro:e	Ljava/lang/String;
    //   144: aload 5
    //   146: ldc 113
    //   148: iconst_0
    //   149: anewarray 115	java/lang/Object
    //   152: invokestatic 120	cvm:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   155: pop
    //   156: aload_1
    //   157: ifnull +9 -> 166
    //   160: aload_1
    //   161: invokeinterface 123 1 0
    //   166: aload 6
    //   168: areturn
    //   169: aload 5
    //   171: ifnull -5 -> 166
    //   174: aload 5
    //   176: invokeinterface 123 1 0
    //   181: aload 6
    //   183: areturn
    //   184: astore_1
    //   185: aload 4
    //   187: ifnull +10 -> 197
    //   190: aload 4
    //   192: invokeinterface 123 1 0
    //   197: aload_1
    //   198: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	cro
    //   0	199	1	paramString	String
    //   57	51	2	i	int
    //   74	42	3	j	int
    //   15	176	4	localObject1	Object
    //   4	110	5	localObject2	Object
    //   136	39	5	localIllegalStateException	IllegalStateException
    //   26	156	6	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   28	36	136	java/lang/IllegalStateException
    //   48	58	136	java/lang/IllegalStateException
    //   65	75	136	java/lang/IllegalStateException
    //   82	92	136	java/lang/IllegalStateException
    //   99	133	136	java/lang/IllegalStateException
    //   28	36	184	finally
    //   48	58	184	finally
    //   65	75	184	finally
    //   82	92	184	finally
    //   99	133	184	finally
    //   141	156	184	finally
  }
  
  public int getCount()
  {
    if (d == null) {
      return 0;
    }
    return d.size();
  }
  
  public Object getItem(int paramInt)
  {
    return d.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      if (f == null) {
        f = LayoutInflater.from(a);
      }
      localView = f.inflate(bue.af, paramViewGroup, false);
    }
    paramView = d.get(paramInt)).b;
    paramViewGroup = (TextView)localView.findViewById(buc.es);
    paramViewGroup.setText(paramView);
    paramViewGroup.setContentDescription(a.getResources().getString(buj.ew, new Object[] { paramView }));
    ((ImageView)localView.findViewById(buc.er)).setImageURI(d.get(paramInt)).c);
    return localView;
  }
}

/* Location:
 * Qualified Name:     cro
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */