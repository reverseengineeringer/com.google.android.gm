.class public final Lcom/android/mail/ui/ConversationViewState$ExpansionState;
.super Ljava/lang/Object;
.source "ConversationViewState.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/ConversationViewState;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "ExpansionState"
.end annotation


# static fields
.field public static COLLAPSED:I

.field public static EXPANDED:I

.field public static SUPER_COLLAPSED:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 47
    const/4 v0, 0x1

    sput v0, Lcom/android/mail/ui/ConversationViewState$ExpansionState;->EXPANDED:I

    .line 48
    const/4 v0, 0x2

    sput v0, Lcom/android/mail/ui/ConversationViewState$ExpansionState;->COLLAPSED:I

    .line 49
    const/4 v0, 0x3

    sput v0, Lcom/android/mail/ui/ConversationViewState$ExpansionState;->SUPER_COLLAPSED:I

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 51
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static isExpanded(I)Z
    .locals 1
    .param p0, "state"    # I

    .prologue
    .line 54
    sget v0, Lcom/android/mail/ui/ConversationViewState$ExpansionState;->EXPANDED:I

    if-ne p0, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isSuperCollapsed(I)Z
    .locals 1
    .param p0, "state"    # I

    .prologue
    .line 57
    sget v0, Lcom/android/mail/ui/ConversationViewState$ExpansionState;->SUPER_COLLAPSED:I

    if-ne p0, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
