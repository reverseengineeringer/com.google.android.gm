.class public Lcom/android/mail/ui/FolderItemView;
.super Landroid/widget/RelativeLayout;
.source "FolderItemView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/ui/FolderItemView$DropHandler;
    }
.end annotation


# static fields
.field private static DRAG_STEADY_STATE_BACKGROUND:Landroid/graphics/drawable/Drawable;

.field private static DROPPABLE_HOVER_BACKGROUND:Landroid/graphics/drawable/Drawable;

.field private static NON_DROPPABLE_TARGET_TEXT_COLOR:I

.field private static SHORTCUT_ICON:Landroid/graphics/Bitmap;


# instance fields
.field private mBackground:Landroid/graphics/drawable/Drawable;

.field private mDropHandler:Lcom/android/mail/ui/FolderItemView$DropHandler;

.field private mFolder:Lcom/android/mail/providers/Folder;

.field private mFolderParentIcon:Landroid/widget/ImageView;

.field private mFolderTextView:Landroid/widget/TextView;

.field private mInitialFolderTextColor:Landroid/content/res/ColorStateList;

.field private mInitialUnreadCountTextColor:Landroid/content/res/ColorStateList;

.field private mUnreadCountTextView:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 81
    invoke-direct {p0, p1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    .line 82
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 85
    invoke-direct {p0, p1, p2}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 86
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 89
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 90
    return-void
.end method

.method private isDroppableTarget(Landroid/view/DragEvent;)Z
    .locals 2
    .param p1, "event"    # Landroid/view/DragEvent;

    .prologue
    .line 128
    iget-object v0, p0, Lcom/android/mail/ui/FolderItemView;->mDropHandler:Lcom/android/mail/ui/FolderItemView$DropHandler;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/ui/FolderItemView;->mDropHandler:Lcom/android/mail/ui/FolderItemView$DropHandler;

    iget-object v1, p0, Lcom/android/mail/ui/FolderItemView;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-interface {v0, p1, v1}, Lcom/android/mail/ui/FolderItemView$DropHandler;->supportsDrag(Landroid/view/DragEvent;Lcom/android/mail/providers/Folder;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public bind(Lcom/android/mail/providers/Folder;Lcom/android/mail/ui/FolderItemView$DropHandler;)V
    .locals 5
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;
    .param p2, "dropHandler"    # Lcom/android/mail/ui/FolderItemView$DropHandler;

    .prologue
    const/16 v3, 0x8

    const/4 v2, 0x0

    .line 115
    iput-object p1, p0, Lcom/android/mail/ui/FolderItemView;->mFolder:Lcom/android/mail/providers/Folder;

    .line 116
    iput-object p2, p0, Lcom/android/mail/ui/FolderItemView;->mDropHandler:Lcom/android/mail/ui/FolderItemView$DropHandler;

    .line 117
    iget-object v1, p0, Lcom/android/mail/ui/FolderItemView;->mFolderTextView:Landroid/widget/TextView;

    iget-object v4, p1, Lcom/android/mail/providers/Folder;->name:Ljava/lang/String;

    invoke-virtual {v1, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 118
    iget-object v4, p0, Lcom/android/mail/ui/FolderItemView;->mFolderParentIcon:Landroid/widget/ImageView;

    iget-object v1, p0, Lcom/android/mail/ui/FolderItemView;->mFolder:Lcom/android/mail/providers/Folder;

    iget-boolean v1, v1, Lcom/android/mail/providers/Folder;->hasChildren:Z

    if-eqz v1, :cond_1

    move v1, v2

    :goto_0
    invoke-virtual {v4, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 119
    iget-object v1, p0, Lcom/android/mail/ui/FolderItemView;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-static {v1}, Lcom/android/mail/utils/Utils;->getFolderUnreadDisplayCount(Lcom/android/mail/providers/Folder;)I

    move-result v0

    .line 120
    .local v0, "count":I
    iget-object v1, p0, Lcom/android/mail/ui/FolderItemView;->mUnreadCountTextView:Landroid/widget/TextView;

    if-lez v0, :cond_2

    :goto_1
    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 122
    if-lez v0, :cond_0

    .line 123
    iget-object v1, p0, Lcom/android/mail/ui/FolderItemView;->mUnreadCountTextView:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/android/mail/ui/FolderItemView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2, v0}, Lcom/android/mail/utils/Utils;->getUnreadCountString(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 125
    :cond_0
    return-void

    .end local v0    # "count":I
    :cond_1
    move v1, v3

    .line 118
    goto :goto_0

    .restart local v0    # "count":I
    :cond_2
    move v2, v3

    .line 120
    goto :goto_1
.end method

.method public onDragEvent(Landroid/view/DragEvent;)Z
    .locals 3
    .param p1, "event"    # Landroid/view/DragEvent;

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x1

    .line 138
    invoke-virtual {p1}, Landroid/view/DragEvent;->getAction()I

    move-result v2

    packed-switch v2, :pswitch_data_0

    :cond_0
    move v0, v1

    .line 190
    :goto_0
    :pswitch_0
    return v0

    .line 141
    :pswitch_1
    invoke-direct {p0, p1}, Lcom/android/mail/ui/FolderItemView;->isDroppableTarget(Landroid/view/DragEvent;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 143
    iget-object v1, p0, Lcom/android/mail/ui/FolderItemView;->mFolderTextView:Landroid/widget/TextView;

    invoke-virtual {v1}, Landroid/widget/TextView;->getTextColors()Landroid/content/res/ColorStateList;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/ui/FolderItemView;->mInitialFolderTextColor:Landroid/content/res/ColorStateList;

    .line 144
    iget-object v1, p0, Lcom/android/mail/ui/FolderItemView;->mUnreadCountTextView:Landroid/widget/TextView;

    invoke-virtual {v1}, Landroid/widget/TextView;->getTextColors()Landroid/content/res/ColorStateList;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/ui/FolderItemView;->mInitialUnreadCountTextColor:Landroid/content/res/ColorStateList;

    .line 145
    iget-object v1, p0, Lcom/android/mail/ui/FolderItemView;->mFolderTextView:Landroid/widget/TextView;

    sget v2, Lcom/android/mail/ui/FolderItemView;->NON_DROPPABLE_TARGET_TEXT_COLOR:I

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setTextColor(I)V

    .line 146
    iget-object v1, p0, Lcom/android/mail/ui/FolderItemView;->mUnreadCountTextView:Landroid/widget/TextView;

    sget v2, Lcom/android/mail/ui/FolderItemView;->NON_DROPPABLE_TARGET_TEXT_COLOR:I

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setTextColor(I)V

    .line 149
    :cond_1
    sget-object v1, Lcom/android/mail/ui/FolderItemView;->DRAG_STEADY_STATE_BACKGROUND:Landroid/graphics/drawable/Drawable;

    invoke-virtual {p0, v1}, Lcom/android/mail/ui/FolderItemView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0

    .line 154
    :pswitch_2
    invoke-direct {p0, p1}, Lcom/android/mail/ui/FolderItemView;->isDroppableTarget(Landroid/view/DragEvent;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 155
    sget-object v1, Lcom/android/mail/ui/FolderItemView;->DROPPABLE_HOVER_BACKGROUND:Landroid/graphics/drawable/Drawable;

    invoke-virtual {p0, v1}, Lcom/android/mail/ui/FolderItemView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0

    .line 163
    :pswitch_3
    invoke-direct {p0, p1}, Lcom/android/mail/ui/FolderItemView;->isDroppableTarget(Landroid/view/DragEvent;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 164
    sget-object v1, Lcom/android/mail/ui/FolderItemView;->DRAG_STEADY_STATE_BACKGROUND:Landroid/graphics/drawable/Drawable;

    invoke-virtual {p0, v1}, Lcom/android/mail/ui/FolderItemView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0

    .line 171
    :pswitch_4
    invoke-direct {p0, p1}, Lcom/android/mail/ui/FolderItemView;->isDroppableTarget(Landroid/view/DragEvent;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 172
    iget-object v1, p0, Lcom/android/mail/ui/FolderItemView;->mFolderTextView:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/android/mail/ui/FolderItemView;->mInitialFolderTextColor:Landroid/content/res/ColorStateList;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setTextColor(Landroid/content/res/ColorStateList;)V

    .line 173
    iget-object v1, p0, Lcom/android/mail/ui/FolderItemView;->mUnreadCountTextView:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/android/mail/ui/FolderItemView;->mInitialUnreadCountTextColor:Landroid/content/res/ColorStateList;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setTextColor(Landroid/content/res/ColorStateList;)V

    .line 176
    :cond_2
    iget-object v1, p0, Lcom/android/mail/ui/FolderItemView;->mBackground:Landroid/graphics/drawable/Drawable;

    invoke-virtual {p0, v1}, Lcom/android/mail/ui/FolderItemView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0

    .line 183
    :pswitch_5
    iget-object v2, p0, Lcom/android/mail/ui/FolderItemView;->mDropHandler:Lcom/android/mail/ui/FolderItemView$DropHandler;

    if-nez v2, :cond_3

    move v0, v1

    .line 184
    goto :goto_0

    .line 187
    :cond_3
    iget-object v1, p0, Lcom/android/mail/ui/FolderItemView;->mDropHandler:Lcom/android/mail/ui/FolderItemView$DropHandler;

    iget-object v2, p0, Lcom/android/mail/ui/FolderItemView;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-interface {v1, p1, v2}, Lcom/android/mail/ui/FolderItemView$DropHandler;->handleDrop(Landroid/view/DragEvent;Lcom/android/mail/providers/Folder;)V

    goto :goto_0

    .line 138
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_5
        :pswitch_4
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method protected onFinishInflate()V
    .locals 2

    .prologue
    .line 94
    invoke-super {p0}, Landroid/widget/RelativeLayout;->onFinishInflate()V

    .line 95
    sget-object v1, Lcom/android/mail/ui/FolderItemView;->SHORTCUT_ICON:Landroid/graphics/Bitmap;

    if-nez v1, :cond_0

    .line 96
    invoke-virtual {p0}, Lcom/android/mail/ui/FolderItemView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 97
    .local v0, "res":Landroid/content/res/Resources;
    const v1, 0x7f030001

    invoke-static {v0, v1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v1

    sput-object v1, Lcom/android/mail/ui/FolderItemView;->SHORTCUT_ICON:Landroid/graphics/Bitmap;

    .line 99
    const v1, 0x7f02001e

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    sput-object v1, Lcom/android/mail/ui/FolderItemView;->DROPPABLE_HOVER_BACKGROUND:Landroid/graphics/drawable/Drawable;

    .line 101
    const v1, 0x7f020020

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    sput-object v1, Lcom/android/mail/ui/FolderItemView;->DRAG_STEADY_STATE_BACKGROUND:Landroid/graphics/drawable/Drawable;

    .line 103
    const v1, 0x7f090022

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    sput v1, Lcom/android/mail/ui/FolderItemView;->NON_DROPPABLE_TARGET_TEXT_COLOR:I

    .line 106
    .end local v0    # "res":Landroid/content/res/Resources;
    :cond_0
    const v1, 0x7f10003d

    invoke-virtual {p0, v1}, Lcom/android/mail/ui/FolderItemView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/android/mail/ui/FolderItemView;->mFolderTextView:Landroid/widget/TextView;

    .line 107
    const v1, 0x7f10003c

    invoke-virtual {p0, v1}, Lcom/android/mail/ui/FolderItemView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/android/mail/ui/FolderItemView;->mUnreadCountTextView:Landroid/widget/TextView;

    .line 108
    invoke-virtual {p0}, Lcom/android/mail/ui/FolderItemView;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/ui/FolderItemView;->mBackground:Landroid/graphics/drawable/Drawable;

    .line 109
    iget-object v1, p0, Lcom/android/mail/ui/FolderItemView;->mFolderTextView:Landroid/widget/TextView;

    invoke-virtual {v1}, Landroid/widget/TextView;->getTextColors()Landroid/content/res/ColorStateList;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/ui/FolderItemView;->mInitialFolderTextColor:Landroid/content/res/ColorStateList;

    .line 110
    iget-object v1, p0, Lcom/android/mail/ui/FolderItemView;->mUnreadCountTextView:Landroid/widget/TextView;

    invoke-virtual {v1}, Landroid/widget/TextView;->getTextColors()Landroid/content/res/ColorStateList;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/ui/FolderItemView;->mInitialUnreadCountTextColor:Landroid/content/res/ColorStateList;

    .line 111
    const v1, 0x7f10003a

    invoke-virtual {p0, v1}, Lcom/android/mail/ui/FolderItemView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/android/mail/ui/FolderItemView;->mFolderParentIcon:Landroid/widget/ImageView;

    .line 112
    return-void
.end method
