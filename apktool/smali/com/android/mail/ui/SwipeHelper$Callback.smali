.class public interface abstract Lcom/android/mail/ui/SwipeHelper$Callback;
.super Ljava/lang/Object;
.source "SwipeHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/SwipeHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "Callback"
.end annotation


# virtual methods
.method public abstract canChildBeDismissed(Lcom/android/mail/ui/SwipeableItemView;)Z
.end method

.method public abstract getChildAtPosition(Landroid/view/MotionEvent;)Landroid/view/View;
.end method

.method public abstract onBeginDrag(Landroid/view/View;)V
.end method

.method public abstract onChildDismissed(Lcom/android/mail/ui/SwipeableItemView;)V
.end method

.method public abstract onDragCancelled(Lcom/android/mail/ui/SwipeableItemView;)V
.end method

.method public abstract onScroll()V
.end method
