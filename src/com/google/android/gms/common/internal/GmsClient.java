package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.ArrayList;

public abstract class GmsClient<T extends IInterface>
  implements GooglePlayServicesClient
{
  public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = { "service_esmobile", "service_googleme" };
  private final ArrayList<GmsClient<T>.CallbackProxy<?>> mCallbackProxyList = new ArrayList();
  private ServiceConnection mConnection;
  private ArrayList<GooglePlayServicesClient.OnConnectionFailedListener> mConnectionFailedListeners;
  private ArrayList<GooglePlayServicesClient.ConnectionCallbacks> mConnectionListeners;
  final ArrayList<GooglePlayServicesClient.ConnectionCallbacks> mConnectionListenersRemoved = new ArrayList();
  private final Context mContext;
  final Handler mHandler;
  private boolean mIsProcessingConnectionCallback = false;
  private boolean mIsProcessingOnConnectionFailed = false;
  boolean mPerformConnectionCallbacks = false;
  private final String[] mScopes;
  private T mService;
  
  protected GmsClient(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener, String... paramVarArgs)
  {
    if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
      throw new IllegalStateException("Clients must be created on the UI thread.");
    }
    mContext = ((Context)Preconditions.checkNotNull(paramContext));
    mConnectionListeners = new ArrayList();
    mConnectionListeners.add(Preconditions.checkNotNull(paramConnectionCallbacks));
    mConnectionFailedListeners = new ArrayList();
    mConnectionFailedListeners.add(Preconditions.checkNotNull(paramOnConnectionFailedListener));
    mHandler = new CallbackHandler();
    mScopes = paramVarArgs;
  }
  
  protected final void checkConnected()
  {
    if (!isConnected()) {
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }
  }
  
  public void connect()
  {
    mPerformConnectionCallbacks = true;
    int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(mContext);
    if (i != 0)
    {
      mHandler.sendMessage(mHandler.obtainMessage(3, Integer.valueOf(i)));
      return;
    }
    Intent localIntent = new Intent(getStartServiceAction());
    if (mConnection != null)
    {
      Log.e("GmsClient", "Calling connect() while still connected, missing disconnect().");
      mService = null;
      mContext.unbindService(mConnection);
    }
    mConnection = new GmsServiceConnection();
    boolean bool = mContext.bindService(localIntent, mConnection, 129);
    Log.i("GmsClient", "connect: bindService returned " + bool + " for " + localIntent);
  }
  
  protected abstract T createServiceInterface(IBinder paramIBinder);
  
  public void disconnect()
  {
    mPerformConnectionCallbacks = false;
    synchronized (mCallbackProxyList)
    {
      int j = mCallbackProxyList.size();
      int i = 0;
      while (i < j)
      {
        ((CallbackProxy)mCallbackProxyList.get(i)).removeListener();
        i += 1;
      }
      mCallbackProxyList.clear();
      mService = null;
      if (mConnection != null)
      {
        mContext.unbindService(mConnection);
        mConnection = null;
      }
      return;
    }
  }
  
  public final void doCallback(GmsClient<T>.CallbackProxy<?> paramGmsClient)
  {
    mHandler.sendMessage(mHandler.obtainMessage(2, paramGmsClient));
  }
  
  public final Context getContext()
  {
    return mContext;
  }
  
  protected final T getService()
  {
    checkConnected();
    return mService;
  }
  
  protected abstract String getServiceDescriptor();
  
  protected abstract void getServiceFromBroker(IGmsServiceBroker paramIGmsServiceBroker, GmsClient<T>.GmsCallbacks paramGmsClient)
    throws RemoteException;
  
  protected abstract String getStartServiceAction();
  
  public boolean isConnected()
  {
    return mService != null;
  }
  
  protected final void onConnectionFailure(ConnectionResult paramConnectionResult)
  {
    mHandler.removeMessages(4);
    for (;;)
    {
      int i;
      synchronized (mConnectionFailedListeners)
      {
        mIsProcessingOnConnectionFailed = true;
        ArrayList localArrayList2 = mConnectionFailedListeners;
        i = 0;
        int j = localArrayList2.size();
        if (i < j)
        {
          if (!mPerformConnectionCallbacks) {
            return;
          }
          if (mConnectionFailedListeners.contains(localArrayList2.get(i))) {
            ((GooglePlayServicesClient.OnConnectionFailedListener)localArrayList2.get(i)).onConnectionFailed(paramConnectionResult);
          }
        }
        else
        {
          mIsProcessingOnConnectionFailed = false;
          return;
        }
      }
      i += 1;
    }
  }
  
  protected final void onConnectionSuccess()
  {
    boolean bool2 = true;
    for (;;)
    {
      int i;
      synchronized (mConnectionListeners)
      {
        if (!mIsProcessingConnectionCallback)
        {
          bool1 = true;
          Preconditions.checkState(bool1);
          mHandler.removeMessages(4);
          mIsProcessingConnectionCallback = true;
          if (mConnectionListenersRemoved.size() != 0) {
            break label158;
          }
          bool1 = bool2;
          Preconditions.checkState(bool1);
          ArrayList localArrayList2 = mConnectionListeners;
          i = 0;
          int j = localArrayList2.size();
          if ((i >= j) || (!mPerformConnectionCallbacks) || (!isConnected()))
          {
            mConnectionListenersRemoved.clear();
            mIsProcessingConnectionCallback = false;
            return;
          }
          mConnectionListenersRemoved.size();
          if (mConnectionListenersRemoved.contains(localArrayList2.get(i))) {
            break label163;
          }
          ((GooglePlayServicesClient.ConnectionCallbacks)localArrayList2.get(i)).onConnected();
        }
      }
      boolean bool1 = false;
      continue;
      label158:
      bool1 = false;
      continue;
      label163:
      i += 1;
    }
  }
  
  protected final void onDisconnection()
  {
    mHandler.removeMessages(4);
    for (;;)
    {
      int i;
      synchronized (mConnectionListeners)
      {
        mIsProcessingConnectionCallback = true;
        ArrayList localArrayList2 = mConnectionListeners;
        i = 0;
        int j = localArrayList2.size();
        if ((i >= j) || (!mPerformConnectionCallbacks))
        {
          mIsProcessingConnectionCallback = false;
          return;
        }
        if (mConnectionListeners.contains(localArrayList2.get(i))) {
          ((GooglePlayServicesClient.ConnectionCallbacks)localArrayList2.get(i)).onDisconnected();
        }
      }
      i += 1;
    }
  }
  
  protected final void onServiceBrokerBound(IBinder paramIBinder)
  {
    try
    {
      getServiceFromBroker(IGmsServiceBroker.Stub.asInterface(paramIBinder), new GmsCallbacks());
      return;
    }
    catch (RemoteException paramIBinder)
    {
      Log.w("GmsClient", "service died");
    }
  }
  
  final class CallbackHandler
    extends Handler
  {
    CallbackHandler() {}
    
    public void handleMessage(Message paramMessage)
    {
      if (what == 3) {
        onConnectionFailure(new ConnectionResult(((Integer)obj).intValue(), null));
      }
      do
      {
        return;
        if (what == 4) {
          synchronized (mConnectionListeners)
          {
            if ((mPerformConnectionCallbacks) && (isConnected()) && (mConnectionListeners.contains(obj))) {
              ((GooglePlayServicesClient.ConnectionCallbacks)obj).onConnected();
            }
            return;
          }
        }
      } while (((what == 2) && (!isConnected())) || ((what != 2) && (what != 1)));
      ((GmsClient.CallbackProxy)obj).deliverCallback();
    }
  }
  
  protected abstract class CallbackProxy<TListener>
  {
    private TListener mListener;
    
    public CallbackProxy()
    {
      mListener = ???;
      synchronized (mCallbackProxyList)
      {
        mCallbackProxyList.add(this);
        return;
      }
    }
    
    public void deliverCallback()
    {
      try
      {
        Object localObject1 = mListener;
        deliverCallback(localObject1);
        return;
      }
      finally {}
    }
    
    protected abstract void deliverCallback(TListener paramTListener);
    
    public void removeListener()
    {
      try
      {
        mListener = null;
        return;
      }
      finally {}
    }
  }
  
  protected final class GmsCallbacks
    extends IGmsCallbacks.Stub
  {
    protected GmsCallbacks() {}
    
    public void onPostInitComplete(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    {
      mHandler.sendMessage(mHandler.obtainMessage(1, new GmsClient.PostInitCallback(GmsClient.this, paramInt, paramIBinder, paramBundle)));
    }
  }
  
  final class GmsServiceConnection
    implements ServiceConnection
  {
    GmsServiceConnection() {}
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      Log.d("GmsClient", "service broker connected, binder: " + paramIBinder);
      onServiceBrokerBound(paramIBinder);
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      Log.d("GmsClient", "service disconnected: " + paramComponentName);
      GmsClient.access$002(GmsClient.this, null);
      onDisconnection();
    }
  }
  
  protected final class PostInitCallback
    extends GmsClient<T>.CallbackProxy<Boolean>
  {
    public final Bundle resolution;
    public final IBinder service;
    public final int statusCode;
    
    public PostInitCallback(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    {
      super(Boolean.valueOf(true));
      statusCode = paramInt;
      service = paramIBinder;
      resolution = paramBundle;
    }
    
    protected void deliverCallback(Boolean paramBoolean)
    {
      if (paramBoolean == null) {
        return;
      }
      switch (statusCode)
      {
      default: 
        paramBoolean = (PendingIntent)resolution.getParcelable("pendingIntent");
        onConnectionFailure(new ConnectionResult(statusCode, paramBoolean));
        return;
      }
      try
      {
        paramBoolean = service.getInterfaceDescriptor();
        if (getServiceDescriptor().equals(paramBoolean))
        {
          Log.d("GmsClient", "bound to service broker");
          GmsClient.access$002(GmsClient.this, createServiceInterface(service));
          if (mService != null)
          {
            onConnectionSuccess();
            return;
          }
        }
      }
      catch (RemoteException paramBoolean)
      {
        mContext.unbindService(mConnection);
        GmsClient.access$302(GmsClient.this, null);
        GmsClient.access$002(GmsClient.this, null);
        onConnectionFailure(new ConnectionResult(8, null));
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.GmsClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */