import android.app.ActivityManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Debug.MemoryInfo;
import android.os.Process;

final class gkr
  implements Runnable
{
  gkr(gkp paramgkp, String paramString, int paramInt) {}
  
  public final void run()
  {
    gku localgku = c.a;
    String str = a;
    Object localObject1 = c.b;
    int i = b;
    hri localhri = new hri();
    i = Integer.valueOf(i).intValue();
    localObject1 = a;
    int j = Process.myPid();
    gom.a();
    gol.a(localObject1);
    hqy localhqy = new hqy();
    a = new hqx();
    if (gmy.a == null) {
      gmy.a = (ActivityManager)((Context)localObject1).getSystemService("activity");
    }
    Object localObject3 = gmy.a.getProcessMemoryInfo(new int[] { j });
    Object localObject2 = a;
    localObject3 = localObject3[0];
    hqk localhqk = new hqk();
    a = Integer.valueOf(dalvikPss);
    b = Integer.valueOf(nativePss);
    c = Integer.valueOf(otherPss);
    d = Integer.valueOf(dalvikPrivateDirty);
    e = Integer.valueOf(nativePrivateDirty);
    f = Integer.valueOf(otherPrivateDirty);
    if (Build.VERSION.SDK_INT >= 19)
    {
      g = Integer.valueOf(((Debug.MemoryInfo)localObject3).getTotalPrivateClean());
      i = Integer.valueOf(((Debug.MemoryInfo)localObject3).getTotalSwappablePss());
    }
    h = Integer.valueOf(((Debug.MemoryInfo)localObject3).getTotalSharedDirty());
    if (Build.VERSION.SDK_INT >= 19)
    {
      j = gmu.a((Debug.MemoryInfo)localObject3);
      if (j != -1) {
        j = Integer.valueOf(j);
      }
    }
    a = localhqk;
    b = new hrf();
    localObject2 = b;
    localObject3 = new hql();
    a = Long.valueOf(Process.getElapsedCpuTime());
    b = Boolean.valueOf(gmy.a((Context)localObject1));
    c = Integer.valueOf(Thread.activeCount());
    a = ((hql)localObject3);
    d = new hqq();
    d.a = Boolean.valueOf(gmy.b((Context)localObject1));
    c = i;
    a = localhqy;
    localgku.a(str, localhri);
  }
}

/* Location:
 * Qualified Name:     gkr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */