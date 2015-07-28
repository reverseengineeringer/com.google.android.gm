.class public interface abstract Lcom/android/mail/ui/SwipeableListView$ListItemSwipedListener;
.super Ljava/lang/Object;
.source "SwipeableListView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/SwipeableListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "ListItemSwipedListener"
.end annotation


# virtual methods
.method public abstract onListItemSwiped(Ljava/util/Collection;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;)V"
        }
    .end annotation
.end method
