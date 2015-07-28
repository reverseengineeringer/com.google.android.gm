.class public final Lcom/android/mail/browse/ConversationListFooterView;
.super Landroid/widget/LinearLayout;
.source "ConversationListFooterView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcom/android/mail/ui/ViewMode$ModeChangeListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/browse/ConversationListFooterView$FooterViewClickListener;
    }
.end annotation


# static fields
.field private static sNormalBackground:Landroid/graphics/drawable/Drawable;

.field private static sWideBackground:Landroid/graphics/drawable/Drawable;


# instance fields
.field private mClickListener:Lcom/android/mail/browse/ConversationListFooterView$FooterViewClickListener;

.field private mErrorActionButton:Landroid/widget/Button;

.field private mErrorStatus:I

.field private mErrorText:Landroid/widget/TextView;

.field private mFolder:Lcom/android/mail/providers/Folder;

.field private mLoadMore:Landroid/view/View;

.field private mLoadMoreUri:Landroid/net/Uri;

.field private mLoading:Landroid/view/View;

.field private mNetworkError:Landroid/view/View;

.field private final mTabletDevice:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 59
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 60
    invoke-static {p1}, Lcom/android/mail/utils/Utils;->useTabletUI(Landroid/content/Context;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/android/mail/browse/ConversationListFooterView;->mTabletDevice:Z

    .line 61
    return-void
.end method

.method private getBackground(I)Landroid/graphics/drawable/Drawable;
    .locals 1
    .param p1, "resId"    # I

    .prologue
    .line 193
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationListFooterView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    return-object v0
.end method

.method private getNormalBackground()Landroid/graphics/drawable/Drawable;
    .locals 1

    .prologue
    .line 186
    sget-object v0, Lcom/android/mail/browse/ConversationListFooterView;->sNormalBackground:Landroid/graphics/drawable/Drawable;

    if-nez v0, :cond_0

    .line 187
    const v0, 0x7f020018

    invoke-direct {p0, v0}, Lcom/android/mail/browse/ConversationListFooterView;->getBackground(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    sput-object v0, Lcom/android/mail/browse/ConversationListFooterView;->sNormalBackground:Landroid/graphics/drawable/Drawable;

    .line 189
    :cond_0
    sget-object v0, Lcom/android/mail/browse/ConversationListFooterView;->sNormalBackground:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method private getWideBackground()Landroid/graphics/drawable/Drawable;
    .locals 1

    .prologue
    .line 179
    sget-object v0, Lcom/android/mail/browse/ConversationListFooterView;->sWideBackground:Landroid/graphics/drawable/Drawable;

    if-nez v0, :cond_0

    .line 180
    const v0, 0x7f02001a

    invoke-direct {p0, v0}, Lcom/android/mail/browse/ConversationListFooterView;->getBackground(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    sput-object v0, Lcom/android/mail/browse/ConversationListFooterView;->sWideBackground:Landroid/graphics/drawable/Drawable;

    .line 182
    :cond_0
    sget-object v0, Lcom/android/mail/browse/ConversationListFooterView;->sWideBackground:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 82
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v1

    .line 83
    .local v1, "id":I
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Folder;

    .line 84
    .local v0, "f":Lcom/android/mail/providers/Folder;
    packed-switch v1, :pswitch_data_0

    .line 92
    :goto_0
    :pswitch_0
    return-void

    .line 86
    :pswitch_1
    iget-object v2, p0, Lcom/android/mail/browse/ConversationListFooterView;->mClickListener:Lcom/android/mail/browse/ConversationListFooterView$FooterViewClickListener;

    iget v3, p0, Lcom/android/mail/browse/ConversationListFooterView;->mErrorStatus:I

    invoke-interface {v2, v0, v3}, Lcom/android/mail/browse/ConversationListFooterView$FooterViewClickListener;->onFooterViewErrorActionClick(Lcom/android/mail/providers/Folder;I)V

    goto :goto_0

    .line 89
    :pswitch_2
    iget-object v2, p0, Lcom/android/mail/browse/ConversationListFooterView;->mClickListener:Lcom/android/mail/browse/ConversationListFooterView$FooterViewClickListener;

    invoke-interface {v2, v0}, Lcom/android/mail/browse/ConversationListFooterView$FooterViewClickListener;->onFooterViewLoadMoreClick(Lcom/android/mail/providers/Folder;)V

    goto :goto_0

    .line 84
    :pswitch_data_0
    .packed-switch 0x7f100065
        :pswitch_1
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method protected onFinishInflate()V
    .locals 1

    .prologue
    .line 65
    invoke-super {p0}, Landroid/widget/LinearLayout;->onFinishInflate()V

    .line 67
    const v0, 0x7f100066

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/ConversationListFooterView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/ConversationListFooterView;->mLoading:Landroid/view/View;

    .line 68
    const v0, 0x7f100063

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/ConversationListFooterView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/ConversationListFooterView;->mNetworkError:Landroid/view/View;

    .line 69
    const v0, 0x7f100067

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/ConversationListFooterView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/ConversationListFooterView;->mLoadMore:Landroid/view/View;

    .line 70
    iget-object v0, p0, Lcom/android/mail/browse/ConversationListFooterView;->mLoadMore:Landroid/view/View;

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 71
    const v0, 0x7f100065

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/ConversationListFooterView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/android/mail/browse/ConversationListFooterView;->mErrorActionButton:Landroid/widget/Button;

    .line 72
    iget-object v0, p0, Lcom/android/mail/browse/ConversationListFooterView;->mErrorActionButton:Landroid/widget/Button;

    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 73
    const v0, 0x7f100064

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/ConversationListFooterView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/android/mail/browse/ConversationListFooterView;->mErrorText:Landroid/widget/TextView;

    .line 74
    return-void
.end method

.method public onViewModeChanged(I)V
    .locals 2
    .param p1, "newMode"    # I

    .prologue
    .line 170
    iget-boolean v1, p0, Lcom/android/mail/browse/ConversationListFooterView;->mTabletDevice:Z

    if-eqz v1, :cond_0

    const/4 v1, 0x2

    if-ne p1, v1, :cond_0

    .line 171
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationListFooterView;->getWideBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 175
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    :goto_0
    invoke-virtual {p0, v0}, Lcom/android/mail/browse/ConversationListFooterView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 176
    return-void

    .line 173
    .end local v0    # "drawable":Landroid/graphics/drawable/Drawable;
    :cond_0
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationListFooterView;->getNormalBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .restart local v0    # "drawable":Landroid/graphics/drawable/Drawable;
    goto :goto_0
.end method

.method public setClickListener(Lcom/android/mail/browse/ConversationListFooterView$FooterViewClickListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/android/mail/browse/ConversationListFooterView$FooterViewClickListener;

    .prologue
    .line 77
    iput-object p1, p0, Lcom/android/mail/browse/ConversationListFooterView;->mClickListener:Lcom/android/mail/browse/ConversationListFooterView$FooterViewClickListener;

    .line 78
    return-void
.end method

.method public setFolder(Lcom/android/mail/providers/Folder;)V
    .locals 2
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 95
    iput-object p1, p0, Lcom/android/mail/browse/ConversationListFooterView;->mFolder:Lcom/android/mail/providers/Folder;

    .line 96
    iget-object v0, p0, Lcom/android/mail/browse/ConversationListFooterView;->mErrorActionButton:Landroid/widget/Button;

    iget-object v1, p0, Lcom/android/mail/browse/ConversationListFooterView;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 97
    iget-object v0, p0, Lcom/android/mail/browse/ConversationListFooterView;->mLoadMore:Landroid/view/View;

    iget-object v1, p0, Lcom/android/mail/browse/ConversationListFooterView;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual {v0, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 98
    iget-object v0, p1, Lcom/android/mail/providers/Folder;->loadMoreUri:Landroid/net/Uri;

    iput-object v0, p0, Lcom/android/mail/browse/ConversationListFooterView;->mLoadMoreUri:Landroid/net/Uri;

    .line 99
    return-void
.end method

.method public updateStatus(Lcom/android/mail/browse/ConversationCursor;)Z
    .locals 9
    .param p1, "cursor"    # Lcom/android/mail/browse/ConversationCursor;

    .prologue
    const/4 v5, 0x0

    const/16 v6, 0x8

    .line 105
    if-nez p1, :cond_0

    .line 161
    :goto_0
    return v5

    .line 108
    :cond_0
    const/4 v3, 0x1

    .line 109
    .local v3, "showFooter":Z
    invoke-virtual {p1}, Lcom/android/mail/browse/ConversationCursor;->getExtras()Landroid/os/Bundle;

    move-result-object v2

    .line 110
    .local v2, "extras":Landroid/os/Bundle;
    const-string v4, "cursor_status"

    invoke-virtual {v2, v4}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    .line 111
    .local v1, "cursorStatus":I
    const-string v4, "cursor_error"

    invoke-virtual {v2, v4}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    const-string v4, "cursor_error"

    invoke-virtual {v2, v4}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v4

    :goto_1
    iput v4, p0, Lcom/android/mail/browse/ConversationListFooterView;->mErrorStatus:I

    .line 114
    invoke-static {v1}, Lcom/android/mail/providers/UIProvider$CursorStatus;->isWaitingForResults(I)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 115
    iget-object v4, p0, Lcom/android/mail/browse/ConversationListFooterView;->mLoading:Landroid/view/View;

    invoke-virtual {v4, v5}, Landroid/view/View;->setVisibility(I)V

    .line 116
    iget-object v4, p0, Lcom/android/mail/browse/ConversationListFooterView;->mNetworkError:Landroid/view/View;

    invoke-virtual {v4, v6}, Landroid/view/View;->setVisibility(I)V

    .line 117
    iget-object v4, p0, Lcom/android/mail/browse/ConversationListFooterView;->mLoadMore:Landroid/view/View;

    invoke-virtual {v4, v6}, Landroid/view/View;->setVisibility(I)V

    :goto_2
    move v5, v3

    .line 161
    goto :goto_0

    :cond_1
    move v4, v5

    .line 111
    goto :goto_1

    .line 118
    :cond_2
    iget v4, p0, Lcom/android/mail/browse/ConversationListFooterView;->mErrorStatus:I

    if-eqz v4, :cond_4

    .line 119
    iget-object v4, p0, Lcom/android/mail/browse/ConversationListFooterView;->mNetworkError:Landroid/view/View;

    invoke-virtual {v4, v5}, Landroid/view/View;->setVisibility(I)V

    .line 120
    iget-object v4, p0, Lcom/android/mail/browse/ConversationListFooterView;->mErrorText:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationListFooterView;->getContext()Landroid/content/Context;

    move-result-object v7

    iget v8, p0, Lcom/android/mail/browse/ConversationListFooterView;->mErrorStatus:I

    invoke-static {v7, v8}, Lcom/android/mail/utils/Utils;->getSyncStatusText(Landroid/content/Context;I)Ljava/lang/CharSequence;

    move-result-object v7

    invoke-virtual {v4, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 121
    iget-object v4, p0, Lcom/android/mail/browse/ConversationListFooterView;->mLoading:Landroid/view/View;

    invoke-virtual {v4, v6}, Landroid/view/View;->setVisibility(I)V

    .line 122
    iget-object v4, p0, Lcom/android/mail/browse/ConversationListFooterView;->mLoadMore:Landroid/view/View;

    invoke-virtual {v4, v6}, Landroid/view/View;->setVisibility(I)V

    .line 125
    iget-object v4, p0, Lcom/android/mail/browse/ConversationListFooterView;->mErrorActionButton:Landroid/widget/Button;

    iget v7, p0, Lcom/android/mail/browse/ConversationListFooterView;->mErrorStatus:I

    const/4 v8, 0x3

    if-eq v7, v8, :cond_3

    :goto_3
    invoke-virtual {v4, v5}, Landroid/widget/Button;->setVisibility(I)V

    .line 130
    iget v4, p0, Lcom/android/mail/browse/ConversationListFooterView;->mErrorStatus:I

    packed-switch v4, :pswitch_data_0

    .line 148
    const v0, 0x7f0c0001

    .line 149
    .local v0, "actionTextResourceId":I
    iget-object v4, p0, Lcom/android/mail/browse/ConversationListFooterView;->mNetworkError:Landroid/view/View;

    invoke-virtual {v4, v6}, Landroid/view/View;->setVisibility(I)V

    .line 152
    :goto_4
    iget-object v4, p0, Lcom/android/mail/browse/ConversationListFooterView;->mErrorActionButton:Landroid/widget/Button;

    invoke-virtual {v4, v0}, Landroid/widget/Button;->setText(I)V

    goto :goto_2

    .end local v0    # "actionTextResourceId":I
    :cond_3
    move v5, v6

    .line 125
    goto :goto_3

    .line 132
    :pswitch_0
    const v0, 0x7f0c0001

    .line 133
    .restart local v0    # "actionTextResourceId":I
    goto :goto_4

    .line 135
    .end local v0    # "actionTextResourceId":I
    :pswitch_1
    const v0, 0x7f0c00f5

    .line 136
    .restart local v0    # "actionTextResourceId":I
    goto :goto_4

    .line 138
    .end local v0    # "actionTextResourceId":I
    :pswitch_2
    const v0, 0x7f0c0001

    .line 139
    .restart local v0    # "actionTextResourceId":I
    iget-object v4, p0, Lcom/android/mail/browse/ConversationListFooterView;->mNetworkError:Landroid/view/View;

    invoke-virtual {v4, v6}, Landroid/view/View;->setVisibility(I)V

    goto :goto_4

    .line 142
    .end local v0    # "actionTextResourceId":I
    :pswitch_3
    const v0, 0x7f0c00f6

    .line 143
    .restart local v0    # "actionTextResourceId":I
    goto :goto_4

    .line 145
    .end local v0    # "actionTextResourceId":I
    :pswitch_4
    const v0, 0x7f0c00f7

    .line 146
    .restart local v0    # "actionTextResourceId":I
    goto :goto_4

    .line 154
    .end local v0    # "actionTextResourceId":I
    :cond_4
    iget-object v4, p0, Lcom/android/mail/browse/ConversationListFooterView;->mLoadMoreUri:Landroid/net/Uri;

    if-eqz v4, :cond_5

    .line 155
    iget-object v4, p0, Lcom/android/mail/browse/ConversationListFooterView;->mLoading:Landroid/view/View;

    invoke-virtual {v4, v6}, Landroid/view/View;->setVisibility(I)V

    .line 156
    iget-object v4, p0, Lcom/android/mail/browse/ConversationListFooterView;->mNetworkError:Landroid/view/View;

    invoke-virtual {v4, v6}, Landroid/view/View;->setVisibility(I)V

    .line 157
    iget-object v4, p0, Lcom/android/mail/browse/ConversationListFooterView;->mLoadMore:Landroid/view/View;

    invoke-virtual {v4, v5}, Landroid/view/View;->setVisibility(I)V

    goto :goto_2

    .line 159
    :cond_5
    const/4 v3, 0x0

    goto :goto_2

    .line 130
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method
