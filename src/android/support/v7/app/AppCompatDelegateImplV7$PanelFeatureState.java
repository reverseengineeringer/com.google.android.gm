package android.support.v7.app;

import ads;
import adu;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

public final class AppCompatDelegateImplV7$PanelFeatureState
{
  public int a;
  int b;
  int c;
  int d;
  int e;
  int f;
  ViewGroup g;
  View h;
  View i;
  public adu j;
  ads k;
  Context l;
  public boolean m;
  boolean n;
  boolean o;
  public boolean p;
  public boolean q;
  public boolean r;
  public Bundle s;
  
  AppCompatDelegateImplV7$PanelFeatureState(int paramInt)
  {
    a = paramInt;
    q = false;
  }
  
  final void a(adu paramadu)
  {
    if (paramadu == j) {}
    do
    {
      return;
      if (j != null) {
        j.b(k);
      }
      j = paramadu;
    } while ((paramadu == null) || (k == null));
    paramadu.a(k);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplV7.PanelFeatureState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */