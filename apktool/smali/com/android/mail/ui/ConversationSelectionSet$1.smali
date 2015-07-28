.class final Lcom/android/mail/ui/ConversationSelectionSet$1;
.super Ljava/lang/Object;
.source "ConversationSelectionSet.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/ConversationSelectionSet;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable$Creator",
        "<",
        "Lcom/android/mail/ui/ConversationSelectionSet;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 50
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Lcom/android/mail/ui/ConversationSelectionSet;
    .locals 9
    .param p1, "source"    # Landroid/os/Parcel;

    .prologue
    .line 54
    new-instance v6, Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-direct {v6}, Lcom/android/mail/ui/ConversationSelectionSet;-><init>()V

    .line 55
    .local v6, "result":Lcom/android/mail/ui/ConversationSelectionSet;
    const-class v7, Lcom/android/mail/providers/Conversation;

    invoke-virtual {v7}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v7

    invoke-virtual {p1, v7}, Landroid/os/Parcel;->readParcelableArray(Ljava/lang/ClassLoader;)[Landroid/os/Parcelable;

    move-result-object v2

    .line 57
    .local v2, "conversations":[Landroid/os/Parcelable;
    move-object v0, v2

    .local v0, "arr$":[Landroid/os/Parcelable;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v4, :cond_0

    aget-object v5, v0, v3

    .local v5, "parceled":Landroid/os/Parcelable;
    move-object v1, v5

    .line 58
    check-cast v1, Lcom/android/mail/providers/Conversation;

    .line 59
    .local v1, "conversation":Lcom/android/mail/providers/Conversation;
    iget-wide v7, v1, Lcom/android/mail/providers/Conversation;->id:J

    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    # invokes: Lcom/android/mail/ui/ConversationSelectionSet;->put(Ljava/lang/Long;Lcom/android/mail/providers/Conversation;)V
    invoke-static {v6, v7, v1}, Lcom/android/mail/ui/ConversationSelectionSet;->access$000(Lcom/android/mail/ui/ConversationSelectionSet;Ljava/lang/Long;Lcom/android/mail/providers/Conversation;)V

    .line 57
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 61
    .end local v1    # "conversation":Lcom/android/mail/providers/Conversation;
    .end local v5    # "parceled":Landroid/os/Parcelable;
    :cond_0
    return-object v6
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Landroid/os/Parcel;

    .prologue
    .line 50
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/ConversationSelectionSet$1;->createFromParcel(Landroid/os/Parcel;)Lcom/android/mail/ui/ConversationSelectionSet;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Lcom/android/mail/ui/ConversationSelectionSet;
    .locals 1
    .param p1, "size"    # I

    .prologue
    .line 66
    new-array v0, p1, [Lcom/android/mail/ui/ConversationSelectionSet;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 50
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/ConversationSelectionSet$1;->newArray(I)[Lcom/android/mail/ui/ConversationSelectionSet;

    move-result-object v0

    return-object v0
.end method
