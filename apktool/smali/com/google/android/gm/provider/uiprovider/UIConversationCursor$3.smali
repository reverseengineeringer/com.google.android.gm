.class final Lcom/google/android/gm/provider/uiprovider/UIConversationCursor$3;
.super Ljava/lang/Object;
.source "UIConversationCursor.java"

# interfaces
.implements Lcom/google/android/gm/provider/ObjectCache$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/google/android/gm/provider/ObjectCache$Callback",
        "<",
        "Lcom/android/mail/providers/MessageInfo;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 109
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public newInstance()Lcom/android/mail/providers/MessageInfo;
    .locals 1

    .prologue
    .line 112
    new-instance v0, Lcom/android/mail/providers/MessageInfo;

    invoke-direct {v0}, Lcom/android/mail/providers/MessageInfo;-><init>()V

    return-object v0
.end method

.method public bridge synthetic newInstance()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 109
    invoke-virtual {p0}, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor$3;->newInstance()Lcom/android/mail/providers/MessageInfo;

    move-result-object v0

    return-object v0
.end method

.method public onObjectReleased(Lcom/android/mail/providers/MessageInfo;)V
    .locals 2
    .param p1, "object"    # Lcom/android/mail/providers/MessageInfo;

    .prologue
    const/4 v1, 0x0

    .line 116
    const/4 v0, 0x0

    invoke-virtual {p1, v1, v1, v0, v1}, Lcom/android/mail/providers/MessageInfo;->set(ZZLjava/lang/String;I)V

    .line 117
    return-void
.end method

.method public bridge synthetic onObjectReleased(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 109
    check-cast p1, Lcom/android/mail/providers/MessageInfo;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor$3;->onObjectReleased(Lcom/android/mail/providers/MessageInfo;)V

    return-void
.end method
