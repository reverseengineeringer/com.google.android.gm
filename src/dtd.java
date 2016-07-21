public final class dtd
{
  public boolean a = true;
  public boolean b = false;
  public boolean c = false;
  public Long d;
  public long e = -1L;
  public long f = -1L;
  public boolean g = false;
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SyncInfo: normalSync: ").append(a).append(", justLive: ").append(b).append(", manual: ").append(c);
    if (d != null) {
      localStringBuilder.append(", activeLabelId: ").append(d);
    }
    if (e != -1L) {
      localStringBuilder.append(", conversationId: ").append(e);
    }
    if (f != -1L) {
      localStringBuilder.append(", messageId: ").append(f);
    }
    localStringBuilder.append(", receivedHandledClientOp: ").append(g);
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     dtd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */