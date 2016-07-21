public final class bbl
{
  final long a;
  public final boolean b;
  final boolean c;
  final int d;
  final int e;
  final int f;
  final bdk g;
  final String h;
  
  public bbl(long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, bdk parambdk, String paramString)
  {
    a = paramLong;
    b = paramBoolean1;
    c = paramBoolean2;
    d = paramInt1;
    e = paramInt2;
    f = paramInt3;
    g = parambdk;
    h = paramString;
  }
  
  public final String toString()
  {
    return String.format("[id-%d isFullSync %b, wipedLocal %b, numMsgs %d numSynced %d, numUnsynced %d, numCmds %d, reqBytes %d, rspBytes %d, httpTime %d, splits [%s], numNewMessages %d, numUpgradeMessages %d, numInvalidMessages %d ]", new Object[] { Long.valueOf(a), Boolean.valueOf(b), Boolean.valueOf(c), Integer.valueOf(d), Integer.valueOf(e), Integer.valueOf(f), Integer.valueOf(g.a), Integer.valueOf(g.b), Integer.valueOf(g.c), Long.valueOf(g.g), h, Integer.valueOf(g.d), Integer.valueOf(g.e), Integer.valueOf(g.f) });
  }
}

/* Location:
 * Qualified Name:     bbl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */