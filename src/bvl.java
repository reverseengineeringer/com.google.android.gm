public final class bvl
  implements Runnable
{
  public bvl(bvk parambvk, bvq parambvq) {}
  
  public final void run()
  {
    try
    {
      a.dismissAllowingStateLoss();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      cvm.d(bvk.i, localIllegalStateException, "Exception while dismissing AttachmentProgressDialogFragment", new Object[0]);
    }
  }
}

/* Location:
 * Qualified Name:     bvl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */