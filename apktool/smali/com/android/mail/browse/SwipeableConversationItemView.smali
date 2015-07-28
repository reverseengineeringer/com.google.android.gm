.class public Lcom/android/mail/browse/SwipeableConversationItemView;
.super Landroid/widget/FrameLayout;
.source "SwipeableConversationItemView.java"

# interfaces
.implements Lcom/android/mail/browse/ToggleableItem;


# instance fields
.field private mBackground:Landroid/view/View;

.field private mConversationItemView:Lcom/android/mail/browse/ConversationItemView;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "account"    # Ljava/lang/String;

    .prologue
    .line 41
    invoke-direct {p0, p1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    .line 42
    new-instance v0, Lcom/android/mail/browse/ConversationItemView;

    invoke-direct {v0, p1, p2}, Lcom/android/mail/browse/ConversationItemView;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/android/mail/browse/SwipeableConversationItemView;->mConversationItemView:Lcom/android/mail/browse/ConversationItemView;

    .line 43
    iget-object v0, p0, Lcom/android/mail/browse/SwipeableConversationItemView;->mConversationItemView:Lcom/android/mail/browse/ConversationItemView;

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/SwipeableConversationItemView;->addView(Landroid/view/View;)V

    .line 44
    return-void
.end method


# virtual methods
.method public addBackground(Landroid/content/Context;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 47
    const v0, 0x7f100033

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/SwipeableConversationItemView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/SwipeableConversationItemView;->mBackground:Landroid/view/View;

    .line 48
    iget-object v0, p0, Lcom/android/mail/browse/SwipeableConversationItemView;->mBackground:Landroid/view/View;

    if-nez v0, :cond_0

    .line 49
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f040011

    const/4 v2, 0x0

    const/4 v3, 0x1

    invoke-virtual {v0, v1, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/SwipeableConversationItemView;->mBackground:Landroid/view/View;

    .line 50
    iget-object v0, p0, Lcom/android/mail/browse/SwipeableConversationItemView;->mBackground:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/android/mail/browse/SwipeableConversationItemView;->addView(Landroid/view/View;I)V

    .line 52
    :cond_0
    return-void
.end method

.method public bind(Landroid/database/Cursor;Lcom/android/mail/ui/ControllableActivity;Lcom/android/mail/ui/ConversationSelectionSet;Lcom/android/mail/providers/Folder;ZZZLcom/android/mail/ui/AnimatedAdapter;)V
    .locals 9
    .param p1, "cursor"    # Landroid/database/Cursor;
    .param p2, "activity"    # Lcom/android/mail/ui/ControllableActivity;
    .param p3, "set"    # Lcom/android/mail/ui/ConversationSelectionSet;
    .param p4, "folder"    # Lcom/android/mail/providers/Folder;
    .param p5, "checkboxesDisabled"    # Z
    .param p6, "swipeEnabled"    # Z
    .param p7, "priorityArrowsEnabled"    # Z
    .param p8, "animatedAdapter"    # Lcom/android/mail/ui/AnimatedAdapter;

    .prologue
    .line 83
    iget-object v0, p0, Lcom/android/mail/browse/SwipeableConversationItemView;->mConversationItemView:Lcom/android/mail/browse/ConversationItemView;

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move v5, p5

    move v6, p6

    move/from16 v7, p7

    move-object/from16 v8, p8

    invoke-virtual/range {v0 .. v8}, Lcom/android/mail/browse/ConversationItemView;->bind(Landroid/database/Cursor;Lcom/android/mail/ui/ControllableActivity;Lcom/android/mail/ui/ConversationSelectionSet;Lcom/android/mail/providers/Folder;ZZZLcom/android/mail/ui/AnimatedAdapter;)V

    .line 85
    return-void
.end method

.method public bind(Lcom/android/mail/providers/Conversation;Lcom/android/mail/ui/ControllableActivity;Lcom/android/mail/ui/ConversationSelectionSet;Lcom/android/mail/providers/Folder;ZZZLcom/android/mail/ui/AnimatedAdapter;)V
    .locals 9
    .param p1, "conversation"    # Lcom/android/mail/providers/Conversation;
    .param p2, "activity"    # Lcom/android/mail/ui/ControllableActivity;
    .param p3, "set"    # Lcom/android/mail/ui/ConversationSelectionSet;
    .param p4, "folder"    # Lcom/android/mail/providers/Folder;
    .param p5, "checkboxesDisabled"    # Z
    .param p6, "swipeEnabled"    # Z
    .param p7, "priorityArrowsEnabled"    # Z
    .param p8, "animatedAdapter"    # Lcom/android/mail/ui/AnimatedAdapter;

    .prologue
    .line 76
    iget-object v0, p0, Lcom/android/mail/browse/SwipeableConversationItemView;->mConversationItemView:Lcom/android/mail/browse/ConversationItemView;

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move v5, p5

    move v6, p6

    move/from16 v7, p7

    move-object/from16 v8, p8

    invoke-virtual/range {v0 .. v8}, Lcom/android/mail/browse/ConversationItemView;->bind(Lcom/android/mail/providers/Conversation;Lcom/android/mail/ui/ControllableActivity;Lcom/android/mail/ui/ConversationSelectionSet;Lcom/android/mail/providers/Folder;ZZZLcom/android/mail/ui/AnimatedAdapter;)V

    .line 78
    return-void
.end method

.method public getListView()Landroid/widget/ListView;
    .locals 1

    .prologue
    .line 61
    invoke-virtual {p0}, Lcom/android/mail/browse/SwipeableConversationItemView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    return-object v0
.end method

.method public getSwipeableItemView()Lcom/android/mail/browse/ConversationItemView;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/android/mail/browse/SwipeableConversationItemView;->mConversationItemView:Lcom/android/mail/browse/ConversationItemView;

    return-object v0
.end method

.method public removeBackground()V
    .locals 1

    .prologue
    .line 103
    iget-object v0, p0, Lcom/android/mail/browse/SwipeableConversationItemView;->mBackground:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 104
    iget-object v0, p0, Lcom/android/mail/browse/SwipeableConversationItemView;->mBackground:Landroid/view/View;

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/SwipeableConversationItemView;->removeView(Landroid/view/View;)V

    .line 106
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/mail/browse/SwipeableConversationItemView;->mBackground:Landroid/view/View;

    .line 107
    return-void
.end method

.method public reset()V
    .locals 1

    .prologue
    .line 65
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/SwipeableConversationItemView;->setBackgroundVisibility(I)V

    .line 66
    iget-object v0, p0, Lcom/android/mail/browse/SwipeableConversationItemView;->mConversationItemView:Lcom/android/mail/browse/ConversationItemView;

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationItemView;->reset()V

    .line 67
    return-void
.end method

.method public setBackgroundVisibility(I)V
    .locals 1
    .param p1, "visibility"    # I

    .prologue
    .line 55
    iget-object v0, p0, Lcom/android/mail/browse/SwipeableConversationItemView;->mBackground:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 56
    iget-object v0, p0, Lcom/android/mail/browse/SwipeableConversationItemView;->mBackground:Landroid/view/View;

    invoke-virtual {v0, p1}, Landroid/view/View;->setVisibility(I)V

    .line 58
    :cond_0
    return-void
.end method

.method public startDeleteAnimation(Lcom/android/mail/ui/AnimatedAdapter;Z)V
    .locals 1
    .param p1, "listener"    # Lcom/android/mail/ui/AnimatedAdapter;
    .param p2, "swipe"    # Z

    .prologue
    .line 110
    if-eqz p2, :cond_0

    .line 111
    iget-object v0, p0, Lcom/android/mail/browse/SwipeableConversationItemView;->mConversationItemView:Lcom/android/mail/browse/ConversationItemView;

    invoke-virtual {v0, p1}, Lcom/android/mail/browse/ConversationItemView;->startDestroyWithSwipeAnimation(Landroid/animation/Animator$AnimatorListener;)V

    .line 115
    :goto_0
    return-void

    .line 113
    :cond_0
    iget-object v0, p0, Lcom/android/mail/browse/SwipeableConversationItemView;->mConversationItemView:Lcom/android/mail/browse/ConversationItemView;

    invoke-virtual {v0, p1}, Lcom/android/mail/browse/ConversationItemView;->startDestroyAnimation(Landroid/animation/Animator$AnimatorListener;)V

    goto :goto_0
.end method

.method public startUndoAnimation(Lcom/android/mail/ui/ViewMode;Lcom/android/mail/ui/AnimatedAdapter;Z)V
    .locals 1
    .param p1, "viewMode"    # Lcom/android/mail/ui/ViewMode;
    .param p2, "listener"    # Lcom/android/mail/ui/AnimatedAdapter;
    .param p3, "swipe"    # Z

    .prologue
    .line 88
    if-eqz p3, :cond_0

    .line 89
    invoke-virtual {p0}, Lcom/android/mail/browse/SwipeableConversationItemView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/SwipeableConversationItemView;->addBackground(Landroid/content/Context;)V

    .line 90
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/SwipeableConversationItemView;->setBackgroundVisibility(I)V

    .line 91
    iget-object v0, p0, Lcom/android/mail/browse/SwipeableConversationItemView;->mConversationItemView:Lcom/android/mail/browse/ConversationItemView;

    invoke-virtual {v0, p1, p2}, Lcom/android/mail/browse/ConversationItemView;->startSwipeUndoAnimation(Lcom/android/mail/ui/ViewMode;Landroid/animation/Animator$AnimatorListener;)V

    .line 97
    :goto_0
    return-void

    .line 93
    :cond_0
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/SwipeableConversationItemView;->setBackgroundVisibility(I)V

    .line 94
    iget-object v0, p0, Lcom/android/mail/browse/SwipeableConversationItemView;->mConversationItemView:Lcom/android/mail/browse/ConversationItemView;

    invoke-virtual {v0, p1, p2}, Lcom/android/mail/browse/ConversationItemView;->startUndoAnimation(Lcom/android/mail/ui/ViewMode;Landroid/animation/Animator$AnimatorListener;)V

    goto :goto_0
.end method

.method public toggleCheckMarkOrBeginDrag()V
    .locals 1

    .prologue
    .line 119
    iget-object v0, p0, Lcom/android/mail/browse/SwipeableConversationItemView;->mConversationItemView:Lcom/android/mail/browse/ConversationItemView;

    if-eqz v0, :cond_0

    .line 120
    iget-object v0, p0, Lcom/android/mail/browse/SwipeableConversationItemView;->mConversationItemView:Lcom/android/mail/browse/ConversationItemView;

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationItemView;->toggleCheckMarkOrBeginDrag()V

    .line 122
    :cond_0
    return-void
.end method
