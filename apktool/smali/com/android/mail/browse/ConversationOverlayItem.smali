.class public abstract Lcom/android/mail/browse/ConversationOverlayItem;
.super Ljava/lang/Object;
.source "ConversationOverlayItem.java"


# instance fields
.field private mHeight:I

.field private mNeedsMeasure:Z

.field private mTop:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 32
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public belongsToMessage(Lcom/android/mail/browse/MessageCursor$ConversationMessage;)Z
    .locals 1
    .param p1, "message"    # Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    .prologue
    .line 127
    const/4 v0, 0x0

    return v0
.end method

.method public abstract bindView(Landroid/view/View;Z)V
.end method

.method public canBecomeSnapHeader()Z
    .locals 1

    .prologue
    .line 119
    const/4 v0, 0x0

    return v0
.end method

.method public canPushSnapHeader()Z
    .locals 1

    .prologue
    .line 123
    const/4 v0, 0x0

    return v0
.end method

.method public abstract createView(Landroid/content/Context;Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroid/view/View;
.end method

.method public getGravity()I
    .locals 1

    .prologue
    .line 65
    const/16 v0, 0x50

    return v0
.end method

.method public getHeight()I
    .locals 1

    .prologue
    .line 79
    iget v0, p0, Lcom/android/mail/browse/ConversationOverlayItem;->mHeight:I

    return v0
.end method

.method public getTop()I
    .locals 1

    .prologue
    .line 99
    iget v0, p0, Lcom/android/mail/browse/ConversationOverlayItem;->mTop:I

    return v0
.end method

.method public abstract getType()I
.end method

.method public invalidateMeasurement()V
    .locals 1

    .prologue
    .line 115
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/mail/browse/ConversationOverlayItem;->mNeedsMeasure:Z

    .line 116
    return-void
.end method

.method public abstract isContiguous()Z
.end method

.method public isMeasurementValid()Z
    .locals 1

    .prologue
    .line 107
    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationOverlayItem;->mNeedsMeasure:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public markMeasurementValid()V
    .locals 1

    .prologue
    .line 111
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/mail/browse/ConversationOverlayItem;->mNeedsMeasure:Z

    .line 112
    return-void
.end method

.method public onModelUpdated(Landroid/view/View;)V
    .locals 0
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 139
    return-void
.end method

.method public setHeight(I)Z
    .locals 6
    .param p1, "h"    # I

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x1

    .line 89
    const-string v2, "ConvLayout"

    const-string v3, "IN setHeight=%dpx of overlay item: %s"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v1

    aput-object p0, v4, v0

    invoke-static {v2, v3, v4}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 90
    iget v2, p0, Lcom/android/mail/browse/ConversationOverlayItem;->mHeight:I

    if-eq v2, p1, :cond_0

    .line 91
    iput p1, p0, Lcom/android/mail/browse/ConversationOverlayItem;->mHeight:I

    .line 92
    iput-boolean v0, p0, Lcom/android/mail/browse/ConversationOverlayItem;->mNeedsMeasure:Z

    .line 95
    :goto_0
    return v0

    :cond_0
    move v0, v1

    goto :goto_0
.end method

.method public setMessage(Lcom/android/mail/browse/MessageCursor$ConversationMessage;)V
    .locals 0
    .param p1, "message"    # Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    .prologue
    .line 131
    return-void
.end method

.method public setTop(I)V
    .locals 0
    .param p1, "top"    # I

    .prologue
    .line 103
    iput p1, p0, Lcom/android/mail/browse/ConversationOverlayItem;->mTop:I

    .line 104
    return-void
.end method
