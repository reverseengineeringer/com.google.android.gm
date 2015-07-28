.class public Lcom/android/mail/browse/MessageInviteView;
.super Landroid/widget/LinearLayout;
.source "MessageInviteView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/browse/MessageInviteView$InviteCommandHandler;
    }
.end annotation


# instance fields
.field private mCommandHandler:Lcom/android/mail/browse/MessageInviteView$InviteCommandHandler;

.field private final mContext:Landroid/content/Context;

.field private mMessage:Lcom/android/mail/providers/Message;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "c"    # Landroid/content/Context;

    .prologue
    .line 41
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/android/mail/browse/MessageInviteView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 42
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "c"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 45
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 38
    new-instance v0, Lcom/android/mail/browse/MessageInviteView$InviteCommandHandler;

    invoke-direct {v0, p0}, Lcom/android/mail/browse/MessageInviteView$InviteCommandHandler;-><init>(Lcom/android/mail/browse/MessageInviteView;)V

    iput-object v0, p0, Lcom/android/mail/browse/MessageInviteView;->mCommandHandler:Lcom/android/mail/browse/MessageInviteView$InviteCommandHandler;

    .line 46
    iput-object p1, p0, Lcom/android/mail/browse/MessageInviteView;->mContext:Landroid/content/Context;

    .line 47
    return-void
.end method

.method static synthetic access$000(Lcom/android/mail/browse/MessageInviteView;)Lcom/android/mail/providers/Message;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/browse/MessageInviteView;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/android/mail/browse/MessageInviteView;->mMessage:Lcom/android/mail/providers/Message;

    return-object v0
.end method


# virtual methods
.method public bind(Lcom/android/mail/providers/Message;)V
    .locals 0
    .param p1, "message"    # Lcom/android/mail/providers/Message;

    .prologue
    .line 60
    iput-object p1, p0, Lcom/android/mail/browse/MessageInviteView;->mMessage:Lcom/android/mail/providers/Message;

    .line 61
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 7
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v5, 0x1

    .line 65
    const/4 v0, 0x0

    .line 67
    .local v0, "command":Ljava/lang/Integer;
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v3

    packed-switch v3, :pswitch_data_0

    .line 86
    :cond_0
    :goto_0
    if-eqz v0, :cond_1

    .line 87
    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    .line 88
    .local v2, "params":Landroid/content/ContentValues;
    const-string v3, "UnifiedEmail"

    const-string v4, "SENDING INVITE COMMAND, VALUE=%s"

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object v0, v5, v6

    invoke-static {v3, v4, v5}, Lcom/android/mail/utils/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 89
    const-string v3, "respond"

    invoke-virtual {v2, v3, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 90
    iget-object v3, p0, Lcom/android/mail/browse/MessageInviteView;->mCommandHandler:Lcom/android/mail/browse/MessageInviteView$InviteCommandHandler;

    invoke-virtual {v3, v2}, Lcom/android/mail/browse/MessageInviteView$InviteCommandHandler;->sendCommand(Landroid/content/ContentValues;)V

    .line 92
    .end local v2    # "params":Landroid/content/ContentValues;
    :cond_1
    return-void

    .line 69
    :pswitch_0
    iget-object v3, p0, Lcom/android/mail/browse/MessageInviteView;->mMessage:Lcom/android/mail/providers/Message;

    iget-object v3, v3, Lcom/android/mail/providers/Message;->eventIntentUri:Landroid/net/Uri;

    invoke-static {v3}, Lcom/android/mail/utils/Utils;->isEmpty(Landroid/net/Uri;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 70
    new-instance v1, Landroid/content/Intent;

    const-string v3, "android.intent.action.VIEW"

    invoke-direct {v1, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 71
    .local v1, "intent":Landroid/content/Intent;
    iget-object v3, p0, Lcom/android/mail/browse/MessageInviteView;->mMessage:Lcom/android/mail/providers/Message;

    iget-object v3, v3, Lcom/android/mail/providers/Message;->eventIntentUri:Landroid/net/Uri;

    invoke-virtual {v1, v3}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 72
    iget-object v3, p0, Lcom/android/mail/browse/MessageInviteView;->mContext:Landroid/content/Context;

    invoke-virtual {v3, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 76
    .end local v1    # "intent":Landroid/content/Intent;
    :pswitch_1
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    .line 77
    goto :goto_0

    .line 79
    :pswitch_2
    const/4 v3, 0x2

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    .line 80
    goto :goto_0

    .line 82
    :pswitch_3
    const/4 v3, 0x3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    goto :goto_0

    .line 67
    :pswitch_data_0
    .packed-switch 0x7f10008f
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method protected onFinishInflate()V
    .locals 1

    .prologue
    .line 51
    invoke-super {p0}, Landroid/widget/LinearLayout;->onFinishInflate()V

    .line 53
    const v0, 0x7f10008f

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageInviteView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 54
    const v0, 0x7f100090

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageInviteView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 55
    const v0, 0x7f100091

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageInviteView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 56
    const v0, 0x7f100092

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageInviteView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 57
    return-void
.end method
