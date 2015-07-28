package com.android.mail.browse;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.android.mail.utils.LogTag;

public class SuperCollapsedBlock
  extends FrameLayout
  implements View.OnClickListener
{
  private static final String LOG_TAG = ;
  private View mBackgroundView;
  private OnClickListener mClick;
  private TextView mCountView;
  private View mIconView;
  private ConversationViewAdapter.SuperCollapsedBlockItem mModel;
  
  public SuperCollapsedBlock(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SuperCollapsedBlock(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setActivated(false);
    setOnClickListener(this);
  }
  
  public void bind(ConversationViewAdapter.SuperCollapsedBlockItem paramSuperCollapsedBlockItem)
  {
    mModel = paramSuperCollapsedBlockItem;
    setCount(paramSuperCollapsedBlockItem.getEnd() - paramSuperCollapsedBlockItem.getStart() + 1);
  }
  
  public void initialize(OnClickListener paramOnClickListener)
  {
    mClick = paramOnClickListener;
  }
  
  public void onClick(View paramView)
  {
    ((TextView)findViewById(2131755250)).setText(2131493083);
    mCountView.setVisibility(8);
    if (mClick != null) {
      getHandler().post(new Runnable()
      {
        public void run()
        {
          mClick.onSuperCollapsedClick(mModel);
        }
      });
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    mIconView = findViewById(2131755248);
    mCountView = ((TextView)findViewById(2131755249));
    mBackgroundView = findViewById(2131755247);
    BitmapDrawable localBitmapDrawable = (BitmapDrawable)getResources().getDrawable(2130837544);
    localBitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
    mBackgroundView.setBackgroundDrawable(localBitmapDrawable);
  }
  
  public void setCount(int paramInt)
  {
    mCountView.setText(Integer.toString(paramInt));
    mIconView.getBackground().setLevel(paramInt);
  }
  
  public static abstract interface OnClickListener
  {
    public abstract void onSuperCollapsedClick(ConversationViewAdapter.SuperCollapsedBlockItem paramSuperCollapsedBlockItem);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.SuperCollapsedBlock
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */